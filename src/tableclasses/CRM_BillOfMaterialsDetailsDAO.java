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
public class CRM_BillOfMaterialsDetailsDAO { 
	public static void insert(CRM_BillOfMaterialsDetails cRM_BillOfMaterialsDetails, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_BillOfMaterialsDetails(id, BillOfMaterialsId, NeaCode, Description, Rate, Quantity, Amount, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_BillOfMaterialsDetails.getid());
		ps.setString(2, cRM_BillOfMaterialsDetails.getBillOfMaterialsId());
		ps.setString(3, cRM_BillOfMaterialsDetails.getNeaCode());
		ps.setString(4, cRM_BillOfMaterialsDetails.getDescription());
		ps.setString(5, cRM_BillOfMaterialsDetails.getRate());
		ps.setString(6, cRM_BillOfMaterialsDetails.getQuantity());
		ps.setString(7, cRM_BillOfMaterialsDetails.getAmount());
		ps.setString(8, cRM_BillOfMaterialsDetails.getcreated_at());
		ps.setString(9, cRM_BillOfMaterialsDetails.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_BillOfMaterialsDetails cRM_BillOfMaterialsDetails, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_BillOfMaterialsDetails SET BillOfMaterialsId=?, NeaCode=?, Description=?, Rate=?, Quantity=?, Amount=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_BillOfMaterialsDetails.getBillOfMaterialsId());
		ps.setString(2, cRM_BillOfMaterialsDetails.getNeaCode());
		ps.setString(3, cRM_BillOfMaterialsDetails.getDescription());
		ps.setString(4, cRM_BillOfMaterialsDetails.getRate());
		ps.setString(5, cRM_BillOfMaterialsDetails.getQuantity());
		ps.setString(6, cRM_BillOfMaterialsDetails.getAmount());
		ps.setString(7, cRM_BillOfMaterialsDetails.getcreated_at());
		ps.setString(8, cRM_BillOfMaterialsDetails.getupdated_at());
		ps.setString(9, cRM_BillOfMaterialsDetails.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_BillOfMaterialsDetails getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_BillOfMaterialsDetails WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_BillOfMaterialsDetails cRM_BillOfMaterialsDetails = new CRM_BillOfMaterialsDetails(
			rs.getString("id"),
			rs.getString("BillOfMaterialsId"),
			rs.getString("NeaCode"),
			rs.getString("Description"),
			rs.getString("Rate"),
			rs.getString("Quantity"),
			rs.getString("Amount"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_BillOfMaterialsDetails;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_BillOfMaterialsDetails> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_BillOfMaterialsDetails WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_BillOfMaterialsDetails> cRM_BillOfMaterialsDetailsList = new ArrayList<>();
		while(rs.next()) {
			CRM_BillOfMaterialsDetails cRM_BillOfMaterialsDetails = new CRM_BillOfMaterialsDetails();
			cRM_BillOfMaterialsDetails.setid(rs.getString("id"));
			cRM_BillOfMaterialsDetails.setBillOfMaterialsId(rs.getString("BillOfMaterialsId"));
			cRM_BillOfMaterialsDetails.setNeaCode(rs.getString("NeaCode"));
			cRM_BillOfMaterialsDetails.setDescription(rs.getString("Description"));
			cRM_BillOfMaterialsDetails.setRate(rs.getString("Rate"));
			cRM_BillOfMaterialsDetails.setQuantity(rs.getString("Quantity"));
			cRM_BillOfMaterialsDetails.setAmount(rs.getString("Amount"));
			cRM_BillOfMaterialsDetails.setcreated_at(rs.getString("created_at"));
			cRM_BillOfMaterialsDetails.setupdated_at(rs.getString("updated_at"));
			cRM_BillOfMaterialsDetailsList.add(cRM_BillOfMaterialsDetails);
		}
		rs.close();
		ps.close();
		return cRM_BillOfMaterialsDetailsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_BillOfMaterialsDetails> billing_Billses = CRM_BillOfMaterialsDetailsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_BillOfMaterialsDetails to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_BillOfMaterialsDetails bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_BillOfMaterialsDetails bill = CRM_BillOfMaterialsDetailsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_BillOfMaterialsDetails has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_BillOfMaterialsDetailsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_BillOfMaterialsDetails updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_BillOfMaterialsDetailsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_BillOfMaterialsDetails inserted";
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
