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
public class Cashier_BanksDAO { 
	public static void insert(Cashier_Banks cashier_Banks, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_Banks(id, BankFullName, BankAbbrev, Address, TIN, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_Banks.getid());
		ps.setString(2, cashier_Banks.getBankFullName());
		ps.setString(3, cashier_Banks.getBankAbbrev());
		ps.setString(4, cashier_Banks.getAddress());
		ps.setString(5, cashier_Banks.getTIN());
		ps.setString(6, cashier_Banks.getcreated_at());
		ps.setString(7, cashier_Banks.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_Banks cashier_Banks, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_Banks SET BankFullName=?, BankAbbrev=?, Address=?, TIN=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cashier_Banks.getBankFullName());
		ps.setString(2, cashier_Banks.getBankAbbrev());
		ps.setString(3, cashier_Banks.getAddress());
		ps.setString(4, cashier_Banks.getTIN());
		ps.setString(5, cashier_Banks.getcreated_at());
		ps.setString(6, cashier_Banks.getupdated_at());
		ps.setString(7, cashier_Banks.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_Banks getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_Banks WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_Banks cashier_Banks = new Cashier_Banks(
			rs.getString("id"),
			rs.getString("BankFullName"),
			rs.getString("BankAbbrev"),
			rs.getString("Address"),
			rs.getString("TIN"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cashier_Banks;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_Banks> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_Banks WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_Banks> cashier_BanksList = new ArrayList<>();
		while(rs.next()) {
			Cashier_Banks cashier_Banks = new Cashier_Banks();
			cashier_Banks.setid(rs.getString("id"));
			cashier_Banks.setBankFullName(rs.getString("BankFullName"));
			cashier_Banks.setBankAbbrev(rs.getString("BankAbbrev"));
			cashier_Banks.setAddress(rs.getString("Address"));
			cashier_Banks.setTIN(rs.getString("TIN"));
			cashier_Banks.setcreated_at(rs.getString("created_at"));
			cashier_Banks.setupdated_at(rs.getString("updated_at"));
			cashier_BanksList.add(cashier_Banks);
		}
		rs.close();
		ps.close();
		return cashier_BanksList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_Banks> billing_Billses = Cashier_BanksDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_Banks to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_Banks bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_Banks bill = Cashier_BanksDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_Banks has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_BanksDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_Banks updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_BanksDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_Banks inserted";
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
