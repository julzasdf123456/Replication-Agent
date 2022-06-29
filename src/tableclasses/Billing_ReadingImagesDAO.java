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
public class Billing_ReadingImagesDAO { 
	public static void insert(Billing_ReadingImages billing_ReadingImages, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_ReadingImages(id, Photo, ReadingId, Notes, created_at, updated_at, ServicePeriod, AccountNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_ReadingImages.getid());
		ps.setString(2, billing_ReadingImages.getPhoto());
		ps.setString(3, billing_ReadingImages.getReadingId());
		ps.setString(4, billing_ReadingImages.getNotes());
		ps.setString(5, billing_ReadingImages.getcreated_at());
		ps.setString(6, billing_ReadingImages.getupdated_at());
		ps.setString(7, billing_ReadingImages.getServicePeriod());
		ps.setString(8, billing_ReadingImages.getAccountNumber());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_ReadingImages billing_ReadingImages, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_ReadingImages SET Photo=?, ReadingId=?, Notes=?, created_at=?, updated_at=?, ServicePeriod=?, AccountNumber=?  WHERE id=? ");
		ps.setString(1, billing_ReadingImages.getPhoto());
		ps.setString(2, billing_ReadingImages.getReadingId());
		ps.setString(3, billing_ReadingImages.getNotes());
		ps.setString(4, billing_ReadingImages.getcreated_at());
		ps.setString(5, billing_ReadingImages.getupdated_at());
		ps.setString(6, billing_ReadingImages.getServicePeriod());
		ps.setString(7, billing_ReadingImages.getAccountNumber());
		ps.setString(8, billing_ReadingImages.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_ReadingImages getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_ReadingImages WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_ReadingImages billing_ReadingImages = new Billing_ReadingImages(
			rs.getString("id"),
			rs.getString("Photo"),
			rs.getString("ReadingId"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("ServicePeriod"),
			rs.getString("AccountNumber")
			);
			ps.close();
			rs.close();
			return billing_ReadingImages;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_ReadingImages> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_ReadingImages WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_ReadingImages> billing_ReadingImagesList = new ArrayList<>();
		while(rs.next()) {
			Billing_ReadingImages billing_ReadingImages = new Billing_ReadingImages();
			billing_ReadingImages.setid(rs.getString("id"));
			billing_ReadingImages.setPhoto(rs.getString("Photo"));
			billing_ReadingImages.setReadingId(rs.getString("ReadingId"));
			billing_ReadingImages.setNotes(rs.getString("Notes"));
			billing_ReadingImages.setcreated_at(rs.getString("created_at"));
			billing_ReadingImages.setupdated_at(rs.getString("updated_at"));
			billing_ReadingImages.setServicePeriod(rs.getString("ServicePeriod"));
			billing_ReadingImages.setAccountNumber(rs.getString("AccountNumber"));
			billing_ReadingImagesList.add(billing_ReadingImages);
		}
		rs.close();
		ps.close();
		return billing_ReadingImagesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_ReadingImages> billing_Billses = Billing_ReadingImagesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_ReadingImages to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_ReadingImages bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_ReadingImages bill = Billing_ReadingImagesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_ReadingImages has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_ReadingImagesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_ReadingImages updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_ReadingImagesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_ReadingImages inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
