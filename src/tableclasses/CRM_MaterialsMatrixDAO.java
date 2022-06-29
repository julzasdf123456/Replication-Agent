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
public class CRM_MaterialsMatrixDAO { 
	public static void insert(CRM_MaterialsMatrix cRM_MaterialsMatrix, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_MaterialsMatrix(id, StructureId, MaterialsId, Quantity, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_MaterialsMatrix.getid());
		ps.setString(2, cRM_MaterialsMatrix.getStructureId());
		ps.setString(3, cRM_MaterialsMatrix.getMaterialsId());
		ps.setString(4, cRM_MaterialsMatrix.getQuantity());
		ps.setString(5, cRM_MaterialsMatrix.getcreated_at());
		ps.setString(6, cRM_MaterialsMatrix.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_MaterialsMatrix cRM_MaterialsMatrix, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_MaterialsMatrix SET StructureId=?, MaterialsId=?, Quantity=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_MaterialsMatrix.getStructureId());
		ps.setString(2, cRM_MaterialsMatrix.getMaterialsId());
		ps.setString(3, cRM_MaterialsMatrix.getQuantity());
		ps.setString(4, cRM_MaterialsMatrix.getcreated_at());
		ps.setString(5, cRM_MaterialsMatrix.getupdated_at());
		ps.setString(6, cRM_MaterialsMatrix.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_MaterialsMatrix getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MaterialsMatrix WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_MaterialsMatrix cRM_MaterialsMatrix = new CRM_MaterialsMatrix(
			rs.getString("id"),
			rs.getString("StructureId"),
			rs.getString("MaterialsId"),
			rs.getString("Quantity"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_MaterialsMatrix;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_MaterialsMatrix> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MaterialsMatrix WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_MaterialsMatrix> cRM_MaterialsMatrixList = new ArrayList<>();
		while(rs.next()) {
			CRM_MaterialsMatrix cRM_MaterialsMatrix = new CRM_MaterialsMatrix();
			cRM_MaterialsMatrix.setid(rs.getString("id"));
			cRM_MaterialsMatrix.setStructureId(rs.getString("StructureId"));
			cRM_MaterialsMatrix.setMaterialsId(rs.getString("MaterialsId"));
			cRM_MaterialsMatrix.setQuantity(rs.getString("Quantity"));
			cRM_MaterialsMatrix.setcreated_at(rs.getString("created_at"));
			cRM_MaterialsMatrix.setupdated_at(rs.getString("updated_at"));
			cRM_MaterialsMatrixList.add(cRM_MaterialsMatrix);
		}
		rs.close();
		ps.close();
		return cRM_MaterialsMatrixList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_MaterialsMatrix> billing_Billses = CRM_MaterialsMatrixDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_MaterialsMatrix to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_MaterialsMatrix bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_MaterialsMatrix bill = CRM_MaterialsMatrixDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_MaterialsMatrix has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_MaterialsMatrixDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_MaterialsMatrix updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_MaterialsMatrixDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_MaterialsMatrix inserted";
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
