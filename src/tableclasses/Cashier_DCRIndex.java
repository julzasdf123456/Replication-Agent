package tableclasses;

public class Cashier_DCRIndex { 
	public String id;
	public String GLCode;
	public String NEACode;
	public String TableName;
	public String Columns;
	public String created_at;
	public String updated_at;
	public String TownCode;
	public Cashier_DCRIndex() {
	} 
	public Cashier_DCRIndex(String id, String GLCode, String NEACode, String TableName, String Columns, String created_at, String updated_at, String TownCode) {
		this.id = id;
		this.GLCode = GLCode;
		this.NEACode = NEACode;
		this.TableName = TableName;
		this.Columns = Columns;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.TownCode = TownCode;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setGLCode(String GLCode) {
		this.GLCode = GLCode;
	} 

	public String getGLCode() {
		return GLCode;
	} 

	public void setNEACode(String NEACode) {
		this.NEACode = NEACode;
	} 

	public String getNEACode() {
		return NEACode;
	} 

	public void setTableName(String TableName) {
		this.TableName = TableName;
	} 

	public String getTableName() {
		return TableName;
	} 

	public void setColumns(String Columns) {
		this.Columns = Columns;
	} 

	public String getColumns() {
		return Columns;
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

	public void setTownCode(String TownCode) {
		this.TownCode = TownCode;
	} 

	public String getTownCode() {
		return TownCode;
	} 

} 
