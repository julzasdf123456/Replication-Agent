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
public class CRM_ServiceConnectionMeterAndTransformerDAO { 
	public static void insert(CRM_ServiceConnectionMeterAndTransformer cRM_ServiceConnectionMeterAndTransformer, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionMeterAndTransformer(id, ServiceConnectionId, MeterSerialNumber, MeterBrand, MeterSealNumber, MeterKwhStart, MeterEnclosureType, MeterHeight, MeterNotes, DirectRatedCapacity, InstrumentRatedCapacity, InstrumentRatedLineType, CTPhaseA, CTPhaseB, CTPhaseC, PTPhaseA, PTPhaseB, PTPhaseC, BrandPhaseA, BrandPhaseB, BrandPhaseC, SNPhaseA, SNPhaseB, SNPhaseC, SecuritySealPhaseA, SecuritySealPhaseB, SecuritySealPhaseC, Phase, TransformerQuantity, TransformerRating, TransformerOwnershipType, TransformerOwnership, TransformerBrand, created_at, updated_at, TypeOfMetering, TransformerNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionMeterAndTransformer.getid());
		ps.setString(2, cRM_ServiceConnectionMeterAndTransformer.getServiceConnectionId());
		ps.setString(3, cRM_ServiceConnectionMeterAndTransformer.getMeterSerialNumber());
		ps.setString(4, cRM_ServiceConnectionMeterAndTransformer.getMeterBrand());
		ps.setString(5, cRM_ServiceConnectionMeterAndTransformer.getMeterSealNumber());
		ps.setString(6, cRM_ServiceConnectionMeterAndTransformer.getMeterKwhStart());
		ps.setString(7, cRM_ServiceConnectionMeterAndTransformer.getMeterEnclosureType());
		ps.setString(8, cRM_ServiceConnectionMeterAndTransformer.getMeterHeight());
		ps.setString(9, cRM_ServiceConnectionMeterAndTransformer.getMeterNotes());
		ps.setString(10, cRM_ServiceConnectionMeterAndTransformer.getDirectRatedCapacity());
		ps.setString(11, cRM_ServiceConnectionMeterAndTransformer.getInstrumentRatedCapacity());
		ps.setString(12, cRM_ServiceConnectionMeterAndTransformer.getInstrumentRatedLineType());
		ps.setString(13, cRM_ServiceConnectionMeterAndTransformer.getCTPhaseA());
		ps.setString(14, cRM_ServiceConnectionMeterAndTransformer.getCTPhaseB());
		ps.setString(15, cRM_ServiceConnectionMeterAndTransformer.getCTPhaseC());
		ps.setString(16, cRM_ServiceConnectionMeterAndTransformer.getPTPhaseA());
		ps.setString(17, cRM_ServiceConnectionMeterAndTransformer.getPTPhaseB());
		ps.setString(18, cRM_ServiceConnectionMeterAndTransformer.getPTPhaseC());
		ps.setString(19, cRM_ServiceConnectionMeterAndTransformer.getBrandPhaseA());
		ps.setString(20, cRM_ServiceConnectionMeterAndTransformer.getBrandPhaseB());
		ps.setString(21, cRM_ServiceConnectionMeterAndTransformer.getBrandPhaseC());
		ps.setString(22, cRM_ServiceConnectionMeterAndTransformer.getSNPhaseA());
		ps.setString(23, cRM_ServiceConnectionMeterAndTransformer.getSNPhaseB());
		ps.setString(24, cRM_ServiceConnectionMeterAndTransformer.getSNPhaseC());
		ps.setString(25, cRM_ServiceConnectionMeterAndTransformer.getSecuritySealPhaseA());
		ps.setString(26, cRM_ServiceConnectionMeterAndTransformer.getSecuritySealPhaseB());
		ps.setString(27, cRM_ServiceConnectionMeterAndTransformer.getSecuritySealPhaseC());
		ps.setString(28, cRM_ServiceConnectionMeterAndTransformer.getPhase());
		ps.setString(29, cRM_ServiceConnectionMeterAndTransformer.getTransformerQuantity());
		ps.setString(30, cRM_ServiceConnectionMeterAndTransformer.getTransformerRating());
		ps.setString(31, cRM_ServiceConnectionMeterAndTransformer.getTransformerOwnershipType());
		ps.setString(32, cRM_ServiceConnectionMeterAndTransformer.getTransformerOwnership());
		ps.setString(33, cRM_ServiceConnectionMeterAndTransformer.getTransformerBrand());
		ps.setString(34, cRM_ServiceConnectionMeterAndTransformer.getcreated_at());
		ps.setString(35, cRM_ServiceConnectionMeterAndTransformer.getupdated_at());
		ps.setString(36, cRM_ServiceConnectionMeterAndTransformer.getTypeOfMetering());
		ps.setString(37, cRM_ServiceConnectionMeterAndTransformer.getTransformerNumber());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionMeterAndTransformer cRM_ServiceConnectionMeterAndTransformer, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionMeterAndTransformer SET ServiceConnectionId=?, MeterSerialNumber=?, MeterBrand=?, MeterSealNumber=?, MeterKwhStart=?, MeterEnclosureType=?, MeterHeight=?, MeterNotes=?, DirectRatedCapacity=?, InstrumentRatedCapacity=?, InstrumentRatedLineType=?, CTPhaseA=?, CTPhaseB=?, CTPhaseC=?, PTPhaseA=?, PTPhaseB=?, PTPhaseC=?, BrandPhaseA=?, BrandPhaseB=?, BrandPhaseC=?, SNPhaseA=?, SNPhaseB=?, SNPhaseC=?, SecuritySealPhaseA=?, SecuritySealPhaseB=?, SecuritySealPhaseC=?, Phase=?, TransformerQuantity=?, TransformerRating=?, TransformerOwnershipType=?, TransformerOwnership=?, TransformerBrand=?, created_at=?, updated_at=?, TypeOfMetering=?, TransformerNumber=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionMeterAndTransformer.getServiceConnectionId());
		ps.setString(2, cRM_ServiceConnectionMeterAndTransformer.getMeterSerialNumber());
		ps.setString(3, cRM_ServiceConnectionMeterAndTransformer.getMeterBrand());
		ps.setString(4, cRM_ServiceConnectionMeterAndTransformer.getMeterSealNumber());
		ps.setString(5, cRM_ServiceConnectionMeterAndTransformer.getMeterKwhStart());
		ps.setString(6, cRM_ServiceConnectionMeterAndTransformer.getMeterEnclosureType());
		ps.setString(7, cRM_ServiceConnectionMeterAndTransformer.getMeterHeight());
		ps.setString(8, cRM_ServiceConnectionMeterAndTransformer.getMeterNotes());
		ps.setString(9, cRM_ServiceConnectionMeterAndTransformer.getDirectRatedCapacity());
		ps.setString(10, cRM_ServiceConnectionMeterAndTransformer.getInstrumentRatedCapacity());
		ps.setString(11, cRM_ServiceConnectionMeterAndTransformer.getInstrumentRatedLineType());
		ps.setString(12, cRM_ServiceConnectionMeterAndTransformer.getCTPhaseA());
		ps.setString(13, cRM_ServiceConnectionMeterAndTransformer.getCTPhaseB());
		ps.setString(14, cRM_ServiceConnectionMeterAndTransformer.getCTPhaseC());
		ps.setString(15, cRM_ServiceConnectionMeterAndTransformer.getPTPhaseA());
		ps.setString(16, cRM_ServiceConnectionMeterAndTransformer.getPTPhaseB());
		ps.setString(17, cRM_ServiceConnectionMeterAndTransformer.getPTPhaseC());
		ps.setString(18, cRM_ServiceConnectionMeterAndTransformer.getBrandPhaseA());
		ps.setString(19, cRM_ServiceConnectionMeterAndTransformer.getBrandPhaseB());
		ps.setString(20, cRM_ServiceConnectionMeterAndTransformer.getBrandPhaseC());
		ps.setString(21, cRM_ServiceConnectionMeterAndTransformer.getSNPhaseA());
		ps.setString(22, cRM_ServiceConnectionMeterAndTransformer.getSNPhaseB());
		ps.setString(23, cRM_ServiceConnectionMeterAndTransformer.getSNPhaseC());
		ps.setString(24, cRM_ServiceConnectionMeterAndTransformer.getSecuritySealPhaseA());
		ps.setString(25, cRM_ServiceConnectionMeterAndTransformer.getSecuritySealPhaseB());
		ps.setString(26, cRM_ServiceConnectionMeterAndTransformer.getSecuritySealPhaseC());
		ps.setString(27, cRM_ServiceConnectionMeterAndTransformer.getPhase());
		ps.setString(28, cRM_ServiceConnectionMeterAndTransformer.getTransformerQuantity());
		ps.setString(29, cRM_ServiceConnectionMeterAndTransformer.getTransformerRating());
		ps.setString(30, cRM_ServiceConnectionMeterAndTransformer.getTransformerOwnershipType());
		ps.setString(31, cRM_ServiceConnectionMeterAndTransformer.getTransformerOwnership());
		ps.setString(32, cRM_ServiceConnectionMeterAndTransformer.getTransformerBrand());
		ps.setString(33, cRM_ServiceConnectionMeterAndTransformer.getcreated_at());
		ps.setString(34, cRM_ServiceConnectionMeterAndTransformer.getupdated_at());
		ps.setString(35, cRM_ServiceConnectionMeterAndTransformer.getTypeOfMetering());
		ps.setString(36, cRM_ServiceConnectionMeterAndTransformer.getTransformerNumber());
		ps.setString(37, cRM_ServiceConnectionMeterAndTransformer.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionMeterAndTransformer getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionMeterAndTransformer WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionMeterAndTransformer cRM_ServiceConnectionMeterAndTransformer = new CRM_ServiceConnectionMeterAndTransformer(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("MeterSerialNumber"),
			rs.getString("MeterBrand"),
			rs.getString("MeterSealNumber"),
			rs.getString("MeterKwhStart"),
			rs.getString("MeterEnclosureType"),
			rs.getString("MeterHeight"),
			rs.getString("MeterNotes"),
			rs.getString("DirectRatedCapacity"),
			rs.getString("InstrumentRatedCapacity"),
			rs.getString("InstrumentRatedLineType"),
			rs.getString("CTPhaseA"),
			rs.getString("CTPhaseB"),
			rs.getString("CTPhaseC"),
			rs.getString("PTPhaseA"),
			rs.getString("PTPhaseB"),
			rs.getString("PTPhaseC"),
			rs.getString("BrandPhaseA"),
			rs.getString("BrandPhaseB"),
			rs.getString("BrandPhaseC"),
			rs.getString("SNPhaseA"),
			rs.getString("SNPhaseB"),
			rs.getString("SNPhaseC"),
			rs.getString("SecuritySealPhaseA"),
			rs.getString("SecuritySealPhaseB"),
			rs.getString("SecuritySealPhaseC"),
			rs.getString("Phase"),
			rs.getString("TransformerQuantity"),
			rs.getString("TransformerRating"),
			rs.getString("TransformerOwnershipType"),
			rs.getString("TransformerOwnership"),
			rs.getString("TransformerBrand"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("TypeOfMetering"),
			rs.getString("TransformerNumber")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionMeterAndTransformer;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionMeterAndTransformer> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionMeterAndTransformer WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionMeterAndTransformer> cRM_ServiceConnectionMeterAndTransformerList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionMeterAndTransformer cRM_ServiceConnectionMeterAndTransformer = new CRM_ServiceConnectionMeterAndTransformer();
			cRM_ServiceConnectionMeterAndTransformer.setid(rs.getString("id"));
			cRM_ServiceConnectionMeterAndTransformer.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_ServiceConnectionMeterAndTransformer.setMeterSerialNumber(rs.getString("MeterSerialNumber"));
			cRM_ServiceConnectionMeterAndTransformer.setMeterBrand(rs.getString("MeterBrand"));
			cRM_ServiceConnectionMeterAndTransformer.setMeterSealNumber(rs.getString("MeterSealNumber"));
			cRM_ServiceConnectionMeterAndTransformer.setMeterKwhStart(rs.getString("MeterKwhStart"));
			cRM_ServiceConnectionMeterAndTransformer.setMeterEnclosureType(rs.getString("MeterEnclosureType"));
			cRM_ServiceConnectionMeterAndTransformer.setMeterHeight(rs.getString("MeterHeight"));
			cRM_ServiceConnectionMeterAndTransformer.setMeterNotes(rs.getString("MeterNotes"));
			cRM_ServiceConnectionMeterAndTransformer.setDirectRatedCapacity(rs.getString("DirectRatedCapacity"));
			cRM_ServiceConnectionMeterAndTransformer.setInstrumentRatedCapacity(rs.getString("InstrumentRatedCapacity"));
			cRM_ServiceConnectionMeterAndTransformer.setInstrumentRatedLineType(rs.getString("InstrumentRatedLineType"));
			cRM_ServiceConnectionMeterAndTransformer.setCTPhaseA(rs.getString("CTPhaseA"));
			cRM_ServiceConnectionMeterAndTransformer.setCTPhaseB(rs.getString("CTPhaseB"));
			cRM_ServiceConnectionMeterAndTransformer.setCTPhaseC(rs.getString("CTPhaseC"));
			cRM_ServiceConnectionMeterAndTransformer.setPTPhaseA(rs.getString("PTPhaseA"));
			cRM_ServiceConnectionMeterAndTransformer.setPTPhaseB(rs.getString("PTPhaseB"));
			cRM_ServiceConnectionMeterAndTransformer.setPTPhaseC(rs.getString("PTPhaseC"));
			cRM_ServiceConnectionMeterAndTransformer.setBrandPhaseA(rs.getString("BrandPhaseA"));
			cRM_ServiceConnectionMeterAndTransformer.setBrandPhaseB(rs.getString("BrandPhaseB"));
			cRM_ServiceConnectionMeterAndTransformer.setBrandPhaseC(rs.getString("BrandPhaseC"));
			cRM_ServiceConnectionMeterAndTransformer.setSNPhaseA(rs.getString("SNPhaseA"));
			cRM_ServiceConnectionMeterAndTransformer.setSNPhaseB(rs.getString("SNPhaseB"));
			cRM_ServiceConnectionMeterAndTransformer.setSNPhaseC(rs.getString("SNPhaseC"));
			cRM_ServiceConnectionMeterAndTransformer.setSecuritySealPhaseA(rs.getString("SecuritySealPhaseA"));
			cRM_ServiceConnectionMeterAndTransformer.setSecuritySealPhaseB(rs.getString("SecuritySealPhaseB"));
			cRM_ServiceConnectionMeterAndTransformer.setSecuritySealPhaseC(rs.getString("SecuritySealPhaseC"));
			cRM_ServiceConnectionMeterAndTransformer.setPhase(rs.getString("Phase"));
			cRM_ServiceConnectionMeterAndTransformer.setTransformerQuantity(rs.getString("TransformerQuantity"));
			cRM_ServiceConnectionMeterAndTransformer.setTransformerRating(rs.getString("TransformerRating"));
			cRM_ServiceConnectionMeterAndTransformer.setTransformerOwnershipType(rs.getString("TransformerOwnershipType"));
			cRM_ServiceConnectionMeterAndTransformer.setTransformerOwnership(rs.getString("TransformerOwnership"));
			cRM_ServiceConnectionMeterAndTransformer.setTransformerBrand(rs.getString("TransformerBrand"));
			cRM_ServiceConnectionMeterAndTransformer.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionMeterAndTransformer.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionMeterAndTransformer.setTypeOfMetering(rs.getString("TypeOfMetering"));
			cRM_ServiceConnectionMeterAndTransformer.setTransformerNumber(rs.getString("TransformerNumber"));
			cRM_ServiceConnectionMeterAndTransformerList.add(cRM_ServiceConnectionMeterAndTransformer);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionMeterAndTransformerList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionMeterAndTransformer> billing_Billses = CRM_ServiceConnectionMeterAndTransformerDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionMeterAndTransformer to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionMeterAndTransformer bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionMeterAndTransformer bill = CRM_ServiceConnectionMeterAndTransformerDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionMeterAndTransformer has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionMeterAndTransformerDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionMeterAndTransformer updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionMeterAndTransformerDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionMeterAndTransformer inserted";
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
