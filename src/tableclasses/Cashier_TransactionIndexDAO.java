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
public class Cashier_TransactionIndexDAO { 
	public static void insert(Cashier_TransactionIndex cashier_TransactionIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_TransactionIndex(id, TransactionNumber, PaymentTitle, PaymentDetails, ORNumber, ORDate, SubTotal, VAT, Total, Notes, UserId, created_at, updated_at, ServiceConnectionId, TicketId, ObjectId, Source, PaymentUsed, Status, FiledBy, ApprovedBy, AuditedBy, CancellationNotes, PayeeName, CheckNo, Bank, CheckExpiration, AccountNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_TransactionIndex.getid());
		ps.setString(2, cashier_TransactionIndex.getTransactionNumber());
		ps.setString(3, cashier_TransactionIndex.getPaymentTitle());
		ps.setString(4, cashier_TransactionIndex.getPaymentDetails());
		ps.setString(5, cashier_TransactionIndex.getORNumber());
		ps.setString(6, cashier_TransactionIndex.getORDate());
		ps.setString(7, cashier_TransactionIndex.getSubTotal());
		ps.setString(8, cashier_TransactionIndex.getVAT());
		ps.setString(9, cashier_TransactionIndex.getTotal());
		ps.setString(10, cashier_TransactionIndex.getNotes());
		ps.setString(11, cashier_TransactionIndex.getUserId());
		ps.setString(12, cashier_TransactionIndex.getcreated_at());
		ps.setString(13, cashier_TransactionIndex.getupdated_at());
		ps.setString(14, cashier_TransactionIndex.getServiceConnectionId());
		ps.setString(15, cashier_TransactionIndex.getTicketId());
		ps.setString(16, cashier_TransactionIndex.getObjectId());
		ps.setString(17, cashier_TransactionIndex.getSource());
		ps.setString(18, cashier_TransactionIndex.getPaymentUsed());
		ps.setString(19, cashier_TransactionIndex.getStatus());
		ps.setString(20, cashier_TransactionIndex.getFiledBy());
		ps.setString(21, cashier_TransactionIndex.getApprovedBy());
		ps.setString(22, cashier_TransactionIndex.getAuditedBy());
		ps.setString(23, cashier_TransactionIndex.getCancellationNotes());
		ps.setString(24, cashier_TransactionIndex.getPayeeName());
		ps.setString(25, cashier_TransactionIndex.getCheckNo());
		ps.setString(26, cashier_TransactionIndex.getBank());
		ps.setString(27, cashier_TransactionIndex.getCheckExpiration());
		ps.setString(28, cashier_TransactionIndex.getAccountNumber());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_TransactionIndex cashier_TransactionIndex, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_TransactionIndex SET TransactionNumber=?, PaymentTitle=?, PaymentDetails=?, ORNumber=?, ORDate=?, SubTotal=?, VAT=?, Total=?, Notes=?, UserId=?, created_at=?, updated_at=?, ServiceConnectionId=?, TicketId=?, ObjectId=?, Source=?, PaymentUsed=?, Status=?, FiledBy=?, ApprovedBy=?, AuditedBy=?, CancellationNotes=?, PayeeName=?, CheckNo=?, Bank=?, CheckExpiration=?, AccountNumber=?  WHERE id=? ");
		ps.setString(1, cashier_TransactionIndex.getTransactionNumber());
		ps.setString(2, cashier_TransactionIndex.getPaymentTitle());
		ps.setString(3, cashier_TransactionIndex.getPaymentDetails());
		ps.setString(4, cashier_TransactionIndex.getORNumber());
		ps.setString(5, cashier_TransactionIndex.getORDate());
		ps.setString(6, cashier_TransactionIndex.getSubTotal());
		ps.setString(7, cashier_TransactionIndex.getVAT());
		ps.setString(8, cashier_TransactionIndex.getTotal());
		ps.setString(9, cashier_TransactionIndex.getNotes());
		ps.setString(10, cashier_TransactionIndex.getUserId());
		ps.setString(11, cashier_TransactionIndex.getcreated_at());
		ps.setString(12, cashier_TransactionIndex.getupdated_at());
		ps.setString(13, cashier_TransactionIndex.getServiceConnectionId());
		ps.setString(14, cashier_TransactionIndex.getTicketId());
		ps.setString(15, cashier_TransactionIndex.getObjectId());
		ps.setString(16, cashier_TransactionIndex.getSource());
		ps.setString(17, cashier_TransactionIndex.getPaymentUsed());
		ps.setString(18, cashier_TransactionIndex.getStatus());
		ps.setString(19, cashier_TransactionIndex.getFiledBy());
		ps.setString(20, cashier_TransactionIndex.getApprovedBy());
		ps.setString(21, cashier_TransactionIndex.getAuditedBy());
		ps.setString(22, cashier_TransactionIndex.getCancellationNotes());
		ps.setString(23, cashier_TransactionIndex.getPayeeName());
		ps.setString(24, cashier_TransactionIndex.getCheckNo());
		ps.setString(25, cashier_TransactionIndex.getBank());
		ps.setString(26, cashier_TransactionIndex.getCheckExpiration());
		ps.setString(27, cashier_TransactionIndex.getAccountNumber());
		ps.setString(28, cashier_TransactionIndex.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_TransactionIndex getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_TransactionIndex WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_TransactionIndex cashier_TransactionIndex = new Cashier_TransactionIndex(
			rs.getString("id"),
			rs.getString("TransactionNumber"),
			rs.getString("PaymentTitle"),
			rs.getString("PaymentDetails"),
			rs.getString("ORNumber"),
			rs.getString("ORDate"),
			rs.getString("SubTotal"),
			rs.getString("VAT"),
			rs.getString("Total"),
			rs.getString("Notes"),
			rs.getString("UserId"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("ServiceConnectionId"),
			rs.getString("TicketId"),
			rs.getString("ObjectId"),
			rs.getString("Source"),
			rs.getString("PaymentUsed"),
			rs.getString("Status"),
			rs.getString("FiledBy"),
			rs.getString("ApprovedBy"),
			rs.getString("AuditedBy"),
			rs.getString("CancellationNotes"),
			rs.getString("PayeeName"),
			rs.getString("CheckNo"),
			rs.getString("Bank"),
			rs.getString("CheckExpiration"),
			rs.getString("AccountNumber")
			);
			ps.close();
			rs.close();
			return cashier_TransactionIndex;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_TransactionIndex> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_TransactionIndex WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_TransactionIndex> cashier_TransactionIndexList = new ArrayList<>();
		while(rs.next()) {
			Cashier_TransactionIndex cashier_TransactionIndex = new Cashier_TransactionIndex();
			cashier_TransactionIndex.setid(rs.getString("id"));
			cashier_TransactionIndex.setTransactionNumber(rs.getString("TransactionNumber"));
			cashier_TransactionIndex.setPaymentTitle(rs.getString("PaymentTitle"));
			cashier_TransactionIndex.setPaymentDetails(rs.getString("PaymentDetails"));
			cashier_TransactionIndex.setORNumber(rs.getString("ORNumber"));
			cashier_TransactionIndex.setORDate(rs.getString("ORDate"));
			cashier_TransactionIndex.setSubTotal(rs.getString("SubTotal"));
			cashier_TransactionIndex.setVAT(rs.getString("VAT"));
			cashier_TransactionIndex.setTotal(rs.getString("Total"));
			cashier_TransactionIndex.setNotes(rs.getString("Notes"));
			cashier_TransactionIndex.setUserId(rs.getString("UserId"));
			cashier_TransactionIndex.setcreated_at(rs.getString("created_at"));
			cashier_TransactionIndex.setupdated_at(rs.getString("updated_at"));
			cashier_TransactionIndex.setServiceConnectionId(rs.getString("ServiceConnectionId"));
			cashier_TransactionIndex.setTicketId(rs.getString("TicketId"));
			cashier_TransactionIndex.setObjectId(rs.getString("ObjectId"));
			cashier_TransactionIndex.setSource(rs.getString("Source"));
			cashier_TransactionIndex.setPaymentUsed(rs.getString("PaymentUsed"));
			cashier_TransactionIndex.setStatus(rs.getString("Status"));
			cashier_TransactionIndex.setFiledBy(rs.getString("FiledBy"));
			cashier_TransactionIndex.setApprovedBy(rs.getString("ApprovedBy"));
			cashier_TransactionIndex.setAuditedBy(rs.getString("AuditedBy"));
			cashier_TransactionIndex.setCancellationNotes(rs.getString("CancellationNotes"));
			cashier_TransactionIndex.setPayeeName(rs.getString("PayeeName"));
			cashier_TransactionIndex.setCheckNo(rs.getString("CheckNo"));
			cashier_TransactionIndex.setBank(rs.getString("Bank"));
			cashier_TransactionIndex.setCheckExpiration(rs.getString("CheckExpiration"));
			cashier_TransactionIndex.setAccountNumber(rs.getString("AccountNumber"));
			cashier_TransactionIndexList.add(cashier_TransactionIndex);
		}
		rs.close();
		ps.close();
		return cashier_TransactionIndexList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_TransactionIndex> billing_Billses = Cashier_TransactionIndexDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_TransactionIndex to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_TransactionIndex bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_TransactionIndex bill = Cashier_TransactionIndexDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_TransactionIndex has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_TransactionIndexDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_TransactionIndex updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_TransactionIndexDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_TransactionIndex inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(35);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
