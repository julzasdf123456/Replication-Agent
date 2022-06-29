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
public class Billing_MeterReadersDAO { 
	public static void insert(Billing_MeterReaders billing_MeterReaders, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_MeterReaders(id, MeterReaderCode, UserId, DeviceMacAddress, AreaCodeAssignment, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_MeterReaders.getid());
		ps.setString(2, billing_MeterReaders.getMeterReaderCode());
		ps.setString(3, billing_MeterReaders.getUserId());
		ps.setString(4, billing_MeterReaders.getDeviceMacAddress());
		ps.setString(5, billing_MeterReaders.getAreaCodeAssignment());
		ps.setString(6, billing_MeterReaders.getcreated_at());
		ps.setString(7, billing_MeterReaders.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_MeterReaders billing_MeterReaders, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_MeterReaders SET MeterReaderCode=?, UserId=?, DeviceMacAddress=?, AreaCodeAssignment=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, billing_MeterReaders.getMeterReaderCode());
		ps.setString(2, billing_MeterReaders.getUserId());
		ps.setString(3, billing_MeterReaders.getDeviceMacAddress());
		ps.setString(4, billing_MeterReaders.getAreaCodeAssignment());
		ps.setString(5, billing_MeterReaders.getcreated_at());
		ps.setString(6, billing_MeterReaders.getupdated_at());
		ps.setString(7, billing_MeterReaders.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_MeterReaders getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_MeterReaders WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_MeterReaders billing_MeterReaders = new Billing_MeterReaders(
			rs.getString("id"),
			rs.getString("MeterReaderCode"),
			rs.getString("UserId"),
			rs.getString("DeviceMacAddress"),
			rs.getString("AreaCodeAssignment"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return billing_MeterReaders;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_MeterReaders> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_MeterReaders WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_MeterReaders> billing_MeterReadersList = new ArrayList<>();
		while(rs.next()) {
			Billing_MeterReaders billing_MeterReaders = new Billing_MeterReaders();
			billing_MeterReaders.setid(rs.getString("id"));
			billing_MeterReaders.setMeterReaderCode(rs.getString("MeterReaderCode"));
			billing_MeterReaders.setUserId(rs.getString("UserId"));
			billing_MeterReaders.setDeviceMacAddress(rs.getString("DeviceMacAddress"));
			billing_MeterReaders.setAreaCodeAssignment(rs.getString("AreaCodeAssignment"));
			billing_MeterReaders.setcreated_at(rs.getString("created_at"));
			billing_MeterReaders.setupdated_at(rs.getString("updated_at"));
			billing_MeterReadersList.add(billing_MeterReaders);
		}
		rs.close();
		ps.close();
		return billing_MeterReadersList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_MeterReaders> billing_Billses = Billing_MeterReadersDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_MeterReaders to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_MeterReaders bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_MeterReaders bill = Billing_MeterReadersDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_MeterReaders has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_MeterReadersDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_MeterReaders updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_MeterReadersDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_MeterReaders inserted";
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
