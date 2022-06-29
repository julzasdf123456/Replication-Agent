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
public class NotifiersDAO { 
	public static void insert(Notifiers notifiers, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Notifiers(id, Notification, From, To, Status, Intent, IntentLink, ObjectId, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, notifiers.getid());
		ps.setString(2, notifiers.getNotification());
		ps.setString(3, notifiers.getFrom());
		ps.setString(4, notifiers.getTo());
		ps.setString(5, notifiers.getStatus());
		ps.setString(6, notifiers.getIntent());
		ps.setString(7, notifiers.getIntentLink());
		ps.setString(8, notifiers.getObjectId());
		ps.setString(9, notifiers.getcreated_at());
		ps.setString(10, notifiers.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Notifiers notifiers, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Notifiers SET Notification=?, From=?, To=?, Status=?, Intent=?, IntentLink=?, ObjectId=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, notifiers.getNotification());
		ps.setString(2, notifiers.getFrom());
		ps.setString(3, notifiers.getTo());
		ps.setString(4, notifiers.getStatus());
		ps.setString(5, notifiers.getIntent());
		ps.setString(6, notifiers.getIntentLink());
		ps.setString(7, notifiers.getObjectId());
		ps.setString(8, notifiers.getcreated_at());
		ps.setString(9, notifiers.getupdated_at());
		ps.setString(10, notifiers.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Notifiers getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Notifiers WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Notifiers notifiers = new Notifiers(
			rs.getString("id"),
			rs.getString("Notification"),
			rs.getString("From"),
			rs.getString("To"),
			rs.getString("Status"),
			rs.getString("Intent"),
			rs.getString("IntentLink"),
			rs.getString("ObjectId"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return notifiers;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Notifiers> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Notifiers WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Notifiers> notifiersList = new ArrayList<>();
		while(rs.next()) {
			Notifiers notifiers = new Notifiers();
			notifiers.setid(rs.getString("id"));
			notifiers.setNotification(rs.getString("Notification"));
			notifiers.setFrom(rs.getString("From"));
			notifiers.setTo(rs.getString("To"));
			notifiers.setStatus(rs.getString("Status"));
			notifiers.setIntent(rs.getString("Intent"));
			notifiers.setIntentLink(rs.getString("IntentLink"));
			notifiers.setObjectId(rs.getString("ObjectId"));
			notifiers.setcreated_at(rs.getString("created_at"));
			notifiers.setupdated_at(rs.getString("updated_at"));
			notifiersList.add(notifiers);
		}
		rs.close();
		ps.close();
		return notifiersList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Notifiers> billing_Billses = NotifiersDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Notifiers to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Notifiers bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Notifiers bill = NotifiersDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Notifiers has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        NotifiersDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Notifiers updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    NotifiersDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Notifiers inserted";
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
