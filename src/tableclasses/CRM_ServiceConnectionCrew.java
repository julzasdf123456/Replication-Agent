package tableclasses;

public class CRM_ServiceConnectionCrew { 
	public String id;
	public String StationName;
	public String CrewLeader;
	public String Members;
	public String Notes;
	public String created_at;
	public String updated_at;
	public String Office;
	public String Grouping;
	public CRM_ServiceConnectionCrew() {
	} 
	public CRM_ServiceConnectionCrew(String id, String StationName, String CrewLeader, String Members, String Notes, String created_at, String updated_at, String Office, String Grouping) {
		this.id = id;
		this.StationName = StationName;
		this.CrewLeader = CrewLeader;
		this.Members = Members;
		this.Notes = Notes;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.Office = Office;
		this.Grouping = Grouping;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setStationName(String StationName) {
		this.StationName = StationName;
	} 

	public String getStationName() {
		return StationName;
	} 

	public void setCrewLeader(String CrewLeader) {
		this.CrewLeader = CrewLeader;
	} 

	public String getCrewLeader() {
		return CrewLeader;
	} 

	public void setMembers(String Members) {
		this.Members = Members;
	} 

	public String getMembers() {
		return Members;
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

	public void setOffice(String Office) {
		this.Office = Office;
	} 

	public String getOffice() {
		return Office;
	} 

	public void setGrouping(String Grouping) {
		this.Grouping = Grouping;
	} 

	public String getGrouping() {
		return Grouping;
	} 

} 
