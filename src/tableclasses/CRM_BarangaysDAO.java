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
public class CRM_BarangaysDAO { 
	public static void insert(CRM_Barangays cRM_Barangays, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_Barangays(id, Barangay, TownId, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_Barangays.getid());
		ps.setString(2, cRM_Barangays.getBarangay());
		ps.setString(3, cRM_Barangays.getTownId());
		ps.setString(4, cRM_Barangays.getNotes());
		ps.setString(5, cRM_Barangays.getcreated_at());
		ps.setString(6, cRM_Barangays.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_Barangays cRM_Barangays, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_Barangays SET Barangay=?, TownId=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_Barangays.getBarangay());
		ps.setString(2, cRM_Barangays.getTownId());
		ps.setString(3, cRM_Barangays.getNotes());
		ps.setString(4, cRM_Barangays.getcreated_at());
		ps.setString(5, cRM_Barangays.getupdated_at());
		ps.setString(6, cRM_Barangays.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_Barangays getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_Barangays WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_Barangays cRM_Barangays = new CRM_Barangays(
			rs.getString("id"),
			rs.getString("Barangay"),
			rs.getString("TownId"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_Barangays;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_Barangays> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_Barangays WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_Barangays> cRM_BarangaysList = new ArrayList<>();
		while(rs.next()) {
			CRM_Barangays cRM_Barangays = new CRM_Barangays();
			cRM_Barangays.setid(rs.getString("id"));
			cRM_Barangays.setBarangay(rs.getString("Barangay"));
			cRM_Barangays.setTownId(rs.getString("TownId"));
			cRM_Barangays.setNotes(rs.getString("Notes"));
			cRM_Barangays.setcreated_at(rs.getString("created_at"));
			cRM_Barangays.setupdated_at(rs.getString("updated_at"));
			cRM_BarangaysList.add(cRM_Barangays);
		}
		rs.close();
		ps.close();
		return cRM_BarangaysList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_Barangays> billing_Billses = CRM_BarangaysDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_Barangays to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_Barangays bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_Barangays bill = CRM_BarangaysDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_Barangays has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_BarangaysDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_Barangays updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_BarangaysDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_Barangays inserted";
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
