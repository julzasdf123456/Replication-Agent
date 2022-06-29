package tableclasses;

public class model_has_roles { 
	public String role_id;
	public String model_type;
	public String model_id;
	public model_has_roles() {
	} 
	public model_has_roles(String role_id, String model_type, String model_id) {
		this.role_id = role_id;
		this.model_type = model_type;
		this.model_id = model_id;
	} 

	public void setrole_id(String role_id) {
		this.role_id = role_id;
	} 

	public String getrole_id() {
		return role_id;
	} 

	public void setmodel_type(String model_type) {
		this.model_type = model_type;
	} 

	public String getmodel_type() {
		return model_type;
	} 

	public void setmodel_id(String model_id) {
		this.model_id = model_id;
	} 

	public String getmodel_id() {
		return model_id;
	} 

} 
