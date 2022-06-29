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
public class Billing_ReadingSchedulesDAO { 
	public static void insert(Billing_ReadingSchedules billing_ReadingSchedules, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_ReadingSchedules(id, AreaCode, GroupCode, ServicePeriod, ScheduledDate, MeterReader, created_at, updated_at, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_ReadingSchedules.getid());
		ps.setString(2, billing_ReadingSchedules.getAreaCode());
		ps.setString(3, billing_ReadingSchedules.getGroupCode());
		ps.setString(4, billing_ReadingSchedules.getServicePeriod());
		ps.setString(5, billing_ReadingSchedules.getScheduledDate());
		ps.setString(6, billing_ReadingSchedules.getMeterReader());
		ps.setString(7, billing_ReadingSchedules.getcreated_at());
		ps.setString(8, billing_ReadingSchedules.getupdated_at());
		ps.setString(9, billing_ReadingSchedules.getStatus());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_ReadingSchedules billing_ReadingSchedules, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_ReadingSchedules SET AreaCode=?, GroupCode=?, ServicePeriod=?, ScheduledDate=?, MeterReader=?, created_at=?, updated_at=?, Status=?  WHERE id=? ");
		ps.setString(1, billing_ReadingSchedules.getAreaCode());
		ps.setString(2, billing_ReadingSchedules.getGroupCode());
		ps.setString(3, billing_ReadingSchedules.getServicePeriod());
		ps.setString(4, billing_ReadingSchedules.getScheduledDate());
		ps.setString(5, billing_ReadingSchedules.getMeterReader());
		ps.setString(6, billing_ReadingSchedules.getcreated_at());
		ps.setString(7, billing_ReadingSchedules.getupdated_at());
		ps.setString(8, billing_ReadingSchedules.getStatus());
		ps.setString(9, billing_ReadingSchedules.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_ReadingSchedules getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_ReadingSchedules WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_ReadingSchedules billing_ReadingSchedules = new Billing_ReadingSchedules(
			rs.getString("id"),
			rs.getString("AreaCode"),
			rs.getString("GroupCode"),
			rs.getString("ServicePeriod"),
			rs.getString("ScheduledDate"),
			rs.getString("MeterReader"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Status")
			);
			ps.close();
			rs.close();
			return billing_ReadingSchedules;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_ReadingSchedules> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_ReadingSchedules WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_ReadingSchedules> billing_ReadingSchedulesList = new ArrayList<>();
		while(rs.next()) {
			Billing_ReadingSchedules billing_ReadingSchedules = new Billing_ReadingSchedules();
			billing_ReadingSchedules.setid(rs.getString("id"));
			billing_ReadingSchedules.setAreaCode(rs.getString("AreaCode"));
			billing_ReadingSchedules.setGroupCode(rs.getString("GroupCode"));
			billing_ReadingSchedules.setServicePeriod(rs.getString("ServicePeriod"));
			billing_ReadingSchedules.setScheduledDate(rs.getString("ScheduledDate"));
			billing_ReadingSchedules.setMeterReader(rs.getString("MeterReader"));
			billing_ReadingSchedules.setcreated_at(rs.getString("created_at"));
			billing_ReadingSchedules.setupdated_at(rs.getString("updated_at"));
			billing_ReadingSchedules.setStatus(rs.getString("Status"));
			billing_ReadingSchedulesList.add(billing_ReadingSchedules);
		}
		rs.close();
		ps.close();
		return billing_ReadingSchedulesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_ReadingSchedules> billing_Billses = Billing_ReadingSchedulesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_ReadingSchedules to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_ReadingSchedules bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_ReadingSchedules bill = Billing_ReadingSchedulesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_ReadingSchedules has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_ReadingSchedulesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_ReadingSchedules updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_ReadingSchedulesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_ReadingSchedules inserted";
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

