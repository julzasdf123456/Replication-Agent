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
public class migrationsDAO { 
	public static void insert(migrations migrations, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO migrations(id, migration, batch) VALUES (?, ?, ?)");
		ps.setString(1, migrations.getid());
		ps.setString(2, migrations.getmigration());
		ps.setString(3, migrations.getbatch());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(migrations migrations, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE migrations SET migration=?, batch=?  WHERE id=? ");
		ps.setString(1, migrations.getmigration());
		ps.setString(2, migrations.getbatch());
		ps.setString(3, migrations.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static migrations getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM migrations WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			migrations migrations = new migrations(
			rs.getString("id"),
			rs.getString("migration"),
			rs.getString("batch")
			);
			ps.close();
			rs.close();
			return migrations;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<migrations> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM migrations WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<migrations> migrationsList = new ArrayList<>();
		while(rs.next()) {
			migrations migrations = new migrations();
			migrations.setid(rs.getString("id"));
			migrations.setmigration(rs.getString("migration"));
			migrations.setbatch(rs.getString("batch"));
			migrationsList.add(migrations);
		}
		rs.close();
		ps.close();
		return migrationsList;
	} 
} 
