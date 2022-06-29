package tableclasses;

public class CRM_MemberConsumerChecklists { 
	public String id;
	public String MemberConsumerId;
	public String ChecklistId;
	public String Notes;
	public String created_at;
	public String updated_at;
	public CRM_MemberConsumerChecklists() {
	} 
	public CRM_MemberConsumerChecklists(String id, String MemberConsumerId, String ChecklistId, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.MemberConsumerId = MemberConsumerId;
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

	public void setMemberConsumerId(String MemberConsumerId) {
		this.MemberConsumerId = MemberConsumerId;
	} 

	public String getMemberConsumerId() {
		return MemberConsumerId;
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
