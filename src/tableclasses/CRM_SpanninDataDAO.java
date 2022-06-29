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
public class CRM_SpanninDataDAO { 
	public static void insert(CRM_SpanninData cRM_SpanninData, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_SpanninData(id, ServiceConnectionId, PrimarySpan, PrimarySize, PrimaryType, NeutralSpan, NeutralSize, NeutralType, SecondarySpan, SecondarySize, SecondaryType, SDWSpan, SDWSize, SDWType, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_SpanninData.getid());
		ps.setString(2, cRM_SpanninData.getServiceConnectionId());
		ps.setString(3, cRM_SpanninData.getPrimarySpan());
		ps.setString(4, cRM_SpanninData.getPrimarySize());
		ps.setString(5, cRM_SpanninData.getPrimaryType());
		ps.setString(6, cRM_SpanninData.getNeutralSpan());
		ps.setString(7, cRM_SpanninData.getNeutralSize());
		ps.setString(8, cRM_SpanninData.getNeutralType());
		ps.setString(9, cRM_SpanninData.getSecondarySpan());
		ps.setString(10, cRM_SpanninData.getSecondarySize());
		ps.setString(11, cRM_SpanninData.getSecondaryType());
		ps.setString(12, cRM_SpanninData.getSDWSpan());
		ps.setString(13, cRM_SpanninData.getSDWSize());
		ps.setString(14, cRM_SpanninData.getSDWType());
		ps.setString(15, cRM_SpanninData.getcreated_at());
		ps.setString(16, cRM_SpanninData.getupdated_at());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_SpanninData cRM_SpanninData, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_SpanninData SET ServiceConnectionId=?, PrimarySpan=?, PrimarySize=?, PrimaryType=?, NeutralSpan=?, NeutralSize=?, NeutralType=?, SecondarySpan=?, SecondarySize=?, SecondaryType=?, SDWSpan=?, SDWSize=?, SDWType=?, created_at=?, updated_at=?  WHERE id=? ");
		ps.setString(1, cRM_SpanninData.getServiceConnectionId());
		ps.setString(2, cRM_SpanninData.getPrimarySpan());
		ps.setString(3, cRM_SpanninData.getPrimarySize());
		ps.setString(4, cRM_SpanninData.getPrimaryType());
		ps.setString(5, cRM_SpanninData.getNeutralSpan());
		ps.setString(6, cRM_SpanninData.getNeutralSize());
		ps.setString(7, cRM_SpanninData.getNeutralType());
		ps.setString(8, cRM_SpanninData.getSecondarySpan());
		ps.setString(9, cRM_SpanninData.getSecondarySize());
		ps.setString(10, cRM_SpanninData.getSecondaryType());
		ps.setString(11, cRM_SpanninData.getSDWSpan());
		ps.setString(12, cRM_SpanninData.getSDWSize());
		ps.setString(13, cRM_SpanninData.getSDWType());
		ps.setString(14, cRM_SpanninData.getcreated_at());
		ps.setString(15, cRM_SpanninData.getupdated_at());
		ps.setString(16, cRM_SpanninData.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_SpanninData getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_SpanninData WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_SpanninData cRM_SpanninData = new CRM_SpanninData(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("PrimarySpan"),
			rs.getString("PrimarySize"),
			rs.getString("PrimaryType"),
			rs.getString("NeutralSpan"),
			rs.getString("NeutralSize"),
			rs.getString("NeutralType"),
			rs.getString("SecondarySpan"),
			rs.getString("SecondarySize"),
			rs.getString("SecondaryType"),
			rs.getString("SDWSpan"),
			rs.getString("SDWSize"),
			rs.getString("SDWType"),
			rs.getString("created_at"),
			rs.getString("updated_at")
			);
			ps.close();
			rs.close();
			return cRM_SpanninData;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_SpanninData> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_SpanninData WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_SpanninData> cRM_SpanninDataList = new ArrayList<>();
		while(rs.next()) {
			CRM_SpanninData cRM_SpanninData = new CRM_SpanninData();
			cRM_SpanninData.setid(rs.getString("id"));
			cRM_SpanninData.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_SpanninData.setPrimarySpan(rs.getString("PrimarySpan"));
			cRM_SpanninData.setPrimarySize(rs.getString("PrimarySize"));
			cRM_SpanninData.setPrimaryType(rs.getString("PrimaryType"));
			cRM_SpanninData.setNeutralSpan(rs.getString("NeutralSpan"));
			cRM_SpanninData.setNeutralSize(rs.getString("NeutralSize"));
			cRM_SpanninData.setNeutralType(rs.getString("NeutralType"));
			cRM_SpanninData.setSecondarySpan(rs.getString("SecondarySpan"));
			cRM_SpanninData.setSecondarySize(rs.getString("SecondarySize"));
			cRM_SpanninData.setSecondaryType(rs.getString("SecondaryType"));
			cRM_SpanninData.setSDWSpan(rs.getString("SDWSpan"));
			cRM_SpanninData.setSDWSize(rs.getString("SDWSize"));
			cRM_SpanninData.setSDWType(rs.getString("SDWType"));
			cRM_SpanninData.setcreated_at(rs.getString("created_at"));
			cRM_SpanninData.setupdated_at(rs.getString("updated_at"));
			cRM_SpanninDataList.add(cRM_SpanninData);
		}
		rs.close();
		ps.close();
		return cRM_SpanninDataList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_SpanninData> billing_Billses = CRM_SpanninDataDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_SpanninData to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_SpanninData bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_SpanninData bill = CRM_SpanninDataDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_SpanninData has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_SpanninDataDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_SpanninData updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_SpanninDataDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_SpanninData inserted";
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
