/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurações;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Utilizador
 */
public class Instruments {
 
    public String CurrentDate(){
        

     Date date = (Date) Calendar.getInstance().getTime();
     DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
     String CurrentDate = formatter.format(date);

        return CurrentDate;
    }
    
    public String GetUnitCode_Combo(String unit) {
        
        String[] getCode = unit.split("-",2);
        
        return getCode[0];
    }
    
   
    
   /* public char getUnitCode_excel(){
        char[] unitCode = this.grupo.toCharArray();
        return unitCode[0];
    }
    
     public char getSubUnitCode_excel(){
        char[] SubunitCode = this.grupo.toCharArray();
        return SubunitCode[1];
    }*/


    

    
}
