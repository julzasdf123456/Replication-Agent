package tableclasses;

public class CRM_ServiceConnectionParticularPaymentsTransactions { 
	public String id;
	public String ServiceConnectionId;
	public String Particular;
	public String Amount;
	public String Vat;
	public String Total;
	public String created_at;
	public String updated_at;
	public CRM_ServiceConnectionParticularPaymentsTransactions() {
	} 
	public CRM_ServiceConnectionParticularPaymentsTransactions(String id, String ServiceConnectionId, String Particular, String Amount, String Vat, String Total, String created_at, String updated_at) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.Particular = Particular;
		this.Amount = Amount;
		this.Vat = Vat;
		this.Total = Total;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setServiceConnectionId(String ServiceConnectionId) {
		this.ServiceConnectionId = ServiceConnectionId;
	} 

	public String getServiceConnectionId() {
		return ServiceConnectionId;
	} 

	public void setParticular(String Particular) {
		this.Particular = Particular;
	} 

	public String getParticular() {
		return Particular;
	} 

	public void setAmount(String Amount) {
		this.Amount = Amount;
	} 

	public String getAmount() {
		return Amount;
	} 

	public void setVat(String Vat) {
		this.Vat = Vat;
	} 

	public String getVat() {
		return Vat;
	} 

	public void setTotal(String Total) {
		this.Total = Total;
	} 

	public String getTotal() {
		return Total;
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
