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
public class CRM_TicketsDAO { 
	public static void insert(CRM_Tickets cRM_Tickets, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("INSERT INTO CRM_Tickets(id, AccountNumber, ConsumerName, Town, Barangay, Sitio, Ticket, Reason, ContactNumber, ReportedBy, ORNumber, ORDate, GeoLocation, Neighbor1, Neighbor2, Notes, Status, DateTimeDownloaded, DateTimeLinemanArrived, DateTimeLinemanExecuted, UserId, CrewAssigned, created_at, updated_at, Trash, Office, CurrentMeterNo, CurrentMeterBrand, CurrentMeterReading, KwhRating, PercentError, NewMeterNo, NewMeterBrand, NewMeterReading, ServicePeriod) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, cRM_Tickets.getid());
		ps.setString(2, cRM_Tickets.getAccountNumber());
		ps.setString(3, cRM_Tickets.getConsumerName());
		ps.setString(4, cRM_Tickets.getTown());
		ps.setString(5, cRM_Tickets.getBarangay());
		ps.setString(6, cRM_Tickets.getSitio());
		ps.setString(7, cRM_Tickets.getTicket());
		ps.setString(8, cRM_Tickets.getReason());
		ps.setString(9, cRM_Tickets.getContactNumber());
		ps.setString(10, cRM_Tickets.getReportedBy());
		ps.setString(11, cRM_Tickets.getORNumber());
		ps.setString(12, cRM_Tickets.getORDate());
		ps.setString(13, cRM_Tickets.getGeoLocation());
		ps.setString(14, cRM_Tickets.getNeighbor1());
		ps.setString(15, cRM_Tickets.getNeighbor2());
		ps.setString(16, cRM_Tickets.getNotes());
		ps.setString(17, cRM_Tickets.getStatus());
		ps.setString(18, cRM_Tickets.getDateTimeDownloaded());
		ps.setString(19, cRM_Tickets.getDateTimeLinemanArrived());
		ps.setString(20, cRM_Tickets.getDateTimeLinemanExecuted());
		ps.setString(21, cRM_Tickets.getUserId());
		ps.setString(22, cRM_Tickets.getCrewAssigned());
		ps.setString(23, cRM_Tickets.getcreated_at());
		ps.setString(24, cRM_Tickets.getupdated_at());
		ps.setString(25, cRM_Tickets.getTrash());
		ps.setString(26, cRM_Tickets.getOffice());
		ps.setString(27, cRM_Tickets.getCurrentMeterNo());
		ps.setString(28, cRM_Tickets.getCurrentMeterBrand());
		ps.setString(29, cRM_Tickets.getCurrentMeterReading());
		ps.setString(30, cRM_Tickets.getKwhRating());
		ps.setString(31, cRM_Tickets.getPercentError());
		ps.setString(32, cRM_Tickets.getNewMeterNo());
		ps.setString(33, cRM_Tickets.getNewMeterBrand());
		ps.setString(34, cRM_Tickets.getNewMeterReading());
		ps.setString(35, cRM_Tickets.getServicePeriod());
		ps.executeUpdate();
		ps.close();
	} 
	public static void update(CRM_Tickets cRM_Tickets, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("UPDATE CRM_Tickets SET AccountNumber=?, ConsumerName=?, Town=?, Barangay=?, Sitio=?, Ticket=?, Reason=?, ContactNumber=?, ReportedBy=?, ORNumber=?, ORDate=?, GeoLocation=?, Neighbor1=?, Neighbor2=?, Notes=?, Status=?, DateTimeDownloaded=?, DateTimeLinemanArrived=?, DateTimeLinemanExecuted=?, UserId=?, CrewAssigned=?, created_at=?, updated_at=?, Trash=?, Office=?, CurrentMeterNo=?, CurrentMeterBrand=?, CurrentMeterReading=?, KwhRating=?, PercentError=?, NewMeterNo=?, NewMeterBrand=?, NewMeterReading=?, ServicePeriod=?  WHERE id=? ");
		ps.setString(1, cRM_Tickets.getAccountNumber());
		ps.setString(2, cRM_Tickets.getConsumerName());
		ps.setString(3, cRM_Tickets.getTown());
		ps.setString(4, cRM_Tickets.getBarangay());
		ps.setString(5, cRM_Tickets.getSitio());
		ps.setString(6, cRM_Tickets.getTicket());
		ps.setString(7, cRM_Tickets.getReason());
		ps.setString(8, cRM_Tickets.getContactNumber());
		ps.setString(9, cRM_Tickets.getReportedBy());
		ps.setString(10, cRM_Tickets.getORNumber());
		ps.setString(11, cRM_Tickets.getORDate());
		ps.setString(12, cRM_Tickets.getGeoLocation());
		ps.setString(13, cRM_Tickets.getNeighbor1());
		ps.setString(14, cRM_Tickets.getNeighbor2());
		ps.setString(15, cRM_Tickets.getNotes());
		ps.setString(16, cRM_Tickets.getStatus());
		ps.setString(17, cRM_Tickets.getDateTimeDownloaded());
		ps.setString(18, cRM_Tickets.getDateTimeLinemanArrived());
		ps.setString(19, cRM_Tickets.getDateTimeLinemanExecuted());
		ps.setString(20, cRM_Tickets.getUserId());
		ps.setString(21, cRM_Tickets.getCrewAssigned());
		ps.setString(22, cRM_Tickets.getcreated_at());
		ps.setString(23, cRM_Tickets.getupdated_at());
		ps.setString(24, cRM_Tickets.getTrash());
		ps.setString(25, cRM_Tickets.getOffice());
		ps.setString(26, cRM_Tickets.getCurrentMeterNo());
		ps.setString(27, cRM_Tickets.getCurrentMeterBrand());
		ps.setString(28, cRM_Tickets.getCurrentMeterReading());
		ps.setString(29, cRM_Tickets.getKwhRating());
		ps.setString(30, cRM_Tickets.getPercentError());
		ps.setString(31, cRM_Tickets.getNewMeterNo());
		ps.setString(32, cRM_Tickets.getNewMeterBrand());
		ps.setString(33, cRM_Tickets.getNewMeterReading());
		ps.setString(34, cRM_Tickets.getServicePeriod());
		ps.setString(35, cRM_Tickets.getid());
		ps.executeUpdate();
		ps.close();
	} 
	public static CRM_Tickets getOne(String id, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_Tickets WHERE id=?");
		ps.setString(1, id);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CRM_Tickets cRM_Tickets = new CRM_Tickets(
			rs.getString("id"),
			rs.getString("AccountNumber"),
			rs.getString("ConsumerName"),
			rs.getString("Town"),
			rs.getString("Barangay"),
			rs.getString("Sitio"),
			rs.getString("Ticket"),
			rs.getString("Reason"),
			rs.getString("ContactNumber"),
			rs.getString("ReportedBy"),
			rs.getString("ORNumber"),
			rs.getString("ORDate"),
			rs.getString("GeoLocation"),
			rs.getString("Neighbor1"),
			rs.getString("Neighbor2"),
			rs.getString("Notes"),
			rs.getString("Status"),
			rs.getString("DateTimeDownloaded"),
			rs.getString("DateTimeLinemanArrived"),
			rs.getString("DateTimeLinemanExecuted"),
			rs.getString("UserId"),
			rs.getString("CrewAssigned"),
			rs.getString("created_at"),
			rs.getString("updated_at"),
			rs.getString("Trash"),
			rs.getString("Office"),
			rs.getString("CurrentMeterNo"),
			rs.getString("CurrentMeterBrand"),
			rs.getString("CurrentMeterReading"),
			rs.getString("KwhRating"),
			rs.getString("PercentError"),
			rs.getString("NewMeterNo"),
			rs.getString("NewMeterBrand"),
			rs.getString("NewMeterReading"),
			rs.getString("ServicePeriod")
			);
			ps.close();
			rs.close();
			return cRM_Tickets;
		}
		rs.close();
		ps.close();
		return null;
	} 
	public static List<CRM_Tickets> selectUpdatedAt(String from, String to, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_Tickets WHERE updated_at BETWEEN ? AND ?");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		List<CRM_Tickets> cRM_TicketsList = new ArrayList<>();
		while(rs.next()) {
			CRM_Tickets cRM_Tickets = new CRM_Tickets();
			cRM_Tickets.setid(rs.getString("id"));
			cRM_Tickets.setAccountNumber(rs.getString("AccountNumber"));
			cRM_Tickets.setConsumerName(rs.getString("ConsumerName"));
			cRM_Tickets.setTown(rs.getString("Town"));
			cRM_Tickets.setBarangay(rs.getString("Barangay"));
			cRM_Tickets.setSitio(rs.getString("Sitio"));
			cRM_Tickets.setTicket(rs.getString("Ticket"));
			cRM_Tickets.setReason(rs.getString("Reason"));
			cRM_Tickets.setContactNumber(rs.getString("ContactNumber"));
			cRM_Tickets.setReportedBy(rs.getString("ReportedBy"));
			cRM_Tickets.setORNumber(rs.getString("ORNumber"));
			cRM_Tickets.setORDate(rs.getString("ORDate"));
			cRM_Tickets.setGeoLocation(rs.getString("GeoLocation"));
			cRM_Tickets.setNeighbor1(rs.getString("Neighbor1"));
			cRM_Tickets.setNeighbor2(rs.getString("Neighbor2"));
			cRM_Tickets.setNotes(rs.getString("Notes"));
			cRM_Tickets.setStatus(rs.getString("Status"));
			cRM_Tickets.setDateTimeDownloaded(rs.getString("DateTimeDownloaded"));
			cRM_Tickets.setDateTimeLinemanArrived(rs.getString("DateTimeLinemanArrived"));
			cRM_Tickets.setDateTimeLinemanExecuted(rs.getString("DateTimeLinemanExecuted"));
			cRM_Tickets.setUserId(rs.getString("UserId"));
			cRM_Tickets.setCrewAssigned(rs.getString("CrewAssigned"));
			cRM_Tickets.setcreated_at(rs.getString("created_at"));
			cRM_Tickets.setupdated_at(rs.getString("updated_at"));
			cRM_Tickets.setTrash(rs.getString("Trash"));
			cRM_Tickets.setOffice(rs.getString("Office"));
			cRM_Tickets.setCurrentMeterNo(rs.getString("CurrentMeterNo"));
			cRM_Tickets.setCurrentMeterBrand(rs.getString("CurrentMeterBrand"));
			cRM_Tickets.setCurrentMeterReading(rs.getString("CurrentMeterReading"));
			cRM_Tickets.setKwhRating(rs.getString("KwhRating"));
			cRM_Tickets.setPercentError(rs.getString("PercentError"));
			cRM_Tickets.setNewMeterNo(rs.getString("NewMeterNo"));
			cRM_Tickets.setNewMeterBrand(rs.getString("NewMeterBrand"));
			cRM_Tickets.setNewMeterReading(rs.getString("NewMeterReading"));
			cRM_Tickets.setServicePeriod(rs.getString("ServicePeriod"));
			cRM_TicketsList.add(cRM_Tickets);
		}
		rs.close();
		ps.close();
		return cRM_TicketsList;
	} 
        
        public static void performUpdate(JLabel quickStats, JTextArea synclogs, String subscriberSelected, String from, String to, DBConnection connectionPublisher, DBConnection connectionSubscribers) {
            try {
                List<CRM_Tickets> billing_Billses = CRM_TicketsDAO.selectUpdatedAt(from, to, connectionPublisher.getInitializedConnection());
                        
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        quickStats.setText("Synchronizing CRM_Tickets to " + subscriberSelected + " (" + billing_Billses.size() + " data found)");
                    }
                });

                for (CRM_Tickets bills : billing_Billses) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CRM_Tickets bill = CRM_TicketsDAO.getOne(bills.getid(), connectionSubscribers.getInitializedConnection());
                                String message = "";
                                if (bill != null) {
                                    // UPDATE MODULE
                                    if (bills.getupdated_at().equals(bill.getupdated_at())) {
                                        // SKIP IF UNTOUCHED
                                        message = "ID " + bill.getid() + " in CRM_Tickets has no changes, skipping update";
                                    } else {
                                        // UPDATE
                                        CRM_TicketsDAO.update(bill, connectionSubscribers.getInitializedConnection());
                                        message = "ID " + bill.getid() + " in CRM_Tickets updated";
                                    }                                            
                                } else {
                                    // CREATE
                                    CRM_TicketsDAO.insert(bills, connectionSubscribers.getInitializedConnection());
                                    message = "ID " + bills.getid() + " in CRM_Tickets inserted";
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
