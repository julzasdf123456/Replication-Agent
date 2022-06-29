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
public class CRM_PoleIndexDAO { 
	public static void insert(CRM_PoleIndex cRM_PoleIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_PoleIndex(id, NEACode, Type, created_at, updated_at) VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, cRM_PoleIndex.getid());
		ps.setString(2, cRM_PoleIndex.getNEACode());
		ps.setString(3, cRM_PoleIndex.getType());
		ps.setString(4, cRM_PoleIndex.getcreated_at());
		ps.setString(5, cRM_PoleIndex.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_PoleIndex cRM_PoleIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_PoleIndex SET NEACode=?, Type=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_PoleIndex.getNEACode());
		ps.setString(2, cRM_PoleIndex.getType());
		ps.setString(3, cRM_PoleIndex.getcreated_at());
		ps.setString(4, cRM_PoleIndex.getupdated_at());
		ps.setString(5, cRM_PoleIndex.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_PoleIndex getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_PoleIndex WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_PoleIndex cRM_PoleIndex = new CRM_PoleIndex(
			rs.getString("id"),
			rs.getString("NEACode"),
			rs.getString("Type"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_PoleIndex;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_PoleIndex> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_PoleIndex WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_PoleIndex> cRM_PoleIndexList = new ArrayList<>();
		while(rs.next()) {
			CRM_PoleIndex cRM_PoleIndex = new CRM_PoleIndex();
			cRM_PoleIndex.setid(rs.getString("id"));
			cRM_PoleIndex.setNEACode(rs.getString("NEACode"));
			cRM_PoleIndex.setType(rs.getString("Type"));
			cRM_PoleIndex.setcreated_at(rs.getString("created_at"));
			cRM_PoleIndex.setupdated_at(rs.getString("updated_at"));
			cRM_PoleIndexList.add(cRM_PoleIndex);
		}
		rs.close();
		ps.close();
		return cRM_PoleIndexList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_PoleIndex> billing_Billses = CRM_PoleIndexDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_PoleIndex to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_PoleIndex bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_PoleIndex bill = CRM_PoleIndexDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_PoleIndex has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_PoleIndexDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_PoleIndex updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_PoleIndexDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_PoleIndex inserted";
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
