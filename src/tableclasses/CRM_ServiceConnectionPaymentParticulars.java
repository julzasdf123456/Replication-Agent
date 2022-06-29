package tableclasses;

public class CRM_ServiceConnectionPaymentParticulars { 
	public String id;
	public String Particular;
	public String Description;
	public String VatPercentage;
	public String Notes;
	public String created_at;
	public String updated_at;
	public String DefaultAmount;
	public String AccountNumber;
	public CRM_ServiceConnectionPaymentParticulars() {
	} 
	public CRM_ServiceConnectionPaymentParticulars(String id, String Particular, String Description, String VatPercentage, String Notes, String created_at, String updated_at, String DefaultAmount, String AccountNumber) {
		this.id = id;
		this.Particular = Particular;
		this.Description = Description;
		this.VatPercentage = VatPercentage;
		this.Notes = Notes;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.DefaultAmount = DefaultAmount;
		this.AccountNumber = AccountNumber;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setParticular(String Particular) {
		this.Particular = Particular;
	} 

	public String getParticular() {
		return Particular;
	} 

	public void setDescription(String Description) {
		this.Description = Description;
	} 

	public String getDescription() {
		return Description;
	} 

	public void setVatPercentage(String VatPercentage) {
		this.VatPercentage = VatPercentage;
	} 

	public String getVatPercentage() {
		return VatPercentage;
	} 

	public void setNotes(String Notes) {
		this.Notes = Notes;
	} 

	public String getNotes() {
		return Notes;
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

	public void setDefaultAmount(String DefaultAmount) {
		this.DefaultAmount = DefaultAmount;
	} 

	public String getDefaultAmount() {
		return DefaultAmount;
	} 

	public void setAccountNumber(String AccountNumber) {
		this.AccountNumber = AccountNumber;
	} 

	public String getAccountNumber() {
		return AccountNumber;
	} 

} 
