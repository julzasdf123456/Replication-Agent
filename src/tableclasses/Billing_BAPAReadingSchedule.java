package tableclasses;

public class Billing_BAPAReadingSchedule { 
	public String id;
	public String ServicePeriod;
	public String Town;
	public String BAPAName;
	public String Status;
	public String DownloadedBy;
	public String created_at;
	public String updated_at;
	public Billing_BAPAReadingSchedule() {
	} 
	public Billing_BAPAReadingSchedule(String id, String ServicePeriod, String Town, String BAPAName, String Status, String DownloadedBy, String created_at, String updated_at) {
		this.id = id;
		this.ServicePeriod = ServicePeriod;
		this.Town = Town;
		this.BAPAName = BAPAName;
		this.Status = Status;
		this.DownloadedBy = DownloadedBy;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setTown(String Town) {
		this.Town = Town;
	} 

	public String getTown() {
		return Town;
	} 

	public void setBAPAName(String BAPAName) {
		this.BAPAName = BAPAName;
	} 

	public String getBAPAName() {
		return BAPAName;
	} 

	public void setStatus(String Status) {
		this.Status = Status;
	} 

	public String getStatus() {
		return Status;
	} 

	public void setDownloadedBy(String DownloadedBy) {
		this.DownloadedBy = DownloadedBy;
	} 

	public String getDownloadedBy() {
		return DownloadedBy;
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
