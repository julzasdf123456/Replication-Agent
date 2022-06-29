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
public class CRM_BillOfMaterialsMatrixDAO { 
	public static void insert(CRM_BillOfMaterialsMatrix cRM_BillOfMaterialsMatrix, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_BillOfMaterialsMatrix(id, ServiceConnectionId, StructureAssigningId, StructureId, MaterialsId, Quantity, created_at, updated_at, StructureType, Amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_BillOfMaterialsMatrix.getid());
		ps.setString(2, cRM_BillOfMaterialsMatrix.getServiceConnectionId());
		ps.setString(3, cRM_BillOfMaterialsMatrix.getStructureAssigningId());
		ps.setString(4, cRM_BillOfMaterialsMatrix.getStructureId());
		ps.setString(5, cRM_BillOfMaterialsMatrix.getMaterialsId());
		ps.setString(6, cRM_BillOfMaterialsMatrix.getQuantity());
		ps.setString(7, cRM_BillOfMaterialsMatrix.getcreated_at());
		ps.setString(8, cRM_BillOfMaterialsMatrix.getupdated_at());
		ps.setString(9, cRM_BillOfMaterialsMatrix.getStructureType());
		ps.setString(10, cRM_BillOfMaterialsMatrix.getAmount());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_BillOfMaterialsMatrix cRM_BillOfMaterialsMatrix, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_BillOfMaterialsMatrix SET ServiceConnectionId=?, StructureAssigningId=?, StructureId=?, MaterialsId=?, Quantity=?, created_at=?, updated_at=?, StructureType=?, Amount=?  WHERE id=? ");
		ps.setString(1, cRM_BillOfMaterialsMatrix.getServiceConnectionId());
		ps.setString(2, cRM_BillOfMaterialsMatrix.getStructureAssigningId());
		ps.setString(3, cRM_BillOfMaterialsMatrix.getStructureId());
		ps.setString(4, cRM_BillOfMaterialsMatrix.getMaterialsId());
		ps.setString(5, cRM_BillOfMaterialsMatrix.getQuantity());
		ps.setString(6, cRM_BillOfMaterialsMatrix.getcreated_at());
		ps.setString(7, cRM_BillOfMaterialsMatrix.getupdated_at());
		ps.setString(8, cRM_BillOfMaterialsMatrix.getStructureType());
		ps.setString(9, cRM_BillOfMaterialsMatrix.getAmount());
		ps.setString(10, cRM_BillOfMaterialsMatrix.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_BillOfMaterialsMatrix getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_BillOfMaterialsMatrix WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_BillOfMaterialsMatrix cRM_BillOfMaterialsMatrix = new CRM_BillOfMaterialsMatrix(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("StructureAssigningId"),
			rs.getString("StructureId"),
			rs.getString("MaterialsId"),
			rs.getString("Quantity"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("StructureType"),
			rs.getString("Amount")
			);
			ps.close();
			rs.close();
			return cRM_BillOfMaterialsMatrix;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_BillOfMaterialsMatrix> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_BillOfMaterialsMatrix WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_BillOfMaterialsMatrix> cRM_BillOfMaterialsMatrixList = new ArrayList<>();
		while(rs.next()) {
			CRM_BillOfMaterialsMatrix cRM_BillOfMaterialsMatrix = new CRM_BillOfMaterialsMatrix();
			cRM_BillOfMaterialsMatrix.setid(rs.getString("id"));
			cRM_BillOfMaterialsMatrix.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_BillOfMaterialsMatrix.setStructureAssigningId(rs.getString("StructureAssigningId"));
			cRM_BillOfMaterialsMatrix.setStructureId(rs.getString("StructureId"));
			cRM_BillOfMaterialsMatrix.setMaterialsId(rs.getString("MaterialsId"));
			cRM_BillOfMaterialsMatrix.setQuantity(rs.getString("Quantity"));
			cRM_BillOfMaterialsMatrix.setcreated_at(rs.getString("created_at"));
			cRM_BillOfMaterialsMatrix.setupdated_at(rs.getString("updated_at"));
			cRM_BillOfMaterialsMatrix.setStructureType(rs.getString("StructureType"));
			cRM_BillOfMaterialsMatrix.setAmount(rs.getString("Amount"));
			cRM_BillOfMaterialsMatrixList.add(cRM_BillOfMaterialsMatrix);
		}
		rs.close();
		ps.close();
		return cRM_BillOfMaterialsMatrixList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_BillOfMaterialsMatrix> billing_Billses = CRM_BillOfMaterialsMatrixDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_BillOfMaterialsMatrix to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_BillOfMaterialsMatrix bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_BillOfMaterialsMatrix bill = CRM_BillOfMaterialsMatrixDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_BillOfMaterialsMatrix has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_BillOfMaterialsMatrixDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_BillOfMaterialsMatrix updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_BillOfMaterialsMatrixDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_BillOfMaterialsMatrix inserted";
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
