package tableclasses;

public class Cashier_AccountPayables { 
	public String id;
	public String AccountCode;
	public String AccountTitle;
	public String AccountDescription;
	public String DefaultAmount;
	public String VATPercentage;
	public String Notes;
	public String created_at;
	public String updated_at;
	public Cashier_AccountPayables() {
	} 
	public Cashier_AccountPayables(String id, String AccountCode, String AccountTitle, String AccountDescription, String DefaultAmount, String VATPercentage, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.AccountCode = AccountCode;
		this.AccountTitle = AccountTitle;
		this.AccountDescription = AccountDescription;
		this.DefaultAmount = DefaultAmount;
		this.VATPercentage = VATPercentage;
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

	public void setAccountCode(String AccountCode) {
		this.AccountCode = AccountCode;
	} 

	public String getAccountCode() {
		return AccountCode;
	} 

	public void setAccountTitle(String AccountTitle) {
		this.AccountTitle = AccountTitle;
	} 

	public String getAccountTitle() {
		return AccountTitle;
	} 

	public void setAccountDescription(String AccountDescription) {
		this.AccountDescription = AccountDescription;
	} 

	public String getAccountDescription() {
		return AccountDescription;
	} 

	public void setDefaultAmount(String DefaultAmount) {
		this.DefaultAmount = DefaultAmount;
	} 

	public String getDefaultAmount() {
		return DefaultAmount;
	} 

	public void setVATPercentage(String VATPercentage) {
		this.VATPercentage = VATPercentage;
	} 

	public String getVATPercentage() {
		return VATPercentage;
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
