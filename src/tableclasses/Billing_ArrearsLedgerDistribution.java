package tableclasses;

public class Billing_ArrearsLedgerDistribution { 
	public String id;
	public String AccountNumber;
	public String ServicePeriod;
	public String Amount;
	public String IsBilled;
	public String IsPaid;
	public String LinkedBillNumber;
	public String Notes;
	public String created_at;
	public String updated_at;
	public Billing_ArrearsLedgerDistribution() {
	} 
	public Billing_ArrearsLedgerDistribution(String id, String AccountNumber, String ServicePeriod, String Amount, String IsBilled, String IsPaid, String LinkedBillNumber, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.AccountNumber = AccountNumber;
		this.ServicePeriod = ServicePeriod;
		this.Amount = Amount;
		this.IsBilled = IsBilled;
		this.IsPaid = IsPaid;
		this.LinkedBillNumber = LinkedBillNumber;
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

	public void setAccountNumber(String AccountNumber) {
		this.AccountNumber = AccountNumber;
	} 

	public String getAccountNumber() {
		return AccountNumber;
	} 

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setAmount(String Amount) {
		this.Amount = Amount;
	} 

	public String getAmount() {
		return Amount;
	} 

	public void setIsBilled(String IsBilled) {
		this.IsBilled = IsBilled;
	} 

	public String getIsBilled() {
		return IsBilled;
	} 

	public void setIsPaid(String IsPaid) {
		this.IsPaid = IsPaid;
	} 

	public String getIsPaid() {
		return IsPaid;
	} 

	public void setLinkedBillNumber(String LinkedBillNumber) {
		this.LinkedBillNumber = LinkedBillNumber;
	} 

	public String getLinkedBillNumber() {
		return LinkedBillNumber;
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
