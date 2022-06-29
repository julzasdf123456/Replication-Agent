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
public class Disconnection_HistoryDAO { 
	public static void insert(Disconnection_History disconnection_History, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Disconnection_History(id, AccountNumber, ServicePeriod, Latitude, Longitude, BillId, DisconnectionPayment, Status, UserId, Notes, created_at, updated_at, DateDisconnected, TimeDisconnected) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, disconnection_History.getid());
		ps.setString(2, disconnection_History.getAccountNumber());
		ps.setString(3, disconnection_History.getServicePeriod());
		ps.setString(4, disconnection_History.getLatitude());
		ps.setString(5, disconnection_History.getLongitude());
		ps.setString(6, disconnection_History.getBillId());
		ps.setString(7, disconnection_History.getDisconnectionPayment());
		ps.setString(8, disconnection_History.getStatus());
		ps.setString(9, disconnection_History.getUserId());
		ps.setString(10, disconnection_History.getNotes());
		ps.setString(11, disconnection_History.getcreated_at());
		ps.setString(12, disconnection_History.getupdated_at());
		ps.setString(13, disconnection_History.getDateDisconnected());
		ps.setString(14, disconnection_History.getTimeDisconnected());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Disconnection_History disconnection_History, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Disconnection_History SET AccountNumber=?, ServicePeriod=?, Latitude=?, Longitude=?, BillId=?, DisconnectionPayment=?, Status=?, UserId=?, Notes=?, created_at=?, updated_at=?, DateDisconnected=?, TimeDisconnected=?  WHERE id=? ");
		ps.setString(1, disconnection_History.getAccountNumber());
		ps.setString(2, disconnection_History.getServicePeriod());
		ps.setString(3, disconnection_History.getLatitude());
		ps.setString(4, disconnection_History.getLongitude());
		ps.setString(5, disconnection_History.getBillId());
		ps.setString(6, disconnection_History.getDisconnectionPayment());
		ps.setString(7, disconnection_History.getStatus());
		ps.setString(8, disconnection_History.getUserId());
		ps.setString(9, disconnection_History.getNotes());
		ps.setString(10, disconnection_History.getcreated_at());
		ps.setString(11, disconnection_History.getupdated_at());
		ps.setString(12, disconnection_History.getDateDisconnected());
		ps.setString(13, disconnection_History.getTimeDisconnected());
		ps.setString(14, disconnection_History.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Disconnection_History getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Disconnection_History WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Disconnection_History disconnection_History = new Disconnection_History(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("ServicePeriod"),
			rs.getString("Latitude"),
			rs.getString("Longitude"),
			rs.getString("BillId"),
			rs.getString("DisconnectionPayment"),
			rs.getString("Status"),
			rs.getString("UserId"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("DateDisconnected"),
			rs.getString("TimeDisconnected")
			);
			ps.close();
			rs.close();
			return disconnection_History;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Disconnection_History> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Disconnection_History WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Disconnection_History> disconnection_HistoryList = new ArrayList<>();
		while(rs.next()) {
			Disconnection_History disconnection_History = new Disconnection_History();
			disconnection_History.setid(rs.getString("id"));
			disconnection_History.setAccountNumber(rs.getString("AccountNumber"));
			disconnection_History.setServicePeriod(rs.getString("ServicePeriod"));
			disconnection_History.setLatitude(rs.getString("Latitude"));
			disconnection_History.setLongitude(rs.getString("Longitude"));
			disconnection_History.setBillId(rs.getString("BillId"));
			disconnection_History.setDisconnectionPayment(rs.getString("DisconnectionPayment"));
			disconnection_History.setStatus(rs.getString("Status"));
			disconnection_History.setUserId(rs.getString("UserId"));
			disconnection_History.setNotes(rs.getString("Notes"));
			disconnection_History.setcreated_at(rs.getString("created_at"));
			disconnection_History.setupdated_at(rs.getString("updated_at"));
			disconnection_History.setDateDisconnected(rs.getString("DateDisconnected"));
			disconnection_History.setTimeDisconnected(rs.getString("TimeDisconnected"));
			disconnection_HistoryList.add(disconnection_History);
		}
		rs.close();
		ps.close();
		return disconnection_HistoryList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Disconnection_History> billing_Billses = Disconnection_HistoryDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Disconnection_History to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Disconnection_History bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Disconnection_History bill = Disconnection_HistoryDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Disconnection_History has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Disconnection_HistoryDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Disconnection_History updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Disconnection_HistoryDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Disconnection_History inserted";
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
