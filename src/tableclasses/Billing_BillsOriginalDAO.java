package tableclasses;

import db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import others.ObjectHelpers;
import replicationagent.MainFrame;
public class Billing_BillsOriginalDAO { 
	public static void insert(Billing_BillsOriginal billing_BillsOriginal, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_BillsOriginal(id, BillNumber, AccountNumber, ServicePeriod, Multiplier, Coreloss, KwhUsed, PreviousKwh, PresentKwh, DemandPreviousKwh, DemandPresentKwh, AdditionalKwh, AdditionalDemandKwh, KwhAmount, EffectiveRate, AdditionalCharges, Deductions, NetAmount, BillingDate, ServiceDateFrom, ServiceDateTo, DueDate, MeterNumber, ConsumerType, BillType, GenerationSystemCharge, TransmissionDeliveryChargeKW, TransmissionDeliveryChargeKWH, SystemLossCharge, DistributionDemandCharge, DistributionSystemCharge, SupplyRetailCustomerCharge, SupplySystemCharge, MeteringRetailCustomerCharge, MeteringSystemCharge, RFSC, LifelineRate, InterClassCrossSubsidyCharge, PPARefund, SeniorCitizenSubsidy, MissionaryElectrificationCharge, EnvironmentalCharge, StrandedContractCosts, NPCStrandedDebt, FeedInTariffAllowance, MissionaryElectrificationREDCI, GenerationVAT, TransmissionVAT, SystemLossVAT, DistributionVAT, RealPropertyTax, OtherGenerationRateAdjustment, OtherTransmissionCostAdjustmentKW, OtherTransmissionCostAdjustmentKWH, OtherSystemLossCostAdjustment, OtherLifelineRateCostAdjustment, SeniorCitizenDiscountAndSubsidyAdjustment, FranchiseTax, BusinessTax, AdjustmentType, AdjustmentNumber, AdjustedBy, DateAdjusted, Notes, UserId, BilledFrom, Form2307Amount, Evat2Percent, Evat5Percent, MergedToCollectible, DeductedDeposit, ExcessDeposit, AveragedCount, IsUnlockedForPayment, UnlockedBy, created_at, updated_at, ForCancellation, CancelRequestedBy, CancelApprovedBy) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_BillsOriginal.getid());
		ps.setString(2, billing_BillsOriginal.getBillNumber());
		ps.setString(3, billing_BillsOriginal.getAccountNumber());
		ps.setString(4, billing_BillsOriginal.getServicePeriod());
		ps.setString(5, billing_BillsOriginal.getMultiplier());
		ps.setString(6, billing_BillsOriginal.getCoreloss());
		ps.setString(7, billing_BillsOriginal.getKwhUsed());
		ps.setString(8, billing_BillsOriginal.getPreviousKwh());
		ps.setString(9, billing_BillsOriginal.getPresentKwh());
		ps.setString(10, billing_BillsOriginal.getDemandPreviousKwh());
		ps.setString(11, billing_BillsOriginal.getDemandPresentKwh());
		ps.setString(12, billing_BillsOriginal.getAdditionalKwh());
		ps.setString(13, billing_BillsOriginal.getAdditionalDemandKwh());
		ps.setString(14, billing_BillsOriginal.getKwhAmount());
		ps.setString(15, billing_BillsOriginal.getEffectiveRate());
		ps.setString(16, billing_BillsOriginal.getAdditionalCharges());
		ps.setString(17, billing_BillsOriginal.getDeductions());
		ps.setString(18, billing_BillsOriginal.getNetAmount());
		ps.setString(19, billing_BillsOriginal.getBillingDate());
		ps.setString(20, billing_BillsOriginal.getServiceDateFrom());
		ps.setString(21, billing_BillsOriginal.getServiceDateTo());
		ps.setString(22, billing_BillsOriginal.getDueDate());
		ps.setString(23, billing_BillsOriginal.getMeterNumber());
		ps.setString(24, billing_BillsOriginal.getConsumerType());
		ps.setString(25, billing_BillsOriginal.getBillType());
		ps.setString(26, billing_BillsOriginal.getGenerationSystemCharge());
		ps.setString(27, billing_BillsOriginal.getTransmissionDeliveryChargeKW());
		ps.setString(28, billing_BillsOriginal.getTransmissionDeliveryChargeKWH());
		ps.setString(29, billing_BillsOriginal.getSystemLossCharge());
		ps.setString(30, billing_BillsOriginal.getDistributionDemandCharge());
		ps.setString(31, billing_BillsOriginal.getDistributionSystemCharge());
		ps.setString(32, billing_BillsOriginal.getSupplyRetailCustomerCharge());
		ps.setString(33, billing_BillsOriginal.getSupplySystemCharge());
		ps.setString(34, billing_BillsOriginal.getMeteringRetailCustomerCharge());
		ps.setString(35, billing_BillsOriginal.getMeteringSystemCharge());
		ps.setString(36, billing_BillsOriginal.getRFSC());
		ps.setString(37, billing_BillsOriginal.getLifelineRate());
		ps.setString(38, billing_BillsOriginal.getInterClassCrossSubsidyCharge());
		ps.setString(39, billing_BillsOriginal.getPPARefund());
		ps.setString(40, billing_BillsOriginal.getSeniorCitizenSubsidy());
		ps.setString(41, billing_BillsOriginal.getMissionaryElectrificationCharge());
		ps.setString(42, billing_BillsOriginal.getEnvironmentalCharge());
		ps.setString(43, billing_BillsOriginal.getStrandedContractCosts());
		ps.setString(44, billing_BillsOriginal.getNPCStrandedDebt());
		ps.setString(45, billing_BillsOriginal.getFeedInTariffAllowance());
		ps.setString(46, billing_BillsOriginal.getMissionaryElectrificationREDCI());
		ps.setString(47, billing_BillsOriginal.getGenerationVAT());
		ps.setString(48, billing_BillsOriginal.getTransmissionVAT());
		ps.setString(49, billing_BillsOriginal.getSystemLossVAT());
		ps.setString(50, billing_BillsOriginal.getDistributionVAT());
		ps.setString(51, billing_BillsOriginal.getRealPropertyTax());
		ps.setString(52, billing_BillsOriginal.getOtherGenerationRateAdjustment());
		ps.setString(53, billing_BillsOriginal.getOtherTransmissionCostAdjustmentKW());
		ps.setString(54, billing_BillsOriginal.getOtherTransmissionCostAdjustmentKWH());
		ps.setString(55, billing_BillsOriginal.getOtherSystemLossCostAdjustment());
		ps.setString(56, billing_BillsOriginal.getOtherLifelineRateCostAdjustment());
		ps.setString(57, billing_BillsOriginal.getSeniorCitizenDiscountAndSubsidyAdjustment());
		ps.setString(58, billing_BillsOriginal.getFranchiseTax());
		ps.setString(59, billing_BillsOriginal.getBusinessTax());
		ps.setString(60, billing_BillsOriginal.getAdjustmentType());
		ps.setString(61, billing_BillsOriginal.getAdjustmentNumber());
		ps.setString(62, billing_BillsOriginal.getAdjustedBy());
		ps.setString(63, billing_BillsOriginal.getDateAdjusted());
		ps.setString(64, billing_BillsOriginal.getNotes());
		ps.setString(65, billing_BillsOriginal.getUserId());
		ps.setString(66, billing_BillsOriginal.getBilledFrom());
		ps.setString(67, billing_BillsOriginal.getForm2307Amount());
		ps.setString(68, billing_BillsOriginal.getEvat2Percent());
		ps.setString(69, billing_BillsOriginal.getEvat5Percent());
		ps.setString(70, billing_BillsOriginal.getMergedToCollectible());
		ps.setString(71, billing_BillsOriginal.getDeductedDeposit());
		ps.setString(72, billing_BillsOriginal.getExcessDeposit());
		ps.setString(73, billing_BillsOriginal.getAveragedCount());
		ps.setString(74, billing_BillsOriginal.getIsUnlockedForPayment());
		ps.setString(75, billing_BillsOriginal.getUnlockedBy());
		ps.setString(76, billing_BillsOriginal.getcreated_at());
		ps.setString(77, billing_BillsOriginal.getupdated_at());
		ps.setString(78, billing_BillsOriginal.getForCancellation());
		ps.setString(79, billing_BillsOriginal.getCancelRequestedBy());
		ps.setString(80, billing_BillsOriginal.getCancelApprovedBy());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_BillsOriginal billing_BillsOriginal, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_BillsOriginal SET BillNumber=?, AccountNumber=?, ServicePeriod=?, Multiplier=?, Coreloss=?, KwhUsed=?, PreviousKwh=?, PresentKwh=?, DemandPreviousKwh=?, DemandPresentKwh=?, AdditionalKwh=?, AdditionalDemandKwh=?, KwhAmount=?, EffectiveRate=?, AdditionalCharges=?, Deductions=?, NetAmount=?, BillingDate=?, ServiceDateFrom=?, ServiceDateTo=?, DueDate=?, MeterNumber=?, ConsumerType=?, BillType=?, GenerationSystemCharge=?, TransmissionDeliveryChargeKW=?, TransmissionDeliveryChargeKWH=?, SystemLossCharge=?, DistributionDemandCharge=?, DistributionSystemCharge=?, SupplyRetailCustomerCharge=?, SupplySystemCharge=?, MeteringRetailCustomerCharge=?, MeteringSystemCharge=?, RFSC=?, LifelineRate=?, InterClassCrossSubsidyCharge=?, PPARefund=?, SeniorCitizenSubsidy=?, MissionaryElectrificationCharge=?, EnvironmentalCharge=?, StrandedContractCosts=?, NPCStrandedDebt=?, FeedInTariffAllowance=?, MissionaryElectrificationREDCI=?, GenerationVAT=?, TransmissionVAT=?, SystemLossVAT=?, DistributionVAT=?, RealPropertyTax=?, OtherGenerationRateAdjustment=?, OtherTransmissionCostAdjustmentKW=?, OtherTransmissionCostAdjustmentKWH=?, OtherSystemLossCostAdjustment=?, OtherLifelineRateCostAdjustment=?, SeniorCitizenDiscountAndSubsidyAdjustment=?, FranchiseTax=?, BusinessTax=?, AdjustmentType=?, AdjustmentNumber=?, AdjustedBy=?, DateAdjusted=?, Notes=?, UserId=?, BilledFrom=?, Form2307Amount=?, Evat2Percent=?, Evat5Percent=?, MergedToCollectible=?, DeductedDeposit=?, ExcessDeposit=?, AveragedCount=?, IsUnlockedForPayment=?, UnlockedBy=?, created_at=?, updated_at=?, ForCancellation=?, CancelRequestedBy=?, CancelApprovedBy=?  WHERE id=? ");
		ps.setString(1, billing_BillsOriginal.getBillNumber());
		ps.setString(2, billing_BillsOriginal.getAccountNumber());
		ps.setString(3, billing_BillsOriginal.getServicePeriod());
		ps.setString(4, billing_BillsOriginal.getMultiplier());
		ps.setString(5, billing_BillsOriginal.getCoreloss());
		ps.setString(6, billing_BillsOriginal.getKwhUsed());
		ps.setString(7, billing_BillsOriginal.getPreviousKwh());
		ps.setString(8, billing_BillsOriginal.getPresentKwh());
		ps.setString(9, billing_BillsOriginal.getDemandPreviousKwh());
		ps.setString(10, billing_BillsOriginal.getDemandPresentKwh());
		ps.setString(11, billing_BillsOriginal.getAdditionalKwh());
		ps.setString(12, billing_BillsOriginal.getAdditionalDemandKwh());
		ps.setString(13, billing_BillsOriginal.getKwhAmount());
		ps.setString(14, billing_BillsOriginal.getEffectiveRate());
		ps.setString(15, billing_BillsOriginal.getAdditionalCharges());
		ps.setString(16, billing_BillsOriginal.getDeductions());
		ps.setString(17, billing_BillsOriginal.getNetAmount());
		ps.setString(18, billing_BillsOriginal.getBillingDate());
		ps.setString(19, billing_BillsOriginal.getServiceDateFrom());
		ps.setString(20, billing_BillsOriginal.getServiceDateTo());
		ps.setString(21, billing_BillsOriginal.getDueDate());
		ps.setString(22, billing_BillsOriginal.getMeterNumber());
		ps.setString(23, billing_BillsOriginal.getConsumerType());
		ps.setString(24, billing_BillsOriginal.getBillType());
		ps.setString(25, billing_BillsOriginal.getGenerationSystemCharge());
		ps.setString(26, billing_BillsOriginal.getTransmissionDeliveryChargeKW());
		ps.setString(27, billing_BillsOriginal.getTransmissionDeliveryChargeKWH());
		ps.setString(28, billing_BillsOriginal.getSystemLossCharge());
		ps.setString(29, billing_BillsOriginal.getDistributionDemandCharge());
		ps.setString(30, billing_BillsOriginal.getDistributionSystemCharge());
		ps.setString(31, billing_BillsOriginal.getSupplyRetailCustomerCharge());
		ps.setString(32, billing_BillsOriginal.getSupplySystemCharge());
		ps.setString(33, billing_BillsOriginal.getMeteringRetailCustomerCharge());
		ps.setString(34, billing_BillsOriginal.getMeteringSystemCharge());
		ps.setString(35, billing_BillsOriginal.getRFSC());
		ps.setString(36, billing_BillsOriginal.getLifelineRate());
		ps.setString(37, billing_BillsOriginal.getInterClassCrossSubsidyCharge());
		ps.setString(38, billing_BillsOriginal.getPPARefund());
		ps.setString(39, billing_BillsOriginal.getSeniorCitizenSubsidy());
		ps.setString(40, billing_BillsOriginal.getMissionaryElectrificationCharge());
		ps.setString(41, billing_BillsOriginal.getEnvironmentalCharge());
		ps.setString(42, billing_BillsOriginal.getStrandedContractCosts());
		ps.setString(43, billing_BillsOriginal.getNPCStrandedDebt());
		ps.setString(44, billing_BillsOriginal.getFeedInTariffAllowance());
		ps.setString(45, billing_BillsOriginal.getMissionaryElectrificationREDCI());
		ps.setString(46, billing_BillsOriginal.getGenerationVAT());
		ps.setString(47, billing_BillsOriginal.getTransmissionVAT());
		ps.setString(48, billing_BillsOriginal.getSystemLossVAT());
		ps.setString(49, billing_BillsOriginal.getDistributionVAT());
		ps.setString(50, billing_BillsOriginal.getRealPropertyTax());
		ps.setString(51, billing_BillsOriginal.getOtherGenerationRateAdjustment());
		ps.setString(52, billing_BillsOriginal.getOtherTransmissionCostAdjustmentKW());
		ps.setString(53, billing_BillsOriginal.getOtherTransmissionCostAdjustmentKWH());
		ps.setString(54, billing_BillsOriginal.getOtherSystemLossCostAdjustment());
		ps.setString(55, billing_BillsOriginal.getOtherLifelineRateCostAdjustment());
		ps.setString(56, billing_BillsOriginal.getSeniorCitizenDiscountAndSubsidyAdjustment());
		ps.setString(57, billing_BillsOriginal.getFranchiseTax());
		ps.setString(58, billing_BillsOriginal.getBusinessTax());
		ps.setString(59, billing_BillsOriginal.getAdjustmentType());
		ps.setString(60, billing_BillsOriginal.getAdjustmentNumber());
		ps.setString(61, billing_BillsOriginal.getAdjustedBy());
		ps.setString(62, billing_BillsOriginal.getDateAdjusted());
		ps.setString(63, billing_BillsOriginal.getNotes());
		ps.setString(64, billing_BillsOriginal.getUserId());
		ps.setString(65, billing_BillsOriginal.getBilledFrom());
		ps.setString(66, billing_BillsOriginal.getForm2307Amount());
		ps.setString(67, billing_BillsOriginal.getEvat2Percent());
		ps.setString(68, billing_BillsOriginal.getEvat5Percent());
		ps.setString(69, billing_BillsOriginal.getMergedToCollectible());
		ps.setString(70, billing_BillsOriginal.getDeductedDeposit());
		ps.setString(71, billing_BillsOriginal.getExcessDeposit());
		ps.setString(72, billing_BillsOriginal.getAveragedCount());
		ps.setString(73, billing_BillsOriginal.getIsUnlockedForPayment());
		ps.setString(74, billing_BillsOriginal.getUnlockedBy());
		ps.setString(75, billing_BillsOriginal.getcreated_at());
		ps.setString(76, billing_BillsOriginal.getupdated_at());
		ps.setString(77, billing_BillsOriginal.getForCancellation());
		ps.setString(78, billing_BillsOriginal.getCancelRequestedBy());
		ps.setString(79, billing_BillsOriginal.getCancelApprovedBy());
		ps.setString(80, billing_BillsOriginal.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_BillsOriginal getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_BillsOriginal WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_BillsOriginal billing_BillsOriginal = new Billing_BillsOriginal(
			rs.getString("id"),
			rs.getString("BillNumber"),
			rs.getString("AccountNumber"),
			rs.getString("ServicePeriod"),
			rs.getString("Multiplier"),
			rs.getString("Coreloss"),
			rs.getString("KwhUsed"),
			rs.getString("PreviousKwh"),
			rs.getString("PresentKwh"),
			rs.getString("DemandPreviousKwh"),
			rs.getString("DemandPresentKwh"),
			rs.getString("AdditionalKwh"),
			rs.getString("AdditionalDemandKwh"),
			rs.getString("KwhAmount"),
			rs.getString("EffectiveRate"),
			rs.getString("AdditionalCharges"),
			rs.getString("Deductions"),
			rs.getString("NetAmount"),
			rs.getString("BillingDate"),
			rs.getString("ServiceDateFrom"),
			rs.getString("ServiceDateTo"),
			rs.getString("DueDate"),
			rs.getString("MeterNumber"),
			rs.getString("ConsumerType"),
			rs.getString("BillType"),
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
			rs.getString("RealPropertyTax"),
			rs.getString("OtherGenerationRateAdjustment"),
			rs.getString("OtherTransmissionCostAdjustmentKW"),
			rs.getString("OtherTransmissionCostAdjustmentKWH"),
			rs.getString("OtherSystemLossCostAdjustment"),
			rs.getString("OtherLifelineRateCostAdjustment"),
			rs.getString("SeniorCitizenDiscountAndSubsidyAdjustment"),
			rs.getString("FranchiseTax"),
			rs.getString("BusinessTax"),
			rs.getString("AdjustmentType"),
			rs.getString("AdjustmentNumber"),
			rs.getString("AdjustedBy"),
			rs.getString("DateAdjusted"),
			rs.getString("Notes"),
			rs.getString("UserId"),
			rs.getString("BilledFrom"),
			rs.getString("Form2307Amount"),
			rs.getString("Evat2Percent"),
			rs.getString("Evat5Percent"),
			rs.getString("MergedToCollectible"),
			rs.getString("DeductedDeposit"),
			rs.getString("ExcessDeposit"),
			rs.getString("AveragedCount"),
			rs.getString("IsUnlockedForPayment"),
			rs.getString("UnlockedBy"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("ForCancellation"),
			rs.getString("CancelRequestedBy"),
			rs.getString("CancelApprovedBy")
			);
			ps.close();
			rs.close();
			return billing_BillsOriginal;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_BillsOriginal> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_BillsOriginal WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_BillsOriginal> billing_BillsOriginalList = new ArrayList<>();
		while(rs.next()) {
			Billing_BillsOriginal billing_BillsOriginal = new Billing_BillsOriginal();
			billing_BillsOriginal.setid(rs.getString("id"));
			billing_BillsOriginal.setBillNumber(rs.getString("BillNumber"));
			billing_BillsOriginal.setAccountNumber(rs.getString("AccountNumber"));
			billing_BillsOriginal.setServicePeriod(rs.getString("ServicePeriod"));
			billing_BillsOriginal.setMultiplier(rs.getString("Multiplier"));
			billing_BillsOriginal.setCoreloss(rs.getString("Coreloss"));
			billing_BillsOriginal.setKwhUsed(rs.getString("KwhUsed"));
			billing_BillsOriginal.setPreviousKwh(rs.getString("PreviousKwh"));
			billing_BillsOriginal.setPresentKwh(rs.getString("PresentKwh"));
			billing_BillsOriginal.setDemandPreviousKwh(rs.getString("DemandPreviousKwh"));
			billing_BillsOriginal.setDemandPresentKwh(rs.getString("DemandPresentKwh"));
			billing_BillsOriginal.setAdditionalKwh(rs.getString("AdditionalKwh"));
			billing_BillsOriginal.setAdditionalDemandKwh(rs.getString("AdditionalDemandKwh"));
			billing_BillsOriginal.setKwhAmount(rs.getString("KwhAmount"));
			billing_BillsOriginal.setEffectiveRate(rs.getString("EffectiveRate"));
			billing_BillsOriginal.setAdditionalCharges(rs.getString("AdditionalCharges"));
			billing_BillsOriginal.setDeductions(rs.getString("Deductions"));
			billing_BillsOriginal.setNetAmount(rs.getString("NetAmount"));
			billing_BillsOriginal.setBillingDate(rs.getString("BillingDate"));
			billing_BillsOriginal.setServiceDateFrom(rs.getString("ServiceDateFrom"));
			billing_BillsOriginal.setServiceDateTo(rs.getString("ServiceDateTo"));
			billing_BillsOriginal.setDueDate(rs.getString("DueDate"));
			billing_BillsOriginal.setMeterNumber(rs.getString("MeterNumber"));
			billing_BillsOriginal.setConsumerType(rs.getString("ConsumerType"));
			billing_BillsOriginal.setBillType(rs.getString("BillType"));
			billing_BillsOriginal.setGenerationSystemCharge(rs.getString("GenerationSystemCharge"));
			billing_BillsOriginal.setTransmissionDeliveryChargeKW(rs.getString("TransmissionDeliveryChargeKW"));
			billing_BillsOriginal.setTransmissionDeliveryChargeKWH(rs.getString("TransmissionDeliveryChargeKWH"));
			billing_BillsOriginal.setSystemLossCharge(rs.getString("SystemLossCharge"));
			billing_BillsOriginal.setDistributionDemandCharge(rs.getString("DistributionDemandCharge"));
			billing_BillsOriginal.setDistributionSystemCharge(rs.getString("DistributionSystemCharge"));
			billing_BillsOriginal.setSupplyRetailCustomerCharge(rs.getString("SupplyRetailCustomerCharge"));
			billing_BillsOriginal.setSupplySystemCharge(rs.getString("SupplySystemCharge"));
			billing_BillsOriginal.setMeteringRetailCustomerCharge(rs.getString("MeteringRetailCustomerCharge"));
			billing_BillsOriginal.setMeteringSystemCharge(rs.getString("MeteringSystemCharge"));
			billing_BillsOriginal.setRFSC(rs.getString("RFSC"));
			billing_BillsOriginal.setLifelineRate(rs.getString("LifelineRate"));
			billing_BillsOriginal.setInterClassCrossSubsidyCharge(rs.getString("InterClassCrossSubsidyCharge"));
			billing_BillsOriginal.setPPARefund(rs.getString("PPARefund"));
			billing_BillsOriginal.setSeniorCitizenSubsidy(rs.getString("SeniorCitizenSubsidy"));
			billing_BillsOriginal.setMissionaryElectrificationCharge(rs.getString("MissionaryElectrificationCharge"));
			billing_BillsOriginal.setEnvironmentalCharge(rs.getString("EnvironmentalCharge"));
			billing_BillsOriginal.setStrandedContractCosts(rs.getString("StrandedContractCosts"));
			billing_BillsOriginal.setNPCStrandedDebt(rs.getString("NPCStrandedDebt"));
			billing_BillsOriginal.setFeedInTariffAllowance(rs.getString("FeedInTariffAllowance"));
			billing_BillsOriginal.setMissionaryElectrificationREDCI(rs.getString("MissionaryElectrificationREDCI"));
			billing_BillsOriginal.setGenerationVAT(rs.getString("GenerationVAT"));
			billing_BillsOriginal.setTransmissionVAT(rs.getString("TransmissionVAT"));
			billing_BillsOriginal.setSystemLossVAT(rs.getString("SystemLossVAT"));
			billing_BillsOriginal.setDistributionVAT(rs.getString("DistributionVAT"));
			billing_BillsOriginal.setRealPropertyTax(rs.getString("RealPropertyTax"));
			billing_BillsOriginal.setOtherGenerationRateAdjustment(rs.getString("OtherGenerationRateAdjustment"));
			billing_BillsOriginal.setOtherTransmissionCostAdjustmentKW(rs.getString("OtherTransmissionCostAdjustmentKW"));
			billing_BillsOriginal.setOtherTransmissionCostAdjustmentKWH(rs.getString("OtherTransmissionCostAdjustmentKWH"));
			billing_BillsOriginal.setOtherSystemLossCostAdjustment(rs.getString("OtherSystemLossCostAdjustment"));
			billing_BillsOriginal.setOtherLifelineRateCostAdjustment(rs.getString("OtherLifelineRateCostAdjustment"));
			billing_BillsOriginal.setSeniorCitizenDiscountAndSubsidyAdjustment(rs.getString("SeniorCitizenDiscountAndSubsidyAdjustment"));
			billing_BillsOriginal.setFranchiseTax(rs.getString("FranchiseTax"));
			billing_BillsOriginal.setBusinessTax(rs.getString("BusinessTax"));
			billing_BillsOriginal.setAdjustmentType(rs.getString("AdjustmentType"));
			billing_BillsOriginal.setAdjustmentNumber(rs.getString("AdjustmentNumber"));
			billing_BillsOriginal.setAdjustedBy(rs.getString("AdjustedBy"));
			billing_BillsOriginal.setDateAdjusted(rs.getString("DateAdjusted"));
			billing_BillsOriginal.setNotes(rs.getString("Notes"));
			billing_BillsOriginal.setUserId(rs.getString("UserId"));
			billing_BillsOriginal.setBilledFrom(rs.getString("BilledFrom"));
			billing_BillsOriginal.setForm2307Amount(rs.getString("Form2307Amount"));
			billing_BillsOriginal.setEvat2Percent(rs.getString("Evat2Percent"));
			billing_BillsOriginal.setEvat5Percent(rs.getString("Evat5Percent"));
			billing_BillsOriginal.setMergedToCollectible(rs.getString("MergedToCollectible"));
			billing_BillsOriginal.setDeductedDeposit(rs.getString("DeductedDeposit"));
			billing_BillsOriginal.setExcessDeposit(rs.getString("ExcessDeposit"));
			billing_BillsOriginal.setAveragedCount(rs.getString("AveragedCount"));
			billing_BillsOriginal.setIsUnlockedForPayment(rs.getString("IsUnlockedForPayment"));
			billing_BillsOriginal.setUnlockedBy(rs.getString("UnlockedBy"));
			billing_BillsOriginal.setcreated_at(rs.getString("created_at"));
			billing_BillsOriginal.setupdated_at(rs.getString("updated_at"));
			billing_BillsOriginal.setForCancellation(rs.getString("ForCancellation"));
			billing_BillsOriginal.setCancelRequestedBy(rs.getString("CancelRequestedBy"));
			billing_BillsOriginal.setCancelApprovedBy(rs.getString("CancelApprovedBy"));
			billing_BillsOriginalList.add(billing_BillsOriginal);
		}
		rs.close();
		ps.close();
		return billing_BillsOriginalList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_BillsOriginal> billing_Billses = Billing_BillsOriginalDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_BillsOriginal to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_BillsOriginal bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_BillsOriginal bill = Billing_BillsOriginalDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_BillsOriginal has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_BillsOriginalDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_BillsOriginal updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_BillsOriginalDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_BillsOriginal inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
