<%-- 
    Document   : DetailScreen
    Created on : 4/set/2022, 21:58:17
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
      int index =Integer.parseInt(request.getParameter("EquipId").toString());    
      int tipoId = 0;
      int unitId = 0;
      int subunitId = 0;
      
      String selected = "";
    try{
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");  
    Statement st = con.createStatement();
    String query_Select = "SELECT EQUIPAMENTOS.NOME, \n" +
                            " EQUIPAMENTOS.CODIGO,\n" +
                            " EQUIPAMENTOS.DESCRICAO,\n" +
                            " TIPOS_EQUIPAMENTO.NOME,\n" +
                            " EQUIPAMENTOS.DATA_REGISTO,\n" +
                            " UNIDADES.NOME,\n" +
                            " SUBUNIDADES.NOME,\n" +
                            " SUBUNIDADES.CODIGO,\n" +
                            " TIPOS_EQUIPAMENTO.CODIGO,\n" +
                            " EQUIPAMENTOS.EQUIPAMENTO_ID,\n" +
                            " TIPOS_EQUIPAMENTO.TE_ID, \n"+
                            " UNIDADES.UNIDADE_ID, \n"+
                            " SUBUNIDADES.SUBUNIDADE_ID \n"+
                            "FROM ADMINA.EQUIPAMENTOS \n" +
                            "left join EQUIPAMENTOS_UNIDADES on EQUIPAMENTO_ID = EQUIPAMENTO_FK\n" +
                            "left join UNIDADES on UNIDADE_FK= UNIDADE_ID\n" +
                            "left join SUBUNIDADES on SUBUNI_FK = SUBUNIDADE_ID\n" +
                            "left join TIPOS_EQUIPAMENTO on EQUIPAMENTOS.TIPO = TIPOS_EQUIPAMENTO.TE_ID "

            + "where \"EQUIPAMENTO_ID\" = "+index;
    
    ResultSet rs = st.executeQuery(query_Select);
    
    

   
    while (rs.next()){
         if(rs.getInt(11) != 0)
        tipoId=Integer.parseInt(rs.getString(11).trim());
           if(rs.getInt(12) != 0)
        unitId=Integer.parseInt(rs.getString(12).trim());
            if(rs.getInt(13) != 0)
        subunitId=Integer.parseInt(rs.getString(13).trim());
    
        
        %>
        
         <h1>O equipamento selecionado: </h1>
         
         <form name="EquipForm" method="post" action="DetailScreenOperations" >
             <div class=".InputTextBox">
             <label> Equipamento </label>
             <input type="text" name="EquipName" value="<%=rs.getString(1)%>" /></div><br>
             <div class=".InputTextBox">
             <label> Descrição </label>
             <input type="text" name="EquipDescrip" value="<%=rs.getString(3)%>" /></div><br>
              <div class=".InputTextBox">
               <label> Codigo do Equipamento </label>
             <input type="text" name="EquipCode" value="<%=rs.getString(2)%>" /></div><br>
              <div class=".InputTextBox">
               <label> Data de registo</label>
             <input type="text" name="EquipData" value="<%=rs.getString(5)%>" /></div><br>
              <div class=".InputTextBox">
                   <label for="EquipType">Tipo de Equipamento: </label>
                   <select name="EquipType" id="EquipType">
                        <option value="0">Selecione um Equipamento</option>
                        <%
                           rs.close();
                           String query_getTypeQuip = "SELECT TE_ID,NOME FROM TIPOS_EQUIPAMENTO";
                           ResultSet GetTypeEquips = st.executeQuery(query_getTypeQuip);
                           while(GetTypeEquips.next()){
                             
                            %>   
                       <option value="<%=GetTypeEquips.getString(1).trim()%>" <%if(tipoId==Integer.parseInt(GetTypeEquips.getString(1).trim())){%> selected <%}%> value=""  ><%=GetTypeEquips.getString(2).trim()%></option>
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
                       <option value="<%=GetUnits.getString(1).trim()%>" <%if(unitId==Integer.parseInt(GetUnits.getString(1).trim())){%> selected <%}%> ><%=GetUnits.getString(2)%></option>
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
                       <option value="<%=GetSubUnits.getString(1).trim()%>" <%if(subunitId==Integer.parseInt(GetSubUnits.getString(1).trim())){%> selected <%}%> ><%=GetSubUnits.getString(2)%></option>
                       <% }
                       %>
                   </select>
               </div><br>
             
                         
               <button type="submit" value="UpdateBtn" name="button">Atualizar Equipamento</button>
               <button type="submit" value="DeleteBtn" name="button">Eliminar equipamento</button>
               
             </form>
             <input type="button" value="Cancelar" onclick="window.document.location='EquipmentList.jsp'">
    
        <%
                }

    con.close();

    }catch(Exception e){System.out.println("An exception occurred: " + e.getMessage());;};
          

    

    
            %>
        
       
       
    </body>
</html>
