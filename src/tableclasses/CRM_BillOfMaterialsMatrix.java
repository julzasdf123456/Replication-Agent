package tableclasses;

public class CRM_BillOfMaterialsMatrix { 
	public String id;
	public String ServiceConnectionId;
	public String StructureAssigningId;
	public String StructureId;
	public String MaterialsId;
	public String Quantity;
	public String created_at;
	public String updated_at;
	public String StructureType;
	public String Amount;
	public CRM_BillOfMaterialsMatrix() {
	} 
	public CRM_BillOfMaterialsMatrix(String id, String ServiceConnectionId, String StructureAssigningId, String StructureId, String MaterialsId, String Quantity, String created_at, String updated_at, String StructureType, String Amount) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.StructureAssigningId = StructureAssigningId;
		this.StructureId = StructureId;
		this.MaterialsId = MaterialsId;
		this.Quantity = Quantity;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.StructureType = StructureType;
		this.Amount = Amount;
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

	public void setStructureAssigningId(String StructureAssigningId) {
		this.StructureAssigningId = StructureAssigningId;
	} 

	public String getStructureAssigningId() {
		return StructureAssigningId;
	} 

	public void setStructureId(String StructureId) {
		this.StructureId = StructureId;
	} 

	public String getStructureId() {
		return StructureId;
	} 

	public void setMaterialsId(String MaterialsId) {
		this.MaterialsId = MaterialsId;
	} 

	public String getMaterialsId() {
		return MaterialsId;
	} 

	public void setQuantity(String Quantity) {
		this.Quantity = Quantity;
	} 

	public String getQuantity() {
		return Quantity;
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

	public void setStructureType(String StructureType) {
		this.StructureType = StructureType;
	} 

	public String getStructureType() {
		return StructureType;
	} 

	public void setAmount(String Amount) {
		this.Amount = Amount;
	} 

	public String getAmount() {
		return Amount;
	} 

} 
