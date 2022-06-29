package tableclasses;

public class Billing_Bills { 
	public String id;
	public String BillNumber;
	public String AccountNumber;
	public String ServicePeriod;
	public String Multiplier;
	public String Coreloss;
	public String KwhUsed;
	public String PreviousKwh;
	public String PresentKwh;
	public String DemandPreviousKwh;
	public String DemandPresentKwh;
	public String AdditionalKwh;
	public String AdditionalDemandKwh;
	public String KwhAmount;
	public String EffectiveRate;
	public String AdditionalCharges;
	public String Deductions;
	public String NetAmount;
	public String BillingDate;
	public String ServiceDateFrom;
	public String ServiceDateTo;
	public String DueDate;
	public String MeterNumber;
	public String ConsumerType;
	public String BillType;
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
	public String RealPropertyTax;
	public String Notes;
	public String UserId;
	public String BilledFrom;
	public String created_at;
	public String updated_at;
	public String AveragedCount;
	public String MergedToCollectible;
	public String OtherGenerationRateAdjustment;
	public String OtherTransmissionCostAdjustmentKW;
	public String OtherTransmissionCostAdjustmentKWH;
	public String OtherSystemLossCostAdjustment;
	public String OtherLifelineRateCostAdjustment;
	public String SeniorCitizenDiscountAndSubsidyAdjustment;
	public String FranchiseTax;
	public String BusinessTax;
	public String AdjustmentType;
	public String Form2307Amount;
	public String DeductedDeposit;
	public String ExcessDeposit;
	public String IsUnlockedForPayment;
	public String UnlockedBy;
	public String Evat2Percent;
	public String Evat5Percent;
	public String AdjustmentNumber;
	public String AdjustedBy;
	public String DateAdjusted;
	public String ForCancellation;
	public String CancelRequestedBy;
	public String CancelApprovedBy;
	public Billing_Bills() {
	} 
	public Billing_Bills(String id, String BillNumber, String AccountNumber, String ServicePeriod, String Multiplier, String Coreloss, String KwhUsed, String PreviousKwh, String PresentKwh, String DemandPreviousKwh, String DemandPresentKwh, String AdditionalKwh, String AdditionalDemandKwh, String KwhAmount, String EffectiveRate, String AdditionalCharges, String Deductions, String NetAmount, String BillingDate, String ServiceDateFrom, String ServiceDateTo, String DueDate, String MeterNumber, String ConsumerType, String BillType, String GenerationSystemCharge, String TransmissionDeliveryChargeKW, String TransmissionDeliveryChargeKWH, String SystemLossCharge, String DistributionDemandCharge, String DistributionSystemCharge, String SupplyRetailCustomerCharge, String SupplySystemCharge, String MeteringRetailCustomerCharge, String MeteringSystemCharge, String RFSC, String LifelineRate, String InterClassCrossSubsidyCharge, String PPARefund, String SeniorCitizenSubsidy, String MissionaryElectrificationCharge, String EnvironmentalCharge, String StrandedContractCosts, String NPCStrandedDebt, String FeedInTariffAllowance, String MissionaryElectrificationREDCI, String GenerationVAT, String TransmissionVAT, String SystemLossVAT, String DistributionVAT, String RealPropertyTax, String Notes, String UserId, String BilledFrom, String created_at, String updated_at, String AveragedCount, String MergedToCollectible, String OtherGenerationRateAdjustment, String OtherTransmissionCostAdjustmentKW, String OtherTransmissionCostAdjustmentKWH, String OtherSystemLossCostAdjustment, String OtherLifelineRateCostAdjustment, String SeniorCitizenDiscountAndSubsidyAdjustment, String FranchiseTax, String BusinessTax, String AdjustmentType, String Form2307Amount, String DeductedDeposit, String ExcessDeposit, String IsUnlockedForPayment, String UnlockedBy, String Evat2Percent, String Evat5Percent, String AdjustmentNumber, String AdjustedBy, String DateAdjusted, String ForCancellation, String CancelRequestedBy, String CancelApprovedBy) {
		this.id = id;
		this.BillNumber = BillNumber;
		this.AccountNumber = AccountNumber;
		this.ServicePeriod = ServicePeriod;
		this.Multiplier = Multiplier;
		this.Coreloss = Coreloss;
		this.KwhUsed = KwhUsed;
		this.PreviousKwh = PreviousKwh;
		this.PresentKwh = PresentKwh;
		this.DemandPreviousKwh = DemandPreviousKwh;
		this.DemandPresentKwh = DemandPresentKwh;
		this.AdditionalKwh = AdditionalKwh;
		this.AdditionalDemandKwh = AdditionalDemandKwh;
		this.KwhAmount = KwhAmount;
		this.EffectiveRate = EffectiveRate;
		this.AdditionalCharges = AdditionalCharges;
		this.Deductions = Deductions;
		this.NetAmount = NetAmount;
		this.BillingDate = BillingDate;
		this.ServiceDateFrom = ServiceDateFrom;
		this.ServiceDateTo = ServiceDateTo;
		this.DueDate = DueDate;
		this.MeterNumber = MeterNumber;
		this.ConsumerType = ConsumerType;
		this.BillType = BillType;
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
		this.RealPropertyTax = RealPropertyTax;
		this.Notes = Notes;
		this.UserId = UserId;
		this.BilledFrom = BilledFrom;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.AveragedCount = AveragedCount;
		this.MergedToCollectible = MergedToCollectible;
		this.OtherGenerationRateAdjustment = OtherGenerationRateAdjustment;
		this.OtherTransmissionCostAdjustmentKW = OtherTransmissionCostAdjustmentKW;
		this.OtherTransmissionCostAdjustmentKWH = OtherTransmissionCostAdjustmentKWH;
		this.OtherSystemLossCostAdjustment = OtherSystemLossCostAdjustment;
		this.OtherLifelineRateCostAdjustment = OtherLifelineRateCostAdjustment;
		this.SeniorCitizenDiscountAndSubsidyAdjustment = SeniorCitizenDiscountAndSubsidyAdjustment;
		this.FranchiseTax = FranchiseTax;
		this.BusinessTax = BusinessTax;
		this.AdjustmentType = AdjustmentType;
		this.Form2307Amount = Form2307Amount;
		this.DeductedDeposit = DeductedDeposit;
		this.ExcessDeposit = ExcessDeposit;
		this.IsUnlockedForPayment = IsUnlockedForPayment;
		this.UnlockedBy = UnlockedBy;
		this.Evat2Percent = Evat2Percent;
		this.Evat5Percent = Evat5Percent;
		this.AdjustmentNumber = AdjustmentNumber;
		this.AdjustedBy = AdjustedBy;
		this.DateAdjusted = DateAdjusted;
		this.ForCancellation = ForCancellation;
		this.CancelRequestedBy = CancelRequestedBy;
		this.CancelApprovedBy = CancelApprovedBy;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setBillNumber(String BillNumber) {
		this.BillNumber = BillNumber;
	} 

	public String getBillNumber() {
		return BillNumber;
	} 

	public void setAccountNumber(String AccountNumber) {
		this.AccountNumber = AccountNumber;
	} 

	public String getAccountNumber() {
		return AccountNumber;
	} 

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setMultiplier(String Multiplier) {
		this.Multiplier = Multiplier;
	} 

	public String getMultiplier() {
		return Multiplier;
	} 

	public void setCoreloss(String Coreloss) {
		this.Coreloss = Coreloss;
	} 

	public String getCoreloss() {
		return Coreloss;
	} 

	public void setKwhUsed(String KwhUsed) {
		this.KwhUsed = KwhUsed;
	} 

	public String getKwhUsed() {
		return KwhUsed;
	} 

	public void setPreviousKwh(String PreviousKwh) {
		this.PreviousKwh = PreviousKwh;
	} 

	public String getPreviousKwh() {
		return PreviousKwh;
	} 

	public void setPresentKwh(String PresentKwh) {
		this.PresentKwh = PresentKwh;
	} 

	public String getPresentKwh() {
		return PresentKwh;
	} 

	public void setDemandPreviousKwh(String DemandPreviousKwh) {
		this.DemandPreviousKwh = DemandPreviousKwh;
	} 

	public String getDemandPreviousKwh() {
		return DemandPreviousKwh;
	} 

	public void setDemandPresentKwh(String DemandPresentKwh) {
		this.DemandPresentKwh = DemandPresentKwh;
	} 

	public String getDemandPresentKwh() {
		return DemandPresentKwh;
	} 

	public void setAdditionalKwh(String AdditionalKwh) {
		this.AdditionalKwh = AdditionalKwh;
	} 

	public String getAdditionalKwh() {
		return AdditionalKwh;
	} 

	public void setAdditionalDemandKwh(String AdditionalDemandKwh) {
		this.AdditionalDemandKwh = AdditionalDemandKwh;
	} 

	public String getAdditionalDemandKwh() {
		return AdditionalDemandKwh;
	} 

	public void setKwhAmount(String KwhAmount) {
		this.KwhAmount = KwhAmount;
	} 

	public String getKwhAmount() {
		return KwhAmount;
	} 

	public void setEffectiveRate(String EffectiveRate) {
		this.EffectiveRate = EffectiveRate;
	} 

	public String getEffectiveRate() {
		return EffectiveRate;
	} 

	public void setAdditionalCharges(String AdditionalCharges) {
		this.AdditionalCharges = AdditionalCharges;
	} 

	public String getAdditionalCharges() {
		return AdditionalCharges;
	} 

	public void setDeductions(String Deductions) {
		this.Deductions = Deductions;
	} 

	public String getDeductions() {
		return Deductions;
	} 

	public void setNetAmount(String NetAmount) {
		this.NetAmount = NetAmount;
	} 

	public String getNetAmount() {
		return NetAmount;
	} 

	public void setBillingDate(String BillingDate) {
		this.BillingDate = BillingDate;
	} 

	public String getBillingDate() {
		return BillingDate;
	} 

	public void setServiceDateFrom(String ServiceDateFrom) {
		this.ServiceDateFrom = ServiceDateFrom;
	} 

	public String getServiceDateFrom() {
		return ServiceDateFrom;
	} 

	public void setServiceDateTo(String ServiceDateTo) {
		this.ServiceDateTo = ServiceDateTo;
	} 

	public String getServiceDateTo() {
		return ServiceDateTo;
	} 

	public void setDueDate(String DueDate) {
		this.DueDate = DueDate;
	} 

	public String getDueDate() {
		return DueDate;
	} 

	public void setMeterNumber(String MeterNumber) {
		this.MeterNumber = MeterNumber;
	} 

	public String getMeterNumber() {
		return MeterNumber;
	} 

	public void setConsumerType(String ConsumerType) {
		this.ConsumerType = ConsumerType;
	} 

	public String getConsumerType() {
		return ConsumerType;
	} 

	public void setBillType(String BillType) {
		this.BillType = BillType;
	} 

	public String getBillType() {
		return BillType;
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

	public void setRealPropertyTax(String RealPropertyTax) {
		this.RealPropertyTax = RealPropertyTax;
	} 

	public String getRealPropertyTax() {
		return RealPropertyTax;
	} 

	public void setNotes(String Notes) {
		this.Notes = Notes;
	} 

	public String getNotes() {
		return Notes;
	} 

	public void setUserId(String UserId) {
		this.UserId = UserId;
	} 

	public String getUserId() {
		return UserId;
	} 

	public void setBilledFrom(String BilledFrom) {
		this.BilledFrom = BilledFrom;
	} 

	public String getBilledFrom() {
		return BilledFrom;
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

	public void setAveragedCount(String AveragedCount) {
		this.AveragedCount = AveragedCount;
	} 

	public String getAveragedCount() {
		return AveragedCount;
	} 

	public void setMergedToCollectible(String MergedToCollectible) {
		this.MergedToCollectible = MergedToCollectible;
	} 

	public String getMergedToCollectible() {
		return MergedToCollectible;
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

	public void setAdjustmentType(String AdjustmentType) {
		this.AdjustmentType = AdjustmentType;
	} 

	public String getAdjustmentType() {
		return AdjustmentType;
	} 

	public void setForm2307Amount(String Form2307Amount) {
		this.Form2307Amount = Form2307Amount;
	} 

	public String getForm2307Amount() {
		return Form2307Amount;
	} 

	public void setDeductedDeposit(String DeductedDeposit) {
		this.DeductedDeposit = DeductedDeposit;
	} 

	public String getDeductedDeposit() {
		return DeductedDeposit;
	} 

	public void setExcessDeposit(String ExcessDeposit) {
		this.ExcessDeposit = ExcessDeposit;
	} 

	public String getExcessDeposit() {
		return ExcessDeposit;
	} 

	public void setIsUnlockedForPayment(String IsUnlockedForPayment) {
		this.IsUnlockedForPayment = IsUnlockedForPayment;
	} 

	public String getIsUnlockedForPayment() {
		return IsUnlockedForPayment;
	} 

	public void setUnlockedBy(String UnlockedBy) {
		this.UnlockedBy = UnlockedBy;
	} 

	public String getUnlockedBy() {
		return UnlockedBy;
	} 

	public void setEvat2Percent(String Evat2Percent) {
		this.Evat2Percent = Evat2Percent;
	} 

	public String getEvat2Percent() {
		return Evat2Percent;
	} 

	public void setEvat5Percent(String Evat5Percent) {
		this.Evat5Percent = Evat5Percent;
	} 

	public String getEvat5Percent() {
		return Evat5Percent;
	} 

	public void setAdjustmentNumber(String AdjustmentNumber) {
		this.AdjustmentNumber = AdjustmentNumber;
	} 

	public String getAdjustmentNumber() {
		return AdjustmentNumber;
	} 

	public void setAdjustedBy(String AdjustedBy) {
		this.AdjustedBy = AdjustedBy;
	} 

	public String getAdjustedBy() {
		return AdjustedBy;
	} 

	public void setDateAdjusted(String DateAdjusted) {
		this.DateAdjusted = DateAdjusted;
	} 

	public String getDateAdjusted() {
		return DateAdjusted;
	} 

	public void setForCancellation(String ForCancellation) {
		this.ForCancellation = ForCancellation;
	} 

	public String getForCancellation() {
		return ForCancellation;
	} 

	public void setCancelRequestedBy(String CancelRequestedBy) {
		this.CancelRequestedBy = CancelRequestedBy;
	} 

	public String getCancelRequestedBy() {
		return CancelRequestedBy;
	} 

	public void setCancelApprovedBy(String CancelApprovedBy) {
		this.CancelApprovedBy = CancelApprovedBy;
	} 

	public String getCancelApprovedBy() {
		return CancelApprovedBy;
	} 

} 
