package tableclasses;

public class CRM_ServiceConnectionMaterialPayables { 
	public String id;
	public String Material;
	public String Rate;
	public String Description;
	public String VatPercentage;
	public String Notes;
	public String created_at;
	public String updated_at;
	public String BuildingType;
	public CRM_ServiceConnectionMaterialPayables() {
	} 
	public CRM_ServiceConnectionMaterialPayables(String id, String Material, String Rate, String Description, String VatPercentage, String Notes, String created_at, String updated_at, String BuildingType) {
		this.id = id;
		this.Material = Material;
		this.Rate = Rate;
		this.Description = Description;
		this.VatPercentage = VatPercentage;
		this.Notes = Notes;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.BuildingType = BuildingType;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setMaterial(String Material) {
		this.Material = Material;
	} 

	public String getMaterial() {
		return Material;
	} 

	public void setRate(String Rate) {
		this.Rate = Rate;
	} 

	public String getRate() {
		return Rate;
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

	public void setBuildingType(String BuildingType) {
		this.BuildingType = BuildingType;
	} 

	public String getBuildingType() {
		return BuildingType;
	} 

} 
