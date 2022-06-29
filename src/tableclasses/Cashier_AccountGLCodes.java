package tableclasses;

public class Cashier_AccountGLCodes { 
	public String id;
	public String AccountCode;
	public String NEACode;
	public String Status;
	public String Notes;
	public String created_at;
	public String updated_at;
	public Cashier_AccountGLCodes() {
	} 
	public Cashier_AccountGLCodes(String id, String AccountCode, String NEACode, String Status, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.AccountCode = AccountCode;
		this.NEACode = NEACode;
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

	public void setAccountCode(String AccountCode) {
		this.AccountCode = AccountCode;
	} 

	public String getAccountCode() {
		return AccountCode;
	} 

	public void setNEACode(String NEACode) {
		this.NEACode = NEACode;
	} 

	public String getNEACode() {
		return NEACode;
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
