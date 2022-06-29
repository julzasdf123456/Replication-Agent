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
public class Billing_ChangeMeterLogsDAO { 
	public static void insert(Billing_ChangeMeterLogs billing_ChangeMeterLogs, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_ChangeMeterLogs(id, AccountNumber, OldMeterSerial, NewMeterSerial, PullOutReading, AdditionalKwhForNextBilling, Status, created_at, updated_at, ServicePeriod, NewMeterStartKwh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_ChangeMeterLogs.getid());
		ps.setString(2, billing_ChangeMeterLogs.getAccountNumber());
		ps.setString(3, billing_ChangeMeterLogs.getOldMeterSerial());
		ps.setString(4, billing_ChangeMeterLogs.getNewMeterSerial());
		ps.setString(5, billing_ChangeMeterLogs.getPullOutReading());
		ps.setString(6, billing_ChangeMeterLogs.getAdditionalKwhForNextBilling());
		ps.setString(7, billing_ChangeMeterLogs.getStatus());
		ps.setString(8, billing_ChangeMeterLogs.getcreated_at());
		ps.setString(9, billing_ChangeMeterLogs.getupdated_at());
		ps.setString(10, billing_ChangeMeterLogs.getServicePeriod());
		ps.setString(11, billing_ChangeMeterLogs.getNewMeterStartKwh());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_ChangeMeterLogs billing_ChangeMeterLogs, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_ChangeMeterLogs SET AccountNumber=?, OldMeterSerial=?, NewMeterSerial=?, PullOutReading=?, AdditionalKwhForNextBilling=?, Status=?, created_at=?, updated_at=?, ServicePeriod=?, NewMeterStartKwh=?  WHERE id=? ");
		ps.setString(1, billing_ChangeMeterLogs.getAccountNumber());
		ps.setString(2, billing_ChangeMeterLogs.getOldMeterSerial());
		ps.setString(3, billing_ChangeMeterLogs.getNewMeterSerial());
		ps.setString(4, billing_ChangeMeterLogs.getPullOutReading());
		ps.setString(5, billing_ChangeMeterLogs.getAdditionalKwhForNextBilling());
		ps.setString(6, billing_ChangeMeterLogs.getStatus());
		ps.setString(7, billing_ChangeMeterLogs.getcreated_at());
		ps.setString(8, billing_ChangeMeterLogs.getupdated_at());
		ps.setString(9, billing_ChangeMeterLogs.getServicePeriod());
		ps.setString(10, billing_ChangeMeterLogs.getNewMeterStartKwh());
		ps.setString(11, billing_ChangeMeterLogs.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_ChangeMeterLogs getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_ChangeMeterLogs WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_ChangeMeterLogs billing_ChangeMeterLogs = new Billing_ChangeMeterLogs(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("OldMeterSerial"),
			rs.getString("NewMeterSerial"),
			rs.getString("PullOutReading"),
			rs.getString("AdditionalKwhForNextBilling"),
			rs.getString("Status"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("ServicePeriod"),
			rs.getString("NewMeterStartKwh")
			);
			ps.close();
			rs.close();
			return billing_ChangeMeterLogs;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_ChangeMeterLogs> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_ChangeMeterLogs WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_ChangeMeterLogs> billing_ChangeMeterLogsList = new ArrayList<>();
		while(rs.next()) {
			Billing_ChangeMeterLogs billing_ChangeMeterLogs = new Billing_ChangeMeterLogs();
			billing_ChangeMeterLogs.setid(rs.getString("id"));
			billing_ChangeMeterLogs.setAccountNumber(rs.getString("AccountNumber"));
			billing_ChangeMeterLogs.setOldMeterSerial(rs.getString("OldMeterSerial"));
			billing_ChangeMeterLogs.setNewMeterSerial(rs.getString("NewMeterSerial"));
			billing_ChangeMeterLogs.setPullOutReading(rs.getString("PullOutReading"));
			billing_ChangeMeterLogs.setAdditionalKwhForNextBilling(rs.getString("AdditionalKwhForNextBilling"));
			billing_ChangeMeterLogs.setStatus(rs.getString("Status"));
			billing_ChangeMeterLogs.setcreated_at(rs.getString("created_at"));
			billing_ChangeMeterLogs.setupdated_at(rs.getString("updated_at"));
			billing_ChangeMeterLogs.setServicePeriod(rs.getString("ServicePeriod"));
			billing_ChangeMeterLogs.setNewMeterStartKwh(rs.getString("NewMeterStartKwh"));
			billing_ChangeMeterLogsList.add(billing_ChangeMeterLogs);
		}
		rs.close();
		ps.close();
		return billing_ChangeMeterLogsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_ChangeMeterLogs> billing_Billses = Billing_ChangeMeterLogsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_ChangeMeterLogs to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_ChangeMeterLogs bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_ChangeMeterLogs bill = Billing_ChangeMeterLogsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_ChangeMeterLogs has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_ChangeMeterLogsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_ChangeMeterLogs updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_ChangeMeterLogsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_ChangeMeterLogs inserted";
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
