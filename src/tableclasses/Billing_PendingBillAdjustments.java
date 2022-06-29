package tableclasses;

public class Billing_PendingBillAdjustments { 
	public String id;
	public String ReadingId;
	public String KwhUsed;
	public String AccountNumber;
	public String ServicePeriod;
	public String Confirmed;
	public String ReadDate;
	public String created_at;
	public String updated_at;
	public String UserId;
	public String Office;
	public Billing_PendingBillAdjustments() {
	} 
	public Billing_PendingBillAdjustments(String id, String ReadingId, String KwhUsed, String AccountNumber, String ServicePeriod, String Confirmed, String ReadDate, String created_at, String updated_at, String UserId, String Office) {
		this.id = id;
		this.ReadingId = ReadingId;
		this.KwhUsed = KwhUsed;
		this.AccountNumber = AccountNumber;
		this.ServicePeriod = ServicePeriod;
		this.Confirmed = Confirmed;
		this.ReadDate = ReadDate;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.UserId = UserId;
		this.Office = Office;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setReadingId(String ReadingId) {
		this.ReadingId = ReadingId;
	} 

	public String getReadingId() {
		return ReadingId;
	} 

	public void setKwhUsed(String KwhUsed) {
		this.KwhUsed = KwhUsed;
	} 

	public String getKwhUsed() {
		return KwhUsed;
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

	public void setConfirmed(String Confirmed) {
		this.Confirmed = Confirmed;
	} 

	public String getConfirmed() {
		return Confirmed;
	} 

	public void setReadDate(String ReadDate) {
		this.ReadDate = ReadDate;
	} 

	public String getReadDate() {
		return ReadDate;
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

	public void setUserId(String UserId) {
		this.UserId = UserId;
	} 

	public String getUserId() {
		return UserId;
	} 

	public void setOffice(String Office) {
		this.Office = Office;
	} 

	public String getOffice() {
		return Office;
	} 

} 
