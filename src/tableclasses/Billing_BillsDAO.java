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
public class Billing_BillsDAO { 
	public static void insert(Billing_Bills billing_Bills, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Billing_Bills(id, BillNumber, AccountNumber, ServicePeriod, Multiplier, Coreloss, KwhUsed, PreviousKwh, PresentKwh, DemandPreviousKwh, DemandPresentKwh, AdditionalKwh, AdditionalDemandKwh, KwhAmount, EffectiveRate, AdditionalCharges, Deductions, NetAmount, BillingDate, ServiceDateFrom, ServiceDateTo, DueDate, MeterNumber, ConsumerType, BillType, GenerationSystemCharge, TransmissionDeliveryChargeKW, TransmissionDeliveryChargeKWH, SystemLossCharge, DistributionDemandCharge, DistributionSystemCharge, SupplyRetailCustomerCharge, SupplySystemCharge, MeteringRetailCustomerCharge, MeteringSystemCharge, RFSC, LifelineRate, InterClassCrossSubsidyCharge, PPARefund, SeniorCitizenSubsidy, MissionaryElectrificationCharge, EnvironmentalCharge, StrandedContractCosts, NPCStrandedDebt, FeedInTariffAllowance, MissionaryElectrificationREDCI, GenerationVAT, TransmissionVAT, SystemLossVAT, DistributionVAT, RealPropertyTax, Notes, UserId, BilledFrom, created_at, updated_at, AveragedCount, MergedToCollectible, OtherGenerationRateAdjustment, OtherTransmissionCostAdjustmentKW, OtherTransmissionCostAdjustmentKWH, OtherSystemLossCostAdjustment, OtherLifelineRateCostAdjustment, SeniorCitizenDiscountAndSubsidyAdjustment, FranchiseTax, BusinessTax, AdjustmentType, Form2307Amount, DeductedDeposit, ExcessDeposit, IsUnlockedForPayment, UnlockedBy, Evat2Percent, Evat5Percent, AdjustmentNumber, AdjustedBy, DateAdjusted, ForCancellation, CancelRequestedBy, CancelApprovedBy) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, billing_Bills.getid());
		ps.setString(2, billing_Bills.getBillNumber());
		ps.setString(3, billing_Bills.getAccountNumber());
		ps.setString(4, billing_Bills.getServicePeriod());
		ps.setString(5, billing_Bills.getMultiplier());
		ps.setString(6, billing_Bills.getCoreloss());
		ps.setString(7, billing_Bills.getKwhUsed());
		ps.setString(8, billing_Bills.getPreviousKwh());
		ps.setString(9, billing_Bills.getPresentKwh());
		ps.setString(10, billing_Bills.getDemandPreviousKwh());
		ps.setString(11, billing_Bills.getDemandPresentKwh());
		ps.setString(12, billing_Bills.getAdditionalKwh());
		ps.setString(13, billing_Bills.getAdditionalDemandKwh());
		ps.setString(14, billing_Bills.getKwhAmount());
		ps.setString(15, billing_Bills.getEffectiveRate());
		ps.setString(16, billing_Bills.getAdditionalCharges());
		ps.setString(17, billing_Bills.getDeductions());
		ps.setString(18, billing_Bills.getNetAmount());
		ps.setString(19, billing_Bills.getBillingDate());
		ps.setString(20, billing_Bills.getServiceDateFrom());
		ps.setString(21, billing_Bills.getServiceDateTo());
		ps.setString(22, billing_Bills.getDueDate());
		ps.setString(23, billing_Bills.getMeterNumber());
		ps.setString(24, billing_Bills.getConsumerType());
		ps.setString(25, billing_Bills.getBillType());
		ps.setString(26, billing_Bills.getGenerationSystemCharge());
		ps.setString(27, billing_Bills.getTransmissionDeliveryChargeKW());
		ps.setString(28, billing_Bills.getTransmissionDeliveryChargeKWH());
		ps.setString(29, billing_Bills.getSystemLossCharge());
		ps.setString(30, billing_Bills.getDistributionDemandCharge());
		ps.setString(31, billing_Bills.getDistributionSystemCharge());
		ps.setString(32, billing_Bills.getSupplyRetailCustomerCharge());
		ps.setString(33, billing_Bills.getSupplySystemCharge());
		ps.setString(34, billing_Bills.getMeteringRetailCustomerCharge());
		ps.setString(35, billing_Bills.getMeteringSystemCharge());
		ps.setString(36, billing_Bills.getRFSC());
		ps.setString(37, billing_Bills.getLifelineRate());
		ps.setString(38, billing_Bills.getInterClassCrossSubsidyCharge());
		ps.setString(39, billing_Bills.getPPARefund());
		ps.setString(40, billing_Bills.getSeniorCitizenSubsidy());
		ps.setString(41, billing_Bills.getMissionaryElectrificationCharge());
		ps.setString(42, billing_Bills.getEnvironmentalCharge());
		ps.setString(43, billing_Bills.getStrandedContractCosts());
		ps.setString(44, billing_Bills.getNPCStrandedDebt());
		ps.setString(45, billing_Bills.getFeedInTariffAllowance());
		ps.setString(46, billing_Bills.getMissionaryElectrificationREDCI());
		ps.setString(47, billing_Bills.getGenerationVAT());
		ps.setString(48, billing_Bills.getTransmissionVAT());
		ps.setString(49, billing_Bills.getSystemLossVAT());
		ps.setString(50, billing_Bills.getDistributionVAT());
		ps.setString(51, billing_Bills.getRealPropertyTax());
		ps.setString(52, billing_Bills.getNotes());
		ps.setString(53, billing_Bills.getUserId());
		ps.setString(54, billing_Bills.getBilledFrom());
		ps.setString(55, billing_Bills.getcreated_at());
		ps.setString(56, billing_Bills.getupdated_at());
		ps.setString(57, billing_Bills.getAveragedCount());
		ps.setString(58, billing_Bills.getMergedToCollectible());
		ps.setString(59, billing_Bills.getOtherGenerationRateAdjustment());
		ps.setString(60, billing_Bills.getOtherTransmissionCostAdjustmentKW());
		ps.setString(61, billing_Bills.getOtherTransmissionCostAdjustmentKWH());
		ps.setString(62, billing_Bills.getOtherSystemLossCostAdjustment());
		ps.setString(63, billing_Bills.getOtherLifelineRateCostAdjustment());
		ps.setString(64, billing_Bills.getSeniorCitizenDiscountAndSubsidyAdjustment());
		ps.setString(65, billing_Bills.getFranchiseTax());
		ps.setString(66, billing_Bills.getBusinessTax());
		ps.setString(67, billing_Bills.getAdjustmentType());
		ps.setString(68, billing_Bills.getForm2307Amount());
		ps.setString(69, billing_Bills.getDeductedDeposit());
		ps.setString(70, billing_Bills.getExcessDeposit());
		ps.setString(71, billing_Bills.getIsUnlockedForPayment());
		ps.setString(72, billing_Bills.getUnlockedBy());
		ps.setString(73, billing_Bills.getEvat2Percent());
		ps.setString(74, billing_Bills.getEvat5Percent());
		ps.setString(75, billing_Bills.getAdjustmentNumber());
		ps.setString(76, billing_Bills.getAdjustedBy());
		ps.setString(77, billing_Bills.getDateAdjusted());
		ps.setString(78, billing_Bills.getForCancellation());
		ps.setString(79, billing_Bills.getCancelRequestedBy());
		ps.setString(80, billing_Bills.getCancelApprovedBy());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Billing_Bills billing_Bills, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Billing_Bills SET BillNumber=?, AccountNumber=?, ServicePeriod=?, Multiplier=?, Coreloss=?, KwhUsed=?, PreviousKwh=?, PresentKwh=?, DemandPreviousKwh=?, DemandPresentKwh=?, AdditionalKwh=?, AdditionalDemandKwh=?, KwhAmount=?, EffectiveRate=?, AdditionalCharges=?, Deductions=?, NetAmount=?, BillingDate=?, ServiceDateFrom=?, ServiceDateTo=?, DueDate=?, MeterNumber=?, ConsumerType=?, BillType=?, GenerationSystemCharge=?, TransmissionDeliveryChargeKW=?, TransmissionDeliveryChargeKWH=?, SystemLossCharge=?, DistributionDemandCharge=?, DistributionSystemCharge=?, SupplyRetailCustomerCharge=?, SupplySystemCharge=?, MeteringRetailCustomerCharge=?, MeteringSystemCharge=?, RFSC=?, LifelineRate=?, InterClassCrossSubsidyCharge=?, PPARefund=?, SeniorCitizenSubsidy=?, MissionaryElectrificationCharge=?, EnvironmentalCharge=?, StrandedContractCosts=?, NPCStrandedDebt=?, FeedInTariffAllowance=?, MissionaryElectrificationREDCI=?, GenerationVAT=?, TransmissionVAT=?, SystemLossVAT=?, DistributionVAT=?, RealPropertyTax=?, Notes=?, UserId=?, BilledFrom=?, created_at=?, updated_at=?, AveragedCount=?, MergedToCollectible=?, OtherGenerationRateAdjustment=?, OtherTransmissionCostAdjustmentKW=?, OtherTransmissionCostAdjustmentKWH=?, OtherSystemLossCostAdjustment=?, OtherLifelineRateCostAdjustment=?, SeniorCitizenDiscountAndSubsidyAdjustment=?, FranchiseTax=?, BusinessTax=?, AdjustmentType=?, Form2307Amount=?, DeductedDeposit=?, ExcessDeposit=?, IsUnlockedForPayment=?, UnlockedBy=?, Evat2Percent=?, Evat5Percent=?, AdjustmentNumber=?, AdjustedBy=?, DateAdjusted=?, ForCancellation=?, CancelRequestedBy=?, CancelApprovedBy=?  WHERE id=? ");
		ps.setString(1, billing_Bills.getBillNumber());
		ps.setString(2, billing_Bills.getAccountNumber());
		ps.setString(3, billing_Bills.getServicePeriod());
		ps.setString(4, billing_Bills.getMultiplier());
		ps.setString(5, billing_Bills.getCoreloss());
		ps.setString(6, billing_Bills.getKwhUsed());
		ps.setString(7, billing_Bills.getPreviousKwh());
		ps.setString(8, billing_Bills.getPresentKwh());
		ps.setString(9, billing_Bills.getDemandPreviousKwh());
		ps.setString(10, billing_Bills.getDemandPresentKwh());
		ps.setString(11, billing_Bills.getAdditionalKwh());
		ps.setString(12, billing_Bills.getAdditionalDemandKwh());
		ps.setString(13, billing_Bills.getKwhAmount());
		ps.setString(14, billing_Bills.getEffectiveRate());
		ps.setString(15, billing_Bills.getAdditionalCharges());
		ps.setString(16, billing_Bills.getDeductions());
		ps.setString(17, billing_Bills.getNetAmount());
		ps.setString(18, billing_Bills.getBillingDate());
		ps.setString(19, billing_Bills.getServiceDateFrom());
		ps.setString(20, billing_Bills.getServiceDateTo());
		ps.setString(21, billing_Bills.getDueDate());
		ps.setString(22, billing_Bills.getMeterNumber());
		ps.setString(23, billing_Bills.getConsumerType());
		ps.setString(24, billing_Bills.getBillType());
		ps.setString(25, billing_Bills.getGenerationSystemCharge());
		ps.setString(26, billing_Bills.getTransmissionDeliveryChargeKW());
		ps.setString(27, billing_Bills.getTransmissionDeliveryChargeKWH());
		ps.setString(28, billing_Bills.getSystemLossCharge());
		ps.setString(29, billing_Bills.getDistributionDemandCharge());
		ps.setString(30, billing_Bills.getDistributionSystemCharge());
		ps.setString(31, billing_Bills.getSupplyRetailCustomerCharge());
		ps.setString(32, billing_Bills.getSupplySystemCharge());
		ps.setString(33, billing_Bills.getMeteringRetailCustomerCharge());
		ps.setString(34, billing_Bills.getMeteringSystemCharge());
		ps.setString(35, billing_Bills.getRFSC());
		ps.setString(36, billing_Bills.getLifelineRate());
		ps.setString(37, billing_Bills.getInterClassCrossSubsidyCharge());
		ps.setString(38, billing_Bills.getPPARefund());
		ps.setString(39, billing_Bills.getSeniorCitizenSubsidy());
		ps.setString(40, billing_Bills.getMissionaryElectrificationCharge());
		ps.setString(41, billing_Bills.getEnvironmentalCharge());
		ps.setString(42, billing_Bills.getStrandedContractCosts());
		ps.setString(43, billing_Bills.getNPCStrandedDebt());
		ps.setString(44, billing_Bills.getFeedInTariffAllowance());
		ps.setString(45, billing_Bills.getMissionaryElectrificationREDCI());
		ps.setString(46, billing_Bills.getGenerationVAT());
		ps.setString(47, billing_Bills.getTransmissionVAT());
		ps.setString(48, billing_Bills.getSystemLossVAT());
		ps.setString(49, billing_Bills.getDistributionVAT());
		ps.setString(50, billing_Bills.getRealPropertyTax());
		ps.setString(51, billing_Bills.getNotes());
		ps.setString(52, billing_Bills.getUserId());
		ps.setString(53, billing_Bills.getBilledFrom());
		ps.setString(54, billing_Bills.getcreated_at());
		ps.setString(55, billing_Bills.getupdated_at());
		ps.setString(56, billing_Bills.getAveragedCount());
		ps.setString(57, billing_Bills.getMergedToCollectible());
		ps.setString(58, billing_Bills.getOtherGenerationRateAdjustment());
		ps.setString(59, billing_Bills.getOtherTransmissionCostAdjustmentKW());
		ps.setString(60, billing_Bills.getOtherTransmissionCostAdjustmentKWH());
		ps.setString(61, billing_Bills.getOtherSystemLossCostAdjustment());
		ps.setString(62, billing_Bills.getOtherLifelineRateCostAdjustment());
		ps.setString(63, billing_Bills.getSeniorCitizenDiscountAndSubsidyAdjustment());
		ps.setString(64, billing_Bills.getFranchiseTax());
		ps.setString(65, billing_Bills.getBusinessTax());
		ps.setString(66, billing_Bills.getAdjustmentType());
		ps.setString(67, billing_Bills.getForm2307Amount());
		ps.setString(68, billing_Bills.getDeductedDeposit());
		ps.setString(69, billing_Bills.getExcessDeposit());
		ps.setString(70, billing_Bills.getIsUnlockedForPayment());
		ps.setString(71, billing_Bills.getUnlockedBy());
		ps.setString(72, billing_Bills.getEvat2Percent());
		ps.setString(73, billing_Bills.getEvat5Percent());
		ps.setString(74, billing_Bills.getAdjustmentNumber());
		ps.setString(75, billing_Bills.getAdjustedBy());
		ps.setString(76, billing_Bills.getDateAdjusted());
		ps.setString(77, billing_Bills.getForCancellation());
		ps.setString(78, billing_Bills.getCancelRequestedBy());
		ps.setString(79, billing_Bills.getCancelApprovedBy());
		ps.setString(80, billing_Bills.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Billing_Bills getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Bills WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Billing_Bills billing_Bills = new Billing_Bills(
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
			rs.getString("Notes"),
			rs.getString("UserId"),
			rs.getString("BilledFrom"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("AveragedCount"),
			rs.getString("MergedToCollectible"),
			rs.getString("OtherGenerationRateAdjustment"),
			rs.getString("OtherTransmissionCostAdjustmentKW"),
			rs.getString("OtherTransmissionCostAdjustmentKWH"),
			rs.getString("OtherSystemLossCostAdjustment"),
			rs.getString("OtherLifelineRateCostAdjustment"),
			rs.getString("SeniorCitizenDiscountAndSubsidyAdjustment"),
			rs.getString("FranchiseTax"),
			rs.getString("BusinessTax"),
			rs.getString("AdjustmentType"),
			rs.getString("Form2307Amount"),
			rs.getString("DeductedDeposit"),
			rs.getString("ExcessDeposit"),
			rs.getString("IsUnlockedForPayment"),
			rs.getString("UnlockedBy"),
			rs.getString("Evat2Percent"),
			rs.getString("Evat5Percent"),
			rs.getString("AdjustmentNumber"),
			rs.getString("AdjustedBy"),
			rs.getString("DateAdjusted"),
			rs.getString("ForCancellation"),
			rs.getString("CancelRequestedBy"),
			rs.getString("CancelApprovedBy")
			);
			ps.close();
			rs.close();
			return billing_Bills;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Billing_Bills> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Bills WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Billing_Bills> billing_BillsList = new ArrayList<>();
		while(rs.next()) {
			Billing_Bills billing_Bills = new Billing_Bills();
			billing_Bills.setid(rs.getString("id"));
			billing_Bills.setBillNumber(rs.getString("BillNumber"));
			billing_Bills.setAccountNumber(rs.getString("AccountNumber"));
			billing_Bills.setServicePeriod(rs.getString("ServicePeriod"));
			billing_Bills.setMultiplier(rs.getString("Multiplier"));
			billing_Bills.setCoreloss(rs.getString("Coreloss"));
			billing_Bills.setKwhUsed(rs.getString("KwhUsed"));
			billing_Bills.setPreviousKwh(rs.getString("PreviousKwh"));
			billing_Bills.setPresentKwh(rs.getString("PresentKwh"));
			billing_Bills.setDemandPreviousKwh(rs.getString("DemandPreviousKwh"));
			billing_Bills.setDemandPresentKwh(rs.getString("DemandPresentKwh"));
			billing_Bills.setAdditionalKwh(rs.getString("AdditionalKwh"));
			billing_Bills.setAdditionalDemandKwh(rs.getString("AdditionalDemandKwh"));
			billing_Bills.setKwhAmount(rs.getString("KwhAmount"));
			billing_Bills.setEffectiveRate(rs.getString("EffectiveRate"));
			billing_Bills.setAdditionalCharges(rs.getString("AdditionalCharges"));
			billing_Bills.setDeductions(rs.getString("Deductions"));
			billing_Bills.setNetAmount(rs.getString("NetAmount"));
			billing_Bills.setBillingDate(rs.getString("BillingDate"));
			billing_Bills.setServiceDateFrom(rs.getString("ServiceDateFrom"));
			billing_Bills.setServiceDateTo(rs.getString("ServiceDateTo"));
			billing_Bills.setDueDate(rs.getString("DueDate"));
			billing_Bills.setMeterNumber(rs.getString("MeterNumber"));
			billing_Bills.setConsumerType(rs.getString("ConsumerType"));
			billing_Bills.setBillType(rs.getString("BillType"));
			billing_Bills.setGenerationSystemCharge(rs.getString("GenerationSystemCharge"));
			billing_Bills.setTransmissionDeliveryChargeKW(rs.getString("TransmissionDeliveryChargeKW"));
			billing_Bills.setTransmissionDeliveryChargeKWH(rs.getString("TransmissionDeliveryChargeKWH"));
			billing_Bills.setSystemLossCharge(rs.getString("SystemLossCharge"));
			billing_Bills.setDistributionDemandCharge(rs.getString("DistributionDemandCharge"));
			billing_Bills.setDistributionSystemCharge(rs.getString("DistributionSystemCharge"));
			billing_Bills.setSupplyRetailCustomerCharge(rs.getString("SupplyRetailCustomerCharge"));
			billing_Bills.setSupplySystemCharge(rs.getString("SupplySystemCharge"));
			billing_Bills.setMeteringRetailCustomerCharge(rs.getString("MeteringRetailCustomerCharge"));
			billing_Bills.setMeteringSystemCharge(rs.getString("MeteringSystemCharge"));
			billing_Bills.setRFSC(rs.getString("RFSC"));
			billing_Bills.setLifelineRate(rs.getString("LifelineRate"));
			billing_Bills.setInterClassCrossSubsidyCharge(rs.getString("InterClassCrossSubsidyCharge"));
			billing_Bills.setPPARefund(rs.getString("PPARefund"));
			billing_Bills.setSeniorCitizenSubsidy(rs.getString("SeniorCitizenSubsidy"));
			billing_Bills.setMissionaryElectrificationCharge(rs.getString("MissionaryElectrificationCharge"));
			billing_Bills.setEnvironmentalCharge(rs.getString("EnvironmentalCharge"));
			billing_Bills.setStrandedContractCosts(rs.getString("StrandedContractCosts"));
			billing_Bills.setNPCStrandedDebt(rs.getString("NPCStrandedDebt"));
			billing_Bills.setFeedInTariffAllowance(rs.getString("FeedInTariffAllowance"));
			billing_Bills.setMissionaryElectrificationREDCI(rs.getString("MissionaryElectrificationREDCI"));
			billing_Bills.setGenerationVAT(rs.getString("GenerationVAT"));
			billing_Bills.setTransmissionVAT(rs.getString("TransmissionVAT"));
			billing_Bills.setSystemLossVAT(rs.getString("SystemLossVAT"));
			billing_Bills.setDistributionVAT(rs.getString("DistributionVAT"));
			billing_Bills.setRealPropertyTax(rs.getString("RealPropertyTax"));
			billing_Bills.setNotes(rs.getString("Notes"));
			billing_Bills.setUserId(rs.getString("UserId"));
			billing_Bills.setBilledFrom(rs.getString("BilledFrom"));
			billing_Bills.setcreated_at(rs.getString("created_at"));
			billing_Bills.setupdated_at(rs.getString("updated_at"));
			billing_Bills.setAveragedCount(rs.getString("AveragedCount"));
			billing_Bills.setMergedToCollectible(rs.getString("MergedToCollectible"));
			billing_Bills.setOtherGenerationRateAdjustment(rs.getString("OtherGenerationRateAdjustment"));
			billing_Bills.setOtherTransmissionCostAdjustmentKW(rs.getString("OtherTransmissionCostAdjustmentKW"));
			billing_Bills.setOtherTransmissionCostAdjustmentKWH(rs.getString("OtherTransmissionCostAdjustmentKWH"));
			billing_Bills.setOtherSystemLossCostAdjustment(rs.getString("OtherSystemLossCostAdjustment"));
			billing_Bills.setOtherLifelineRateCostAdjustment(rs.getString("OtherLifelineRateCostAdjustment"));
			billing_Bills.setSeniorCitizenDiscountAndSubsidyAdjustment(rs.getString("SeniorCitizenDiscountAndSubsidyAdjustment"));
			billing_Bills.setFranchiseTax(rs.getString("FranchiseTax"));
			billing_Bills.setBusinessTax(rs.getString("BusinessTax"));
			billing_Bills.setAdjustmentType(rs.getString("AdjustmentType"));
			billing_Bills.setForm2307Amount(rs.getString("Form2307Amount"));
			billing_Bills.setDeductedDeposit(rs.getString("DeductedDeposit"));
			billing_Bills.setExcessDeposit(rs.getString("ExcessDeposit"));
			billing_Bills.setIsUnlockedForPayment(rs.getString("IsUnlockedForPayment"));
			billing_Bills.setUnlockedBy(rs.getString("UnlockedBy"));
			billing_Bills.setEvat2Percent(rs.getString("Evat2Percent"));
			billing_Bills.setEvat5Percent(rs.getString("Evat5Percent"));
			billing_Bills.setAdjustmentNumber(rs.getString("AdjustmentNumber"));
			billing_Bills.setAdjustedBy(rs.getString("AdjustedBy"));
			billing_Bills.setDateAdjusted(rs.getString("DateAdjusted"));
			billing_Bills.setForCancellation(rs.getString("ForCancellation"));
			billing_Bills.setCancelRequestedBy(rs.getString("CancelRequestedBy"));
			billing_Bills.setCancelApprovedBy(rs.getString("CancelApprovedBy"));
			billing_BillsList.add(billing_Bills);
		}
		rs.close();
		ps.close();
		return billing_BillsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Billing_Bills> billing_Billses = Billing_BillsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Billing_Bills to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Billing_Bills bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Billing_Bills bill = Billing_BillsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Billing_Bills has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Billing_BillsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Billing_Bills updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Billing_BillsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Billing_Bills inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(70);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
