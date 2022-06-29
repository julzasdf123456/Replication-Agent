package tableclasses;

import db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import others.ObjectHelpers;
import replicationagent.MainFrame;
public class CRM_TransformerIndexDAO { 
	public static void insert(CRM_TransformerIndex cRM_TransformerIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_TransformerIndex(id, NEACode, created_at, updated_at, LinkFuseCode) VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, cRM_TransformerIndex.getid());
		ps.setString(2, cRM_TransformerIndex.getNEACode());
		ps.setString(3, cRM_TransformerIndex.getcreated_at());
		ps.setString(4, cRM_TransformerIndex.getupdated_at());
		ps.setString(5, cRM_TransformerIndex.getLinkFuseCode());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_TransformerIndex cRM_TransformerIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_TransformerIndex SET NEACode=?, created_at=?, updated_at=?, LinkFuseCode=?  WHERE id=? ");
		ps.setString(1, cRM_TransformerIndex.getNEACode());
		ps.setString(2, cRM_TransformerIndex.getcreated_at());
		ps.setString(3, cRM_TransformerIndex.getupdated_at());
		ps.setString(4, cRM_TransformerIndex.getLinkFuseCode());
		ps.setString(5, cRM_TransformerIndex.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_TransformerIndex getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_TransformerIndex WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_TransformerIndex cRM_TransformerIndex = new CRM_TransformerIndex(
			rs.getString("id"),
			rs.getString("NEACode"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("LinkFuseCode")
			);
			ps.close();
			rs.close();
			return cRM_TransformerIndex;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_TransformerIndex> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_TransformerIndex WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_TransformerIndex> cRM_TransformerIndexList = new ArrayList<>();
		while(rs.next()) {
			CRM_TransformerIndex cRM_TransformerIndex = new CRM_TransformerIndex();
			cRM_TransformerIndex.setid(rs.getString("id"));
			cRM_TransformerIndex.setNEACode(rs.getString("NEACode"));
			cRM_TransformerIndex.setcreated_at(rs.getString("created_at"));
			cRM_TransformerIndex.setupdated_at(rs.getString("updated_at"));
			cRM_TransformerIndex.setLinkFuseCode(rs.getString("LinkFuseCode"));
			cRM_TransformerIndexList.add(cRM_TransformerIndex);
		}
		rs.close();
		ps.close();
		return cRM_TransformerIndexList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_TransformerIndex> billing_Billses = CRM_TransformerIndexDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_TransformerIndex to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_TransformerIndex bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_TransformerIndex bill = CRM_TransformerIndexDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_TransformerIndex has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_TransformerIndexDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_TransformerIndex updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_TransformerIndexDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_TransformerIndex inserted";
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
