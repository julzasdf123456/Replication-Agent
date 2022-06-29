package tableclasses;

public class migrations { 
	public String id;
	public String migration;
	public String batch;
	public migrations() {
	} 
	public migrations(String id, String migration, String batch) {
		this.id = id;
		this.migration = migration;
		this.batch = batch;
	} 

	public void setid(String id) {
		this.id = id;
	} 

	public String getid() {
		return id;
	} 

	public void setmigration(String migration) {
		this.migration = migration;
	} 

	public String getmigration() {
		return migration;
	} 

	public void setbatch(String batch) {
		this.batch = batch;
	} 

	public String getbatch() {
		return batch;
	} 

} 
