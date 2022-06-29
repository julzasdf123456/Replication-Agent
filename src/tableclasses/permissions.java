package tableclasses;

public class permissions { 
	public String id;
	public String name;
	public String guard_name;
	public String created_at;
	public String updated_at;
	public permissions() {
	} 
	public permissions(String id, String name, String guard_name, String created_at, String updated_at) {
		this.id = id;
		this.name = name;
		this.guard_name = guard_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setname(String name) {
		this.name = name;
	} 

	public String getname() {
		return name;
	} 

	public void setguard_name(String guard_name) {
		this.guard_name = guard_name;
	} 

	public String getguard_name() {
		return guard_name;
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
