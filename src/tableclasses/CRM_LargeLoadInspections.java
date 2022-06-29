package tableclasses;

public class CRM_LargeLoadInspections { 
	public String id;
	public String ServiceConnectionId;
	public String Assessment;
	public String DateOfInspection;
	public String Notes;
	public String created_at;
	public String updated_at;
	public String Options;
	public CRM_LargeLoadInspections() {
	} 
	public CRM_LargeLoadInspections(String id, String ServiceConnectionId, String Assessment, String DateOfInspection, String Notes, String created_at, String updated_at, String Options) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.Assessment = Assessment;
		this.DateOfInspection = DateOfInspection;
		this.Notes = Notes;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.Options = Options;
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

	public void setAssessment(String Assessment) {
		this.Assessment = Assessment;
	} 

	public String getAssessment() {
		return Assessment;
	} 

	public void setDateOfInspection(String DateOfInspection) {
		this.DateOfInspection = DateOfInspection;
	} 

	public String getDateOfInspection() {
		return DateOfInspection;
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

	public void setOptions(String Options) {
		this.Options = Options;
	} 

	public String getOptions() {
		return Options;
	} 

} 
