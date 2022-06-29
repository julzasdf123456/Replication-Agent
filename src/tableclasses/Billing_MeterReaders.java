package tableclasses;

public class Billing_MeterReaders { 
	public String id;
	public String MeterReaderCode;
	public String UserId;
	public String DeviceMacAddress;
	public String AreaCodeAssignment;
	public String created_at;
	public String updated_at;
	public Billing_MeterReaders() {
	} 
	public Billing_MeterReaders(String id, String MeterReaderCode, String UserId, String DeviceMacAddress, String AreaCodeAssignment, String created_at, String updated_at) {
		this.id = id;
		this.MeterReaderCode = MeterReaderCode;
		this.UserId = UserId;
		this.DeviceMacAddress = DeviceMacAddress;
		this.AreaCodeAssignment = AreaCodeAssignment;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setMeterReaderCode(String MeterReaderCode) {
		this.MeterReaderCode = MeterReaderCode;
	} 

	public String getMeterReaderCode() {
		return MeterReaderCode;
	} 

	public void setUserId(String UserId) {
		this.UserId = UserId;
	} 

	public String getUserId() {
		return UserId;
	} 

	public void setDeviceMacAddress(String DeviceMacAddress) {
		this.DeviceMacAddress = DeviceMacAddress;
	} 

	public String getDeviceMacAddress() {
		return DeviceMacAddress;
	} 

	public void setAreaCodeAssignment(String AreaCodeAssignment) {
		this.AreaCodeAssignment = AreaCodeAssignment;
	} 

	public String getAreaCodeAssignment() {
		return AreaCodeAssignment;
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
