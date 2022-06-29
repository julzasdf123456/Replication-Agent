package tableclasses;

public class CRM_ServiceConnectionTotalPayments { 
	public String id;
	public String ServiceConnectionId;
	public String SubTotal;
	public String Form2307TwoPercent;
	public String Form2307FivePercent;
	public String TotalVat;
	public String Total;
	public String Notes;
	public String created_at;
	public String updated_at;
	public CRM_ServiceConnectionTotalPayments() {
	} 
	public CRM_ServiceConnectionTotalPayments(String id, String ServiceConnectionId, String SubTotal, String Form2307TwoPercent, String Form2307FivePercent, String TotalVat, String Total, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.SubTotal = SubTotal;
		this.Form2307TwoPercent = Form2307TwoPercent;
		this.Form2307FivePercent = Form2307FivePercent;
		this.TotalVat = TotalVat;
		this.Total = Total;
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

	public void setServiceConnectionId(String ServiceConnectionId) {
		this.ServiceConnectionId = ServiceConnectionId;
	} 

	public String getServiceConnectionId() {
		return ServiceConnectionId;
	} 

	public void setSubTotal(String SubTotal) {
		this.SubTotal = SubTotal;
	} 

	public String getSubTotal() {
		return SubTotal;
	} 

	public void setForm2307TwoPercent(String Form2307TwoPercent) {
		this.Form2307TwoPercent = Form2307TwoPercent;
	} 

	public String getForm2307TwoPercent() {
		return Form2307TwoPercent;
	} 

	public void setForm2307FivePercent(String Form2307FivePercent) {
		this.Form2307FivePercent = Form2307FivePercent;
	} 

	public String getForm2307FivePercent() {
		return Form2307FivePercent;
	} 

	public void setTotalVat(String TotalVat) {
		this.TotalVat = TotalVat;
	} 

	public String getTotalVat() {
		return TotalVat;
	} 

	public void setTotal(String Total) {
		this.Total = Total;
	} 

	public String getTotal() {
		return Total;
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
