package tableclasses;

public class model_has_permissions { 
	public String permission_id;
	public String model_type;
	public String model_id;
	public model_has_permissions() {
	} 
	public model_has_permissions(String permission_id, String model_type, String model_id) {
		this.permission_id = permission_id;
		this.model_type = model_type;
		this.model_id = model_id;
	} 

	public void setpermission_id(String permission_id) {
		this.permission_id = permission_id;
	} 

	public String getpermission_id() {
		return permission_id;
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
