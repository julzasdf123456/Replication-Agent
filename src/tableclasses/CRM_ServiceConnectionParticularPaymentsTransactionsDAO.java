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
public class CRM_ServiceConnectionParticularPaymentsTransactionsDAO { 
	public static void insert(CRM_ServiceConnectionParticularPaymentsTransactions cRM_ServiceConnectionParticularPaymentsTransactions, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionParticularPaymentsTransactions(id, ServiceConnectionId, Particular, Amount, Vat, Total, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionParticularPaymentsTransactions.getid());
		ps.setString(2, cRM_ServiceConnectionParticularPaymentsTransactions.getServiceConnectionId());
		ps.setString(3, cRM_ServiceConnectionParticularPaymentsTransactions.getParticular());
		ps.setString(4, cRM_ServiceConnectionParticularPaymentsTransactions.getAmount());
		ps.setString(5, cRM_ServiceConnectionParticularPaymentsTransactions.getVat());
		ps.setString(6, cRM_ServiceConnectionParticularPaymentsTransactions.getTotal());
		ps.setString(7, cRM_ServiceConnectionParticularPaymentsTransactions.getcreated_at());
		ps.setString(8, cRM_ServiceConnectionParticularPaymentsTransactions.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionParticularPaymentsTransactions cRM_ServiceConnectionParticularPaymentsTransactions, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionParticularPaymentsTransactions SET ServiceConnectionId=?, Particular=?, Amount=?, Vat=?, Total=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionParticularPaymentsTransactions.getServiceConnectionId());
		ps.setString(2, cRM_ServiceConnectionParticularPaymentsTransactions.getParticular());
		ps.setString(3, cRM_ServiceConnectionParticularPaymentsTransactions.getAmount());
		ps.setString(4, cRM_ServiceConnectionParticularPaymentsTransactions.getVat());
		ps.setString(5, cRM_ServiceConnectionParticularPaymentsTransactions.getTotal());
		ps.setString(6, cRM_ServiceConnectionParticularPaymentsTransactions.getcreated_at());
		ps.setString(7, cRM_ServiceConnectionParticularPaymentsTransactions.getupdated_at());
		ps.setString(8, cRM_ServiceConnectionParticularPaymentsTransactions.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionParticularPaymentsTransactions getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionParticularPaymentsTransactions WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionParticularPaymentsTransactions cRM_ServiceConnectionParticularPaymentsTransactions = new CRM_ServiceConnectionParticularPaymentsTransactions(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("Particular"),
			rs.getString("Amount"),
			rs.getString("Vat"),
			rs.getString("Total"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionParticularPaymentsTransactions;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionParticularPaymentsTransactions> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionParticularPaymentsTransactions WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionParticularPaymentsTransactions> cRM_ServiceConnectionParticularPaymentsTransactionsList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionParticularPaymentsTransactions cRM_ServiceConnectionParticularPaymentsTransactions = new CRM_ServiceConnectionParticularPaymentsTransactions();
			cRM_ServiceConnectionParticularPaymentsTransactions.setid(rs.getString("id"));
			cRM_ServiceConnectionParticularPaymentsTransactions.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_ServiceConnectionParticularPaymentsTransactions.setParticular(rs.getString("Particular"));
			cRM_ServiceConnectionParticularPaymentsTransactions.setAmount(rs.getString("Amount"));
			cRM_ServiceConnectionParticularPaymentsTransactions.setVat(rs.getString("Vat"));
			cRM_ServiceConnectionParticularPaymentsTransactions.setTotal(rs.getString("Total"));
			cRM_ServiceConnectionParticularPaymentsTransactions.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionParticularPaymentsTransactions.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionParticularPaymentsTransactionsList.add(cRM_ServiceConnectionParticularPaymentsTransactions);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionParticularPaymentsTransactionsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionParticularPaymentsTransactions> billing_Billses = CRM_ServiceConnectionParticularPaymentsTransactionsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionParticularPaymentsTransactions to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionParticularPaymentsTransactions bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionParticularPaymentsTransactions bill = CRM_ServiceConnectionParticularPaymentsTransactionsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionParticularPaymentsTransactions has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionParticularPaymentsTransactionsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionParticularPaymentsTransactions updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionParticularPaymentsTransactionsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionParticularPaymentsTransactions inserted";
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
