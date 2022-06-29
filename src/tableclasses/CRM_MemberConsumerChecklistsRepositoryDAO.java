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
public class CRM_MemberConsumerChecklistsRepositoryDAO { 
	public static void insert(CRM_MemberConsumerChecklistsRepository cRM_MemberConsumerChecklistsRepository, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_MemberConsumerChecklistsRepository(id, Checklist, Notes, created_at, updated_at) VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, cRM_MemberConsumerChecklistsRepository.getid());
		ps.setString(2, cRM_MemberConsumerChecklistsRepository.getChecklist());
		ps.setString(3, cRM_MemberConsumerChecklistsRepository.getNotes());
		ps.setString(4, cRM_MemberConsumerChecklistsRepository.getcreated_at());
		ps.setString(5, cRM_MemberConsumerChecklistsRepository.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_MemberConsumerChecklistsRepository cRM_MemberConsumerChecklistsRepository, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_MemberConsumerChecklistsRepository SET Checklist=?, Notes=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_MemberConsumerChecklistsRepository.getChecklist());
		ps.setString(2, cRM_MemberConsumerChecklistsRepository.getNotes());
		ps.setString(3, cRM_MemberConsumerChecklistsRepository.getcreated_at());
		ps.setString(4, cRM_MemberConsumerChecklistsRepository.getupdated_at());
		ps.setString(5, cRM_MemberConsumerChecklistsRepository.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_MemberConsumerChecklistsRepository getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumerChecklistsRepository WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_MemberConsumerChecklistsRepository cRM_MemberConsumerChecklistsRepository = new CRM_MemberConsumerChecklistsRepository(
			rs.getString("id"),
			rs.getString("Checklist"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_MemberConsumerChecklistsRepository;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_MemberConsumerChecklistsRepository> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_MemberConsumerChecklistsRepository WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_MemberConsumerChecklistsRepository> cRM_MemberConsumerChecklistsRepositoryList = new ArrayList<>();
		while(rs.next()) {
			CRM_MemberConsumerChecklistsRepository cRM_MemberConsumerChecklistsRepository = new CRM_MemberConsumerChecklistsRepository();
			cRM_MemberConsumerChecklistsRepository.setid(rs.getString("id"));
			cRM_MemberConsumerChecklistsRepository.setChecklist(rs.getString("Checklist"));
			cRM_MemberConsumerChecklistsRepository.setNotes(rs.getString("Notes"));
			cRM_MemberConsumerChecklistsRepository.setcreated_at(rs.getString("created_at"));
			cRM_MemberConsumerChecklistsRepository.setupdated_at(rs.getString("updated_at"));
			cRM_MemberConsumerChecklistsRepositoryList.add(cRM_MemberConsumerChecklistsRepository);
		}
		rs.close();
		ps.close();
		return cRM_MemberConsumerChecklistsRepositoryList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_MemberConsumerChecklistsRepository> billing_Billses = CRM_MemberConsumerChecklistsRepositoryDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_MemberConsumerChecklistsRepository to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_MemberConsumerChecklistsRepository bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_MemberConsumerChecklistsRepository bill = CRM_MemberConsumerChecklistsRepositoryDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_MemberConsumerChecklistsRepository has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_MemberConsumerChecklistsRepositoryDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_MemberConsumerChecklistsRepository updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_MemberConsumerChecklistsRepositoryDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_MemberConsumerChecklistsRepository inserted";
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
