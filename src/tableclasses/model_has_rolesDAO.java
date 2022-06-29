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
public class model_has_rolesDAO { 
	public static void insert(model_has_roles model_has_roles, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO model_has_roles(role_id, model_type, model_id) VALUES (?, ?, ?)");
		ps.setString(1, model_has_roles.getrole_id());
		ps.setString(2, model_has_roles.getmodel_type());
		ps.setString(3, model_has_roles.getmodel_id());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(model_has_roles model_has_roles, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE model_has_roles SET model_type=?, model_id=?  WHERE role_id=? ");
		ps.setString(1, model_has_roles.getmodel_type());
		ps.setString(2, model_has_roles.getmodel_id());
		ps.setString(3, model_has_roles.getrole_id());
		ps.executeUpdate();
		ps.close();
	} 
	public static model_has_roles getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM model_has_roles WHERE role_id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			model_has_roles model_has_roles = new model_has_roles(
			rs.getString("role_id"),
			rs.getString("model_type"),
			rs.getString("model_id")
			);
			ps.close();
			rs.close();
			return model_has_roles;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<model_has_roles> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM model_has_roles WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<model_has_roles> model_has_rolesList = new ArrayList<>();
		while(rs.next()) {
			model_has_roles model_has_roles = new model_has_roles();
			model_has_roles.setrole_id(rs.getString("role_id"));
			model_has_roles.setmodel_type(rs.getString("model_type"));
			model_has_roles.setmodel_id(rs.getString("model_id"));
			model_has_rolesList.add(model_has_roles);
		}
		rs.close();
		ps.close();
		return model_has_rolesList;
	} 
} 
