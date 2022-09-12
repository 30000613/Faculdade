package Configurações;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import Configurações.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utilizador
 */
public class InsertScoutMaterial_Excel {
    
      Connection con;
      SqlOperations getKey;
      
      

    public InsertScoutMaterial_Excel() throws SQLException {
        this.getKey = new SqlOperations();
    }
      
    public void InsertMaterial(String codigo_input,String unidade_input,String Subunidade_input,String Tipo_input, String name_input,String descricao_input ) throws SQLException {

     String codigo = codigo_input;
     int unidade = getKey.getUnitId_ByName(unidade_input);
     int subunidade = getKey.getSubUnitId_ByName(Subunidade_input);
     int Tipo = getKey.getTypeEquipmentId_ByName(Tipo_input);
     String name = name_input;   
     String descricao = descricao_input;

     Date date = (Date) Calendar.getInstance().getTime();
     DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
     String CurrentDate = formatter.format(date);
     
     System.out.println("Codigo: "+codigo);
     System.out.println("Unidade: "+unidade);
     System.out.println("Sub-Unidade: "+subunidade);
     System.out.println("Tipo de equipamento: "+Tipo);
     System.out.println("Nome do equipamento: "+name);
     System.out.println("Descrição :"+descricao);
     System.out.println("Data de registo: "+CurrentDate);
     
     
    ObjectsExcel Charact =  new ObjectsExcel();
    Charact.setFullCodigo(codigo);
            
           
           
         try{
    con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");  
    Statement st = con.createStatement();
    String query_Insert_Equipment = "Insert into ADMINA.EQUIPAMENTOS(NOME,DESCRICAO,DATA_REGISTO,TIPO,CODIGO) VALUES('"+name+"','"+descricao+"','"+CurrentDate+"',3,'01')";
    String[] returnId = { "EQUIPAMENTO_ID" };
    PreparedStatement statement = con.prepareStatement(query_Insert_Equipment,
                                      returnId);
    statement.executeUpdate();
    ResultSet rs = statement.getGeneratedKeys();
    
    
    int EquipId = 0;
     if (rs.next()) {
       EquipId = rs.getInt(1);
                }

    String query_insert_relationshipt = "Insert into EQUIPAMENTOS_UNIDADES(UNIDADE_FK,SUBUNI_FK,EQUIPAMENTO_FK) VALUES("+unidade+","+subunidade+","+EquipId+")";
    st.execute(query_insert_relationshipt);
    
    st.close();
    con.close();
             System.out.println("Dados Guardados");
    }catch(Exception e){e.printStackTrace();};
    
    
}
    
}
