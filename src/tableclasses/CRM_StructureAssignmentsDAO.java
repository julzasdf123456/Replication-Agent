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
public class CRM_StructureAssignmentsDAO { 
	public static void insert(CRM_StructureAssignments cRM_StructureAssignments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_StructureAssignments(id, ServiceConnectionId, StructureId, created_at, updated_at, Quantity, Type, ConAssGrouping) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_StructureAssignments.getid());
		ps.setString(2, cRM_StructureAssignments.getServiceConnectionId());
		ps.setString(3, cRM_StructureAssignments.getStructureId());
		ps.setString(4, cRM_StructureAssignments.getcreated_at());
		ps.setString(5, cRM_StructureAssignments.getupdated_at());
		ps.setString(6, cRM_StructureAssignments.getQuantity());
		ps.setString(7, cRM_StructureAssignments.getType());
		ps.setString(8, cRM_StructureAssignments.getConAssGrouping());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_StructureAssignments cRM_StructureAssignments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_StructureAssignments SET ServiceConnectionId=?, StructureId=?, created_at=?, updated_at=?, Quantity=?, Type=?, ConAssGrouping=?  WHERE id=? ");
		ps.setString(1, cRM_StructureAssignments.getServiceConnectionId());
		ps.setString(2, cRM_StructureAssignments.getStructureId());
		ps.setString(3, cRM_StructureAssignments.getcreated_at());
		ps.setString(4, cRM_StructureAssignments.getupdated_at());
		ps.setString(5, cRM_StructureAssignments.getQuantity());
		ps.setString(6, cRM_StructureAssignments.getType());
		ps.setString(7, cRM_StructureAssignments.getConAssGrouping());
		ps.setString(8, cRM_StructureAssignments.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_StructureAssignments getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_StructureAssignments WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_StructureAssignments cRM_StructureAssignments = new CRM_StructureAssignments(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("StructureId"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Quantity"),
			rs.getString("Type"),
			rs.getString("ConAssGrouping")
			);
			ps.close();
			rs.close();
			return cRM_StructureAssignments;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_StructureAssignments> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_StructureAssignments WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_StructureAssignments> cRM_StructureAssignmentsList = new ArrayList<>();
		while(rs.next()) {
			CRM_StructureAssignments cRM_StructureAssignments = new CRM_StructureAssignments();
			cRM_StructureAssignments.setid(rs.getString("id"));
			cRM_StructureAssignments.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_StructureAssignments.setStructureId(rs.getString("StructureId"));
			cRM_StructureAssignments.setcreated_at(rs.getString("created_at"));
			cRM_StructureAssignments.setupdated_at(rs.getString("updated_at"));
			cRM_StructureAssignments.setQuantity(rs.getString("Quantity"));
			cRM_StructureAssignments.setType(rs.getString("Type"));
			cRM_StructureAssignments.setConAssGrouping(rs.getString("ConAssGrouping"));
			cRM_StructureAssignmentsList.add(cRM_StructureAssignments);
		}
		rs.close();
		ps.close();
		return cRM_StructureAssignmentsList;
	} 

        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_StructureAssignments> billing_Billses = CRM_StructureAssignmentsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_StructureAssignments to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_StructureAssignments bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_StructureAssignments bill = CRM_StructureAssignmentsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_StructureAssignments has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_StructureAssignmentsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_StructureAssignments updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_StructureAssignmentsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_StructureAssignments inserted";
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
