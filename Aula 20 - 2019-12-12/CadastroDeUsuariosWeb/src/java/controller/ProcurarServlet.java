package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name="ProcurarServlet", urlPatterns={"/procurar"})
public class ProcurarServlet extends HttpServlet { 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String email = request.getParameter("email");
        
        Usuario u = UsuarioDAO.procurarUsuario(email);
        
        if (u == null) {
            request.setAttribute("erro", "Email não cadastrado");
            request.getRequestDispatcher("procurar.jsp").forward(request, response);
        } else {
            request.setAttribute("usuario", u);
            request.getRequestDispatcher("perfil.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
