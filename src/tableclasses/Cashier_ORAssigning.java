package tableclasses;

public class Cashier_ORAssigning { 
	public String id;
	public String ORNumber;
	public String UserId;
	public String DateAssigned;
	public String IsSetManually;
	public String TimeAssigned;
	public String Office;
	public String created_at;
	public String updated_at;
	public Cashier_ORAssigning() {
	} 
	public Cashier_ORAssigning(String id, String ORNumber, String UserId, String DateAssigned, String IsSetManually, String TimeAssigned, String Office, String created_at, String updated_at) {
		this.id = id;
		this.ORNumber = ORNumber;
		this.UserId = UserId;
		this.DateAssigned = DateAssigned;
		this.IsSetManually = IsSetManually;
		this.TimeAssigned = TimeAssigned;
		this.Office = Office;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setORNumber(String ORNumber) {
		this.ORNumber = ORNumber;
	} 

	public String getORNumber() {
		return ORNumber;
	} 

	public void setUserId(String UserId) {
		this.UserId = UserId;
	} 

	public String getUserId() {
		return UserId;
	} 

	public void setDateAssigned(String DateAssigned) {
		this.DateAssigned = DateAssigned;
	} 

	public String getDateAssigned() {
		return DateAssigned;
	} 

	public void setIsSetManually(String IsSetManually) {
		this.IsSetManually = IsSetManually;
	} 

	public String getIsSetManually() {
		return IsSetManually;
	} 

	public void setTimeAssigned(String TimeAssigned) {
		this.TimeAssigned = TimeAssigned;
	} 

	public String getTimeAssigned() {
		return TimeAssigned;
	} 

	public void setOffice(String Office) {
		this.Office = Office;
	} 

	public String getOffice() {
		return Office;
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
