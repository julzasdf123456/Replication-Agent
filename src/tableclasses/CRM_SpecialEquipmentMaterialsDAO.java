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
public class CRM_SpecialEquipmentMaterialsDAO { 
	public static void insert(CRM_SpecialEquipmentMaterials cRM_SpecialEquipmentMaterials, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_SpecialEquipmentMaterials(id, NEACode, created_at, updated_at) VALUES (?, ?, ?, ?)");
		ps.setString(1, cRM_SpecialEquipmentMaterials.getid());
		ps.setString(2, cRM_SpecialEquipmentMaterials.getNEACode());
		ps.setString(3, cRM_SpecialEquipmentMaterials.getcreated_at());
		ps.setString(4, cRM_SpecialEquipmentMaterials.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_SpecialEquipmentMaterials cRM_SpecialEquipmentMaterials, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_SpecialEquipmentMaterials SET NEACode=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_SpecialEquipmentMaterials.getNEACode());
		ps.setString(2, cRM_SpecialEquipmentMaterials.getcreated_at());
		ps.setString(3, cRM_SpecialEquipmentMaterials.getupdated_at());
		ps.setString(4, cRM_SpecialEquipmentMaterials.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_SpecialEquipmentMaterials getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_SpecialEquipmentMaterials WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_SpecialEquipmentMaterials cRM_SpecialEquipmentMaterials = new CRM_SpecialEquipmentMaterials(
			rs.getString("id"),
			rs.getString("NEACode"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_SpecialEquipmentMaterials;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_SpecialEquipmentMaterials> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_SpecialEquipmentMaterials WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_SpecialEquipmentMaterials> cRM_SpecialEquipmentMaterialsList = new ArrayList<>();
		while(rs.next()) {
			CRM_SpecialEquipmentMaterials cRM_SpecialEquipmentMaterials = new CRM_SpecialEquipmentMaterials();
			cRM_SpecialEquipmentMaterials.setid(rs.getString("id"));
			cRM_SpecialEquipmentMaterials.setNEACode(rs.getString("NEACode"));
			cRM_SpecialEquipmentMaterials.setcreated_at(rs.getString("created_at"));
			cRM_SpecialEquipmentMaterials.setupdated_at(rs.getString("updated_at"));
			cRM_SpecialEquipmentMaterialsList.add(cRM_SpecialEquipmentMaterials);
		}
		rs.close();
		ps.close();
		return cRM_SpecialEquipmentMaterialsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_SpecialEquipmentMaterials> billing_Billses = CRM_SpecialEquipmentMaterialsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_SpecialEquipmentMaterials to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_SpecialEquipmentMaterials bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_SpecialEquipmentMaterials bill = CRM_SpecialEquipmentMaterialsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_SpecialEquipmentMaterials has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_SpecialEquipmentMaterialsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_SpecialEquipmentMaterials updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_SpecialEquipmentMaterialsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_SpecialEquipmentMaterials inserted";
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
