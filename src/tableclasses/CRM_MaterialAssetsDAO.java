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
public class CRM_MaterialAssetsDAO { 
	public static void insert(CRM_MaterialAssets cRM_MaterialAssets, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_MaterialAssets(id, Description, Amount, created_at, updated_at) VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, cRM_MaterialAssets.getid());
		ps.setString(2, cRM_MaterialAssets.getDescription());
		ps.setString(3, cRM_MaterialAssets.getAmount());
		ps.setString(4, cRM_MaterialAssets.getcreated_at());
		ps.setString(5, cRM_MaterialAssets.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_MaterialAssets cRM_MaterialAssets, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_MaterialAssets SET Description=?, Amount=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_MaterialAssets.getDescription());
		ps.setString(2, cRM_MaterialAssets.getAmount());
		ps.setString(3, cRM_MaterialAssets.getcreated_at());
		ps.setString(4, cRM_MaterialAssets.getupdated_at());
		ps.setString(5, cRM_MaterialAssets.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_MaterialAssets getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MaterialAssets WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_MaterialAssets cRM_MaterialAssets = new CRM_MaterialAssets(
			rs.getString("id"),
			rs.getString("Description"),
			rs.getString("Amount"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_MaterialAssets;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_MaterialAssets> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MaterialAssets WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_MaterialAssets> cRM_MaterialAssetsList = new ArrayList<>();
		while(rs.next()) {
			CRM_MaterialAssets cRM_MaterialAssets = new CRM_MaterialAssets();
			cRM_MaterialAssets.setid(rs.getString("id"));
			cRM_MaterialAssets.setDescription(rs.getString("Description"));
			cRM_MaterialAssets.setAmount(rs.getString("Amount"));
			cRM_MaterialAssets.setcreated_at(rs.getString("created_at"));
			cRM_MaterialAssets.setupdated_at(rs.getString("updated_at"));
			cRM_MaterialAssetsList.add(cRM_MaterialAssets);
		}
		rs.close();
		ps.close();
		return cRM_MaterialAssetsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_MaterialAssets> billing_Billses = CRM_MaterialAssetsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_MaterialAssets to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_MaterialAssets bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_MaterialAssets bill = CRM_MaterialAssetsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_MaterialAssets has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_MaterialAssetsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_MaterialAssets updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_MaterialAssetsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_MaterialAssets inserted";
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
