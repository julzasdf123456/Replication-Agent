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
public class Billing_ServiceAccountsDAO { 
	public static void insert(Billing_ServiceAccounts billing_ServiceAccounts, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_ServiceAccounts(id, ServiceAccountName, Town, Barangay, Purok, AccountType, AccountStatus, ContactNumber, EmailAddress, ServiceConnectionId, MeterDetailsId, TransformerDetailsId, PoleNumber, AreaCode, BlockCode, SequenceCode, Feeder, ComputeType, Organization, OrganizationParentAccount, GPSMeter, created_at, updated_at, BillingType, SeniorCitizen, Locked, AccountCount, OldAccountNo, UserId, MeterReader, GroupCode, ForDistribution, Multiplier, Coreloss, Main, Evat5Percent, Ewt2Percent, ConnectionDate, LatestReadingDate, DateDisconnected, DateTransfered, AccountPaymentType, Latitude, Longitude, AccountRetention, AccountExpiration, DurationInMonths, Contestable, NetMetered, Notes, Migrated, MemberConsumerId, DistributionAccountCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_ServiceAccounts.getid());
		ps.setString(2, billing_ServiceAccounts.getServiceAccountName());
		ps.setString(3, billing_ServiceAccounts.getTown());
		ps.setString(4, billing_ServiceAccounts.getBarangay());
		ps.setString(5, billing_ServiceAccounts.getPurok());
		ps.setString(6, billing_ServiceAccounts.getAccountType());
		ps.setString(7, billing_ServiceAccounts.getAccountStatus());
		ps.setString(8, billing_ServiceAccounts.getContactNumber());
		ps.setString(9, billing_ServiceAccounts.getEmailAddress());
		ps.setString(10, billing_ServiceAccounts.getServiceConnectionId());
		ps.setString(11, billing_ServiceAccounts.getMeterDetailsId());
		ps.setString(12, billing_ServiceAccounts.getTransformerDetailsId());
		ps.setString(13, billing_ServiceAccounts.getPoleNumber());
		ps.setString(14, billing_ServiceAccounts.getAreaCode());
		ps.setString(15, billing_ServiceAccounts.getBlockCode());
		ps.setString(16, billing_ServiceAccounts.getSequenceCode());
		ps.setString(17, billing_ServiceAccounts.getFeeder());
		ps.setString(18, billing_ServiceAccounts.getComputeType());
		ps.setString(19, billing_ServiceAccounts.getOrganization());
		ps.setString(20, billing_ServiceAccounts.getOrganizationParentAccount());
		ps.setString(21, billing_ServiceAccounts.getGPSMeter());
		ps.setString(22, billing_ServiceAccounts.getcreated_at());
		ps.setString(23, billing_ServiceAccounts.getupdated_at());
		ps.setString(24, billing_ServiceAccounts.getBillingType());
		ps.setString(25, billing_ServiceAccounts.getSeniorCitizen());
		ps.setString(26, billing_ServiceAccounts.getLocked());
		ps.setString(27, billing_ServiceAccounts.getAccountCount());
		ps.setString(28, billing_ServiceAccounts.getOldAccountNo());
		ps.setString(29, billing_ServiceAccounts.getUserId());
		ps.setString(30, billing_ServiceAccounts.getMeterReader());
		ps.setString(31, billing_ServiceAccounts.getGroupCode());
		ps.setString(32, billing_ServiceAccounts.getForDistribution());
		ps.setString(33, billing_ServiceAccounts.getMultiplier());
		ps.setString(34, billing_ServiceAccounts.getCoreloss());
		ps.setString(35, billing_ServiceAccounts.getMain());
		ps.setString(36, billing_ServiceAccounts.getEvat5Percent());
		ps.setString(37, billing_ServiceAccounts.getEwt2Percent());
		ps.setString(38, billing_ServiceAccounts.getConnectionDate());
		ps.setString(39, billing_ServiceAccounts.getLatestReadingDate());
		ps.setString(40, billing_ServiceAccounts.getDateDisconnected());
		ps.setString(41, billing_ServiceAccounts.getDateTransfered());
		ps.setString(42, billing_ServiceAccounts.getAccountPaymentType());
		ps.setString(43, billing_ServiceAccounts.getLatitude());
		ps.setString(44, billing_ServiceAccounts.getLongitude());
		ps.setString(45, billing_ServiceAccounts.getAccountRetention());
		ps.setString(46, billing_ServiceAccounts.getAccountExpiration());
		ps.setString(47, billing_ServiceAccounts.getDurationInMonths());
		ps.setString(48, billing_ServiceAccounts.getContestable());
		ps.setString(49, billing_ServiceAccounts.getNetMetered());
		ps.setString(50, billing_ServiceAccounts.getNotes());
		ps.setString(51, billing_ServiceAccounts.getMigrated());
		ps.setString(52, billing_ServiceAccounts.getMemberConsumerId());
		ps.setString(53, billing_ServiceAccounts.getDistributionAccountCode());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_ServiceAccounts billing_ServiceAccounts, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_ServiceAccounts SET ServiceAccountName=?, Town=?, Barangay=?, Purok=?, AccountType=?, AccountStatus=?, ContactNumber=?, EmailAddress=?, ServiceConnectionId=?, MeterDetailsId=?, TransformerDetailsId=?, PoleNumber=?, AreaCode=?, BlockCode=?, SequenceCode=?, Feeder=?, ComputeType=?, Organization=?, OrganizationParentAccount=?, GPSMeter=?, created_at=?, updated_at=?, BillingType=?, SeniorCitizen=?, Locked=?, AccountCount=?, OldAccountNo=?, UserId=?, MeterReader=?, GroupCode=?, ForDistribution=?, Multiplier=?, Coreloss=?, Main=?, Evat5Percent=?, Ewt2Percent=?, ConnectionDate=?, LatestReadingDate=?, DateDisconnected=?, DateTransfered=?, AccountPaymentType=?, Latitude=?, Longitude=?, AccountRetention=?, AccountExpiration=?, DurationInMonths=?, Contestable=?, NetMetered=?, Notes=?, Migrated=?, MemberConsumerId=?, DistributionAccountCode=?  WHERE id=? ");
		ps.setString(1, billing_ServiceAccounts.getServiceAccountName());
		ps.setString(2, billing_ServiceAccounts.getTown());
		ps.setString(3, billing_ServiceAccounts.getBarangay());
		ps.setString(4, billing_ServiceAccounts.getPurok());
		ps.setString(5, billing_ServiceAccounts.getAccountType());
		ps.setString(6, billing_ServiceAccounts.getAccountStatus());
		ps.setString(7, billing_ServiceAccounts.getContactNumber());
		ps.setString(8, billing_ServiceAccounts.getEmailAddress());
		ps.setString(9, billing_ServiceAccounts.getServiceConnectionId());
		ps.setString(10, billing_ServiceAccounts.getMeterDetailsId());
		ps.setString(11, billing_ServiceAccounts.getTransformerDetailsId());
		ps.setString(12, billing_ServiceAccounts.getPoleNumber());
		ps.setString(13, billing_ServiceAccounts.getAreaCode());
		ps.setString(14, billing_ServiceAccounts.getBlockCode());
		ps.setString(15, billing_ServiceAccounts.getSequenceCode());
		ps.setString(16, billing_ServiceAccounts.getFeeder());
		ps.setString(17, billing_ServiceAccounts.getComputeType());
		ps.setString(18, billing_ServiceAccounts.getOrganization());
		ps.setString(19, billing_ServiceAccounts.getOrganizationParentAccount());
		ps.setString(20, billing_ServiceAccounts.getGPSMeter());
		ps.setString(21, billing_ServiceAccounts.getcreated_at());
		ps.setString(22, billing_ServiceAccounts.getupdated_at());
		ps.setString(23, billing_ServiceAccounts.getBillingType());
		ps.setString(24, billing_ServiceAccounts.getSeniorCitizen());
		ps.setString(25, billing_ServiceAccounts.getLocked());
		ps.setString(26, billing_ServiceAccounts.getAccountCount());
		ps.setString(27, billing_ServiceAccounts.getOldAccountNo());
		ps.setString(28, billing_ServiceAccounts.getUserId());
		ps.setString(29, billing_ServiceAccounts.getMeterReader());
		ps.setString(30, billing_ServiceAccounts.getGroupCode());
		ps.setString(31, billing_ServiceAccounts.getForDistribution());
		ps.setString(32, billing_ServiceAccounts.getMultiplier());
		ps.setString(33, billing_ServiceAccounts.getCoreloss());
		ps.setString(34, billing_ServiceAccounts.getMain());
		ps.setString(35, billing_ServiceAccounts.getEvat5Percent());
		ps.setString(36, billing_ServiceAccounts.getEwt2Percent());
		ps.setString(37, billing_ServiceAccounts.getConnectionDate());
		ps.setString(38, billing_ServiceAccounts.getLatestReadingDate());
		ps.setString(39, billing_ServiceAccounts.getDateDisconnected());
		ps.setString(40, billing_ServiceAccounts.getDateTransfered());
		ps.setString(41, billing_ServiceAccounts.getAccountPaymentType());
		ps.setString(42, billing_ServiceAccounts.getLatitude());
		ps.setString(43, billing_ServiceAccounts.getLongitude());
		ps.setString(44, billing_ServiceAccounts.getAccountRetention());
		ps.setString(45, billing_ServiceAccounts.getAccountExpiration());
		ps.setString(46, billing_ServiceAccounts.getDurationInMonths());
		ps.setString(47, billing_ServiceAccounts.getContestable());
		ps.setString(48, billing_ServiceAccounts.getNetMetered());
		ps.setString(49, billing_ServiceAccounts.getNotes());
		ps.setString(50, billing_ServiceAccounts.getMigrated());
		ps.setString(51, billing_ServiceAccounts.getMemberConsumerId());
		ps.setString(52, billing_ServiceAccounts.getDistributionAccountCode());
		ps.setString(53, billing_ServiceAccounts.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_ServiceAccounts getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_ServiceAccounts WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_ServiceAccounts billing_ServiceAccounts = new Billing_ServiceAccounts(
			rs.getString("id"),
			rs.getString("ServiceAccountName"),
			rs.getString("Town"),
			rs.getString("Barangay"),
			rs.getString("Purok"),
			rs.getString("AccountType"),
			rs.getString("AccountStatus"),
			rs.getString("ContactNumber"),
			rs.getString("EmailAddress"),
			rs.getString("ServiceConnectionId"),
			rs.getString("MeterDetailsId"),
			rs.getString("TransformerDetailsId"),
			rs.getString("PoleNumber"),
			rs.getString("AreaCode"),
			rs.getString("BlockCode"),
			rs.getString("SequenceCode"),
			rs.getString("Feeder"),
			rs.getString("ComputeType"),
			rs.getString("Organization"),
			rs.getString("OrganizationParentAccount"),
			rs.getString("GPSMeter"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("BillingType"),
			rs.getString("SeniorCitizen"),
			rs.getString("Locked"),
			rs.getString("AccountCount"),
			rs.getString("OldAccountNo"),
			rs.getString("UserId"),
			rs.getString("MeterReader"),
			rs.getString("GroupCode"),
			rs.getString("ForDistribution"),
			rs.getString("Multiplier"),
			rs.getString("Coreloss"),
			rs.getString("Main"),
			rs.getString("Evat5Percent"),
			rs.getString("Ewt2Percent"),
			rs.getString("ConnectionDate"),
			rs.getString("LatestReadingDate"),
			rs.getString("DateDisconnected"),
			rs.getString("DateTransfered"),
			rs.getString("AccountPaymentType"),
			rs.getString("Latitude"),
			rs.getString("Longitude"),
			rs.getString("AccountRetention"),
			rs.getString("AccountExpiration"),
			rs.getString("DurationInMonths"),
			rs.getString("Contestable"),
			rs.getString("NetMetered"),
			rs.getString("Notes"),
			rs.getString("Migrated"),
			rs.getString("MemberConsumerId"),
			rs.getString("DistributionAccountCode")
			);
			ps.close();
			rs.close();
			return billing_ServiceAccounts;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_ServiceAccounts> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_ServiceAccounts WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_ServiceAccounts> billing_ServiceAccountsList = new ArrayList<>();
		while(rs.next()) {
			Billing_ServiceAccounts billing_ServiceAccounts = new Billing_ServiceAccounts();
			billing_ServiceAccounts.setid(rs.getString("id"));
			billing_ServiceAccounts.setServiceAccountName(rs.getString("ServiceAccountName"));
			billing_ServiceAccounts.setTown(rs.getString("Town"));
			billing_ServiceAccounts.setBarangay(rs.getString("Barangay"));
			billing_ServiceAccounts.setPurok(rs.getString("Purok"));
			billing_ServiceAccounts.setAccountType(rs.getString("AccountType"));
			billing_ServiceAccounts.setAccountStatus(rs.getString("AccountStatus"));
			billing_ServiceAccounts.setContactNumber(rs.getString("ContactNumber"));
			billing_ServiceAccounts.setEmailAddress(rs.getString("EmailAddress"));
			billing_ServiceAccounts.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			billing_ServiceAccounts.setMeterDetailsId(rs.getString("MeterDetailsId"));
			billing_ServiceAccounts.setTransformerDetailsId(rs.getString("TransformerDetailsId"));
			billing_ServiceAccounts.setPoleNumber(rs.getString("PoleNumber"));
			billing_ServiceAccounts.setAreaCode(rs.getString("AreaCode"));
			billing_ServiceAccounts.setBlockCode(rs.getString("BlockCode"));
			billing_ServiceAccounts.setSequenceCode(rs.getString("SequenceCode"));
			billing_ServiceAccounts.setFeeder(rs.getString("Feeder"));
			billing_ServiceAccounts.setComputeType(rs.getString("ComputeType"));
			billing_ServiceAccounts.setOrganization(rs.getString("Organization"));
			billing_ServiceAccounts.setOrganizationParentAccount(rs.getString("OrganizationParentAccount"));
			billing_ServiceAccounts.setGPSMeter(rs.getString("GPSMeter"));
			billing_ServiceAccounts.setcreated_at(rs.getString("created_at"));
			billing_ServiceAccounts.setupdated_at(rs.getString("updated_at"));
			billing_ServiceAccounts.setBillingType(rs.getString("BillingType"));
			billing_ServiceAccounts.setSeniorCitizen(rs.getString("SeniorCitizen"));
			billing_ServiceAccounts.setLocked(rs.getString("Locked"));
			billing_ServiceAccounts.setAccountCount(rs.getString("AccountCount"));
			billing_ServiceAccounts.setOldAccountNo(rs.getString("OldAccountNo"));
			billing_ServiceAccounts.setUserId(rs.getString("UserId"));
			billing_ServiceAccounts.setMeterReader(rs.getString("MeterReader"));
			billing_ServiceAccounts.setGroupCode(rs.getString("GroupCode"));
			billing_ServiceAccounts.setForDistribution(rs.getString("ForDistribution"));
			billing_ServiceAccounts.setMultiplier(rs.getString("Multiplier"));
			billing_ServiceAccounts.setCoreloss(rs.getString("Coreloss"));
			billing_ServiceAccounts.setMain(rs.getString("Main"));
			billing_ServiceAccounts.setEvat5Percent(rs.getString("Evat5Percent"));
			billing_ServiceAccounts.setEwt2Percent(rs.getString("Ewt2Percent"));
			billing_ServiceAccounts.setConnectionDate(rs.getString("ConnectionDate"));
			billing_ServiceAccounts.setLatestReadingDate(rs.getString("LatestReadingDate"));
			billing_ServiceAccounts.setDateDisconnected(rs.getString("DateDisconnected"));
			billing_ServiceAccounts.setDateTransfered(rs.getString("DateTransfered"));
			billing_ServiceAccounts.setAccountPaymentType(rs.getString("AccountPaymentType"));
			billing_ServiceAccounts.setLatitude(rs.getString("Latitude"));
			billing_ServiceAccounts.setLongitude(rs.getString("Longitude"));
			billing_ServiceAccounts.setAccountRetention(rs.getString("AccountRetention"));
			billing_ServiceAccounts.setAccountExpiration(rs.getString("AccountExpiration"));
			billing_ServiceAccounts.setDurationInMonths(rs.getString("DurationInMonths"));
			billing_ServiceAccounts.setContestable(rs.getString("Contestable"));
			billing_ServiceAccounts.setNetMetered(rs.getString("NetMetered"));
			billing_ServiceAccounts.setNotes(rs.getString("Notes"));
			billing_ServiceAccounts.setMigrated(rs.getString("Migrated"));
			billing_ServiceAccounts.setMemberConsumerId(rs.getString("MemberConsumerId"));
			billing_ServiceAccounts.setDistributionAccountCode(rs.getString("DistributionAccountCode"));
			billing_ServiceAccountsList.add(billing_ServiceAccounts);
		}
		rs.close();
		ps.close();
		return billing_ServiceAccountsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_ServiceAccounts> billing_Billses = Billing_ServiceAccountsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_ServiceAccounts to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_ServiceAccounts bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_ServiceAccounts bill = Billing_ServiceAccountsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_ServiceAccounts has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_ServiceAccountsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_ServiceAccounts updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_ServiceAccountsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_ServiceAccounts inserted";
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
