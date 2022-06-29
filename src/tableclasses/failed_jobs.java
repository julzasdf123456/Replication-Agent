package tableclasses;

public class failed_jobs { 
	public String id;
	public String uuid;
	public String connection;
	public String queue;
	public String payload;
	public String exception;
	public String failed_at;
	public failed_jobs() {
	} 
	public failed_jobs(String id, String uuid, String connection, String queue, String payload, String exception, String failed_at) {
		this.id = id;
		this.uuid = uuid;
		this.connection = connection;
		this.queue = queue;
		this.payload = payload;
		this.exception = exception;
		this.failed_at = failed_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setuuid(String uuid) {
		this.uuid = uuid;
	} 

	public String getuuid() {
		return uuid;
	} 

	public void setconnection(String connection) {
		this.connection = connection;
	} 

	public String getconnection() {
		return connection;
	} 

	public void setqueue(String queue) {
		this.queue = queue;
	} 

	public String getqueue() {
		return queue;
	} 

	public void setpayload(String payload) {
		this.payload = payload;
	} 

	public String getpayload() {
		return payload;
	} 

	public void setexception(String exception) {
		this.exception = exception;
	} 

	public String getexception() {
		return exception;
	} 

	public void setfailed_at(String failed_at) {
		this.failed_at = failed_at;
	} 

	public String getfailed_at() {
		return failed_at;
	} 

} 
