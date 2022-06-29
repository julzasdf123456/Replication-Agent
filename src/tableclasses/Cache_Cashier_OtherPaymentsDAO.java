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
public class Cache_Cashier_OtherPaymentsDAO { 
	public static void insert(Cache_Cashier_OtherPayments cache_Cashier_OtherPayments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cache_Cashier_OtherPayments(id, AccountNumber, TransactionIndexId, Particular, Amount, VAT, Total, AccountCode, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cache_Cashier_OtherPayments.getid());
		ps.setString(2, cache_Cashier_OtherPayments.getAccountNumber());
		ps.setString(3, cache_Cashier_OtherPayments.getTransactionIndexId());
		ps.setString(4, cache_Cashier_OtherPayments.getParticular());
		ps.setString(5, cache_Cashier_OtherPayments.getAmount());
		ps.setString(6, cache_Cashier_OtherPayments.getVAT());
		ps.setString(7, cache_Cashier_OtherPayments.getTotal());
		ps.setString(8, cache_Cashier_OtherPayments.getAccountCode());
		ps.setString(9, cache_Cashier_OtherPayments.getcreated_at());
		ps.setString(10, cache_Cashier_OtherPayments.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cache_Cashier_OtherPayments cache_Cashier_OtherPayments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cache_Cashier_OtherPayments SET AccountNumber=?, TransactionIndexId=?, Particular=?, Amount=?, VAT=?, Total=?, AccountCode=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cache_Cashier_OtherPayments.getAccountNumber());
		ps.setString(2, cache_Cashier_OtherPayments.getTransactionIndexId());
		ps.setString(3, cache_Cashier_OtherPayments.getParticular());
		ps.setString(4, cache_Cashier_OtherPayments.getAmount());
		ps.setString(5, cache_Cashier_OtherPayments.getVAT());
		ps.setString(6, cache_Cashier_OtherPayments.getTotal());
		ps.setString(7, cache_Cashier_OtherPayments.getAccountCode());
		ps.setString(8, cache_Cashier_OtherPayments.getcreated_at());
		ps.setString(9, cache_Cashier_OtherPayments.getupdated_at());
		ps.setString(10, cache_Cashier_OtherPayments.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cache_Cashier_OtherPayments getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cache_Cashier_OtherPayments WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cache_Cashier_OtherPayments cache_Cashier_OtherPayments = new Cache_Cashier_OtherPayments(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("TransactionIndexId"),
			rs.getString("Particular"),
			rs.getString("Amount"),
			rs.getString("VAT"),
			rs.getString("Total"),
			rs.getString("AccountCode"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cache_Cashier_OtherPayments;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cache_Cashier_OtherPayments> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cache_Cashier_OtherPayments WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cache_Cashier_OtherPayments> cache_Cashier_OtherPaymentsList = new ArrayList<>();
		while(rs.next()) {
			Cache_Cashier_OtherPayments cache_Cashier_OtherPayments = new Cache_Cashier_OtherPayments();
			cache_Cashier_OtherPayments.setid(rs.getString("id"));
			cache_Cashier_OtherPayments.setAccountNumber(rs.getString("AccountNumber"));
			cache_Cashier_OtherPayments.setTransactionIndexId(rs.getString("TransactionIndexId"));
			cache_Cashier_OtherPayments.setParticular(rs.getString("Particular"));
			cache_Cashier_OtherPayments.setAmount(rs.getString("Amount"));
			cache_Cashier_OtherPayments.setVAT(rs.getString("VAT"));
			cache_Cashier_OtherPayments.setTotal(rs.getString("Total"));
			cache_Cashier_OtherPayments.setAccountCode(rs.getString("AccountCode"));
			cache_Cashier_OtherPayments.setcreated_at(rs.getString("created_at"));
			cache_Cashier_OtherPayments.setupdated_at(rs.getString("updated_at"));
			cache_Cashier_OtherPaymentsList.add(cache_Cashier_OtherPayments);
		}
		rs.close();
		ps.close();
		return cache_Cashier_OtherPaymentsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cache_Cashier_OtherPayments> billing_Billses = Cache_Cashier_OtherPaymentsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cache_Cashier_OtherPayments to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cache_Cashier_OtherPayments bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cache_Cashier_OtherPayments bill = Cache_Cashier_OtherPaymentsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cache_Cashier_OtherPayments has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cache_Cashier_OtherPaymentsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cache_Cashier_OtherPayments updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cache_Cashier_OtherPaymentsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cache_Cashier_OtherPayments inserted";
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
