/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Org.Scouts.backend;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Orgs.Scouts.Actions.*;

/**
 *
 * @author Utilizador
 */
@WebServlet(name = "EquipmentListOpeartions", urlPatterns = {"/EquipmentListOpeartions"})
public class EquipmentListOpeartions extends HttpServlet {

boolean DeleteResult;  
SqlOperations operations = new SqlOperations();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    String urlHomePage = request.getHeader("Referer");      
        response.setContentType("text/html;charset=UTF-8");
     if (DeleteResult = true){   
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<script type=\"text/javascript\">");
    out.println("var popwin = window.open(\"SucessPopUp.jsp\")");
    out.println("</script>");
    out.println("</body></html>");
     }
     else{
         
          PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<script type=\"text/javascript\">");
    out.println("var popwin = window.open(\"SucessPopUp.jsp\")");
    out.println("</script>");
    out.println("</body></html>");
     }
     
     
      response.setStatus(response.SC_MOVED_TEMPORARILY); 
      response.setHeader("Location", urlHomePage);     
     request.getRequestDispatcher("EquipmentList.jsp").forward(request, response);
     
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
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
        
     
     String action = request.getParameter("action");
    if ("DeleteAllBtn".equals(action)) {
       DeleteResult = operations.DeleteAllEquipments();
         processRequest(request, response);
        
    } else if ("SecondServlet".equals(action)) {
        // Invoke SecondServlet's job here.
    }
        
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
