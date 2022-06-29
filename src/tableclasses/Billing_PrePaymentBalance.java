package tableclasses;

public class Billing_PrePaymentBalance { 
	public String id;
	public String AccountNumber;
	public String Balance;
	public String Status;
	public String created_at;
	public String updated_at;
	public Billing_PrePaymentBalance() {
	} 
	public Billing_PrePaymentBalance(String id, String AccountNumber, String Balance, String Status, String created_at, String updated_at) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.Balance = Balance;
		this.Status = Status;
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

	public void setBalance(String Balance) {
		this.Balance = Balance;
	} 

	public String getBalance() {
		return Balance;
	} 

	public void setStatus(String Status) {
		this.Status = Status;
	} 

	public String getStatus() {
		return Status;
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
