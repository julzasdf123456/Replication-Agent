package tableclasses;

public class CRM_MastPoles { 
	public String id;
	public String ServiceConnectionId;
	public String Latitude;
	public String Longitude;
	public String DateTimeTaken;
	public String PoleRemarks;
	public String created_at;
	public String updated_at;
	public CRM_MastPoles() {
	} 
	public CRM_MastPoles(String id, String ServiceConnectionId, String Latitude, String Longitude, String DateTimeTaken, String PoleRemarks, String created_at, String updated_at) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
		this.DateTimeTaken = DateTimeTaken;
		this.PoleRemarks = PoleRemarks;
		this.created_at = created_at;
		this.updated_at = updated_at;
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

	public void setDateTimeTaken(String DateTimeTaken) {
		this.DateTimeTaken = DateTimeTaken;
	} 

	public String getDateTimeTaken() {
		return DateTimeTaken;
	} 

	public void setPoleRemarks(String PoleRemarks) {
		this.PoleRemarks = PoleRemarks;
	} 

	public String getPoleRemarks() {
		return PoleRemarks;
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
