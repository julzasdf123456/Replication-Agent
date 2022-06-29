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
public class CRM_SpanningIndexDAO { 
	public static void insert(CRM_SpanningIndex cRM_SpanningIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_SpanningIndex(id, NeaCode, Structure, Description, Size, Type, SpliceNeaCode, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_SpanningIndex.getid());
		ps.setString(2, cRM_SpanningIndex.getNeaCode());
		ps.setString(3, cRM_SpanningIndex.getStructure());
		ps.setString(4, cRM_SpanningIndex.getDescription());
		ps.setString(5, cRM_SpanningIndex.getSize());
		ps.setString(6, cRM_SpanningIndex.getType());
		ps.setString(7, cRM_SpanningIndex.getSpliceNeaCode());
		ps.setString(8, cRM_SpanningIndex.getcreated_at());
		ps.setString(9, cRM_SpanningIndex.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_SpanningIndex cRM_SpanningIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_SpanningIndex SET NeaCode=?, Structure=?, Description=?, Size=?, Type=?, SpliceNeaCode=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_SpanningIndex.getNeaCode());
		ps.setString(2, cRM_SpanningIndex.getStructure());
		ps.setString(3, cRM_SpanningIndex.getDescription());
		ps.setString(4, cRM_SpanningIndex.getSize());
		ps.setString(5, cRM_SpanningIndex.getType());
		ps.setString(6, cRM_SpanningIndex.getSpliceNeaCode());
		ps.setString(7, cRM_SpanningIndex.getcreated_at());
		ps.setString(8, cRM_SpanningIndex.getupdated_at());
		ps.setString(9, cRM_SpanningIndex.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_SpanningIndex getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_SpanningIndex WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_SpanningIndex cRM_SpanningIndex = new CRM_SpanningIndex(
			rs.getString("id"),
			rs.getString("NeaCode"),
			rs.getString("Structure"),
			rs.getString("Description"),
			rs.getString("Size"),
			rs.getString("Type"),
			rs.getString("SpliceNeaCode"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_SpanningIndex;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_SpanningIndex> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_SpanningIndex WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_SpanningIndex> cRM_SpanningIndexList = new ArrayList<>();
		while(rs.next()) {
			CRM_SpanningIndex cRM_SpanningIndex = new CRM_SpanningIndex();
			cRM_SpanningIndex.setid(rs.getString("id"));
			cRM_SpanningIndex.setNeaCode(rs.getString("NeaCode"));
			cRM_SpanningIndex.setStructure(rs.getString("Structure"));
			cRM_SpanningIndex.setDescription(rs.getString("Description"));
			cRM_SpanningIndex.setSize(rs.getString("Size"));
			cRM_SpanningIndex.setType(rs.getString("Type"));
			cRM_SpanningIndex.setSpliceNeaCode(rs.getString("SpliceNeaCode"));
			cRM_SpanningIndex.setcreated_at(rs.getString("created_at"));
			cRM_SpanningIndex.setupdated_at(rs.getString("updated_at"));
			cRM_SpanningIndexList.add(cRM_SpanningIndex);
		}
		rs.close();
		ps.close();
		return cRM_SpanningIndexList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_SpanningIndex> billing_Billses = CRM_SpanningIndexDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_SpanningIndex to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_SpanningIndex bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_SpanningIndex bill = CRM_SpanningIndexDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_SpanningIndex has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_SpanningIndexDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_SpanningIndex updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_SpanningIndexDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_SpanningIndex inserted";
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
