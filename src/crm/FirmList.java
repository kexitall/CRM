package crm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import sun.awt.VerticalBagLayout;

public class FirmList extends JScrollPane {

// TODO condition: firmList must chose first firm record to anable this featre
   
//   private String firmContacts[];      
    private int numOfFirms;
    private static FirmCard chosen;
    private static Color defCardColour;

    
    
    private static FirmCard[] firmCardArr;
    private java.util.List<FirmCard> firmCardCollection;
    private FirmCard[] searchResult;
    int matches;
    int topCount;
    String lastSearched="";
    //List<String> asdf = new ArrayList<String>();

    public JPanel panel;
    public VerticalBagLayout layout;
    
   
    public FirmList(int numOfFirms) {
        this.numOfFirms = numOfFirms;
        firmCardCollection = new ArrayList<>(numOfFirms);
        firmCardArr = new FirmCard[numOfFirms];
        searchResult = new FirmCard[numOfFirms];
        for (int i = 0; i<numOfFirms; i++ ) {
            try {
                
                firmCardArr[i] = (new FirmCard(CRM_window.db.getFirmName(i), CRM_window.db.getFirmWebAddr(i), CRM_window.db.getFirmID(i)) );
                firmCardArr[i].setSize(200, 300);
            } catch (SQLException ex) {
                Logger.getLogger(FirmList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       
       //TODO () - окна карточек отказались работыть. Че за нах? разобратся в механизме
        System.arraycopy(firmCardArr, 0, searchResult, 0, numOfFirms);
       
        defCardColour = new Color(123);
        defCardColour = firmCardArr[0].getBackground();    // just picks a default crad colour for future use
        chosen = firmCardArr[0];
        setChosen(firmCardArr[0]);  // sets initialy chosen card;
        matches=numOfFirms;
        
        initComponents();

    }
   

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
   public static void setChosen ( MouseEvent e ) {
       chosen.setBackground(defCardColour);         // unchoses card
       ( firmCardArr[(((FirmCard)(e.getSource())).getFirmID()) - 1] ).setBackground(Color.gray);
         chosen = firmCardArr[(((FirmCard)(e.getSource())).getFirmID())-1];
       //CRM_window.contactsPanel.removeAll();
      // CRM_window.contactsPanel.setPreferredSize(new java.awt.Dimension(200, 265));
      // CRM_window.contactsPanel.setVerifyInputWhenFocusTarget(false);
     //  AScrollList scrollList = new AScrollList(((FirmCard)(e.getSource())).getFirmID());
      // FlowLayout scrolListPanelLayout = new FlowLayout();
      // scrollList.setLayout(scrolListPanelLayout);
      
    CRM_window.pointer.paint((((FirmCard)(e.getSource())).getFirmID()));     
           
  
       
         
   }
   public static void setChosen ( FirmCard c ) {
       c.setBackground(defCardColour);         // unchoses card
   }
   public static FirmCard getChosen (){
       return chosen;
   }
       
   private void initComponents() {
       
        panel = new javax.swing.JPanel();
        this.setMaximumSize(new Dimension(1250, 450));
        this.setPreferredSize( new Dimension(780,450));
        
        layout = new VerticalBagLayout();
        panel.setLayout(layout);
        for (int i = 0; i<numOfFirms; i++) {
            panel.add(firmCardArr[i]);
        }
        
        this.setViewportView(panel);
        }
   public void repaintS(FirmCard[] arr, int num) {
       chosen.setBackground(defCardColour); // unchoses card before delete it in removeAll() method
       panel.removeAll();
       this.setMaximumSize(new Dimension(1250, 450));
       this.setPreferredSize( new Dimension(780,450));
       
       layout = new VerticalBagLayout();
       panel.setLayout(layout);
       for (int i = 0; i<num; i++) {
           panel.add(arr[i]);
       }
       defCardColour = new Color(123);
       defCardColour = arr[0].getBackground();    // just picks a default crad colour for future use
       chosen = arr[0];
       setChosen(arr[0]);  // sets initialy chosen card;

       this.setViewportView(panel);
        
   }
   
   public void search(String searched) {
       System.out.println("called justSearch()");
       topCount=0; 
       for (int i = 0; i<numOfFirms; i++){
           if (firmCardArr[i].getFirmName().toLowerCase().contains(searched.toLowerCase()) ) {
               
               searchResult[topCount]=firmCardArr[i];
               topCount++;
           } 
           }
       repaintS(searchResult, topCount);
                   
   } 
  // </editor-fold>
    
   
    
    
}
