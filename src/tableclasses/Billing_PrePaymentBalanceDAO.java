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
public class Billing_PrePaymentBalanceDAO { 
	public static void insert(Billing_PrePaymentBalance billing_PrePaymentBalance, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_PrePaymentBalance(id, AccountNumber, Balance, Status, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_PrePaymentBalance.getid());
		ps.setString(2, billing_PrePaymentBalance.getAccountNumber());
		ps.setString(3, billing_PrePaymentBalance.getBalance());
		ps.setString(4, billing_PrePaymentBalance.getStatus());
		ps.setString(5, billing_PrePaymentBalance.getcreated_at());
		ps.setString(6, billing_PrePaymentBalance.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_PrePaymentBalance billing_PrePaymentBalance, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_PrePaymentBalance SET AccountNumber=?, Balance=?, Status=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, billing_PrePaymentBalance.getAccountNumber());
		ps.setString(2, billing_PrePaymentBalance.getBalance());
		ps.setString(3, billing_PrePaymentBalance.getStatus());
		ps.setString(4, billing_PrePaymentBalance.getcreated_at());
		ps.setString(5, billing_PrePaymentBalance.getupdated_at());
		ps.setString(6, billing_PrePaymentBalance.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_PrePaymentBalance getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_PrePaymentBalance WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_PrePaymentBalance billing_PrePaymentBalance = new Billing_PrePaymentBalance(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("Balance"),
			rs.getString("Status"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return billing_PrePaymentBalance;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_PrePaymentBalance> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_PrePaymentBalance WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_PrePaymentBalance> billing_PrePaymentBalanceList = new ArrayList<>();
		while(rs.next()) {
			Billing_PrePaymentBalance billing_PrePaymentBalance = new Billing_PrePaymentBalance();
			billing_PrePaymentBalance.setid(rs.getString("id"));
			billing_PrePaymentBalance.setAccountNumber(rs.getString("AccountNumber"));
			billing_PrePaymentBalance.setBalance(rs.getString("Balance"));
			billing_PrePaymentBalance.setStatus(rs.getString("Status"));
			billing_PrePaymentBalance.setcreated_at(rs.getString("created_at"));
			billing_PrePaymentBalance.setupdated_at(rs.getString("updated_at"));
			billing_PrePaymentBalanceList.add(billing_PrePaymentBalance);
		}
		rs.close();
		ps.close();
		return billing_PrePaymentBalanceList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_PrePaymentBalance> billing_Billses = Billing_PrePaymentBalanceDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_PrePaymentBalance to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_PrePaymentBalance bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_PrePaymentBalance bill = Billing_PrePaymentBalanceDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_PrePaymentBalance has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_PrePaymentBalanceDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_PrePaymentBalance updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_PrePaymentBalanceDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_PrePaymentBalance inserted";
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
