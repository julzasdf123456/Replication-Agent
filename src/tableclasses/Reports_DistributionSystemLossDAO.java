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
public class Reports_DistributionSystemLossDAO { 
	public static void insert(Reports_DistributionSystemLoss reports_DistributionSystemLoss, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Reports_DistributionSystemLoss(id, ServicePeriod, VictoriasSubstation, SagaySubstation, SanCarlosSubstation, EscalanteSubstation, LopezSubstation, CadizSubstation, IpiSubstation, TobosoCalatravaSubstation, VictoriasMillingCompany, SanCarlosBionergy, TotalEnergyInput, EnergySales, EnergyAdjustmentRecoveries, TotalEnergyOutput, TotalSystemLoss, TotalSystemLossPercentage, UserId, From, To, Status, Notes, created_at, updated_at, CalatravaSubstation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, reports_DistributionSystemLoss.getid());
		ps.setString(2, reports_DistributionSystemLoss.getServicePeriod());
		ps.setString(3, reports_DistributionSystemLoss.getVictoriasSubstation());
		ps.setString(4, reports_DistributionSystemLoss.getSagaySubstation());
		ps.setString(5, reports_DistributionSystemLoss.getSanCarlosSubstation());
		ps.setString(6, reports_DistributionSystemLoss.getEscalanteSubstation());
		ps.setString(7, reports_DistributionSystemLoss.getLopezSubstation());
		ps.setString(8, reports_DistributionSystemLoss.getCadizSubstation());
		ps.setString(9, reports_DistributionSystemLoss.getIpiSubstation());
		ps.setString(10, reports_DistributionSystemLoss.getTobosoCalatravaSubstation());
		ps.setString(11, reports_DistributionSystemLoss.getVictoriasMillingCompany());
		ps.setString(12, reports_DistributionSystemLoss.getSanCarlosBionergy());
		ps.setString(13, reports_DistributionSystemLoss.getTotalEnergyInput());
		ps.setString(14, reports_DistributionSystemLoss.getEnergySales());
		ps.setString(15, reports_DistributionSystemLoss.getEnergyAdjustmentRecoveries());
		ps.setString(16, reports_DistributionSystemLoss.getTotalEnergyOutput());
		ps.setString(17, reports_DistributionSystemLoss.getTotalSystemLoss());
		ps.setString(18, reports_DistributionSystemLoss.getTotalSystemLossPercentage());
		ps.setString(19, reports_DistributionSystemLoss.getUserId());
		ps.setString(20, reports_DistributionSystemLoss.getFrom());
		ps.setString(21, reports_DistributionSystemLoss.getTo());
		ps.setString(22, reports_DistributionSystemLoss.getStatus());
		ps.setString(23, reports_DistributionSystemLoss.getNotes());
		ps.setString(24, reports_DistributionSystemLoss.getcreated_at());
		ps.setString(25, reports_DistributionSystemLoss.getupdated_at());
		ps.setString(26, reports_DistributionSystemLoss.getCalatravaSubstation());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Reports_DistributionSystemLoss reports_DistributionSystemLoss, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Reports_DistributionSystemLoss SET ServicePeriod=?, VictoriasSubstation=?, SagaySubstation=?, SanCarlosSubstation=?, EscalanteSubstation=?, LopezSubstation=?, CadizSubstation=?, IpiSubstation=?, TobosoCalatravaSubstation=?, VictoriasMillingCompany=?, SanCarlosBionergy=?, TotalEnergyInput=?, EnergySales=?, EnergyAdjustmentRecoveries=?, TotalEnergyOutput=?, TotalSystemLoss=?, TotalSystemLossPercentage=?, UserId=?, From=?, To=?, Status=?, Notes=?, created_at=?, updated_at=?, CalatravaSubstation=?  WHERE id=? ");
		ps.setString(1, reports_DistributionSystemLoss.getServicePeriod());
		ps.setString(2, reports_DistributionSystemLoss.getVictoriasSubstation());
		ps.setString(3, reports_DistributionSystemLoss.getSagaySubstation());
		ps.setString(4, reports_DistributionSystemLoss.getSanCarlosSubstation());
		ps.setString(5, reports_DistributionSystemLoss.getEscalanteSubstation());
		ps.setString(6, reports_DistributionSystemLoss.getLopezSubstation());
		ps.setString(7, reports_DistributionSystemLoss.getCadizSubstation());
		ps.setString(8, reports_DistributionSystemLoss.getIpiSubstation());
		ps.setString(9, reports_DistributionSystemLoss.getTobosoCalatravaSubstation());
		ps.setString(10, reports_DistributionSystemLoss.getVictoriasMillingCompany());
		ps.setString(11, reports_DistributionSystemLoss.getSanCarlosBionergy());
		ps.setString(12, reports_DistributionSystemLoss.getTotalEnergyInput());
		ps.setString(13, reports_DistributionSystemLoss.getEnergySales());
		ps.setString(14, reports_DistributionSystemLoss.getEnergyAdjustmentRecoveries());
		ps.setString(15, reports_DistributionSystemLoss.getTotalEnergyOutput());
		ps.setString(16, reports_DistributionSystemLoss.getTotalSystemLoss());
		ps.setString(17, reports_DistributionSystemLoss.getTotalSystemLossPercentage());
		ps.setString(18, reports_DistributionSystemLoss.getUserId());
		ps.setString(19, reports_DistributionSystemLoss.getFrom());
		ps.setString(20, reports_DistributionSystemLoss.getTo());
		ps.setString(21, reports_DistributionSystemLoss.getStatus());
		ps.setString(22, reports_DistributionSystemLoss.getNotes());
		ps.setString(23, reports_DistributionSystemLoss.getcreated_at());
		ps.setString(24, reports_DistributionSystemLoss.getupdated_at());
		ps.setString(25, reports_DistributionSystemLoss.getCalatravaSubstation());
		ps.setString(26, reports_DistributionSystemLoss.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Reports_DistributionSystemLoss getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Reports_DistributionSystemLoss WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Reports_DistributionSystemLoss reports_DistributionSystemLoss = new Reports_DistributionSystemLoss(
			rs.getString("id"),
			rs.getString("ServicePeriod"),
			rs.getString("VictoriasSubstation"),
			rs.getString("SagaySubstation"),
			rs.getString("SanCarlosSubstation"),
			rs.getString("EscalanteSubstation"),
			rs.getString("LopezSubstation"),
			rs.getString("CadizSubstation"),
			rs.getString("IpiSubstation"),
			rs.getString("TobosoCalatravaSubstation"),
			rs.getString("VictoriasMillingCompany"),
			rs.getString("SanCarlosBionergy"),
			rs.getString("TotalEnergyInput"),
			rs.getString("EnergySales"),
			rs.getString("EnergyAdjustmentRecoveries"),
			rs.getString("TotalEnergyOutput"),
			rs.getString("TotalSystemLoss"),
			rs.getString("TotalSystemLossPercentage"),
			rs.getString("UserId"),
			rs.getString("From"),
			rs.getString("To"),
			rs.getString("Status"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("CalatravaSubstation")
			);
			ps.close();
			rs.close();
			return reports_DistributionSystemLoss;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Reports_DistributionSystemLoss> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Reports_DistributionSystemLoss WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Reports_DistributionSystemLoss> reports_DistributionSystemLossList = new ArrayList<>();
		while(rs.next()) {
			Reports_DistributionSystemLoss reports_DistributionSystemLoss = new Reports_DistributionSystemLoss();
			reports_DistributionSystemLoss.setid(rs.getString("id"));
			reports_DistributionSystemLoss.setServicePeriod(rs.getString("ServicePeriod"));
			reports_DistributionSystemLoss.setVictoriasSubstation(rs.getString("VictoriasSubstation"));
			reports_DistributionSystemLoss.setSagaySubstation(rs.getString("SagaySubstation"));
			reports_DistributionSystemLoss.setSanCarlosSubstation(rs.getString("SanCarlosSubstation"));
			reports_DistributionSystemLoss.setEscalanteSubstation(rs.getString("EscalanteSubstation"));
			reports_DistributionSystemLoss.setLopezSubstation(rs.getString("LopezSubstation"));
			reports_DistributionSystemLoss.setCadizSubstation(rs.getString("CadizSubstation"));
			reports_DistributionSystemLoss.setIpiSubstation(rs.getString("IpiSubstation"));
			reports_DistributionSystemLoss.setTobosoCalatravaSubstation(rs.getString("TobosoCalatravaSubstation"));
			reports_DistributionSystemLoss.setVictoriasMillingCompany(rs.getString("VictoriasMillingCompany"));
			reports_DistributionSystemLoss.setSanCarlosBionergy(rs.getString("SanCarlosBionergy"));
			reports_DistributionSystemLoss.setTotalEnergyInput(rs.getString("TotalEnergyInput"));
			reports_DistributionSystemLoss.setEnergySales(rs.getString("EnergySales"));
			reports_DistributionSystemLoss.setEnergyAdjustmentRecoveries(rs.getString("EnergyAdjustmentRecoveries"));
			reports_DistributionSystemLoss.setTotalEnergyOutput(rs.getString("TotalEnergyOutput"));
			reports_DistributionSystemLoss.setTotalSystemLoss(rs.getString("TotalSystemLoss"));
			reports_DistributionSystemLoss.setTotalSystemLossPercentage(rs.getString("TotalSystemLossPercentage"));
			reports_DistributionSystemLoss.setUserId(rs.getString("UserId"));
			reports_DistributionSystemLoss.setFrom(rs.getString("From"));
			reports_DistributionSystemLoss.setTo(rs.getString("To"));
			reports_DistributionSystemLoss.setStatus(rs.getString("Status"));
			reports_DistributionSystemLoss.setNotes(rs.getString("Notes"));
			reports_DistributionSystemLoss.setcreated_at(rs.getString("created_at"));
			reports_DistributionSystemLoss.setupdated_at(rs.getString("updated_at"));
			reports_DistributionSystemLoss.setCalatravaSubstation(rs.getString("CalatravaSubstation"));
			reports_DistributionSystemLossList.add(reports_DistributionSystemLoss);
		}
		rs.close();
		ps.close();
		return reports_DistributionSystemLossList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Reports_DistributionSystemLoss> billing_Billses = Reports_DistributionSystemLossDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Reports_DistributionSystemLoss to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Reports_DistributionSystemLoss bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Reports_DistributionSystemLoss bill = Reports_DistributionSystemLossDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Reports_DistributionSystemLoss has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Reports_DistributionSystemLossDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Reports_DistributionSystemLoss updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Reports_DistributionSystemLossDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Reports_DistributionSystemLoss inserted";
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
