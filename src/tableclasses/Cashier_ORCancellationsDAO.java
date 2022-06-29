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
public class Cashier_ORCancellationsDAO { 
	public static void insert(Cashier_ORCancellations cashier_ORCancellations, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_ORCancellations(id, ORNumber, ORDate, From, ObjectId, DateTimeFiled, DateTimeApproved, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_ORCancellations.getid());
		ps.setString(2, cashier_ORCancellations.getORNumber());
		ps.setString(3, cashier_ORCancellations.getORDate());
		ps.setString(4, cashier_ORCancellations.getFrom());
		ps.setString(5, cashier_ORCancellations.getObjectId());
		ps.setString(6, cashier_ORCancellations.getDateTimeFiled());
		ps.setString(7, cashier_ORCancellations.getDateTimeApproved());
		ps.setString(8, cashier_ORCancellations.getcreated_at());
		ps.setString(9, cashier_ORCancellations.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_ORCancellations cashier_ORCancellations, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_ORCancellations SET ORNumber=?, ORDate=?, From=?, ObjectId=?, DateTimeFiled=?, DateTimeApproved=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cashier_ORCancellations.getORNumber());
		ps.setString(2, cashier_ORCancellations.getORDate());
		ps.setString(3, cashier_ORCancellations.getFrom());
		ps.setString(4, cashier_ORCancellations.getObjectId());
		ps.setString(5, cashier_ORCancellations.getDateTimeFiled());
		ps.setString(6, cashier_ORCancellations.getDateTimeApproved());
		ps.setString(7, cashier_ORCancellations.getcreated_at());
		ps.setString(8, cashier_ORCancellations.getupdated_at());
		ps.setString(9, cashier_ORCancellations.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_ORCancellations getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_ORCancellations WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_ORCancellations cashier_ORCancellations = new Cashier_ORCancellations(
			rs.getString("id"),
			rs.getString("ORNumber"),
			rs.getString("ORDate"),
			rs.getString("From"),
			rs.getString("ObjectId"),
			rs.getString("DateTimeFiled"),
			rs.getString("DateTimeApproved"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cashier_ORCancellations;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_ORCancellations> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_ORCancellations WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_ORCancellations> cashier_ORCancellationsList = new ArrayList<>();
		while(rs.next()) {
			Cashier_ORCancellations cashier_ORCancellations = new Cashier_ORCancellations();
			cashier_ORCancellations.setid(rs.getString("id"));
			cashier_ORCancellations.setORNumber(rs.getString("ORNumber"));
			cashier_ORCancellations.setORDate(rs.getString("ORDate"));
			cashier_ORCancellations.setFrom(rs.getString("From"));
			cashier_ORCancellations.setObjectId(rs.getString("ObjectId"));
			cashier_ORCancellations.setDateTimeFiled(rs.getString("DateTimeFiled"));
			cashier_ORCancellations.setDateTimeApproved(rs.getString("DateTimeApproved"));
			cashier_ORCancellations.setcreated_at(rs.getString("created_at"));
			cashier_ORCancellations.setupdated_at(rs.getString("updated_at"));
			cashier_ORCancellationsList.add(cashier_ORCancellations);
		}
		rs.close();
		ps.close();
		return cashier_ORCancellationsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_ORCancellations> billing_Billses = Cashier_ORCancellationsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_ORCancellations to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_ORCancellations bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_ORCancellations bill = Cashier_ORCancellationsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_ORCancellations has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_ORCancellationsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_ORCancellations updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_ORCancellationsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_ORCancellations inserted";
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
