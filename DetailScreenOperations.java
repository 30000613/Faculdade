/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Org.Scouts.backend;

import Orgs.Scouts.Actions.SqlOperations;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Utilizador
 */
@WebServlet(name = "DetailScreenOperations", urlPatterns = {"/DetailScreenOperations"})
public class DetailScreenOperations extends HttpServlet {

     SqlOperations operations = new SqlOperations();
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, int MaterialId, String action)
            throws ServletException, IOException {
        
      
    
       
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, 0, "");
     
      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
       String nome = request.getParameter("EquipName");
         String descricao = request.getParameter("EquipDescrip");
         String codigo = request.getParameter("EquipCode");
         int TipoID= Integer.parseInt(request.getParameter("EquipType"));
         int UnidadeID= Integer.parseInt(request.getParameter("EquipUnit"));
         int SubUnidadeId= Integer.parseInt(request.getParameter("EquipSubUnit"));
            
         
         
         String urlHomePage = request.getHeader("Referer");
         int MaterialId = operations.getMaterialId_FromUrl(urlHomePage);
     
    String action = request.getParameter("button");
         
         
    if ("UpdateBtn".equals(action)) {
     try {
            
            
           
            
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");
            Statement st = con.createStatement();
            
            String Update_Equip ="Update EQUIPAMENTOS\n" +
                    "set EQUIPAMENTOS.NOME = '"+nome+"', EQUIPAMENTOS.DESCRICAO ='"+descricao+"',EQUIPAMENTOS.CODIGO = '"+codigo+"', EQUIPAMENTOS.TIPO = "+TipoID+" \n" +
                    "where EQUIPAMENTOS.EQUIPAMENTO_ID = "+MaterialId+" ";;
                    st.executeUpdate(Update_Equip);
                   
            if(operations.EquipmentUnionExists(MaterialId) == true){   
                
            String Update_Union ="Update ADMINA.EQUIPAMENTOS_UNIDADES\n" +
                          "set EQUIPAMENTOS_UNIDADES.UNIDADE_FK = "+UnidadeID+", EQUIPAMENTOS_UNIDADES.SUBUNI_FK = "+SubUnidadeId+"    \n" +
                          "where EQUIPAMENTOS_UNIDADES.EQUIPAMENTO_FK = "+MaterialId+" ";
                             st.executeUpdate(Update_Union);
                            con.close();
            }else{
                String CreateUnion ="Insert into EQUIPAMENTOS_UNIDADES(UNIDADE_FK,SUBUNI_FK,EQUIPAMENTO_FK) values ("+UnidadeID+","+SubUnidadeId+","+MaterialId+")";
                st.executeUpdate(CreateUnion);
            }
 
     response.setContentType("text/html");
     response.setStatus(response.SC_MOVED_TEMPORARILY); 
     response.setHeader("Location", urlHomePage);     
     request.getRequestDispatcher("DetailScreen.jsp?EquipId="+MaterialId).forward(request, response);
               
                    
       //processRequest(request, response, MaterialId, action);            
        } catch (SQLException ex) {
            Logger.getLogger(DetailScreenOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else if ("DeleteBtn".equals(action)) {
        try {
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");
            Statement st = con.createStatement();
            String query ="Delete from ADMINA.EQUIPAMENTOS where \"EQUIPAMENTO_ID\" = "+MaterialId; 
             st.executeUpdate(query); 
            response.sendRedirect("EquipmentList.jsp");
        } catch (Exception e) {
        }
    }
    
    }

    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
