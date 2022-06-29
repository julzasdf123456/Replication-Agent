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
public class password_resetsDAO { 
	public static void insert(password_resets password_resets, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO password_resets(email, token, created_at) VALUES (?, ?, ?)");
		ps.setString(1, password_resets.getemail());
		ps.setString(2, password_resets.gettoken());
		ps.setString(3, password_resets.getcreated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(password_resets password_resets, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE password_resets SET token=?, created_at=?  WHERE email=? ");
		ps.setString(1, password_resets.gettoken());
		ps.setString(2, password_resets.getcreated_at());
		ps.setString(3, password_resets.getemail());
		ps.executeUpdate();
		ps.close();
	} 
	public static password_resets getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM password_resets WHERE email=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			password_resets password_resets = new password_resets(
			rs.getString("email"),
			rs.getString("token"),
			rs.getString("created_at")
			);
			ps.close();
			rs.close();
			return password_resets;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<password_resets> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM password_resets WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<password_resets> password_resetsList = new ArrayList<>();
		while(rs.next()) {
			password_resets password_resets = new password_resets();
			password_resets.setemail(rs.getString("email"));
			password_resets.settoken(rs.getString("token"));
			password_resets.setcreated_at(rs.getString("created_at"));
			password_resetsList.add(password_resets);
		}
		rs.close();
		ps.close();
		return password_resetsList;
	} 
} 
