package tableclasses;

public class role_has_permissions { 
	public String permission_id;
	public String role_id;
	public role_has_permissions() {
	} 
	public role_has_permissions(String permission_id, String role_id) {
		this.permission_id = permission_id;
		this.role_id = role_id;
	} 

	public void setpermission_id(String permission_id) {
		this.permission_id = permission_id;
	} 

	public String getpermission_id() {
		return permission_id;
	} 

	public void setrole_id(String role_id) {
		this.role_id = role_id;
	} 

	public String getrole_id() {
		return role_id;
	} 

} 
