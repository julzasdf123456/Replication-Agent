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
public class CRM_DamageAssessmentDAO { 
	public static void insert(CRM_DamageAssessment cRM_DamageAssessment, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_DamageAssessment(id, Type, ObjectName, Feeder, Town, Status, Notes, DateFixed, CrewAssigned, Latitude, Longitude, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_DamageAssessment.getid());
		ps.setString(2, cRM_DamageAssessment.getType());
		ps.setString(3, cRM_DamageAssessment.getObjectName());
		ps.setString(4, cRM_DamageAssessment.getFeeder());
		ps.setString(5, cRM_DamageAssessment.getTown());
		ps.setString(6, cRM_DamageAssessment.getStatus());
		ps.setString(7, cRM_DamageAssessment.getNotes());
		ps.setString(8, cRM_DamageAssessment.getDateFixed());
		ps.setString(9, cRM_DamageAssessment.getCrewAssigned());
		ps.setString(10, cRM_DamageAssessment.getLatitude());
		ps.setString(11, cRM_DamageAssessment.getLongitude());
		ps.setString(12, cRM_DamageAssessment.getcreated_at());
		ps.setString(13, cRM_DamageAssessment.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_DamageAssessment cRM_DamageAssessment, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_DamageAssessment SET Type=?, ObjectName=?, Feeder=?, Town=?, Status=?, Notes=?, DateFixed=?, CrewAssigned=?, Latitude=?, Longitude=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_DamageAssessment.getType());
		ps.setString(2, cRM_DamageAssessment.getObjectName());
		ps.setString(3, cRM_DamageAssessment.getFeeder());
		ps.setString(4, cRM_DamageAssessment.getTown());
		ps.setString(5, cRM_DamageAssessment.getStatus());
		ps.setString(6, cRM_DamageAssessment.getNotes());
		ps.setString(7, cRM_DamageAssessment.getDateFixed());
		ps.setString(8, cRM_DamageAssessment.getCrewAssigned());
		ps.setString(9, cRM_DamageAssessment.getLatitude());
		ps.setString(10, cRM_DamageAssessment.getLongitude());
		ps.setString(11, cRM_DamageAssessment.getcreated_at());
		ps.setString(12, cRM_DamageAssessment.getupdated_at());
		ps.setString(13, cRM_DamageAssessment.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_DamageAssessment getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_DamageAssessment WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_DamageAssessment cRM_DamageAssessment = new CRM_DamageAssessment(
			rs.getString("id"),
			rs.getString("Type"),
			rs.getString("ObjectName"),
			rs.getString("Feeder"),
			rs.getString("Town"),
			rs.getString("Status"),
			rs.getString("Notes"),
			rs.getString("DateFixed"),
			rs.getString("CrewAssigned"),
			rs.getString("Latitude"),
			rs.getString("Longitude"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_DamageAssessment;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_DamageAssessment> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_DamageAssessment WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_DamageAssessment> cRM_DamageAssessmentList = new ArrayList<>();
		while(rs.next()) {
			CRM_DamageAssessment cRM_DamageAssessment = new CRM_DamageAssessment();
			cRM_DamageAssessment.setid(rs.getString("id"));
			cRM_DamageAssessment.setType(rs.getString("Type"));
			cRM_DamageAssessment.setObjectName(rs.getString("ObjectName"));
			cRM_DamageAssessment.setFeeder(rs.getString("Feeder"));
			cRM_DamageAssessment.setTown(rs.getString("Town"));
			cRM_DamageAssessment.setStatus(rs.getString("Status"));
			cRM_DamageAssessment.setNotes(rs.getString("Notes"));
			cRM_DamageAssessment.setDateFixed(rs.getString("DateFixed"));
			cRM_DamageAssessment.setCrewAssigned(rs.getString("CrewAssigned"));
			cRM_DamageAssessment.setLatitude(rs.getString("Latitude"));
			cRM_DamageAssessment.setLongitude(rs.getString("Longitude"));
			cRM_DamageAssessment.setcreated_at(rs.getString("created_at"));
			cRM_DamageAssessment.setupdated_at(rs.getString("updated_at"));
			cRM_DamageAssessmentList.add(cRM_DamageAssessment);
		}
		rs.close();
		ps.close();
		return cRM_DamageAssessmentList;
	} 
} 
