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
public class role_has_permissionsDAO { 
	public static void insert(role_has_permissions role_has_permissions, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO role_has_permissions(permission_id, role_id) VALUES (?, ?)");
		ps.setString(1, role_has_permissions.getpermission_id());
		ps.setString(2, role_has_permissions.getrole_id());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(role_has_permissions role_has_permissions, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE role_has_permissions SET role_id=?  WHERE permission_id=? ");
		ps.setString(1, role_has_permissions.getrole_id());
		ps.setString(2, role_has_permissions.getpermission_id());
		ps.executeUpdate();
		ps.close();
	} 
	public static role_has_permissions getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM role_has_permissions WHERE permission_id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			role_has_permissions role_has_permissions = new role_has_permissions(
			rs.getString("permission_id"),
			rs.getString("role_id")
			);
			ps.close();
			rs.close();
			return role_has_permissions;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<role_has_permissions> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM role_has_permissions WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<role_has_permissions> role_has_permissionsList = new ArrayList<>();
		while(rs.next()) {
			role_has_permissions role_has_permissions = new role_has_permissions();
			role_has_permissions.setpermission_id(rs.getString("permission_id"));
			role_has_permissions.setrole_id(rs.getString("role_id"));
			role_has_permissionsList.add(role_has_permissions);
		}
		rs.close();
		ps.close();
		return role_has_permissionsList;
	} 
} 
