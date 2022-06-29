package tableclasses;

public class Cashier_TransactionPaymentDetails { 
	public String id;
	public String TransactionIndexId;
	public String Amount;
	public String PaymentUsed;
	public String Bank;
	public String CheckNo;
	public String CheckExpiration;
	public String created_at;
	public String updated_at;
	public String ORNumber;
	public Cashier_TransactionPaymentDetails() {
	} 
	public Cashier_TransactionPaymentDetails(String id, String TransactionIndexId, String Amount, String PaymentUsed, String Bank, String CheckNo, String CheckExpiration, String created_at, String updated_at, String ORNumber) {
		this.id = id;
		this.TransactionIndexId = TransactionIndexId;
		this.Amount = Amount;
		this.PaymentUsed = PaymentUsed;
		this.Bank = Bank;
		this.CheckNo = CheckNo;
		this.CheckExpiration = CheckExpiration;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.ORNumber = ORNumber;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setTransactionIndexId(String TransactionIndexId) {
		this.TransactionIndexId = TransactionIndexId;
	} 

	public String getTransactionIndexId() {
		return TransactionIndexId;
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

	public void setBank(String Bank) {
		this.Bank = Bank;
	} 

	public String getBank() {
		return Bank;
	} 

	public void setCheckNo(String CheckNo) {
		this.CheckNo = CheckNo;
	} 

	public String getCheckNo() {
		return CheckNo;
	} 

	public void setCheckExpiration(String CheckExpiration) {
		this.CheckExpiration = CheckExpiration;
	} 

	public String getCheckExpiration() {
		return CheckExpiration;
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

	public void setORNumber(String ORNumber) {
		this.ORNumber = ORNumber;
	} 

	public String getORNumber() {
		return ORNumber;
	} 

} 
