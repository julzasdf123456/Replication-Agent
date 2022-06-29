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
public class CRM_BillOfMaterialsIndexDAO { 
	public static void insert(CRM_BillOfMaterialsIndex cRM_BillOfMaterialsIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_BillOfMaterialsIndex(id, ServiceConnectionId, Date, SubTotal, LaborCost, Others, Total, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_BillOfMaterialsIndex.getid());
		ps.setString(2, cRM_BillOfMaterialsIndex.getServiceConnectionId());
		ps.setString(3, cRM_BillOfMaterialsIndex.getDate());
		ps.setString(4, cRM_BillOfMaterialsIndex.getSubTotal());
		ps.setString(5, cRM_BillOfMaterialsIndex.getLaborCost());
		ps.setString(6, cRM_BillOfMaterialsIndex.getOthers());
		ps.setString(7, cRM_BillOfMaterialsIndex.getTotal());
		ps.setString(8, cRM_BillOfMaterialsIndex.getcreated_at());
		ps.setString(9, cRM_BillOfMaterialsIndex.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_BillOfMaterialsIndex cRM_BillOfMaterialsIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_BillOfMaterialsIndex SET ServiceConnectionId=?, Date=?, SubTotal=?, LaborCost=?, Others=?, Total=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_BillOfMaterialsIndex.getServiceConnectionId());
		ps.setString(2, cRM_BillOfMaterialsIndex.getDate());
		ps.setString(3, cRM_BillOfMaterialsIndex.getSubTotal());
		ps.setString(4, cRM_BillOfMaterialsIndex.getLaborCost());
		ps.setString(5, cRM_BillOfMaterialsIndex.getOthers());
		ps.setString(6, cRM_BillOfMaterialsIndex.getTotal());
		ps.setString(7, cRM_BillOfMaterialsIndex.getcreated_at());
		ps.setString(8, cRM_BillOfMaterialsIndex.getupdated_at());
		ps.setString(9, cRM_BillOfMaterialsIndex.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_BillOfMaterialsIndex getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_BillOfMaterialsIndex WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_BillOfMaterialsIndex cRM_BillOfMaterialsIndex = new CRM_BillOfMaterialsIndex(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("Date"),
			rs.getString("SubTotal"),
			rs.getString("LaborCost"),
			rs.getString("Others"),
			rs.getString("Total"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_BillOfMaterialsIndex;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_BillOfMaterialsIndex> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_BillOfMaterialsIndex WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_BillOfMaterialsIndex> cRM_BillOfMaterialsIndexList = new ArrayList<>();
		while(rs.next()) {
			CRM_BillOfMaterialsIndex cRM_BillOfMaterialsIndex = new CRM_BillOfMaterialsIndex();
			cRM_BillOfMaterialsIndex.setid(rs.getString("id"));
			cRM_BillOfMaterialsIndex.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_BillOfMaterialsIndex.setDate(rs.getString("Date"));
			cRM_BillOfMaterialsIndex.setSubTotal(rs.getString("SubTotal"));
			cRM_BillOfMaterialsIndex.setLaborCost(rs.getString("LaborCost"));
			cRM_BillOfMaterialsIndex.setOthers(rs.getString("Others"));
			cRM_BillOfMaterialsIndex.setTotal(rs.getString("Total"));
			cRM_BillOfMaterialsIndex.setcreated_at(rs.getString("created_at"));
			cRM_BillOfMaterialsIndex.setupdated_at(rs.getString("updated_at"));
			cRM_BillOfMaterialsIndexList.add(cRM_BillOfMaterialsIndex);
		}
		rs.close();
		ps.close();
		return cRM_BillOfMaterialsIndexList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_BillOfMaterialsIndex> billing_Billses = CRM_BillOfMaterialsIndexDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_BillOfMaterialsIndex to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_BillOfMaterialsIndex bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_BillOfMaterialsIndex bill = CRM_BillOfMaterialsIndexDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_BillOfMaterialsIndex has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_BillOfMaterialsIndexDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_BillOfMaterialsIndex updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_BillOfMaterialsIndexDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_BillOfMaterialsIndex inserted";
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
