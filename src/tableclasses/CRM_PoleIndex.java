package tableclasses;

public class CRM_PoleIndex { 
	public String id;
	public String NEACode;
	public String Type;
	public String created_at;
	public String updated_at;
	public CRM_PoleIndex() {
	} 
	public CRM_PoleIndex(String id, String NEACode, String Type, String created_at, String updated_at) {
		this.id = id;
		this.NEACode = NEACode;
		this.Type = Type;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setNEACode(String NEACode) {
		this.NEACode = NEACode;
	} 

	public String getNEACode() {
		return NEACode;
	} 

	public void setType(String Type) {
		this.Type = Type;
	} 

	public String getType() {
		return Type;
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
