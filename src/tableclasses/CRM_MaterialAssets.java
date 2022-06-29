package tableclasses;

public class CRM_MaterialAssets { 
	public String id;
	public String Description;
	public String Amount;
	public String created_at;
	public String updated_at;
	public CRM_MaterialAssets() {
	} 
	public CRM_MaterialAssets(String id, String Description, String Amount, String created_at, String updated_at) {
		this.id = id;
		this.Description = Description;
		this.Amount = Amount;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setDescription(String Description) {
		this.Description = Description;
	} 

	public String getDescription() {
		return Description;
	} 

	public void setAmount(String Amount) {
		this.Amount = Amount;
	} 

	public String getAmount() {
		return Amount;
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
