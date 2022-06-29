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
public class Cashier_ORAssigningDAO { 
	public static void insert(Cashier_ORAssigning cashier_ORAssigning, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_ORAssigning(id, ORNumber, UserId, DateAssigned, IsSetManually, TimeAssigned, Office, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_ORAssigning.getid());
		ps.setString(2, cashier_ORAssigning.getORNumber());
		ps.setString(3, cashier_ORAssigning.getUserId());
		ps.setString(4, cashier_ORAssigning.getDateAssigned());
		ps.setString(5, cashier_ORAssigning.getIsSetManually());
		ps.setString(6, cashier_ORAssigning.getTimeAssigned());
		ps.setString(7, cashier_ORAssigning.getOffice());
		ps.setString(8, cashier_ORAssigning.getcreated_at());
		ps.setString(9, cashier_ORAssigning.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_ORAssigning cashier_ORAssigning, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_ORAssigning SET ORNumber=?, UserId=?, DateAssigned=?, IsSetManually=?, TimeAssigned=?, Office=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cashier_ORAssigning.getORNumber());
		ps.setString(2, cashier_ORAssigning.getUserId());
		ps.setString(3, cashier_ORAssigning.getDateAssigned());
		ps.setString(4, cashier_ORAssigning.getIsSetManually());
		ps.setString(5, cashier_ORAssigning.getTimeAssigned());
		ps.setString(6, cashier_ORAssigning.getOffice());
		ps.setString(7, cashier_ORAssigning.getcreated_at());
		ps.setString(8, cashier_ORAssigning.getupdated_at());
		ps.setString(9, cashier_ORAssigning.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_ORAssigning getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_ORAssigning WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_ORAssigning cashier_ORAssigning = new Cashier_ORAssigning(
			rs.getString("id"),
			rs.getString("ORNumber"),
			rs.getString("UserId"),
			rs.getString("DateAssigned"),
			rs.getString("IsSetManually"),
			rs.getString("TimeAssigned"),
			rs.getString("Office"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cashier_ORAssigning;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_ORAssigning> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_ORAssigning WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_ORAssigning> cashier_ORAssigningList = new ArrayList<>();
		while(rs.next()) {
			Cashier_ORAssigning cashier_ORAssigning = new Cashier_ORAssigning();
			cashier_ORAssigning.setid(rs.getString("id"));
			cashier_ORAssigning.setORNumber(rs.getString("ORNumber"));
			cashier_ORAssigning.setUserId(rs.getString("UserId"));
			cashier_ORAssigning.setDateAssigned(rs.getString("DateAssigned"));
			cashier_ORAssigning.setIsSetManually(rs.getString("IsSetManually"));
			cashier_ORAssigning.setTimeAssigned(rs.getString("TimeAssigned"));
			cashier_ORAssigning.setOffice(rs.getString("Office"));
			cashier_ORAssigning.setcreated_at(rs.getString("created_at"));
			cashier_ORAssigning.setupdated_at(rs.getString("updated_at"));
			cashier_ORAssigningList.add(cashier_ORAssigning);
		}
		rs.close();
		ps.close();
		return cashier_ORAssigningList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_ORAssigning> billing_Billses = Cashier_ORAssigningDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_ORAssigning to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_ORAssigning bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_ORAssigning bill = Cashier_ORAssigningDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_ORAssigning has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_ORAssigningDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_ORAssigning updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_ORAssigningDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_ORAssigning inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
