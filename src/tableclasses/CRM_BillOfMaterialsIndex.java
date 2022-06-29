package tableclasses;

public class CRM_BillOfMaterialsIndex { 
	public String id;
	public String ServiceConnectionId;
	public String Date;
	public String SubTotal;
	public String LaborCost;
	public String Others;
	public String Total;
	public String created_at;
	public String updated_at;
	public CRM_BillOfMaterialsIndex() {
	} 
	public CRM_BillOfMaterialsIndex(String id, String ServiceConnectionId, String Date, String SubTotal, String LaborCost, String Others, String Total, String created_at, String updated_at) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.Date = Date;
		this.SubTotal = SubTotal;
		this.LaborCost = LaborCost;
		this.Others = Others;
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

	public void setDate(String Date) {
		this.Date = Date;
	} 

	public String getDate() {
		return Date;
	} 

	public void setSubTotal(String SubTotal) {
		this.SubTotal = SubTotal;
	} 

	public String getSubTotal() {
		return SubTotal;
	} 

	public void setLaborCost(String LaborCost) {
		this.LaborCost = LaborCost;
	} 

	public String getLaborCost() {
		return LaborCost;
	} 

	public void setOthers(String Others) {
		this.Others = Others;
	} 

	public String getOthers() {
		return Others;
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
