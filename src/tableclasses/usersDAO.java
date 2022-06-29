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
public class usersDAO { 
	public static void insert(users users, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO users(id, username, name, email, email_verified_at, password, remember_token, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, users.getid());
		ps.setString(2, users.getusername());
		ps.setString(3, users.getname());
		ps.setString(4, users.getemail());
		ps.setString(5, users.getemail_verified_at());
		ps.setString(6, users.getpassword());
		ps.setString(7, users.getremember_token());
		ps.setString(8, users.getcreated_at());
		ps.setString(9, users.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(users users, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE users SET username=?, name=?, email=?, email_verified_at=?, password=?, remember_token=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, users.getusername());
		ps.setString(2, users.getname());
		ps.setString(3, users.getemail());
		ps.setString(4, users.getemail_verified_at());
		ps.setString(5, users.getpassword());
		ps.setString(6, users.getremember_token());
		ps.setString(7, users.getcreated_at());
		ps.setString(8, users.getupdated_at());
		ps.setString(9, users.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static users getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			users users = new users(
			rs.getString("id"),
			rs.getString("username"),
			rs.getString("name"),
			rs.getString("email"),
			rs.getString("email_verified_at"),
			rs.getString("password"),
			rs.getString("remember_token"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return users;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<users> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<users> usersList = new ArrayList<>();
		while(rs.next()) {
			users users = new users();
			users.setid(rs.getString("id"));
			users.setusername(rs.getString("username"));
			users.setname(rs.getString("name"));
			users.setemail(rs.getString("email"));
			users.setemail_verified_at(rs.getString("email_verified_at"));
			users.setpassword(rs.getString("password"));
			users.setremember_token(rs.getString("remember_token"));
			users.setcreated_at(rs.getString("created_at"));
			users.setupdated_at(rs.getString("updated_at"));
			usersList.add(users);
		}
		rs.close();
		ps.close();
		return usersList;
	} 
} 
