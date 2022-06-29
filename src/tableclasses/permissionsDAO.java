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
public class permissionsDAO { 
	public static void insert(permissions permissions, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO permissions(id, name, guard_name, created_at, updated_at) VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, permissions.getid());
		ps.setString(2, permissions.getname());
		ps.setString(3, permissions.getguard_name());
		ps.setString(4, permissions.getcreated_at());
		ps.setString(5, permissions.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(permissions permissions, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE permissions SET name=?, guard_name=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, permissions.getname());
		ps.setString(2, permissions.getguard_name());
		ps.setString(3, permissions.getcreated_at());
		ps.setString(4, permissions.getupdated_at());
		ps.setString(5, permissions.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static permissions getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM permissions WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			permissions permissions = new permissions(
			rs.getString("id"),
			rs.getString("name"),
			rs.getString("guard_name"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return permissions;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<permissions> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM permissions WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<permissions> permissionsList = new ArrayList<>();
		while(rs.next()) {
			permissions permissions = new permissions();
			permissions.setid(rs.getString("id"));
			permissions.setname(rs.getString("name"));
			permissions.setguard_name(rs.getString("guard_name"));
			permissions.setcreated_at(rs.getString("created_at"));
			permissions.setupdated_at(rs.getString("updated_at"));
			permissionsList.add(permissions);
		}
		rs.close();
		ps.close();
		return permissionsList;
	} 
} 
