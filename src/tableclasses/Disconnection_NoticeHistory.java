package tableclasses;

public class Disconnection_NoticeHistory { 
	public String id;
	public String AccountNumber;
	public String ServicePeriod;
	public String BillId;
	public String created_at;
	public String updated_at;
	public Disconnection_NoticeHistory() {
	} 
	public Disconnection_NoticeHistory(String id, String AccountNumber, String ServicePeriod, String BillId, String created_at, String updated_at) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.ServicePeriod = ServicePeriod;
		this.BillId = BillId;
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

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setBillId(String BillId) {
		this.BillId = BillId;
	} 

	public String getBillId() {
		return BillId;
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
