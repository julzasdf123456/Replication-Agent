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
public class CRM_ServiceConnectionsDAO { 
	public static void insert(CRM_ServiceConnections cRM_ServiceConnections, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnections(id, MemberConsumerId, DateOfApplication, ServiceAccountName, AccountCount, Sitio, Barangay, Town, ContactNumber, EmailAddress, AccountType, AccountOrganization, OrganizationAccountNumber, IsNIHE, AccountApplicationType, ConnectionApplicationType, Status, Notes, created_at, updated_at, BuildingType, Trash, ORNumber, ORDate, DateTimeOfEnergization, DateTimeLinemenArrived, EnergizationOrderIssued, DateTimeOfEnergizationIssue, StationCrewAssigned, LoadCategory, TemporaryDurationInMonths, LongSpan, Office, TypeOfOccupancy, ResidenceNumber, AccountNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnections.getid());
		ps.setString(2, cRM_ServiceConnections.getMemberConsumerId());
		ps.setString(3, cRM_ServiceConnections.getDateOfApplication());
		ps.setString(4, cRM_ServiceConnections.getServiceAccountName());
		ps.setString(5, cRM_ServiceConnections.getAccountCount());
		ps.setString(6, cRM_ServiceConnections.getSitio());
		ps.setString(7, cRM_ServiceConnections.getBarangay());
		ps.setString(8, cRM_ServiceConnections.getTown());
		ps.setString(9, cRM_ServiceConnections.getContactNumber());
		ps.setString(10, cRM_ServiceConnections.getEmailAddress());
		ps.setString(11, cRM_ServiceConnections.getAccountType());
		ps.setString(12, cRM_ServiceConnections.getAccountOrganization());
		ps.setString(13, cRM_ServiceConnections.getOrganizationAccountNumber());
		ps.setString(14, cRM_ServiceConnections.getIsNIHE());
		ps.setString(15, cRM_ServiceConnections.getAccountApplicationType());
		ps.setString(16, cRM_ServiceConnections.getConnectionApplicationType());
		ps.setString(17, cRM_ServiceConnections.getStatus());
		ps.setString(18, cRM_ServiceConnections.getNotes());
		ps.setString(19, cRM_ServiceConnections.getcreated_at());
		ps.setString(20, cRM_ServiceConnections.getupdated_at());
		ps.setString(21, cRM_ServiceConnections.getBuildingType());
		ps.setString(22, cRM_ServiceConnections.getTrash());
		ps.setString(23, cRM_ServiceConnections.getORNumber());
		ps.setString(24, cRM_ServiceConnections.getORDate());
		ps.setString(25, cRM_ServiceConnections.getDateTimeOfEnergization());
		ps.setString(26, cRM_ServiceConnections.getDateTimeLinemenArrived());
		ps.setString(27, cRM_ServiceConnections.getEnergizationOrderIssued());
		ps.setString(28, cRM_ServiceConnections.getDateTimeOfEnergizationIssue());
		ps.setString(29, cRM_ServiceConnections.getStationCrewAssigned());
		ps.setString(30, cRM_ServiceConnections.getLoadCategory());
		ps.setString(31, cRM_ServiceConnections.getTemporaryDurationInMonths());
		ps.setString(32, cRM_ServiceConnections.getLongSpan());
		ps.setString(33, cRM_ServiceConnections.getOffice());
		ps.setString(34, cRM_ServiceConnections.getTypeOfOccupancy());
		ps.setString(35, cRM_ServiceConnections.getResidenceNumber());
		ps.setString(36, cRM_ServiceConnections.getAccountNumber());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnections cRM_ServiceConnections, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnections SET MemberConsumerId=?, DateOfApplication=?, ServiceAccountName=?, AccountCount=?, Sitio=?, Barangay=?, Town=?, ContactNumber=?, EmailAddress=?, AccountType=?, AccountOrganization=?, OrganizationAccountNumber=?, IsNIHE=?, AccountApplicationType=?, ConnectionApplicationType=?, Status=?, Notes=?, created_at=?, updated_at=?, BuildingType=?, Trash=?, ORNumber=?, ORDate=?, DateTimeOfEnergization=?, DateTimeLinemenArrived=?, EnergizationOrderIssued=?, DateTimeOfEnergizationIssue=?, StationCrewAssigned=?, LoadCategory=?, TemporaryDurationInMonths=?, LongSpan=?, Office=?, TypeOfOccupancy=?, ResidenceNumber=?, AccountNumber=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnections.getMemberConsumerId());
		ps.setString(2, cRM_ServiceConnections.getDateOfApplication());
		ps.setString(3, cRM_ServiceConnections.getServiceAccountName());
		ps.setString(4, cRM_ServiceConnections.getAccountCount());
		ps.setString(5, cRM_ServiceConnections.getSitio());
		ps.setString(6, cRM_ServiceConnections.getBarangay());
		ps.setString(7, cRM_ServiceConnections.getTown());
		ps.setString(8, cRM_ServiceConnections.getContactNumber());
		ps.setString(9, cRM_ServiceConnections.getEmailAddress());
		ps.setString(10, cRM_ServiceConnections.getAccountType());
		ps.setString(11, cRM_ServiceConnections.getAccountOrganization());
		ps.setString(12, cRM_ServiceConnections.getOrganizationAccountNumber());
		ps.setString(13, cRM_ServiceConnections.getIsNIHE());
		ps.setString(14, cRM_ServiceConnections.getAccountApplicationType());
		ps.setString(15, cRM_ServiceConnections.getConnectionApplicationType());
		ps.setString(16, cRM_ServiceConnections.getStatus());
		ps.setString(17, cRM_ServiceConnections.getNotes());
		ps.setString(18, cRM_ServiceConnections.getcreated_at());
		ps.setString(19, cRM_ServiceConnections.getupdated_at());
		ps.setString(20, cRM_ServiceConnections.getBuildingType());
		ps.setString(21, cRM_ServiceConnections.getTrash());
		ps.setString(22, cRM_ServiceConnections.getORNumber());
		ps.setString(23, cRM_ServiceConnections.getORDate());
		ps.setString(24, cRM_ServiceConnections.getDateTimeOfEnergization());
		ps.setString(25, cRM_ServiceConnections.getDateTimeLinemenArrived());
		ps.setString(26, cRM_ServiceConnections.getEnergizationOrderIssued());
		ps.setString(27, cRM_ServiceConnections.getDateTimeOfEnergizationIssue());
		ps.setString(28, cRM_ServiceConnections.getStationCrewAssigned());
		ps.setString(29, cRM_ServiceConnections.getLoadCategory());
		ps.setString(30, cRM_ServiceConnections.getTemporaryDurationInMonths());
		ps.setString(31, cRM_ServiceConnections.getLongSpan());
		ps.setString(32, cRM_ServiceConnections.getOffice());
		ps.setString(33, cRM_ServiceConnections.getTypeOfOccupancy());
		ps.setString(34, cRM_ServiceConnections.getResidenceNumber());
		ps.setString(35, cRM_ServiceConnections.getAccountNumber());
		ps.setString(36, cRM_ServiceConnections.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnections getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnections WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnections cRM_ServiceConnections = new CRM_ServiceConnections(
			rs.getString("id"),
			rs.getString("MemberConsumerId"),
			rs.getString("DateOfApplication"),
			rs.getString("ServiceAccountName"),
			rs.getString("AccountCount"),
			rs.getString("Sitio"),
			rs.getString("Barangay"),
			rs.getString("Town"),
			rs.getString("ContactNumber"),
			rs.getString("EmailAddress"),
			rs.getString("AccountType"),
			rs.getString("AccountOrganization"),
			rs.getString("OrganizationAccountNumber"),
			rs.getString("IsNIHE"),
			rs.getString("AccountApplicationType"),
			rs.getString("ConnectionApplicationType"),
			rs.getString("Status"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("BuildingType"),
			rs.getString("Trash"),
			rs.getString("ORNumber"),
			rs.getString("ORDate"),
			rs.getString("DateTimeOfEnergization"),
			rs.getString("DateTimeLinemenArrived"),
			rs.getString("EnergizationOrderIssued"),
			rs.getString("DateTimeOfEnergizationIssue"),
			rs.getString("StationCrewAssigned"),
			rs.getString("LoadCategory"),
			rs.getString("TemporaryDurationInMonths"),
			rs.getString("LongSpan"),
			rs.getString("Office"),
			rs.getString("TypeOfOccupancy"),
			rs.getString("ResidenceNumber"),
			rs.getString("AccountNumber")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnections;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnections> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnections WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnections> cRM_ServiceConnectionsList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnections cRM_ServiceConnections = new CRM_ServiceConnections();
			cRM_ServiceConnections.setid(rs.getString("id"));
			cRM_ServiceConnections.setMemberConsumerId(rs.getString("MemberConsumerId"));
			cRM_ServiceConnections.setDateOfApplication(rs.getString("DateOfApplication"));
			cRM_ServiceConnections.setServiceAccountName(rs.getString("ServiceAccountName"));
			cRM_ServiceConnections.setAccountCount(rs.getString("AccountCount"));
			cRM_ServiceConnections.setSitio(rs.getString("Sitio"));
			cRM_ServiceConnections.setBarangay(rs.getString("Barangay"));
			cRM_ServiceConnections.setTown(rs.getString("Town"));
			cRM_ServiceConnections.setContactNumber(rs.getString("ContactNumber"));
			cRM_ServiceConnections.setEmailAddress(rs.getString("EmailAddress"));
			cRM_ServiceConnections.setAccountType(rs.getString("AccountType"));
			cRM_ServiceConnections.setAccountOrganization(rs.getString("AccountOrganization"));
			cRM_ServiceConnections.setOrganizationAccountNumber(rs.getString("OrganizationAccountNumber"));
			cRM_ServiceConnections.setIsNIHE(rs.getString("IsNIHE"));
			cRM_ServiceConnections.setAccountApplicationType(rs.getString("AccountApplicationType"));
			cRM_ServiceConnections.setConnectionApplicationType(rs.getString("ConnectionApplicationType"));
			cRM_ServiceConnections.setStatus(rs.getString("Status"));
			cRM_ServiceConnections.setNotes(rs.getString("Notes"));
			cRM_ServiceConnections.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnections.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnections.setBuildingType(rs.getString("BuildingType"));
			cRM_ServiceConnections.setTrash(rs.getString("Trash"));
			cRM_ServiceConnections.setORNumber(rs.getString("ORNumber"));
			cRM_ServiceConnections.setORDate(rs.getString("ORDate"));
			cRM_ServiceConnections.setDateTimeOfEnergization(rs.getString("DateTimeOfEnergization"));
			cRM_ServiceConnections.setDateTimeLinemenArrived(rs.getString("DateTimeLinemenArrived"));
			cRM_ServiceConnections.setEnergizationOrderIssued(rs.getString("EnergizationOrderIssued"));
			cRM_ServiceConnections.setDateTimeOfEnergizationIssue(rs.getString("DateTimeOfEnergizationIssue"));
			cRM_ServiceConnections.setStationCrewAssigned(rs.getString("StationCrewAssigned"));
			cRM_ServiceConnections.setLoadCategory(rs.getString("LoadCategory"));
			cRM_ServiceConnections.setTemporaryDurationInMonths(rs.getString("TemporaryDurationInMonths"));
			cRM_ServiceConnections.setLongSpan(rs.getString("LongSpan"));
			cRM_ServiceConnections.setOffice(rs.getString("Office"));
			cRM_ServiceConnections.setTypeOfOccupancy(rs.getString("TypeOfOccupancy"));
			cRM_ServiceConnections.setResidenceNumber(rs.getString("ResidenceNumber"));
			cRM_ServiceConnections.setAccountNumber(rs.getString("AccountNumber"));
			cRM_ServiceConnectionsList.add(cRM_ServiceConnections);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnections> billing_Billses = CRM_ServiceConnectionsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnections to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnections bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnections bill = CRM_ServiceConnectionsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnections has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnections updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnections inserted";
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
