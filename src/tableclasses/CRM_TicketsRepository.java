package tableclasses;

public class CRM_TicketsRepository { 
	public String id;
	public String Name;
	public String Description;
	public String ParentTicket;
	public String Type;
	public String KPSCategory;
	public String KPSIssue;
	public String created_at;
	public String updated_at;
	public CRM_TicketsRepository() {
	} 
	public CRM_TicketsRepository(String id, String Name, String Description, String ParentTicket, String Type, String KPSCategory, String KPSIssue, String created_at, String updated_at) {
		this.id = id;
		this.Name = Name;
		this.Description = Description;
		this.ParentTicket = ParentTicket;
		this.Type = Type;
		this.KPSCategory = KPSCategory;
		this.KPSIssue = KPSIssue;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setName(String Name) {
		this.Name = Name;
	} 

	public String getName() {
		return Name;
	} 

	public void setDescription(String Description) {
		this.Description = Description;
	} 

	public String getDescription() {
		return Description;
	} 

	public void setParentTicket(String ParentTicket) {
		this.ParentTicket = ParentTicket;
	} 

	public String getParentTicket() {
		return ParentTicket;
	} 

	public void setType(String Type) {
		this.Type = Type;
	} 

	public String getType() {
		return Type;
	} 

	public void setKPSCategory(String KPSCategory) {
		this.KPSCategory = KPSCategory;
	} 

	public String getKPSCategory() {
		return KPSCategory;
	} 

	public void setKPSIssue(String KPSIssue) {
		this.KPSIssue = KPSIssue;
	} 

	public String getKPSIssue() {
		return KPSIssue;
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
