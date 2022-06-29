package tableclasses;

public class CRM_Barangays { 
	public String id;
	public String Barangay;
	public String TownId;
	public String Notes;
	public String created_at;
	public String updated_at;
	public CRM_Barangays() {
	} 
	public CRM_Barangays(String id, String Barangay, String TownId, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.Barangay = Barangay;
		this.TownId = TownId;
		this.Notes = Notes;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setBarangay(String Barangay) {
		this.Barangay = Barangay;
	} 

	public String getBarangay() {
		return Barangay;
	} 

	public void setTownId(String TownId) {
		this.TownId = TownId;
	} 

	public String getTownId() {
		return TownId;
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

} 
