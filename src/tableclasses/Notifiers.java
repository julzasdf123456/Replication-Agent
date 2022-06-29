package tableclasses;

public class Notifiers { 
	public String id;
	public String Notification;
	public String From;
	public String To;
	public String Status;
	public String Intent;
	public String IntentLink;
	public String ObjectId;
	public String created_at;
	public String updated_at;
	public Notifiers() {
	} 
	public Notifiers(String id, String Notification, String From, String To, String Status, String Intent, String IntentLink, String ObjectId, String created_at, String updated_at) {
		this.id = id;
		this.Notification = Notification;
		this.From = From;
		this.To = To;
		this.Status = Status;
		this.Intent = Intent;
		this.IntentLink = IntentLink;
		this.ObjectId = ObjectId;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setNotification(String Notification) {
		this.Notification = Notification;
	} 

	public String getNotification() {
		return Notification;
	} 

	public void setFrom(String From) {
		this.From = From;
	} 

	public String getFrom() {
		return From;
	} 

	public void setTo(String To) {
		this.To = To;
	} 

	public String getTo() {
		return To;
	} 

	public void setStatus(String Status) {
		this.Status = Status;
	} 

	public String getStatus() {
		return Status;
	} 

	public void setIntent(String Intent) {
		this.Intent = Intent;
	} 

	public String getIntent() {
		return Intent;
	} 

	public void setIntentLink(String IntentLink) {
		this.IntentLink = IntentLink;
	} 

	public String getIntentLink() {
		return IntentLink;
	} 

	public void setObjectId(String ObjectId) {
		this.ObjectId = ObjectId;
	} 

	public String getObjectId() {
		return ObjectId;
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
