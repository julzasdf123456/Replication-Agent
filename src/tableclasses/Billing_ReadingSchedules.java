package tableclasses;

public class Billing_ReadingSchedules { 
	public String id;
	public String AreaCode;
	public String GroupCode;
	public String ServicePeriod;
	public String ScheduledDate;
	public String MeterReader;
	public String created_at;
	public String updated_at;
	public String Status;
	public Billing_ReadingSchedules() {
	} 
	public Billing_ReadingSchedules(String id, String AreaCode, String GroupCode, String ServicePeriod, String ScheduledDate, String MeterReader, String created_at, String updated_at, String Status) {
		this.id = id;
		this.AreaCode = AreaCode;
		this.GroupCode = GroupCode;
		this.ServicePeriod = ServicePeriod;
		this.ScheduledDate = ScheduledDate;
		this.MeterReader = MeterReader;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.Status = Status;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setAreaCode(String AreaCode) {
		this.AreaCode = AreaCode;
	} 

	public String getAreaCode() {
		return AreaCode;
	} 

	public void setGroupCode(String GroupCode) {
		this.GroupCode = GroupCode;
	} 

	public String getGroupCode() {
		return GroupCode;
	} 

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setScheduledDate(String ScheduledDate) {
		this.ScheduledDate = ScheduledDate;
	} 

	public String getScheduledDate() {
		return ScheduledDate;
	} 

	public void setMeterReader(String MeterReader) {
		this.MeterReader = MeterReader;
	} 

	public String getMeterReader() {
		return MeterReader;
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

	public void setStatus(String Status) {
		this.Status = Status;
	} 

	public String getStatus() {
		return Status;
	} 

} 
