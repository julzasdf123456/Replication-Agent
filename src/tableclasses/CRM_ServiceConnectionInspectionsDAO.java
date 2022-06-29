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
public class CRM_ServiceConnectionInspectionsDAO { 
	public static void insert(CRM_ServiceConnectionInspections cRM_ServiceConnectionInspections, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionInspections(id, ServiceConnectionId, SEMainCircuitBreakerAsPlan, SEMainCircuitBreakerAsInstalled, SENoOfBranchesAsPlan, SENoOfBranchesAsInstalled, PoleGIEstimatedDiameter, PoleGIHeight, PoleGINoOfLiftPoles, PoleConcreteEstimatedDiameter, PoleConcreteHeight, PoleConcreteNoOfLiftPoles, PoleHardwoodEstimatedDiameter, PoleHardwoodHeight, PoleHardwoodNoOfLiftPoles, PoleRemarks, SDWSizeAsPlan, SDWSizeAsInstalled, SDWLengthAsPlan, SDWLengthAsInstalled, GeoBuilding, GeoTappingPole, GeoMeteringPole, GeoSEPole, FirstNeighborName, FirstNeighborMeterSerial, SecondNeighborName, SecondNeighborMeterSerial, EngineerInchargeName, EngineerInchargeTitle, EngineerInchargeLicenseNo, EngineerInchargeLicenseValidity, EngineerInchargeContactNo, Status, Inspector, DateOfVerification, EstimatedDateForReinspection, Notes, created_at, updated_at, PoleNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionInspections.getid());
		ps.setString(2, cRM_ServiceConnectionInspections.getServiceConnectionId());
		ps.setString(3, cRM_ServiceConnectionInspections.getSEMainCircuitBreakerAsPlan());
		ps.setString(4, cRM_ServiceConnectionInspections.getSEMainCircuitBreakerAsInstalled());
		ps.setString(5, cRM_ServiceConnectionInspections.getSENoOfBranchesAsPlan());
		ps.setString(6, cRM_ServiceConnectionInspections.getSENoOfBranchesAsInstalled());
		ps.setString(7, cRM_ServiceConnectionInspections.getPoleGIEstimatedDiameter());
		ps.setString(8, cRM_ServiceConnectionInspections.getPoleGIHeight());
		ps.setString(9, cRM_ServiceConnectionInspections.getPoleGINoOfLiftPoles());
		ps.setString(10, cRM_ServiceConnectionInspections.getPoleConcreteEstimatedDiameter());
		ps.setString(11, cRM_ServiceConnectionInspections.getPoleConcreteHeight());
		ps.setString(12, cRM_ServiceConnectionInspections.getPoleConcreteNoOfLiftPoles());
		ps.setString(13, cRM_ServiceConnectionInspections.getPoleHardwoodEstimatedDiameter());
		ps.setString(14, cRM_ServiceConnectionInspections.getPoleHardwoodHeight());
		ps.setString(15, cRM_ServiceConnectionInspections.getPoleHardwoodNoOfLiftPoles());
		ps.setString(16, cRM_ServiceConnectionInspections.getPoleRemarks());
		ps.setString(17, cRM_ServiceConnectionInspections.getSDWSizeAsPlan());
		ps.setString(18, cRM_ServiceConnectionInspections.getSDWSizeAsInstalled());
		ps.setString(19, cRM_ServiceConnectionInspections.getSDWLengthAsPlan());
		ps.setString(20, cRM_ServiceConnectionInspections.getSDWLengthAsInstalled());
		ps.setString(21, cRM_ServiceConnectionInspections.getGeoBuilding());
		ps.setString(22, cRM_ServiceConnectionInspections.getGeoTappingPole());
		ps.setString(23, cRM_ServiceConnectionInspections.getGeoMeteringPole());
		ps.setString(24, cRM_ServiceConnectionInspections.getGeoSEPole());
		ps.setString(25, cRM_ServiceConnectionInspections.getFirstNeighborName());
		ps.setString(26, cRM_ServiceConnectionInspections.getFirstNeighborMeterSerial());
		ps.setString(27, cRM_ServiceConnectionInspections.getSecondNeighborName());
		ps.setString(28, cRM_ServiceConnectionInspections.getSecondNeighborMeterSerial());
		ps.setString(29, cRM_ServiceConnectionInspections.getEngineerInchargeName());
		ps.setString(30, cRM_ServiceConnectionInspections.getEngineerInchargeTitle());
		ps.setString(31, cRM_ServiceConnectionInspections.getEngineerInchargeLicenseNo());
		ps.setString(32, cRM_ServiceConnectionInspections.getEngineerInchargeLicenseValidity());
		ps.setString(33, cRM_ServiceConnectionInspections.getEngineerInchargeContactNo());
		ps.setString(34, cRM_ServiceConnectionInspections.getStatus());
		ps.setString(35, cRM_ServiceConnectionInspections.getInspector());
		ps.setString(36, cRM_ServiceConnectionInspections.getDateOfVerification());
		ps.setString(37, cRM_ServiceConnectionInspections.getEstimatedDateForReinspection());
		ps.setString(38, cRM_ServiceConnectionInspections.getNotes());
		ps.setString(39, cRM_ServiceConnectionInspections.getcreated_at());
		ps.setString(40, cRM_ServiceConnectionInspections.getupdated_at());
		ps.setString(41, cRM_ServiceConnectionInspections.getPoleNumber());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionInspections cRM_ServiceConnectionInspections, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionInspections SET ServiceConnectionId=?, SEMainCircuitBreakerAsPlan=?, SEMainCircuitBreakerAsInstalled=?, SENoOfBranchesAsPlan=?, SENoOfBranchesAsInstalled=?, PoleGIEstimatedDiameter=?, PoleGIHeight=?, PoleGINoOfLiftPoles=?, PoleConcreteEstimatedDiameter=?, PoleConcreteHeight=?, PoleConcreteNoOfLiftPoles=?, PoleHardwoodEstimatedDiameter=?, PoleHardwoodHeight=?, PoleHardwoodNoOfLiftPoles=?, PoleRemarks=?, SDWSizeAsPlan=?, SDWSizeAsInstalled=?, SDWLengthAsPlan=?, SDWLengthAsInstalled=?, GeoBuilding=?, GeoTappingPole=?, GeoMeteringPole=?, GeoSEPole=?, FirstNeighborName=?, FirstNeighborMeterSerial=?, SecondNeighborName=?, SecondNeighborMeterSerial=?, EngineerInchargeName=?, EngineerInchargeTitle=?, EngineerInchargeLicenseNo=?, EngineerInchargeLicenseValidity=?, EngineerInchargeContactNo=?, Status=?, Inspector=?, DateOfVerification=?, EstimatedDateForReinspection=?, Notes=?, created_at=?, updated_at=?, PoleNumber=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionInspections.getServiceConnectionId());
		ps.setString(2, cRM_ServiceConnectionInspections.getSEMainCircuitBreakerAsPlan());
		ps.setString(3, cRM_ServiceConnectionInspections.getSEMainCircuitBreakerAsInstalled());
		ps.setString(4, cRM_ServiceConnectionInspections.getSENoOfBranchesAsPlan());
		ps.setString(5, cRM_ServiceConnectionInspections.getSENoOfBranchesAsInstalled());
		ps.setString(6, cRM_ServiceConnectionInspections.getPoleGIEstimatedDiameter());
		ps.setString(7, cRM_ServiceConnectionInspections.getPoleGIHeight());
		ps.setString(8, cRM_ServiceConnectionInspections.getPoleGINoOfLiftPoles());
		ps.setString(9, cRM_ServiceConnectionInspections.getPoleConcreteEstimatedDiameter());
		ps.setString(10, cRM_ServiceConnectionInspections.getPoleConcreteHeight());
		ps.setString(11, cRM_ServiceConnectionInspections.getPoleConcreteNoOfLiftPoles());
		ps.setString(12, cRM_ServiceConnectionInspections.getPoleHardwoodEstimatedDiameter());
		ps.setString(13, cRM_ServiceConnectionInspections.getPoleHardwoodHeight());
		ps.setString(14, cRM_ServiceConnectionInspections.getPoleHardwoodNoOfLiftPoles());
		ps.setString(15, cRM_ServiceConnectionInspections.getPoleRemarks());
		ps.setString(16, cRM_ServiceConnectionInspections.getSDWSizeAsPlan());
		ps.setString(17, cRM_ServiceConnectionInspections.getSDWSizeAsInstalled());
		ps.setString(18, cRM_ServiceConnectionInspections.getSDWLengthAsPlan());
		ps.setString(19, cRM_ServiceConnectionInspections.getSDWLengthAsInstalled());
		ps.setString(20, cRM_ServiceConnectionInspections.getGeoBuilding());
		ps.setString(21, cRM_ServiceConnectionInspections.getGeoTappingPole());
		ps.setString(22, cRM_ServiceConnectionInspections.getGeoMeteringPole());
		ps.setString(23, cRM_ServiceConnectionInspections.getGeoSEPole());
		ps.setString(24, cRM_ServiceConnectionInspections.getFirstNeighborName());
		ps.setString(25, cRM_ServiceConnectionInspections.getFirstNeighborMeterSerial());
		ps.setString(26, cRM_ServiceConnectionInspections.getSecondNeighborName());
		ps.setString(27, cRM_ServiceConnectionInspections.getSecondNeighborMeterSerial());
		ps.setString(28, cRM_ServiceConnectionInspections.getEngineerInchargeName());
		ps.setString(29, cRM_ServiceConnectionInspections.getEngineerInchargeTitle());
		ps.setString(30, cRM_ServiceConnectionInspections.getEngineerInchargeLicenseNo());
		ps.setString(31, cRM_ServiceConnectionInspections.getEngineerInchargeLicenseValidity());
		ps.setString(32, cRM_ServiceConnectionInspections.getEngineerInchargeContactNo());
		ps.setString(33, cRM_ServiceConnectionInspections.getStatus());
		ps.setString(34, cRM_ServiceConnectionInspections.getInspector());
		ps.setString(35, cRM_ServiceConnectionInspections.getDateOfVerification());
		ps.setString(36, cRM_ServiceConnectionInspections.getEstimatedDateForReinspection());
		ps.setString(37, cRM_ServiceConnectionInspections.getNotes());
		ps.setString(38, cRM_ServiceConnectionInspections.getcreated_at());
		ps.setString(39, cRM_ServiceConnectionInspections.getupdated_at());
		ps.setString(40, cRM_ServiceConnectionInspections.getPoleNumber());
		ps.setString(41, cRM_ServiceConnectionInspections.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionInspections getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionInspections WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionInspections cRM_ServiceConnectionInspections = new CRM_ServiceConnectionInspections(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("SEMainCircuitBreakerAsPlan"),
			rs.getString("SEMainCircuitBreakerAsInstalled"),
			rs.getString("SENoOfBranchesAsPlan"),
			rs.getString("SENoOfBranchesAsInstalled"),
			rs.getString("PoleGIEstimatedDiameter"),
			rs.getString("PoleGIHeight"),
			rs.getString("PoleGINoOfLiftPoles"),
			rs.getString("PoleConcreteEstimatedDiameter"),
			rs.getString("PoleConcreteHeight"),
			rs.getString("PoleConcreteNoOfLiftPoles"),
			rs.getString("PoleHardwoodEstimatedDiameter"),
			rs.getString("PoleHardwoodHeight"),
			rs.getString("PoleHardwoodNoOfLiftPoles"),
			rs.getString("PoleRemarks"),
			rs.getString("SDWSizeAsPlan"),
			rs.getString("SDWSizeAsInstalled"),
			rs.getString("SDWLengthAsPlan"),
			rs.getString("SDWLengthAsInstalled"),
			rs.getString("GeoBuilding"),
			rs.getString("GeoTappingPole"),
			rs.getString("GeoMeteringPole"),
			rs.getString("GeoSEPole"),
			rs.getString("FirstNeighborName"),
			rs.getString("FirstNeighborMeterSerial"),
			rs.getString("SecondNeighborName"),
			rs.getString("SecondNeighborMeterSerial"),
			rs.getString("EngineerInchargeName"),
			rs.getString("EngineerInchargeTitle"),
			rs.getString("EngineerInchargeLicenseNo"),
			rs.getString("EngineerInchargeLicenseValidity"),
			rs.getString("EngineerInchargeContactNo"),
			rs.getString("Status"),
			rs.getString("Inspector"),
			rs.getString("DateOfVerification"),
			rs.getString("EstimatedDateForReinspection"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("PoleNumber")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionInspections;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionInspections> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionInspections WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionInspections> cRM_ServiceConnectionInspectionsList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionInspections cRM_ServiceConnectionInspections = new CRM_ServiceConnectionInspections();
			cRM_ServiceConnectionInspections.setid(rs.getString("id"));
			cRM_ServiceConnectionInspections.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_ServiceConnectionInspections.setSEMainCircuitBreakerAsPlan(rs.getString("SEMainCircuitBreakerAsPlan"));
			cRM_ServiceConnectionInspections.setSEMainCircuitBreakerAsInstalled(rs.getString("SEMainCircuitBreakerAsInstalled"));
			cRM_ServiceConnectionInspections.setSENoOfBranchesAsPlan(rs.getString("SENoOfBranchesAsPlan"));
			cRM_ServiceConnectionInspections.setSENoOfBranchesAsInstalled(rs.getString("SENoOfBranchesAsInstalled"));
			cRM_ServiceConnectionInspections.setPoleGIEstimatedDiameter(rs.getString("PoleGIEstimatedDiameter"));
			cRM_ServiceConnectionInspections.setPoleGIHeight(rs.getString("PoleGIHeight"));
			cRM_ServiceConnectionInspections.setPoleGINoOfLiftPoles(rs.getString("PoleGINoOfLiftPoles"));
			cRM_ServiceConnectionInspections.setPoleConcreteEstimatedDiameter(rs.getString("PoleConcreteEstimatedDiameter"));
			cRM_ServiceConnectionInspections.setPoleConcreteHeight(rs.getString("PoleConcreteHeight"));
			cRM_ServiceConnectionInspections.setPoleConcreteNoOfLiftPoles(rs.getString("PoleConcreteNoOfLiftPoles"));
			cRM_ServiceConnectionInspections.setPoleHardwoodEstimatedDiameter(rs.getString("PoleHardwoodEstimatedDiameter"));
			cRM_ServiceConnectionInspections.setPoleHardwoodHeight(rs.getString("PoleHardwoodHeight"));
			cRM_ServiceConnectionInspections.setPoleHardwoodNoOfLiftPoles(rs.getString("PoleHardwoodNoOfLiftPoles"));
			cRM_ServiceConnectionInspections.setPoleRemarks(rs.getString("PoleRemarks"));
			cRM_ServiceConnectionInspections.setSDWSizeAsPlan(rs.getString("SDWSizeAsPlan"));
			cRM_ServiceConnectionInspections.setSDWSizeAsInstalled(rs.getString("SDWSizeAsInstalled"));
			cRM_ServiceConnectionInspections.setSDWLengthAsPlan(rs.getString("SDWLengthAsPlan"));
			cRM_ServiceConnectionInspections.setSDWLengthAsInstalled(rs.getString("SDWLengthAsInstalled"));
			cRM_ServiceConnectionInspections.setGeoBuilding(rs.getString("GeoBuilding"));
			cRM_ServiceConnectionInspections.setGeoTappingPole(rs.getString("GeoTappingPole"));
			cRM_ServiceConnectionInspections.setGeoMeteringPole(rs.getString("GeoMeteringPole"));
			cRM_ServiceConnectionInspections.setGeoSEPole(rs.getString("GeoSEPole"));
			cRM_ServiceConnectionInspections.setFirstNeighborName(rs.getString("FirstNeighborName"));
			cRM_ServiceConnectionInspections.setFirstNeighborMeterSerial(rs.getString("FirstNeighborMeterSerial"));
			cRM_ServiceConnectionInspections.setSecondNeighborName(rs.getString("SecondNeighborName"));
			cRM_ServiceConnectionInspections.setSecondNeighborMeterSerial(rs.getString("SecondNeighborMeterSerial"));
			cRM_ServiceConnectionInspections.setEngineerInchargeName(rs.getString("EngineerInchargeName"));
			cRM_ServiceConnectionInspections.setEngineerInchargeTitle(rs.getString("EngineerInchargeTitle"));
			cRM_ServiceConnectionInspections.setEngineerInchargeLicenseNo(rs.getString("EngineerInchargeLicenseNo"));
			cRM_ServiceConnectionInspections.setEngineerInchargeLicenseValidity(rs.getString("EngineerInchargeLicenseValidity"));
			cRM_ServiceConnectionInspections.setEngineerInchargeContactNo(rs.getString("EngineerInchargeContactNo"));
			cRM_ServiceConnectionInspections.setStatus(rs.getString("Status"));
			cRM_ServiceConnectionInspections.setInspector(rs.getString("Inspector"));
			cRM_ServiceConnectionInspections.setDateOfVerification(rs.getString("DateOfVerification"));
			cRM_ServiceConnectionInspections.setEstimatedDateForReinspection(rs.getString("EstimatedDateForReinspection"));
			cRM_ServiceConnectionInspections.setNotes(rs.getString("Notes"));
			cRM_ServiceConnectionInspections.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionInspections.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionInspections.setPoleNumber(rs.getString("PoleNumber"));
			cRM_ServiceConnectionInspectionsList.add(cRM_ServiceConnectionInspections);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionInspectionsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionInspections> billing_Billses = CRM_ServiceConnectionInspectionsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionInspections to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionInspections bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionInspections bill = CRM_ServiceConnectionInspectionsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionInspections has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionInspectionsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionInspections updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionInspectionsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionInspections inserted";
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
