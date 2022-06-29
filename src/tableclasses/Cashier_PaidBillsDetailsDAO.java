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
public class Cashier_PaidBillsDetailsDAO { 
	public static void insert(Cashier_PaidBillsDetails cashier_PaidBillsDetails, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_PaidBillsDetails(id, AccountNumber, ServicePeriod, BillId, ORNumber, Amount, PaymentUsed, CheckNo, Bank, CheckExpiration, UserId, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_PaidBillsDetails.getid());
		ps.setString(2, cashier_PaidBillsDetails.getAccountNumber());
		ps.setString(3, cashier_PaidBillsDetails.getServicePeriod());
		ps.setString(4, cashier_PaidBillsDetails.getBillId());
		ps.setString(5, cashier_PaidBillsDetails.getORNumber());
		ps.setString(6, cashier_PaidBillsDetails.getAmount());
		ps.setString(7, cashier_PaidBillsDetails.getPaymentUsed());
		ps.setString(8, cashier_PaidBillsDetails.getCheckNo());
		ps.setString(9, cashier_PaidBillsDetails.getBank());
		ps.setString(10, cashier_PaidBillsDetails.getCheckExpiration());
		ps.setString(11, cashier_PaidBillsDetails.getUserId());
		ps.setString(12, cashier_PaidBillsDetails.getcreated_at());
		ps.setString(13, cashier_PaidBillsDetails.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_PaidBillsDetails cashier_PaidBillsDetails, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_PaidBillsDetails SET AccountNumber=?, ServicePeriod=?, BillId=?, ORNumber=?, Amount=?, PaymentUsed=?, CheckNo=?, Bank=?, CheckExpiration=?, UserId=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cashier_PaidBillsDetails.getAccountNumber());
		ps.setString(2, cashier_PaidBillsDetails.getServicePeriod());
		ps.setString(3, cashier_PaidBillsDetails.getBillId());
		ps.setString(4, cashier_PaidBillsDetails.getORNumber());
		ps.setString(5, cashier_PaidBillsDetails.getAmount());
		ps.setString(6, cashier_PaidBillsDetails.getPaymentUsed());
		ps.setString(7, cashier_PaidBillsDetails.getCheckNo());
		ps.setString(8, cashier_PaidBillsDetails.getBank());
		ps.setString(9, cashier_PaidBillsDetails.getCheckExpiration());
		ps.setString(10, cashier_PaidBillsDetails.getUserId());
		ps.setString(11, cashier_PaidBillsDetails.getcreated_at());
		ps.setString(12, cashier_PaidBillsDetails.getupdated_at());
		ps.setString(13, cashier_PaidBillsDetails.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_PaidBillsDetails getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_PaidBillsDetails WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_PaidBillsDetails cashier_PaidBillsDetails = new Cashier_PaidBillsDetails(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("ServicePeriod"),
			rs.getString("BillId"),
			rs.getString("ORNumber"),
			rs.getString("Amount"),
			rs.getString("PaymentUsed"),
			rs.getString("CheckNo"),
			rs.getString("Bank"),
			rs.getString("CheckExpiration"),
			rs.getString("UserId"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cashier_PaidBillsDetails;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_PaidBillsDetails> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_PaidBillsDetails WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_PaidBillsDetails> cashier_PaidBillsDetailsList = new ArrayList<>();
		while(rs.next()) {
			Cashier_PaidBillsDetails cashier_PaidBillsDetails = new Cashier_PaidBillsDetails();
			cashier_PaidBillsDetails.setid(rs.getString("id"));
			cashier_PaidBillsDetails.setAccountNumber(rs.getString("AccountNumber"));
			cashier_PaidBillsDetails.setServicePeriod(rs.getString("ServicePeriod"));
			cashier_PaidBillsDetails.setBillId(rs.getString("BillId"));
			cashier_PaidBillsDetails.setORNumber(rs.getString("ORNumber"));
			cashier_PaidBillsDetails.setAmount(rs.getString("Amount"));
			cashier_PaidBillsDetails.setPaymentUsed(rs.getString("PaymentUsed"));
			cashier_PaidBillsDetails.setCheckNo(rs.getString("CheckNo"));
			cashier_PaidBillsDetails.setBank(rs.getString("Bank"));
			cashier_PaidBillsDetails.setCheckExpiration(rs.getString("CheckExpiration"));
			cashier_PaidBillsDetails.setUserId(rs.getString("UserId"));
			cashier_PaidBillsDetails.setcreated_at(rs.getString("created_at"));
			cashier_PaidBillsDetails.setupdated_at(rs.getString("updated_at"));
			cashier_PaidBillsDetailsList.add(cashier_PaidBillsDetails);
		}
		rs.close();
		ps.close();
		return cashier_PaidBillsDetailsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_PaidBillsDetails> billing_Billses = Cashier_PaidBillsDetailsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_PaidBillsDetails to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_PaidBillsDetails bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_PaidBillsDetails bill = Cashier_PaidBillsDetailsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_PaidBillsDetails has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_PaidBillsDetailsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_PaidBillsDetails updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_PaidBillsDetailsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_PaidBillsDetails inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
