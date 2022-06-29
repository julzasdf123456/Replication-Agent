package tableclasses;

public class users { 
	public String id;
	public String username;
	public String name;
	public String email;
	public String email_verified_at;
	public String password;
	public String remember_token;
	public String created_at;
	public String updated_at;
	public users() {
	} 
	public users(String id, String username, String name, String email, String email_verified_at, String password, String remember_token, String created_at, String updated_at) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.email = email;
		this.email_verified_at = email_verified_at;
		this.password = password;
		this.remember_token = remember_token;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setusername(String username) {
		this.username = username;
	} 

	public String getusername() {
		return username;
	} 

	public void setname(String name) {
		this.name = name;
	} 

	public String getname() {
		return name;
	} 

	public void setemail(String email) {
		this.email = email;
	} 

	public String getemail() {
		return email;
	} 

	public void setemail_verified_at(String email_verified_at) {
		this.email_verified_at = email_verified_at;
	} 

	public String getemail_verified_at() {
		return email_verified_at;
	} 

	public void setpassword(String password) {
		this.password = password;
	} 

	public String getpassword() {
		return password;
	} 

	public void setremember_token(String remember_token) {
		this.remember_token = remember_token;
	} 

	public String getremember_token() {
		return remember_token;
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
