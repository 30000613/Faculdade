/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurações;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Utilizador
 */
public class SqlOperations {
    
    Connection con;  
    Statement st = con.createStatement();
    
    public SqlOperations() throws SQLException {
        this.con = DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");
    }
    
    
    public int getUnitId_ByName(String name_input){
        
    
        try {
    Statement st = con.createStatement();
    String query_Select = "Select * from UNIDADES where \"NOME\" = '"+name_input+"'";
    ResultSet rs = st.executeQuery(query_Select);
    int id=0;  
    while (rs.next()){
        if(rs.getInt(1) != 0 )
        id = rs.getInt(1);
                }
    
    return id;
    
      } catch (SQLException ex) {
            Logger.getLogger(SqlOperations.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    
    }
    public int getSubUnitId_ByName(String name_input) throws SQLException{
        
          Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");  
    Statement st = con.createStatement();
    String query_Select = "Select * from SUBUNIDADES where \"NOME\" = '"+name_input+"'";
    ResultSet rs = st.executeQuery(query_Select);
    int id=0;  
    while (rs.next()){
        id = rs.getInt(1);
                }
    return id;
    
    }
    public int getTypeEquipmentId_ByName(String name_input) throws SQLException{
        
          Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");  
    Statement st = con.createStatement();
    String query_Select = "Select * from TIPOS_EQUIPAMENTO where \"NOME\" = '"+name_input+"'";
    ResultSet rs = st.executeQuery(query_Select);
    int id=0;  
    while (rs.next()){
        id = rs.getInt(1);
                }
    return id;
    
    }
    
  
}
