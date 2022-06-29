/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package replicationagent;

import classes.Subscriber;
import classes.Subscribers;
import db.DBConnection;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import others.Notifiers;
import others.ObjectHelpers;
import tableclasses.Billing_AccountLocationHistoryDAO;
import tableclasses.Billing_AccountNameHistoryDAO;
import tableclasses.Billing_ArrearsLedgerDistributionDAO;
import tableclasses.Billing_BAPAReadingScheduleDAO;
import tableclasses.Billing_BillsDAO;
import tableclasses.Billing_BillsOriginalDAO;
import tableclasses.Billing_ChangeMeterLogsDAO;
import tableclasses.Billing_CollectiblesDAO;
import tableclasses.Billing_KwhSalesDAO;
import tableclasses.Billing_MeterReadersDAO;
import tableclasses.Billing_MetersDAO;
import tableclasses.Billing_PendingBillAdjustmentsDAO;
import tableclasses.Billing_PrePaymentBalanceDAO;
import tableclasses.Billing_PrePaymentTransactionHistoryDAO;
import tableclasses.Billing_RatesDAO;
import tableclasses.Billing_ReadingImagesDAO;
import tableclasses.Billing_ReadingSchedulesDAO;
import tableclasses.Billing_ReadingsDAO;
import tableclasses.Billing_ServiceAccountsDAO;
import tableclasses.Billing_TransformersDAO;
import tableclasses.CRM_BarangaysDAO;
import tableclasses.CRM_BillOfMaterialsDetailsDAO;
import tableclasses.CRM_BillOfMaterialsIndexDAO;
import tableclasses.CRM_BillOfMaterialsMatrixDAO;
import tableclasses.CRM_BillsOfMaterialsSummaryDAO;
import tableclasses.CRM_LargeLoadInspectionsDAO;
import tableclasses.CRM_MastPolesDAO;
import tableclasses.CRM_MaterialAssetsDAO;
import tableclasses.CRM_MaterialsMatrixDAO;
import tableclasses.CRM_MemberConsumerChecklistsDAO;
import tableclasses.CRM_MemberConsumerChecklistsRepositoryDAO;
import tableclasses.CRM_MemberConsumerImagesDAO;
import tableclasses.CRM_MemberConsumerSpouseDAO;
import tableclasses.CRM_MemberConsumerTypesDAO;
import tableclasses.CRM_MemberConsumersDAO;
import tableclasses.CRM_PoleIndexDAO;
import tableclasses.CRM_PreDefinedMaterialsDAO;
import tableclasses.CRM_PreDefinedMaterialsMatrixDAO;
import tableclasses.CRM_ServiceConnectionAccountTypesDAO;
import tableclasses.CRM_ServiceConnectionChecklistDAO;
import tableclasses.CRM_ServiceConnectionChecklistRepositoryDAO;
import tableclasses.CRM_ServiceConnectionCrewDAO;
import tableclasses.CRM_ServiceConnectionImagesDAO;
import tableclasses.CRM_ServiceConnectionInspectionsDAO;
import tableclasses.CRM_ServiceConnectionMaterialPayablesDAO;
import tableclasses.CRM_ServiceConnectionMeterAndTransformerDAO;
import tableclasses.CRM_ServiceConnectionParticularPaymentsTransactionsDAO;
import tableclasses.CRM_ServiceConnectionPaymentParticularsDAO;
import tableclasses.CRM_ServiceConnectionTimeframesDAO;
import tableclasses.CRM_ServiceConnectionTotalPaymentsDAO;
import tableclasses.CRM_ServiceConnectionsDAO;
import tableclasses.CRM_SpanninDataDAO;
import tableclasses.CRM_SpanningIndexDAO;
import tableclasses.CRM_SpecialEquipmentMaterialsDAO;
import tableclasses.CRM_StructureAssignmentsDAO;
import tableclasses.CRM_StructuresDAO;
import tableclasses.CRM_TicketLogsDAO;
import tableclasses.CRM_TicketsDAO;
import tableclasses.CRM_TicketsRepositoryDAO;
import tableclasses.CRM_TownsDAO;
import tableclasses.CRM_TransformerIndexDAO;
import tableclasses.CRM_TransformersAssignedMatrixDAO;
import tableclasses.Cache_Cashier_OtherPaymentsDAO;
import tableclasses.Cashier_AccountGLCodesDAO;
import tableclasses.Cashier_BAPAAdjustmentDetailsDAO;
import tableclasses.Cashier_BAPAAdjustmentsDAO;
import tableclasses.Cashier_BAPAPaymentsDAO;
import tableclasses.Cashier_DCRIndexDAO;
import tableclasses.Cashier_DCRSummaryTransactionsDAO;
import tableclasses.Cashier_DenominationsDAO;
import tableclasses.Cashier_ORAssigningDAO;
import tableclasses.Cashier_ORCancellationsDAO;
import tableclasses.Cashier_PaidBillsDAO;
import tableclasses.Cashier_PaidBillsDetailsDAO;
import tableclasses.Cashier_TransactionDetailsDAO;
import tableclasses.Cashier_TransactionIndexDAO;
import tableclasses.Cashier_TransactionPaymentDetailsDAO;
import tableclasses.Disconnection_HistoryDAO;
import tableclasses.Disconnection_NoticeHistoryDAO;
import tableclasses.NotifiersDAO;
import tableclasses.Reports_DistributionSystemLossDAO;
import tableclasses.Reports_RateItemsDAO;

/**
 *
 * @author Julio Lopez
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    DBConnection connectionSubscribers;
    DBConnection connectionPublisher;
    Subscribers subscribers;
    Subscriber publisher;
    List<Subscriber> subscribersList;
    String server = null;
    
    // LIST OF DB
    DefaultListModel defaultListModel;
    
    public String subscriberSelected;
    
    public MainFrame() {
        initComponents();
        setTitle("NONECO Replication Agent");
        setExtendedState(MAXIMIZED_BOTH);
        setSize(1000, 700);
        setLocationRelativeTo(this);
        
        connectionSubscribers = new DBConnection();
        connectionPublisher = new DBConnection();
        server = connectionPublisher.getServer();
        
        subscribers = new Subscribers();
        subscribersList = subscribers.getSubscribers();
        
        publisher = connectionSubscribers.getPublisher();
        connectionPublisher.getDbConnectionFromDatabase(publisher.getDatabase(), publisher.getUsername(), publisher.getPassword(), server);
        
        defaultListModel = new DefaultListModel<>();
        
        displayDatabaseList();        
    }
    
    public void pullandPushData() {
        try {
            pullAndPushData.setEnabled(false);
            pullOnly.setEnabled(false);
            int subSize = subscribersList.size();
            String from = dateFrom.getText();
            String to = dateTo.getText();
            if (from.isEmpty() || to.isEmpty()) {
                Notifiers.showErrorMessage("Provide Dates", "Please supply the FROM and TO dates to perform the replication.");                
            } else {
                /**
                 * LOOP SUBSCRIBERS
                 */   
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try { 
                            // START LOOP
                            // PULL DATA
                            for (int i=0; i<subSize; i++) {
                                subscriberName.setText("Pulling data from " + subscribersList.get(i).getDatabase());
                                databaseLists.setSelectedValue(subscribersList.get(i).getDatabase(), rootPaneCheckingEnabled);
                                connectionSubscribers.getDbConnectionFromDatabase(subscribersList.get(i).getDatabase(), subscribersList.get(i).getUsername(), subscribersList.get(i).getPassword(), server);
                                
                                Billing_AccountLocationHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_AccountNameHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ArrearsLedgerDistributionDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_BAPAReadingScheduleDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_BillsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_BillsOriginalDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ChangeMeterLogsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_CollectiblesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_KwhSalesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_MeterReadersDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_MetersDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_PendingBillAdjustmentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_PrePaymentBalanceDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_PrePaymentTransactionHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_RatesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ReadingImagesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ReadingSchedulesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ReadingsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ServiceAccountsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_TransformersDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_BarangaysDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_BillOfMaterialsDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_BillOfMaterialsIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_BillOfMaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_BillsOfMaterialsSummaryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_LargeLoadInspectionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MastPolesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MaterialAssetsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumerChecklistsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumerChecklistsRepositoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumerImagesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumerSpouseDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumerTypesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumersDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_PoleIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_PreDefinedMaterialsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_PreDefinedMaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionAccountTypesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionChecklistDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionChecklistRepositoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionCrewDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionImagesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionInspectionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionMaterialPayablesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionMeterAndTransformerDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionParticularPaymentsTransactionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionPaymentParticularsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionTimeframesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionTotalPaymentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_SpanninDataDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_SpanningIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_SpecialEquipmentMaterialsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_StructureAssignmentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_StructuresDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TicketLogsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TicketsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TicketsRepositoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TownsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TransformerIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TransformersAssignedMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cache_Cashier_OtherPaymentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_AccountGLCodesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_BAPAAdjustmentDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_BAPAAdjustmentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_BAPAPaymentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_DCRIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_DCRSummaryTransactionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_DenominationsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_ORAssigningDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_ORCancellationsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_PaidBillsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_PaidBillsDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_TransactionDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_TransactionIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_TransactionPaymentDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Disconnection_HistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Disconnection_NoticeHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                NotifiersDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Reports_DistributionSystemLossDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                /** 
                                 * THIS IS THE LAST ONE, PROVIDE INDICATOR IF DONE
                                 */
                                Reports_RateItemsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                quickStats.setText("Sync done!");
                                ObjectHelpers.logger(synclogs, "Sync complete.");
                            }
                            quickStats.setText("Pulling of data from all subscribers completed!");
                            ObjectHelpers.logger(synclogs, "Pulling of data complete.");
                            
                            /**
                             * START OF PUSHING DATA TO EVERY SERVER
                             */
                            for (int j=0; j<subSize; j++) {
                                subscriberName.setText("Pushing data to " + subscribersList.get(j).getDatabase());                                
                                databaseLists.setSelectedValue(subscribersList.get(j).getDatabase(), rootPaneCheckingEnabled);
                                connectionSubscribers.getDbConnectionFromDatabase(subscribersList.get(j).getDatabase(), subscribersList.get(j).getUsername(), subscribersList.get(j).getPassword(), server);
                            
                                Billing_AccountLocationHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_AccountNameHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_ArrearsLedgerDistributionDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_BAPAReadingScheduleDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_BillsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_BillsOriginalDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_ChangeMeterLogsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_CollectiblesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_KwhSalesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_MeterReadersDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_MetersDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_PendingBillAdjustmentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_PrePaymentBalanceDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_PrePaymentTransactionHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_RatesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_ReadingImagesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_ReadingSchedulesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_ReadingsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_ServiceAccountsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Billing_TransformersDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_BarangaysDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_BillOfMaterialsDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_BillOfMaterialsIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_BillOfMaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_BillsOfMaterialsSummaryDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_LargeLoadInspectionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_MastPolesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_MaterialAssetsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_MaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_MemberConsumerChecklistsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_MemberConsumerChecklistsRepositoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_MemberConsumerImagesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_MemberConsumerSpouseDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_MemberConsumerTypesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_MemberConsumersDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_PoleIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_PreDefinedMaterialsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_PreDefinedMaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionAccountTypesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionChecklistDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionChecklistRepositoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionCrewDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionImagesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionInspectionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionMaterialPayablesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionMeterAndTransformerDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionParticularPaymentsTransactionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionPaymentParticularsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionTimeframesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionTotalPaymentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_ServiceConnectionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_SpanninDataDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_SpanningIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_SpecialEquipmentMaterialsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_StructureAssignmentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_StructuresDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_TicketLogsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_TicketsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_TicketsRepositoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_TownsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_TransformerIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                CRM_TransformersAssignedMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cache_Cashier_OtherPaymentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_AccountGLCodesDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_BAPAAdjustmentDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_BAPAAdjustmentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_BAPAPaymentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_DCRIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_DCRSummaryTransactionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_DenominationsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_ORAssigningDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_ORCancellationsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_PaidBillsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_PaidBillsDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_TransactionDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_TransactionIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Cashier_TransactionPaymentDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Disconnection_HistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Disconnection_NoticeHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                NotifiersDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Reports_DistributionSystemLossDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);

                                Reports_RateItemsDAO.performUpdate(quickStats, synclogs, subscribersList.get(j).getDatabase(), from, to, connectionPublisher, connectionSubscribers);
//                                syncButton.setEnabled(true);
                            }
                            subscriberName.setText("Replication Complete");
                            pullAndPushData.setEnabled(true);
                            pullOnly.setEnabled(true);
                            quickStats.setText("Sync done!");
                            ObjectHelpers.logger(synclogs, "Sync complete.");
                        } catch (Exception ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                            ObjectHelpers.logger(synclogs, ex.getMessage());
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Connecting to DBs", e.getMessage());
        }
    }
    
    public void pullOnlyData() {
        try {
            pullAndPushData.setEnabled(false);
            pullOnly.setEnabled(false);
            int subSize = subscribersList.size();
            String from = dateFrom.getText();
            String to = dateTo.getText();
            if (from.isEmpty() || to.isEmpty()) {
                Notifiers.showErrorMessage("Provide Dates", "Please supply the FROM and TO dates to perform the replication.");                
            } else {
                /**
                 * LOOP SUBSCRIBERS
                 */   
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try { 
                            // START LOOP
                            // PULL DATA
                            for (int i=0; i<subSize; i++) {
                                subscriberName.setText("Pulling data from " + subscribersList.get(i).getDatabase());
                                databaseLists.setSelectedValue(subscribersList.get(i).getDatabase(), rootPaneCheckingEnabled);
                                connectionSubscribers.getDbConnectionFromDatabase(subscribersList.get(i).getDatabase(), subscribersList.get(i).getUsername(), subscribersList.get(i).getPassword(), server);
                                
                                Billing_AccountLocationHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_AccountNameHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ArrearsLedgerDistributionDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_BAPAReadingScheduleDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_BillsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_BillsOriginalDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ChangeMeterLogsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_CollectiblesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_KwhSalesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_MeterReadersDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_MetersDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_PendingBillAdjustmentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_PrePaymentBalanceDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_PrePaymentTransactionHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_RatesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ReadingImagesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ReadingSchedulesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ReadingsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_ServiceAccountsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Billing_TransformersDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_BarangaysDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_BillOfMaterialsDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_BillOfMaterialsIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_BillOfMaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_BillsOfMaterialsSummaryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_LargeLoadInspectionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MastPolesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MaterialAssetsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumerChecklistsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumerChecklistsRepositoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumerImagesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumerSpouseDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumerTypesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_MemberConsumersDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_PoleIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_PreDefinedMaterialsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_PreDefinedMaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionAccountTypesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionChecklistDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionChecklistRepositoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionCrewDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionImagesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionInspectionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionMaterialPayablesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionMeterAndTransformerDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionParticularPaymentsTransactionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionPaymentParticularsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionTimeframesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionTotalPaymentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_ServiceConnectionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_SpanninDataDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_SpanningIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_SpecialEquipmentMaterialsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_StructureAssignmentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_StructuresDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TicketLogsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TicketsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TicketsRepositoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TownsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TransformerIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                CRM_TransformersAssignedMatrixDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cache_Cashier_OtherPaymentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_AccountGLCodesDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_BAPAAdjustmentDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_BAPAAdjustmentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_BAPAPaymentsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_DCRIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_DCRSummaryTransactionsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_DenominationsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_ORAssigningDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_ORCancellationsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_PaidBillsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_PaidBillsDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_TransactionDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_TransactionIndexDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Cashier_TransactionPaymentDetailsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Disconnection_HistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Disconnection_NoticeHistoryDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                NotifiersDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                Reports_DistributionSystemLossDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                /** 
                                 * THIS IS THE LAST ONE, PROVIDE INDICATOR IF DONE
                                 */
                                Reports_RateItemsDAO.performUpdate(quickStats, synclogs, subscribersList.get(i).getDatabase(), from, to, connectionSubscribers, connectionPublisher);

                                quickStats.setText("Sync done!");
                                ObjectHelpers.logger(synclogs, "Sync complete.");
                            }
                            quickStats.setText("Pulling of data from all subscribers completed!");
                            ObjectHelpers.logger(synclogs, "Pulling of data complete.");
                            subscriberName.setText("Replication Complete");
                            
                            pullAndPushData.setEnabled(true);
                            pullOnly.setEnabled(true);
                            quickStats.setText("Sync done!");
                            ObjectHelpers.logger(synclogs, "Sync complete.");
                        } catch (Exception ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                            ObjectHelpers.logger(synclogs, ex.getMessage());
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Connecting to DBs", e.getMessage());
        }
    }
    
    public void transact() {
        try {
            /**
             * CONNECT TO DATABASE
             */
            String from = dateFrom.getText();
            String to = dateTo.getText();
            
            if (from.isEmpty() || to.isEmpty()) {
                Notifiers.showErrorMessage("Provide Dates", "Please supply the FROM and TO dates to perform the replication.");                
            } else {
                Optional<Subscriber> selectedSubscriber = ObjectHelpers.containsName(subscribersList, subscriberSelected);
                connectionSubscribers.getDbConnectionFromDatabase(selectedSubscriber.get().getDatabase(), selectedSubscriber.get().getUsername(), selectedSubscriber.get().getPassword(), server);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {  
                            Billing_AccountLocationHistoryDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_AccountNameHistoryDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_ArrearsLedgerDistributionDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_BAPAReadingScheduleDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_BillsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_BillsOriginalDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_ChangeMeterLogsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_CollectiblesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_KwhSalesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_MeterReadersDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_MetersDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_PendingBillAdjustmentsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_PrePaymentBalanceDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_PrePaymentTransactionHistoryDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_RatesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_ReadingImagesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_ReadingSchedulesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_ReadingsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_ServiceAccountsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Billing_TransformersDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_BarangaysDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_BillOfMaterialsDetailsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_BillOfMaterialsIndexDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_BillOfMaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_BillsOfMaterialsSummaryDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_LargeLoadInspectionsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_MastPolesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_MaterialAssetsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_MaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_MemberConsumerChecklistsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_MemberConsumerChecklistsRepositoryDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_MemberConsumerImagesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_MemberConsumerSpouseDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_MemberConsumerTypesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_MemberConsumersDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_PoleIndexDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_PreDefinedMaterialsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_PreDefinedMaterialsMatrixDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionAccountTypesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionChecklistDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionChecklistRepositoryDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionCrewDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionImagesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionInspectionsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionMaterialPayablesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionMeterAndTransformerDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionParticularPaymentsTransactionsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionPaymentParticularsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionTimeframesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionTotalPaymentsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_ServiceConnectionsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_SpanninDataDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_SpanningIndexDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_SpecialEquipmentMaterialsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_StructureAssignmentsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_StructuresDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_TicketLogsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_TicketsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_TicketsRepositoryDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_TownsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_TransformerIndexDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            CRM_TransformersAssignedMatrixDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cache_Cashier_OtherPaymentsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_AccountGLCodesDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_BAPAAdjustmentDetailsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_BAPAAdjustmentsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_BAPAPaymentsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_DCRIndexDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_DCRSummaryTransactionsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_DenominationsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_ORAssigningDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_ORCancellationsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_PaidBillsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_PaidBillsDetailsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_TransactionDetailsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_TransactionIndexDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Cashier_TransactionPaymentDetailsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Disconnection_HistoryDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Disconnection_NoticeHistoryDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            NotifiersDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            Reports_DistributionSystemLossDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);

                            /** 
                             * THIS IS THE LAST ONE, PROVIDE INDICATOR IF DONE
                             */
                            Reports_RateItemsDAO.performUpdate(quickStats, synclogs, subscriberSelected, from, to, connectionPublisher, connectionSubscribers);
//                            syncButton.setEnabled(true);
                            quickStats.setText("Sync done!");
                            ObjectHelpers.logger(synclogs, "Sync complete.");
                        } catch (Exception ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                            ObjectHelpers.logger(synclogs, ex.getMessage());
                        }
                    }
                }).start();
            }           
                    
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Connecting to DBs", e.getMessage());
        }
    }
    
    public void displayDatabaseList() {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0; i<subscribersList.size(); i++) {
                        defaultListModel.addElement(subscribersList.get(i).getDatabase());
                    }
                    databaseLists.setModel(defaultListModel);
                    
                    // display publisher
                    publisherName.setText(publisher.getDatabase());
                }
            }).run();
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Displaying DBs", e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainSplitPane = new javax.swing.JSplitPane();
        leftSplitPanePanel = new javax.swing.JPanel();
        leftPaneSplitPanel = new javax.swing.JSplitPane();
        databaseListPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        databaseLists = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        publisherName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        subscriberName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateTo = new javax.swing.JTextField();
        dateFrom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        synclogs = new javax.swing.JTextArea();
        pullAndPushData = new javax.swing.JButton();
        pullOnly = new javax.swing.JButton();
        mainMenu = new javax.swing.JMenuBar();
        optionsMenu = new javax.swing.JMenu();
        subscriberSettings = new javax.swing.JMenuItem();
        connectionSettings = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        mainSplitPane.setDividerLocation(250);

        leftPaneSplitPanel.setDividerLocation(200);
        leftPaneSplitPanel.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel1.setText("Databases in Config");

        databaseLists.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        databaseLists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                databaseListsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(databaseLists);

        javax.swing.GroupLayout databaseListPanelLayout = new javax.swing.GroupLayout(databaseListPanel);
        databaseListPanel.setLayout(databaseListPanelLayout);
        databaseListPanelLayout.setHorizontalGroup(
            databaseListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databaseListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(databaseListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(databaseListPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                .addContainerGap())
        );
        databaseListPanelLayout.setVerticalGroup(
            databaseListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databaseListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        leftPaneSplitPanel.setTopComponent(databaseListPanel);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Replication Scheduler");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 11)); // NOI18N
        jLabel7.setText("To be added soonest :)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        leftPaneSplitPanel.setRightComponent(jPanel2);

        javax.swing.GroupLayout leftSplitPanePanelLayout = new javax.swing.GroupLayout(leftSplitPanePanel);
        leftSplitPanePanel.setLayout(leftSplitPanePanelLayout);
        leftSplitPanePanelLayout.setHorizontalGroup(
            leftSplitPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
            .addGroup(leftSplitPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(leftPaneSplitPanel, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        leftSplitPanePanelLayout.setVerticalGroup(
            leftSplitPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
            .addGroup(leftSplitPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(leftPaneSplitPanel, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        mainSplitPane.setLeftComponent(leftSplitPanePanel);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel2.setText("Publishing Server");

        publisherName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        publisherName.setText("Publisher");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel3.setText("Work Performed");

        subscriberName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        quickStats.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        quickStats.setText("Quick Stats");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel4.setText("Date To");

        dateTo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        dateTo.setText("2022-06-29");
        dateTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateToActionPerformed(evt);
            }
        });

        dateFrom.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        dateFrom.setText("2022-06-27");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel5.setText("Date From");

        synclogs.setColumns(20);
        synclogs.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        synclogs.setRows(5);
        jScrollPane3.setViewportView(synclogs);

        pullAndPushData.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        pullAndPushData.setText("PULL AND PUSH");
        pullAndPushData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pullAndPushDataActionPerformed(evt);
            }
        });

        pullOnly.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        pullOnly.setText("PULL");
        pullOnly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pullOnlyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(publisherName)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pullOnly)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pullAndPushData)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quickStats)
                            .addComponent(jLabel3)
                            .addComponent(subscriberName))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publisherName)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pullAndPushData, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pullOnly, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subscriberName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quickStats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainSplitPane.setRightComponent(jPanel1);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane)
        );

        optionsMenu.setText("Options");
        optionsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsMenuActionPerformed(evt);
            }
        });

        subscriberSettings.setText("Subscribers Settings");
        optionsMenu.add(subscriberSettings);

        connectionSettings.setText("Connection Settings");
        connectionSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionSettingsActionPerformed(evt);
            }
        });
        optionsMenu.add(connectionSettings);

        mainMenu.add(optionsMenu);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void optionsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsMenuActionPerformed
        
    }//GEN-LAST:event_optionsMenuActionPerformed

    private void connectionSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionSettingsActionPerformed
        
    }//GEN-LAST:event_connectionSettingsActionPerformed

    private void databaseListsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseListsMouseClicked
        if (evt.getClickCount() == 2) {
            int index = databaseLists.locationToIndex(evt.getPoint());
            subscriberName.setText(databaseLists.getSelectedValue().toString());
//            syncButton.setEnabled(true);
        }
    }//GEN-LAST:event_databaseListsMouseClicked

    private void dateToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateToActionPerformed

    private void pullAndPushDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pullAndPushDataActionPerformed
        pullandPushData();
    }//GEN-LAST:event_pullAndPushDataActionPerformed

    private void pullOnlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pullOnlyActionPerformed
        pullOnlyData();
    }//GEN-LAST:event_pullOnlyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem connectionSettings;
    private javax.swing.JPanel databaseListPanel;
    private javax.swing.JList<String> databaseLists;
    private javax.swing.JTextField dateFrom;
    private javax.swing.JTextField dateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane leftPaneSplitPanel;
    private javax.swing.JPanel leftSplitPanePanel;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JLabel publisherName;
    private javax.swing.JButton pullAndPushData;
    private javax.swing.JButton pullOnly;
    private final javax.swing.JLabel quickStats = new javax.swing.JLabel();
    private javax.swing.JLabel subscriberName;
    private javax.swing.JMenuItem subscriberSettings;
    private javax.swing.JTextArea synclogs;
    // End of variables declaration//GEN-END:variables
}
