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
public class Billing_PrePaymentTransactionHistoryDAO { 
	public static void insert(Billing_PrePaymentTransactionHistory billing_PrePaymentTransactionHistory, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_PrePaymentTransactionHistory(id, AccountNumber, Method, Amount, UserId, Notes, created_at, updated_at, ORNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_PrePaymentTransactionHistory.getid());
		ps.setString(2, billing_PrePaymentTransactionHistory.getAccountNumber());
		ps.setString(3, billing_PrePaymentTransactionHistory.getMethod());
		ps.setString(4, billing_PrePaymentTransactionHistory.getAmount());
		ps.setString(5, billing_PrePaymentTransactionHistory.getUserId());
		ps.setString(6, billing_PrePaymentTransactionHistory.getNotes());
		ps.setString(7, billing_PrePaymentTransactionHistory.getcreated_at());
		ps.setString(8, billing_PrePaymentTransactionHistory.getupdated_at());
		ps.setString(9, billing_PrePaymentTransactionHistory.getORNumber());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_PrePaymentTransactionHistory billing_PrePaymentTransactionHistory, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_PrePaymentTransactionHistory SET AccountNumber=?, Method=?, Amount=?, UserId=?, Notes=?, created_at=?, updated_at=?, ORNumber=?  WHERE id=? ");
		ps.setString(1, billing_PrePaymentTransactionHistory.getAccountNumber());
		ps.setString(2, billing_PrePaymentTransactionHistory.getMethod());
		ps.setString(3, billing_PrePaymentTransactionHistory.getAmount());
		ps.setString(4, billing_PrePaymentTransactionHistory.getUserId());
		ps.setString(5, billing_PrePaymentTransactionHistory.getNotes());
		ps.setString(6, billing_PrePaymentTransactionHistory.getcreated_at());
		ps.setString(7, billing_PrePaymentTransactionHistory.getupdated_at());
		ps.setString(8, billing_PrePaymentTransactionHistory.getORNumber());
		ps.setString(9, billing_PrePaymentTransactionHistory.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_PrePaymentTransactionHistory getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_PrePaymentTransactionHistory WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_PrePaymentTransactionHistory billing_PrePaymentTransactionHistory = new Billing_PrePaymentTransactionHistory(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("Method"),
			rs.getString("Amount"),
			rs.getString("UserId"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("ORNumber")
			);
			ps.close();
			rs.close();
			return billing_PrePaymentTransactionHistory;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_PrePaymentTransactionHistory> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_PrePaymentTransactionHistory WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_PrePaymentTransactionHistory> billing_PrePaymentTransactionHistoryList = new ArrayList<>();
		while(rs.next()) {
			Billing_PrePaymentTransactionHistory billing_PrePaymentTransactionHistory = new Billing_PrePaymentTransactionHistory();
			billing_PrePaymentTransactionHistory.setid(rs.getString("id"));
			billing_PrePaymentTransactionHistory.setAccountNumber(rs.getString("AccountNumber"));
			billing_PrePaymentTransactionHistory.setMethod(rs.getString("Method"));
			billing_PrePaymentTransactionHistory.setAmount(rs.getString("Amount"));
			billing_PrePaymentTransactionHistory.setUserId(rs.getString("UserId"));
			billing_PrePaymentTransactionHistory.setNotes(rs.getString("Notes"));
			billing_PrePaymentTransactionHistory.setcreated_at(rs.getString("created_at"));
			billing_PrePaymentTransactionHistory.setupdated_at(rs.getString("updated_at"));
			billing_PrePaymentTransactionHistory.setORNumber(rs.getString("ORNumber"));
			billing_PrePaymentTransactionHistoryList.add(billing_PrePaymentTransactionHistory);
		}
		rs.close();
		ps.close();
		return billing_PrePaymentTransactionHistoryList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_PrePaymentTransactionHistory> billing_Billses = Billing_PrePaymentTransactionHistoryDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_PrePaymentTransactionHistory to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_PrePaymentTransactionHistory bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_PrePaymentTransactionHistory bill = Billing_PrePaymentTransactionHistoryDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_PrePaymentTransactionHistory has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_PrePaymentTransactionHistoryDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_PrePaymentTransactionHistory updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_PrePaymentTransactionHistoryDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_PrePaymentTransactionHistory inserted";
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
