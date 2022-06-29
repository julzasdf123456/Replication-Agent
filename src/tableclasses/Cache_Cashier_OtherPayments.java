package tableclasses;

public class Cache_Cashier_OtherPayments { 
	public String id;
	public String AccountNumber;
	public String TransactionIndexId;
	public String Particular;
	public String Amount;
	public String VAT;
	public String Total;
	public String AccountCode;
	public String created_at;
	public String updated_at;
	public Cache_Cashier_OtherPayments() {
	} 
	public Cache_Cashier_OtherPayments(String id, String AccountNumber, String TransactionIndexId, String Particular, String Amount, String VAT, String Total, String AccountCode, String created_at, String updated_at) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.TransactionIndexId = TransactionIndexId;
		this.Particular = Particular;
		this.Amount = Amount;
		this.VAT = VAT;
		this.Total = Total;
		this.AccountCode = AccountCode;
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

	public void setTransactionIndexId(String TransactionIndexId) {
		this.TransactionIndexId = TransactionIndexId;
	} 

	public String getTransactionIndexId() {
		return TransactionIndexId;
	} 

	public void setParticular(String Particular) {
		this.Particular = Particular;
	} 

	public String getParticular() {
		return Particular;
	} 

	public void setAmount(String Amount) {
		this.Amount = Amount;
	} 

	public String getAmount() {
		return Amount;
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

	public void setAccountCode(String AccountCode) {
		this.AccountCode = AccountCode;
	} 

	public String getAccountCode() {
		return AccountCode;
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
