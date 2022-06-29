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
public class CRM_TransformersAssignedMatrixDAO { 
	public static void insert(CRM_TransformersAssignedMatrix cRM_TransformersAssignedMatrix, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_TransformersAssignedMatrix(id, ServiceConnectionId, MaterialsId, Quantity, created_at, updated_at, Type, Amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_TransformersAssignedMatrix.getid());
		ps.setString(2, cRM_TransformersAssignedMatrix.getServiceConnectionId());
		ps.setString(3, cRM_TransformersAssignedMatrix.getMaterialsId());
		ps.setString(4, cRM_TransformersAssignedMatrix.getQuantity());
		ps.setString(5, cRM_TransformersAssignedMatrix.getcreated_at());
		ps.setString(6, cRM_TransformersAssignedMatrix.getupdated_at());
		ps.setString(7, cRM_TransformersAssignedMatrix.getType());
		ps.setString(8, cRM_TransformersAssignedMatrix.getAmount());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_TransformersAssignedMatrix cRM_TransformersAssignedMatrix, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_TransformersAssignedMatrix SET ServiceConnectionId=?, MaterialsId=?, Quantity=?, created_at=?, updated_at=?, Type=?, Amount=?  WHERE id=? ");
		ps.setString(1, cRM_TransformersAssignedMatrix.getServiceConnectionId());
		ps.setString(2, cRM_TransformersAssignedMatrix.getMaterialsId());
		ps.setString(3, cRM_TransformersAssignedMatrix.getQuantity());
		ps.setString(4, cRM_TransformersAssignedMatrix.getcreated_at());
		ps.setString(5, cRM_TransformersAssignedMatrix.getupdated_at());
		ps.setString(6, cRM_TransformersAssignedMatrix.getType());
		ps.setString(7, cRM_TransformersAssignedMatrix.getAmount());
		ps.setString(8, cRM_TransformersAssignedMatrix.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_TransformersAssignedMatrix getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_TransformersAssignedMatrix WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_TransformersAssignedMatrix cRM_TransformersAssignedMatrix = new CRM_TransformersAssignedMatrix(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("MaterialsId"),
			rs.getString("Quantity"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Type"),
			rs.getString("Amount")
			);
			ps.close();
			rs.close();
			return cRM_TransformersAssignedMatrix;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_TransformersAssignedMatrix> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_TransformersAssignedMatrix WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_TransformersAssignedMatrix> cRM_TransformersAssignedMatrixList = new ArrayList<>();
		while(rs.next()) {
			CRM_TransformersAssignedMatrix cRM_TransformersAssignedMatrix = new CRM_TransformersAssignedMatrix();
			cRM_TransformersAssignedMatrix.setid(rs.getString("id"));
			cRM_TransformersAssignedMatrix.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_TransformersAssignedMatrix.setMaterialsId(rs.getString("MaterialsId"));
			cRM_TransformersAssignedMatrix.setQuantity(rs.getString("Quantity"));
			cRM_TransformersAssignedMatrix.setcreated_at(rs.getString("created_at"));
			cRM_TransformersAssignedMatrix.setupdated_at(rs.getString("updated_at"));
			cRM_TransformersAssignedMatrix.setType(rs.getString("Type"));
			cRM_TransformersAssignedMatrix.setAmount(rs.getString("Amount"));
			cRM_TransformersAssignedMatrixList.add(cRM_TransformersAssignedMatrix);
		}
		rs.close();
		ps.close();
		return cRM_TransformersAssignedMatrixList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_TransformersAssignedMatrix> billing_Billses = CRM_TransformersAssignedMatrixDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_TransformersAssignedMatrix to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_TransformersAssignedMatrix bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_TransformersAssignedMatrix bill = CRM_TransformersAssignedMatrixDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_TransformersAssignedMatrix has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_TransformersAssignedMatrixDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_TransformersAssignedMatrix updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_TransformersAssignedMatrixDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_TransformersAssignedMatrix inserted";
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
