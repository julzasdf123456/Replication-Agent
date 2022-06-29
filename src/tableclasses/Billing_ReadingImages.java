package tableclasses;

public class Billing_ReadingImages { 
	public String id;
	public String Photo;
	public String ReadingId;
	public String Notes;
	public String created_at;
	public String updated_at;
	public String ServicePeriod;
	public String AccountNumber;
	public Billing_ReadingImages() {
	} 
	public Billing_ReadingImages(String id, String Photo, String ReadingId, String Notes, String created_at, String updated_at, String ServicePeriod, String AccountNumber) {
		this.id = id;
		this.Photo = Photo;
		this.ReadingId = ReadingId;
		this.Notes = Notes;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.ServicePeriod = ServicePeriod;
		this.AccountNumber = AccountNumber;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setPhoto(String Photo) {
		this.Photo = Photo;
	} 

	public String getPhoto() {
		return Photo;
	} 

	public void setReadingId(String ReadingId) {
		this.ReadingId = ReadingId;
	} 

	public String getReadingId() {
		return ReadingId;
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

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setAccountNumber(String AccountNumber) {
		this.AccountNumber = AccountNumber;
	} 

	public String getAccountNumber() {
		return AccountNumber;
	} 

} 
