package tableclasses;

public class CRM_MemberConsumerTypes { 
	public String Id;
	public String Type;
	public String Description;
	public String created_at;
	public String updated_at;
	public CRM_MemberConsumerTypes() {
	} 
	public CRM_MemberConsumerTypes(String Id, String Type, String Description, String created_at, String updated_at) {
		this.Id = Id;
		this.Type = Type;
		this.Description = Description;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setId(String Id) {
		this.Id = Id;
	} 

	public String getId() {
		return Id;
	} 

	public void setType(String Type) {
		this.Type = Type;
	} 

	public String getType() {
		return Type;
	} 

	public void setDescription(String Description) {
		this.Description = Description;
	} 

	public String getDescription() {
		return Description;
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
