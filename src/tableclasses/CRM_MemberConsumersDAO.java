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
public class CRM_MemberConsumersDAO { 
	public static void insert(CRM_MemberConsumers cRM_MemberConsumers, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_MemberConsumers(Id, MembershipType, FirstName, MiddleName, LastName, Suffix, OrganizationName, Birthdate, Sitio, Barangay, Town, ContactNumbers, EmailAddress, DateApplied, DateOfPMS, DateApproved, CivilStatus, Religion, Citizenship, ApplicationStatus, Notes, Trashed, created_at, updated_at, Gender, OrganizationRepresentative, ResidenceNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_MemberConsumers.getId());
		ps.setString(2, cRM_MemberConsumers.getMembershipType());
		ps.setString(3, cRM_MemberConsumers.getFirstName());
		ps.setString(4, cRM_MemberConsumers.getMiddleName());
		ps.setString(5, cRM_MemberConsumers.getLastName());
		ps.setString(6, cRM_MemberConsumers.getSuffix());
		ps.setString(7, cRM_MemberConsumers.getOrganizationName());
		ps.setString(8, cRM_MemberConsumers.getBirthdate());
		ps.setString(9, cRM_MemberConsumers.getSitio());
		ps.setString(10, cRM_MemberConsumers.getBarangay());
		ps.setString(11, cRM_MemberConsumers.getTown());
		ps.setString(12, cRM_MemberConsumers.getContactNumbers());
		ps.setString(13, cRM_MemberConsumers.getEmailAddress());
		ps.setString(14, cRM_MemberConsumers.getDateApplied());
		ps.setString(15, cRM_MemberConsumers.getDateOfPMS());
		ps.setString(16, cRM_MemberConsumers.getDateApproved());
		ps.setString(17, cRM_MemberConsumers.getCivilStatus());
		ps.setString(18, cRM_MemberConsumers.getReligion());
		ps.setString(19, cRM_MemberConsumers.getCitizenship());
		ps.setString(20, cRM_MemberConsumers.getApplicationStatus());
		ps.setString(21, cRM_MemberConsumers.getNotes());
		ps.setString(22, cRM_MemberConsumers.getTrashed());
		ps.setString(23, cRM_MemberConsumers.getcreated_at());
		ps.setString(24, cRM_MemberConsumers.getupdated_at());
		ps.setString(25, cRM_MemberConsumers.getGender());
		ps.setString(26, cRM_MemberConsumers.getOrganizationRepresentative());
		ps.setString(27, cRM_MemberConsumers.getResidenceNumber());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_MemberConsumers cRM_MemberConsumers, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_MemberConsumers SET MembershipType=?, FirstName=?, MiddleName=?, LastName=?, Suffix=?, OrganizationName=?, Birthdate=?, Sitio=?, Barangay=?, Town=?, ContactNumbers=?, EmailAddress=?, DateApplied=?, DateOfPMS=?, DateApproved=?, CivilStatus=?, Religion=?, Citizenship=?, ApplicationStatus=?, Notes=?, Trashed=?, created_at=?, updated_at=?, Gender=?, OrganizationRepresentative=?, ResidenceNumber=?  WHERE Id=? ");
		ps.setString(1, cRM_MemberConsumers.getMembershipType());
		ps.setString(2, cRM_MemberConsumers.getFirstName());
		ps.setString(3, cRM_MemberConsumers.getMiddleName());
		ps.setString(4, cRM_MemberConsumers.getLastName());
		ps.setString(5, cRM_MemberConsumers.getSuffix());
		ps.setString(6, cRM_MemberConsumers.getOrganizationName());
		ps.setString(7, cRM_MemberConsumers.getBirthdate());
		ps.setString(8, cRM_MemberConsumers.getSitio());
		ps.setString(9, cRM_MemberConsumers.getBarangay());
		ps.setString(10, cRM_MemberConsumers.getTown());
		ps.setString(11, cRM_MemberConsumers.getContactNumbers());
		ps.setString(12, cRM_MemberConsumers.getEmailAddress());
		ps.setString(13, cRM_MemberConsumers.getDateApplied());
		ps.setString(14, cRM_MemberConsumers.getDateOfPMS());
		ps.setString(15, cRM_MemberConsumers.getDateApproved());
		ps.setString(16, cRM_MemberConsumers.getCivilStatus());
		ps.setString(17, cRM_MemberConsumers.getReligion());
		ps.setString(18, cRM_MemberConsumers.getCitizenship());
		ps.setString(19, cRM_MemberConsumers.getApplicationStatus());
		ps.setString(20, cRM_MemberConsumers.getNotes());
		ps.setString(21, cRM_MemberConsumers.getTrashed());
		ps.setString(22, cRM_MemberConsumers.getcreated_at());
		ps.setString(23, cRM_MemberConsumers.getupdated_at());
		ps.setString(24, cRM_MemberConsumers.getGender());
		ps.setString(25, cRM_MemberConsumers.getOrganizationRepresentative());
		ps.setString(26, cRM_MemberConsumers.getResidenceNumber());
		ps.setString(27, cRM_MemberConsumers.getId());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_MemberConsumers getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumers WHERE Id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_MemberConsumers cRM_MemberConsumers = new CRM_MemberConsumers(
			rs.getString("Id"),
			rs.getString("MembershipType"),
			rs.getString("FirstName"),
			rs.getString("MiddleName"),
			rs.getString("LastName"),
			rs.getString("Suffix"),
			rs.getString("OrganizationName"),
			rs.getString("Birthdate"),
			rs.getString("Sitio"),
			rs.getString("Barangay"),
			rs.getString("Town"),
			rs.getString("ContactNumbers"),
			rs.getString("EmailAddress"),
			rs.getString("DateApplied"),
			rs.getString("DateOfPMS"),
			rs.getString("DateApproved"),
			rs.getString("CivilStatus"),
			rs.getString("Religion"),
			rs.getString("Citizenship"),
			rs.getString("ApplicationStatus"),
			rs.getString("Notes"),
			rs.getString("Trashed"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Gender"),
			rs.getString("OrganizationRepresentative"),
			rs.getString("ResidenceNumber")
			);
			ps.close();
			rs.close();
			return cRM_MemberConsumers;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_MemberConsumers> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumers WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_MemberConsumers> cRM_MemberConsumersList = new ArrayList<>();
		while(rs.next()) {
			CRM_MemberConsumers cRM_MemberConsumers = new CRM_MemberConsumers();
			cRM_MemberConsumers.setId(rs.getString("Id"));
			cRM_MemberConsumers.setMembershipType(rs.getString("MembershipType"));
			cRM_MemberConsumers.setFirstName(rs.getString("FirstName"));
			cRM_MemberConsumers.setMiddleName(rs.getString("MiddleName"));
			cRM_MemberConsumers.setLastName(rs.getString("LastName"));
			cRM_MemberConsumers.setSuffix(rs.getString("Suffix"));
			cRM_MemberConsumers.setOrganizationName(rs.getString("OrganizationName"));
			cRM_MemberConsumers.setBirthdate(rs.getString("Birthdate"));
			cRM_MemberConsumers.setSitio(rs.getString("Sitio"));
			cRM_MemberConsumers.setBarangay(rs.getString("Barangay"));
			cRM_MemberConsumers.setTown(rs.getString("Town"));
			cRM_MemberConsumers.setContactNumbers(rs.getString("ContactNumbers"));
			cRM_MemberConsumers.setEmailAddress(rs.getString("EmailAddress"));
			cRM_MemberConsumers.setDateApplied(rs.getString("DateApplied"));
			cRM_MemberConsumers.setDateOfPMS(rs.getString("DateOfPMS"));
			cRM_MemberConsumers.setDateApproved(rs.getString("DateApproved"));
			cRM_MemberConsumers.setCivilStatus(rs.getString("CivilStatus"));
			cRM_MemberConsumers.setReligion(rs.getString("Religion"));
			cRM_MemberConsumers.setCitizenship(rs.getString("Citizenship"));
			cRM_MemberConsumers.setApplicationStatus(rs.getString("ApplicationStatus"));
			cRM_MemberConsumers.setNotes(rs.getString("Notes"));
			cRM_MemberConsumers.setTrashed(rs.getString("Trashed"));
			cRM_MemberConsumers.setcreated_at(rs.getString("created_at"));
			cRM_MemberConsumers.setupdated_at(rs.getString("updated_at"));
			cRM_MemberConsumers.setGender(rs.getString("Gender"));
			cRM_MemberConsumers.setOrganizationRepresentative(rs.getString("OrganizationRepresentative"));
			cRM_MemberConsumers.setResidenceNumber(rs.getString("ResidenceNumber"));
			cRM_MemberConsumersList.add(cRM_MemberConsumers);
		}
		rs.close();
		ps.close();
		return cRM_MemberConsumersList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_MemberConsumers> billing_Billses = CRM_MemberConsumersDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_MemberConsumers to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_MemberConsumers bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_MemberConsumers bill = CRM_MemberConsumersDAO.getOne(bills.getId(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getId() + " in CRM_MemberConsumers has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_MemberConsumersDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getId() + " in CRM_MemberConsumers updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_MemberConsumersDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getId() + " in CRM_MemberConsumers inserted";
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
