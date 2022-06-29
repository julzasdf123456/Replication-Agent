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
public class Billing_CollectiblesDAO { 
	public static void insert(Billing_Collectibles billing_Collectibles, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_Collectibles(id, AccountNumber, Balance, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_Collectibles.getid());
		ps.setString(2, billing_Collectibles.getAccountNumber());
		ps.setString(3, billing_Collectibles.getBalance());
		ps.setString(4, billing_Collectibles.getNotes());
		ps.setString(5, billing_Collectibles.getcreated_at());
		ps.setString(6, billing_Collectibles.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_Collectibles billing_Collectibles, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_Collectibles SET AccountNumber=?, Balance=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, billing_Collectibles.getAccountNumber());
		ps.setString(2, billing_Collectibles.getBalance());
		ps.setString(3, billing_Collectibles.getNotes());
		ps.setString(4, billing_Collectibles.getcreated_at());
		ps.setString(5, billing_Collectibles.getupdated_at());
		ps.setString(6, billing_Collectibles.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_Collectibles getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Collectibles WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_Collectibles billing_Collectibles = new Billing_Collectibles(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("Balance"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return billing_Collectibles;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_Collectibles> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Collectibles WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_Collectibles> billing_CollectiblesList = new ArrayList<>();
		while(rs.next()) {
			Billing_Collectibles billing_Collectibles = new Billing_Collectibles();
			billing_Collectibles.setid(rs.getString("id"));
			billing_Collectibles.setAccountNumber(rs.getString("AccountNumber"));
			billing_Collectibles.setBalance(rs.getString("Balance"));
			billing_Collectibles.setNotes(rs.getString("Notes"));
			billing_Collectibles.setcreated_at(rs.getString("created_at"));
			billing_Collectibles.setupdated_at(rs.getString("updated_at"));
			billing_CollectiblesList.add(billing_Collectibles);
		}
		rs.close();
		ps.close();
		return billing_CollectiblesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_Collectibles> billing_Billses = Billing_CollectiblesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_Collectibles to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_Collectibles bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_Collectibles bill = Billing_CollectiblesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_Collectibles has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_CollectiblesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_Collectibles updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_CollectiblesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_Collectibles inserted";
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
