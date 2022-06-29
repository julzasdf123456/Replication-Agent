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
public class CRM_MemberConsumerTypesDAO { 
	public static void insert(CRM_MemberConsumerTypes cRM_MemberConsumerTypes, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_MemberConsumerTypes(Id, Type, Description, created_at, updated_at) VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, cRM_MemberConsumerTypes.getId());
		ps.setString(2, cRM_MemberConsumerTypes.getType());
		ps.setString(3, cRM_MemberConsumerTypes.getDescription());
		ps.setString(4, cRM_MemberConsumerTypes.getcreated_at());
		ps.setString(5, cRM_MemberConsumerTypes.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_MemberConsumerTypes cRM_MemberConsumerTypes, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_MemberConsumerTypes SET Type=?, Description=?, created_at=?, updated_at=?  WHERE Id=? ");
		ps.setString(1, cRM_MemberConsumerTypes.getType());
		ps.setString(2, cRM_MemberConsumerTypes.getDescription());
		ps.setString(3, cRM_MemberConsumerTypes.getcreated_at());
		ps.setString(4, cRM_MemberConsumerTypes.getupdated_at());
		ps.setString(5, cRM_MemberConsumerTypes.getId());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_MemberConsumerTypes getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumerTypes WHERE Id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_MemberConsumerTypes cRM_MemberConsumerTypes = new CRM_MemberConsumerTypes(
			rs.getString("Id"),
			rs.getString("Type"),
			rs.getString("Description"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_MemberConsumerTypes;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_MemberConsumerTypes> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumerTypes WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_MemberConsumerTypes> cRM_MemberConsumerTypesList = new ArrayList<>();
		while(rs.next()) {
			CRM_MemberConsumerTypes cRM_MemberConsumerTypes = new CRM_MemberConsumerTypes();
			cRM_MemberConsumerTypes.setId(rs.getString("Id"));
			cRM_MemberConsumerTypes.setType(rs.getString("Type"));
			cRM_MemberConsumerTypes.setDescription(rs.getString("Description"));
			cRM_MemberConsumerTypes.setcreated_at(rs.getString("created_at"));
			cRM_MemberConsumerTypes.setupdated_at(rs.getString("updated_at"));
			cRM_MemberConsumerTypesList.add(cRM_MemberConsumerTypes);
		}
		rs.close();
		ps.close();
		return cRM_MemberConsumerTypesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_MemberConsumerTypes> billing_Billses = CRM_MemberConsumerTypesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_MemberConsumerTypes to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_MemberConsumerTypes bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_MemberConsumerTypes bill = CRM_MemberConsumerTypesDAO.getOne(bills.getId(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getId() + " in CRM_MemberConsumerTypes has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_MemberConsumerTypesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getId() + " in CRM_MemberConsumerTypes updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_MemberConsumerTypesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getId() + " in CRM_MemberConsumerTypes inserted";
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
