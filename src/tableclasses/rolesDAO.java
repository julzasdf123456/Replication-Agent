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
public class rolesDAO { 
	public static void insert(roles roles, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO roles(id, name, guard_name, created_at, updated_at) VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, roles.getid());
		ps.setString(2, roles.getname());
		ps.setString(3, roles.getguard_name());
		ps.setString(4, roles.getcreated_at());
		ps.setString(5, roles.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(roles roles, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE roles SET name=?, guard_name=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, roles.getname());
		ps.setString(2, roles.getguard_name());
		ps.setString(3, roles.getcreated_at());
		ps.setString(4, roles.getupdated_at());
		ps.setString(5, roles.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static roles getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM roles WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			roles roles = new roles(
			rs.getString("id"),
			rs.getString("name"),
			rs.getString("guard_name"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return roles;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<roles> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM roles WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<roles> rolesList = new ArrayList<>();
		while(rs.next()) {
			roles roles = new roles();
			roles.setid(rs.getString("id"));
			roles.setname(rs.getString("name"));
			roles.setguard_name(rs.getString("guard_name"));
			roles.setcreated_at(rs.getString("created_at"));
			roles.setupdated_at(rs.getString("updated_at"));
			rolesList.add(roles);
		}
		rs.close();
		ps.close();
		return rolesList;
	} 
} 
