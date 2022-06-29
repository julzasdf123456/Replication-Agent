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
public class CRM_ServiceConnectionImagesDAO { 
	public static void insert(CRM_ServiceConnectionImages cRM_ServiceConnectionImages, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionImages(id, Photo, ServiceConnectionId, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionImages.getid());
		ps.setString(2, cRM_ServiceConnectionImages.getPhoto());
		ps.setString(3, cRM_ServiceConnectionImages.getServiceConnectionId());
		ps.setString(4, cRM_ServiceConnectionImages.getNotes());
		ps.setString(5, cRM_ServiceConnectionImages.getcreated_at());
		ps.setString(6, cRM_ServiceConnectionImages.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionImages cRM_ServiceConnectionImages, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionImages SET Photo=?, ServiceConnectionId=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionImages.getPhoto());
		ps.setString(2, cRM_ServiceConnectionImages.getServiceConnectionId());
		ps.setString(3, cRM_ServiceConnectionImages.getNotes());
		ps.setString(4, cRM_ServiceConnectionImages.getcreated_at());
		ps.setString(5, cRM_ServiceConnectionImages.getupdated_at());
		ps.setString(6, cRM_ServiceConnectionImages.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionImages getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionImages WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionImages cRM_ServiceConnectionImages = new CRM_ServiceConnectionImages(
			rs.getString("id"),
			rs.getString("Photo"),
			rs.getString("ServiceConnectionId"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionImages;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionImages> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionImages WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionImages> cRM_ServiceConnectionImagesList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionImages cRM_ServiceConnectionImages = new CRM_ServiceConnectionImages();
			cRM_ServiceConnectionImages.setid(rs.getString("id"));
			cRM_ServiceConnectionImages.setPhoto(rs.getString("Photo"));
			cRM_ServiceConnectionImages.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_ServiceConnectionImages.setNotes(rs.getString("Notes"));
			cRM_ServiceConnectionImages.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionImages.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionImagesList.add(cRM_ServiceConnectionImages);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionImagesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionImages> billing_Billses = CRM_ServiceConnectionImagesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionImages to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionImages bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionImages bill = CRM_ServiceConnectionImagesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionImages has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionImagesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionImages updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionImagesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionImages inserted";
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
