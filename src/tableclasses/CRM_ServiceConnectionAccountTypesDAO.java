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
public class CRM_ServiceConnectionAccountTypesDAO { 
	public static void insert(CRM_ServiceConnectionAccountTypes cRM_ServiceConnectionAccountTypes, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionAccountTypes(id, AccountType, Description, created_at, updated_at, Alias) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionAccountTypes.getid());
		ps.setString(2, cRM_ServiceConnectionAccountTypes.getAccountType());
		ps.setString(3, cRM_ServiceConnectionAccountTypes.getDescription());
		ps.setString(4, cRM_ServiceConnectionAccountTypes.getcreated_at());
		ps.setString(5, cRM_ServiceConnectionAccountTypes.getupdated_at());
		ps.setString(6, cRM_ServiceConnectionAccountTypes.getAlias());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionAccountTypes cRM_ServiceConnectionAccountTypes, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionAccountTypes SET AccountType=?, Description=?, created_at=?, updated_at=?, Alias=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionAccountTypes.getAccountType());
		ps.setString(2, cRM_ServiceConnectionAccountTypes.getDescription());
		ps.setString(3, cRM_ServiceConnectionAccountTypes.getcreated_at());
		ps.setString(4, cRM_ServiceConnectionAccountTypes.getupdated_at());
		ps.setString(5, cRM_ServiceConnectionAccountTypes.getAlias());
		ps.setString(6, cRM_ServiceConnectionAccountTypes.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionAccountTypes getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionAccountTypes WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionAccountTypes cRM_ServiceConnectionAccountTypes = new CRM_ServiceConnectionAccountTypes(
			rs.getString("id"),
			rs.getString("AccountType"),
			rs.getString("Description"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Alias")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionAccountTypes;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionAccountTypes> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionAccountTypes WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionAccountTypes> cRM_ServiceConnectionAccountTypesList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionAccountTypes cRM_ServiceConnectionAccountTypes = new CRM_ServiceConnectionAccountTypes();
			cRM_ServiceConnectionAccountTypes.setid(rs.getString("id"));
			cRM_ServiceConnectionAccountTypes.setAccountType(rs.getString("AccountType"));
			cRM_ServiceConnectionAccountTypes.setDescription(rs.getString("Description"));
			cRM_ServiceConnectionAccountTypes.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionAccountTypes.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionAccountTypes.setAlias(rs.getString("Alias"));
			cRM_ServiceConnectionAccountTypesList.add(cRM_ServiceConnectionAccountTypes);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionAccountTypesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionAccountTypes> billing_Billses = CRM_ServiceConnectionAccountTypesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionAccountTypes to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionAccountTypes bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionAccountTypes bill = CRM_ServiceConnectionAccountTypesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionAccountTypes has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionAccountTypesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionAccountTypes updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionAccountTypesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionAccountTypes inserted";
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
