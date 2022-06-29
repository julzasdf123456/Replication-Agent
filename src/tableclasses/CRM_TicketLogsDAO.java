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
public class CRM_TicketLogsDAO { 
	public static void insert(CRM_TicketLogs cRM_TicketLogs, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_TicketLogs(id, TicketId, Log, LogDetails, LogType, UserId, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_TicketLogs.getid());
		ps.setString(2, cRM_TicketLogs.getTicketId());
		ps.setString(3, cRM_TicketLogs.getLog());
		ps.setString(4, cRM_TicketLogs.getLogDetails());
		ps.setString(5, cRM_TicketLogs.getLogType());
		ps.setString(6, cRM_TicketLogs.getUserId());
		ps.setString(7, cRM_TicketLogs.getcreated_at());
		ps.setString(8, cRM_TicketLogs.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_TicketLogs cRM_TicketLogs, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_TicketLogs SET TicketId=?, Log=?, LogDetails=?, LogType=?, UserId=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_TicketLogs.getTicketId());
		ps.setString(2, cRM_TicketLogs.getLog());
		ps.setString(3, cRM_TicketLogs.getLogDetails());
		ps.setString(4, cRM_TicketLogs.getLogType());
		ps.setString(5, cRM_TicketLogs.getUserId());
		ps.setString(6, cRM_TicketLogs.getcreated_at());
		ps.setString(7, cRM_TicketLogs.getupdated_at());
		ps.setString(8, cRM_TicketLogs.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_TicketLogs getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_TicketLogs WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_TicketLogs cRM_TicketLogs = new CRM_TicketLogs(
			rs.getString("id"),
			rs.getString("TicketId"),
			rs.getString("Log"),
			rs.getString("LogDetails"),
			rs.getString("LogType"),
			rs.getString("UserId"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_TicketLogs;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_TicketLogs> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_TicketLogs WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_TicketLogs> cRM_TicketLogsList = new ArrayList<>();
		while(rs.next()) {
			CRM_TicketLogs cRM_TicketLogs = new CRM_TicketLogs();
			cRM_TicketLogs.setid(rs.getString("id"));
			cRM_TicketLogs.setTicketId(rs.getString("TicketId"));
			cRM_TicketLogs.setLog(rs.getString("Log"));
			cRM_TicketLogs.setLogDetails(rs.getString("LogDetails"));
			cRM_TicketLogs.setLogType(rs.getString("LogType"));
			cRM_TicketLogs.setUserId(rs.getString("UserId"));
			cRM_TicketLogs.setcreated_at(rs.getString("created_at"));
			cRM_TicketLogs.setupdated_at(rs.getString("updated_at"));
			cRM_TicketLogsList.add(cRM_TicketLogs);
		}
		rs.close();
		ps.close();
		return cRM_TicketLogsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_TicketLogs> billing_Billses = CRM_TicketLogsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_TicketLogs to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_TicketLogs bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_TicketLogs bill = CRM_TicketLogsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_TicketLogs has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_TicketLogsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_TicketLogs updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_TicketLogsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_TicketLogs inserted";
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
