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
public class Billing_RatesDAO { 
	public static void insert(Billing_Rates billing_Rates, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_Rates(id, RateFor, ConsumerType, ServicePeriod, Notes, GenerationSystemCharge, TransmissionDeliveryChargeKW, TransmissionDeliveryChargeKWH, SystemLossCharge, DistributionDemandCharge, DistributionSystemCharge, SupplyRetailCustomerCharge, SupplySystemCharge, MeteringRetailCustomerCharge, MeteringSystemCharge, RFSC, LifelineRate, InterClassCrossSubsidyCharge, PPARefund, SeniorCitizenSubsidy, MissionaryElectrificationCharge, EnvironmentalCharge, StrandedContractCosts, NPCStrandedDebt, FeedInTariffAllowance, MissionaryElectrificationREDCI, GenerationVAT, TransmissionVAT, SystemLossVAT, DistributionVAT, TotalRateVATExcluded, TotalRateVATIncluded, UserId, created_at, updated_at, RealPropertyTax, AreaCode, OtherGenerationRateAdjustment, OtherTransmissionCostAdjustmentKW, OtherTransmissionCostAdjustmentKWH, OtherSystemLossCostAdjustment, OtherLifelineRateCostAdjustment, SeniorCitizenDiscountAndSubsidyAdjustment, FranchiseTax, BusinessTax, TotalRateVATExcludedWithAdjustments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_Rates.getid());
		ps.setString(2, billing_Rates.getRateFor());
		ps.setString(3, billing_Rates.getConsumerType());
		ps.setString(4, billing_Rates.getServicePeriod());
		ps.setString(5, billing_Rates.getNotes());
		ps.setString(6, billing_Rates.getGenerationSystemCharge());
		ps.setString(7, billing_Rates.getTransmissionDeliveryChargeKW());
		ps.setString(8, billing_Rates.getTransmissionDeliveryChargeKWH());
		ps.setString(9, billing_Rates.getSystemLossCharge());
		ps.setString(10, billing_Rates.getDistributionDemandCharge());
		ps.setString(11, billing_Rates.getDistributionSystemCharge());
		ps.setString(12, billing_Rates.getSupplyRetailCustomerCharge());
		ps.setString(13, billing_Rates.getSupplySystemCharge());
		ps.setString(14, billing_Rates.getMeteringRetailCustomerCharge());
		ps.setString(15, billing_Rates.getMeteringSystemCharge());
		ps.setString(16, billing_Rates.getRFSC());
		ps.setString(17, billing_Rates.getLifelineRate());
		ps.setString(18, billing_Rates.getInterClassCrossSubsidyCharge());
		ps.setString(19, billing_Rates.getPPARefund());
		ps.setString(20, billing_Rates.getSeniorCitizenSubsidy());
		ps.setString(21, billing_Rates.getMissionaryElectrificationCharge());
		ps.setString(22, billing_Rates.getEnvironmentalCharge());
		ps.setString(23, billing_Rates.getStrandedContractCosts());
		ps.setString(24, billing_Rates.getNPCStrandedDebt());
		ps.setString(25, billing_Rates.getFeedInTariffAllowance());
		ps.setString(26, billing_Rates.getMissionaryElectrificationREDCI());
		ps.setString(27, billing_Rates.getGenerationVAT());
		ps.setString(28, billing_Rates.getTransmissionVAT());
		ps.setString(29, billing_Rates.getSystemLossVAT());
		ps.setString(30, billing_Rates.getDistributionVAT());
		ps.setString(31, billing_Rates.getTotalRateVATExcluded());
		ps.setString(32, billing_Rates.getTotalRateVATIncluded());
		ps.setString(33, billing_Rates.getUserId());
		ps.setString(34, billing_Rates.getcreated_at());
		ps.setString(35, billing_Rates.getupdated_at());
		ps.setString(36, billing_Rates.getRealPropertyTax());
		ps.setString(37, billing_Rates.getAreaCode());
		ps.setString(38, billing_Rates.getOtherGenerationRateAdjustment());
		ps.setString(39, billing_Rates.getOtherTransmissionCostAdjustmentKW());
		ps.setString(40, billing_Rates.getOtherTransmissionCostAdjustmentKWH());
		ps.setString(41, billing_Rates.getOtherSystemLossCostAdjustment());
		ps.setString(42, billing_Rates.getOtherLifelineRateCostAdjustment());
		ps.setString(43, billing_Rates.getSeniorCitizenDiscountAndSubsidyAdjustment());
		ps.setString(44, billing_Rates.getFranchiseTax());
		ps.setString(45, billing_Rates.getBusinessTax());
		ps.setString(46, billing_Rates.getTotalRateVATExcludedWithAdjustments());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_Rates billing_Rates, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_Rates SET RateFor=?, ConsumerType=?, ServicePeriod=?, Notes=?, GenerationSystemCharge=?, TransmissionDeliveryChargeKW=?, TransmissionDeliveryChargeKWH=?, SystemLossCharge=?, DistributionDemandCharge=?, DistributionSystemCharge=?, SupplyRetailCustomerCharge=?, SupplySystemCharge=?, MeteringRetailCustomerCharge=?, MeteringSystemCharge=?, RFSC=?, LifelineRate=?, InterClassCrossSubsidyCharge=?, PPARefund=?, SeniorCitizenSubsidy=?, MissionaryElectrificationCharge=?, EnvironmentalCharge=?, StrandedContractCosts=?, NPCStrandedDebt=?, FeedInTariffAllowance=?, MissionaryElectrificationREDCI=?, GenerationVAT=?, TransmissionVAT=?, SystemLossVAT=?, DistributionVAT=?, TotalRateVATExcluded=?, TotalRateVATIncluded=?, UserId=?, created_at=?, updated_at=?, RealPropertyTax=?, AreaCode=?, OtherGenerationRateAdjustment=?, OtherTransmissionCostAdjustmentKW=?, OtherTransmissionCostAdjustmentKWH=?, OtherSystemLossCostAdjustment=?, OtherLifelineRateCostAdjustment=?, SeniorCitizenDiscountAndSubsidyAdjustment=?, FranchiseTax=?, BusinessTax=?, TotalRateVATExcludedWithAdjustments=?  WHERE id=? ");
		ps.setString(1, billing_Rates.getRateFor());
		ps.setString(2, billing_Rates.getConsumerType());
		ps.setString(3, billing_Rates.getServicePeriod());
		ps.setString(4, billing_Rates.getNotes());
		ps.setString(5, billing_Rates.getGenerationSystemCharge());
		ps.setString(6, billing_Rates.getTransmissionDeliveryChargeKW());
		ps.setString(7, billing_Rates.getTransmissionDeliveryChargeKWH());
		ps.setString(8, billing_Rates.getSystemLossCharge());
		ps.setString(9, billing_Rates.getDistributionDemandCharge());
		ps.setString(10, billing_Rates.getDistributionSystemCharge());
		ps.setString(11, billing_Rates.getSupplyRetailCustomerCharge());
		ps.setString(12, billing_Rates.getSupplySystemCharge());
		ps.setString(13, billing_Rates.getMeteringRetailCustomerCharge());
		ps.setString(14, billing_Rates.getMeteringSystemCharge());
		ps.setString(15, billing_Rates.getRFSC());
		ps.setString(16, billing_Rates.getLifelineRate());
		ps.setString(17, billing_Rates.getInterClassCrossSubsidyCharge());
		ps.setString(18, billing_Rates.getPPARefund());
		ps.setString(19, billing_Rates.getSeniorCitizenSubsidy());
		ps.setString(20, billing_Rates.getMissionaryElectrificationCharge());
		ps.setString(21, billing_Rates.getEnvironmentalCharge());
		ps.setString(22, billing_Rates.getStrandedContractCosts());
		ps.setString(23, billing_Rates.getNPCStrandedDebt());
		ps.setString(24, billing_Rates.getFeedInTariffAllowance());
		ps.setString(25, billing_Rates.getMissionaryElectrificationREDCI());
		ps.setString(26, billing_Rates.getGenerationVAT());
		ps.setString(27, billing_Rates.getTransmissionVAT());
		ps.setString(28, billing_Rates.getSystemLossVAT());
		ps.setString(29, billing_Rates.getDistributionVAT());
		ps.setString(30, billing_Rates.getTotalRateVATExcluded());
		ps.setString(31, billing_Rates.getTotalRateVATIncluded());
		ps.setString(32, billing_Rates.getUserId());
		ps.setString(33, billing_Rates.getcreated_at());
		ps.setString(34, billing_Rates.getupdated_at());
		ps.setString(35, billing_Rates.getRealPropertyTax());
		ps.setString(36, billing_Rates.getAreaCode());
		ps.setString(37, billing_Rates.getOtherGenerationRateAdjustment());
		ps.setString(38, billing_Rates.getOtherTransmissionCostAdjustmentKW());
		ps.setString(39, billing_Rates.getOtherTransmissionCostAdjustmentKWH());
		ps.setString(40, billing_Rates.getOtherSystemLossCostAdjustment());
		ps.setString(41, billing_Rates.getOtherLifelineRateCostAdjustment());
		ps.setString(42, billing_Rates.getSeniorCitizenDiscountAndSubsidyAdjustment());
		ps.setString(43, billing_Rates.getFranchiseTax());
		ps.setString(44, billing_Rates.getBusinessTax());
		ps.setString(45, billing_Rates.getTotalRateVATExcludedWithAdjustments());
		ps.setString(46, billing_Rates.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_Rates getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Rates WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_Rates billing_Rates = new Billing_Rates(
			rs.getString("id"),
			rs.getString("RateFor"),
			rs.getString("ConsumerType"),
			rs.getString("ServicePeriod"),
			rs.getString("Notes"),
			rs.getString("GenerationSystemCharge"),
			rs.getString("TransmissionDeliveryChargeKW"),
			rs.getString("TransmissionDeliveryChargeKWH"),
			rs.getString("SystemLossCharge"),
			rs.getString("DistributionDemandCharge"),
			rs.getString("DistributionSystemCharge"),
			rs.getString("SupplyRetailCustomerCharge"),
			rs.getString("SupplySystemCharge"),
			rs.getString("MeteringRetailCustomerCharge"),
			rs.getString("MeteringSystemCharge"),
			rs.getString("RFSC"),
			rs.getString("LifelineRate"),
			rs.getString("InterClassCrossSubsidyCharge"),
			rs.getString("PPARefund"),
			rs.getString("SeniorCitizenSubsidy"),
			rs.getString("MissionaryElectrificationCharge"),
			rs.getString("EnvironmentalCharge"),
			rs.getString("StrandedContractCosts"),
			rs.getString("NPCStrandedDebt"),
			rs.getString("FeedInTariffAllowance"),
			rs.getString("MissionaryElectrificationREDCI"),
			rs.getString("GenerationVAT"),
			rs.getString("TransmissionVAT"),
			rs.getString("SystemLossVAT"),
			rs.getString("DistributionVAT"),
			rs.getString("TotalRateVATExcluded"),
			rs.getString("TotalRateVATIncluded"),
			rs.getString("UserId"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("RealPropertyTax"),
			rs.getString("AreaCode"),
			rs.getString("OtherGenerationRateAdjustment"),
			rs.getString("OtherTransmissionCostAdjustmentKW"),
			rs.getString("OtherTransmissionCostAdjustmentKWH"),
			rs.getString("OtherSystemLossCostAdjustment"),
			rs.getString("OtherLifelineRateCostAdjustment"),
			rs.getString("SeniorCitizenDiscountAndSubsidyAdjustment"),
			rs.getString("FranchiseTax"),
			rs.getString("BusinessTax"),
			rs.getString("TotalRateVATExcludedWithAdjustments")
			);
			ps.close();
			rs.close();
			return billing_Rates;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_Rates> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Rates WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_Rates> billing_RatesList = new ArrayList<>();
		while(rs.next()) {
			Billing_Rates billing_Rates = new Billing_Rates();
			billing_Rates.setid(rs.getString("id"));
			billing_Rates.setRateFor(rs.getString("RateFor"));
			billing_Rates.setConsumerType(rs.getString("ConsumerType"));
			billing_Rates.setServicePeriod(rs.getString("ServicePeriod"));
			billing_Rates.setNotes(rs.getString("Notes"));
			billing_Rates.setGenerationSystemCharge(rs.getString("GenerationSystemCharge"));
			billing_Rates.setTransmissionDeliveryChargeKW(rs.getString("TransmissionDeliveryChargeKW"));
			billing_Rates.setTransmissionDeliveryChargeKWH(rs.getString("TransmissionDeliveryChargeKWH"));
			billing_Rates.setSystemLossCharge(rs.getString("SystemLossCharge"));
			billing_Rates.setDistributionDemandCharge(rs.getString("DistributionDemandCharge"));
			billing_Rates.setDistributionSystemCharge(rs.getString("DistributionSystemCharge"));
			billing_Rates.setSupplyRetailCustomerCharge(rs.getString("SupplyRetailCustomerCharge"));
			billing_Rates.setSupplySystemCharge(rs.getString("SupplySystemCharge"));
			billing_Rates.setMeteringRetailCustomerCharge(rs.getString("MeteringRetailCustomerCharge"));
			billing_Rates.setMeteringSystemCharge(rs.getString("MeteringSystemCharge"));
			billing_Rates.setRFSC(rs.getString("RFSC"));
			billing_Rates.setLifelineRate(rs.getString("LifelineRate"));
			billing_Rates.setInterClassCrossSubsidyCharge(rs.getString("InterClassCrossSubsidyCharge"));
			billing_Rates.setPPARefund(rs.getString("PPARefund"));
			billing_Rates.setSeniorCitizenSubsidy(rs.getString("SeniorCitizenSubsidy"));
			billing_Rates.setMissionaryElectrificationCharge(rs.getString("MissionaryElectrificationCharge"));
			billing_Rates.setEnvironmentalCharge(rs.getString("EnvironmentalCharge"));
			billing_Rates.setStrandedContractCosts(rs.getString("StrandedContractCosts"));
			billing_Rates.setNPCStrandedDebt(rs.getString("NPCStrandedDebt"));
			billing_Rates.setFeedInTariffAllowance(rs.getString("FeedInTariffAllowance"));
			billing_Rates.setMissionaryElectrificationREDCI(rs.getString("MissionaryElectrificationREDCI"));
			billing_Rates.setGenerationVAT(rs.getString("GenerationVAT"));
			billing_Rates.setTransmissionVAT(rs.getString("TransmissionVAT"));
			billing_Rates.setSystemLossVAT(rs.getString("SystemLossVAT"));
			billing_Rates.setDistributionVAT(rs.getString("DistributionVAT"));
			billing_Rates.setTotalRateVATExcluded(rs.getString("TotalRateVATExcluded"));
			billing_Rates.setTotalRateVATIncluded(rs.getString("TotalRateVATIncluded"));
			billing_Rates.setUserId(rs.getString("UserId"));
			billing_Rates.setcreated_at(rs.getString("created_at"));
			billing_Rates.setupdated_at(rs.getString("updated_at"));
			billing_Rates.setRealPropertyTax(rs.getString("RealPropertyTax"));
			billing_Rates.setAreaCode(rs.getString("AreaCode"));
			billing_Rates.setOtherGenerationRateAdjustment(rs.getString("OtherGenerationRateAdjustment"));
			billing_Rates.setOtherTransmissionCostAdjustmentKW(rs.getString("OtherTransmissionCostAdjustmentKW"));
			billing_Rates.setOtherTransmissionCostAdjustmentKWH(rs.getString("OtherTransmissionCostAdjustmentKWH"));
			billing_Rates.setOtherSystemLossCostAdjustment(rs.getString("OtherSystemLossCostAdjustment"));
			billing_Rates.setOtherLifelineRateCostAdjustment(rs.getString("OtherLifelineRateCostAdjustment"));
			billing_Rates.setSeniorCitizenDiscountAndSubsidyAdjustment(rs.getString("SeniorCitizenDiscountAndSubsidyAdjustment"));
			billing_Rates.setFranchiseTax(rs.getString("FranchiseTax"));
			billing_Rates.setBusinessTax(rs.getString("BusinessTax"));
			billing_Rates.setTotalRateVATExcludedWithAdjustments(rs.getString("TotalRateVATExcludedWithAdjustments"));
			billing_RatesList.add(billing_Rates);
		}
		rs.close();
		ps.close();
		return billing_RatesList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_Rates> billing_Billses = Billing_RatesDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_Rates to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_Rates bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_Rates bill = Billing_RatesDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_Rates has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_RatesDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_Rates updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_RatesDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_Rates inserted";
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
