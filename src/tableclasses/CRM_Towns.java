package tableclasses;

public class CRM_Towns { 
	public String id;
	public String Town;
	public String District;
	public String Station;
	public String created_at;
	public String updated_at;
	public CRM_Towns() {
	} 
	public CRM_Towns(String id, String Town, String District, String Station, String created_at, String updated_at) {
		this.id = id;
		this.Town = Town;
		this.District = District;
		this.Station = Station;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setTown(String Town) {
		this.Town = Town;
	} 

	public String getTown() {
		return Town;
	} 

	public void setDistrict(String District) {
		this.District = District;
	} 

	public String getDistrict() {
		return District;
	} 

	public void setStation(String Station) {
		this.Station = Station;
	} 

	public String getStation() {
		return Station;
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
