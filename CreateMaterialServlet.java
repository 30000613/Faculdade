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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(name = "CreateMaterialServlet", urlPatterns = {"/CreateMaterialServlet"})
public class CreateMaterialServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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
        processRequest(request, response);
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
        processRequest(request, response);
        

          String nome = request.getParameter("EquipName");
         String descricao = request.getParameter("EquipDescrip");
         String codigo = request.getParameter("EquipCode");
         int TipoID= Integer.parseInt(request.getParameter("EquipType"));
         int UnidadeID= Integer.parseInt(request.getParameter("EquipUnit"));
         int SubUnidadeId= Integer.parseInt(request.getParameter("EquipSubUnit"));
         
         String urlHomePage = request.getHeader("Referer");
         
         SqlOperations operations = new SqlOperations();
         Instruments instrument = new Instruments();
         int MaterialId =0;
     
           
      
        
        try {
            processRequest(request, response);
            
           
            
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");
            Statement st = con.createStatement();
            
            String[] returnId = { "EQUIPAMENTO_ID" };
            String Create_Insert =" INSERT INTO EQUIPAMENTOS(NOME, DESCRICAO, DATA_REGISTO, TIPO, CODIGO) VALUES ('"+nome.trim()+"', '"+descricao.trim()+"', '"+instrument.CurrentDate()+"',"+TipoID+",'"+codigo+"')" ;
            PreparedStatement statement = con.prepareStatement(Create_Insert,returnId);
            statement.executeUpdate();
            
            
            ResultSet rs = statement.getGeneratedKeys();
  
            if (rs.next()) {
               MaterialId = rs.getInt(1);
                }

             String CreateUnion ="Insert into EQUIPAMENTOS_UNIDADES(UNIDADE_FK,SUBUNI_FK,EQUIPAMENTO_FK) values ("+UnidadeID+","+SubUnidadeId+","+MaterialId+")";
             st.executeUpdate(CreateUnion);
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(DetailScreenOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
         
             response.setContentType("text/html");
     response.setStatus(response.SC_MOVED_TEMPORARILY); 
        response.setHeader("Location", urlHomePage);     
     request.getRequestDispatcher("DetailScreen.jsp?EquipId="+MaterialId).forward(request, response);
         
        
   
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
