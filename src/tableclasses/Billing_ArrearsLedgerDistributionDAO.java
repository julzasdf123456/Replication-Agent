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
public class Billing_ArrearsLedgerDistributionDAO { 
	public static void insert(Billing_ArrearsLedgerDistribution billing_ArrearsLedgerDistribution, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_ArrearsLedgerDistribution(id, AccountNumber, ServicePeriod, Amount, IsBilled, IsPaid, LinkedBillNumber, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_ArrearsLedgerDistribution.getid());
		ps.setString(2, billing_ArrearsLedgerDistribution.getAccountNumber());
		ps.setString(3, billing_ArrearsLedgerDistribution.getServicePeriod());
		ps.setString(4, billing_ArrearsLedgerDistribution.getAmount());
		ps.setString(5, billing_ArrearsLedgerDistribution.getIsBilled());
		ps.setString(6, billing_ArrearsLedgerDistribution.getIsPaid());
		ps.setString(7, billing_ArrearsLedgerDistribution.getLinkedBillNumber());
		ps.setString(8, billing_ArrearsLedgerDistribution.getNotes());
		ps.setString(9, billing_ArrearsLedgerDistribution.getcreated_at());
		ps.setString(10, billing_ArrearsLedgerDistribution.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_ArrearsLedgerDistribution billing_ArrearsLedgerDistribution, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_ArrearsLedgerDistribution SET AccountNumber=?, ServicePeriod=?, Amount=?, IsBilled=?, IsPaid=?, LinkedBillNumber=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, billing_ArrearsLedgerDistribution.getAccountNumber());
		ps.setString(2, billing_ArrearsLedgerDistribution.getServicePeriod());
		ps.setString(3, billing_ArrearsLedgerDistribution.getAmount());
		ps.setString(4, billing_ArrearsLedgerDistribution.getIsBilled());
		ps.setString(5, billing_ArrearsLedgerDistribution.getIsPaid());
		ps.setString(6, billing_ArrearsLedgerDistribution.getLinkedBillNumber());
		ps.setString(7, billing_ArrearsLedgerDistribution.getNotes());
		ps.setString(8, billing_ArrearsLedgerDistribution.getcreated_at());
		ps.setString(9, billing_ArrearsLedgerDistribution.getupdated_at());
		ps.setString(10, billing_ArrearsLedgerDistribution.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_ArrearsLedgerDistribution getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_ArrearsLedgerDistribution WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_ArrearsLedgerDistribution billing_ArrearsLedgerDistribution = new Billing_ArrearsLedgerDistribution(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("ServicePeriod"),
			rs.getString("Amount"),
			rs.getString("IsBilled"),
			rs.getString("IsPaid"),
			rs.getString("LinkedBillNumber"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return billing_ArrearsLedgerDistribution;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_ArrearsLedgerDistribution> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_ArrearsLedgerDistribution WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_ArrearsLedgerDistribution> billing_ArrearsLedgerDistributionList = new ArrayList<>();
		while(rs.next()) {
			Billing_ArrearsLedgerDistribution billing_ArrearsLedgerDistribution = new Billing_ArrearsLedgerDistribution();
			billing_ArrearsLedgerDistribution.setid(rs.getString("id"));
			billing_ArrearsLedgerDistribution.setAccountNumber(rs.getString("AccountNumber"));
			billing_ArrearsLedgerDistribution.setServicePeriod(rs.getString("ServicePeriod"));
			billing_ArrearsLedgerDistribution.setAmount(rs.getString("Amount"));
			billing_ArrearsLedgerDistribution.setIsBilled(rs.getString("IsBilled"));
			billing_ArrearsLedgerDistribution.setIsPaid(rs.getString("IsPaid"));
			billing_ArrearsLedgerDistribution.setLinkedBillNumber(rs.getString("LinkedBillNumber"));
			billing_ArrearsLedgerDistribution.setNotes(rs.getString("Notes"));
			billing_ArrearsLedgerDistribution.setcreated_at(rs.getString("created_at"));
			billing_ArrearsLedgerDistribution.setupdated_at(rs.getString("updated_at"));
			billing_ArrearsLedgerDistributionList.add(billing_ArrearsLedgerDistribution);
		}
		rs.close();
		ps.close();
		return billing_ArrearsLedgerDistributionList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_ArrearsLedgerDistribution> billing_Billses = Billing_ArrearsLedgerDistributionDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_ArrearsLedgerDistribution to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_ArrearsLedgerDistribution bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_ArrearsLedgerDistribution bill = Billing_ArrearsLedgerDistributionDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_ArrearsLedgerDistribution has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_ArrearsLedgerDistributionDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_ArrearsLedgerDistribution updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_ArrearsLedgerDistributionDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_ArrearsLedgerDistribution inserted";
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
