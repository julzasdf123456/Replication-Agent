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
public class Billing_ReadingsDAO { 
	public static void insert(Billing_Readings billing_Readings, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_Readings(id, AccountNumber, ServicePeriod, ReadingTimestamp, KwhUsed, DemandKwhUsed, Notes, Latitude, Longitude, created_at, updated_at, FieldStatus, MeterReader) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_Readings.getid());
		ps.setString(2, billing_Readings.getAccountNumber());
		ps.setString(3, billing_Readings.getServicePeriod());
		ps.setString(4, billing_Readings.getReadingTimestamp());
		ps.setString(5, billing_Readings.getKwhUsed());
		ps.setString(6, billing_Readings.getDemandKwhUsed());
		ps.setString(7, billing_Readings.getNotes());
		ps.setString(8, billing_Readings.getLatitude());
		ps.setString(9, billing_Readings.getLongitude());
		ps.setString(10, billing_Readings.getcreated_at());
		ps.setString(11, billing_Readings.getupdated_at());
		ps.setString(12, billing_Readings.getFieldStatus());
		ps.setString(13, billing_Readings.getMeterReader());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_Readings billing_Readings, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_Readings SET AccountNumber=?, ServicePeriod=?, ReadingTimestamp=?, KwhUsed=?, DemandKwhUsed=?, Notes=?, Latitude=?, Longitude=?, created_at=?, updated_at=?, FieldStatus=?, MeterReader=?  WHERE id=? ");
		ps.setString(1, billing_Readings.getAccountNumber());
		ps.setString(2, billing_Readings.getServicePeriod());
		ps.setString(3, billing_Readings.getReadingTimestamp());
		ps.setString(4, billing_Readings.getKwhUsed());
		ps.setString(5, billing_Readings.getDemandKwhUsed());
		ps.setString(6, billing_Readings.getNotes());
		ps.setString(7, billing_Readings.getLatitude());
		ps.setString(8, billing_Readings.getLongitude());
		ps.setString(9, billing_Readings.getcreated_at());
		ps.setString(10, billing_Readings.getupdated_at());
		ps.setString(11, billing_Readings.getFieldStatus());
		ps.setString(12, billing_Readings.getMeterReader());
		ps.setString(13, billing_Readings.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_Readings getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Readings WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_Readings billing_Readings = new Billing_Readings(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("ServicePeriod"),
			rs.getString("ReadingTimestamp"),
			rs.getString("KwhUsed"),
			rs.getString("DemandKwhUsed"),
			rs.getString("Notes"),
			rs.getString("Latitude"),
			rs.getString("Longitude"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("FieldStatus"),
			rs.getString("MeterReader")
			);
			ps.close();
			rs.close();
			return billing_Readings;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_Readings> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Readings WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_Readings> billing_ReadingsList = new ArrayList<>();
		while(rs.next()) {
			Billing_Readings billing_Readings = new Billing_Readings();
			billing_Readings.setid(rs.getString("id"));
			billing_Readings.setAccountNumber(rs.getString("AccountNumber"));
			billing_Readings.setServicePeriod(rs.getString("ServicePeriod"));
			billing_Readings.setReadingTimestamp(rs.getString("ReadingTimestamp"));
			billing_Readings.setKwhUsed(rs.getString("KwhUsed"));
			billing_Readings.setDemandKwhUsed(rs.getString("DemandKwhUsed"));
			billing_Readings.setNotes(rs.getString("Notes"));
			billing_Readings.setLatitude(rs.getString("Latitude"));
			billing_Readings.setLongitude(rs.getString("Longitude"));
			billing_Readings.setcreated_at(rs.getString("created_at"));
			billing_Readings.setupdated_at(rs.getString("updated_at"));
			billing_Readings.setFieldStatus(rs.getString("FieldStatus"));
			billing_Readings.setMeterReader(rs.getString("MeterReader"));
			billing_ReadingsList.add(billing_Readings);
		}
		rs.close();
		ps.close();
		return billing_ReadingsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_Readings> billing_Billses = Billing_ReadingsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_Readings to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_Readings bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_Readings bill = Billing_ReadingsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_Readings has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_ReadingsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_Readings updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_ReadingsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_Readings inserted";
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
