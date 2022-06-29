package tableclasses;

public class CRM_SpanninData { 
	public String id;
	public String ServiceConnectionId;
	public String PrimarySpan;
	public String PrimarySize;
	public String PrimaryType;
	public String NeutralSpan;
	public String NeutralSize;
	public String NeutralType;
	public String SecondarySpan;
	public String SecondarySize;
	public String SecondaryType;
	public String SDWSpan;
	public String SDWSize;
	public String SDWType;
	public String created_at;
	public String updated_at;
	public CRM_SpanninData() {
	} 
	public CRM_SpanninData(String id, String ServiceConnectionId, String PrimarySpan, String PrimarySize, String PrimaryType, String NeutralSpan, String NeutralSize, String NeutralType, String SecondarySpan, String SecondarySize, String SecondaryType, String SDWSpan, String SDWSize, String SDWType, String created_at, String updated_at) {
		this.id = id;
		this.ServiceConnectionId = ServiceConnectionId;
		this.PrimarySpan = PrimarySpan;
		this.PrimarySize = PrimarySize;
		this.PrimaryType = PrimaryType;
		this.NeutralSpan = NeutralSpan;
		this.NeutralSize = NeutralSize;
		this.NeutralType = NeutralType;
		this.SecondarySpan = SecondarySpan;
		this.SecondarySize = SecondarySize;
		this.SecondaryType = SecondaryType;
		this.SDWSpan = SDWSpan;
		this.SDWSize = SDWSize;
		this.SDWType = SDWType;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setServiceConnectionId(String ServiceConnectionId) {
		this.ServiceConnectionId = ServiceConnectionId;
	} 

	public String getServiceConnectionId() {
		return ServiceConnectionId;
	} 

	public void setPrimarySpan(String PrimarySpan) {
		this.PrimarySpan = PrimarySpan;
	} 

	public String getPrimarySpan() {
		return PrimarySpan;
	} 

	public void setPrimarySize(String PrimarySize) {
		this.PrimarySize = PrimarySize;
	} 

	public String getPrimarySize() {
		return PrimarySize;
	} 

	public void setPrimaryType(String PrimaryType) {
		this.PrimaryType = PrimaryType;
	} 

	public String getPrimaryType() {
		return PrimaryType;
	} 

	public void setNeutralSpan(String NeutralSpan) {
		this.NeutralSpan = NeutralSpan;
	} 

	public String getNeutralSpan() {
		return NeutralSpan;
	} 

	public void setNeutralSize(String NeutralSize) {
		this.NeutralSize = NeutralSize;
	} 

	public String getNeutralSize() {
		return NeutralSize;
	} 

	public void setNeutralType(String NeutralType) {
		this.NeutralType = NeutralType;
	} 

	public String getNeutralType() {
		return NeutralType;
	} 

	public void setSecondarySpan(String SecondarySpan) {
		this.SecondarySpan = SecondarySpan;
	} 

	public String getSecondarySpan() {
		return SecondarySpan;
	} 

	public void setSecondarySize(String SecondarySize) {
		this.SecondarySize = SecondarySize;
	} 

	public String getSecondarySize() {
		return SecondarySize;
	} 

	public void setSecondaryType(String SecondaryType) {
		this.SecondaryType = SecondaryType;
	} 

	public String getSecondaryType() {
		return SecondaryType;
	} 

	public void setSDWSpan(String SDWSpan) {
		this.SDWSpan = SDWSpan;
	} 

	public String getSDWSpan() {
		return SDWSpan;
	} 

	public void setSDWSize(String SDWSize) {
		this.SDWSize = SDWSize;
	} 

	public String getSDWSize() {
		return SDWSize;
	} 

	public void setSDWType(String SDWType) {
		this.SDWType = SDWType;
	} 

	public String getSDWType() {
		return SDWType;
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
