package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name="CadastrarUsuarioServlet", urlPatterns={"/cadastrar"})
public class CadastrarUsuarioServlet extends HttpServlet { 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
 
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setSenha(senha);
        
        boolean cadastrado = UsuarioDAO.cadastrarUsuario(u);
        
        if (cadastrado) {
            
            RequestDispatcher rd = request.getRequestDispatcher("cadastroSucesso.jsp");
            rd.forward(request, response);
            
        } else {
            
            request.setAttribute("erro", "Erro ao cadastrar. Tente novamente");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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
