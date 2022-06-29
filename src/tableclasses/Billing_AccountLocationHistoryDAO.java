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
public class Billing_AccountLocationHistoryDAO { 
	public static void insert(Billing_AccountLocationHistory billing_AccountLocationHistory, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_AccountLocationHistory(id, AccountNumber, Town, Barangay, Purok, AreaCode, SequenceCode, MeterReader, ServiceConnectionId, RelocationDate, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_AccountLocationHistory.getid());
		ps.setString(2, billing_AccountLocationHistory.getAccountNumber());
		ps.setString(3, billing_AccountLocationHistory.getTown());
		ps.setString(4, billing_AccountLocationHistory.getBarangay());
		ps.setString(5, billing_AccountLocationHistory.getPurok());
		ps.setString(6, billing_AccountLocationHistory.getAreaCode());
		ps.setString(7, billing_AccountLocationHistory.getSequenceCode());
		ps.setString(8, billing_AccountLocationHistory.getMeterReader());
		ps.setString(9, billing_AccountLocationHistory.getServiceConnectionId());
		ps.setString(10, billing_AccountLocationHistory.getRelocationDate());
		ps.setString(11, billing_AccountLocationHistory.getcreated_at());
		ps.setString(12, billing_AccountLocationHistory.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_AccountLocationHistory billing_AccountLocationHistory, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_AccountLocationHistory SET AccountNumber=?, Town=?, Barangay=?, Purok=?, AreaCode=?, SequenceCode=?, MeterReader=?, ServiceConnectionId=?, RelocationDate=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, billing_AccountLocationHistory.getAccountNumber());
		ps.setString(2, billing_AccountLocationHistory.getTown());
		ps.setString(3, billing_AccountLocationHistory.getBarangay());
		ps.setString(4, billing_AccountLocationHistory.getPurok());
		ps.setString(5, billing_AccountLocationHistory.getAreaCode());
		ps.setString(6, billing_AccountLocationHistory.getSequenceCode());
		ps.setString(7, billing_AccountLocationHistory.getMeterReader());
		ps.setString(8, billing_AccountLocationHistory.getServiceConnectionId());
		ps.setString(9, billing_AccountLocationHistory.getRelocationDate());
		ps.setString(10, billing_AccountLocationHistory.getcreated_at());
		ps.setString(11, billing_AccountLocationHistory.getupdated_at());
		ps.setString(12, billing_AccountLocationHistory.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_AccountLocationHistory getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_AccountLocationHistory WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_AccountLocationHistory billing_AccountLocationHistory = new Billing_AccountLocationHistory(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("Town"),
			rs.getString("Barangay"),
			rs.getString("Purok"),
			rs.getString("AreaCode"),
			rs.getString("SequenceCode"),
			rs.getString("MeterReader"),
			rs.getString("ServiceConnectionId"),
			rs.getString("RelocationDate"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return billing_AccountLocationHistory;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_AccountLocationHistory> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_AccountLocationHistory WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_AccountLocationHistory> billing_AccountLocationHistoryList = new ArrayList<>();
		while(rs.next()) {
			Billing_AccountLocationHistory billing_AccountLocationHistory = new Billing_AccountLocationHistory();
			billing_AccountLocationHistory.setid(rs.getString("id"));
			billing_AccountLocationHistory.setAccountNumber(rs.getString("AccountNumber"));
			billing_AccountLocationHistory.setTown(rs.getString("Town"));
			billing_AccountLocationHistory.setBarangay(rs.getString("Barangay"));
			billing_AccountLocationHistory.setPurok(rs.getString("Purok"));
			billing_AccountLocationHistory.setAreaCode(rs.getString("AreaCode"));
			billing_AccountLocationHistory.setSequenceCode(rs.getString("SequenceCode"));
			billing_AccountLocationHistory.setMeterReader(rs.getString("MeterReader"));
			billing_AccountLocationHistory.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			billing_AccountLocationHistory.setRelocationDate(rs.getString("RelocationDate"));
			billing_AccountLocationHistory.setcreated_at(rs.getString("created_at"));
			billing_AccountLocationHistory.setupdated_at(rs.getString("updated_at"));
			billing_AccountLocationHistoryList.add(billing_AccountLocationHistory);
		}
		rs.close();
		ps.close();
		return billing_AccountLocationHistoryList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_AccountLocationHistory> accountHistories = Billing_AccountLocationHistoryDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_AccountLocationHistory to " + subscriberSelected + " (" + accountHistories.size() + " data found)");
                    }
                });

                for (Billing_AccountLocationHistory accountHistory : accountHistories) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_AccountLocationHistory accountHistorySub = Billing_AccountLocationHistoryDAO.getOne(accountHistory.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (accountHistorySub != null) {
                                    // UPDATE MODULE
                                    if (accountHistory.getupdated_at().equals(accountHistorySub.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + accountHistorySub.getid() + " in Billing_AccountLocationHistory has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_AccountLocationHistoryDAO.update(accountHistorySub, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + accountHistorySub.getid() + " in Billing_AccountLocationHistory updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_AccountLocationHistoryDAO.insert(accountHistory, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + accountHistory.getid() + " in Billing_AccountLocationHistory inserted";
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
