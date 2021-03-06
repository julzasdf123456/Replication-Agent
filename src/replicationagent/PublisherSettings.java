/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package replicationagent;

import classes.Subscriber;
import classes.Subscribers;
import classes.Tables;
import db.DBConnection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import others.Notifiers;

/**
 *
 * @author Julio Lopez
 */
public class PublisherSettings extends javax.swing.JFrame {

    /**
     * Creates new form PublisherSettings
     */
    DBConnection db;
    Subscriber publisher;
    Subscribers subscribers;
    
    // LIST OF DB
    DefaultListModel defaultListModel;
    Object[] columnNames = {"Select", "Table Name"};
    DefaultTableModel model;
    
    public PublisherSettings() {
        initComponents();
        setSize(1000, 700);
        setLocationRelativeTo(this);
        setTitle("Publisher Settings");
        
        db = new DBConnection();        
        publisher = db.getPublisher();
        String server = db.getServer();
        subscribers = new Subscribers();
        db.getDbConnectionFromDatabase(publisher.getDatabase(), publisher.getUsername(), publisher.getPassword(), server);
        
        defaultListModel = new DefaultListModel<>();
        
        displayPublisher();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        databasesList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        publisherTablesTable = new javax.swing.JTable();
        applyBtn = new javax.swing.JButton();
        okBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(160);

        jLabel1.setText("Publisher Database");

        jScrollPane1.setViewportView(databasesList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel2);

        publisherTablesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "Table Name"
            }
        ));
        publisherTablesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane2.setViewportView(publisherTablesTable);
        if (publisherTablesTable.getColumnModel().getColumnCount() > 0) {
            publisherTablesTable.getColumnModel().getColumn(0).setMinWidth(10);
            publisherTablesTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            publisherTablesTable.getColumnModel().getColumn(0).setMaxWidth(20);
            publisherTablesTable.getColumnModel().getColumn(1).setPreferredWidth(90);
        }

        jSplitPane1.setRightComponent(jScrollPane2);

        applyBtn.setText("Apply");
        applyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyBtnActionPerformed(evt);
            }
        });

        okBtn.setText("OK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyBtn)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyBtn)
                    .addComponent(okBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void displayPublisher() {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    defaultListModel.addElement(publisher.getDatabase());
                    databasesList.setModel(defaultListModel);
                    
                    /**
                     * GET SELECTED PUBLISHERS
                     */
                    List<String> tableSelected = subscribers.getPublisherTables();
                    
                    /**
                     * GET TABLES FROM DB
                     */
                    List<Tables> tablesList = db.getTableNames(publisher.getDatabase());
                    Object[][] data = new Object[tablesList.size()][2];
                    for (int tb=0; tb<tablesList.size(); tb++) {
                        if (tableSelected != null && tableSelected.contains(tablesList.get(tb).getTableNames())) {
                            data[tb][0] = true;
                        } else {
                            data[tb][0] = false;
                        }
                        
                        data[tb][1] = tablesList.get(tb).getTableNames();
                    }
                    displayToTable(data);
                }
            }).run();
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Displaying DBs", e.getMessage());
        }
    }
    
    public void displayToTable(Object[][] data) {
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }            
        };
        publisherTablesTable.setModel(model);
        publisherTablesTable.getColumnModel().getColumn(0).setMaxWidth(40);
        publisherTablesTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
    private void applyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBtnActionPerformed
        List<String> tablenames = new ArrayList<>();
        for (int i = 0; i < model.getRowCount(); i++) {
            if ((Boolean) model.getValueAt(i,0)) {  
                tablenames.add(model.getValueAt(i, 1).toString());
            }
        }
        subscribers.writePublisherTables(tablenames);
        db.writePublisherClasses(tablenames, publisher.getDatabase());
        db.writePublisherDaoClasses(tablenames, publisher.getDatabase());
        dispose();
    }//GEN-LAST:event_applyBtnActionPerformed

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
            java.util.logging.Logger.getLogger(PublisherSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PublisherSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PublisherSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PublisherSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PublisherSettings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyBtn;
    private javax.swing.JList<String> databasesList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton okBtn;
    private javax.swing.JTable publisherTablesTable;
    // End of variables declaration//GEN-END:variables
}
