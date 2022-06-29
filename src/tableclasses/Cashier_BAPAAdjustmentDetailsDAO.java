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
public class Cashier_BAPAAdjustmentDetailsDAO { 
	public static void insert(Cashier_BAPAAdjustmentDetails cashier_BAPAAdjustmentDetails, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_BAPAAdjustmentDetails(id, AccountNumber, BillId, DiscountPercentage, DiscountAmount, BAPAName, ServicePeriod, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_BAPAAdjustmentDetails.getid());
		ps.setString(2, cashier_BAPAAdjustmentDetails.getAccountNumber());
		ps.setString(3, cashier_BAPAAdjustmentDetails.getBillId());
		ps.setString(4, cashier_BAPAAdjustmentDetails.getDiscountPercentage());
		ps.setString(5, cashier_BAPAAdjustmentDetails.getDiscountAmount());
		ps.setString(6, cashier_BAPAAdjustmentDetails.getBAPAName());
		ps.setString(7, cashier_BAPAAdjustmentDetails.getServicePeriod());
		ps.setString(8, cashier_BAPAAdjustmentDetails.getcreated_at());
		ps.setString(9, cashier_BAPAAdjustmentDetails.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_BAPAAdjustmentDetails cashier_BAPAAdjustmentDetails, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_BAPAAdjustmentDetails SET AccountNumber=?, BillId=?, DiscountPercentage=?, DiscountAmount=?, BAPAName=?, ServicePeriod=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cashier_BAPAAdjustmentDetails.getAccountNumber());
		ps.setString(2, cashier_BAPAAdjustmentDetails.getBillId());
		ps.setString(3, cashier_BAPAAdjustmentDetails.getDiscountPercentage());
		ps.setString(4, cashier_BAPAAdjustmentDetails.getDiscountAmount());
		ps.setString(5, cashier_BAPAAdjustmentDetails.getBAPAName());
		ps.setString(6, cashier_BAPAAdjustmentDetails.getServicePeriod());
		ps.setString(7, cashier_BAPAAdjustmentDetails.getcreated_at());
		ps.setString(8, cashier_BAPAAdjustmentDetails.getupdated_at());
		ps.setString(9, cashier_BAPAAdjustmentDetails.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_BAPAAdjustmentDetails getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_BAPAAdjustmentDetails WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_BAPAAdjustmentDetails cashier_BAPAAdjustmentDetails = new Cashier_BAPAAdjustmentDetails(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("BillId"),
			rs.getString("DiscountPercentage"),
			rs.getString("DiscountAmount"),
			rs.getString("BAPAName"),
			rs.getString("ServicePeriod"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cashier_BAPAAdjustmentDetails;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_BAPAAdjustmentDetails> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_BAPAAdjustmentDetails WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_BAPAAdjustmentDetails> cashier_BAPAAdjustmentDetailsList = new ArrayList<>();
		while(rs.next()) {
			Cashier_BAPAAdjustmentDetails cashier_BAPAAdjustmentDetails = new Cashier_BAPAAdjustmentDetails();
			cashier_BAPAAdjustmentDetails.setid(rs.getString("id"));
			cashier_BAPAAdjustmentDetails.setAccountNumber(rs.getString("AccountNumber"));
			cashier_BAPAAdjustmentDetails.setBillId(rs.getString("BillId"));
			cashier_BAPAAdjustmentDetails.setDiscountPercentage(rs.getString("DiscountPercentage"));
			cashier_BAPAAdjustmentDetails.setDiscountAmount(rs.getString("DiscountAmount"));
			cashier_BAPAAdjustmentDetails.setBAPAName(rs.getString("BAPAName"));
			cashier_BAPAAdjustmentDetails.setServicePeriod(rs.getString("ServicePeriod"));
			cashier_BAPAAdjustmentDetails.setcreated_at(rs.getString("created_at"));
			cashier_BAPAAdjustmentDetails.setupdated_at(rs.getString("updated_at"));
			cashier_BAPAAdjustmentDetailsList.add(cashier_BAPAAdjustmentDetails);
		}
		rs.close();
		ps.close();
		return cashier_BAPAAdjustmentDetailsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_BAPAAdjustmentDetails> billing_Billses = Cashier_BAPAAdjustmentDetailsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_BAPAAdjustmentDetails to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_BAPAAdjustmentDetails bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_BAPAAdjustmentDetails bill = Cashier_BAPAAdjustmentDetailsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_BAPAAdjustmentDetails has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_BAPAAdjustmentDetailsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_BAPAAdjustmentDetails updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_BAPAAdjustmentDetailsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_BAPAAdjustmentDetails inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
