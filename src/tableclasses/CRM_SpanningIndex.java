package tableclasses;

public class CRM_SpanningIndex { 
	public String id;
	public String NeaCode;
	public String Structure;
	public String Description;
	public String Size;
	public String Type;
	public String SpliceNeaCode;
	public String created_at;
	public String updated_at;
	public CRM_SpanningIndex() {
	} 
	public CRM_SpanningIndex(String id, String NeaCode, String Structure, String Description, String Size, String Type, String SpliceNeaCode, String created_at, String updated_at) {
		this.id = id;
		this.NeaCode = NeaCode;
		this.Structure = Structure;
		this.Description = Description;
		this.Size = Size;
		this.Type = Type;
		this.SpliceNeaCode = SpliceNeaCode;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setNeaCode(String NeaCode) {
		this.NeaCode = NeaCode;
	} 

	public String getNeaCode() {
		return NeaCode;
	} 

	public void setStructure(String Structure) {
		this.Structure = Structure;
	} 

	public String getStructure() {
		return Structure;
	} 

	public void setDescription(String Description) {
		this.Description = Description;
	} 

	public String getDescription() {
		return Description;
	} 

	public void setSize(String Size) {
		this.Size = Size;
	} 

	public String getSize() {
		return Size;
	} 

	public void setType(String Type) {
		this.Type = Type;
	} 

	public String getType() {
		return Type;
	} 

	public void setSpliceNeaCode(String SpliceNeaCode) {
		this.SpliceNeaCode = SpliceNeaCode;
	} 

	public String getSpliceNeaCode() {
		return SpliceNeaCode;
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
