<%-- 
    Document   : CreateScreen
    Created on : 4/set/2022, 22:19:41
    Author     : Utilizador
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
        
        
        <%
       
  
   
    try{
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");  
    Statement st = con.createStatement();


        
        %>
        
         <h1>O equipamento selecionado: </h1>
         
         <form name="EquipForm" method="post" action="CreateMaterialServlet" >
             <div class=".InputTextBox">
             <label> Equipamento </label>
             <input type="text" name="EquipName" value= ></div><br>
             <div class=".InputTextBox">
             <label> Descrição </label>
             <input type="text" name="EquipDescrip" value= ></div><br>
              <div class=".InputTextBox">
               <label> Codigo do Equipamento </label>
             <input type="text" name="EquipCode" value= ></div><br>       
              <div class=".InputTextBox">
                   <label for="EquipType">Tipo de Equipamento: </label>
                   <select name="EquipType" id="EquipType">
                        <option value="0">Selecione um Equipamento</option>
                        <%
                         
                           String query_getTypeQuip = "SELECT TE_ID,NOME FROM TIPOS_EQUIPAMENTO";
                           ResultSet GetTypeEquips = st.executeQuery(query_getTypeQuip);
                           while(GetTypeEquips.next()){
                             
                            %>   
                       <option value="<%=GetTypeEquips.getString(1).trim()%>"> <%=GetTypeEquips.getString(2).trim()%> </option>
                       <% }

                       %>
                   </select>
               </div><br>
                <div class=".InputTextBox">
                   <label for="EquipUnit">Unidade: </label>
                   <select name="EquipUnit" id="EquipUnit">
                        <option value="0">Selecione uma Unidade</option>
                        <%
                           GetTypeEquips.close();
                           String query_getTypeUnit = "SELECT UNIDADE_ID,NOME FROM ADMINA.UNIDADES";
                           ResultSet GetUnits = st.executeQuery(query_getTypeUnit);
                           while(GetUnits.next()){
                            %>   
                       <option value="<%=GetUnits.getString(1).trim()%>" ><%=GetUnits.getString(2)%></option>
                       <% }
                       %>
                   </select>
               </div><br>
     <div class=".InputTextBox">
                   <label for="EquipSubUnit">Sub-Unidade: </label>
                   <select name="EquipSubUnit" id="EquipSubUnit">
                        <option value="0">Selecione uma sub-unidade</option>
                        <%
                           GetUnits.close();
                           String query_getSubType = "SELECT SUBUNIDADE_ID,NOME FROM SUBUNIDADES";
                           ResultSet GetSubUnits = st.executeQuery(query_getSubType);
                           while(GetSubUnits.next()){
                            %>   
                       <option value="<%=GetSubUnits.getString(1).trim()%>"><%=GetSubUnits.getString(2)%></option>
                       <% }
                       %>
                   </select>
               </div><br>
   
                 <input type="submit" value="Guardar Equipamento" id="button">
                 <input type="button" value="Cancelar" onclick="window.document.location='EquipmentList.jsp'">
               
             </form>
    
        <%
                

    con.close();

    }catch(Exception e){System.out.println("An exception occurred: " + e.getMessage());;};
          

    

    
            %>
        
       
       
    </body>
</html>
