/*
 * This class provides:
 * 
 * 1) methods to work with server connection,
 * 2) methods to process db data;
 * 3) local copy of DB data (stored in resultSet objects) to provide quick data
 *    processing in comparison with sql queries.
 * 4) connection used for login and work;
 */


package crm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kexital
 */
public class LocDbProvider {
    // 
    private static Connection conn1 = null;
    private static Connection conn2 = null;
    private static Statement stmnt1 = null;
    private static Statement stmnt2 = null;
    
    // TODO review access midifiers:
    public static ResultSet firmData = null;  
    public static ResultSet contaсtsData = null;
//    private static ResultSet sf = null;
//    private static ResultSet sdf = null;
//    private static ResultSet sdff = null;
    private static int firmListLength;
    
    private static int fTLenth;
    // TODO тут я срочно для BTL делаю отображение контктов. Халявно. 
    // Поетому в перспективе пересмеотреть реализацию,
    
    public LocDbProvider() {
        try { 
            setConection();
            loadFirmData();
            loadContactsData();
            // set FirmListLength before using of any of gui-related
            // methods like getFirmList.
            setFirmListLength();
            
        } catch (SQLException ex) {
            Logger.getLogger(LocDbProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
    }
//    
//    String serverIP ="192.168.3.115", port = "3306", dbname = "CRM",
//                user = "cs4pc", pass = "0229065nenet";
    String selectQuery = "SELECT * FROM companies;";
//    String conQuery = "jdbc:mysql://" + serverIP +":"+
//                port+ "/" + dbname +"?user=" + user +
//                "&" + "password=" + pass;
    private void setConection() throws SQLException {
        try {
            System.out.print("setting a connection............     ");
            conn1 = DriverManager.getConnection("jdbc:mysql://192.168.1.32:3306/crm?user=cs4pc&password=0229065nenet");
            conn2 = DriverManager.getConnection("jdbc:mysql://192.168.1.32:3306/crm?user=cs4pc&password=0229065nenet");
            System.out.println("OK");
        } 
        catch (SQLException e) {
            System.out.println( "CRM Connection error:" + e);
            conn1.close();
            conn2.close();
        }
        finally {
          //TODO : Call crm err vindow with err summary  
        }
    }
    private void loadFirmData() throws SQLException{
        try {
            System.out.print("Loading FirmTble.........  ");
            stmnt1 = conn1.createStatement();
            firmData = stmnt1.executeQuery("use crm;");
            firmData = stmnt1.executeQuery(selectQuery);
            System.out.println("OK");
        } catch (Exception e) { 
            System.out.println("CRM SQL Select or conn error:" + e);
            conn1.close();
        }
        finally {
            //TODO : Call crm err vindow with err summary
            //TODO close connection when program laods all data or exits;
        }
    }
    private void loadContactsData() throws SQLException{
        try {
            System.out.print("Loading ContactsData.........  ");
            stmnt2 = conn2.createStatement(); // TODO !!!! 1 21  11 1 что за нах
            contaсtsData = stmnt2.executeQuery("SELECT * FROM contacts;");
            System.out.println("OK");
        } catch (Exception e) { 
            System.out.println("CRM SQL Select or conn error:" + e);
            conn2.close();
        }
        finally {
            
        }
    }
    private void setFirmListLength(){
//        !!! Set FirmListLength before using of any
//        of gui-related methods like getFirmList
        try {
            firmData.last();
            firmListLength=firmData.getRow();
            firmData.first();
        } catch (SQLException ex) {
            System.out.println("CRM_Connection_related_error. PrintStack:" + ex);
            Logger.getLogger(LocDbProvider.class.getName()).log(Level.INFO, null, ex);
        }
       
                
//      TODO Fogot about using System.err - its depricated for production, 
//      because of its using may cause you to lose important error information.
//      You are able to use it during testing or development but not Production.
//      Use Logger (java.util.logging.Logger) or other loggin framework instead.
//      System.err;
        
    };
    
    public static int getFirmListLength (){
        return firmListLength;
    }
//    public void getContactData(int firmCardId) throws SQLException {
//        try {
//           // Statement st = conn1.createStatement();
//            System.out.print("Loading Contacts.........  ");
//            contaсtsData = stmnt2.executeQuery("SELECT * FROM Contacts where IdCompany Like \"" + firmCardId+ "\";");
//            System.out.println("OK");
//        } catch (Exception e) { 
//            System.out.println("CRM SQL Select or conn error:" + e);
//            conn1.close();
//        }
//        finally {
//            //TODO : Call crm err vindow with err summary
//            //TODO close connection when program laods all data or exits;
//        }
//       
//    }
    public final String getFirmList(int carret) throws SQLException  {
        // length without table "autoicnrement" and "ID" fields = 6
        // even list elements - 2-nd ResultSet row, odd- 6-th
        // TODO AbstractList get elements by i position begining from
        // 0 (as used to use String arrays)

        carret++;
        String value;
        String arr[] = new String[fTLenth];
        
             if (carret == 1) { 
                 firmData.first();
                 value = firmData.getString(2);
             } else { 
                 if (carret == 2){
                     firmData.first();
                     value = firmData.getString(6);
                 } else{
                     /// сцука ппц метод напиши красиво
                 if (carret%2 != 0) {
                     firmData.absolute((carret+1)/2);
                     value =firmData.getString(2);                
                 } else { 
                     firmData.absolute(carret/2);
                     value = firmData.getString(6); }
                 }
            }
        return value;   
        
     
    }
    public final String getFirmName(int carret) throws SQLException  {
        // 
        carret++;
        String arr[] = new String[fTLenth];
        firmData.first();
        firmData.absolute(carret);
        
             
        return firmData.getString(2);   
        
     
    }
    public final String getFirmWebAddr(int carret) throws SQLException  {
        // 
        carret++;
        String arr[] = new String[fTLenth];
        firmData.first();
        firmData.absolute(carret);
        
             
        return firmData.getString(6);   
        
     
    }
    public final int getFirmID(int carret) throws SQLException{
           carret++;
        String arr[] = new String[fTLenth];
        firmData.first();
        firmData.absolute(carret);
        
        return (firmData.getInt(1));
       }
    public void getContactData() {
           
    }
       
    public final String[] getAllFirmData() throws SQLException {
        firmData.last();
        fTLenth = firmData.getRow();
        int rowLength = 6;  // length without table "autoicnrement" and "ID" fields
        String arr[] = new String[fTLenth];
        try { 
            
            firmData.first();
            int top = 0;
            do {
                    for (int i=0; i<rowLength; i++){
                        arr[top] = firmData.getString(i+2);   //+2 ass we should begun from 1 (resultset colomns id begin from 1) + we skip ID field (additional +1)
                        top++;
                    } 
                    
                } while (firmData.next());
            }
            catch (Exception e) {
                
            }
        return arr;
        
    }
    
//    public static void main ( String[] args) throws SQLException {
//        LocDbProvider d = new LocDbProvider();
//        d.setConection();
//        d.loadFirmData();
//        while (firmData.next()) {
//            for (int i=1;i<5;i++){
//               System.out.print(firmData.getString(i)+" ");
//               conn.close();
//            }
//            System.out.println();
//            
//        }
            
            
       
//    }
    
    
}
    
