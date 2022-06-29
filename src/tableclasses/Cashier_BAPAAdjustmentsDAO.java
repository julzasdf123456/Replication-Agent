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
public class Cashier_BAPAAdjustmentsDAO { 
	public static void insert(Cashier_BAPAAdjustments cashier_BAPAAdjustments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_BAPAAdjustments(id, BAPAName, ServicePeriod, DiscountPercentage, DiscountAmount, NumberOfConsumers, SubTotal, NetAmount, UserId, Route, created_at, updated_at, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_BAPAAdjustments.getid());
		ps.setString(2, cashier_BAPAAdjustments.getBAPAName());
		ps.setString(3, cashier_BAPAAdjustments.getServicePeriod());
		ps.setString(4, cashier_BAPAAdjustments.getDiscountPercentage());
		ps.setString(5, cashier_BAPAAdjustments.getDiscountAmount());
		ps.setString(6, cashier_BAPAAdjustments.getNumberOfConsumers());
		ps.setString(7, cashier_BAPAAdjustments.getSubTotal());
		ps.setString(8, cashier_BAPAAdjustments.getNetAmount());
		ps.setString(9, cashier_BAPAAdjustments.getUserId());
		ps.setString(10, cashier_BAPAAdjustments.getRoute());
		ps.setString(11, cashier_BAPAAdjustments.getcreated_at());
		ps.setString(12, cashier_BAPAAdjustments.getupdated_at());
		ps.setString(13, cashier_BAPAAdjustments.getStatus());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_BAPAAdjustments cashier_BAPAAdjustments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_BAPAAdjustments SET BAPAName=?, ServicePeriod=?, DiscountPercentage=?, DiscountAmount=?, NumberOfConsumers=?, SubTotal=?, NetAmount=?, UserId=?, Route=?, created_at=?, updated_at=?, Status=?  WHERE id=? ");
		ps.setString(1, cashier_BAPAAdjustments.getBAPAName());
		ps.setString(2, cashier_BAPAAdjustments.getServicePeriod());
		ps.setString(3, cashier_BAPAAdjustments.getDiscountPercentage());
		ps.setString(4, cashier_BAPAAdjustments.getDiscountAmount());
		ps.setString(5, cashier_BAPAAdjustments.getNumberOfConsumers());
		ps.setString(6, cashier_BAPAAdjustments.getSubTotal());
		ps.setString(7, cashier_BAPAAdjustments.getNetAmount());
		ps.setString(8, cashier_BAPAAdjustments.getUserId());
		ps.setString(9, cashier_BAPAAdjustments.getRoute());
		ps.setString(10, cashier_BAPAAdjustments.getcreated_at());
		ps.setString(11, cashier_BAPAAdjustments.getupdated_at());
		ps.setString(12, cashier_BAPAAdjustments.getStatus());
		ps.setString(13, cashier_BAPAAdjustments.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_BAPAAdjustments getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_BAPAAdjustments WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_BAPAAdjustments cashier_BAPAAdjustments = new Cashier_BAPAAdjustments(
			rs.getString("id"),
			rs.getString("BAPAName"),
			rs.getString("ServicePeriod"),
			rs.getString("DiscountPercentage"),
			rs.getString("DiscountAmount"),
			rs.getString("NumberOfConsumers"),
			rs.getString("SubTotal"),
			rs.getString("NetAmount"),
			rs.getString("UserId"),
			rs.getString("Route"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Status")
			);
			ps.close();
			rs.close();
			return cashier_BAPAAdjustments;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_BAPAAdjustments> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_BAPAAdjustments WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_BAPAAdjustments> cashier_BAPAAdjustmentsList = new ArrayList<>();
		while(rs.next()) {
			Cashier_BAPAAdjustments cashier_BAPAAdjustments = new Cashier_BAPAAdjustments();
			cashier_BAPAAdjustments.setid(rs.getString("id"));
			cashier_BAPAAdjustments.setBAPAName(rs.getString("BAPAName"));
			cashier_BAPAAdjustments.setServicePeriod(rs.getString("ServicePeriod"));
			cashier_BAPAAdjustments.setDiscountPercentage(rs.getString("DiscountPercentage"));
			cashier_BAPAAdjustments.setDiscountAmount(rs.getString("DiscountAmount"));
			cashier_BAPAAdjustments.setNumberOfConsumers(rs.getString("NumberOfConsumers"));
			cashier_BAPAAdjustments.setSubTotal(rs.getString("SubTotal"));
			cashier_BAPAAdjustments.setNetAmount(rs.getString("NetAmount"));
			cashier_BAPAAdjustments.setUserId(rs.getString("UserId"));
			cashier_BAPAAdjustments.setRoute(rs.getString("Route"));
			cashier_BAPAAdjustments.setcreated_at(rs.getString("created_at"));
			cashier_BAPAAdjustments.setupdated_at(rs.getString("updated_at"));
			cashier_BAPAAdjustments.setStatus(rs.getString("Status"));
			cashier_BAPAAdjustmentsList.add(cashier_BAPAAdjustments);
		}
		rs.close();
		ps.close();
		return cashier_BAPAAdjustmentsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_BAPAAdjustments> billing_Billses = Cashier_BAPAAdjustmentsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_BAPAAdjustments to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_BAPAAdjustments bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_BAPAAdjustments bill = Cashier_BAPAAdjustmentsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_BAPAAdjustments has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_BAPAAdjustmentsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_BAPAAdjustments updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_BAPAAdjustmentsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_BAPAAdjustments inserted";
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
