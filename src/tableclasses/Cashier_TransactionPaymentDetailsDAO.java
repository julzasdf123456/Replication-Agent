package tableclasses;

import db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import others.ObjectHelpers;
import replicationagent.MainFrame;
public class Cashier_TransactionPaymentDetailsDAO { 
	public static void insert(Cashier_TransactionPaymentDetails cashier_TransactionPaymentDetails, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_TransactionPaymentDetails(id, TransactionIndexId, Amount, PaymentUsed, Bank, CheckNo, CheckExpiration, created_at, updated_at, ORNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_TransactionPaymentDetails.getid());
		ps.setString(2, cashier_TransactionPaymentDetails.getTransactionIndexId());
		ps.setString(3, cashier_TransactionPaymentDetails.getAmount());
		ps.setString(4, cashier_TransactionPaymentDetails.getPaymentUsed());
		ps.setString(5, cashier_TransactionPaymentDetails.getBank());
		ps.setString(6, cashier_TransactionPaymentDetails.getCheckNo());
		ps.setString(7, cashier_TransactionPaymentDetails.getCheckExpiration());
		ps.setString(8, cashier_TransactionPaymentDetails.getcreated_at());
		ps.setString(9, cashier_TransactionPaymentDetails.getupdated_at());
		ps.setString(10, cashier_TransactionPaymentDetails.getORNumber());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_TransactionPaymentDetails cashier_TransactionPaymentDetails, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_TransactionPaymentDetails SET TransactionIndexId=?, Amount=?, PaymentUsed=?, Bank=?, CheckNo=?, CheckExpiration=?, created_at=?, updated_at=?, ORNumber=?  WHERE id=? ");
		ps.setString(1, cashier_TransactionPaymentDetails.getTransactionIndexId());
		ps.setString(2, cashier_TransactionPaymentDetails.getAmount());
		ps.setString(3, cashier_TransactionPaymentDetails.getPaymentUsed());
		ps.setString(4, cashier_TransactionPaymentDetails.getBank());
		ps.setString(5, cashier_TransactionPaymentDetails.getCheckNo());
		ps.setString(6, cashier_TransactionPaymentDetails.getCheckExpiration());
		ps.setString(7, cashier_TransactionPaymentDetails.getcreated_at());
		ps.setString(8, cashier_TransactionPaymentDetails.getupdated_at());
		ps.setString(9, cashier_TransactionPaymentDetails.getORNumber());
		ps.setString(10, cashier_TransactionPaymentDetails.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_TransactionPaymentDetails getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_TransactionPaymentDetails WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_TransactionPaymentDetails cashier_TransactionPaymentDetails = new Cashier_TransactionPaymentDetails(
			rs.getString("id"),
			rs.getString("TransactionIndexId"),
			rs.getString("Amount"),
			rs.getString("PaymentUsed"),
			rs.getString("Bank"),
			rs.getString("CheckNo"),
			rs.getString("CheckExpiration"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("ORNumber")
			);
			ps.close();
			rs.close();
			return cashier_TransactionPaymentDetails;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_TransactionPaymentDetails> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_TransactionPaymentDetails WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_TransactionPaymentDetails> cashier_TransactionPaymentDetailsList = new ArrayList<>();
		while(rs.next()) {
			Cashier_TransactionPaymentDetails cashier_TransactionPaymentDetails = new Cashier_TransactionPaymentDetails();
			cashier_TransactionPaymentDetails.setid(rs.getString("id"));
			cashier_TransactionPaymentDetails.setTransactionIndexId(rs.getString("TransactionIndexId"));
			cashier_TransactionPaymentDetails.setAmount(rs.getString("Amount"));
			cashier_TransactionPaymentDetails.setPaymentUsed(rs.getString("PaymentUsed"));
			cashier_TransactionPaymentDetails.setBank(rs.getString("Bank"));
			cashier_TransactionPaymentDetails.setCheckNo(rs.getString("CheckNo"));
			cashier_TransactionPaymentDetails.setCheckExpiration(rs.getString("CheckExpiration"));
			cashier_TransactionPaymentDetails.setcreated_at(rs.getString("created_at"));
			cashier_TransactionPaymentDetails.setupdated_at(rs.getString("updated_at"));
			cashier_TransactionPaymentDetails.setORNumber(rs.getString("ORNumber"));
			cashier_TransactionPaymentDetailsList.add(cashier_TransactionPaymentDetails);
		}
		rs.close();
		ps.close();
		return cashier_TransactionPaymentDetailsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_TransactionPaymentDetails> billing_Billses = Cashier_TransactionPaymentDetailsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_TransactionPaymentDetails to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_TransactionPaymentDetails bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_TransactionPaymentDetails bill = Cashier_TransactionPaymentDetailsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_TransactionPaymentDetails has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_TransactionPaymentDetailsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_TransactionPaymentDetails updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_TransactionPaymentDetailsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_TransactionPaymentDetails inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
