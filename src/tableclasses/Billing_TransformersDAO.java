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
public class Billing_TransformersDAO { 
	public static void insert(Billing_Transformers billing_Transformers, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_Transformers(id, ServiceAccountId, TransformerNumber, Rating, RentalFee, Load, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_Transformers.getid());
		ps.setString(2, billing_Transformers.getServiceAccountId());
		ps.setString(3, billing_Transformers.getTransformerNumber());
		ps.setString(4, billing_Transformers.getRating());
		ps.setString(5, billing_Transformers.getRentalFee());
		ps.setString(6, billing_Transformers.getLoad());
		ps.setString(7, billing_Transformers.getcreated_at());
		ps.setString(8, billing_Transformers.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_Transformers billing_Transformers, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_Transformers SET ServiceAccountId=?, TransformerNumber=?, Rating=?, RentalFee=?, Load=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, billing_Transformers.getServiceAccountId());
		ps.setString(2, billing_Transformers.getTransformerNumber());
		ps.setString(3, billing_Transformers.getRating());
		ps.setString(4, billing_Transformers.getRentalFee());
		ps.setString(5, billing_Transformers.getLoad());
		ps.setString(6, billing_Transformers.getcreated_at());
		ps.setString(7, billing_Transformers.getupdated_at());
		ps.setString(8, billing_Transformers.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_Transformers getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Transformers WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_Transformers billing_Transformers = new Billing_Transformers(
			rs.getString("id"),
			rs.getString("ServiceAccountId"),
			rs.getString("TransformerNumber"),
			rs.getString("Rating"),
			rs.getString("RentalFee"),
			rs.getString("Load"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return billing_Transformers;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_Transformers> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Transformers WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_Transformers> billing_TransformersList = new ArrayList<>();
		while(rs.next()) {
			Billing_Transformers billing_Transformers = new Billing_Transformers();
			billing_Transformers.setid(rs.getString("id"));
			billing_Transformers.setServiceAccountId(rs.getString("ServiceAccountId"));
			billing_Transformers.setTransformerNumber(rs.getString("TransformerNumber"));
			billing_Transformers.setRating(rs.getString("Rating"));
			billing_Transformers.setRentalFee(rs.getString("RentalFee"));
			billing_Transformers.setLoad(rs.getString("Load"));
			billing_Transformers.setcreated_at(rs.getString("created_at"));
			billing_Transformers.setupdated_at(rs.getString("updated_at"));
			billing_TransformersList.add(billing_Transformers);
		}
		rs.close();
		ps.close();
		return billing_TransformersList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_Transformers> billing_Billses = Billing_TransformersDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_Transformers to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_Transformers bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_Transformers bill = Billing_TransformersDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_Transformers has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_TransformersDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_Transformers updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_TransformersDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_Transformers inserted";
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
