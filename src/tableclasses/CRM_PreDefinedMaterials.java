package tableclasses;

public class CRM_PreDefinedMaterials { 
	public String id;
	public String NEACode;
	public String Quantity;
	public String Options;
	public String ApplicationType;
	public String Notes;
	public String created_at;
	public String updated_at;
	public String LaborPercentage;
	public CRM_PreDefinedMaterials() {
	} 
	public CRM_PreDefinedMaterials(String id, String NEACode, String Quantity, String Options, String ApplicationType, String Notes, String created_at, String updated_at, String LaborPercentage) {
		this.id = id;
		this.NEACode = NEACode;
		this.Quantity = Quantity;
		this.Options = Options;
		this.ApplicationType = ApplicationType;
		this.Notes = Notes;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.LaborPercentage = LaborPercentage;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setNEACode(String NEACode) {
		this.NEACode = NEACode;
	} 

	public String getNEACode() {
		return NEACode;
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

	public void setLaborPercentage(String LaborPercentage) {
		this.LaborPercentage = LaborPercentage;
	} 

	public String getLaborPercentage() {
		return LaborPercentage;
	} 

} 
