package tableclasses;

public class Billing_AccountLocationHistory { 
	public String id;
	public String AccountNumber;
	public String Town;
	public String Barangay;
	public String Purok;
	public String AreaCode;
	public String SequenceCode;
	public String MeterReader;
	public String ServiceConnectionId;
	public String RelocationDate;
	public String created_at;
	public String updated_at;
	public Billing_AccountLocationHistory() {
	} 
	public Billing_AccountLocationHistory(String id, String AccountNumber, String Town, String Barangay, String Purok, String AreaCode, String SequenceCode, String MeterReader, String ServiceConnectionId, String RelocationDate, String created_at, String updated_at) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.Town = Town;
		this.Barangay = Barangay;
		this.Purok = Purok;
		this.AreaCode = AreaCode;
		this.SequenceCode = SequenceCode;
		this.MeterReader = MeterReader;
		this.ServiceConnectionId = ServiceConnectionId;
		this.RelocationDate = RelocationDate;
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

	public void setTown(String Town) {
		this.Town = Town;
	} 

	public String getTown() {
		return Town;
	} 

	public void setBarangay(String Barangay) {
		this.Barangay = Barangay;
	} 

	public String getBarangay() {
		return Barangay;
	} 

	public void setPurok(String Purok) {
		this.Purok = Purok;
	} 

	public String getPurok() {
		return Purok;
	} 

	public void setAreaCode(String AreaCode) {
		this.AreaCode = AreaCode;
	} 

	public String getAreaCode() {
		return AreaCode;
	} 

	public void setSequenceCode(String SequenceCode) {
		this.SequenceCode = SequenceCode;
	} 

	public String getSequenceCode() {
		return SequenceCode;
	} 

	public void setMeterReader(String MeterReader) {
		this.MeterReader = MeterReader;
	} 

	public String getMeterReader() {
		return MeterReader;
	} 

	public void setServiceConnectionId(String ServiceConnectionId) {
		this.ServiceConnectionId = ServiceConnectionId;
	} 

	public String getServiceConnectionId() {
		return ServiceConnectionId;
	} 

	public void setRelocationDate(String RelocationDate) {
		this.RelocationDate = RelocationDate;
	} 

	public String getRelocationDate() {
		return RelocationDate;
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
