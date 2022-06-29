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
public class Billing_KwhSalesDAO { 
	public static void insert(Billing_KwhSales billing_KwhSales, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_KwhSales(id, ServicePeriod, Town, BilledKwh, ConsumedKwh, NoOfConsumers, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_KwhSales.getid());
		ps.setString(2, billing_KwhSales.getServicePeriod());
		ps.setString(3, billing_KwhSales.getTown());
		ps.setString(4, billing_KwhSales.getBilledKwh());
		ps.setString(5, billing_KwhSales.getConsumedKwh());
		ps.setString(6, billing_KwhSales.getNoOfConsumers());
		ps.setString(7, billing_KwhSales.getNotes());
		ps.setString(8, billing_KwhSales.getcreated_at());
		ps.setString(9, billing_KwhSales.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_KwhSales billing_KwhSales, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_KwhSales SET ServicePeriod=?, Town=?, BilledKwh=?, ConsumedKwh=?, NoOfConsumers=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, billing_KwhSales.getServicePeriod());
		ps.setString(2, billing_KwhSales.getTown());
		ps.setString(3, billing_KwhSales.getBilledKwh());
		ps.setString(4, billing_KwhSales.getConsumedKwh());
		ps.setString(5, billing_KwhSales.getNoOfConsumers());
		ps.setString(6, billing_KwhSales.getNotes());
		ps.setString(7, billing_KwhSales.getcreated_at());
		ps.setString(8, billing_KwhSales.getupdated_at());
		ps.setString(9, billing_KwhSales.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_KwhSales getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_KwhSales WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_KwhSales billing_KwhSales = new Billing_KwhSales(
			rs.getString("id"),
			rs.getString("ServicePeriod"),
			rs.getString("Town"),
			rs.getString("BilledKwh"),
			rs.getString("ConsumedKwh"),
			rs.getString("NoOfConsumers"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return billing_KwhSales;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_KwhSales> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_KwhSales WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_KwhSales> billing_KwhSalesList = new ArrayList<>();
		while(rs.next()) {
			Billing_KwhSales billing_KwhSales = new Billing_KwhSales();
			billing_KwhSales.setid(rs.getString("id"));
			billing_KwhSales.setServicePeriod(rs.getString("ServicePeriod"));
			billing_KwhSales.setTown(rs.getString("Town"));
			billing_KwhSales.setBilledKwh(rs.getString("BilledKwh"));
			billing_KwhSales.setConsumedKwh(rs.getString("ConsumedKwh"));
			billing_KwhSales.setNoOfConsumers(rs.getString("NoOfConsumers"));
			billing_KwhSales.setNotes(rs.getString("Notes"));
			billing_KwhSales.setcreated_at(rs.getString("created_at"));
			billing_KwhSales.setupdated_at(rs.getString("updated_at"));
			billing_KwhSalesList.add(billing_KwhSales);
		}
		rs.close();
		ps.close();
		return billing_KwhSalesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_KwhSales> billing_Billses = Billing_KwhSalesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_KwhSales to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_KwhSales bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_KwhSales bill = Billing_KwhSalesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_KwhSales has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_KwhSalesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_KwhSales updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_KwhSalesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_KwhSales inserted";
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
