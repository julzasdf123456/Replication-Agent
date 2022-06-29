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
public class CRM_ServiceConnectionTotalPaymentsDAO { 
	public static void insert(CRM_ServiceConnectionTotalPayments cRM_ServiceConnectionTotalPayments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionTotalPayments(id, ServiceConnectionId, SubTotal, Form2307TwoPercent, Form2307FivePercent, TotalVat, Total, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionTotalPayments.getid());
		ps.setString(2, cRM_ServiceConnectionTotalPayments.getServiceConnectionId());
		ps.setString(3, cRM_ServiceConnectionTotalPayments.getSubTotal());
		ps.setString(4, cRM_ServiceConnectionTotalPayments.getForm2307TwoPercent());
		ps.setString(5, cRM_ServiceConnectionTotalPayments.getForm2307FivePercent());
		ps.setString(6, cRM_ServiceConnectionTotalPayments.getTotalVat());
		ps.setString(7, cRM_ServiceConnectionTotalPayments.getTotal());
		ps.setString(8, cRM_ServiceConnectionTotalPayments.getNotes());
		ps.setString(9, cRM_ServiceConnectionTotalPayments.getcreated_at());
		ps.setString(10, cRM_ServiceConnectionTotalPayments.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionTotalPayments cRM_ServiceConnectionTotalPayments, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionTotalPayments SET ServiceConnectionId=?, SubTotal=?, Form2307TwoPercent=?, Form2307FivePercent=?, TotalVat=?, Total=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionTotalPayments.getServiceConnectionId());
		ps.setString(2, cRM_ServiceConnectionTotalPayments.getSubTotal());
		ps.setString(3, cRM_ServiceConnectionTotalPayments.getForm2307TwoPercent());
		ps.setString(4, cRM_ServiceConnectionTotalPayments.getForm2307FivePercent());
		ps.setString(5, cRM_ServiceConnectionTotalPayments.getTotalVat());
		ps.setString(6, cRM_ServiceConnectionTotalPayments.getTotal());
		ps.setString(7, cRM_ServiceConnectionTotalPayments.getNotes());
		ps.setString(8, cRM_ServiceConnectionTotalPayments.getcreated_at());
		ps.setString(9, cRM_ServiceConnectionTotalPayments.getupdated_at());
		ps.setString(10, cRM_ServiceConnectionTotalPayments.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionTotalPayments getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionTotalPayments WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionTotalPayments cRM_ServiceConnectionTotalPayments = new CRM_ServiceConnectionTotalPayments(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("SubTotal"),
			rs.getString("Form2307TwoPercent"),
			rs.getString("Form2307FivePercent"),
			rs.getString("TotalVat"),
			rs.getString("Total"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionTotalPayments;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionTotalPayments> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionTotalPayments WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionTotalPayments> cRM_ServiceConnectionTotalPaymentsList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionTotalPayments cRM_ServiceConnectionTotalPayments = new CRM_ServiceConnectionTotalPayments();
			cRM_ServiceConnectionTotalPayments.setid(rs.getString("id"));
			cRM_ServiceConnectionTotalPayments.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_ServiceConnectionTotalPayments.setSubTotal(rs.getString("SubTotal"));
			cRM_ServiceConnectionTotalPayments.setForm2307TwoPercent(rs.getString("Form2307TwoPercent"));
			cRM_ServiceConnectionTotalPayments.setForm2307FivePercent(rs.getString("Form2307FivePercent"));
			cRM_ServiceConnectionTotalPayments.setTotalVat(rs.getString("TotalVat"));
			cRM_ServiceConnectionTotalPayments.setTotal(rs.getString("Total"));
			cRM_ServiceConnectionTotalPayments.setNotes(rs.getString("Notes"));
			cRM_ServiceConnectionTotalPayments.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionTotalPayments.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionTotalPaymentsList.add(cRM_ServiceConnectionTotalPayments);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionTotalPaymentsList;
	}
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionTotalPayments> billing_Billses = CRM_ServiceConnectionTotalPaymentsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionTotalPayments to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionTotalPayments bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionTotalPayments bill = CRM_ServiceConnectionTotalPaymentsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionTotalPayments has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionTotalPaymentsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionTotalPayments updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionTotalPaymentsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionTotalPayments inserted";
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
