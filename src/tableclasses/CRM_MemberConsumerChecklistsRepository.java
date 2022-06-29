package tableclasses;

public class CRM_MemberConsumerChecklistsRepository { 
	public String id;
	public String Checklist;
	public String Notes;
	public String created_at;
	public String updated_at;
	public CRM_MemberConsumerChecklistsRepository() {
	} 
	public CRM_MemberConsumerChecklistsRepository(String id, String Checklist, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.Checklist = Checklist;
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

	public void setChecklist(String Checklist) {
		this.Checklist = Checklist;
	} 

	public String getChecklist() {
		return Checklist;
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
