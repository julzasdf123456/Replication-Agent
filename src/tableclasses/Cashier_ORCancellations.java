package tableclasses;

public class Cashier_ORCancellations { 
	public String id;
	public String ORNumber;
	public String ORDate;
	public String From;
	public String ObjectId;
	public String DateTimeFiled;
	public String DateTimeApproved;
	public String created_at;
	public String updated_at;
	public Cashier_ORCancellations() {
	} 
	public Cashier_ORCancellations(String id, String ORNumber, String ORDate, String From, String ObjectId, String DateTimeFiled, String DateTimeApproved, String created_at, String updated_at) {
		this.id = id;
		this.ORNumber = ORNumber;
		this.ORDate = ORDate;
		this.From = From;
		this.ObjectId = ObjectId;
		this.DateTimeFiled = DateTimeFiled;
		this.DateTimeApproved = DateTimeApproved;
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

	public void setORDate(String ORDate) {
		this.ORDate = ORDate;
	} 

	public String getORDate() {
		return ORDate;
	} 

	public void setFrom(String From) {
		this.From = From;
	} 

	public String getFrom() {
		return From;
	} 

	public void setObjectId(String ObjectId) {
		this.ObjectId = ObjectId;
	} 

	public String getObjectId() {
		return ObjectId;
	} 

	public void setDateTimeFiled(String DateTimeFiled) {
		this.DateTimeFiled = DateTimeFiled;
	} 

	public String getDateTimeFiled() {
		return DateTimeFiled;
	} 

	public void setDateTimeApproved(String DateTimeApproved) {
		this.DateTimeApproved = DateTimeApproved;
	} 

	public String getDateTimeApproved() {
		return DateTimeApproved;
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
