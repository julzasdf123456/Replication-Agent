package tableclasses;

public class Reports_RateItems { 
	public String id;
	public String RateItem;
	public String Notes;
	public String created_at;
	public String updated_at;
	public Reports_RateItems() {
	} 
	public Reports_RateItems(String id, String RateItem, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.RateItem = RateItem;
		this.Notes = Notes;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setRateItem(String RateItem) {
		this.RateItem = RateItem;
	} 

	public String getRateItem() {
		return RateItem;
	} 

	public void setNotes(String Notes) {
		this.Notes = Notes;
	} 

	public String getNotes() {
		return Notes;
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
