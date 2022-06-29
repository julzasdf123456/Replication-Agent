package tableclasses;

public class CRM_DamageAssessment { 
	public String id;
	public String Type;
	public String ObjectName;
	public String Feeder;
	public String Town;
	public String Status;
	public String Notes;
	public String DateFixed;
	public String CrewAssigned;
	public String Latitude;
	public String Longitude;
	public String created_at;
	public String updated_at;
	public CRM_DamageAssessment() {
	} 
	public CRM_DamageAssessment(String id, String Type, String ObjectName, String Feeder, String Town, String Status, String Notes, String DateFixed, String CrewAssigned, String Latitude, String Longitude, String created_at, String updated_at) {
		this.id = id;
		this.Type = Type;
		this.ObjectName = ObjectName;
		this.Feeder = Feeder;
		this.Town = Town;
		this.Status = Status;
		this.Notes = Notes;
		this.DateFixed = DateFixed;
		this.CrewAssigned = CrewAssigned;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setType(String Type) {
		this.Type = Type;
	} 

	public String getType() {
		return Type;
	} 

	public void setObjectName(String ObjectName) {
		this.ObjectName = ObjectName;
	} 

	public String getObjectName() {
		return ObjectName;
	} 

	public void setFeeder(String Feeder) {
		this.Feeder = Feeder;
	} 

	public String getFeeder() {
		return Feeder;
	} 

	public void setTown(String Town) {
		this.Town = Town;
	} 

	public String getTown() {
		return Town;
	} 

	public void setStatus(String Status) {
		this.Status = Status;
	} 

	public String getStatus() {
		return Status;
	} 

	public void setNotes(String Notes) {
		this.Notes = Notes;
	} 

	public String getNotes() {
		return Notes;
	} 

	public void setDateFixed(String DateFixed) {
		this.DateFixed = DateFixed;
	} 

	public String getDateFixed() {
		return DateFixed;
	} 

	public void setCrewAssigned(String CrewAssigned) {
		this.CrewAssigned = CrewAssigned;
	} 

	public String getCrewAssigned() {
		return CrewAssigned;
	} 

	public void setLatitude(String Latitude) {
		this.Latitude = Latitude;
	} 

	public String getLatitude() {
		return Latitude;
	} 

	public void setLongitude(String Longitude) {
		this.Longitude = Longitude;
	} 

	public String getLongitude() {
		return Longitude;
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
