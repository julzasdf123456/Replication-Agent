package tableclasses;

import db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import others.ObjectHelpers;
import replicationagent.MainFrame;
public class Reports_RateItemsDAO { 
	public static void insert(Reports_RateItems reports_RateItems, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Reports_RateItems(id, RateItem, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, reports_RateItems.getid());
		ps.setString(2, reports_RateItems.getRateItem());
		ps.setString(3, reports_RateItems.getNotes());
		ps.setString(4, reports_RateItems.getcreated_at());
		ps.setString(5, reports_RateItems.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Reports_RateItems reports_RateItems, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Reports_RateItems SET RateItem=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, reports_RateItems.getRateItem());
		ps.setString(2, reports_RateItems.getNotes());
		ps.setString(3, reports_RateItems.getcreated_at());
		ps.setString(4, reports_RateItems.getupdated_at());
		ps.setString(5, reports_RateItems.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Reports_RateItems getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Reports_RateItems WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Reports_RateItems reports_RateItems = new Reports_RateItems(
			rs.getString("id"),
			rs.getString("RateItem"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return reports_RateItems;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Reports_RateItems> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Reports_RateItems WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Reports_RateItems> reports_RateItemsList = new ArrayList<>();
		while(rs.next()) {
			Reports_RateItems reports_RateItems = new Reports_RateItems();
			reports_RateItems.setid(rs.getString("id"));
			reports_RateItems.setRateItem(rs.getString("RateItem"));
			reports_RateItems.setNotes(rs.getString("Notes"));
			reports_RateItems.setcreated_at(rs.getString("created_at"));
			reports_RateItems.setupdated_at(rs.getString("updated_at"));
			reports_RateItemsList.add(reports_RateItems);
		}
		rs.close();
		ps.close();
		return reports_RateItemsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Reports_RateItems> billing_Billses = Reports_RateItemsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Reports_RateItems to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });
                int size = 0;
                for (Reports_RateItems bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Reports_RateItems bill = Reports_RateItemsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Reports_RateItems has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Reports_RateItemsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Reports_RateItems updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Reports_RateItemsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Reports_RateItems inserted";
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
                        size++;
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }                    
                }   
                
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
