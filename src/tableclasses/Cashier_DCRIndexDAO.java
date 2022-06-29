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
public class Cashier_DCRIndexDAO { 
	public static void insert(Cashier_DCRIndex cashier_DCRIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_DCRIndex(id, GLCode, NEACode, TableName, Columns, created_at, updated_at, TownCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_DCRIndex.getid());
		ps.setString(2, cashier_DCRIndex.getGLCode());
		ps.setString(3, cashier_DCRIndex.getNEACode());
		ps.setString(4, cashier_DCRIndex.getTableName());
		ps.setString(5, cashier_DCRIndex.getColumns());
		ps.setString(6, cashier_DCRIndex.getcreated_at());
		ps.setString(7, cashier_DCRIndex.getupdated_at());
		ps.setString(8, cashier_DCRIndex.getTownCode());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_DCRIndex cashier_DCRIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_DCRIndex SET GLCode=?, NEACode=?, TableName=?, Columns=?, created_at=?, updated_at=?, TownCode=?  WHERE id=? ");
		ps.setString(1, cashier_DCRIndex.getGLCode());
		ps.setString(2, cashier_DCRIndex.getNEACode());
		ps.setString(3, cashier_DCRIndex.getTableName());
		ps.setString(4, cashier_DCRIndex.getColumns());
		ps.setString(5, cashier_DCRIndex.getcreated_at());
		ps.setString(6, cashier_DCRIndex.getupdated_at());
		ps.setString(7, cashier_DCRIndex.getTownCode());
		ps.setString(8, cashier_DCRIndex.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_DCRIndex getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_DCRIndex WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_DCRIndex cashier_DCRIndex = new Cashier_DCRIndex(
			rs.getString("id"),
			rs.getString("GLCode"),
			rs.getString("NEACode"),
			rs.getString("TableName"),
			rs.getString("Columns"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("TownCode")
			);
			ps.close();
			rs.close();
			return cashier_DCRIndex;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_DCRIndex> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_DCRIndex WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_DCRIndex> cashier_DCRIndexList = new ArrayList<>();
		while(rs.next()) {
			Cashier_DCRIndex cashier_DCRIndex = new Cashier_DCRIndex();
			cashier_DCRIndex.setid(rs.getString("id"));
			cashier_DCRIndex.setGLCode(rs.getString("GLCode"));
			cashier_DCRIndex.setNEACode(rs.getString("NEACode"));
			cashier_DCRIndex.setTableName(rs.getString("TableName"));
			cashier_DCRIndex.setColumns(rs.getString("Columns"));
			cashier_DCRIndex.setcreated_at(rs.getString("created_at"));
			cashier_DCRIndex.setupdated_at(rs.getString("updated_at"));
			cashier_DCRIndex.setTownCode(rs.getString("TownCode"));
			cashier_DCRIndexList.add(cashier_DCRIndex);
		}
		rs.close();
		ps.close();
		return cashier_DCRIndexList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_DCRIndex> billing_Billses = Cashier_DCRIndexDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_DCRIndex to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_DCRIndex bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_DCRIndex bill = Cashier_DCRIndexDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_DCRIndex has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_DCRIndexDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_DCRIndex updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_DCRIndexDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_DCRIndex inserted";
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
