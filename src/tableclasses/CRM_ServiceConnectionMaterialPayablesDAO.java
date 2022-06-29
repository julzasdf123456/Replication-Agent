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
public class CRM_ServiceConnectionMaterialPayablesDAO { 
	public static void insert(CRM_ServiceConnectionMaterialPayables cRM_ServiceConnectionMaterialPayables, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionMaterialPayables(id, Material, Rate, Description, VatPercentage, Notes, created_at, updated_at, BuildingType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionMaterialPayables.getid());
		ps.setString(2, cRM_ServiceConnectionMaterialPayables.getMaterial());
		ps.setString(3, cRM_ServiceConnectionMaterialPayables.getRate());
		ps.setString(4, cRM_ServiceConnectionMaterialPayables.getDescription());
		ps.setString(5, cRM_ServiceConnectionMaterialPayables.getVatPercentage());
		ps.setString(6, cRM_ServiceConnectionMaterialPayables.getNotes());
		ps.setString(7, cRM_ServiceConnectionMaterialPayables.getcreated_at());
		ps.setString(8, cRM_ServiceConnectionMaterialPayables.getupdated_at());
		ps.setString(9, cRM_ServiceConnectionMaterialPayables.getBuildingType());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionMaterialPayables cRM_ServiceConnectionMaterialPayables, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionMaterialPayables SET Material=?, Rate=?, Description=?, VatPercentage=?, Notes=?, created_at=?, updated_at=?, BuildingType=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionMaterialPayables.getMaterial());
		ps.setString(2, cRM_ServiceConnectionMaterialPayables.getRate());
		ps.setString(3, cRM_ServiceConnectionMaterialPayables.getDescription());
		ps.setString(4, cRM_ServiceConnectionMaterialPayables.getVatPercentage());
		ps.setString(5, cRM_ServiceConnectionMaterialPayables.getNotes());
		ps.setString(6, cRM_ServiceConnectionMaterialPayables.getcreated_at());
		ps.setString(7, cRM_ServiceConnectionMaterialPayables.getupdated_at());
		ps.setString(8, cRM_ServiceConnectionMaterialPayables.getBuildingType());
		ps.setString(9, cRM_ServiceConnectionMaterialPayables.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionMaterialPayables getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionMaterialPayables WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionMaterialPayables cRM_ServiceConnectionMaterialPayables = new CRM_ServiceConnectionMaterialPayables(
			rs.getString("id"),
			rs.getString("Material"),
			rs.getString("Rate"),
			rs.getString("Description"),
			rs.getString("VatPercentage"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("BuildingType")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionMaterialPayables;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionMaterialPayables> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionMaterialPayables WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionMaterialPayables> cRM_ServiceConnectionMaterialPayablesList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionMaterialPayables cRM_ServiceConnectionMaterialPayables = new CRM_ServiceConnectionMaterialPayables();
			cRM_ServiceConnectionMaterialPayables.setid(rs.getString("id"));
			cRM_ServiceConnectionMaterialPayables.setMaterial(rs.getString("Material"));
			cRM_ServiceConnectionMaterialPayables.setRate(rs.getString("Rate"));
			cRM_ServiceConnectionMaterialPayables.setDescription(rs.getString("Description"));
			cRM_ServiceConnectionMaterialPayables.setVatPercentage(rs.getString("VatPercentage"));
			cRM_ServiceConnectionMaterialPayables.setNotes(rs.getString("Notes"));
			cRM_ServiceConnectionMaterialPayables.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionMaterialPayables.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionMaterialPayables.setBuildingType(rs.getString("BuildingType"));
			cRM_ServiceConnectionMaterialPayablesList.add(cRM_ServiceConnectionMaterialPayables);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionMaterialPayablesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionMaterialPayables> billing_Billses = CRM_ServiceConnectionMaterialPayablesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionMaterialPayables to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionMaterialPayables bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionMaterialPayables bill = CRM_ServiceConnectionMaterialPayablesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionMaterialPayables has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionMaterialPayablesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionMaterialPayables updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionMaterialPayablesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionMaterialPayables inserted";
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
