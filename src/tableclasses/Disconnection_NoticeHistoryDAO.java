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
public class Disconnection_NoticeHistoryDAO { 
	public static void insert(Disconnection_NoticeHistory disconnection_NoticeHistory, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Disconnection_NoticeHistory(id, AccountNumber, ServicePeriod, BillId, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, disconnection_NoticeHistory.getid());
		ps.setString(2, disconnection_NoticeHistory.getAccountNumber());
		ps.setString(3, disconnection_NoticeHistory.getServicePeriod());
		ps.setString(4, disconnection_NoticeHistory.getBillId());
		ps.setString(5, disconnection_NoticeHistory.getcreated_at());
		ps.setString(6, disconnection_NoticeHistory.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Disconnection_NoticeHistory disconnection_NoticeHistory, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Disconnection_NoticeHistory SET AccountNumber=?, ServicePeriod=?, BillId=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, disconnection_NoticeHistory.getAccountNumber());
		ps.setString(2, disconnection_NoticeHistory.getServicePeriod());
		ps.setString(3, disconnection_NoticeHistory.getBillId());
		ps.setString(4, disconnection_NoticeHistory.getcreated_at());
		ps.setString(5, disconnection_NoticeHistory.getupdated_at());
		ps.setString(6, disconnection_NoticeHistory.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Disconnection_NoticeHistory getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Disconnection_NoticeHistory WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Disconnection_NoticeHistory disconnection_NoticeHistory = new Disconnection_NoticeHistory(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("ServicePeriod"),
			rs.getString("BillId"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return disconnection_NoticeHistory;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Disconnection_NoticeHistory> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Disconnection_NoticeHistory WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Disconnection_NoticeHistory> disconnection_NoticeHistoryList = new ArrayList<>();
		while(rs.next()) {
			Disconnection_NoticeHistory disconnection_NoticeHistory = new Disconnection_NoticeHistory();
			disconnection_NoticeHistory.setid(rs.getString("id"));
			disconnection_NoticeHistory.setAccountNumber(rs.getString("AccountNumber"));
			disconnection_NoticeHistory.setServicePeriod(rs.getString("ServicePeriod"));
			disconnection_NoticeHistory.setBillId(rs.getString("BillId"));
			disconnection_NoticeHistory.setcreated_at(rs.getString("created_at"));
			disconnection_NoticeHistory.setupdated_at(rs.getString("updated_at"));
			disconnection_NoticeHistoryList.add(disconnection_NoticeHistory);
		}
		rs.close();
		ps.close();
		return disconnection_NoticeHistoryList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Disconnection_NoticeHistory> billing_Billses = Disconnection_NoticeHistoryDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Disconnection_NoticeHistory to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Disconnection_NoticeHistory bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Disconnection_NoticeHistory bill = Disconnection_NoticeHistoryDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Disconnection_NoticeHistory has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Disconnection_NoticeHistoryDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Disconnection_NoticeHistory updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Disconnection_NoticeHistoryDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Disconnection_NoticeHistory inserted";
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
