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
public class Cashier_PaidBillsDAO { 
	public static void insert(Cashier_PaidBills cashier_PaidBills, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_PaidBills(id, BillNumber, AccountNumber, ServicePeriod, ORNumber, ORDate, DCRNumber, KwhUsed, Teller, OfficeTransacted, PostingDate, PostingTime, Surcharge, Form2307TwoPercent, Form2307FivePercent, AdditionalCharges, Deductions, NetAmount, Source, ObjectSourceId, UserId, created_at, updated_at, Status, FiledBy, ApprovedBy, AuditedBy, Notes, CheckNo, Bank, CheckExpiration, PaymentUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cashier_PaidBills.getid());
		ps.setString(2, cashier_PaidBills.getBillNumber());
		ps.setString(3, cashier_PaidBills.getAccountNumber());
		ps.setString(4, cashier_PaidBills.getServicePeriod());
		ps.setString(5, cashier_PaidBills.getORNumber());
		ps.setString(6, cashier_PaidBills.getORDate());
		ps.setString(7, cashier_PaidBills.getDCRNumber());
		ps.setString(8, cashier_PaidBills.getKwhUsed());
		ps.setString(9, cashier_PaidBills.getTeller());
		ps.setString(10, cashier_PaidBills.getOfficeTransacted());
		ps.setString(11, cashier_PaidBills.getPostingDate());
		ps.setString(12, cashier_PaidBills.getPostingTime());
		ps.setString(13, cashier_PaidBills.getSurcharge());
		ps.setString(14, cashier_PaidBills.getForm2307TwoPercent());
		ps.setString(15, cashier_PaidBills.getForm2307FivePercent());
		ps.setString(16, cashier_PaidBills.getAdditionalCharges());
		ps.setString(17, cashier_PaidBills.getDeductions());
		ps.setString(18, cashier_PaidBills.getNetAmount());
		ps.setString(19, cashier_PaidBills.getSource());
		ps.setString(20, cashier_PaidBills.getObjectSourceId());
		ps.setString(21, cashier_PaidBills.getUserId());
		ps.setString(22, cashier_PaidBills.getcreated_at());
		ps.setString(23, cashier_PaidBills.getupdated_at());
		ps.setString(24, cashier_PaidBills.getStatus());
		ps.setString(25, cashier_PaidBills.getFiledBy());
		ps.setString(26, cashier_PaidBills.getApprovedBy());
		ps.setString(27, cashier_PaidBills.getAuditedBy());
		ps.setString(28, cashier_PaidBills.getNotes());
		ps.setString(29, cashier_PaidBills.getCheckNo());
		ps.setString(30, cashier_PaidBills.getBank());
		ps.setString(31, cashier_PaidBills.getCheckExpiration());
		ps.setString(32, cashier_PaidBills.getPaymentUsed());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(Cashier_PaidBills cashier_PaidBills, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE Cashier_PaidBills SET BillNumber=?, AccountNumber=?, ServicePeriod=?, ORNumber=?, ORDate=?, DCRNumber=?, KwhUsed=?, Teller=?, OfficeTransacted=?, PostingDate=?, PostingTime=?, Surcharge=?, Form2307TwoPercent=?, Form2307FivePercent=?, AdditionalCharges=?, Deductions=?, NetAmount=?, Source=?, ObjectSourceId=?, UserId=?, created_at=?, updated_at=?, Status=?, FiledBy=?, ApprovedBy=?, AuditedBy=?, Notes=?, CheckNo=?, Bank=?, CheckExpiration=?, PaymentUsed=?  WHERE id=? ");
		ps.setString(1, cashier_PaidBills.getBillNumber());
		ps.setString(2, cashier_PaidBills.getAccountNumber());
		ps.setString(3, cashier_PaidBills.getServicePeriod());
		ps.setString(4, cashier_PaidBills.getORNumber());
		ps.setString(5, cashier_PaidBills.getORDate());
		ps.setString(6, cashier_PaidBills.getDCRNumber());
		ps.setString(7, cashier_PaidBills.getKwhUsed());
		ps.setString(8, cashier_PaidBills.getTeller());
		ps.setString(9, cashier_PaidBills.getOfficeTransacted());
		ps.setString(10, cashier_PaidBills.getPostingDate());
		ps.setString(11, cashier_PaidBills.getPostingTime());
		ps.setString(12, cashier_PaidBills.getSurcharge());
		ps.setString(13, cashier_PaidBills.getForm2307TwoPercent());
		ps.setString(14, cashier_PaidBills.getForm2307FivePercent());
		ps.setString(15, cashier_PaidBills.getAdditionalCharges());
		ps.setString(16, cashier_PaidBills.getDeductions());
		ps.setString(17, cashier_PaidBills.getNetAmount());
		ps.setString(18, cashier_PaidBills.getSource());
		ps.setString(19, cashier_PaidBills.getObjectSourceId());
		ps.setString(20, cashier_PaidBills.getUserId());
		ps.setString(21, cashier_PaidBills.getcreated_at());
		ps.setString(22, cashier_PaidBills.getupdated_at());
		ps.setString(23, cashier_PaidBills.getStatus());
		ps.setString(24, cashier_PaidBills.getFiledBy());
		ps.setString(25, cashier_PaidBills.getApprovedBy());
		ps.setString(26, cashier_PaidBills.getAuditedBy());
		ps.setString(27, cashier_PaidBills.getNotes());
		ps.setString(28, cashier_PaidBills.getCheckNo());
		ps.setString(29, cashier_PaidBills.getBank());
		ps.setString(30, cashier_PaidBills.getCheckExpiration());
		ps.setString(31, cashier_PaidBills.getPaymentUsed());
		ps.setString(32, cashier_PaidBills.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static Cashier_PaidBills getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_PaidBills WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Cashier_PaidBills cashier_PaidBills = new Cashier_PaidBills(
			rs.getString("id"),
			rs.getString("BillNumber"),
			rs.getString("AccountNumber"),
			rs.getString("ServicePeriod"),
			rs.getString("ORNumber"),
			rs.getString("ORDate"),
			rs.getString("DCRNumber"),
			rs.getString("KwhUsed"),
			rs.getString("Teller"),
			rs.getString("OfficeTransacted"),
			rs.getString("PostingDate"),
			rs.getString("PostingTime"),
			rs.getString("Surcharge"),
			rs.getString("Form2307TwoPercent"),
			rs.getString("Form2307FivePercent"),
			rs.getString("AdditionalCharges"),
			rs.getString("Deductions"),
			rs.getString("NetAmount"),
			rs.getString("Source"),
			rs.getString("ObjectSourceId"),
			rs.getString("UserId"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Status"),
			rs.getString("FiledBy"),
			rs.getString("ApprovedBy"),
			rs.getString("AuditedBy"),
			rs.getString("Notes"),
			rs.getString("CheckNo"),
			rs.getString("Bank"),
			rs.getString("CheckExpiration"),
			rs.getString("PaymentUsed")
			);
			ps.close();
			rs.close();
			return cashier_PaidBills;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<Cashier_PaidBills> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_PaidBills WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<Cashier_PaidBills> cashier_PaidBillsList = new ArrayList<>();
		while(rs.next()) {
			Cashier_PaidBills cashier_PaidBills = new Cashier_PaidBills();
			cashier_PaidBills.setid(rs.getString("id"));
			cashier_PaidBills.setBillNumber(rs.getString("BillNumber"));
			cashier_PaidBills.setAccountNumber(rs.getString("AccountNumber"));
			cashier_PaidBills.setServicePeriod(rs.getString("ServicePeriod"));
			cashier_PaidBills.setORNumber(rs.getString("ORNumber"));
			cashier_PaidBills.setORDate(rs.getString("ORDate"));
			cashier_PaidBills.setDCRNumber(rs.getString("DCRNumber"));
			cashier_PaidBills.setKwhUsed(rs.getString("KwhUsed"));
			cashier_PaidBills.setTeller(rs.getString("Teller"));
			cashier_PaidBills.setOfficeTransacted(rs.getString("OfficeTransacted"));
			cashier_PaidBills.setPostingDate(rs.getString("PostingDate"));
			cashier_PaidBills.setPostingTime(rs.getString("PostingTime"));
			cashier_PaidBills.setSurcharge(rs.getString("Surcharge"));
			cashier_PaidBills.setForm2307TwoPercent(rs.getString("Form2307TwoPercent"));
			cashier_PaidBills.setForm2307FivePercent(rs.getString("Form2307FivePercent"));
			cashier_PaidBills.setAdditionalCharges(rs.getString("AdditionalCharges"));
			cashier_PaidBills.setDeductions(rs.getString("Deductions"));
			cashier_PaidBills.setNetAmount(rs.getString("NetAmount"));
			cashier_PaidBills.setSource(rs.getString("Source"));
			cashier_PaidBills.setObjectSourceId(rs.getString("ObjectSourceId"));
			cashier_PaidBills.setUserId(rs.getString("UserId"));
			cashier_PaidBills.setcreated_at(rs.getString("created_at"));
			cashier_PaidBills.setupdated_at(rs.getString("updated_at"));
			cashier_PaidBills.setStatus(rs.getString("Status"));
			cashier_PaidBills.setFiledBy(rs.getString("FiledBy"));
			cashier_PaidBills.setApprovedBy(rs.getString("ApprovedBy"));
			cashier_PaidBills.setAuditedBy(rs.getString("AuditedBy"));
			cashier_PaidBills.setNotes(rs.getString("Notes"));
			cashier_PaidBills.setCheckNo(rs.getString("CheckNo"));
			cashier_PaidBills.setBank(rs.getString("Bank"));
			cashier_PaidBills.setCheckExpiration(rs.getString("CheckExpiration"));
			cashier_PaidBills.setPaymentUsed(rs.getString("PaymentUsed"));
			cashier_PaidBillsList.add(cashier_PaidBills);
		}
		rs.close();
		ps.close();
		return cashier_PaidBillsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<Cashier_PaidBills> billing_Billses = Cashier_PaidBillsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing Cashier_PaidBills to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (Cashier_PaidBills bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Cashier_PaidBills bill = Cashier_PaidBillsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in Cashier_PaidBills has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        Cashier_PaidBillsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in Cashier_PaidBills updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    Cashier_PaidBillsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in Cashier_PaidBills inserted";
                                }
                                ObjectHelpers.logger(synclogs, message);
                            } catch (Exception ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                ObjectHelpers.logger(synclogs, ex.getMessage());
                            }
                        }                        
                    });
                    try {
                        Thread.sleep(75);
                    } catch (InterruptedException ex) {
                       ObjectHelpers.logger(synclogs, ex.getMessage());
                    }
                }            
            } catch (Exception e) {
                others.Notifiers.showErrorMessage("Error Updating " + subscriberSelected, e.getMessage());
            }
        }
} 
