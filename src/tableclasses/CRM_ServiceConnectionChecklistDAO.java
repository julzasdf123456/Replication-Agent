package tableclasses;

import db.DBConnection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import others.ObjectHelpers;
import replicationagent.MainFrame;
public class CRM_ServiceConnectionChecklistDAO { 
	public static void insert(CRM_ServiceConnectionChecklist cRM_ServiceConnectionChecklist, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionChecklist(id, ServiceConnectionId, ChecklistId, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionChecklist.getid());
		ps.setString(2, cRM_ServiceConnectionChecklist.getServiceConnectionId());
		ps.setString(3, cRM_ServiceConnectionChecklist.getChecklistId());
		ps.setString(4, cRM_ServiceConnectionChecklist.getNotes());
		ps.setString(5, cRM_ServiceConnectionChecklist.getcreated_at());
		ps.setString(6, cRM_ServiceConnectionChecklist.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionChecklist cRM_ServiceConnectionChecklist, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionChecklist SET ServiceConnectionId=?, ChecklistId=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionChecklist.getServiceConnectionId());
		ps.setString(2, cRM_ServiceConnectionChecklist.getChecklistId());
		ps.setString(3, cRM_ServiceConnectionChecklist.getNotes());
		ps.setString(4, cRM_ServiceConnectionChecklist.getcreated_at());
		ps.setString(5, cRM_ServiceConnectionChecklist.getupdated_at());
		ps.setString(6, cRM_ServiceConnectionChecklist.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionChecklist getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionChecklist WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionChecklist cRM_ServiceConnectionChecklist = new CRM_ServiceConnectionChecklist(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("ChecklistId"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionChecklist;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionChecklist> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionChecklist WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionChecklist> cRM_ServiceConnectionChecklistList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionChecklist cRM_ServiceConnectionChecklist = new CRM_ServiceConnectionChecklist();
			cRM_ServiceConnectionChecklist.setid(rs.getString("id"));
			cRM_ServiceConnectionChecklist.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_ServiceConnectionChecklist.setChecklistId(rs.getString("ChecklistId"));
			cRM_ServiceConnectionChecklist.setNotes(rs.getString("Notes"));
			cRM_ServiceConnectionChecklist.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionChecklist.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionChecklistList.add(cRM_ServiceConnectionChecklist);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionChecklistList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionChecklist> billing_Billses = CRM_ServiceConnectionChecklistDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionChecklist to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionChecklist bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionChecklist bill = CRM_ServiceConnectionChecklistDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionChecklist has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionChecklistDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionChecklist updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionChecklistDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionChecklist inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
