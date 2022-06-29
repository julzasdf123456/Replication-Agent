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
public class CRM_ServiceConnectionPaymentParticularsDAO { 
	public static void insert(CRM_ServiceConnectionPaymentParticulars cRM_ServiceConnectionPaymentParticulars, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionPaymentParticulars(id, Particular, Description, VatPercentage, Notes, created_at, updated_at, DefaultAmount, AccountNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionPaymentParticulars.getid());
		ps.setString(2, cRM_ServiceConnectionPaymentParticulars.getParticular());
		ps.setString(3, cRM_ServiceConnectionPaymentParticulars.getDescription());
		ps.setString(4, cRM_ServiceConnectionPaymentParticulars.getVatPercentage());
		ps.setString(5, cRM_ServiceConnectionPaymentParticulars.getNotes());
		ps.setString(6, cRM_ServiceConnectionPaymentParticulars.getcreated_at());
		ps.setString(7, cRM_ServiceConnectionPaymentParticulars.getupdated_at());
		ps.setString(8, cRM_ServiceConnectionPaymentParticulars.getDefaultAmount());
		ps.setString(9, cRM_ServiceConnectionPaymentParticulars.getAccountNumber());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionPaymentParticulars cRM_ServiceConnectionPaymentParticulars, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionPaymentParticulars SET Particular=?, Description=?, VatPercentage=?, Notes=?, created_at=?, updated_at=?, DefaultAmount=?, AccountNumber=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionPaymentParticulars.getParticular());
		ps.setString(2, cRM_ServiceConnectionPaymentParticulars.getDescription());
		ps.setString(3, cRM_ServiceConnectionPaymentParticulars.getVatPercentage());
		ps.setString(4, cRM_ServiceConnectionPaymentParticulars.getNotes());
		ps.setString(5, cRM_ServiceConnectionPaymentParticulars.getcreated_at());
		ps.setString(6, cRM_ServiceConnectionPaymentParticulars.getupdated_at());
		ps.setString(7, cRM_ServiceConnectionPaymentParticulars.getDefaultAmount());
		ps.setString(8, cRM_ServiceConnectionPaymentParticulars.getAccountNumber());
		ps.setString(9, cRM_ServiceConnectionPaymentParticulars.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionPaymentParticulars getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionPaymentParticulars WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionPaymentParticulars cRM_ServiceConnectionPaymentParticulars = new CRM_ServiceConnectionPaymentParticulars(
			rs.getString("id"),
			rs.getString("Particular"),
			rs.getString("Description"),
			rs.getString("VatPercentage"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("DefaultAmount"),
			rs.getString("AccountNumber")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionPaymentParticulars;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionPaymentParticulars> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionPaymentParticulars WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionPaymentParticulars> cRM_ServiceConnectionPaymentParticularsList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionPaymentParticulars cRM_ServiceConnectionPaymentParticulars = new CRM_ServiceConnectionPaymentParticulars();
			cRM_ServiceConnectionPaymentParticulars.setid(rs.getString("id"));
			cRM_ServiceConnectionPaymentParticulars.setParticular(rs.getString("Particular"));
			cRM_ServiceConnectionPaymentParticulars.setDescription(rs.getString("Description"));
			cRM_ServiceConnectionPaymentParticulars.setVatPercentage(rs.getString("VatPercentage"));
			cRM_ServiceConnectionPaymentParticulars.setNotes(rs.getString("Notes"));
			cRM_ServiceConnectionPaymentParticulars.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionPaymentParticulars.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionPaymentParticulars.setDefaultAmount(rs.getString("DefaultAmount"));
			cRM_ServiceConnectionPaymentParticulars.setAccountNumber(rs.getString("AccountNumber"));
			cRM_ServiceConnectionPaymentParticularsList.add(cRM_ServiceConnectionPaymentParticulars);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionPaymentParticularsList;
	}
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionPaymentParticulars> billing_Billses = CRM_ServiceConnectionPaymentParticularsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionPaymentParticulars to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionPaymentParticulars bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionPaymentParticulars bill = CRM_ServiceConnectionPaymentParticularsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionPaymentParticulars has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionPaymentParticularsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionPaymentParticulars updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionPaymentParticularsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionPaymentParticulars inserted";
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
