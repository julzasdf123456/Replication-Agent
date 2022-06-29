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
public class Cashier_TransactionDetailsDAO { 
	public static void insert(Cashier_TransactionDetails cashier_TransactionDetails, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_TransactionDetails(id, TransactionIndexId, Particular, Amount, VAT, Total, created_at, updated_at, AccountCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_TransactionDetails.getid());
		ps.setString(2, cashier_TransactionDetails.getTransactionIndexId());
		ps.setString(3, cashier_TransactionDetails.getParticular());
		ps.setString(4, cashier_TransactionDetails.getAmount());
		ps.setString(5, cashier_TransactionDetails.getVAT());
		ps.setString(6, cashier_TransactionDetails.getTotal());
		ps.setString(7, cashier_TransactionDetails.getcreated_at());
		ps.setString(8, cashier_TransactionDetails.getupdated_at());
		ps.setString(9, cashier_TransactionDetails.getAccountCode());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_TransactionDetails cashier_TransactionDetails, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_TransactionDetails SET TransactionIndexId=?, Particular=?, Amount=?, VAT=?, Total=?, created_at=?, updated_at=?, AccountCode=?  WHERE id=? ");
		ps.setString(1, cashier_TransactionDetails.getTransactionIndexId());
		ps.setString(2, cashier_TransactionDetails.getParticular());
		ps.setString(3, cashier_TransactionDetails.getAmount());
		ps.setString(4, cashier_TransactionDetails.getVAT());
		ps.setString(5, cashier_TransactionDetails.getTotal());
		ps.setString(6, cashier_TransactionDetails.getcreated_at());
		ps.setString(7, cashier_TransactionDetails.getupdated_at());
		ps.setString(8, cashier_TransactionDetails.getAccountCode());
		ps.setString(9, cashier_TransactionDetails.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_TransactionDetails getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_TransactionDetails WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_TransactionDetails cashier_TransactionDetails = new Cashier_TransactionDetails(
			rs.getString("id"),
			rs.getString("TransactionIndexId"),
			rs.getString("Particular"),
			rs.getString("Amount"),
			rs.getString("VAT"),
			rs.getString("Total"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("AccountCode")
			);
			ps.close();
			rs.close();
			return cashier_TransactionDetails;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_TransactionDetails> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_TransactionDetails WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_TransactionDetails> cashier_TransactionDetailsList = new ArrayList<>();
		while(rs.next()) {
			Cashier_TransactionDetails cashier_TransactionDetails = new Cashier_TransactionDetails();
			cashier_TransactionDetails.setid(rs.getString("id"));
			cashier_TransactionDetails.setTransactionIndexId(rs.getString("TransactionIndexId"));
			cashier_TransactionDetails.setParticular(rs.getString("Particular"));
			cashier_TransactionDetails.setAmount(rs.getString("Amount"));
			cashier_TransactionDetails.setVAT(rs.getString("VAT"));
			cashier_TransactionDetails.setTotal(rs.getString("Total"));
			cashier_TransactionDetails.setcreated_at(rs.getString("created_at"));
			cashier_TransactionDetails.setupdated_at(rs.getString("updated_at"));
			cashier_TransactionDetails.setAccountCode(rs.getString("AccountCode"));
			cashier_TransactionDetailsList.add(cashier_TransactionDetails);
		}
		rs.close();
		ps.close();
		return cashier_TransactionDetailsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_TransactionDetails> billing_Billses = Cashier_TransactionDetailsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_TransactionDetails to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_TransactionDetails bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_TransactionDetails bill = Cashier_TransactionDetailsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_TransactionDetails has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_TransactionDetailsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_TransactionDetails updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_TransactionDetailsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_TransactionDetails inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
