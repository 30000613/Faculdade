/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orgs.Scouts.Actions;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilizador
 */
public class SqlOperations {
    
    
     public void UpdateEquipment(String inputName,String inputDescricao, int index) throws SQLException{
        

                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");
                Statement st = con.createStatement();
                String Update_Query ="Update EQUIPAMENTOS\n" +
                                        "set EQUIPAMENTOS.NOME = '"+inputName+"', EQUIPAMENTOS.DESCRICAO ='"+inputDescricao+"'\n" +
                                        "where EQUIPAMENTOS.EQUIPAMENTO_ID = "+index+" ";; 
                st.executeUpdate(Update_Query);
                con.close();
    }
    
    public int getMaterialId_FromUrl(String url_input) throws MalformedURLException {  
             
               URL url = new URL(url_input);
               String queryStr = url.getQuery();
               String key ="";
               String val = "";
               int id = 0;
               
               String[] params = queryStr.split("&");
               for (String param: params) {
                    key = param.substring(0, param.indexOf('='));
                    val = param.substring(param.indexOf('=') + 1);
                }
               
               id = Integer.parseInt(val);
                    return id;  
}
    public boolean EquipmentUnionExists(int EquipId_input) throws SQLException {
        int id = EquipId_input;
        boolean exists = true;
         Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");
         Statement st = con.createStatement();
         String query ="SELECT * from EQUIPAMENTOS_UNIDADES\n" +
                        "where EQUIPAMENTOS_UNIDADES.EQUIPAMENTO_FK = "+id+" ";
       ResultSet rs =  st.executeQuery(query);
     if(rs.next() == false) {
         exists = false;
     }else { exists= true; }
        return exists;
    }
    
    public boolean DeleteAllEquipments () {
        
         try {
             Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");
             Statement st = con.createStatement();
             String query ="Delete from ADMINA.EQUIPAMENTOS";
             st.executeUpdate(query);
             return true;
             
         } catch (SQLException ex) {
             Logger.getLogger(SqlOperations.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
        
    }
    
    
   
    
}
