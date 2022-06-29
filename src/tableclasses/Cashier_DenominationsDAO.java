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
public class Cashier_DenominationsDAO { 
	public static void insert(Cashier_Denominations cashier_Denominations, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_Denominations(id, AccountNumber, ServicePeriod, OneThousand, FiveHundred, OneHundred, Fifty, Twenty, Ten, Five, Peso, Cents, PaidBillId, Notes, created_at, updated_at, Total, ORNumber, ORDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_Denominations.getid());
		ps.setString(2, cashier_Denominations.getAccountNumber());
		ps.setString(3, cashier_Denominations.getServicePeriod());
		ps.setString(4, cashier_Denominations.getOneThousand());
		ps.setString(5, cashier_Denominations.getFiveHundred());
		ps.setString(6, cashier_Denominations.getOneHundred());
		ps.setString(7, cashier_Denominations.getFifty());
		ps.setString(8, cashier_Denominations.getTwenty());
		ps.setString(9, cashier_Denominations.getTen());
		ps.setString(10, cashier_Denominations.getFive());
		ps.setString(11, cashier_Denominations.getPeso());
		ps.setString(12, cashier_Denominations.getCents());
		ps.setString(13, cashier_Denominations.getPaidBillId());
		ps.setString(14, cashier_Denominations.getNotes());
		ps.setString(15, cashier_Denominations.getcreated_at());
		ps.setString(16, cashier_Denominations.getupdated_at());
		ps.setString(17, cashier_Denominations.getTotal());
		ps.setString(18, cashier_Denominations.getORNumber());
		ps.setString(19, cashier_Denominations.getORDate());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_Denominations cashier_Denominations, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_Denominations SET AccountNumber=?, ServicePeriod=?, OneThousand=?, FiveHundred=?, OneHundred=?, Fifty=?, Twenty=?, Ten=?, Five=?, Peso=?, Cents=?, PaidBillId=?, Notes=?, created_at=?, updated_at=?, Total=?, ORNumber=?, ORDate=?  WHERE id=? ");
		ps.setString(1, cashier_Denominations.getAccountNumber());
		ps.setString(2, cashier_Denominations.getServicePeriod());
		ps.setString(3, cashier_Denominations.getOneThousand());
		ps.setString(4, cashier_Denominations.getFiveHundred());
		ps.setString(5, cashier_Denominations.getOneHundred());
		ps.setString(6, cashier_Denominations.getFifty());
		ps.setString(7, cashier_Denominations.getTwenty());
		ps.setString(8, cashier_Denominations.getTen());
		ps.setString(9, cashier_Denominations.getFive());
		ps.setString(10, cashier_Denominations.getPeso());
		ps.setString(11, cashier_Denominations.getCents());
		ps.setString(12, cashier_Denominations.getPaidBillId());
		ps.setString(13, cashier_Denominations.getNotes());
		ps.setString(14, cashier_Denominations.getcreated_at());
		ps.setString(15, cashier_Denominations.getupdated_at());
		ps.setString(16, cashier_Denominations.getTotal());
		ps.setString(17, cashier_Denominations.getORNumber());
		ps.setString(18, cashier_Denominations.getORDate());
		ps.setString(19, cashier_Denominations.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_Denominations getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_Denominations WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_Denominations cashier_Denominations = new Cashier_Denominations(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("ServicePeriod"),
			rs.getString("OneThousand"),
			rs.getString("FiveHundred"),
			rs.getString("OneHundred"),
			rs.getString("Fifty"),
			rs.getString("Twenty"),
			rs.getString("Ten"),
			rs.getString("Five"),
			rs.getString("Peso"),
			rs.getString("Cents"),
			rs.getString("PaidBillId"),
			rs.getString("Notes"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Total"),
			rs.getString("ORNumber"),
			rs.getString("ORDate")
			);
			ps.close();
			rs.close();
			return cashier_Denominations;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_Denominations> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_Denominations WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_Denominations> cashier_DenominationsList = new ArrayList<>();
		while(rs.next()) {
			Cashier_Denominations cashier_Denominations = new Cashier_Denominations();
			cashier_Denominations.setid(rs.getString("id"));
			cashier_Denominations.setAccountNumber(rs.getString("AccountNumber"));
			cashier_Denominations.setServicePeriod(rs.getString("ServicePeriod"));
			cashier_Denominations.setOneThousand(rs.getString("OneThousand"));
			cashier_Denominations.setFiveHundred(rs.getString("FiveHundred"));
			cashier_Denominations.setOneHundred(rs.getString("OneHundred"));
			cashier_Denominations.setFifty(rs.getString("Fifty"));
			cashier_Denominations.setTwenty(rs.getString("Twenty"));
			cashier_Denominations.setTen(rs.getString("Ten"));
			cashier_Denominations.setFive(rs.getString("Five"));
			cashier_Denominations.setPeso(rs.getString("Peso"));
			cashier_Denominations.setCents(rs.getString("Cents"));
			cashier_Denominations.setPaidBillId(rs.getString("PaidBillId"));
			cashier_Denominations.setNotes(rs.getString("Notes"));
			cashier_Denominations.setcreated_at(rs.getString("created_at"));
			cashier_Denominations.setupdated_at(rs.getString("updated_at"));
			cashier_Denominations.setTotal(rs.getString("Total"));
			cashier_Denominations.setORNumber(rs.getString("ORNumber"));
			cashier_Denominations.setORDate(rs.getString("ORDate"));
			cashier_DenominationsList.add(cashier_Denominations);
		}
		rs.close();
		ps.close();
		return cashier_DenominationsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_Denominations> billing_Billses = Cashier_DenominationsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_Denominations to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_Denominations bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_Denominations bill = Cashier_DenominationsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_Denominations has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_DenominationsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_Denominations updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_DenominationsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_Denominations inserted";
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
