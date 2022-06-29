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
public class CRM_MemberConsumerSpouseDAO { 
	public static void insert(CRM_MemberConsumerSpouse cRM_MemberConsumerSpouse, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_MemberConsumerSpouse(id, MemberConsumerId, FirstName, MiddleName, LastName, Suffix, Gender, Birthdate, Sitio, Barangay, Town, ContactNumbers, EmailAddress, Religion, Citizenship, Notes, Trashed, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_MemberConsumerSpouse.getid());
		ps.setString(2, cRM_MemberConsumerSpouse.getMemberConsumerId());
		ps.setString(3, cRM_MemberConsumerSpouse.getFirstName());
		ps.setString(4, cRM_MemberConsumerSpouse.getMiddleName());
		ps.setString(5, cRM_MemberConsumerSpouse.getLastName());
		ps.setString(6, cRM_MemberConsumerSpouse.getSuffix());
		ps.setString(7, cRM_MemberConsumerSpouse.getGender());
		ps.setString(8, cRM_MemberConsumerSpouse.getBirthdate());
		ps.setString(9, cRM_MemberConsumerSpouse.getSitio());
		ps.setString(10, cRM_MemberConsumerSpouse.getBarangay());
		ps.setString(11, cRM_MemberConsumerSpouse.getTown());
		ps.setString(12, cRM_MemberConsumerSpouse.getContactNumbers());
		ps.setString(13, cRM_MemberConsumerSpouse.getEmailAddress());
		ps.setString(14, cRM_MemberConsumerSpouse.getReligion());
		ps.setString(15, cRM_MemberConsumerSpouse.getCitizenship());
		ps.setString(16, cRM_MemberConsumerSpouse.getNotes());
		ps.setString(17, cRM_MemberConsumerSpouse.getTrashed());
		ps.setString(18, cRM_MemberConsumerSpouse.getcreated_at());
		ps.setString(19, cRM_MemberConsumerSpouse.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_MemberConsumerSpouse cRM_MemberConsumerSpouse, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_MemberConsumerSpouse SET MemberConsumerId=?, FirstName=?, MiddleName=?, LastName=?, Suffix=?, Gender=?, Birthdate=?, Sitio=?, Barangay=?, Town=?, ContactNumbers=?, EmailAddress=?, Religion=?, Citizenship=?, Notes=?, Trashed=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_MemberConsumerSpouse.getMemberConsumerId());
		ps.setString(2, cRM_MemberConsumerSpouse.getFirstName());
		ps.setString(3, cRM_MemberConsumerSpouse.getMiddleName());
		ps.setString(4, cRM_MemberConsumerSpouse.getLastName());
		ps.setString(5, cRM_MemberConsumerSpouse.getSuffix());
		ps.setString(6, cRM_MemberConsumerSpouse.getGender());
		ps.setString(7, cRM_MemberConsumerSpouse.getBirthdate());
		ps.setString(8, cRM_MemberConsumerSpouse.getSitio());
		ps.setString(9, cRM_MemberConsumerSpouse.getBarangay());
		ps.setString(10, cRM_MemberConsumerSpouse.getTown());
		ps.setString(11, cRM_MemberConsumerSpouse.getContactNumbers());
		ps.setString(12, cRM_MemberConsumerSpouse.getEmailAddress());
		ps.setString(13, cRM_MemberConsumerSpouse.getReligion());
		ps.setString(14, cRM_MemberConsumerSpouse.getCitizenship());
		ps.setString(15, cRM_MemberConsumerSpouse.getNotes());
		ps.setString(16, cRM_MemberConsumerSpouse.getTrashed());
		ps.setString(17, cRM_MemberConsumerSpouse.getcreated_at());
		ps.setString(18, cRM_MemberConsumerSpouse.getupdated_at());
		ps.setString(19, cRM_MemberConsumerSpouse.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_MemberConsumerSpouse getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumerSpouse WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_MemberConsumerSpouse cRM_MemberConsumerSpouse = new CRM_MemberConsumerSpouse(
			rs.getString("id"),
			rs.getString("MemberConsumerId"),
			rs.getString("FirstName"),
			rs.getString("MiddleName"),
			rs.getString("LastName"),
			rs.getString("Suffix"),
			rs.getString("Gender"),
			rs.getString("Birthdate"),
			rs.getString("Sitio"),
			rs.getString("Barangay"),
			rs.getString("Town"),
			rs.getString("ContactNumbers"),
			rs.getString("EmailAddress"),
			rs.getString("Religion"),
			rs.getString("Citizenship"),
			rs.getString("Notes"),
			rs.getString("Trashed"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_MemberConsumerSpouse;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_MemberConsumerSpouse> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumerSpouse WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_MemberConsumerSpouse> cRM_MemberConsumerSpouseList = new ArrayList<>();
		while(rs.next()) {
			CRM_MemberConsumerSpouse cRM_MemberConsumerSpouse = new CRM_MemberConsumerSpouse();
			cRM_MemberConsumerSpouse.setid(rs.getString("id"));
			cRM_MemberConsumerSpouse.setMemberConsumerId(rs.getString("MemberConsumerId"));
			cRM_MemberConsumerSpouse.setFirstName(rs.getString("FirstName"));
			cRM_MemberConsumerSpouse.setMiddleName(rs.getString("MiddleName"));
			cRM_MemberConsumerSpouse.setLastName(rs.getString("LastName"));
			cRM_MemberConsumerSpouse.setSuffix(rs.getString("Suffix"));
			cRM_MemberConsumerSpouse.setGender(rs.getString("Gender"));
			cRM_MemberConsumerSpouse.setBirthdate(rs.getString("Birthdate"));
			cRM_MemberConsumerSpouse.setSitio(rs.getString("Sitio"));
			cRM_MemberConsumerSpouse.setBarangay(rs.getString("Barangay"));
			cRM_MemberConsumerSpouse.setTown(rs.getString("Town"));
			cRM_MemberConsumerSpouse.setContactNumbers(rs.getString("ContactNumbers"));
			cRM_MemberConsumerSpouse.setEmailAddress(rs.getString("EmailAddress"));
			cRM_MemberConsumerSpouse.setReligion(rs.getString("Religion"));
			cRM_MemberConsumerSpouse.setCitizenship(rs.getString("Citizenship"));
			cRM_MemberConsumerSpouse.setNotes(rs.getString("Notes"));
			cRM_MemberConsumerSpouse.setTrashed(rs.getString("Trashed"));
			cRM_MemberConsumerSpouse.setcreated_at(rs.getString("created_at"));
			cRM_MemberConsumerSpouse.setupdated_at(rs.getString("updated_at"));
			cRM_MemberConsumerSpouseList.add(cRM_MemberConsumerSpouse);
		}
		rs.close();
		ps.close();
		return cRM_MemberConsumerSpouseList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_MemberConsumerSpouse> billing_Billses = CRM_MemberConsumerSpouseDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_MemberConsumerSpouse to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_MemberConsumerSpouse bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_MemberConsumerSpouse bill = CRM_MemberConsumerSpouseDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_MemberConsumerSpouse has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_MemberConsumerSpouseDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_MemberConsumerSpouse updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_MemberConsumerSpouseDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_MemberConsumerSpouse inserted";
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
