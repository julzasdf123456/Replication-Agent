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
public class CRM_MemberConsumerChecklistsDAO { 
	public static void insert(CRM_MemberConsumerChecklists cRM_MemberConsumerChecklists, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_MemberConsumerChecklists(id, MemberConsumerId, ChecklistId, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_MemberConsumerChecklists.getid());
		ps.setString(2, cRM_MemberConsumerChecklists.getMemberConsumerId());
		ps.setString(3, cRM_MemberConsumerChecklists.getChecklistId());
		ps.setString(4, cRM_MemberConsumerChecklists.getNotes());
		ps.setString(5, cRM_MemberConsumerChecklists.getcreated_at());
		ps.setString(6, cRM_MemberConsumerChecklists.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_MemberConsumerChecklists cRM_MemberConsumerChecklists, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_MemberConsumerChecklists SET MemberConsumerId=?, ChecklistId=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_MemberConsumerChecklists.getMemberConsumerId());
		ps.setString(2, cRM_MemberConsumerChecklists.getChecklistId());
		ps.setString(3, cRM_MemberConsumerChecklists.getNotes());
		ps.setString(4, cRM_MemberConsumerChecklists.getcreated_at());
		ps.setString(5, cRM_MemberConsumerChecklists.getupdated_at());
		ps.setString(6, cRM_MemberConsumerChecklists.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_MemberConsumerChecklists getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumerChecklists WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_MemberConsumerChecklists cRM_MemberConsumerChecklists = new CRM_MemberConsumerChecklists(
			rs.getString("id"),
			rs.getString("MemberConsumerId"),
			rs.getString("ChecklistId"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_MemberConsumerChecklists;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_MemberConsumerChecklists> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumerChecklists WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_MemberConsumerChecklists> cRM_MemberConsumerChecklistsList = new ArrayList<>();
		while(rs.next()) {
			CRM_MemberConsumerChecklists cRM_MemberConsumerChecklists = new CRM_MemberConsumerChecklists();
			cRM_MemberConsumerChecklists.setid(rs.getString("id"));
			cRM_MemberConsumerChecklists.setMemberConsumerId(rs.getString("MemberConsumerId"));
			cRM_MemberConsumerChecklists.setChecklistId(rs.getString("ChecklistId"));
			cRM_MemberConsumerChecklists.setNotes(rs.getString("Notes"));
			cRM_MemberConsumerChecklists.setcreated_at(rs.getString("created_at"));
			cRM_MemberConsumerChecklists.setupdated_at(rs.getString("updated_at"));
			cRM_MemberConsumerChecklistsList.add(cRM_MemberConsumerChecklists);
		}
		rs.close();
		ps.close();
		return cRM_MemberConsumerChecklistsList;
	}
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_MemberConsumerChecklists> billing_Billses = CRM_MemberConsumerChecklistsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_MemberConsumerChecklists to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_MemberConsumerChecklists bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_MemberConsumerChecklists bill = CRM_MemberConsumerChecklistsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_MemberConsumerChecklists has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_MemberConsumerChecklistsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_MemberConsumerChecklists updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_MemberConsumerChecklistsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_MemberConsumerChecklists inserted";
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
