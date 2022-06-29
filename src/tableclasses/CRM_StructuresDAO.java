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
public class CRM_StructuresDAO { 
	public static void insert(CRM_Structures cRM_Structures, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_Structures(id, Type, Data, created_at, updated_at) VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, cRM_Structures.getid());
		ps.setString(2, cRM_Structures.getType());
		ps.setString(3, cRM_Structures.getData());
		ps.setString(4, cRM_Structures.getcreated_at());
		ps.setString(5, cRM_Structures.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_Structures cRM_Structures, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_Structures SET Type=?, Data=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_Structures.getType());
		ps.setString(2, cRM_Structures.getData());
		ps.setString(3, cRM_Structures.getcreated_at());
		ps.setString(4, cRM_Structures.getupdated_at());
		ps.setString(5, cRM_Structures.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_Structures getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_Structures WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_Structures cRM_Structures = new CRM_Structures(
			rs.getString("id"),
			rs.getString("Type"),
			rs.getString("Data"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_Structures;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_Structures> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_Structures WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_Structures> cRM_StructuresList = new ArrayList<>();
		while(rs.next()) {
			CRM_Structures cRM_Structures = new CRM_Structures();
			cRM_Structures.setid(rs.getString("id"));
			cRM_Structures.setType(rs.getString("Type"));
			cRM_Structures.setData(rs.getString("Data"));
			cRM_Structures.setcreated_at(rs.getString("created_at"));
			cRM_Structures.setupdated_at(rs.getString("updated_at"));
			cRM_StructuresList.add(cRM_Structures);
		}
		rs.close();
		ps.close();
		return cRM_StructuresList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_Structures> billing_Billses = CRM_StructuresDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_Structures to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_Structures bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_Structures bill = CRM_StructuresDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_Structures has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_StructuresDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_Structures updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_StructuresDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_Structures inserted";
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
