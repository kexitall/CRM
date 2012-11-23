/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crm;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;
import sun.awt.VerticalBagLayout;

/**
 *
 * @author kexital
 */
public class DataChoser {
     
         // components for dateChooser window
        JFrame f = new JFrame("Cal");
        
        // myPanel contains myPanel1 - myPanel3 verticaly
        // myPanel1 - calendar
        // myPamel2 - end begin buttons
        // myPanel3 - Ok button
        
        JPanel myPanel = new JPanel(); 
        JPanel myPanel1 = new JPanel();
        JPanel myPanel2 = new JPanel();
        JPanel myPanel3 = new JPanel();
        
        
        JButton beginButton = new javax.swing.JButton();
        JButton endButton = new javax.swing.JButton();
        JButton okButton = new JButton();

        public DataChoser (){
        createDataChoserWindow ();
    }
        private void createDataChoserWindow () {
       //<editor-fold defaultstate="collapsed" desc="Shows DataChoserWindow">
       
        // setting a componenets
        f.setContentPane(myPanel);
        f.setLayout( new VerticalBagLayout());
        f.setMinimumSize( new Dimension(250, 240));
        f.setMaximumSize( new Dimension(400, 450));
        
        beginButton.setText("<< Начало периода");
        endButton.setText("Конец периода >>");
        okButton.setText("Ok");

        // construct window
        myPanel.add(myPanel1);
        myPanel.add(myPanel2);
        myPanel.add(myPanel3);
        myPanel1.add(new JXDatePicker());
               // new Calendar_panel()

        myPanel2.add(beginButton);
        myPanel2.add(endButton);
        myPanel3.add(okButton);
        f.pack();
        f.setVisible(false);
    //</editor-fold>
    }
    
    
    
    
    public void appear(){
        f.setVisible(true);
        LocDbProvider bb = new LocDbProvider();
    }
   
}
