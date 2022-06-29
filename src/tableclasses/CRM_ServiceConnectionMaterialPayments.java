package tableclasses;

public class CRM_ServiceConnectionMaterialPayments { 
	public String id;
	public String ServiceConnectionId;
	public String Material;
	public String Quantity;
	public String Vat;
	public String Total;
	public String created_at;
	public String updated_at;
	public CRM_ServiceConnectionMaterialPayments() {
	} 
	public CRM_ServiceConnectionMaterialPayments(String id, String ServiceConnectionId, String Material, String Quantity, String Vat, String Total, String created_at, String updated_at) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.Material = Material;
		this.Quantity = Quantity;
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

	public void setMaterial(String Material) {
		this.Material = Material;
	} 

	public String getMaterial() {
		return Material;
	} 

	public void setQuantity(String Quantity) {
		this.Quantity = Quantity;
	} 

	public String getQuantity() {
		return Quantity;
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
