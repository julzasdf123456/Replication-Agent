package tableclasses;

public class CRM_BillOfMaterialsDetails { 
	public String id;
	public String BillOfMaterialsId;
	public String NeaCode;
	public String Description;
	public String Rate;
	public String Quantity;
	public String Amount;
	public String created_at;
	public String updated_at;
	public CRM_BillOfMaterialsDetails() {
	} 
	public CRM_BillOfMaterialsDetails(String id, String BillOfMaterialsId, String NeaCode, String Description, String Rate, String Quantity, String Amount, String created_at, String updated_at) {
		this.id = id;
		this.BillOfMaterialsId = BillOfMaterialsId;
		this.NeaCode = NeaCode;
		this.Description = Description;
		this.Rate = Rate;
		this.Quantity = Quantity;
		this.Amount = Amount;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setBillOfMaterialsId(String BillOfMaterialsId) {
		this.BillOfMaterialsId = BillOfMaterialsId;
	} 

	public String getBillOfMaterialsId() {
		return BillOfMaterialsId;
	} 

	public void setNeaCode(String NeaCode) {
		this.NeaCode = NeaCode;
	} 

	public String getNeaCode() {
		return NeaCode;
	} 

	public void setDescription(String Description) {
		this.Description = Description;
	} 

	public String getDescription() {
		return Description;
	} 

	public void setRate(String Rate) {
		this.Rate = Rate;
	} 

	public String getRate() {
		return Rate;
	} 

	public void setQuantity(String Quantity) {
		this.Quantity = Quantity;
	} 

	public String getQuantity() {
		return Quantity;
	} 

	public void setAmount(String Amount) {
		this.Amount = Amount;
	} 

	public String getAmount() {
		return Amount;
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
