package tableclasses;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
public class failed_jobsDAO { 
	public static void insert(failed_jobs failed_jobs, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO failed_jobs(id, uuid, connection, queue, payload, exception, failed_at) VALUES (?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, failed_jobs.getid());
		ps.setString(2, failed_jobs.getuuid());
		ps.setString(3, failed_jobs.getconnection());
		ps.setString(4, failed_jobs.getqueue());
		ps.setString(5, failed_jobs.getpayload());
		ps.setString(6, failed_jobs.getexception());
		ps.setString(7, failed_jobs.getfailed_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(failed_jobs failed_jobs, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE failed_jobs SET uuid=?, connection=?, queue=?, payload=?, exception=?, failed_at=?  WHERE id=? ");
		ps.setString(1, failed_jobs.getuuid());
		ps.setString(2, failed_jobs.getconnection());
		ps.setString(3, failed_jobs.getqueue());
		ps.setString(4, failed_jobs.getpayload());
		ps.setString(5, failed_jobs.getexception());
		ps.setString(6, failed_jobs.getfailed_at());
		ps.setString(7, failed_jobs.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static failed_jobs getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM failed_jobs WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			failed_jobs failed_jobs = new failed_jobs(
			rs.getString("id"),
			rs.getString("uuid"),
			rs.getString("connection"),
			rs.getString("queue"),
			rs.getString("payload"),
			rs.getString("exception"),
			rs.getString("failed_at")
			);
			ps.close();
			rs.close();
			return failed_jobs;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<failed_jobs> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM failed_jobs WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<failed_jobs> failed_jobsList = new ArrayList<>();
		while(rs.next()) {
			failed_jobs failed_jobs = new failed_jobs();
			failed_jobs.setid(rs.getString("id"));
			failed_jobs.setuuid(rs.getString("uuid"));
			failed_jobs.setconnection(rs.getString("connection"));
			failed_jobs.setqueue(rs.getString("queue"));
			failed_jobs.setpayload(rs.getString("payload"));
			failed_jobs.setexception(rs.getString("exception"));
			failed_jobs.setfailed_at(rs.getString("failed_at"));
			failed_jobsList.add(failed_jobs);
		}
		rs.close();
		ps.close();
		return failed_jobsList;
	} 
} 
