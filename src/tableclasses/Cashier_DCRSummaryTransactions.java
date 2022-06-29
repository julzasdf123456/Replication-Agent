package tableclasses;

public class Cashier_DCRSummaryTransactions { 
	public String id;
	public String GLCode;
	public String NEACode;
	public String Description;
	public String Amount;
	public String Day;
	public String Time;
	public String Teller;
	public String DCRNumber;
	public String Status;
	public String created_at;
	public String updated_at;
	public String ORNumber;
	public String ReportDestination;
	public String Office;
	public String AccountNumber;
	public Cashier_DCRSummaryTransactions() {
	} 
	public Cashier_DCRSummaryTransactions(String id, String GLCode, String NEACode, String Description, String Amount, String Day, String Time, String Teller, String DCRNumber, String Status, String created_at, String updated_at, String ORNumber, String ReportDestination, String Office, String AccountNumber) {
		this.id = id;
		this.GLCode = GLCode;
		this.NEACode = NEACode;
		this.Description = Description;
		this.Amount = Amount;
		this.Day = Day;
		this.Time = Time;
		this.Teller = Teller;
		this.DCRNumber = DCRNumber;
		this.Status = Status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.ORNumber = ORNumber;
		this.ReportDestination = ReportDestination;
		this.Office = Office;
		this.AccountNumber = AccountNumber;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setGLCode(String GLCode) {
		this.GLCode = GLCode;
	} 

	public String getGLCode() {
		return GLCode;
	} 

	public void setNEACode(String NEACode) {
		this.NEACode = NEACode;
	} 

	public String getNEACode() {
		return NEACode;
	} 

	public void setDescription(String Description) {
		this.Description = Description;
	} 

	public String getDescription() {
		return Description;
	} 

	public void setAmount(String Amount) {
		this.Amount = Amount;
	} 

	public String getAmount() {
		return Amount;
	} 

	public void setDay(String Day) {
		this.Day = Day;
	} 

	public String getDay() {
		return Day;
	} 

	public void setTime(String Time) {
		this.Time = Time;
	} 

	public String getTime() {
		return Time;
	} 

	public void setTeller(String Teller) {
		this.Teller = Teller;
	} 

	public String getTeller() {
		return Teller;
	} 

	public void setDCRNumber(String DCRNumber) {
		this.DCRNumber = DCRNumber;
	} 

	public String getDCRNumber() {
		return DCRNumber;
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

	public void setORNumber(String ORNumber) {
		this.ORNumber = ORNumber;
	} 

	public String getORNumber() {
		return ORNumber;
	} 

	public void setReportDestination(String ReportDestination) {
		this.ReportDestination = ReportDestination;
	} 

	public String getReportDestination() {
		return ReportDestination;
	} 

	public void setOffice(String Office) {
		this.Office = Office;
	} 

	public String getOffice() {
		return Office;
	} 

	public void setAccountNumber(String AccountNumber) {
		this.AccountNumber = AccountNumber;
	} 

	public String getAccountNumber() {
		return AccountNumber;
	} 

} 
