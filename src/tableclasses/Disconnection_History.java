package tableclasses;

public class Disconnection_History { 
	public String id;
	public String AccountNumber;
	public String ServicePeriod;
	public String Latitude;
	public String Longitude;
	public String BillId;
	public String DisconnectionPayment;
	public String Status;
	public String UserId;
	public String Notes;
	public String created_at;
	public String updated_at;
	public String DateDisconnected;
	public String TimeDisconnected;
	public Disconnection_History() {
	} 
	public Disconnection_History(String id, String AccountNumber, String ServicePeriod, String Latitude, String Longitude, String BillId, String DisconnectionPayment, String Status, String UserId, String Notes, String created_at, String updated_at, String DateDisconnected, String TimeDisconnected) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.ServicePeriod = ServicePeriod;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
		this.BillId = BillId;
		this.DisconnectionPayment = DisconnectionPayment;
		this.Status = Status;
		this.UserId = UserId;
		this.Notes = Notes;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.DateDisconnected = DateDisconnected;
		this.TimeDisconnected = TimeDisconnected;
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

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setLatitude(String Latitude) {
		this.Latitude = Latitude;
	} 

	public String getLatitude() {
		return Latitude;
	} 

	public void setLongitude(String Longitude) {
		this.Longitude = Longitude;
	} 

	public String getLongitude() {
		return Longitude;
	} 

	public void setBillId(String BillId) {
		this.BillId = BillId;
	} 

	public String getBillId() {
		return BillId;
	} 

	public void setDisconnectionPayment(String DisconnectionPayment) {
		this.DisconnectionPayment = DisconnectionPayment;
	} 

	public String getDisconnectionPayment() {
		return DisconnectionPayment;
	} 

	public void setStatus(String Status) {
		this.Status = Status;
	} 

	public String getStatus() {
		return Status;
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

	public void setDateDisconnected(String DateDisconnected) {
		this.DateDisconnected = DateDisconnected;
	} 

	public String getDateDisconnected() {
		return DateDisconnected;
	} 

	public void setTimeDisconnected(String TimeDisconnected) {
		this.TimeDisconnected = TimeDisconnected;
	} 

	public String getTimeDisconnected() {
		return TimeDisconnected;
	} 

} 
