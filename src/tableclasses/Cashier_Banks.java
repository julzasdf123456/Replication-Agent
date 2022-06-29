package tableclasses;

public class Cashier_Banks { 
	public String id;
	public String BankFullName;
	public String BankAbbrev;
	public String Address;
	public String TIN;
	public String created_at;
	public String updated_at;
	public Cashier_Banks() {
	} 
	public Cashier_Banks(String id, String BankFullName, String BankAbbrev, String Address, String TIN, String created_at, String updated_at) {
		this.id = id;
		this.BankFullName = BankFullName;
		this.BankAbbrev = BankAbbrev;
		this.Address = Address;
		this.TIN = TIN;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setBankFullName(String BankFullName) {
		this.BankFullName = BankFullName;
	} 

	public String getBankFullName() {
		return BankFullName;
	} 

	public void setBankAbbrev(String BankAbbrev) {
		this.BankAbbrev = BankAbbrev;
	} 

	public String getBankAbbrev() {
		return BankAbbrev;
	} 

	public void setAddress(String Address) {
		this.Address = Address;
	} 

	public String getAddress() {
		return Address;
	} 

	public void setTIN(String TIN) {
		this.TIN = TIN;
	} 

	public String getTIN() {
		return TIN;
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
