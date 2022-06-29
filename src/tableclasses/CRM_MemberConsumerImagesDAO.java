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
public class CRM_MemberConsumerImagesDAO { 
	public static void insert(CRM_MemberConsumerImages cRM_MemberConsumerImages, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_MemberConsumerImages(id, ConsumerId, PicturePath, created_at, updated_at, HexImage) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_MemberConsumerImages.getid());
		ps.setString(2, cRM_MemberConsumerImages.getConsumerId());
		ps.setString(3, cRM_MemberConsumerImages.getPicturePath());
		ps.setString(4, cRM_MemberConsumerImages.getcreated_at());
		ps.setString(5, cRM_MemberConsumerImages.getupdated_at());
		ps.setString(6, cRM_MemberConsumerImages.getHexImage());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_MemberConsumerImages cRM_MemberConsumerImages, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_MemberConsumerImages SET ConsumerId=?, PicturePath=?, created_at=?, updated_at=?, HexImage=?  WHERE id=? ");
		ps.setString(1, cRM_MemberConsumerImages.getConsumerId());
		ps.setString(2, cRM_MemberConsumerImages.getPicturePath());
		ps.setString(3, cRM_MemberConsumerImages.getcreated_at());
		ps.setString(4, cRM_MemberConsumerImages.getupdated_at());
		ps.setString(5, cRM_MemberConsumerImages.getHexImage());
		ps.setString(6, cRM_MemberConsumerImages.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_MemberConsumerImages getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumerImages WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_MemberConsumerImages cRM_MemberConsumerImages = new CRM_MemberConsumerImages(
			rs.getString("id"),
			rs.getString("ConsumerId"),
			rs.getString("PicturePath"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("HexImage")
			);
			ps.close();
			rs.close();
			return cRM_MemberConsumerImages;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_MemberConsumerImages> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumerImages WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_MemberConsumerImages> cRM_MemberConsumerImagesList = new ArrayList<>();
		while(rs.next()) {
			CRM_MemberConsumerImages cRM_MemberConsumerImages = new CRM_MemberConsumerImages();
			cRM_MemberConsumerImages.setid(rs.getString("id"));
			cRM_MemberConsumerImages.setConsumerId(rs.getString("ConsumerId"));
			cRM_MemberConsumerImages.setPicturePath(rs.getString("PicturePath"));
			cRM_MemberConsumerImages.setcreated_at(rs.getString("created_at"));
			cRM_MemberConsumerImages.setupdated_at(rs.getString("updated_at"));
			cRM_MemberConsumerImages.setHexImage(rs.getString("HexImage"));
			cRM_MemberConsumerImagesList.add(cRM_MemberConsumerImages);
		}
		rs.close();
		ps.close();
		return cRM_MemberConsumerImagesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_MemberConsumerImages> billing_Billses = CRM_MemberConsumerImagesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_MemberConsumerImages to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_MemberConsumerImages bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_MemberConsumerImages bill = CRM_MemberConsumerImagesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_MemberConsumerImages has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_MemberConsumerImagesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_MemberConsumerImages updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_MemberConsumerImagesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_MemberConsumerImages inserted";
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
