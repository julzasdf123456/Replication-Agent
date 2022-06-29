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
public class Billing_BAPAReadingScheduleDAO { 
	public static void insert(Billing_BAPAReadingSchedule billing_BAPAReadingSchedule, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_BAPAReadingSchedule(id, ServicePeriod, Town, BAPAName, Status, DownloadedBy, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_BAPAReadingSchedule.getid());
		ps.setString(2, billing_BAPAReadingSchedule.getServicePeriod());
		ps.setString(3, billing_BAPAReadingSchedule.getTown());
		ps.setString(4, billing_BAPAReadingSchedule.getBAPAName());
		ps.setString(5, billing_BAPAReadingSchedule.getStatus());
		ps.setString(6, billing_BAPAReadingSchedule.getDownloadedBy());
		ps.setString(7, billing_BAPAReadingSchedule.getcreated_at());
		ps.setString(8, billing_BAPAReadingSchedule.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_BAPAReadingSchedule billing_BAPAReadingSchedule, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_BAPAReadingSchedule SET ServicePeriod=?, Town=?, BAPAName=?, Status=?, DownloadedBy=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, billing_BAPAReadingSchedule.getServicePeriod());
		ps.setString(2, billing_BAPAReadingSchedule.getTown());
		ps.setString(3, billing_BAPAReadingSchedule.getBAPAName());
		ps.setString(4, billing_BAPAReadingSchedule.getStatus());
		ps.setString(5, billing_BAPAReadingSchedule.getDownloadedBy());
		ps.setString(6, billing_BAPAReadingSchedule.getcreated_at());
		ps.setString(7, billing_BAPAReadingSchedule.getupdated_at());
		ps.setString(8, billing_BAPAReadingSchedule.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_BAPAReadingSchedule getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_BAPAReadingSchedule WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_BAPAReadingSchedule billing_BAPAReadingSchedule = new Billing_BAPAReadingSchedule(
			rs.getString("id"),
			rs.getString("ServicePeriod"),
			rs.getString("Town"),
			rs.getString("BAPAName"),
			rs.getString("Status"),
			rs.getString("DownloadedBy"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return billing_BAPAReadingSchedule;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_BAPAReadingSchedule> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_BAPAReadingSchedule WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_BAPAReadingSchedule> billing_BAPAReadingScheduleList = new ArrayList<>();
		while(rs.next()) {
			Billing_BAPAReadingSchedule billing_BAPAReadingSchedule = new Billing_BAPAReadingSchedule();
			billing_BAPAReadingSchedule.setid(rs.getString("id"));
			billing_BAPAReadingSchedule.setServicePeriod(rs.getString("ServicePeriod"));
			billing_BAPAReadingSchedule.setTown(rs.getString("Town"));
			billing_BAPAReadingSchedule.setBAPAName(rs.getString("BAPAName"));
			billing_BAPAReadingSchedule.setStatus(rs.getString("Status"));
			billing_BAPAReadingSchedule.setDownloadedBy(rs.getString("DownloadedBy"));
			billing_BAPAReadingSchedule.setcreated_at(rs.getString("created_at"));
			billing_BAPAReadingSchedule.setupdated_at(rs.getString("updated_at"));
			billing_BAPAReadingScheduleList.add(billing_BAPAReadingSchedule);
		}
		rs.close();
		ps.close();
		return billing_BAPAReadingScheduleList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_BAPAReadingSchedule> billing_Billses = Billing_BAPAReadingScheduleDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_BAPAReadingSchedule to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_BAPAReadingSchedule bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_BAPAReadingSchedule bill = Billing_BAPAReadingScheduleDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_BAPAReadingSchedule has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_BAPAReadingScheduleDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_BAPAReadingSchedule updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_BAPAReadingScheduleDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_BAPAReadingSchedule inserted";
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
