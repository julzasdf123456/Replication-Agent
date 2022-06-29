package tableclasses;

public class CRM_ServiceConnectionAccountTypes { 
	public String id;
	public String AccountType;
	public String Description;
	public String created_at;
	public String updated_at;
	public String Alias;
	public CRM_ServiceConnectionAccountTypes() {
	} 
	public CRM_ServiceConnectionAccountTypes(String id, String AccountType, String Description, String created_at, String updated_at, String Alias) {
		this.id = id;
		this.AccountType = AccountType;
		this.Description = Description;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.Alias = Alias;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setAccountType(String AccountType) {
		this.AccountType = AccountType;
	} 

	public String getAccountType() {
		return AccountType;
	} 

	public void setDescription(String Description) {
		this.Description = Description;
	} 

	public String getDescription() {
		return Description;
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

	public void setAlias(String Alias) {
		this.Alias = Alias;
	} 

	public String getAlias() {
		return Alias;
	} 

} 
