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
public class CRM_ServiceConnectionTimeframesDAO { 
	public static void insert(CRM_ServiceConnectionTimeframes cRM_ServiceConnectionTimeframes, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionTimeframes(id, ServiceConnectionId, UserId, Status, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionTimeframes.getid());
		ps.setString(2, cRM_ServiceConnectionTimeframes.getServiceConnectionId());
		ps.setString(3, cRM_ServiceConnectionTimeframes.getUserId());
		ps.setString(4, cRM_ServiceConnectionTimeframes.getStatus());
		ps.setString(5, cRM_ServiceConnectionTimeframes.getNotes());
		ps.setString(6, cRM_ServiceConnectionTimeframes.getcreated_at());
		ps.setString(7, cRM_ServiceConnectionTimeframes.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionTimeframes cRM_ServiceConnectionTimeframes, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionTimeframes SET ServiceConnectionId=?, UserId=?, Status=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionTimeframes.getServiceConnectionId());
		ps.setString(2, cRM_ServiceConnectionTimeframes.getUserId());
		ps.setString(3, cRM_ServiceConnectionTimeframes.getStatus());
		ps.setString(4, cRM_ServiceConnectionTimeframes.getNotes());
		ps.setString(5, cRM_ServiceConnectionTimeframes.getcreated_at());
		ps.setString(6, cRM_ServiceConnectionTimeframes.getupdated_at());
		ps.setString(7, cRM_ServiceConnectionTimeframes.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionTimeframes getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionTimeframes WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionTimeframes cRM_ServiceConnectionTimeframes = new CRM_ServiceConnectionTimeframes(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("UserId"),
			rs.getString("Status"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionTimeframes;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionTimeframes> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionTimeframes WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionTimeframes> cRM_ServiceConnectionTimeframesList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionTimeframes cRM_ServiceConnectionTimeframes = new CRM_ServiceConnectionTimeframes();
			cRM_ServiceConnectionTimeframes.setid(rs.getString("id"));
			cRM_ServiceConnectionTimeframes.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_ServiceConnectionTimeframes.setUserId(rs.getString("UserId"));
			cRM_ServiceConnectionTimeframes.setStatus(rs.getString("Status"));
			cRM_ServiceConnectionTimeframes.setNotes(rs.getString("Notes"));
			cRM_ServiceConnectionTimeframes.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionTimeframes.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionTimeframesList.add(cRM_ServiceConnectionTimeframes);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionTimeframesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionTimeframes> billing_Billses = CRM_ServiceConnectionTimeframesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionTimeframes to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionTimeframes bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionTimeframes bill = CRM_ServiceConnectionTimeframesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionTimeframes has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionTimeframesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionTimeframes updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionTimeframesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionTimeframes inserted";
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
