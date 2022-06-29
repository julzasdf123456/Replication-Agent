package tableclasses;

public class CRM_Structures { 
	public String id;
	public String Type;
	public String Data;
	public String created_at;
	public String updated_at;
	public CRM_Structures() {
	} 
	public CRM_Structures(String id, String Type, String Data, String created_at, String updated_at) {
		this.id = id;
		this.Type = Type;
		this.Data = Data;
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

	public void setData(String Data) {
		this.Data = Data;
	} 

	public String getData() {
		return Data;
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
