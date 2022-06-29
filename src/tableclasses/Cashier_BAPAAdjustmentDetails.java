package tableclasses;

public class Cashier_BAPAAdjustmentDetails { 
	public String id;
	public String AccountNumber;
	public String BillId;
	public String DiscountPercentage;
	public String DiscountAmount;
	public String BAPAName;
	public String ServicePeriod;
	public String created_at;
	public String updated_at;
	public Cashier_BAPAAdjustmentDetails() {
	} 
	public Cashier_BAPAAdjustmentDetails(String id, String AccountNumber, String BillId, String DiscountPercentage, String DiscountAmount, String BAPAName, String ServicePeriod, String created_at, String updated_at) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.BillId = BillId;
		this.DiscountPercentage = DiscountPercentage;
		this.DiscountAmount = DiscountAmount;
		this.BAPAName = BAPAName;
		this.ServicePeriod = ServicePeriod;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setAccountNumber(String AccountNumber) {
		this.AccountNumber = AccountNumber;
	} 

	public String getAccountNumber() {
		return AccountNumber;
	} 

	public void setBillId(String BillId) {
		this.BillId = BillId;
	} 

	public String getBillId() {
		return BillId;
	} 

	public void setDiscountPercentage(String DiscountPercentage) {
		this.DiscountPercentage = DiscountPercentage;
	} 

	public String getDiscountPercentage() {
		return DiscountPercentage;
	} 

	public void setDiscountAmount(String DiscountAmount) {
		this.DiscountAmount = DiscountAmount;
	} 

	public String getDiscountAmount() {
		return DiscountAmount;
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
