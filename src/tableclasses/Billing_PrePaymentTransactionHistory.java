package tableclasses;

public class Billing_PrePaymentTransactionHistory { 
	public String id;
	public String AccountNumber;
	public String Method;
	public String Amount;
	public String UserId;
	public String Notes;
	public String created_at;
	public String updated_at;
	public String ORNumber;
	public Billing_PrePaymentTransactionHistory() {
	} 
	public Billing_PrePaymentTransactionHistory(String id, String AccountNumber, String Method, String Amount, String UserId, String Notes, String created_at, String updated_at, String ORNumber) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.Method = Method;
		this.Amount = Amount;
		this.UserId = UserId;
		this.Notes = Notes;
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

	public void setAccountNumber(String AccountNumber) {
		this.AccountNumber = AccountNumber;
	} 

	public String getAccountNumber() {
		return AccountNumber;
	} 

	public void setMethod(String Method) {
		this.Method = Method;
	} 

	public String getMethod() {
		return Method;
	} 

	public void setAmount(String Amount) {
		this.Amount = Amount;
	} 

	public String getAmount() {
		return Amount;
	} 

	public void setUserId(String UserId) {
		this.UserId = UserId;
	} 

	public String getUserId() {
		return UserId;
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

	public void setORNumber(String ORNumber) {
		this.ORNumber = ORNumber;
	} 

	public String getORNumber() {
		return ORNumber;
	} 

} 
