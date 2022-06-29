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
public class CRM_BillsOfMaterialsSummaryDAO { 
	public static void insert(CRM_BillsOfMaterialsSummary cRM_BillsOfMaterialsSummary, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_BillsOfMaterialsSummary(id, ServiceConnectionId, ExcludeTransformerLaborCost, TransformerChangedPrice, MonthDuration, TransformerLaborCostPercentage, MaterialLaborCostPercentage, HandlingCostPercentage, SubTotal, LaborCost, HandlingCost, Total, TotalVAT, created_at, updated_at, TransformerLaborCost, MaterialLaborCost, TransformerTotal, IsPaid, ORNumber, ORDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_BillsOfMaterialsSummary.getid());
		ps.setString(2, cRM_BillsOfMaterialsSummary.getServiceConnectionId());
		ps.setString(3, cRM_BillsOfMaterialsSummary.getExcludeTransformerLaborCost());
		ps.setString(4, cRM_BillsOfMaterialsSummary.getTransformerChangedPrice());
		ps.setString(5, cRM_BillsOfMaterialsSummary.getMonthDuration());
		ps.setString(6, cRM_BillsOfMaterialsSummary.getTransformerLaborCostPercentage());
		ps.setString(7, cRM_BillsOfMaterialsSummary.getMaterialLaborCostPercentage());
		ps.setString(8, cRM_BillsOfMaterialsSummary.getHandlingCostPercentage());
		ps.setString(9, cRM_BillsOfMaterialsSummary.getSubTotal());
		ps.setString(10, cRM_BillsOfMaterialsSummary.getLaborCost());
		ps.setString(11, cRM_BillsOfMaterialsSummary.getHandlingCost());
		ps.setString(12, cRM_BillsOfMaterialsSummary.getTotal());
		ps.setString(13, cRM_BillsOfMaterialsSummary.getTotalVAT());
		ps.setString(14, cRM_BillsOfMaterialsSummary.getcreated_at());
		ps.setString(15, cRM_BillsOfMaterialsSummary.getupdated_at());
		ps.setString(16, cRM_BillsOfMaterialsSummary.getTransformerLaborCost());
		ps.setString(17, cRM_BillsOfMaterialsSummary.getMaterialLaborCost());
		ps.setString(18, cRM_BillsOfMaterialsSummary.getTransformerTotal());
		ps.setString(19, cRM_BillsOfMaterialsSummary.getIsPaid());
		ps.setString(20, cRM_BillsOfMaterialsSummary.getORNumber());
		ps.setString(21, cRM_BillsOfMaterialsSummary.getORDate());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_BillsOfMaterialsSummary cRM_BillsOfMaterialsSummary, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_BillsOfMaterialsSummary SET ServiceConnectionId=?, ExcludeTransformerLaborCost=?, TransformerChangedPrice=?, MonthDuration=?, TransformerLaborCostPercentage=?, MaterialLaborCostPercentage=?, HandlingCostPercentage=?, SubTotal=?, LaborCost=?, HandlingCost=?, Total=?, TotalVAT=?, created_at=?, updated_at=?, TransformerLaborCost=?, MaterialLaborCost=?, TransformerTotal=?, IsPaid=?, ORNumber=?, ORDate=?  WHERE id=? ");
		ps.setString(1, cRM_BillsOfMaterialsSummary.getServiceConnectionId());
		ps.setString(2, cRM_BillsOfMaterialsSummary.getExcludeTransformerLaborCost());
		ps.setString(3, cRM_BillsOfMaterialsSummary.getTransformerChangedPrice());
		ps.setString(4, cRM_BillsOfMaterialsSummary.getMonthDuration());
		ps.setString(5, cRM_BillsOfMaterialsSummary.getTransformerLaborCostPercentage());
		ps.setString(6, cRM_BillsOfMaterialsSummary.getMaterialLaborCostPercentage());
		ps.setString(7, cRM_BillsOfMaterialsSummary.getHandlingCostPercentage());
		ps.setString(8, cRM_BillsOfMaterialsSummary.getSubTotal());
		ps.setString(9, cRM_BillsOfMaterialsSummary.getLaborCost());
		ps.setString(10, cRM_BillsOfMaterialsSummary.getHandlingCost());
		ps.setString(11, cRM_BillsOfMaterialsSummary.getTotal());
		ps.setString(12, cRM_BillsOfMaterialsSummary.getTotalVAT());
		ps.setString(13, cRM_BillsOfMaterialsSummary.getcreated_at());
		ps.setString(14, cRM_BillsOfMaterialsSummary.getupdated_at());
		ps.setString(15, cRM_BillsOfMaterialsSummary.getTransformerLaborCost());
		ps.setString(16, cRM_BillsOfMaterialsSummary.getMaterialLaborCost());
		ps.setString(17, cRM_BillsOfMaterialsSummary.getTransformerTotal());
		ps.setString(18, cRM_BillsOfMaterialsSummary.getIsPaid());
		ps.setString(19, cRM_BillsOfMaterialsSummary.getORNumber());
		ps.setString(20, cRM_BillsOfMaterialsSummary.getORDate());
		ps.setString(21, cRM_BillsOfMaterialsSummary.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_BillsOfMaterialsSummary getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_BillsOfMaterialsSummary WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_BillsOfMaterialsSummary cRM_BillsOfMaterialsSummary = new CRM_BillsOfMaterialsSummary(
			rs.getString("id"),
			rs.getString("ServiceConnectionId"),
			rs.getString("ExcludeTransformerLaborCost"),
			rs.getString("TransformerChangedPrice"),
			rs.getString("MonthDuration"),
			rs.getString("TransformerLaborCostPercentage"),
			rs.getString("MaterialLaborCostPercentage"),
			rs.getString("HandlingCostPercentage"),
			rs.getString("SubTotal"),
			rs.getString("LaborCost"),
			rs.getString("HandlingCost"),
			rs.getString("Total"),
			rs.getString("TotalVAT"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("TransformerLaborCost"),
			rs.getString("MaterialLaborCost"),
			rs.getString("TransformerTotal"),
			rs.getString("IsPaid"),
			rs.getString("ORNumber"),
			rs.getString("ORDate")
			);
			ps.close();
			rs.close();
			return cRM_BillsOfMaterialsSummary;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_BillsOfMaterialsSummary> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_BillsOfMaterialsSummary WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_BillsOfMaterialsSummary> cRM_BillsOfMaterialsSummaryList = new ArrayList<>();
		while(rs.next()) {
			CRM_BillsOfMaterialsSummary cRM_BillsOfMaterialsSummary = new CRM_BillsOfMaterialsSummary();
			cRM_BillsOfMaterialsSummary.setid(rs.getString("id"));
			cRM_BillsOfMaterialsSummary.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cRM_BillsOfMaterialsSummary.setExcludeTransformerLaborCost(rs.getString("ExcludeTransformerLaborCost"));
			cRM_BillsOfMaterialsSummary.setTransformerChangedPrice(rs.getString("TransformerChangedPrice"));
			cRM_BillsOfMaterialsSummary.setMonthDuration(rs.getString("MonthDuration"));
			cRM_BillsOfMaterialsSummary.setTransformerLaborCostPercentage(rs.getString("TransformerLaborCostPercentage"));
			cRM_BillsOfMaterialsSummary.setMaterialLaborCostPercentage(rs.getString("MaterialLaborCostPercentage"));
			cRM_BillsOfMaterialsSummary.setHandlingCostPercentage(rs.getString("HandlingCostPercentage"));
			cRM_BillsOfMaterialsSummary.setSubTotal(rs.getString("SubTotal"));
			cRM_BillsOfMaterialsSummary.setLaborCost(rs.getString("LaborCost"));
			cRM_BillsOfMaterialsSummary.setHandlingCost(rs.getString("HandlingCost"));
			cRM_BillsOfMaterialsSummary.setTotal(rs.getString("Total"));
			cRM_BillsOfMaterialsSummary.setTotalVAT(rs.getString("TotalVAT"));
			cRM_BillsOfMaterialsSummary.setcreated_at(rs.getString("created_at"));
			cRM_BillsOfMaterialsSummary.setupdated_at(rs.getString("updated_at"));
			cRM_BillsOfMaterialsSummary.setTransformerLaborCost(rs.getString("TransformerLaborCost"));
			cRM_BillsOfMaterialsSummary.setMaterialLaborCost(rs.getString("MaterialLaborCost"));
			cRM_BillsOfMaterialsSummary.setTransformerTotal(rs.getString("TransformerTotal"));
			cRM_BillsOfMaterialsSummary.setIsPaid(rs.getString("IsPaid"));
			cRM_BillsOfMaterialsSummary.setORNumber(rs.getString("ORNumber"));
			cRM_BillsOfMaterialsSummary.setORDate(rs.getString("ORDate"));
			cRM_BillsOfMaterialsSummaryList.add(cRM_BillsOfMaterialsSummary);
		}
		rs.close();
		ps.close();
		return cRM_BillsOfMaterialsSummaryList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_BillsOfMaterialsSummary> billing_Billses = CRM_BillsOfMaterialsSummaryDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_BillsOfMaterialsSummary to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_BillsOfMaterialsSummary bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_BillsOfMaterialsSummary bill = CRM_BillsOfMaterialsSummaryDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_BillsOfMaterialsSummary has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_BillsOfMaterialsSummaryDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_BillsOfMaterialsSummary updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_BillsOfMaterialsSummaryDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_BillsOfMaterialsSummary inserted";
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
