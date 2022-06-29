package tableclasses;

public class CRM_TicketLogs { 
	public String id;
	public String TicketId;
	public String Log;
	public String LogDetails;
	public String LogType;
	public String UserId;
	public String created_at;
	public String updated_at;
	public CRM_TicketLogs() {
	} 
	public CRM_TicketLogs(String id, String TicketId, String Log, String LogDetails, String LogType, String UserId, String created_at, String updated_at) {
		this.id = id;
		this.TicketId = TicketId;
		this.Log = Log;
		this.LogDetails = LogDetails;
		this.LogType = LogType;
		this.UserId = UserId;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setTicketId(String TicketId) {
		this.TicketId = TicketId;
	} 

	public String getTicketId() {
		return TicketId;
	} 

	public void setLog(String Log) {
		this.Log = Log;
	} 

	public String getLog() {
		return Log;
	} 

	public void setLogDetails(String LogDetails) {
		this.LogDetails = LogDetails;
	} 

	public String getLogDetails() {
		return LogDetails;
	} 

	public void setLogType(String LogType) {
		this.LogType = LogType;
	} 

	public String getLogType() {
		return LogType;
	} 

	public void setUserId(String UserId) {
		this.UserId = UserId;
	} 

	public String getUserId() {
		return UserId;
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
