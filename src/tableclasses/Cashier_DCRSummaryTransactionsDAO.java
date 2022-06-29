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
public class Cashier_DCRSummaryTransactionsDAO { 
	public static void insert(Cashier_DCRSummaryTransactions cashier_DCRSummaryTransactions, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_DCRSummaryTransactions(id, GLCode, NEACode, Description, Amount, Day, Time, Teller, DCRNumber, Status, created_at, updated_at, ORNumber, ReportDestination, Office, AccountNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_DCRSummaryTransactions.getid());
		ps.setString(2, cashier_DCRSummaryTransactions.getGLCode());
		ps.setString(3, cashier_DCRSummaryTransactions.getNEACode());
		ps.setString(4, cashier_DCRSummaryTransactions.getDescription());
		ps.setString(5, cashier_DCRSummaryTransactions.getAmount());
		ps.setString(6, cashier_DCRSummaryTransactions.getDay());
		ps.setString(7, cashier_DCRSummaryTransactions.getTime());
		ps.setString(8, cashier_DCRSummaryTransactions.getTeller());
		ps.setString(9, cashier_DCRSummaryTransactions.getDCRNumber());
		ps.setString(10, cashier_DCRSummaryTransactions.getStatus());
		ps.setString(11, cashier_DCRSummaryTransactions.getcreated_at());
		ps.setString(12, cashier_DCRSummaryTransactions.getupdated_at());
		ps.setString(13, cashier_DCRSummaryTransactions.getORNumber());
		ps.setString(14, cashier_DCRSummaryTransactions.getReportDestination());
		ps.setString(15, cashier_DCRSummaryTransactions.getOffice());
		ps.setString(16, cashier_DCRSummaryTransactions.getAccountNumber());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_DCRSummaryTransactions cashier_DCRSummaryTransactions, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_DCRSummaryTransactions SET GLCode=?, NEACode=?, Description=?, Amount=?, Day=?, Time=?, Teller=?, DCRNumber=?, Status=?, created_at=?, updated_at=?, ORNumber=?, ReportDestination=?, Office=?, AccountNumber=?  WHERE id=? ");
		ps.setString(1, cashier_DCRSummaryTransactions.getGLCode());
		ps.setString(2, cashier_DCRSummaryTransactions.getNEACode());
		ps.setString(3, cashier_DCRSummaryTransactions.getDescription());
		ps.setString(4, cashier_DCRSummaryTransactions.getAmount());
		ps.setString(5, cashier_DCRSummaryTransactions.getDay());
		ps.setString(6, cashier_DCRSummaryTransactions.getTime());
		ps.setString(7, cashier_DCRSummaryTransactions.getTeller());
		ps.setString(8, cashier_DCRSummaryTransactions.getDCRNumber());
		ps.setString(9, cashier_DCRSummaryTransactions.getStatus());
		ps.setString(10, cashier_DCRSummaryTransactions.getcreated_at());
		ps.setString(11, cashier_DCRSummaryTransactions.getupdated_at());
		ps.setString(12, cashier_DCRSummaryTransactions.getORNumber());
		ps.setString(13, cashier_DCRSummaryTransactions.getReportDestination());
		ps.setString(14, cashier_DCRSummaryTransactions.getOffice());
		ps.setString(15, cashier_DCRSummaryTransactions.getAccountNumber());
		ps.setString(16, cashier_DCRSummaryTransactions.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_DCRSummaryTransactions getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_DCRSummaryTransactions WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_DCRSummaryTransactions cashier_DCRSummaryTransactions = new Cashier_DCRSummaryTransactions(
			rs.getString("id"),
			rs.getString("GLCode"),
			rs.getString("NEACode"),
			rs.getString("Description"),
			rs.getString("Amount"),
			rs.getString("Day"),
			rs.getString("Time"),
			rs.getString("Teller"),
			rs.getString("DCRNumber"),
			rs.getString("Status"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("ORNumber"),
			rs.getString("ReportDestination"),
			rs.getString("Office"),
			rs.getString("AccountNumber")
			);
			ps.close();
			rs.close();
			return cashier_DCRSummaryTransactions;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_DCRSummaryTransactions> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_DCRSummaryTransactions WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_DCRSummaryTransactions> cashier_DCRSummaryTransactionsList = new ArrayList<>();
		while(rs.next()) {
			Cashier_DCRSummaryTransactions cashier_DCRSummaryTransactions = new Cashier_DCRSummaryTransactions();
			cashier_DCRSummaryTransactions.setid(rs.getString("id"));
			cashier_DCRSummaryTransactions.setGLCode(rs.getString("GLCode"));
			cashier_DCRSummaryTransactions.setNEACode(rs.getString("NEACode"));
			cashier_DCRSummaryTransactions.setDescription(rs.getString("Description"));
			cashier_DCRSummaryTransactions.setAmount(rs.getString("Amount"));
			cashier_DCRSummaryTransactions.setDay(rs.getString("Day"));
			cashier_DCRSummaryTransactions.setTime(rs.getString("Time"));
			cashier_DCRSummaryTransactions.setTeller(rs.getString("Teller"));
			cashier_DCRSummaryTransactions.setDCRNumber(rs.getString("DCRNumber"));
			cashier_DCRSummaryTransactions.setStatus(rs.getString("Status"));
			cashier_DCRSummaryTransactions.setcreated_at(rs.getString("created_at"));
			cashier_DCRSummaryTransactions.setupdated_at(rs.getString("updated_at"));
			cashier_DCRSummaryTransactions.setORNumber(rs.getString("ORNumber"));
			cashier_DCRSummaryTransactions.setReportDestination(rs.getString("ReportDestination"));
			cashier_DCRSummaryTransactions.setOffice(rs.getString("Office"));
			cashier_DCRSummaryTransactions.setAccountNumber(rs.getString("AccountNumber"));
			cashier_DCRSummaryTransactionsList.add(cashier_DCRSummaryTransactions);
		}
		rs.close();
		ps.close();
		return cashier_DCRSummaryTransactionsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_DCRSummaryTransactions> billing_Billses = Cashier_DCRSummaryTransactionsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_DCRSummaryTransactions to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_DCRSummaryTransactions bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_DCRSummaryTransactions bill = Cashier_DCRSummaryTransactionsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_DCRSummaryTransactions has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_DCRSummaryTransactionsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_DCRSummaryTransactions updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_DCRSummaryTransactionsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_DCRSummaryTransactions inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(70);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
