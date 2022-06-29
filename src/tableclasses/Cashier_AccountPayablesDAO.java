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
public class Cashier_AccountPayablesDAO { 
	public static void insert(Cashier_AccountPayables cashier_AccountPayables, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_AccountPayables(id, AccountCode, AccountTitle, AccountDescription, DefaultAmount, VATPercentage, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_AccountPayables.getid());
		ps.setString(2, cashier_AccountPayables.getAccountCode());
		ps.setString(3, cashier_AccountPayables.getAccountTitle());
		ps.setString(4, cashier_AccountPayables.getAccountDescription());
		ps.setString(5, cashier_AccountPayables.getDefaultAmount());
		ps.setString(6, cashier_AccountPayables.getVATPercentage());
		ps.setString(7, cashier_AccountPayables.getNotes());
		ps.setString(8, cashier_AccountPayables.getcreated_at());
		ps.setString(9, cashier_AccountPayables.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_AccountPayables cashier_AccountPayables, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_AccountPayables SET AccountCode=?, AccountTitle=?, AccountDescription=?, DefaultAmount=?, VATPercentage=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cashier_AccountPayables.getAccountCode());
		ps.setString(2, cashier_AccountPayables.getAccountTitle());
		ps.setString(3, cashier_AccountPayables.getAccountDescription());
		ps.setString(4, cashier_AccountPayables.getDefaultAmount());
		ps.setString(5, cashier_AccountPayables.getVATPercentage());
		ps.setString(6, cashier_AccountPayables.getNotes());
		ps.setString(7, cashier_AccountPayables.getcreated_at());
		ps.setString(8, cashier_AccountPayables.getupdated_at());
		ps.setString(9, cashier_AccountPayables.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_AccountPayables getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_AccountPayables WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_AccountPayables cashier_AccountPayables = new Cashier_AccountPayables(
			rs.getString("id"),
			rs.getString("AccountCode"),
			rs.getString("AccountTitle"),
			rs.getString("AccountDescription"),
			rs.getString("DefaultAmount"),
			rs.getString("VATPercentage"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cashier_AccountPayables;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_AccountPayables> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_AccountPayables WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_AccountPayables> cashier_AccountPayablesList = new ArrayList<>();
		while(rs.next()) {
			Cashier_AccountPayables cashier_AccountPayables = new Cashier_AccountPayables();
			cashier_AccountPayables.setid(rs.getString("id"));
			cashier_AccountPayables.setAccountCode(rs.getString("AccountCode"));
			cashier_AccountPayables.setAccountTitle(rs.getString("AccountTitle"));
			cashier_AccountPayables.setAccountDescription(rs.getString("AccountDescription"));
			cashier_AccountPayables.setDefaultAmount(rs.getString("DefaultAmount"));
			cashier_AccountPayables.setVATPercentage(rs.getString("VATPercentage"));
			cashier_AccountPayables.setNotes(rs.getString("Notes"));
			cashier_AccountPayables.setcreated_at(rs.getString("created_at"));
			cashier_AccountPayables.setupdated_at(rs.getString("updated_at"));
			cashier_AccountPayablesList.add(cashier_AccountPayables);
		}
		rs.close();
		ps.close();
		return cashier_AccountPayablesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_AccountPayables> billing_Billses = Cashier_AccountPayablesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_AccountPayables to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_AccountPayables bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_AccountPayables bill = Cashier_AccountPayablesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_AccountPayables has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_AccountPayablesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_AccountPayables updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_AccountPayablesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_AccountPayables inserted";
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
