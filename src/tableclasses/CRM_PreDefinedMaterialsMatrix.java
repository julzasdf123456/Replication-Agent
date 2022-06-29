package tableclasses;

public class CRM_PreDefinedMaterialsMatrix { 
	public String id;
	public String ServiceConnectionId;
	public String NEACode;
	public String Description;
	public String Quantity;
	public String Options;
	public String ApplicationType;
	public String Cost;
	public String LaborCost;
	public String Notes;
	public String LaborPercentage;
	public String created_at;
	public String updated_at;
	public String Amount;
	public CRM_PreDefinedMaterialsMatrix() {
	} 
	public CRM_PreDefinedMaterialsMatrix(String id, String ServiceConnectionId, String NEACode, String Description, String Quantity, String Options, String ApplicationType, String Cost, String LaborCost, String Notes, String LaborPercentage, String created_at, String updated_at, String Amount) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.NEACode = NEACode;
		this.Description = Description;
		this.Quantity = Quantity;
		this.Options = Options;
		this.ApplicationType = ApplicationType;
		this.Cost = Cost;
		this.LaborCost = LaborCost;
		this.Notes = Notes;
		this.LaborPercentage = LaborPercentage;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.Amount = Amount;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setServiceConnectionId(String ServiceConnectionId) {
		this.ServiceConnectionId = ServiceConnectionId;
	} 

	public String getServiceConnectionId() {
		return ServiceConnectionId;
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

	public void setQuantity(String Quantity) {
		this.Quantity = Quantity;
	} 

	public String getQuantity() {
		return Quantity;
	} 

	public void setOptions(String Options) {
		this.Options = Options;
	} 

	public String getOptions() {
		return Options;
	} 

	public void setApplicationType(String ApplicationType) {
		this.ApplicationType = ApplicationType;
	} 

	public String getApplicationType() {
		return ApplicationType;
	} 

	public void setCost(String Cost) {
		this.Cost = Cost;
	} 

	public String getCost() {
		return Cost;
	} 

	public void setLaborCost(String LaborCost) {
		this.LaborCost = LaborCost;
	} 

	public String getLaborCost() {
		return LaborCost;
	} 

	public void setNotes(String Notes) {
		this.Notes = Notes;
	} 

	public String getNotes() {
		return Notes;
	} 

	public void setLaborPercentage(String LaborPercentage) {
		this.LaborPercentage = LaborPercentage;
	} 

	public String getLaborPercentage() {
		return LaborPercentage;
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

	public void setAmount(String Amount) {
		this.Amount = Amount;
	} 

	public String getAmount() {
		return Amount;
	} 

} 
