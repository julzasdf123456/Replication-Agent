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
public class CRM_TicketsRepositoryDAO { 
	public static void insert(CRM_TicketsRepository cRM_TicketsRepository, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_TicketsRepository(id, Name, Description, ParentTicket, Type, KPSCategory, KPSIssue, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_TicketsRepository.getid());
		ps.setString(2, cRM_TicketsRepository.getName());
		ps.setString(3, cRM_TicketsRepository.getDescription());
		ps.setString(4, cRM_TicketsRepository.getParentTicket());
		ps.setString(5, cRM_TicketsRepository.getType());
		ps.setString(6, cRM_TicketsRepository.getKPSCategory());
		ps.setString(7, cRM_TicketsRepository.getKPSIssue());
		ps.setString(8, cRM_TicketsRepository.getcreated_at());
		ps.setString(9, cRM_TicketsRepository.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_TicketsRepository cRM_TicketsRepository, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_TicketsRepository SET Name=?, Description=?, ParentTicket=?, Type=?, KPSCategory=?, KPSIssue=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_TicketsRepository.getName());
		ps.setString(2, cRM_TicketsRepository.getDescription());
		ps.setString(3, cRM_TicketsRepository.getParentTicket());
		ps.setString(4, cRM_TicketsRepository.getType());
		ps.setString(5, cRM_TicketsRepository.getKPSCategory());
		ps.setString(6, cRM_TicketsRepository.getKPSIssue());
		ps.setString(7, cRM_TicketsRepository.getcreated_at());
		ps.setString(8, cRM_TicketsRepository.getupdated_at());
		ps.setString(9, cRM_TicketsRepository.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_TicketsRepository getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_TicketsRepository WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_TicketsRepository cRM_TicketsRepository = new CRM_TicketsRepository(
			rs.getString("id"),
			rs.getString("Name"),
			rs.getString("Description"),
			rs.getString("ParentTicket"),
			rs.getString("Type"),
			rs.getString("KPSCategory"),
			rs.getString("KPSIssue"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_TicketsRepository;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_TicketsRepository> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_TicketsRepository WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_TicketsRepository> cRM_TicketsRepositoryList = new ArrayList<>();
		while(rs.next()) {
			CRM_TicketsRepository cRM_TicketsRepository = new CRM_TicketsRepository();
			cRM_TicketsRepository.setid(rs.getString("id"));
			cRM_TicketsRepository.setName(rs.getString("Name"));
			cRM_TicketsRepository.setDescription(rs.getString("Description"));
			cRM_TicketsRepository.setParentTicket(rs.getString("ParentTicket"));
			cRM_TicketsRepository.setType(rs.getString("Type"));
			cRM_TicketsRepository.setKPSCategory(rs.getString("KPSCategory"));
			cRM_TicketsRepository.setKPSIssue(rs.getString("KPSIssue"));
			cRM_TicketsRepository.setcreated_at(rs.getString("created_at"));
			cRM_TicketsRepository.setupdated_at(rs.getString("updated_at"));
			cRM_TicketsRepositoryList.add(cRM_TicketsRepository);
		}
		rs.close();
		ps.close();
		return cRM_TicketsRepositoryList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_TicketsRepository> billing_Billses = CRM_TicketsRepositoryDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_TicketsRepository to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_TicketsRepository bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_TicketsRepository bill = CRM_TicketsRepositoryDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_TicketsRepository has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_TicketsRepositoryDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_TicketsRepository updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_TicketsRepositoryDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_TicketsRepository inserted";
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
