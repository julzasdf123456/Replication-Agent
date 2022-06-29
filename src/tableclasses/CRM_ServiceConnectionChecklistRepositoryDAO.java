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
public class CRM_ServiceConnectionChecklistRepositoryDAO { 
	public static void insert(CRM_ServiceConnectionChecklistRepository cRM_ServiceConnectionChecklistRepository, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_ServiceConnectionChecklistRepository(id, Checklist, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, cRM_ServiceConnectionChecklistRepository.getid());
		ps.setString(2, cRM_ServiceConnectionChecklistRepository.getChecklist());
		ps.setString(3, cRM_ServiceConnectionChecklistRepository.getNotes());
		ps.setString(4, cRM_ServiceConnectionChecklistRepository.getcreated_at());
		ps.setString(5, cRM_ServiceConnectionChecklistRepository.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_ServiceConnectionChecklistRepository cRM_ServiceConnectionChecklistRepository, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionChecklistRepository SET Checklist=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_ServiceConnectionChecklistRepository.getChecklist());
		ps.setString(2, cRM_ServiceConnectionChecklistRepository.getNotes());
		ps.setString(3, cRM_ServiceConnectionChecklistRepository.getcreated_at());
		ps.setString(4, cRM_ServiceConnectionChecklistRepository.getupdated_at());
		ps.setString(5, cRM_ServiceConnectionChecklistRepository.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_ServiceConnectionChecklistRepository getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionChecklistRepository WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_ServiceConnectionChecklistRepository cRM_ServiceConnectionChecklistRepository = new CRM_ServiceConnectionChecklistRepository(
			rs.getString("id"),
			rs.getString("Checklist"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_ServiceConnectionChecklistRepository;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_ServiceConnectionChecklistRepository> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_ServiceConnectionChecklistRepository WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_ServiceConnectionChecklistRepository> cRM_ServiceConnectionChecklistRepositoryList = new ArrayList<>();
		while(rs.next()) {
			CRM_ServiceConnectionChecklistRepository cRM_ServiceConnectionChecklistRepository = new CRM_ServiceConnectionChecklistRepository();
			cRM_ServiceConnectionChecklistRepository.setid(rs.getString("id"));
			cRM_ServiceConnectionChecklistRepository.setChecklist(rs.getString("Checklist"));
			cRM_ServiceConnectionChecklistRepository.setNotes(rs.getString("Notes"));
			cRM_ServiceConnectionChecklistRepository.setcreated_at(rs.getString("created_at"));
			cRM_ServiceConnectionChecklistRepository.setupdated_at(rs.getString("updated_at"));
			cRM_ServiceConnectionChecklistRepositoryList.add(cRM_ServiceConnectionChecklistRepository);
		}
		rs.close();
		ps.close();
		return cRM_ServiceConnectionChecklistRepositoryList;
	} 

        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_ServiceConnectionChecklistRepository> billing_Billses = CRM_ServiceConnectionChecklistRepositoryDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_ServiceConnectionChecklistRepository to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_ServiceConnectionChecklistRepository bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_ServiceConnectionChecklistRepository bill = CRM_ServiceConnectionChecklistRepositoryDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionChecklistRepository has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_ServiceConnectionChecklistRepositoryDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_ServiceConnectionChecklistRepository updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_ServiceConnectionChecklistRepositoryDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_ServiceConnectionChecklistRepository inserted";
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
