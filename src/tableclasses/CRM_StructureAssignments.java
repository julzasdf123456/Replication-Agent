package tableclasses;

public class CRM_StructureAssignments { 
	public String id;
	public String ServiceConnectionId;
	public String StructureId;
	public String created_at;
	public String updated_at;
	public String Quantity;
	public String Type;
	public String ConAssGrouping;
	public CRM_StructureAssignments() {
	} 
	public CRM_StructureAssignments(String id, String ServiceConnectionId, String StructureId, String created_at, String updated_at, String Quantity, String Type, String ConAssGrouping) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.StructureId = StructureId;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.Quantity = Quantity;
		this.Type = Type;
		this.ConAssGrouping = ConAssGrouping;
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

	public void setStructureId(String StructureId) {
		this.StructureId = StructureId;
	} 

	public String getStructureId() {
		return StructureId;
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

	public void setQuantity(String Quantity) {
		this.Quantity = Quantity;
	} 

	public String getQuantity() {
		return Quantity;
	} 

	public void setType(String Type) {
		this.Type = Type;
	} 

	public String getType() {
		return Type;
	} 

	public void setConAssGrouping(String ConAssGrouping) {
		this.ConAssGrouping = ConAssGrouping;
	} 

	public String getConAssGrouping() {
		return ConAssGrouping;
	} 

} 
