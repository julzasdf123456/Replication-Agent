package tableclasses;

public class Cashier_TransactionDetails { 
	public String id;
	public String TransactionIndexId;
	public String Particular;
	public String Amount;
	public String VAT;
	public String Total;
	public String created_at;
	public String updated_at;
	public String AccountCode;
	public Cashier_TransactionDetails() {
	} 
	public Cashier_TransactionDetails(String id, String TransactionIndexId, String Particular, String Amount, String VAT, String Total, String created_at, String updated_at, String AccountCode) {
		this.id = id;
		this.TransactionIndexId = TransactionIndexId;
		this.Particular = Particular;
		this.Amount = Amount;
		this.VAT = VAT;
		this.Total = Total;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.AccountCode = AccountCode;
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

	public void setAccountCode(String AccountCode) {
		this.AccountCode = AccountCode;
	} 

	public String getAccountCode() {
		return AccountCode;
	} 

} 
