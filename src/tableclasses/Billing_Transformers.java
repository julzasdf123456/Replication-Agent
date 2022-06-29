package tableclasses;

public class Billing_Transformers { 
	public String id;
	public String ServiceAccountId;
	public String TransformerNumber;
	public String Rating;
	public String RentalFee;
	public String Load;
	public String created_at;
	public String updated_at;
	public Billing_Transformers() {
	} 
	public Billing_Transformers(String id, String ServiceAccountId, String TransformerNumber, String Rating, String RentalFee, String Load, String created_at, String updated_at) {
		this.id = id;
		this.ServiceAccountId = ServiceAccountId;
		this.TransformerNumber = TransformerNumber;
		this.Rating = Rating;
		this.RentalFee = RentalFee;
		this.Load = Load;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setServiceAccountId(String ServiceAccountId) {
		this.ServiceAccountId = ServiceAccountId;
	} 

	public String getServiceAccountId() {
		return ServiceAccountId;
	} 

	public void setTransformerNumber(String TransformerNumber) {
		this.TransformerNumber = TransformerNumber;
	} 

	public String getTransformerNumber() {
		return TransformerNumber;
	} 

	public void setRating(String Rating) {
		this.Rating = Rating;
	} 

	public String getRating() {
		return Rating;
	} 

	public void setRentalFee(String RentalFee) {
		this.RentalFee = RentalFee;
	} 

	public String getRentalFee() {
		return RentalFee;
	} 

	public void setLoad(String Load) {
		this.Load = Load;
	} 

	public String getLoad() {
		return Load;
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
