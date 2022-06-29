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
public class Billing_PendingBillAdjustmentsDAO { 
	public static void insert(Billing_PendingBillAdjustments billing_PendingBillAdjustments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_PendingBillAdjustments(id, ReadingId, KwhUsed, AccountNumber, ServicePeriod, Confirmed, ReadDate, created_at, updated_at, UserId, Office) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_PendingBillAdjustments.getid());
		ps.setString(2, billing_PendingBillAdjustments.getReadingId());
		ps.setString(3, billing_PendingBillAdjustments.getKwhUsed());
		ps.setString(4, billing_PendingBillAdjustments.getAccountNumber());
		ps.setString(5, billing_PendingBillAdjustments.getServicePeriod());
		ps.setString(6, billing_PendingBillAdjustments.getConfirmed());
		ps.setString(7, billing_PendingBillAdjustments.getReadDate());
		ps.setString(8, billing_PendingBillAdjustments.getcreated_at());
		ps.setString(9, billing_PendingBillAdjustments.getupdated_at());
		ps.setString(10, billing_PendingBillAdjustments.getUserId());
		ps.setString(11, billing_PendingBillAdjustments.getOffice());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_PendingBillAdjustments billing_PendingBillAdjustments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_PendingBillAdjustments SET ReadingId=?, KwhUsed=?, AccountNumber=?, ServicePeriod=?, Confirmed=?, ReadDate=?, created_at=?, updated_at=?, UserId=?, Office=?  WHERE id=? ");
		ps.setString(1, billing_PendingBillAdjustments.getReadingId());
		ps.setString(2, billing_PendingBillAdjustments.getKwhUsed());
		ps.setString(3, billing_PendingBillAdjustments.getAccountNumber());
		ps.setString(4, billing_PendingBillAdjustments.getServicePeriod());
		ps.setString(5, billing_PendingBillAdjustments.getConfirmed());
		ps.setString(6, billing_PendingBillAdjustments.getReadDate());
		ps.setString(7, billing_PendingBillAdjustments.getcreated_at());
		ps.setString(8, billing_PendingBillAdjustments.getupdated_at());
		ps.setString(9, billing_PendingBillAdjustments.getUserId());
		ps.setString(10, billing_PendingBillAdjustments.getOffice());
		ps.setString(11, billing_PendingBillAdjustments.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_PendingBillAdjustments getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_PendingBillAdjustments WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_PendingBillAdjustments billing_PendingBillAdjustments = new Billing_PendingBillAdjustments(
			rs.getString("id"),
			rs.getString("ReadingId"),
			rs.getString("KwhUsed"),
			rs.getString("AccountNumber"),
			rs.getString("ServicePeriod"),
			rs.getString("Confirmed"),
			rs.getString("ReadDate"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("UserId"),
			rs.getString("Office")
			);
			ps.close();
			rs.close();
			return billing_PendingBillAdjustments;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_PendingBillAdjustments> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_PendingBillAdjustments WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_PendingBillAdjustments> billing_PendingBillAdjustmentsList = new ArrayList<>();
		while(rs.next()) {
			Billing_PendingBillAdjustments billing_PendingBillAdjustments = new Billing_PendingBillAdjustments();
			billing_PendingBillAdjustments.setid(rs.getString("id"));
			billing_PendingBillAdjustments.setReadingId(rs.getString("ReadingId"));
			billing_PendingBillAdjustments.setKwhUsed(rs.getString("KwhUsed"));
			billing_PendingBillAdjustments.setAccountNumber(rs.getString("AccountNumber"));
			billing_PendingBillAdjustments.setServicePeriod(rs.getString("ServicePeriod"));
			billing_PendingBillAdjustments.setConfirmed(rs.getString("Confirmed"));
			billing_PendingBillAdjustments.setReadDate(rs.getString("ReadDate"));
			billing_PendingBillAdjustments.setcreated_at(rs.getString("created_at"));
			billing_PendingBillAdjustments.setupdated_at(rs.getString("updated_at"));
			billing_PendingBillAdjustments.setUserId(rs.getString("UserId"));
			billing_PendingBillAdjustments.setOffice(rs.getString("Office"));
			billing_PendingBillAdjustmentsList.add(billing_PendingBillAdjustments);
		}
		rs.close();
		ps.close();
		return billing_PendingBillAdjustmentsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_PendingBillAdjustments> billing_Billses = Billing_PendingBillAdjustmentsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_PendingBillAdjustments to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_PendingBillAdjustments bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_PendingBillAdjustments bill = Billing_PendingBillAdjustmentsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_PendingBillAdjustments has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_PendingBillAdjustmentsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_PendingBillAdjustments updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_PendingBillAdjustmentsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_PendingBillAdjustments inserted";
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
