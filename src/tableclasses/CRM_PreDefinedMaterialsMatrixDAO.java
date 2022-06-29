package tableclasses;

import db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import others.ObjectHelpers;
import replicationagent.MainFrame;
public class CRM_PreDefinedMaterialsMatrixDAO { 
	public static void insert(CRM_PreDefinedMaterialsMatrix cRM_PreDefinedMaterialsMatrix, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_PreDefinedMaterialsMatrix(id, ServiceConnectionId, NEACode, Description, Quantity, Options, ApplicationType, Cost, LaborCost, Notes, LaborPercentage, created_at, updated_at, Amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_PreDefinedMaterialsMatrix.getid());
		ps.setString(2, cRM_PreDefinedMaterialsMatrix.getServiceConnectionId());
		ps.setString(3, cRM_PreDefinedMaterialsMatrix.getNEACode());
		ps.setString(4, cRM_PreDefinedMaterialsMatrix.getDescription());
		ps.setString(5, cRM_PreDefinedMaterialsMatrix.getQuantity());
		ps.setString(6, cRM_PreDefinedMaterialsMatrix.getOptions());
		ps.setString(7, cRM_PreDefinedMaterialsMatrix.getApplicationType());
		ps.setString(8, cRM_PreDefinedMaterialsMatrix.getCost());
		ps.setString(9, cRM_PreDefinedMaterialsMatrix.getLaborCost());
		ps.setString(10, cRM_PreDefinedMaterialsMatrix.getNotes());
		ps.setString(11, cRM_PreDefinedMaterialsMatrix.getLaborPercentage());
		ps.setString(12, cRM_PreDefinedMaterialsMatrix.getcreated_at());
		ps.setString(13, cRM_PreDefinedMaterialsMatrix.getupdated_at());
		ps.setString(14, cRM_PreDefinedMaterialsMatrix.getAmount());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_PreDefinedMaterialsMatrix cRM_PreDefinedMaterialsMatrix, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_PreDefinedMaterialsMatrix SET ServiceConnectionId=?, NEACode=?, Description=?, Quantity=?, Options=?, ApplicationType=?, Cost=?, LaborCost=?, Notes=?, LaborPercentage=?, created_at=?, updated_at=?, Amount=?  WHERE id=? ");
		ps.setString(1, cRM_PreDefinedMaterialsMatrix.getServiceConnectionId());
		ps.setString(2, cRM_PreDefinedMaterialsMatrix.getNEACode());
		ps.setString(3, cRM_PreDefinedMaterialsMatrix.getDescription());
		ps.setString(4, cRM_PreDefinedMaterialsMatrix.getQuantity());
		ps.setString(5, cRM_PreDefinedMaterialsMatrix.getOptions());
		ps.setString(6, cRM_PreDefinedMaterialsMatrix.getApplicationType());
		ps.setString(7, cRM_PreDefinedMaterialsMatrix.getCost());
		ps.setString(8, cRM_PreDefinedMaterialsMatrix.getLaborCost());
		ps.setString(9, cRM_PreDefinedMaterialsMatrix.getNotes());
		ps.setString(10, cRM_PreDefinedMaterialsMatrix.getLaborPercentage());
		ps.setString(11, cRM_PreDefinedMaterialsMatrix.getcreated_at());
		ps.setString(12, cRM_PreDefinedMaterialsMatrix.getupdated_at());
		ps.setString(13, cRM_PreDefinedMaterialsMatrix.getAmount());
		ps.setString(14, cRM_PreDefinedMaterialsMatrix.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_PreDefinedMaterialsMatrix getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_PreDefinedMaterialsMatrix WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_PreDefinedMaterialsMatrix cRM_PreDefinedMaterialsMatrix = new CRM_PreDefinedMaterialsMatrix(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("NEACode"),
			rs.getString("Description"),
			rs.getString("Quantity"),
			rs.getString("Options"),
			rs.getString("ApplicationType"),
			rs.getString("Cost"),
			rs.getString("LaborCost"),
			rs.getString("Notes"),
			rs.getString("LaborPercentage"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Amount")
			);
			ps.close();
			rs.close();
			return cRM_PreDefinedMaterialsMatrix;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_PreDefinedMaterialsMatrix> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_PreDefinedMaterialsMatrix WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_PreDefinedMaterialsMatrix> cRM_PreDefinedMaterialsMatrixList = new ArrayList<>();
		while(rs.next()) {
			CRM_PreDefinedMaterialsMatrix cRM_PreDefinedMaterialsMatrix = new CRM_PreDefinedMaterialsMatrix();
			cRM_PreDefinedMaterialsMatrix.setid(rs.getString("id"));
			cRM_PreDefinedMaterialsMatrix.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_PreDefinedMaterialsMatrix.setNEACode(rs.getString("NEACode"));
			cRM_PreDefinedMaterialsMatrix.setDescription(rs.getString("Description"));
			cRM_PreDefinedMaterialsMatrix.setQuantity(rs.getString("Quantity"));
			cRM_PreDefinedMaterialsMatrix.setOptions(rs.getString("Options"));
			cRM_PreDefinedMaterialsMatrix.setApplicationType(rs.getString("ApplicationType"));
			cRM_PreDefinedMaterialsMatrix.setCost(rs.getString("Cost"));
			cRM_PreDefinedMaterialsMatrix.setLaborCost(rs.getString("LaborCost"));
			cRM_PreDefinedMaterialsMatrix.setNotes(rs.getString("Notes"));
			cRM_PreDefinedMaterialsMatrix.setLaborPercentage(rs.getString("LaborPercentage"));
			cRM_PreDefinedMaterialsMatrix.setcreated_at(rs.getString("created_at"));
			cRM_PreDefinedMaterialsMatrix.setupdated_at(rs.getString("updated_at"));
			cRM_PreDefinedMaterialsMatrix.setAmount(rs.getString("Amount"));
			cRM_PreDefinedMaterialsMatrixList.add(cRM_PreDefinedMaterialsMatrix);
		}
		rs.close();
		ps.close();
		return cRM_PreDefinedMaterialsMatrixList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_PreDefinedMaterialsMatrix> billing_Billses = CRM_PreDefinedMaterialsMatrixDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_PreDefinedMaterialsMatrix to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_PreDefinedMaterialsMatrix bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_PreDefinedMaterialsMatrix bill = CRM_PreDefinedMaterialsMatrixDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_PreDefinedMaterialsMatrix has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_PreDefinedMaterialsMatrixDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_PreDefinedMaterialsMatrix updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_PreDefinedMaterialsMatrixDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_PreDefinedMaterialsMatrix inserted";
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
