package tableclasses;

public class Cashier_PaidBillsDetails { 
	public String id;
	public String AccountNumber;
	public String ServicePeriod;
	public String BillId;
	public String ORNumber;
	public String Amount;
	public String PaymentUsed;
	public String CheckNo;
	public String Bank;
	public String CheckExpiration;
	public String UserId;
	public String created_at;
	public String updated_at;
	public Cashier_PaidBillsDetails() {
	} 
	public Cashier_PaidBillsDetails(String id, String AccountNumber, String ServicePeriod, String BillId, String ORNumber, String Amount, String PaymentUsed, String CheckNo, String Bank, String CheckExpiration, String UserId, String created_at, String updated_at) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.ServicePeriod = ServicePeriod;
		this.BillId = BillId;
		this.ORNumber = ORNumber;
		this.Amount = Amount;
		this.PaymentUsed = PaymentUsed;
		this.CheckNo = CheckNo;
		this.Bank = Bank;
		this.CheckExpiration = CheckExpiration;
		this.UserId = UserId;
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

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setBillId(String BillId) {
		this.BillId = BillId;
	} 

	public String getBillId() {
		return BillId;
	} 

	public void setORNumber(String ORNumber) {
		this.ORNumber = ORNumber;
	} 

	public String getORNumber() {
		return ORNumber;
	} 

	public void setAmount(String Amount) {
		this.Amount = Amount;
	} 

	public String getAmount() {
		return Amount;
	} 

	public void setPaymentUsed(String PaymentUsed) {
		this.PaymentUsed = PaymentUsed;
	} 

	public String getPaymentUsed() {
		return PaymentUsed;
	} 

	public void setCheckNo(String CheckNo) {
		this.CheckNo = CheckNo;
	} 

	public String getCheckNo() {
		return CheckNo;
	} 

	public void setBank(String Bank) {
		this.Bank = Bank;
	} 

	public String getBank() {
		return Bank;
	} 

	public void setCheckExpiration(String CheckExpiration) {
		this.CheckExpiration = CheckExpiration;
	} 

	public String getCheckExpiration() {
		return CheckExpiration;
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

} 
