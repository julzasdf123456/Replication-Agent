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
public class CRM_TownsDAO { 
	public static void insert(CRM_Towns cRM_Towns, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_Towns(id, Town, District, Station, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_Towns.getid());
		ps.setString(2, cRM_Towns.getTown());
		ps.setString(3, cRM_Towns.getDistrict());
		ps.setString(4, cRM_Towns.getStation());
		ps.setString(5, cRM_Towns.getcreated_at());
		ps.setString(6, cRM_Towns.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_Towns cRM_Towns, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_Towns SET Town=?, District=?, Station=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_Towns.getTown());
		ps.setString(2, cRM_Towns.getDistrict());
		ps.setString(3, cRM_Towns.getStation());
		ps.setString(4, cRM_Towns.getcreated_at());
		ps.setString(5, cRM_Towns.getupdated_at());
		ps.setString(6, cRM_Towns.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_Towns getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_Towns WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_Towns cRM_Towns = new CRM_Towns(
			rs.getString("id"),
			rs.getString("Town"),
			rs.getString("District"),
			rs.getString("Station"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_Towns;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_Towns> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_Towns WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_Towns> cRM_TownsList = new ArrayList<>();
		while(rs.next()) {
			CRM_Towns cRM_Towns = new CRM_Towns();
			cRM_Towns.setid(rs.getString("id"));
			cRM_Towns.setTown(rs.getString("Town"));
			cRM_Towns.setDistrict(rs.getString("District"));
			cRM_Towns.setStation(rs.getString("Station"));
			cRM_Towns.setcreated_at(rs.getString("created_at"));
			cRM_Towns.setupdated_at(rs.getString("updated_at"));
			cRM_TownsList.add(cRM_Towns);
		}
		rs.close();
		ps.close();
		return cRM_TownsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_Towns> billing_Billses = CRM_TownsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_Towns to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_Towns bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_Towns bill = CRM_TownsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_Towns has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_TownsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_Towns updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_TownsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_Towns inserted";
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
