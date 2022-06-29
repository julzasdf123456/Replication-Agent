package tableclasses;

public class Cashier_BAPAPayments { 
	public String id;
	public String BAPAName;
	public String ServicePeriod;
	public String ORNumber;
	public String ORDate;
	public String SubTotal;
	public String TwoPercentDiscount;
	public String FivePercentDiscount;
	public String AdditionalCharges;
	public String Deductions;
	public String VAT;
	public String Total;
	public String Teller;
	public String NoOfConsumersPaid;
	public String Status;
	public String Notes;
	public String created_at;
	public String updated_at;
	public Cashier_BAPAPayments() {
	} 
	public Cashier_BAPAPayments(String id, String BAPAName, String ServicePeriod, String ORNumber, String ORDate, String SubTotal, String TwoPercentDiscount, String FivePercentDiscount, String AdditionalCharges, String Deductions, String VAT, String Total, String Teller, String NoOfConsumersPaid, String Status, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.BAPAName = BAPAName;
		this.ServicePeriod = ServicePeriod;
		this.ORNumber = ORNumber;
		this.ORDate = ORDate;
		this.SubTotal = SubTotal;
		this.TwoPercentDiscount = TwoPercentDiscount;
		this.FivePercentDiscount = FivePercentDiscount;
		this.AdditionalCharges = AdditionalCharges;
		this.Deductions = Deductions;
		this.VAT = VAT;
		this.Total = Total;
		this.Teller = Teller;
		this.NoOfConsumersPaid = NoOfConsumersPaid;
		this.Status = Status;
		this.Notes = Notes;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setBAPAName(String BAPAName) {
		this.BAPAName = BAPAName;
	} 

	public String getBAPAName() {
		return BAPAName;
	} 

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setORNumber(String ORNumber) {
		this.ORNumber = ORNumber;
	} 

	public String getORNumber() {
		return ORNumber;
	} 

	public void setORDate(String ORDate) {
		this.ORDate = ORDate;
	} 

	public String getORDate() {
		return ORDate;
	} 

	public void setSubTotal(String SubTotal) {
		this.SubTotal = SubTotal;
	} 

	public String getSubTotal() {
		return SubTotal;
	} 

	public void setTwoPercentDiscount(String TwoPercentDiscount) {
		this.TwoPercentDiscount = TwoPercentDiscount;
	} 

	public String getTwoPercentDiscount() {
		return TwoPercentDiscount;
	} 

	public void setFivePercentDiscount(String FivePercentDiscount) {
		this.FivePercentDiscount = FivePercentDiscount;
	} 

	public String getFivePercentDiscount() {
		return FivePercentDiscount;
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

	public void setVAT(String VAT) {
		this.VAT = VAT;
	} 

	public String getVAT() {
		return VAT;
	} 

	public void setTotal(String Total) {
		this.Total = Total;
	} 

	public String getTotal() {
		return Total;
	} 

	public void setTeller(String Teller) {
		this.Teller = Teller;
	} 

	public String getTeller() {
		return Teller;
	} 

	public void setNoOfConsumersPaid(String NoOfConsumersPaid) {
		this.NoOfConsumersPaid = NoOfConsumersPaid;
	} 

	public String getNoOfConsumersPaid() {
		return NoOfConsumersPaid;
	} 

	public void setStatus(String Status) {
		this.Status = Status;
	} 

	public String getStatus() {
		return Status;
	} 

	public void setNotes(String Notes) {
		this.Notes = Notes;
	} 

	public String getNotes() {
		return Notes;
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

} 
