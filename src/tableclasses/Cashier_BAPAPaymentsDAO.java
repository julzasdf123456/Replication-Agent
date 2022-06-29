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
public class Cashier_BAPAPaymentsDAO { 
	public static void insert(Cashier_BAPAPayments cashier_BAPAPayments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_BAPAPayments(id, BAPAName, ServicePeriod, ORNumber, ORDate, SubTotal, TwoPercentDiscount, FivePercentDiscount, AdditionalCharges, Deductions, VAT, Total, Teller, NoOfConsumersPaid, Status, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_BAPAPayments.getid());
		ps.setString(2, cashier_BAPAPayments.getBAPAName());
		ps.setString(3, cashier_BAPAPayments.getServicePeriod());
		ps.setString(4, cashier_BAPAPayments.getORNumber());
		ps.setString(5, cashier_BAPAPayments.getORDate());
		ps.setString(6, cashier_BAPAPayments.getSubTotal());
		ps.setString(7, cashier_BAPAPayments.getTwoPercentDiscount());
		ps.setString(8, cashier_BAPAPayments.getFivePercentDiscount());
		ps.setString(9, cashier_BAPAPayments.getAdditionalCharges());
		ps.setString(10, cashier_BAPAPayments.getDeductions());
		ps.setString(11, cashier_BAPAPayments.getVAT());
		ps.setString(12, cashier_BAPAPayments.getTotal());
		ps.setString(13, cashier_BAPAPayments.getTeller());
		ps.setString(14, cashier_BAPAPayments.getNoOfConsumersPaid());
		ps.setString(15, cashier_BAPAPayments.getStatus());
		ps.setString(16, cashier_BAPAPayments.getNotes());
		ps.setString(17, cashier_BAPAPayments.getcreated_at());
		ps.setString(18, cashier_BAPAPayments.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_BAPAPayments cashier_BAPAPayments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_BAPAPayments SET BAPAName=?, ServicePeriod=?, ORNumber=?, ORDate=?, SubTotal=?, TwoPercentDiscount=?, FivePercentDiscount=?, AdditionalCharges=?, Deductions=?, VAT=?, Total=?, Teller=?, NoOfConsumersPaid=?, Status=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cashier_BAPAPayments.getBAPAName());
		ps.setString(2, cashier_BAPAPayments.getServicePeriod());
		ps.setString(3, cashier_BAPAPayments.getORNumber());
		ps.setString(4, cashier_BAPAPayments.getORDate());
		ps.setString(5, cashier_BAPAPayments.getSubTotal());
		ps.setString(6, cashier_BAPAPayments.getTwoPercentDiscount());
		ps.setString(7, cashier_BAPAPayments.getFivePercentDiscount());
		ps.setString(8, cashier_BAPAPayments.getAdditionalCharges());
		ps.setString(9, cashier_BAPAPayments.getDeductions());
		ps.setString(10, cashier_BAPAPayments.getVAT());
		ps.setString(11, cashier_BAPAPayments.getTotal());
		ps.setString(12, cashier_BAPAPayments.getTeller());
		ps.setString(13, cashier_BAPAPayments.getNoOfConsumersPaid());
		ps.setString(14, cashier_BAPAPayments.getStatus());
		ps.setString(15, cashier_BAPAPayments.getNotes());
		ps.setString(16, cashier_BAPAPayments.getcreated_at());
		ps.setString(17, cashier_BAPAPayments.getupdated_at());
		ps.setString(18, cashier_BAPAPayments.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_BAPAPayments getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_BAPAPayments WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_BAPAPayments cashier_BAPAPayments = new Cashier_BAPAPayments(
			rs.getString("id"),
			rs.getString("BAPAName"),
			rs.getString("ServicePeriod"),
			rs.getString("ORNumber"),
			rs.getString("ORDate"),
			rs.getString("SubTotal"),
			rs.getString("TwoPercentDiscount"),
			rs.getString("FivePercentDiscount"),
			rs.getString("AdditionalCharges"),
			rs.getString("Deductions"),
			rs.getString("VAT"),
			rs.getString("Total"),
			rs.getString("Teller"),
			rs.getString("NoOfConsumersPaid"),
			rs.getString("Status"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cashier_BAPAPayments;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_BAPAPayments> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_BAPAPayments WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_BAPAPayments> cashier_BAPAPaymentsList = new ArrayList<>();
		while(rs.next()) {
			Cashier_BAPAPayments cashier_BAPAPayments = new Cashier_BAPAPayments();
			cashier_BAPAPayments.setid(rs.getString("id"));
			cashier_BAPAPayments.setBAPAName(rs.getString("BAPAName"));
			cashier_BAPAPayments.setServicePeriod(rs.getString("ServicePeriod"));
			cashier_BAPAPayments.setORNumber(rs.getString("ORNumber"));
			cashier_BAPAPayments.setORDate(rs.getString("ORDate"));
			cashier_BAPAPayments.setSubTotal(rs.getString("SubTotal"));
			cashier_BAPAPayments.setTwoPercentDiscount(rs.getString("TwoPercentDiscount"));
			cashier_BAPAPayments.setFivePercentDiscount(rs.getString("FivePercentDiscount"));
			cashier_BAPAPayments.setAdditionalCharges(rs.getString("AdditionalCharges"));
			cashier_BAPAPayments.setDeductions(rs.getString("Deductions"));
			cashier_BAPAPayments.setVAT(rs.getString("VAT"));
			cashier_BAPAPayments.setTotal(rs.getString("Total"));
			cashier_BAPAPayments.setTeller(rs.getString("Teller"));
			cashier_BAPAPayments.setNoOfConsumersPaid(rs.getString("NoOfConsumersPaid"));
			cashier_BAPAPayments.setStatus(rs.getString("Status"));
			cashier_BAPAPayments.setNotes(rs.getString("Notes"));
			cashier_BAPAPayments.setcreated_at(rs.getString("created_at"));
			cashier_BAPAPayments.setupdated_at(rs.getString("updated_at"));
			cashier_BAPAPaymentsList.add(cashier_BAPAPayments);
		}
		rs.close();
		ps.close();
		return cashier_BAPAPaymentsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_BAPAPayments> billing_Billses = Cashier_BAPAPaymentsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_BAPAPayments to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_BAPAPayments bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_BAPAPayments bill = Cashier_BAPAPaymentsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_BAPAPayments has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_BAPAPaymentsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_BAPAPayments updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_BAPAPaymentsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_BAPAPayments inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(35);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
