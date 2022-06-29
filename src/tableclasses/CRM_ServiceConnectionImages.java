package tableclasses;

public class CRM_ServiceConnectionImages { 
	public String id;
	public String Photo;
	public String ServiceConnectionId;
	public String Notes;
	public String created_at;
	public String updated_at;
	public CRM_ServiceConnectionImages() {
	} 
	public CRM_ServiceConnectionImages(String id, String Photo, String ServiceConnectionId, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.Photo = Photo;
		this.ServiceConnectionId = ServiceConnectionId;
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

	public void setPhoto(String Photo) {
		this.Photo = Photo;
	} 

	public String getPhoto() {
		return Photo;
	} 

	public void setServiceConnectionId(String ServiceConnectionId) {
		this.ServiceConnectionId = ServiceConnectionId;
	} 

	public String getServiceConnectionId() {
		return ServiceConnectionId;
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
