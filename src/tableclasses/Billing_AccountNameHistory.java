package tableclasses;

public class Billing_AccountNameHistory { 
	public String id;
	public String AccountNumber;
	public String OldAccountName;
	public String Notes;
	public String UserId;
	public String created_at;
	public String updated_at;
	public Billing_AccountNameHistory() {
	} 
	public Billing_AccountNameHistory(String id, String AccountNumber, String OldAccountName, String Notes, String UserId, String created_at, String updated_at) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.OldAccountName = OldAccountName;
		this.Notes = Notes;
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

	public void setOldAccountName(String OldAccountName) {
		this.OldAccountName = OldAccountName;
	} 

	public String getOldAccountName() {
		return OldAccountName;
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
