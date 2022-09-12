/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Org.Scouts.backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Utilizador
 */
class Instruments {
    
     public String CurrentDate(){
        

     Date date = (Date) Calendar.getInstance().getTime();
     DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
     String CurrentDate = formatter.format(date);

        return CurrentDate;
    }
    
}
