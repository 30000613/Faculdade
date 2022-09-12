<%-- 
    Document   : newjsp
    Created on : 3/set/2022, 23:34:04
    Author     : Utilizador
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Orgs.Scouts.Actions.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scout Material Manager</title>
        <script src="table2excel.js"></script>
        <style>
    .HalfDiv{
        width: 50%;
        overflow:auto; 
    }
    
    #table-wrapper {
     position:relative;
     float: left;
   }
   #table-scroll {
     height:150px;
     overflow:auto;  

   }
   #table-wrapper table {
     width:100%;

   }

   #table-wrapper table thead th .text {
     position:absolute;   
     top:-20px;
     z-index:2;
     height:20px;
     width:35%;

   }   
    
</style>
        
    </head>
        <body> 
    <div><h1> Scout Material Manager</h1></div>
    
    <div style="width: 100%; overflow: hidden;">
    <div id="table-wrapper" class="HalfDiv">
        <div id="table-scroll" >
            <form method="post" >
                <table border="1" id="EquipTable">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Nome</th>
                            <th>Descricao</th>
                            <th>Tipo Equipamento</th>
                            <th>ID</th>
                        </tr>
                    </thead>
                    
                    <%

   try
   {
     Class.forName("org.apache.derby.jdbc.ClientDriver"); 
    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");  
    Statement st = con.createStatement();
     String query_Select = "SELECT EQUIPAMENTOS.NOME,"
            + "                   EQUIPAMENTOS.DESCRICAO,"
            + "                   TIPOS_EQUIPAMENTO.NOME, "
            + "                   UNIDADES.CODIGO, "
            + "                   SUBUNIDADES.CODIGO,"
            + "                   TIPOS_EQUIPAMENTO.CODIGO,"
            + "                   EQUIPAMENTOS.CODIGO,"
            + "                   EQUIPAMENTOS.EQUIPAMENTO_ID"
            + "                   FROM ADMINA.EQUIPAMENTOS \n" +
                                "left join EQUIPAMENTOS_UNIDADES on EQUIPAMENTO_ID = EQUIPAMENTO_FK\n" +
                                "left join UNIDADES on UNIDADE_FK= UNIDADE_ID\n" +
                                "left join SUBUNIDADES on SUBUNI_FK = SUBUNIDADE_ID\n" +
                                "left join TIPOS_EQUIPAMENTO on EQUIPAMENTOS.TIPO = TIPOS_EQUIPAMENTO.TE_ID\n" +"";
    
    
    ResultSet rs = st.executeQuery(query_Select);
   while(rs.next()){   
    String CodeBuilder="1240."+rs.getString(4)+rs.getString(5)+"."+rs.getString(6)+rs.getString(7); 
   %> 
   <tr onclick="window.document.location='DetailScreen.jsp?EquipId=<%=rs.getString(8)%>'" class="tableRow">
                        <td><%=CodeBuilder %></td>
                        <td><%=rs.getString(1)%></td>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getString(3)%></td>
                        <td><%=rs.getString(8)%></td>
                    </tr>
        <%
            }
   %>                 
 
                </table>
    <%
       }
   catch(Exception e)
   {
        e.printStackTrace();
   }
   %>


           </form>
        </div>
        </div>
   <div style="margin-left: 620px; padding-left: 88px;">
   <div ><input type="submit" value="Adicionar Material" name="CreateButton" onclick="location.href = 'CreateScreen.jsp';" /> </div>
   
   <form action="EquipmentListOpeartions" method="post" enctypt="multipart/form-data">
       
   <label for="Select_File">Selecione o ficheiro para importar: </label>
   
   <div ><input type="file" id="selector" name="Select_File" /></div>
   
   <div><button type="submit" id="ImportExcelBtn" name="action" value="ImportExcelBtn"/>Importar Ficheiro .xlsx</div>
   
   <div><button type="submit" id="DeleteAllBtn" name="action" value="DeleteAllBtn" />Eliminar lista de materiais</div>
   
   </form>
   <div><button type="button" id="DownloadBtn" name="CreateButton" />Download Report </div>
   
   </div>
         </div>
   <script>
       document.getElementById('DownloadBtn').addEventListener('click',function() {
         var table2excel = new Table2Excel();
         table2excel.export(document.querySelectorAll("#EquipTable"));
         
       });
   </script>
   <script>
       const excel_file = document.getElementById('myfile');
       excel_file.addEventListener('change', (event) => {
           var reader = new fileReader();
           reader.readAsArrayBuffer(event.target.files[0]);
           reader.onload = function(event){
               var data = new Uint8Array(reader.result);
               var work_book = XLSX.read(data,{type:'array'});
               var sheet_name = work_book.SheetNames;
               var sheet_data = XLSX.utils.sheet_to_json(work_book.Sheets[sheet_name[0]],{header:1});
               
           }
       }
       
   </script>
   
 

</body>
</html>
