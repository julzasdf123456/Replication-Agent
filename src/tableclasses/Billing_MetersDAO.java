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
public class Billing_MetersDAO { 
	public static void insert(Billing_Meters billing_Meters, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_Meters(id, ServiceAccountId, SerialNumber, SealNumber, Brand, Model, Multiplier, Status, ConnectionDate, LatestReadingDate, DateDisconnected, DateTransfered, created_at, updated_at, InitialReading, LatestReading) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_Meters.getid());
		ps.setString(2, billing_Meters.getServiceAccountId());
		ps.setString(3, billing_Meters.getSerialNumber());
		ps.setString(4, billing_Meters.getSealNumber());
		ps.setString(5, billing_Meters.getBrand());
		ps.setString(6, billing_Meters.getModel());
		ps.setString(7, billing_Meters.getMultiplier());
		ps.setString(8, billing_Meters.getStatus());
		ps.setString(9, billing_Meters.getConnectionDate());
		ps.setString(10, billing_Meters.getLatestReadingDate());
		ps.setString(11, billing_Meters.getDateDisconnected());
		ps.setString(12, billing_Meters.getDateTransfered());
		ps.setString(13, billing_Meters.getcreated_at());
		ps.setString(14, billing_Meters.getupdated_at());
		ps.setString(15, billing_Meters.getInitialReading());
		ps.setString(16, billing_Meters.getLatestReading());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_Meters billing_Meters, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_Meters SET ServiceAccountId=?, SerialNumber=?, SealNumber=?, Brand=?, Model=?, Multiplier=?, Status=?, ConnectionDate=?, LatestReadingDate=?, DateDisconnected=?, DateTransfered=?, created_at=?, updated_at=?, InitialReading=?, LatestReading=?  WHERE id=? ");
		ps.setString(1, billing_Meters.getServiceAccountId());
		ps.setString(2, billing_Meters.getSerialNumber());
		ps.setString(3, billing_Meters.getSealNumber());
		ps.setString(4, billing_Meters.getBrand());
		ps.setString(5, billing_Meters.getModel());
		ps.setString(6, billing_Meters.getMultiplier());
		ps.setString(7, billing_Meters.getStatus());
		ps.setString(8, billing_Meters.getConnectionDate());
		ps.setString(9, billing_Meters.getLatestReadingDate());
		ps.setString(10, billing_Meters.getDateDisconnected());
		ps.setString(11, billing_Meters.getDateTransfered());
		ps.setString(12, billing_Meters.getcreated_at());
		ps.setString(13, billing_Meters.getupdated_at());
		ps.setString(14, billing_Meters.getInitialReading());
		ps.setString(15, billing_Meters.getLatestReading());
		ps.setString(16, billing_Meters.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_Meters getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Meters WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_Meters billing_Meters = new Billing_Meters(
			rs.getString("id"),
			rs.getString("ServiceAccountId"),
			rs.getString("SerialNumber"),
			rs.getString("SealNumber"),
			rs.getString("Brand"),
			rs.getString("Model"),
			rs.getString("Multiplier"),
			rs.getString("Status"),
			rs.getString("ConnectionDate"),
			rs.getString("LatestReadingDate"),
			rs.getString("DateDisconnected"),
			rs.getString("DateTransfered"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("InitialReading"),
			rs.getString("LatestReading")
			);
			ps.close();
			rs.close();
			return billing_Meters;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_Meters> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Meters WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_Meters> billing_MetersList = new ArrayList<>();
		while(rs.next()) {
			Billing_Meters billing_Meters = new Billing_Meters();
			billing_Meters.setid(rs.getString("id"));
			billing_Meters.setServiceAccountId(rs.getString("ServiceAccountId"));
			billing_Meters.setSerialNumber(rs.getString("SerialNumber"));
			billing_Meters.setSealNumber(rs.getString("SealNumber"));
			billing_Meters.setBrand(rs.getString("Brand"));
			billing_Meters.setModel(rs.getString("Model"));
			billing_Meters.setMultiplier(rs.getString("Multiplier"));
			billing_Meters.setStatus(rs.getString("Status"));
			billing_Meters.setConnectionDate(rs.getString("ConnectionDate"));
			billing_Meters.setLatestReadingDate(rs.getString("LatestReadingDate"));
			billing_Meters.setDateDisconnected(rs.getString("DateDisconnected"));
			billing_Meters.setDateTransfered(rs.getString("DateTransfered"));
			billing_Meters.setcreated_at(rs.getString("created_at"));
			billing_Meters.setupdated_at(rs.getString("updated_at"));
			billing_Meters.setInitialReading(rs.getString("InitialReading"));
			billing_Meters.setLatestReading(rs.getString("LatestReading"));
			billing_MetersList.add(billing_Meters);
		}
		rs.close();
		ps.close();
		return billing_MetersList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_Meters> billing_Billses = Billing_MetersDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_Meters to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_Meters bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_Meters bill = Billing_MetersDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_Meters has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_MetersDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_Meters updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_MetersDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_Meters inserted";
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
