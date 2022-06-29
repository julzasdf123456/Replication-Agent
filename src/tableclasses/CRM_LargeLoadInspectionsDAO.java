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
public class CRM_LargeLoadInspectionsDAO { 
	public static void insert(CRM_LargeLoadInspections cRM_LargeLoadInspections, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_LargeLoadInspections(id, ServiceConnectionId, Assessment, DateOfInspection, Notes, created_at, updated_at, Options) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_LargeLoadInspections.getid());
		ps.setString(2, cRM_LargeLoadInspections.getServiceConnectionId());
		ps.setString(3, cRM_LargeLoadInspections.getAssessment());
		ps.setString(4, cRM_LargeLoadInspections.getDateOfInspection());
		ps.setString(5, cRM_LargeLoadInspections.getNotes());
		ps.setString(6, cRM_LargeLoadInspections.getcreated_at());
		ps.setString(7, cRM_LargeLoadInspections.getupdated_at());
		ps.setString(8, cRM_LargeLoadInspections.getOptions());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_LargeLoadInspections cRM_LargeLoadInspections, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_LargeLoadInspections SET ServiceConnectionId=?, Assessment=?, DateOfInspection=?, Notes=?, created_at=?, updated_at=?, Options=?  WHERE id=? ");
		ps.setString(1, cRM_LargeLoadInspections.getServiceConnectionId());
		ps.setString(2, cRM_LargeLoadInspections.getAssessment());
		ps.setString(3, cRM_LargeLoadInspections.getDateOfInspection());
		ps.setString(4, cRM_LargeLoadInspections.getNotes());
		ps.setString(5, cRM_LargeLoadInspections.getcreated_at());
		ps.setString(6, cRM_LargeLoadInspections.getupdated_at());
		ps.setString(7, cRM_LargeLoadInspections.getOptions());
		ps.setString(8, cRM_LargeLoadInspections.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_LargeLoadInspections getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_LargeLoadInspections WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_LargeLoadInspections cRM_LargeLoadInspections = new CRM_LargeLoadInspections(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("Assessment"),
			rs.getString("DateOfInspection"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Options")
			);
			ps.close();
			rs.close();
			return cRM_LargeLoadInspections;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_LargeLoadInspections> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_LargeLoadInspections WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_LargeLoadInspections> cRM_LargeLoadInspectionsList = new ArrayList<>();
		while(rs.next()) {
			CRM_LargeLoadInspections cRM_LargeLoadInspections = new CRM_LargeLoadInspections();
			cRM_LargeLoadInspections.setid(rs.getString("id"));
			cRM_LargeLoadInspections.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_LargeLoadInspections.setAssessment(rs.getString("Assessment"));
			cRM_LargeLoadInspections.setDateOfInspection(rs.getString("DateOfInspection"));
			cRM_LargeLoadInspections.setNotes(rs.getString("Notes"));
			cRM_LargeLoadInspections.setcreated_at(rs.getString("created_at"));
			cRM_LargeLoadInspections.setupdated_at(rs.getString("updated_at"));
			cRM_LargeLoadInspections.setOptions(rs.getString("Options"));
			cRM_LargeLoadInspectionsList.add(cRM_LargeLoadInspections);
		}
		rs.close();
		ps.close();
		return cRM_LargeLoadInspectionsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_LargeLoadInspections> billing_Billses = CRM_LargeLoadInspectionsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_LargeLoadInspections to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_LargeLoadInspections bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_LargeLoadInspections bill = CRM_LargeLoadInspectionsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_LargeLoadInspections has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_LargeLoadInspectionsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_LargeLoadInspections updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_LargeLoadInspectionsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_LargeLoadInspections inserted";
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
