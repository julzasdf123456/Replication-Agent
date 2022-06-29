package tableclasses;

public class Cashier_BAPAAdjustments { 
	public String id;
	public String BAPAName;
	public String ServicePeriod;
	public String DiscountPercentage;
	public String DiscountAmount;
	public String NumberOfConsumers;
	public String SubTotal;
	public String NetAmount;
	public String UserId;
	public String Route;
	public String created_at;
	public String updated_at;
	public String Status;
	public Cashier_BAPAAdjustments() {
	} 
	public Cashier_BAPAAdjustments(String id, String BAPAName, String ServicePeriod, String DiscountPercentage, String DiscountAmount, String NumberOfConsumers, String SubTotal, String NetAmount, String UserId, String Route, String created_at, String updated_at, String Status) {
		this.id = id;
		this.BAPAName = BAPAName;
		this.ServicePeriod = ServicePeriod;
		this.DiscountPercentage = DiscountPercentage;
		this.DiscountAmount = DiscountAmount;
		this.NumberOfConsumers = NumberOfConsumers;
		this.SubTotal = SubTotal;
		this.NetAmount = NetAmount;
		this.UserId = UserId;
		this.Route = Route;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.Status = Status;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setBAPAName(String BAPAName) {
		this.BAPAName = BAPAName;
	} 

	public String getBAPAName() {
		return BAPAName;
	} 

	public void setServicePeriod(String ServicePeriod) {
		this.ServicePeriod = ServicePeriod;
	} 

	public String getServicePeriod() {
		return ServicePeriod;
	} 

	public void setDiscountPercentage(String DiscountPercentage) {
		this.DiscountPercentage = DiscountPercentage;
	} 

	public String getDiscountPercentage() {
		return DiscountPercentage;
	} 

	public void setDiscountAmount(String DiscountAmount) {
		this.DiscountAmount = DiscountAmount;
	} 

	public String getDiscountAmount() {
		return DiscountAmount;
	} 

	public void setNumberOfConsumers(String NumberOfConsumers) {
		this.NumberOfConsumers = NumberOfConsumers;
	} 

	public String getNumberOfConsumers() {
		return NumberOfConsumers;
	} 

	public void setSubTotal(String SubTotal) {
		this.SubTotal = SubTotal;
	} 

	public String getSubTotal() {
		return SubTotal;
	} 

	public void setNetAmount(String NetAmount) {
		this.NetAmount = NetAmount;
	} 

	public String getNetAmount() {
		return NetAmount;
	} 

	public void setUserId(String UserId) {
		this.UserId = UserId;
	} 

	public String getUserId() {
		return UserId;
	} 

	public void setRoute(String Route) {
		this.Route = Route;
	} 

	public String getRoute() {
		return Route;
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

	public void setStatus(String Status) {
		this.Status = Status;
	} 

	public String getStatus() {
		return Status;
	} 

} 
