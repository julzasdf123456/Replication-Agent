package tableclasses;

public class CRM_MaterialsMatrix { 
	public String id;
	public String StructureId;
	public String MaterialsId;
	public String Quantity;
	public String created_at;
	public String updated_at;
	public CRM_MaterialsMatrix() {
	} 
	public CRM_MaterialsMatrix(String id, String StructureId, String MaterialsId, String Quantity, String created_at, String updated_at) {
		this.id = id;
		this.StructureId = StructureId;
		this.MaterialsId = MaterialsId;
		this.Quantity = Quantity;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
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

} 
