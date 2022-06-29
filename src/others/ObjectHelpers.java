/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import classes.Subscriber;
import java.util.List;
import java.util.Optional;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Julio Lopez
 */
public class ObjectHelpers {
    public static String smallFirstLetter(String regex) {
        return Character.toLowerCase(regex.charAt(0)) + regex.substring(1);
    }
    
    public static Optional<Subscriber> containsName(final List<Subscriber> list, final String name){
        return list.stream().filter(o -> o.getDatabase().equals(name)).findFirst();
    }
    
    public static void logger(JTextArea synclogs, String text) {
        try {
            synclogs.setText(synclogs.getText() + "\n" + text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void setQuickStat(JLabel label, String message) {
        label.setText(message);
    }
}
