package tableclasses;

import db.DBConnection;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import others.ObjectHelpers;
import replicationagent.MainFrame;
public class CRM_ServiceConnectionCrewDAO { 
	public static void insert(CRM_ServiceConnectionCrew cRM_ServiceConnectionCrew, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionCrew(id, StationName, CrewLeader, Members, Notes, created_at, updated_at, Office, Grouping) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionCrew.getid());
		ps.setString(2, cRM_ServiceConnectionCrew.getStationName());
		ps.setString(3, cRM_ServiceConnectionCrew.getCrewLeader());
		ps.setString(4, cRM_ServiceConnectionCrew.getMembers());
		ps.setString(5, cRM_ServiceConnectionCrew.getNotes());
		ps.setString(6, cRM_ServiceConnectionCrew.getcreated_at());
		ps.setString(7, cRM_ServiceConnectionCrew.getupdated_at());
		ps.setString(8, cRM_ServiceConnectionCrew.getOffice());
		ps.setString(9, cRM_ServiceConnectionCrew.getGrouping());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionCrew cRM_ServiceConnectionCrew, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionCrew SET StationName=?, CrewLeader=?, Members=?, Notes=?, created_at=?, updated_at=?, Office=?, Grouping=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionCrew.getStationName());
		ps.setString(2, cRM_ServiceConnectionCrew.getCrewLeader());
		ps.setString(3, cRM_ServiceConnectionCrew.getMembers());
		ps.setString(4, cRM_ServiceConnectionCrew.getNotes());
		ps.setString(5, cRM_ServiceConnectionCrew.getcreated_at());
		ps.setString(6, cRM_ServiceConnectionCrew.getupdated_at());
		ps.setString(7, cRM_ServiceConnectionCrew.getOffice());
		ps.setString(8, cRM_ServiceConnectionCrew.getGrouping());
		ps.setString(9, cRM_ServiceConnectionCrew.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionCrew getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionCrew WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionCrew cRM_ServiceConnectionCrew = new CRM_ServiceConnectionCrew(
			rs.getString("id"),
			rs.getString("StationName"),
			rs.getString("CrewLeader"),
			rs.getString("Members"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Office"),
			rs.getString("Grouping")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionCrew;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionCrew> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionCrew WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionCrew> cRM_ServiceConnectionCrewList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionCrew cRM_ServiceConnectionCrew = new CRM_ServiceConnectionCrew();
			cRM_ServiceConnectionCrew.setid(rs.getString("id"));
			cRM_ServiceConnectionCrew.setStationName(rs.getString("StationName"));
			cRM_ServiceConnectionCrew.setCrewLeader(rs.getString("CrewLeader"));
			cRM_ServiceConnectionCrew.setMembers(rs.getString("Members"));
			cRM_ServiceConnectionCrew.setNotes(rs.getString("Notes"));
			cRM_ServiceConnectionCrew.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionCrew.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionCrew.setOffice(rs.getString("Office"));
			cRM_ServiceConnectionCrew.setGrouping(rs.getString("Grouping"));
			cRM_ServiceConnectionCrewList.add(cRM_ServiceConnectionCrew);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionCrewList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionCrew> billing_Billses = CRM_ServiceConnectionCrewDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionCrew to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionCrew bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionCrew bill = CRM_ServiceConnectionCrewDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionCrew has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionCrewDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionCrew updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionCrewDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionCrew inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
