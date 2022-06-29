package tableclasses;

public class CRM_ServiceConnectionChecklist { 
	public String id;
	public String ServiceConnectionId;
	public String ChecklistId;
	public String Notes;
	public String created_at;
	public String updated_at;
	public CRM_ServiceConnectionChecklist() {
	} 
	public CRM_ServiceConnectionChecklist(String id, String ServiceConnectionId, String ChecklistId, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.ChecklistId = ChecklistId;
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

	public void setServiceConnectionId(String ServiceConnectionId) {
		this.ServiceConnectionId = ServiceConnectionId;
	} 

	public String getServiceConnectionId() {
		return ServiceConnectionId;
	} 

	public void setChecklistId(String ChecklistId) {
		this.ChecklistId = ChecklistId;
	} 

	public String getChecklistId() {
		return ChecklistId;
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
