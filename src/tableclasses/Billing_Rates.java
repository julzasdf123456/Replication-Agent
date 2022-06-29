package tableclasses;

public class Billing_Rates { 
	public String id;
	public String RateFor;
	public String ConsumerType;
	public String ServicePeriod;
	public String Notes;
	public String GenerationSystemCharge;
	public String TransmissionDeliveryChargeKW;
	public String TransmissionDeliveryChargeKWH;
	public String SystemLossCharge;
	public String DistributionDemandCharge;
	public String DistributionSystemCharge;
	public String SupplyRetailCustomerCharge;
	public String SupplySystemCharge;
	public String MeteringRetailCustomerCharge;
	public String MeteringSystemCharge;
	public String RFSC;
	public String LifelineRate;
	public String InterClassCrossSubsidyCharge;
	public String PPARefund;
	public String SeniorCitizenSubsidy;
	public String MissionaryElectrificationCharge;
	public String EnvironmentalCharge;
	public String StrandedContractCosts;
	public String NPCStrandedDebt;
	public String FeedInTariffAllowance;
	public String MissionaryElectrificationREDCI;
	public String GenerationVAT;
	public String TransmissionVAT;
	public String SystemLossVAT;
	public String DistributionVAT;
	public String TotalRateVATExcluded;
	public String TotalRateVATIncluded;
	public String UserId;
	public String created_at;
	public String updated_at;
	public String RealPropertyTax;
	public String AreaCode;
	public String OtherGenerationRateAdjustment;
	public String OtherTransmissionCostAdjustmentKW;
	public String OtherTransmissionCostAdjustmentKWH;
	public String OtherSystemLossCostAdjustment;
	public String OtherLifelineRateCostAdjustment;
	public String SeniorCitizenDiscountAndSubsidyAdjustment;
	public String FranchiseTax;
	public String BusinessTax;
	public String TotalRateVATExcludedWithAdjustments;
	public Billing_Rates() {
	} 
	public Billing_Rates(String id, String RateFor, String ConsumerType, String ServicePeriod, String Notes, String GenerationSystemCharge, String TransmissionDeliveryChargeKW, String TransmissionDeliveryChargeKWH, String SystemLossCharge, String DistributionDemandCharge, String DistributionSystemCharge, String SupplyRetailCustomerCharge, String SupplySystemCharge, String MeteringRetailCustomerCharge, String MeteringSystemCharge, String RFSC, String LifelineRate, String InterClassCrossSubsidyCharge, String PPARefund, String SeniorCitizenSubsidy, String MissionaryElectrificationCharge, String EnvironmentalCharge, String StrandedContractCosts, String NPCStrandedDebt, String FeedInTariffAllowance, String MissionaryElectrificationREDCI, String GenerationVAT, String TransmissionVAT, String SystemLossVAT, String DistributionVAT, String TotalRateVATExcluded, String TotalRateVATIncluded, String UserId, String created_at, String updated_at, String RealPropertyTax, String AreaCode, String OtherGenerationRateAdjustment, String OtherTransmissionCostAdjustmentKW, String OtherTransmissionCostAdjustmentKWH, String OtherSystemLossCostAdjustment, String OtherLifelineRateCostAdjustment, String SeniorCitizenDiscountAndSubsidyAdjustment, String FranchiseTax, String BusinessTax, String TotalRateVATExcludedWithAdjustments) {
		this.id = id;
		this.RateFor = RateFor;
		this.ConsumerType = ConsumerType;
		this.ServicePeriod = ServicePeriod;
		this.Notes = Notes;
		this.GenerationSystemCharge = GenerationSystemCharge;
		this.TransmissionDeliveryChargeKW = TransmissionDeliveryChargeKW;
		this.TransmissionDeliveryChargeKWH = TransmissionDeliveryChargeKWH;
		this.SystemLossCharge = SystemLossCharge;
		this.DistributionDemandCharge = DistributionDemandCharge;
		this.DistributionSystemCharge = DistributionSystemCharge;
		this.SupplyRetailCustomerCharge = SupplyRetailCustomerCharge;
		this.SupplySystemCharge = SupplySystemCharge;
		this.MeteringRetailCustomerCharge = MeteringRetailCustomerCharge;
		this.MeteringSystemCharge = MeteringSystemCharge;
		this.RFSC = RFSC;
		this.LifelineRate = LifelineRate;
		this.InterClassCrossSubsidyCharge = InterClassCrossSubsidyCharge;
		this.PPARefund = PPARefund;
		this.SeniorCitizenSubsidy = SeniorCitizenSubsidy;
		this.MissionaryElectrificationCharge = MissionaryElectrificationCharge;
		this.EnvironmentalCharge = EnvironmentalCharge;
		this.StrandedContractCosts = StrandedContractCosts;
		this.NPCStrandedDebt = NPCStrandedDebt;
		this.FeedInTariffAllowance = FeedInTariffAllowance;
		this.MissionaryElectrificationREDCI = MissionaryElectrificationREDCI;
		this.GenerationVAT = GenerationVAT;
		this.TransmissionVAT = TransmissionVAT;
		this.SystemLossVAT = SystemLossVAT;
		this.DistributionVAT = DistributionVAT;
		this.TotalRateVATExcluded = TotalRateVATExcluded;
		this.TotalRateVATIncluded = TotalRateVATIncluded;
		this.UserId = UserId;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.RealPropertyTax = RealPropertyTax;
		this.AreaCode = AreaCode;
		this.OtherGenerationRateAdjustment = OtherGenerationRateAdjustment;
		this.OtherTransmissionCostAdjustmentKW = OtherTransmissionCostAdjustmentKW;
		this.OtherTransmissionCostAdjustmentKWH = OtherTransmissionCostAdjustmentKWH;
		this.OtherSystemLossCostAdjustment = OtherSystemLossCostAdjustment;
		this.OtherLifelineRateCostAdjustment = OtherLifelineRateCostAdjustment;
		this.SeniorCitizenDiscountAndSubsidyAdjustment = SeniorCitizenDiscountAndSubsidyAdjustment;
		this.FranchiseTax = FranchiseTax;
		this.BusinessTax = BusinessTax;
		this.TotalRateVATExcludedWithAdjustments = TotalRateVATExcludedWithAdjustments;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setRateFor(String RateFor) {
		this.RateFor = RateFor;
	} 

	public String getRateFor() {
		return RateFor;
	} 

	public void setConsumerType(String ConsumerType) {
		this.ConsumerType = ConsumerType;
	} 

	public String getConsumerType() {
		return ConsumerType;
	} 

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setNotes(String Notes) {
		this.Notes = Notes;
	} 

	public String getNotes() {
		return Notes;
	} 

	public void setGenerationSystemCharge(String GenerationSystemCharge) {
		this.GenerationSystemCharge = GenerationSystemCharge;
	} 

	public String getGenerationSystemCharge() {
		return GenerationSystemCharge;
	} 

	public void setTransmissionDeliveryChargeKW(String TransmissionDeliveryChargeKW) {
		this.TransmissionDeliveryChargeKW = TransmissionDeliveryChargeKW;
	} 

	public String getTransmissionDeliveryChargeKW() {
		return TransmissionDeliveryChargeKW;
	} 

	public void setTransmissionDeliveryChargeKWH(String TransmissionDeliveryChargeKWH) {
		this.TransmissionDeliveryChargeKWH = TransmissionDeliveryChargeKWH;
	} 

	public String getTransmissionDeliveryChargeKWH() {
		return TransmissionDeliveryChargeKWH;
	} 

	public void setSystemLossCharge(String SystemLossCharge) {
		this.SystemLossCharge = SystemLossCharge;
	} 

	public String getSystemLossCharge() {
		return SystemLossCharge;
	} 

	public void setDistributionDemandCharge(String DistributionDemandCharge) {
		this.DistributionDemandCharge = DistributionDemandCharge;
	} 

	public String getDistributionDemandCharge() {
		return DistributionDemandCharge;
	} 

	public void setDistributionSystemCharge(String DistributionSystemCharge) {
		this.DistributionSystemCharge = DistributionSystemCharge;
	} 

	public String getDistributionSystemCharge() {
		return DistributionSystemCharge;
	} 

	public void setSupplyRetailCustomerCharge(String SupplyRetailCustomerCharge) {
		this.SupplyRetailCustomerCharge = SupplyRetailCustomerCharge;
	} 

	public String getSupplyRetailCustomerCharge() {
		return SupplyRetailCustomerCharge;
	} 

	public void setSupplySystemCharge(String SupplySystemCharge) {
		this.SupplySystemCharge = SupplySystemCharge;
	} 

	public String getSupplySystemCharge() {
		return SupplySystemCharge;
	} 

	public void setMeteringRetailCustomerCharge(String MeteringRetailCustomerCharge) {
		this.MeteringRetailCustomerCharge = MeteringRetailCustomerCharge;
	} 

	public String getMeteringRetailCustomerCharge() {
		return MeteringRetailCustomerCharge;
	} 

	public void setMeteringSystemCharge(String MeteringSystemCharge) {
		this.MeteringSystemCharge = MeteringSystemCharge;
	} 

	public String getMeteringSystemCharge() {
		return MeteringSystemCharge;
	} 

	public void setRFSC(String RFSC) {
		this.RFSC = RFSC;
	} 

	public String getRFSC() {
		return RFSC;
	} 

	public void setLifelineRate(String LifelineRate) {
		this.LifelineRate = LifelineRate;
	} 

	public String getLifelineRate() {
		return LifelineRate;
	} 

	public void setInterClassCrossSubsidyCharge(String InterClassCrossSubsidyCharge) {
		this.InterClassCrossSubsidyCharge = InterClassCrossSubsidyCharge;
	} 

	public String getInterClassCrossSubsidyCharge() {
		return InterClassCrossSubsidyCharge;
	} 

	public void setPPARefund(String PPARefund) {
		this.PPARefund = PPARefund;
	} 

	public String getPPARefund() {
		return PPARefund;
	} 

	public void setSeniorCitizenSubsidy(String SeniorCitizenSubsidy) {
		this.SeniorCitizenSubsidy = SeniorCitizenSubsidy;
	} 

	public String getSeniorCitizenSubsidy() {
		return SeniorCitizenSubsidy;
	} 

	public void setMissionaryElectrificationCharge(String MissionaryElectrificationCharge) {
		this.MissionaryElectrificationCharge = MissionaryElectrificationCharge;
	} 

	public String getMissionaryElectrificationCharge() {
		return MissionaryElectrificationCharge;
	} 

	public void setEnvironmentalCharge(String EnvironmentalCharge) {
		this.EnvironmentalCharge = EnvironmentalCharge;
	} 

	public String getEnvironmentalCharge() {
		return EnvironmentalCharge;
	} 

	public void setStrandedContractCosts(String StrandedContractCosts) {
		this.StrandedContractCosts = StrandedContractCosts;
	} 

	public String getStrandedContractCosts() {
		return StrandedContractCosts;
	} 

	public void setNPCStrandedDebt(String NPCStrandedDebt) {
		this.NPCStrandedDebt = NPCStrandedDebt;
	} 

	public String getNPCStrandedDebt() {
		return NPCStrandedDebt;
	} 

	public void setFeedInTariffAllowance(String FeedInTariffAllowance) {
		this.FeedInTariffAllowance = FeedInTariffAllowance;
	} 

	public String getFeedInTariffAllowance() {
		return FeedInTariffAllowance;
	} 

	public void setMissionaryElectrificationREDCI(String MissionaryElectrificationREDCI) {
		this.MissionaryElectrificationREDCI = MissionaryElectrificationREDCI;
	} 

	public String getMissionaryElectrificationREDCI() {
		return MissionaryElectrificationREDCI;
	} 

	public void setGenerationVAT(String GenerationVAT) {
		this.GenerationVAT = GenerationVAT;
	} 

	public String getGenerationVAT() {
		return GenerationVAT;
	} 

	public void setTransmissionVAT(String TransmissionVAT) {
		this.TransmissionVAT = TransmissionVAT;
	} 

	public String getTransmissionVAT() {
		return TransmissionVAT;
	} 

	public void setSystemLossVAT(String SystemLossVAT) {
		this.SystemLossVAT = SystemLossVAT;
	} 

	public String getSystemLossVAT() {
		return SystemLossVAT;
	} 

	public void setDistributionVAT(String DistributionVAT) {
		this.DistributionVAT = DistributionVAT;
	} 

	public String getDistributionVAT() {
		return DistributionVAT;
	} 

	public void setTotalRateVATExcluded(String TotalRateVATExcluded) {
		this.TotalRateVATExcluded = TotalRateVATExcluded;
	} 

	public String getTotalRateVATExcluded() {
		return TotalRateVATExcluded;
	} 

	public void setTotalRateVATIncluded(String TotalRateVATIncluded) {
		this.TotalRateVATIncluded = TotalRateVATIncluded;
	} 

	public String getTotalRateVATIncluded() {
		return TotalRateVATIncluded;
	} 

	public void setUserId(String UserId) {
		this.UserId = UserId;
	} 

	public String getUserId() {
		return UserId;
	} 

	public void setcreated_at(String created_at) {
		this.created_at = created_at;
	} 

	public String getcreated_at() {
		return created_at;
	} 

	public void setupdated_at(String updated_at) {
		this.updated_at = updated_at;
	} 

	public String getupdated_at() {
		return updated_at;
	} 

	public void setRealPropertyTax(String RealPropertyTax) {
		this.RealPropertyTax = RealPropertyTax;
	} 

	public String getRealPropertyTax() {
		return RealPropertyTax;
	} 

	public void setAreaCode(String AreaCode) {
		this.AreaCode = AreaCode;
	} 

	public String getAreaCode() {
		return AreaCode;
	} 

	public void setOtherGenerationRateAdjustment(String OtherGenerationRateAdjustment) {
		this.OtherGenerationRateAdjustment = OtherGenerationRateAdjustment;
	} 

	public String getOtherGenerationRateAdjustment() {
		return OtherGenerationRateAdjustment;
	} 

	public void setOtherTransmissionCostAdjustmentKW(String OtherTransmissionCostAdjustmentKW) {
		this.OtherTransmissionCostAdjustmentKW = OtherTransmissionCostAdjustmentKW;
	} 

	public String getOtherTransmissionCostAdjustmentKW() {
		return OtherTransmissionCostAdjustmentKW;
	} 

	public void setOtherTransmissionCostAdjustmentKWH(String OtherTransmissionCostAdjustmentKWH) {
		this.OtherTransmissionCostAdjustmentKWH = OtherTransmissionCostAdjustmentKWH;
	} 

	public String getOtherTransmissionCostAdjustmentKWH() {
		return OtherTransmissionCostAdjustmentKWH;
	} 

	public void setOtherSystemLossCostAdjustment(String OtherSystemLossCostAdjustment) {
		this.OtherSystemLossCostAdjustment = OtherSystemLossCostAdjustment;
	} 

	public String getOtherSystemLossCostAdjustment() {
		return OtherSystemLossCostAdjustment;
	} 

	public void setOtherLifelineRateCostAdjustment(String OtherLifelineRateCostAdjustment) {
		this.OtherLifelineRateCostAdjustment = OtherLifelineRateCostAdjustment;
	} 

	public String getOtherLifelineRateCostAdjustment() {
		return OtherLifelineRateCostAdjustment;
	} 

	public void setSeniorCitizenDiscountAndSubsidyAdjustment(String SeniorCitizenDiscountAndSubsidyAdjustment) {
		this.SeniorCitizenDiscountAndSubsidyAdjustment = SeniorCitizenDiscountAndSubsidyAdjustment;
	} 

	public String getSeniorCitizenDiscountAndSubsidyAdjustment() {
		return SeniorCitizenDiscountAndSubsidyAdjustment;
	} 

	public void setFranchiseTax(String FranchiseTax) {
		this.FranchiseTax = FranchiseTax;
	} 

	public String getFranchiseTax() {
		return FranchiseTax;
	} 

	public void setBusinessTax(String BusinessTax) {
		this.BusinessTax = BusinessTax;
	} 

	public String getBusinessTax() {
		return BusinessTax;
	} 

	public void setTotalRateVATExcludedWithAdjustments(String TotalRateVATExcludedWithAdjustments) {
		this.TotalRateVATExcludedWithAdjustments = TotalRateVATExcludedWithAdjustments;
	} 

	public String getTotalRateVATExcludedWithAdjustments() {
		return TotalRateVATExcludedWithAdjustments;
	} 

} 
