package tableclasses;

public class Billing_Meters { 
	public String id;
	public String ServiceAccountId;
	public String SerialNumber;
	public String SealNumber;
	public String Brand;
	public String Model;
	public String Multiplier;
	public String Status;
	public String ConnectionDate;
	public String LatestReadingDate;
	public String DateDisconnected;
	public String DateTransfered;
	public String created_at;
	public String updated_at;
	public String InitialReading;
	public String LatestReading;
	public Billing_Meters() {
	} 
	public Billing_Meters(String id, String ServiceAccountId, String SerialNumber, String SealNumber, String Brand, String Model, String Multiplier, String Status, String ConnectionDate, String LatestReadingDate, String DateDisconnected, String DateTransfered, String created_at, String updated_at, String InitialReading, String LatestReading) {
		this.id = id;
		this.ServiceAccountId = ServiceAccountId;
		this.SerialNumber = SerialNumber;
		this.SealNumber = SealNumber;
		this.Brand = Brand;
		this.Model = Model;
		this.Multiplier = Multiplier;
		this.Status = Status;
		this.ConnectionDate = ConnectionDate;
		this.LatestReadingDate = LatestReadingDate;
		this.DateDisconnected = DateDisconnected;
		this.DateTransfered = DateTransfered;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.InitialReading = InitialReading;
		this.LatestReading = LatestReading;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setServiceAccountId(String ServiceAccountId) {
		this.ServiceAccountId = ServiceAccountId;
	} 

	public String getServiceAccountId() {
		return ServiceAccountId;
	} 

	public void setSerialNumber(String SerialNumber) {
		this.SerialNumber = SerialNumber;
	} 

	public String getSerialNumber() {
		return SerialNumber;
	} 

	public void setSealNumber(String SealNumber) {
		this.SealNumber = SealNumber;
	} 

	public String getSealNumber() {
		return SealNumber;
	} 

	public void setBrand(String Brand) {
		this.Brand = Brand;
	} 

	public String getBrand() {
		return Brand;
	} 

	public void setModel(String Model) {
		this.Model = Model;
	} 

	public String getModel() {
		return Model;
	} 

	public void setMultiplier(String Multiplier) {
		this.Multiplier = Multiplier;
	} 

	public String getMultiplier() {
		return Multiplier;
	} 

	public void setStatus(String Status) {
		this.Status = Status;
	} 

	public String getStatus() {
		return Status;
	} 

	public void setConnectionDate(String ConnectionDate) {
		this.ConnectionDate = ConnectionDate;
	} 

	public String getConnectionDate() {
		return ConnectionDate;
	} 

	public void setLatestReadingDate(String LatestReadingDate) {
		this.LatestReadingDate = LatestReadingDate;
	} 

	public String getLatestReadingDate() {
		return LatestReadingDate;
	} 

	public void setDateDisconnected(String DateDisconnected) {
		this.DateDisconnected = DateDisconnected;
	} 

	public String getDateDisconnected() {
		return DateDisconnected;
	} 

	public void setDateTransfered(String DateTransfered) {
		this.DateTransfered = DateTransfered;
	} 

	public String getDateTransfered() {
		return DateTransfered;
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

	public void setInitialReading(String InitialReading) {
		this.InitialReading = InitialReading;
	} 

	public String getInitialReading() {
		return InitialReading;
	} 

	public void setLatestReading(String LatestReading) {
		this.LatestReading = LatestReading;
	} 

	public String getLatestReading() {
		return LatestReading;
	} 

} 
