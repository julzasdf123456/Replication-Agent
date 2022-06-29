package tableclasses;

public class CRM_TransformersAssignedMatrix { 
	public String id;
	public String ServiceConnectionId;
	public String MaterialsId;
	public String Quantity;
	public String created_at;
	public String updated_at;
	public String Type;
	public String Amount;
	public CRM_TransformersAssignedMatrix() {
	} 
	public CRM_TransformersAssignedMatrix(String id, String ServiceConnectionId, String MaterialsId, String Quantity, String created_at, String updated_at, String Type, String Amount) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.MaterialsId = MaterialsId;
		this.Quantity = Quantity;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.Type = Type;
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

	public void setType(String Type) {
		this.Type = Type;
	} 

	public String getType() {
		return Type;
	} 

	public void setAmount(String Amount) {
		this.Amount = Amount;
	} 

	public String getAmount() {
		return Amount;
	} 

} 
