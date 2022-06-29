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
public class model_has_permissionsDAO { 
	public static void insert(model_has_permissions model_has_permissions, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO model_has_permissions(permission_id, model_type, model_id) VALUES (?, ?, ?)");
		ps.setString(1, model_has_permissions.getpermission_id());
		ps.setString(2, model_has_permissions.getmodel_type());
		ps.setString(3, model_has_permissions.getmodel_id());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(model_has_permissions model_has_permissions, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE model_has_permissions SET model_type=?, model_id=?  WHERE permission_id=? ");
		ps.setString(1, model_has_permissions.getmodel_type());
		ps.setString(2, model_has_permissions.getmodel_id());
		ps.setString(3, model_has_permissions.getpermission_id());
		ps.executeUpdate();
		ps.close();
	} 
	public static model_has_permissions getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM model_has_permissions WHERE permission_id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			model_has_permissions model_has_permissions = new model_has_permissions(
			rs.getString("permission_id"),
			rs.getString("model_type"),
			rs.getString("model_id")
			);
			ps.close();
			rs.close();
			return model_has_permissions;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<model_has_permissions> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM model_has_permissions WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<model_has_permissions> model_has_permissionsList = new ArrayList<>();
		while(rs.next()) {
			model_has_permissions model_has_permissions = new model_has_permissions();
			model_has_permissions.setpermission_id(rs.getString("permission_id"));
			model_has_permissions.setmodel_type(rs.getString("model_type"));
			model_has_permissions.setmodel_id(rs.getString("model_id"));
			model_has_permissionsList.add(model_has_permissions);
		}
		rs.close();
		ps.close();
		return model_has_permissionsList;
	} 
} 
