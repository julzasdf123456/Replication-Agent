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
public class Billing_AccountNameHistoryDAO { 
	public static void insert(Billing_AccountNameHistory billing_AccountNameHistory, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_AccountNameHistory(id, AccountNumber, OldAccountName, Notes, UserId, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_AccountNameHistory.getid());
		ps.setString(2, billing_AccountNameHistory.getAccountNumber());
		ps.setString(3, billing_AccountNameHistory.getOldAccountName());
		ps.setString(4, billing_AccountNameHistory.getNotes());
		ps.setString(5, billing_AccountNameHistory.getUserId());
		ps.setString(6, billing_AccountNameHistory.getcreated_at());
		ps.setString(7, billing_AccountNameHistory.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_AccountNameHistory billing_AccountNameHistory, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_AccountNameHistory SET AccountNumber=?, OldAccountName=?, Notes=?, UserId=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, billing_AccountNameHistory.getAccountNumber());
		ps.setString(2, billing_AccountNameHistory.getOldAccountName());
		ps.setString(3, billing_AccountNameHistory.getNotes());
		ps.setString(4, billing_AccountNameHistory.getUserId());
		ps.setString(5, billing_AccountNameHistory.getcreated_at());
		ps.setString(6, billing_AccountNameHistory.getupdated_at());
		ps.setString(7, billing_AccountNameHistory.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_AccountNameHistory getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_AccountNameHistory WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_AccountNameHistory billing_AccountNameHistory = new Billing_AccountNameHistory(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("OldAccountName"),
			rs.getString("Notes"),
			rs.getString("UserId"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return billing_AccountNameHistory;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_AccountNameHistory> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_AccountNameHistory WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_AccountNameHistory> billing_AccountNameHistoryList = new ArrayList<>();
		while(rs.next()) {
			Billing_AccountNameHistory billing_AccountNameHistory = new Billing_AccountNameHistory();
			billing_AccountNameHistory.setid(rs.getString("id"));
			billing_AccountNameHistory.setAccountNumber(rs.getString("AccountNumber"));
			billing_AccountNameHistory.setOldAccountName(rs.getString("OldAccountName"));
			billing_AccountNameHistory.setNotes(rs.getString("Notes"));
			billing_AccountNameHistory.setUserId(rs.getString("UserId"));
			billing_AccountNameHistory.setcreated_at(rs.getString("created_at"));
			billing_AccountNameHistory.setupdated_at(rs.getString("updated_at"));
			billing_AccountNameHistoryList.add(billing_AccountNameHistory);
		}
		rs.close();
		ps.close();
		return billing_AccountNameHistoryList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_AccountNameHistory> billing_Billses = Billing_AccountNameHistoryDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_AccountNameHistory to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_AccountNameHistory bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_AccountNameHistory bill = Billing_AccountNameHistoryDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_AccountNameHistory has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_AccountNameHistoryDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_AccountNameHistory updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_AccountNameHistoryDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_AccountNameHistory inserted";
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
