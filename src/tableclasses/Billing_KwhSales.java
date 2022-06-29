package tableclasses;

public class Billing_KwhSales { 
	public String id;
	public String ServicePeriod;
	public String Town;
	public String BilledKwh;
	public String ConsumedKwh;
	public String NoOfConsumers;
	public String Notes;
	public String created_at;
	public String updated_at;
	public Billing_KwhSales() {
	} 
	public Billing_KwhSales(String id, String ServicePeriod, String Town, String BilledKwh, String ConsumedKwh, String NoOfConsumers, String Notes, String created_at, String updated_at) {
		this.id = id;
		this.ServicePeriod = ServicePeriod;
		this.Town = Town;
		this.BilledKwh = BilledKwh;
		this.ConsumedKwh = ConsumedKwh;
		this.NoOfConsumers = NoOfConsumers;
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

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setTown(String Town) {
		this.Town = Town;
	} 

	public String getTown() {
		return Town;
	} 

	public void setBilledKwh(String BilledKwh) {
		this.BilledKwh = BilledKwh;
	} 

	public String getBilledKwh() {
		return BilledKwh;
	} 

	public void setConsumedKwh(String ConsumedKwh) {
		this.ConsumedKwh = ConsumedKwh;
	} 

	public String getConsumedKwh() {
		return ConsumedKwh;
	} 

	public void setNoOfConsumers(String NoOfConsumers) {
		this.NoOfConsumers = NoOfConsumers;
	} 

	public String getNoOfConsumers() {
		return NoOfConsumers;
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
