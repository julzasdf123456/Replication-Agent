package tableclasses;

public class password_resets { 
	public String email;
	public String token;
	public String created_at;
	public password_resets() {
	} 
	public password_resets(String email, String token, String created_at) {
		this.email = email;
		this.token = token;
		this.created_at = created_at;
	} 

	public void setemail(String email) {
		this.email = email;
	} 

	public String getemail() {
		return email;
	} 

	public void settoken(String token) {
		this.token = token;
	} 

	public String gettoken() {
		return token;
	} 

	public void setcreated_at(String created_at) {
		this.created_at = created_at;
	} 

	public String getcreated_at() {
		return created_at;
	} 

} 
