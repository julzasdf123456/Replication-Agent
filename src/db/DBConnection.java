/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import classes.Subscriber;
import classes.Subscribers;
import static classes.Subscribers.PUBLISHER_TABLES_FILE;
import static classes.Subscribers.TABLE_CLASSES_DIR;
import classes.Tables;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import others.Notifiers;
import others.ObjectHelpers;

/**
 *
 * @author Julio Lopez
 */
public class DBConnection {
    private static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String jdbcURL = "jdbc:sqlserver://juliolopez:1433;DatabaseName=main;user=main;password=main;encrypt=true;trustServerCertificate=true;";
           
    Connection databaseConnection= null;
 
    public Connection getDbConnection() {
        try {
           Class.forName(jdbcDriver).newInstance();
           
           databaseConnection = (Connection) DriverManager.getConnection(jdbcURL);
           
           System.out.println("Connected");
           
           return databaseConnection;
        } catch (Exception err) {
           System.out.println("Not Connected");
           err.printStackTrace();
            Notifiers.showErrorMessage("Database Connection Error", err.getMessage());
           return null;
        }
    }
    
    public Connection getDbConnectionFromDatabase(String db, String username, String password, String server) {
        try {
           String url = "jdbc:sqlserver://" + server + ":1433;DatabaseName=" + db + ";user=" + username + ";password=" + password + ";encrypt=true;trustServerCertificate=true;";
           
           Class.forName(jdbcDriver).newInstance();
           
           databaseConnection = (Connection) DriverManager.getConnection(url);
           
           System.out.println("Connected to " + db);
           
           return databaseConnection;
        } catch (Exception err) {
           System.out.println("Not Connected");
           err.printStackTrace();
           Notifiers.showErrorMessage("Database Connection Error", err.getMessage());
           return null;
        }
    }    
    
    public void closeConnection() {
        try {
            databaseConnection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Table Names", ex.getMessage());
        }
    }
    
    public Connection getInitializedConnection() {
        return databaseConnection;
    }
    
    public List<Tables> getTableNames(String dbName) {
        try {
            List<Tables> tables = new ArrayList<>();
            DatabaseMetaData md = databaseConnection.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = md.getTables(dbName, null, "%", types);
            while (rs.next()) {
              tables.add(new Tables(rs.getString("TABLE_NAME")));
            }
            return tables;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Table Names", e.getMessage());
            return null;
        }
    }
    
    public Subscriber getPublisher() {
        try {
            Subscriber databases = new Subscriber();
            File file=new File(Subscribers.PUBLISHER_FILE);    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
            String line;  
            while((line=br.readLine())!=null) {   
                String[] lineTab = line.split(" ");
                databases = new Subscriber(lineTab[0], lineTab[1], lineTab[2]);
            } 
            
            fr.close();    //closes the stream and release the resources   
            
            return databases;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Subscribers", e.getMessage());
            return null;
        }
    }
    
    public String getServer() {
        try {
            String server = "";
            File file=new File(Subscribers.SERVER);    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
            String line;  
            while((line=br.readLine())!=null) {   
                server = line;
            } 
            
            fr.close();    //closes the stream and release the resources   
            
            return server;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Server", e.getMessage());
            return null;
        }
    }
    
    public List<String> getColumnNamesFromTable(String tableName) {
        try {
            Statement stmt = databaseConnection.createStatement();
            //Retrieving the data
            ResultSet rs = stmt.executeQuery("SELECT TOP 1 * FROM " + tableName);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int colcount = rsMetaData.getColumnCount();
            List<String> colNames = new ArrayList<>();
            for (int i=1; i<=colcount; i++) {
                colNames.add(rsMetaData.getColumnName(i));
            }
            return colNames;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Column Names", e.getMessage());
            return null;
        }
    }
    
    public void writePublisherClasses(List<String> tableNames, String dbName) { 
        try {
            int size = tableNames.size();
            for (int i=0; i<size; i++) {
                String className = tableNames.get(i);
                File classFile = new File(TABLE_CLASSES_DIR + className + ".java");
                
                List<String> columnNames = getColumnNamesFromTable(className);
                int colNameSize = columnNames.size();
                
                if (classFile.exists()) {
                    classFile.delete();
                    
                    StringBuilder builder = new StringBuilder();
                    builder.append("package tableclasses;\n\n");
                    builder.append("public class " + className + " { \n");
                    
                    String constData = "";
                    for (int j=0; j<colNameSize; j++) {
                        if (columnNames.get(j).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            builder.append("\tpublic String " + columnNames.get(j) + ";\n");
                            
                            if (j==colNameSize-1) {
                                constData += "String " + columnNames.get(j);
                            } else {
                                constData += "String " + columnNames.get(j) + ", ";
                            }
                        }
                    }
                    
                    builder.append("\tpublic " + className + "() {\n");
                    builder.append("\t} \n"); // closing of constructor
                    
                    builder.append("\tpublic " + className + "(" + constData + ") {\n");
                    for (int h=0; h<colNameSize; h++) {
                        if (columnNames.get(h).equals("rowguid")) {
                            // excempt rowguid
                        } else {                            
                            builder.append("\t\tthis." + columnNames.get(h) + " = " + columnNames.get(h) + ";\n");
                        }
                    }
                    builder.append("\t} \n\n"); // closing of constructor with params
                    
                    for (int k=0; k<colNameSize; k++) {
                        if (columnNames.get(k).equals("rowguid")) {
                            // excempt rowguid
                        } else {       
                            builder.append("\tpublic void set" + columnNames.get(k) + "(String " + columnNames.get(k) + ") {\n");
                            builder.append("\t\tthis." + columnNames.get(k) + " = " + columnNames.get(k) + ";\n");
                            builder.append("\t} \n\n"); // closing of setter
                            
                            builder.append("\tpublic String get" + columnNames.get(k) + "() {\n");
                            builder.append("\t\treturn " + columnNames.get(k) + ";\n");
                            builder.append("\t} \n\n"); // closing of getter
                        }
                    }
                    
                    builder.append("} \n"); // closing of class
                    
                    Files.write(classFile.toPath(), builder.toString().getBytes());
                    System.out.println("CREATED");
                } else {
                    StringBuilder builder = new StringBuilder();
                    builder.append("package tableclasses;\n\n");
                    builder.append("public class " + className + " { \n");
                    
                    String constData = "";
                    for (int j=0; j<colNameSize; j++) {
                        if (columnNames.get(j).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            builder.append("\tpublic String " + columnNames.get(j) + ";\n");
                            
                            if (j==colNameSize-1) {
                                constData += "String " + columnNames.get(j);
                            } else {
                                constData += "String " + columnNames.get(j) + ", ";
                            }
                        }
                    }
                    
                    builder.append("\tpublic " + className + "() {\n");
                    builder.append("\t} \n"); // closing of constructor
                    
                    builder.append("\tpublic " + className + "(" + constData + ") {\n");
                    for (int h=0; h<colNameSize; h++) {
                        if (columnNames.get(h).equals("rowguid")) {
                            // excempt rowguid
                        } else {                            
                            builder.append("\t\tthis." + columnNames.get(h) + " = " + columnNames.get(h) + ";\n");
                        }
                    }
                    builder.append("\t} \n\n"); // closing of constructor with params
                    
                    for (int k=0; k<colNameSize; k++) {
                        if (columnNames.get(k).equals("rowguid")) {
                            // excempt rowguid
                        } else {       
                            builder.append("\tpublic void set" + columnNames.get(k) + "(String " + columnNames.get(k) + ") {\n");
                            builder.append("\t\tthis." + columnNames.get(k) + " = " + columnNames.get(k) + ";\n");
                            builder.append("\t} \n\n"); // closing of setter
                            
                            builder.append("\tpublic String get" + columnNames.get(k) + "() {\n");
                            builder.append("\t\treturn " + columnNames.get(k) + ";\n");
                            builder.append("\t} \n\n"); // closing of getter
                        }
                    }
                    
                    builder.append("} \n"); // closing of class
                    
                    Files.write(classFile.toPath(), builder.toString().getBytes());
                    System.out.println("CREATED");
                }               
            }            
        } catch (IOException e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Subscribers", e.getMessage());
        }
    }
    
    public void writePublisherDaoClasses(List<String> tableNames, String dbName) { 
        try {
            int size = tableNames.size();
            for (int i=0; i<size; i++) {
                String className = tableNames.get(i);
                File classFile = new File(TABLE_CLASSES_DIR + className + "DAO.java");
                
                List<String> columnNames = getColumnNamesFromTable(className);
                int colNameSize = columnNames.size();
                
                if (classFile.exists()) {
                    classFile.delete();
                    
                    StringBuilder builder = new StringBuilder();
                    builder.append("package tableclasses;\n\n");
                    builder.append("import java.sql.Connection;\n");
                    builder.append("import java.sql.DatabaseMetaData;\n");
                    builder.append("import java.sql.DriverManager;\n");
                    builder.append("import java.sql.ResultSet;\n");
                    builder.append("import java.sql.ResultSetMetaData;\n");
                    builder.append("import java.sql.PreparedStatement;\n");
                    builder.append("import java.sql.SQLException;\n");
                    builder.append("import java.sql.Statement;\n");
                    builder.append("import java.util.List;\n");
                    builder.append("import java.util.ArrayList;\n");
                    builder.append("public class " + className + "DAO { \n");
                      
                    /**
                     * ADD INSERT DAO
                     */                    
                    String constData = "";
                    String qMarksInsert = "";
                    for (int j=0; j<colNameSize; j++) {
                        if (columnNames.get(j).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            
                            if (j==colNameSize-1) {
                                constData += columnNames.get(j);
                                qMarksInsert += "?";
                            } else {
                                constData += columnNames.get(j) + ", ";
                                qMarksInsert += "?, ";
                            }
                        }
                    }
                    
                    builder.append("\tpublic static void insert(" + className + " " + ObjectHelpers.smallFirstLetter(className) + ", Connection con) throws Exception {\n");
                    String insertQuery = "INSERT INTO " + className + "(" + constData + ") VALUES (" + qMarksInsert + ")";
                    builder.append("\t\tPreparedStatement ps = con.prepareStatement(\"" + insertQuery + "\");\n");
                    
                    for (int x=0; x<colNameSize; x++) {
                        if (columnNames.get(x).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            builder.append("\t\tps.setString(" + (x+1) + ", " + ObjectHelpers.smallFirstLetter(className) + ".get" + columnNames.get(x) + "());\n");
                        }
                    }
                    builder.append("\t\tps.executeUpdate();\n");
                    builder.append("\t\tps.close();\n");
                    builder.append("\t} \n"); // closing of insert
                    
                    /**
                     * ADD UPDATE DAO
                     */
                    String constDataUpdate = "";
                    String whereId = "";
                    for (int b=0; b<colNameSize; b++) {
                        if (columnNames.get(b).equals("rowguid")) {
                            // excempt rowguid
                        } else {     
                            if (b==0) {
                                // excempt id
                                whereId = " WHERE " + columnNames.get(b) + "=? ";
                            } else {
                                if (b==colNameSize-1) {
                                    constDataUpdate += columnNames.get(b)+ "=? ";
                                } else {
                                    constDataUpdate += columnNames.get(b) + "=?, ";
                                }
                            }                            
                        }
                    }
                    builder.append("\tpublic static void update(" + className + " " + ObjectHelpers.smallFirstLetter(className) + ", Connection con) throws Exception {\n");
                    String update = "UPDATE " + className + " SET " + constDataUpdate + whereId;
                    builder.append("\t\tPreparedStatement ps = con.prepareStatement(\"" + update + "\");\n");
                    int altIndex = 1;
                    String idOfTable = "";
                    for (int v=0; v<colNameSize; v++) {
                        if (columnNames.get(v).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            if (v==0) {
                                idOfTable = columnNames.get(v);
                            } else {
                                builder.append("\t\tps.setString(" + (altIndex) + ", " + ObjectHelpers.smallFirstLetter(className) + ".get" + columnNames.get(v) + "());\n");
                                altIndex++;
                            }                            
                        }
                    }
                    builder.append("\t\tps.setString(" + (altIndex) + ", " + ObjectHelpers.smallFirstLetter(className) + ".get" + idOfTable + "());\n");
                    builder.append("\t\tps.executeUpdate();\n");
                    builder.append("\t\tps.close();\n");
                    builder.append("\t} \n"); // closing of insert
                    
                    /**
                     * SELECT TOP 1
                     */
                    builder.append("\tpublic static " + className + " getOne(String id, Connection con) throws Exception {\n");
                    String selectTopOne = "SELECT * FROM " + className + " WHERE " + idOfTable + "=?";
                    builder.append("\t\tPreparedStatement ps = con.prepareStatement(\"" + selectTopOne + "\");\n");
                    builder.append("\t\tps.setString(1, id);\n");
                    builder.append("\t\tps.executeQuery();\n");
                    builder.append("\t\tResultSet rs = ps.executeQuery();\n");
                    builder.append("\t\tif(rs.next()) {\n");
                    builder.append("\t\t\t" + className + " " + ObjectHelpers.smallFirstLetter(className) + " = new " + className + "(\n");
                    for (int w=0; w<colNameSize; w++) {
                        if (columnNames.get(w).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            if (w == colNameSize-1) {
                                builder.append("\t\t\trs.getString(\"" + columnNames.get(w) + "\")\n");             
                            } else {
                                builder.append("\t\t\trs.getString(\"" + columnNames.get(w) + "\"),\n");             
                            }                      
                        }
                    }
                    builder.append("\t\t\t);\n");
                    builder.append("\t\t\tps.close();\n");
                    builder.append("\t\t\trs.close();\n");
                    builder.append("\t\t\treturn " + ObjectHelpers.smallFirstLetter(className) + ";\n");
                    builder.append("\t\t}\n"); // close rs.next
                    
                    builder.append("\t\trs.close();\n");
                    builder.append("\t\tps.close();\n");
                    builder.append("\t\treturn null;\n");
                    builder.append("\t} \n"); // closing of select
                    
                    /**
                     * SELECT UPDATED AT FROM AND TO
                     */
                    builder.append("\tpublic static List<" + className + "> selectUpdatedAt(String from, String to, Connection con) throws Exception {\n");
                    String selectUpdatedAt = "SELECT * FROM " + className + " WHERE updated_at BETWEEN ? AND ?";
                    builder.append("\t\tPreparedStatement ps = con.prepareStatement(\"" + selectUpdatedAt + "\");\n");
                    builder.append("\t\tps.setString(1, from);\n");
                    builder.append("\t\tps.setString(2, to);\n");
                    builder.append("\t\tps.executeQuery();\n");
                    builder.append("\t\tResultSet rs = ps.executeQuery();\n");
                    builder.append("\t\tList<" + className + "> " + ObjectHelpers.smallFirstLetter(className) + "List = new ArrayList<>();\n");
                    builder.append("\t\twhile(rs.next()) {\n");
                    builder.append("\t\t\t" + className + " " + ObjectHelpers.smallFirstLetter(className) + " = new " + className + "();\n");
                    for (int a=0; a<colNameSize; a++) {
                        if (columnNames.get(a).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            builder.append("\t\t\t" + ObjectHelpers.smallFirstLetter(className) + ".set" + columnNames.get(a) + "(rs.getString(\"" + columnNames.get(a) + "\"));\n");                             
                        }
                    }
                    
                    builder.append("\t\t\t" + ObjectHelpers.smallFirstLetter(className) + "List.add(" + ObjectHelpers.smallFirstLetter(className) + ");\n");
                    builder.append("\t\t}\n"); // close rs.next
                    
                    builder.append("\t\trs.close();\n");
                    builder.append("\t\tps.close();\n");
                    builder.append("\t\treturn " + ObjectHelpers.smallFirstLetter(className) + "List;\n");
                    builder.append("\t} \n"); // closing of select
                    
                    builder.append("} \n"); // closing of class
                    
                    Files.write(classFile.toPath(), builder.toString().getBytes());
                    System.out.println("CREATED INSERT");
                } else {
                    StringBuilder builder = new StringBuilder();
                    builder.append("package tableclasses;\n\n");
                    builder.append("import java.sql.Connection;\n");
                    builder.append("import java.sql.DatabaseMetaData;\n");
                    builder.append("import java.sql.DriverManager;\n");
                    builder.append("import java.sql.ResultSet;\n");
                    builder.append("import java.sql.ResultSetMetaData;\n");
                    builder.append("import java.sql.PreparedStatement;\n");
                    builder.append("import java.sql.SQLException;\n");
                    builder.append("import java.sql.Statement;\n");
                    builder.append("import java.util.List;\n");
                    builder.append("import java.util.ArrayList;\n");
                    builder.append("public class " + className + "DAO { \n");
                      
                    /**
                     * ADD INSERT DAO
                     */                    
                    String constData = "";
                    String qMarksInsert = "";
                    for (int j=0; j<colNameSize; j++) {
                        if (columnNames.get(j).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            
                            if (j==colNameSize-1) {
                                constData += columnNames.get(j);
                                qMarksInsert += "?";
                            } else {
                                constData += columnNames.get(j) + ", ";
                                qMarksInsert += "?, ";
                            }
                        }
                    }
                    
                    builder.append("\tpublic static void insert(" + className + " " + ObjectHelpers.smallFirstLetter(className) + ", Connection con) throws Exception {\n");
                    String insertQuery = "INSERT INTO " + className + "(" + constData + ") VALUES (" + qMarksInsert + ")";
                    builder.append("\t\tPreparedStatement ps = con.prepareStatement(\"" + insertQuery + "\");\n");
                    
                    for (int x=0; x<colNameSize; x++) {
                        if (columnNames.get(x).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            builder.append("\t\tps.setString(" + (x+1) + ", " + ObjectHelpers.smallFirstLetter(className) + ".get" + columnNames.get(x) + "());\n");
                        }
                    }
                    builder.append("\t\tps.executeUpdate();\n");
                    builder.append("\t\tps.close();\n");
                    builder.append("\t} \n"); // closing of insert
                    
                    /**
                     * ADD UPDATE DAO
                     */
                    String constDataUpdate = "";
                    String whereId = "";
                    for (int b=0; b<colNameSize; b++) {
                        if (columnNames.get(b).equals("rowguid")) {
                            // excempt rowguid
                        } else {     
                            if (b==0) {
                                // excempt id
                                whereId = " WHERE " + columnNames.get(b) + "=? ";
                            } else {
                                if (b==colNameSize-1) {
                                    constDataUpdate += columnNames.get(b)+ "=? ";
                                } else {
                                    constDataUpdate += columnNames.get(b) + "=?, ";
                                }
                            }                            
                        }
                    }
                    builder.append("\tpublic static void update(" + className + " " + ObjectHelpers.smallFirstLetter(className) + ", Connection con) throws Exception {\n");
                    String update = "UPDATE " + className + " SET " + constDataUpdate + whereId;
                    builder.append("\t\tPreparedStatement ps = con.prepareStatement(\"" + update + "\");\n");
                    int altIndex = 1;
                    String idOfTable = "";
                    for (int v=0; v<colNameSize; v++) {
                        if (columnNames.get(v).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            if (v==0) {
                                idOfTable = columnNames.get(v);
                            } else {
                                builder.append("\t\tps.setString(" + (altIndex) + ", " + ObjectHelpers.smallFirstLetter(className) + ".get" + columnNames.get(v) + "());\n");
                                altIndex++;
                            }                            
                        }
                    }
                    builder.append("\t\tps.setString(" + (altIndex) + ", " + ObjectHelpers.smallFirstLetter(className) + ".get" + idOfTable + "());\n");
                    builder.append("\t\tps.executeUpdate();\n");
                    builder.append("\t\tps.close();\n");
                    builder.append("\t} \n"); // closing of insert
                    
                    /**
                     * SELECT TOP 1
                     */
                    builder.append("\tpublic static " + className + " getOne(String id, Connection con) throws Exception {\n");
                    String selectTopOne = "SELECT * FROM " + className + " WHERE " + idOfTable + "=?";
                    builder.append("\t\tPreparedStatement ps = con.prepareStatement(\"" + selectTopOne + "\");\n");
                    builder.append("\t\tps.setString(1, id);\n");
                    builder.append("\t\tps.executeQuery();\n");
                    builder.append("\t\tResultSet rs = ps.executeQuery();\n");
                    builder.append("\t\tif(rs.next()) {\n");
                    builder.append("\t\t\t" + className + " " + ObjectHelpers.smallFirstLetter(className) + " = new " + className + "(\n");
                    for (int w=0; w<colNameSize; w++) {
                        if (columnNames.get(w).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            if (w == colNameSize-1) {
                                builder.append("\t\t\trs.getString(\"" + columnNames.get(w) + "\")\n");             
                            } else {
                                builder.append("\t\t\trs.getString(\"" + columnNames.get(w) + "\"),\n");             
                            }                      
                        }
                    }
                    builder.append("\t\t\t);\n");
                    builder.append("\t\t\tps.close();\n");
                    builder.append("\t\t\trs.close();\n");
                    builder.append("\t\t\treturn " + ObjectHelpers.smallFirstLetter(className) + ";\n");
                    builder.append("\t\t}\n"); // close rs.next
                    
                    builder.append("\t\trs.close();\n");
                    builder.append("\t\tps.close();\n");
                    builder.append("\t\treturn null;\n");
                    builder.append("\t} \n"); // closing of select
                    
                    /**
                     * SELECT UPDATED AT FROM AND TO
                     */
                    builder.append("\tpublic static List<" + className + "> selectUpdatedAt(String from, String to, Connection con) throws Exception {\n");
                    String selectUpdatedAt = "SELECT * FROM " + className + " WHERE updated_at BETWEEN ? AND ?";
                    builder.append("\t\tPreparedStatement ps = con.prepareStatement(\"" + selectUpdatedAt + "\");\n");
                    builder.append("\t\tps.setString(1, from);\n");
                    builder.append("\t\tps.setString(2, to);\n");
                    builder.append("\t\tps.executeQuery();\n");
                    builder.append("\t\tResultSet rs = ps.executeQuery();\n");
                    builder.append("\t\tList<" + className + "> " + ObjectHelpers.smallFirstLetter(className) + "List = new ArrayList<>();\n");
                    builder.append("\t\twhile(rs.next()) {\n");
                    builder.append("\t\t\t" + className + " " + ObjectHelpers.smallFirstLetter(className) + " = new " + className + "();\n");
                    for (int a=0; a<colNameSize; a++) {
                        if (columnNames.get(a).equals("rowguid")) {
                            // excempt rowguid
                        } else {
                            builder.append("\t\t\t" + ObjectHelpers.smallFirstLetter(className) + ".set" + columnNames.get(a) + "(rs.getString(\"" + columnNames.get(a) + "\"));\n");                             
                        }
                    }
                    
                    builder.append("\t\t\t" + ObjectHelpers.smallFirstLetter(className) + "List.add(" + ObjectHelpers.smallFirstLetter(className) + ");\n");
                    builder.append("\t\t}\n"); // close rs.next
                    
                    builder.append("\t\trs.close();\n");
                    builder.append("\t\tps.close();\n");
                    builder.append("\t\treturn " + ObjectHelpers.smallFirstLetter(className) + "List;\n");
                    builder.append("\t} \n"); // closing of select
                    
                    builder.append("} \n"); // closing of class
                    
                    Files.write(classFile.toPath(), builder.toString().getBytes());
                    System.out.println("CREATED INSERT");
                }               
            }            
        } catch (IOException e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Subscribers", e.getMessage());
        }
    }
    
    /**
     * TRANSACT TOP THOUSAND RECORD FROM PUBLISHER TO SUBSCRIBER
     * @param tableName
     * @param columnNames 
     */
    public String[][] transactTopThousand(String tableName, List<String> columnNames) {
        try {
            String columnColated = "";
            int colsize = columnNames.size();
            for (int i=0; i<colsize; i++) {
                if (i == colsize-1) {
                    columnColated += columnNames.get(i);
                } else {
                    columnColated += columnNames.get(i) + ", ";
                }
            }
            Statement stmt = databaseConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //Retrieving the data
            ResultSet rs = stmt.executeQuery("SELECT TOP 1 " + columnColated + " FROM " + tableName + " ORDER BY updated_at DESC");
            rs.last();
            String[][] dataObtained = new String[rs.getRow()][colsize];
            rs.beforeFirst();
            int y = 0;
            while (rs.next()) {
                for (int x=0; x<colsize; x++) {
                    dataObtained[y][x] = rs.getString(x+1);
//                    System.out.print(y + " | " + rs.getString(x+1) + " - ");
                }
                y++;
            }
            return dataObtained;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Transacting Top 1000 ", e.getMessage());
            return null;
        }
    }
    
    public void insertOrUpdateRecordToSubscriber(String tableName, List<String> columnNames, String[] data) {
        try {
            int colsize = columnNames.size();
            int datasize = data.length;
            System.out.println(colsize + " - " + datasize);
            if (colsize == datasize) {
                // COLATE COLUMN TO FORMAT TABLE ISNERTS
                String columnColated = "";
                int idIndex = 0;
                for (int i=0; i<colsize; i++) {
                    if (columnNames.get(i).equals("id")) {
                        idIndex = i;
                    }
                    if (i == colsize-1) {
                        columnColated += columnNames.get(i);
                    } else {
                        columnColated += columnNames.get(i) + ", ";
                    }
                }

                // COLATE DATA TO FORMAT TABLE INSERTS
                String dataColated = "";
                for (int x=0; x<datasize; x++) {
                    if (x == datasize-1) {
                        dataColated += "'" + data[x] + "'";
                    } else {
                        dataColated += "'" + data[x] + "', ";
                    }
                }

                Statement stmt = databaseConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                // QUERY IF EXISTS
                ResultSet rs = stmt.executeQuery("SELECT TOP 1 * FROM " + tableName + " WHERE id='" + data[idIndex] + "'");
                rs.last();
                if (rs.getRow() > 0) {
                    // UPDATE
                    rs.first();
                    
                    // PREPARE UPDATE COLLATION
                    String updateCollation = "";
                    for (int v=0; v<colsize; v++) {
                        if (columnNames.get(v).equals("id") | columnNames.get(v).equals("rowguid")) {
                        } else {
                            if (v == colsize-1) {
                                updateCollation += columnNames.get(v) + "='" + data[v] + "'";
                            } else {
                                updateCollation += columnNames.get(v) + "='" + data[v] + "'" + ", ";
                            }
                        }
                            
                    }
                    
                    String statement = "UPDATE " + tableName + " SET " + updateCollation + " " +
                            "WHERE id='" + data[idIndex] + "'";
                    stmt.executeUpdate(statement);
                    System.out.println("Row updated in " + tableName + " with ID " + data[idIndex]);
                } else {
                    // CREATE NEW
                    String statement = "INSERT INTO " + tableName + "(" + columnColated + ") " +
                            "VALUES (" + dataColated + ")";
//                    stmt.executeUpdate(statement);
                    System.out.println(statement.toString());
                    System.out.println("Row inserted to " + tableName + " with ID " + data[idIndex]);
                }
            } else {
                System.out.println("Column size doesn't match the data size. Skipping this item.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Inserting to Subscriber", e.getMessage());
        }
    }
}
