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
public class Cashier_AccountGLCodesDAO { 
	public static void insert(Cashier_AccountGLCodes cashier_AccountGLCodes, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_AccountGLCodes(id, AccountCode, NEACode, Status, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_AccountGLCodes.getid());
		ps.setString(2, cashier_AccountGLCodes.getAccountCode());
		ps.setString(3, cashier_AccountGLCodes.getNEACode());
		ps.setString(4, cashier_AccountGLCodes.getStatus());
		ps.setString(5, cashier_AccountGLCodes.getNotes());
		ps.setString(6, cashier_AccountGLCodes.getcreated_at());
		ps.setString(7, cashier_AccountGLCodes.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_AccountGLCodes cashier_AccountGLCodes, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_AccountGLCodes SET AccountCode=?, NEACode=?, Status=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cashier_AccountGLCodes.getAccountCode());
		ps.setString(2, cashier_AccountGLCodes.getNEACode());
		ps.setString(3, cashier_AccountGLCodes.getStatus());
		ps.setString(4, cashier_AccountGLCodes.getNotes());
		ps.setString(5, cashier_AccountGLCodes.getcreated_at());
		ps.setString(6, cashier_AccountGLCodes.getupdated_at());
		ps.setString(7, cashier_AccountGLCodes.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_AccountGLCodes getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_AccountGLCodes WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_AccountGLCodes cashier_AccountGLCodes = new Cashier_AccountGLCodes(
			rs.getString("id"),
			rs.getString("AccountCode"),
			rs.getString("NEACode"),
			rs.getString("Status"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cashier_AccountGLCodes;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_AccountGLCodes> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_AccountGLCodes WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_AccountGLCodes> cashier_AccountGLCodesList = new ArrayList<>();
		while(rs.next()) {
			Cashier_AccountGLCodes cashier_AccountGLCodes = new Cashier_AccountGLCodes();
			cashier_AccountGLCodes.setid(rs.getString("id"));
			cashier_AccountGLCodes.setAccountCode(rs.getString("AccountCode"));
			cashier_AccountGLCodes.setNEACode(rs.getString("NEACode"));
			cashier_AccountGLCodes.setStatus(rs.getString("Status"));
			cashier_AccountGLCodes.setNotes(rs.getString("Notes"));
			cashier_AccountGLCodes.setcreated_at(rs.getString("created_at"));
			cashier_AccountGLCodes.setupdated_at(rs.getString("updated_at"));
			cashier_AccountGLCodesList.add(cashier_AccountGLCodes);
		}
		rs.close();
		ps.close();
		return cashier_AccountGLCodesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_AccountGLCodes> billing_Billses = Cashier_AccountGLCodesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_AccountGLCodes to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_AccountGLCodes bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_AccountGLCodes bill = Cashier_AccountGLCodesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_AccountGLCodes has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_AccountGLCodesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_AccountGLCodes updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_AccountGLCodesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_AccountGLCodes inserted";
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
