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
public class CRM_PreDefinedMaterialsDAO { 
	public static void insert(CRM_PreDefinedMaterials cRM_PreDefinedMaterials, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_PreDefinedMaterials(id, NEACode, Quantity, Options, ApplicationType, Notes, created_at, updated_at, LaborPercentage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_PreDefinedMaterials.getid());
		ps.setString(2, cRM_PreDefinedMaterials.getNEACode());
		ps.setString(3, cRM_PreDefinedMaterials.getQuantity());
		ps.setString(4, cRM_PreDefinedMaterials.getOptions());
		ps.setString(5, cRM_PreDefinedMaterials.getApplicationType());
		ps.setString(6, cRM_PreDefinedMaterials.getNotes());
		ps.setString(7, cRM_PreDefinedMaterials.getcreated_at());
		ps.setString(8, cRM_PreDefinedMaterials.getupdated_at());
		ps.setString(9, cRM_PreDefinedMaterials.getLaborPercentage());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_PreDefinedMaterials cRM_PreDefinedMaterials, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_PreDefinedMaterials SET NEACode=?, Quantity=?, Options=?, ApplicationType=?, Notes=?, created_at=?, updated_at=?, LaborPercentage=?  WHERE id=? ");
		ps.setString(1, cRM_PreDefinedMaterials.getNEACode());
		ps.setString(2, cRM_PreDefinedMaterials.getQuantity());
		ps.setString(3, cRM_PreDefinedMaterials.getOptions());
		ps.setString(4, cRM_PreDefinedMaterials.getApplicationType());
		ps.setString(5, cRM_PreDefinedMaterials.getNotes());
		ps.setString(6, cRM_PreDefinedMaterials.getcreated_at());
		ps.setString(7, cRM_PreDefinedMaterials.getupdated_at());
		ps.setString(8, cRM_PreDefinedMaterials.getLaborPercentage());
		ps.setString(9, cRM_PreDefinedMaterials.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_PreDefinedMaterials getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_PreDefinedMaterials WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_PreDefinedMaterials cRM_PreDefinedMaterials = new CRM_PreDefinedMaterials(
			rs.getString("id"),
			rs.getString("NEACode"),
			rs.getString("Quantity"),
			rs.getString("Options"),
			rs.getString("ApplicationType"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("LaborPercentage")
			);
			ps.close();
			rs.close();
			return cRM_PreDefinedMaterials;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_PreDefinedMaterials> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_PreDefinedMaterials WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_PreDefinedMaterials> cRM_PreDefinedMaterialsList = new ArrayList<>();
		while(rs.next()) {
			CRM_PreDefinedMaterials cRM_PreDefinedMaterials = new CRM_PreDefinedMaterials();
			cRM_PreDefinedMaterials.setid(rs.getString("id"));
			cRM_PreDefinedMaterials.setNEACode(rs.getString("NEACode"));
			cRM_PreDefinedMaterials.setQuantity(rs.getString("Quantity"));
			cRM_PreDefinedMaterials.setOptions(rs.getString("Options"));
			cRM_PreDefinedMaterials.setApplicationType(rs.getString("ApplicationType"));
			cRM_PreDefinedMaterials.setNotes(rs.getString("Notes"));
			cRM_PreDefinedMaterials.setcreated_at(rs.getString("created_at"));
			cRM_PreDefinedMaterials.setupdated_at(rs.getString("updated_at"));
			cRM_PreDefinedMaterials.setLaborPercentage(rs.getString("LaborPercentage"));
			cRM_PreDefinedMaterialsList.add(cRM_PreDefinedMaterials);
		}
		rs.close();
		ps.close();
		return cRM_PreDefinedMaterialsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_PreDefinedMaterials> billing_Billses = CRM_PreDefinedMaterialsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_PreDefinedMaterials to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_PreDefinedMaterials bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_PreDefinedMaterials bill = CRM_PreDefinedMaterialsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_PreDefinedMaterials has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_PreDefinedMaterialsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_PreDefinedMaterials updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_PreDefinedMaterialsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_PreDefinedMaterials inserted";
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
