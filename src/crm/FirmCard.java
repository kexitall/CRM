/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//TODO Note: Делай поля хранящие ссылку на обьекты с котрыми придтся работать нескольким классам
//TODO Note: Разберись с внутренними классам, и почему здесь одинаковые по названию листенеры но лежащие в разных внутренних классах друг другу не мешают и не Overrides/Hides
//TODO Note: Аккуратно удаляй Listenrs. т.к. глючили диалоговые окна удаления и редактирования контактов изза того что в pullthePlug я удалял Listener, а при очережном возникновениии окна, оно же первоначальное просто ему делал setVisible(true) оно появлялось но кнопки ОК и Cancel не срабатывали, т.к. слушателя у них уже не было.
//TODO Nice comment pattern. note it!
/* */  // <editor-fold defaultstate="collapsed" desc="->>">
            /* 
             * 
             */
           //</editor-fold>



//TODO Empty fold pattern
// <editor-fold defaultstate="collapsed" desc="empty_fold">
            
//</editor-fold>
package crm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.*;


/**
 *
 * @author kexital
 */
public class FirmCard extends JPanel {
 
//  <editor-fold defaultstate="collapsed" desc="Variables declaraion    (not complete)">
    
// static flag (true/false) for Dialog windows exstance:
        private static boolean isConfirmationDialodExists = false;
        private static boolean isNotFinishedActionDialogExists = false;
        private static JPanel SelectedCardPointer; // check logic(field doesnt used)
        
        
//  card fields labels:
        private int firmID;
        private JLabel firmNameLabel;
        private JLabel firmWebAddressLabel;
       

//  card actions buttons:        
        private JButton delButton = new JButton("Delete");
        private JButton editButton = new JButton("Edit");
//  pointers (I don't cnow how to ):
      private static JFrame confirmationDialogPointer;
      private static JFrame warningNotFinishedActionPointer;
      
//  </editor-fold>      
     
  
    public FirmCard ( ) {
        firmID = 1;   // stupidity
        
    }
    public FirmCard ( String firmName, String webAddr, int firmID ) {
        this.firmID = firmID;
        initComponents(firmName, webAddr);
    }
    
    
    
    
    private void initComponents(String firmName, String webAddr) {
       firmNameLabel  = new JLabel(firmName);
       firmNameLabel.setMaximumSize(new Dimension(400, 20));
       firmNameLabel.setFont(new java.awt.Font("Ubuntu", 1, 13));
       firmWebAddressLabel = new JLabel(webAddr);
       this.addMouseListener(new ChoserListeer());
        delButton.addMouseListener(new FirmCard.DelButtonListener());
        editButton.addMouseListener(new FirmCard.EditButtonListener());
        delButton.setEnabled(true);
        this.setBorder(BorderFactory.createEtchedBorder(WIDTH));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(true,firmNameLabel, 50, 100, 500)
                        .addComponent(true, firmWebAddressLabel, 30, 100, 500)
                        .addComponent(true, editButton, 50, 50, 80)                        
                        .addComponent(true, delButton, 50, 50, 80)
                    )
                );

        layout.setVerticalGroup(
                layout.createParallelGroup()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(firmNameLabel)
                        .addComponent(firmWebAddressLabel) 
                        .addComponent(editButton)
                        .addComponent(delButton)
                    )
                );
        
        
        
      
        
       
    }
    
    public void getEmptyCard() {
     // TODO delete emty group if wont fill it
        
    }
    
    public int getFirmID (){ return firmID;};
    public String getFirmName() {
        return firmNameLabel.getText();
    }
  
    void editContact() {
    }

    void deleteContact() {
    }
 





    //<editor-fold defaultstate="collapsed" desc="Listeners Card.">
    
   class DelButtonListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
          
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (isConfirmationDialodExists == false) {
                confirmationDialogPointer = new FirmCard.DeleteDialog();
                isConfirmationDialodExists=true;
                
                
            }   else {
                    if (isNotFinishedActionDialogExists == false) {
                        warningNotFinishedActionPointer = new FirmCard.WarningNotFinishedAction();
                        isNotFinishedActionDialogExists = true;
                        
                    } else {warningNotFinishedActionPointer.setVisible(true);
                    }
                } 
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
               
        }

        @Override
        public void mouseEntered(MouseEvent e) {
               
        }

        @Override
        public void mouseExited(MouseEvent e) {
               
        }
        
    
    
    
   
    } 
    
  
               
   class EditButtonListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
             
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (isConfirmationDialodExists == false) {
                confirmationDialogPointer = new FirmCard.EditDialog();
                isConfirmationDialodExists=true;
                
                
            }   else {
                    if (isNotFinishedActionDialogExists == false) {
                        warningNotFinishedActionPointer = new FirmCard.WarningNotFinishedAction();
                        isNotFinishedActionDialogExists = true;
                        
                    } else {warningNotFinishedActionPointer.setVisible(true);
                    }
                } 
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
   
    } 
   
//   class FirmCardListener implements MouseListener {
//
//        @Override
//        public void mouseClicked(MouseEvent e) {
//             
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//            if (isConfirmationDialodExists == false) {
//                confirmationDialogPointer = new FirmCard.EditDialog();
//                isConfirmationDialodExists=true;
//                
//                
//            }   else {
//                    if (isNotFinishedActionDialogExists == false) {
//                        warningNotFinishedActionPointer = new FirmCard.WarningNotFinishedAction();
//                        isNotFinishedActionDialogExists = true;
//                        
//                    } else {warningNotFinishedActionPointer.setVisible(true);
//                    }
//                } 
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//           // throw new UnsupportedOperationException("Not supported yet.");
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//            //throw new UnsupportedOperationException("Not supported yet.");
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//            //throw new UnsupportedOperationException("Not supported yet.");
//        }
//   
//    } 
   class ChoserListeer implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mousePressed(MouseEvent e) {
          FirmList.setChosen(e);
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }
       
   }
   

//</editor-fold> 
 
   
   
   
   
    class DeleteDialog extends JFrame {
          
          private JLabel message = new JLabel("Delete firm \"" + firmNameLabel.getText() + "\"?");
           private JButton okButton = new JButton("Ok");
           private JButton cancelButton = new JButton("Cancel");
           
           private FirmCard.DeleteDialog.OkButtonListener okButtonListener = new FirmCard.DeleteDialog.OkButtonListener();
           private FirmCard.DeleteDialog.CancelButtonListener cancelButtonListener = new FirmCard.DeleteDialog.CancelButtonListener();

           public DeleteDialog ( ){
             super();
             setTitle("Warning");
             draw();
         }
    private void draw(){
           message.setMinimumSize( new Dimension(250, 50));
           JPanel panel = new JPanel();
           this.setContentPane(panel);
           this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
           javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
           panel.setLayout(layout);
           
//   TODO  если юзаеть this для самонстройки или самоинициализации, то в теле класса его не присунуть.
//         Компилятор допускает использование его тольок в внутри метода. Разобратся почему.  
           
          
           
           okButton.addMouseListener(okButtonListener);
           cancelButton.addMouseListener(cancelButtonListener);
           layout.setHorizontalGroup(
                   layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                     .addComponent(message, GroupLayout.Alignment.CENTER)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addComponent(okButton))
                   
                   );
           layout.setVerticalGroup(
                   layout.createSequentialGroup()
                    .addComponent(message)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(cancelButton)
                        .addComponent(okButton))
                   );
                    
        this.pack();
        this.setVisible(true);
         
     }
    public void pullThePlug() {
//        okButton.removeMouseListener(okButtonListener);
//        cancelButton.removeMouseListener(cancelButtonListener);
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        
    }
    

    
    
    
    // <editor-fold defaultstate="collapsed" desc=" Listeners DeleteDialog">
    
     class OkButtonListener implements MouseListener {
                
        

        @Override
        public void mouseClicked(MouseEvent e) {
            
         }

        @Override
        public void mousePressed(MouseEvent e) {
            
                try {
                    deleteContact();
                    System.out.println("deleted");
                    isConfirmationDialodExists=false;
                    confirmationDialogPointer=null;
                    pullThePlug();
                    
                    
                } catch (Exception ex) {
                }
          
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        
    } 
     
      class CancelButtonListener implements MouseListener {             

        @Override
        public void mouseClicked(MouseEvent e) {
           
        }

        @Override
        public void mousePressed(MouseEvent e) {
                
                try {
                    editContact();
                    System.out.println("deleted");
                    isConfirmationDialodExists=false;
                    confirmationDialogPointer=null;
                    pullThePlug();
                    
                    
                } catch (Exception ex) {
                }
            }
           

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        
        
    
   }
            
//</editor-fold>
    
    }
    
     class EditDialog extends JFrame {
          
          private JLabel message = new JLabel("Are you sure?");
           private JButton okButton = new JButton("Ok");
           private JButton cancelButton = new JButton("Cancel");
           
           private FirmCard.EditDialog.OkButtonListener okButtonListener = new FirmCard.EditDialog.OkButtonListener();
           private FirmCard.EditDialog.CancelButtonListener cancelButtonListener = new FirmCard.EditDialog.CancelButtonListener();

           public EditDialog ( ){
             super();
             setTitle("Warning");
             draw();
         }
    private void draw(){
           message.setMinimumSize( new Dimension(250, 50));
           JPanel panel = new JPanel();
           this.setContentPane(panel);
                   panel.setSize(700, 300);
           this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
           this.setSize(700, 700);
           javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
           panel.setLayout(layout);
           
           
           okButton.addMouseListener(okButtonListener);
           cancelButton.addMouseListener(cancelButtonListener);
           layout.setHorizontalGroup(
                   layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                     .addComponent(message, GroupLayout.Alignment.CENTER)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addComponent(okButton))
                   
                   );
           layout.setVerticalGroup(
                   layout.createSequentialGroup()
                    .addComponent(message)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(cancelButton)
                        .addComponent(okButton))
                   );
                    
        this.pack();
        this.setVisible(true);
         
     }
    
   
    public void pullThePlug() {
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        
    }
    

    
    
    
    // <editor-fold defaultstate="collapsed" desc=" Listeners EditDialog">
    
     class OkButtonListener implements MouseListener {
                
        

        @Override
        public void mouseClicked(MouseEvent e) {
            
         }

        @Override
        public void mousePressed(MouseEvent e) {
            
                try {
                    deleteContact();
                    System.out.println("deleted");
                    isConfirmationDialodExists=false;
                    confirmationDialogPointer=null;
                    pullThePlug();
                    
                    
                } catch (Exception ex) {
                }
          
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        
    } 
     
      class CancelButtonListener implements MouseListener {             

        @Override
        public void mouseClicked(MouseEvent e) {
           
        }

        @Override
        public void mousePressed(MouseEvent e) {
                
                try {
                    editContact();
                    System.out.println("deleted");
                    isConfirmationDialodExists=false;
                    confirmationDialogPointer=null;
                    pullThePlug();
                    
                    
                } catch (Exception ex) {
                }
            }
           

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        
        
    
   }
            
//</editor-fold>
    
    }
    
    class WarningNotFinishedAction extends JFrame {
          
          private JLabel messagePart1 = new JLabel("Warning!!");
          private JLabel messagePart2 = new JLabel("Please complete last Delete/Edit action first");
          private JButton okButton = new JButton("Ok");

          private OkButtonListener okButtonListener = new OkButtonListener();

           public WarningNotFinishedAction ( ){
             super();
             setTitle("Warning!!!");
             draw();
         }
    private void draw(){
           messagePart1.setMinimumSize( new Dimension(250, 25));
            messagePart2.setMinimumSize( new Dimension(250, 25));
           JPanel panel = new JPanel();
           this.setContentPane(panel);
           this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
           javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
           panel.setLayout(layout);
           
           
           okButton.addMouseListener(okButtonListener);
           layout.setHorizontalGroup(
                   layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                     .addComponent(messagePart1, GroupLayout.Alignment.CENTER)
                     .addComponent(messagePart2, GroupLayout.Alignment.CENTER)
                     .addComponent(okButton, GroupLayout.Alignment.CENTER)
                   
                   );
           layout.setVerticalGroup(
                   layout.createSequentialGroup()
                    .addComponent(messagePart1)
                    .addComponent(messagePart2)
                    .addComponent(okButton)
                    
                   );
                    
        this.pack();
        this.setVisible(true);
         
     }
    
    
       
    public void pullThePlug() {
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        
    }
    

    
    
    
    // <editor-fold defaultstate="collapsed" desc=" Listeners WarningWindow">
    
     class OkButtonListener implements MouseListener {
                
        

        @Override
        public void mouseClicked(MouseEvent e) {
            
         }

        @Override
        public void mousePressed(MouseEvent e) {
            
                try {
                    confirmationDialogPointer.setVisible(true);
                    isNotFinishedActionDialogExists = false;
                    pullThePlug();
                    
                    
                } catch (Exception ex) {
                }
          
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        
    } 
     
            
//</editor-fold>
    
    }
     
     
}


