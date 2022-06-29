package tableclasses;

public class CRM_MemberConsumerImages { 
	public String id;
	public String ConsumerId;
	public String PicturePath;
	public String created_at;
	public String updated_at;
	public String HexImage;
	public CRM_MemberConsumerImages() {
	} 
	public CRM_MemberConsumerImages(String id, String ConsumerId, String PicturePath, String created_at, String updated_at, String HexImage) {
		this.id = id;
		this.ConsumerId = ConsumerId;
		this.PicturePath = PicturePath;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.HexImage = HexImage;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setConsumerId(String ConsumerId) {
		this.ConsumerId = ConsumerId;
	} 

	public String getConsumerId() {
		return ConsumerId;
	} 

	public void setPicturePath(String PicturePath) {
		this.PicturePath = PicturePath;
	} 

	public String getPicturePath() {
		return PicturePath;
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

	public void setHexImage(String HexImage) {
		this.HexImage = HexImage;
	} 

	public String getHexImage() {
		return HexImage;
	} 

} 
