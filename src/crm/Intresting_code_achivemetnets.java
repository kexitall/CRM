/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// TODO Instalation tips(do not erase any): 
// 1) add users on servers providing access from any IP in interneal LAN
//    but to only SOME Databases by GRANT all ON DBName ...GRANT ALL PRIVILEGES ON exactDbName TO 'user'@'192.168.1.%'
// 2) User rights is equal to DB admin, but their DB passvords stored in "users_DB_passwords table" (thay has no access to it)
//     and don't known them. Users shuld login in program with some passwords stored in "users_crm_passwords_table"
//     but getting access to crm Databases only because program itself gets users DB_access_pass and perfoms users actions with their admins rights(bu dont shows them their DB passwords)

// 3) CRM admin is the same as DB admin/ and dont shares or stores his password anywhere.
// 4) program has hardCoded serverLogin/Pass pair. But in future program should get it by manual definition during instalation process,
//     and must keep it in encripted file(or get it every time at Key-server( as 1C pruducts does). )

// 5) 




// TODO Programm manual:
// 1) include Instalation tips
// 2) Every perfomed change apdates table immediately with transaction query.
//    updates performs in its own thread process (common for all SQL-queries).
// 3) 

package crm;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author kexital
 */
public class Intresting_code_achivemetnets {
    
    
    
    
     class dateUtil {
        Calendar calll = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat();

        private void del() {
            sdf.set2DigitYearStart(null);
    
        }
    //TODO to Notes and delete now();
    //<editor-fold defaultstate="collapsed" desc="Note. Nice method to get integer date year or smth defined by pattern providet to method">
        public Integer now(String dateFormat) {
        Calendar cal1 = Calendar.getInstance();  // not sure its necessary
        SimpleDateFormat sdf1 = new SimpleDateFormat(dateFormat);
        String str = sdf1.format(calll.getTime());
        // Uncoment SystemOut for test function if need
        // System.out.println(str);
        return Integer.valueOf(str);
        
               
    }
    //</editor-fold>
        
    // TODO Note в полях класса никакая логика и действия не допустимы. Суй в мейн, или в метод выхываемый конструктором.   
        
        
//  deteUtil end
}


}
