/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//TODO Note: Делай поля хранящие ссылку на обьекты с котрыми придтся работать нескольким классам
//TODO Note: Разберись с внутренними классам, и почему здесь одинаковые по названию листенеры но лежащие в разных внутренних классах друг другу не мешают и не Overrides/Hides

//TODO Nice comment pattern. note it!Ш
/* */  // <editor-fold defaultstate="collapsed" desc="->>">
            /* 
             * 
             */
           //</editor-fold>



//TODO Empty fold pattern
// <editor-fold defaultstate="collapsed" desc="empty_fold">
            
//</editor-fold>
package crm;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author kexital
 */
public class ContactCard extends JPanel {
 
//  <editor-fold defaultstate="collapsed" desc="Variables declaraion    (not complete)">
    
// static flag (true/false) for Dialog windows exstance:
        private static boolean isConfirmationDialodExists = false;
        private static boolean isNotFinishedActionDialogExists = false;
        
//  card fields labels:
        private int dbContactID;
        private JLabel firstNameLabel = new JLabel("Имя");
        private JLabel lastNameLabel = new JLabel("Фамилия");
        private JLabel fatherNameLabel = new JLabel("Отчество");
        private JLabel telLabel = new JLabel("тел.");
        private JLabel emailLabel = new JLabel("e-mail");
        private JLabel departmentLabel = new JLabel("Отдел");
        private JLabel positionLabel = new JLabel("Должность");
        private JLabel creatorLabel = new JLabel("Создатель");
       
//      contact's data:
        private JLabel firstName = new JLabel();
        private JLabel lastName = new JLabel();
        private JLabel fatherName = new JLabel();
        private JLabel tel = new JLabel();
        private JLabel email = new JLabel();
        private JLabel department = new JLabel();
        private JLabel position = new JLabel();
        private JLabel creator = new JLabel();

//  card actions buttons:        
        private JButton delButton = new JButton("Delete");
        private JButton editButton = new JButton("Edit");
//  pointers (I don't cnow how to ):
      private static JFrame confirmationDialogPointer;
      private static JFrame warningNotFinishedActionPointer;
      
//  </editor-fold>      
     
  
    public ContactCard (int firmID) {
        try {
                  LocDbProvider.contaсtsData.first();
                  for ( int i = 0; i < LocDbProvider.getFirmListLength()-1; i++ ) {
                  try {
                      LocDbProvider.contaсtsData.first();
                      if ((LocDbProvider.contaсtsData.getInt(1))==firmID||(LocDbProvider.contaсtsData.getInt(7))==firmID) {
                         firstName.setText(LocDbProvider.contaсtsData.getString(2));
                         lastName.setText(LocDbProvider.contaсtsData.getString(3));
                         fatherName.setText(LocDbProvider.contaсtsData.getString(4));
                         tel.setText(LocDbProvider.contaсtsData.getString(5));
                         email.setText(LocDbProvider.contaсtsData.getString(6));
                         department.setText(LocDbProvider.contaсtsData.getString(7));
                         position.setText(LocDbProvider.contaсtsData.getString(8));
                         creator.setText(LocDbProvider.contaсtsData.getString(9));
                         
                         
//                         if (LocDbProvider.contaсtsData.getString(2).equals("")) {
//                             firstName.setText("---");
//                         } else { firstName.setText(LocDbProvider.contaсtsData.getString(2));}
//                         
//                          if (LocDbProvider.contaсtsData.getString(3)==null) {
//                             lastName.setText("---");
//                         } else {lastName.setText(LocDbProvider.contaсtsData.getString(3));}
//                         
//                          if (LocDbProvider.contaсtsData.getString(4)==null) {
//                             fatherName.setText("---");
//                         } else { fatherName.setText(LocDbProvider.contaсtsData.getString(4));}
//                         
//                          if (LocDbProvider.contaсtsData.getString(5)==null) {
//                             tel.setText("---");
//                         } else {tel.setText(LocDbProvider.contaсtsData.getString(5));}
//                         
//                          if (LocDbProvider.contaсtsData.getString(6)==null) {
//                             email.setText("---");
//                         } else {email.setText(LocDbProvider.contaсtsData.getString(6));}
//                          
//                          if (LocDbProvider.contaсtsData.getString(7)==null) {
//                             department.setText("---");
//                         } else {department.setText(LocDbProvider.contaсtsData.getString(7));}
//                          
//                          if (LocDbProvider.contaсtsData.getString(8)==null) {
//                             position.setText("---");
//                         } else {position.setText(LocDbProvider.contaсtsData.getString(8));}
//                          
//                          if (LocDbProvider.contaсtsData.getString(9)==null) {
//                             creator.setText("---");
//                         } else { creator.setText(LocDbProvider.contaсtsData.getString(9));}
                         
                         
                         
                         
                      }
                      LocDbProvider.contaсtsData.next();
                  } catch (SQLException ex) {
                      Logger.getLogger(AScrollList.class.getName()).log(Level.SEVERE, null, ex);
                  }

              }
             LocDbProvider.contaсtsData.first();
             } catch (SQLException ex) {
                 Logger.getLogger(AScrollList.class.getName()).log(Level.SEVERE, null, ex);
             }
              
        initComponents();
        
    }
    
    public ContactCard ( int id,
                         String firstName,
                         String lastName,
                         String fatherName,
                         String tel,
                         String email,
                         String department,
                         String position,
                         String creator ) {
        dbContactID = id;
        
        this.firstName.setText(firstName);
          this.lastName.setText(lastName);
          this.fatherName.setText(fatherName);
          this.tel.setText(tel);
          this.email.setText(email);
          this.department.setText(department);
          this.position.setText(position);
          this.creator.setText(creator);
        initComponents();
    }
    
    
    public static ContactCard[] getAllFirmsContats (int firmID) {
        ContactCard[] arr = new ContactCard[10];    //TODO: в мануал к программе: в проге для одной компании может быть до десяти контактов
        try {
                  
                  int top=0;
                  LocDbProvider.contaсtsData.first();
                  ContactCard buf = new ContactCard(1);   // TODO return dummy assigning if got err/
                  for ( int i = 0; i < LocDbProvider.getFirmListLength(); i++ ) {
                  try {
                      if ((LocDbProvider.contaсtsData.getInt(1))==firmID||(LocDbProvider.contaсtsData.getInt(7))==firmID)  {
                         buf = new ContactCard(LocDbProvider.contaсtsData.getInt(1),
                         LocDbProvider.contaсtsData.getString(2),
                         LocDbProvider.contaсtsData.getString(3),
                         LocDbProvider.contaсtsData.getString(10),
                         LocDbProvider.contaсtsData.getString(9), //8
                         LocDbProvider.contaсtsData.getString(7),
                         LocDbProvider.contaсtsData.getString(5),
                         LocDbProvider.contaсtsData.getString(5),
                         LocDbProvider.contaсtsData.getString(9));
                         buf.setMaximumSize(new Dimension(200, 200));
                         arr[top]=buf; 
                         
                      }
                      top++;
                      LocDbProvider.contaсtsData.next();
                  } catch (SQLException ex) {
                      Logger.getLogger(AScrollList.class.getName()).log(Level.ALL, null, ex);
                  }

              }
             LocDbProvider.contaсtsData.first();
             
             } catch (SQLException ex) {
                 Logger.getLogger(AScrollList.class.getName()).log(Level.SEVERE, null, ex);
             }
        return (arr);
        
    }    
    private void initComponents() {
        delButton.addMouseListener(new ContactCard.DelButtonListener());
        editButton.addMouseListener(new ContactCard.EditButtonListener());
        delButton.setEnabled(true);
        this.setBorder(BorderFactory.createEtchedBorder(WIDTH));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        
        
        // seting sizes for labels to prevent component movings when component hasnt text data(actualy doesnt work with current layout and due .add with size parameters)
        
        int height = 20;
        int weigth = 70;
        
        firstNameLabel.setSize (height, weigth);
        lastNameLabel.setSize (height, weigth);
        fatherNameLabel.setSize (height, weigth);
        telLabel.setSize (height, weigth);
        emailLabel.setSize (height, weigth);
        departmentLabel.setSize (height, weigth);
        positionLabel.setSize (height, weigth);
       // creatorLabel.setSize (height, weigth);
//        
//        firstName.setSize (height, weigth);
//        lastName.setSize (height, weigth);
//        fatherName.setSize (height, weigth);
//        tel.setSize (height, weigth);
//        email.setSize (height, weigth);
//        department.setSize (height, weigth);
//        position.setSize (height, weigth);
//        creator.setSize (height, weigth);
        
        // end of setSize block
        
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                    
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNameLabel, weigth, 75, 76)
                        .addComponent(firstName)
                        
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lastNameLabel, weigth, 75, 76)
                        .addComponent(lastName)
                        
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fatherNameLabel, weigth, 75, 76)
                        .addComponent(fatherName)
                        
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(telLabel, weigth, 75, 76)
                        .addComponent(tel)
                        
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emailLabel, weigth, 75, 76)
                        .addComponent(email)
                        
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(departmentLabel, weigth, 75, 76)
                        .addComponent(department)
                        
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(positionLabel, weigth, 75, 76)
                        .addComponent(position)
                        
                    )
                // comented because there is no realization for getting creator
                // name and it apears as digital code of user that points at actual
                // name stored at other table.
//                    .addGroup(layout.createSequentialGroup()
//                        .addComponent(creatorLabel, weigth, 75, 76)
//                        .addComponent(creator)
//                        
//                    )
//                   
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editButton)
                        .addComponent(delButton)
                        
                    )
                
                );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                
                    .addGroup(layout.createParallelGroup()
                        .addComponent(firstNameLabel)
                        .addComponent(firstName)
                        
                    )
                
                    .addGroup(layout.createParallelGroup()
                        .addComponent(lastNameLabel, weigth, 75, 76)
                        .addComponent(lastName)
                     )
                
                    .addGroup(layout.createParallelGroup()
                        .addComponent(fatherNameLabel)
                        .addComponent(fatherName)
                        
                    )
                    .addGroup(layout.createParallelGroup()
                        .addComponent(telLabel)
                        .addComponent(tel)
                        
                    )
                    .addGroup(layout.createParallelGroup()
                        .addComponent(emailLabel)
                        .addComponent(email)
                        
                    )
                    .addGroup(layout.createParallelGroup()
                        .addComponent(departmentLabel)
                        .addComponent(department)
                        
                    )
                    .addGroup(layout.createParallelGroup()
                        .addComponent(positionLabel)
                        .addComponent(position)
                        
                    )
                
                // comented because there is no realization for getting creator
                // name and it apears as digital code of user that points at actual
                // name stored at other table.
                
//                    .addGroup(layout.createParallelGroup()
//                        .addComponent(creatorLabel)
//                        .addComponent(creator)
//                        
//                    )
//                   
                    .addGroup(layout.createParallelGroup()
                        .addComponent(editButton)
                        .addComponent(delButton)
                        
                    )
                );
        
        
        
      
        
       
    }
    
    public void getEmptyCard() {
        firstName.setText("-");
        lastName.setText("-");
        fatherName.setText("-");
        tel.setText("-");
        email.setText("-");
        department.setText("-");
        position.setText("-");
        creator.setText("-");
        
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
                confirmationDialogPointer = new DeleteDialog();
                isConfirmationDialodExists=true;
                
                
            }   else {
                    if (isNotFinishedActionDialogExists == false) {
                        warningNotFinishedActionPointer = new WarningNotFinishedAction();
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
                confirmationDialogPointer = new EditDialog();
                isConfirmationDialodExists=true;
                
                
            }   else {
                    if (isNotFinishedActionDialogExists == false) {
                        warningNotFinishedActionPointer = new WarningNotFinishedAction();
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
   
  
   

//</editor-fold> 
 
   
   
   
   
    class DeleteDialog extends JFrame {
          
          private JLabel message = new JLabel("Delete contact \"" + firstName.getText() + " " + lastName.getText() + "\"?");
           private JButton okButton = new JButton("Ok");
           private JButton cancelButton = new JButton("Cancel");
           
           private DeleteDialog.OkButtonListener okButtonListener = new DeleteDialog.OkButtonListener();
           private DeleteDialog.CancelButtonListener cancelButtonListener = new DeleteDialog.CancelButtonListener();

           public DeleteDialog ( ){
             super();
             setTitle("Warning");
             
//   TODO: запомни что в конструкторе уже доступно использование 
//   методов наследуемого класса
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
        okButton.removeMouseListener(okButtonListener);
        cancelButton.removeMouseListener(cancelButtonListener);
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
           
           private EditDialog.OkButtonListener okButtonListener = new EditDialog.OkButtonListener();
           private EditDialog.CancelButtonListener cancelButtonListener = new EditDialog.CancelButtonListener();

           public EditDialog ( ){
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
        okButton.removeMouseListener(okButtonListener);
        cancelButton.removeMouseListener(cancelButtonListener);
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
           messagePart1.setMinimumSize( new Dimension(30, 50));
           messagePart2.setMinimumSize( new Dimension(100, 50));
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
        okButton.removeMouseListener(okButtonListener);
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


