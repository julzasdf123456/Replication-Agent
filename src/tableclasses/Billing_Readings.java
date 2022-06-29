package tableclasses;

public class Billing_Readings { 
	public String id;
	public String AccountNumber;
	public String ServicePeriod;
	public String ReadingTimestamp;
	public String KwhUsed;
	public String DemandKwhUsed;
	public String Notes;
	public String Latitude;
	public String Longitude;
	public String created_at;
	public String updated_at;
	public String FieldStatus;
	public String MeterReader;
	public Billing_Readings() {
	} 
	public Billing_Readings(String id, String AccountNumber, String ServicePeriod, String ReadingTimestamp, String KwhUsed, String DemandKwhUsed, String Notes, String Latitude, String Longitude, String created_at, String updated_at, String FieldStatus, String MeterReader) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.ServicePeriod = ServicePeriod;
		this.ReadingTimestamp = ReadingTimestamp;
		this.KwhUsed = KwhUsed;
		this.DemandKwhUsed = DemandKwhUsed;
		this.Notes = Notes;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.FieldStatus = FieldStatus;
		this.MeterReader = MeterReader;
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

	public void setReadingTimestamp(String ReadingTimestamp) {
		this.ReadingTimestamp = ReadingTimestamp;
	} 

	public String getReadingTimestamp() {
		return ReadingTimestamp;
	} 

	public void setKwhUsed(String KwhUsed) {
		this.KwhUsed = KwhUsed;
	} 

	public String getKwhUsed() {
		return KwhUsed;
	} 

	public void setDemandKwhUsed(String DemandKwhUsed) {
		this.DemandKwhUsed = DemandKwhUsed;
	} 

	public String getDemandKwhUsed() {
		return DemandKwhUsed;
	} 

	public void setNotes(String Notes) {
		this.Notes = Notes;
	} 

	public String getNotes() {
		return Notes;
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

	public void setFieldStatus(String FieldStatus) {
		this.FieldStatus = FieldStatus;
	} 

	public String getFieldStatus() {
		return FieldStatus;
	} 

	public void setMeterReader(String MeterReader) {
		this.MeterReader = MeterReader;
	} 

	public String getMeterReader() {
		return MeterReader;
	} 

} 
