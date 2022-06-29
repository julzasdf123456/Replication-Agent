package tableclasses;

public class Billing_ChangeMeterLogs { 
	public String id;
	public String AccountNumber;
	public String OldMeterSerial;
	public String NewMeterSerial;
	public String PullOutReading;
	public String AdditionalKwhForNextBilling;
	public String Status;
	public String created_at;
	public String updated_at;
	public String ServicePeriod;
	public String NewMeterStartKwh;
	public Billing_ChangeMeterLogs() {
	} 
	public Billing_ChangeMeterLogs(String id, String AccountNumber, String OldMeterSerial, String NewMeterSerial, String PullOutReading, String AdditionalKwhForNextBilling, String Status, String created_at, String updated_at, String ServicePeriod, String NewMeterStartKwh) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.OldMeterSerial = OldMeterSerial;
		this.NewMeterSerial = NewMeterSerial;
		this.PullOutReading = PullOutReading;
		this.AdditionalKwhForNextBilling = AdditionalKwhForNextBilling;
		this.Status = Status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.ServicePeriod = ServicePeriod;
		this.NewMeterStartKwh = NewMeterStartKwh;
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

	public void setOldMeterSerial(String OldMeterSerial) {
		this.OldMeterSerial = OldMeterSerial;
	} 

	public String getOldMeterSerial() {
		return OldMeterSerial;
	} 

	public void setNewMeterSerial(String NewMeterSerial) {
		this.NewMeterSerial = NewMeterSerial;
	} 

	public String getNewMeterSerial() {
		return NewMeterSerial;
	} 

	public void setPullOutReading(String PullOutReading) {
		this.PullOutReading = PullOutReading;
	} 

	public String getPullOutReading() {
		return PullOutReading;
	} 

	public void setAdditionalKwhForNextBilling(String AdditionalKwhForNextBilling) {
		this.AdditionalKwhForNextBilling = AdditionalKwhForNextBilling;
	} 

	public String getAdditionalKwhForNextBilling() {
		return AdditionalKwhForNextBilling;
	} 

	public void setStatus(String Status) {
		this.Status = Status;
	} 

	public String getStatus() {
		return Status;
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

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setNewMeterStartKwh(String NewMeterStartKwh) {
		this.NewMeterStartKwh = NewMeterStartKwh;
	} 

	public String getNewMeterStartKwh() {
		return NewMeterStartKwh;
	} 

} 
