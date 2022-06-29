/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import others.Notifiers;

/**
 *
 * @author Julio Lopez
 */
public class Subscribers {
    private static String SEPARATOR = File.separator;    
    private static String SUBSCRIBER_FILE = System.getProperty("user.dir") + SEPARATOR + "res" + SEPARATOR + "subscribers.txt";
    public static String PUBLISHER_FILE = System.getProperty("user.dir") + SEPARATOR + "res" + SEPARATOR + "publisher.txt";
    public static String PUBLISHER_TABLES_FILE = System.getProperty("user.dir") + SEPARATOR + "res" + SEPARATOR + "publishertables.txt";
    public static String TABLE_CLASSES_DIR = System.getProperty("user.dir") + SEPARATOR + "src" + SEPARATOR + "tableclasses" + SEPARATOR;
    public static String SERVER = System.getProperty("user.dir") + SEPARATOR + "res" + SEPARATOR + "server.txt";
    
    public Subscribers() { }
    
    public List<Subscriber> getSubscribers() {
        try {
            List<Subscriber> databases = new ArrayList<>();
            File file=new File(SUBSCRIBER_FILE);    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
            String line;  
            while((line=br.readLine())!=null) {   
                String[] lineTab = line.split(" ");
                databases.add(new Subscriber(lineTab[0], lineTab[1], lineTab[2]));
            } 
            
            fr.close();    //closes the stream and release the resources   
            
            return databases;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Subscribers", e.getMessage());
            return null;
        }
    }
    
    public void writePublisherTables(List<String> tableNames) { 
        try {
            File text = new File(PUBLISHER_TABLES_FILE);
            if (text.createNewFile()) {
                StringBuilder data = new StringBuilder();
                for (int i=0; i<tableNames.size(); i++) {
                    data.append(tableNames.get(i) + "\n");
                }
                Files.write(text.toPath(), data.toString().getBytes());
            } else {
                text.delete();
                
                text = new File(PUBLISHER_TABLES_FILE);
                StringBuilder data = new StringBuilder();
                for (int i=0; i<tableNames.size(); i++) {
                    data.append(tableNames.get(i) + "\n");
                }
                Files.write(text.toPath(), data.toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Subscribers", e.getMessage());
        }
    }
    
    public List<String> getPublisherTables() {
        try {
            List<String> databases = new ArrayList<>();
            File file = new File(PUBLISHER_TABLES_FILE);    //creates a new file instance  
            if (file.exists()) {
                FileReader fr=new FileReader(file);   //reads the file  
                BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
                StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
                String line;  
                while((line=br.readLine())!=null) {   
                    databases.add(line);
                } 

                fr.close();    //closes the stream and release the resources   

                return databases;
            } else {
                return null;
            }                
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Publisher Tables", e.getMessage());
            return null;
        }
    }
    
    
}
