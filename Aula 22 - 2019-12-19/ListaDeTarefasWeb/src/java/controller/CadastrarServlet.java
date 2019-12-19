package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name="CadastrarServlet", urlPatterns={"/CadastrarServlet"})
public class CadastrarServlet extends HttpServlet { 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Usuario u = UsuarioDAO.buscarPorEmail(email);
        
        if(u != null) {
            request.setAttribute("erro", "Email já cadastrado. Tente outro email");
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        } else {
            u = new Usuario();
            u.setEmail(email);
            u.setSenha(senha);
            
            boolean cadastrado = UsuarioDAO.inserir(u);
            
            if (cadastrado) {
                request.getRequestDispatcher("cadastroSucesso.jsp").forward(request, response);
            } else {
                request.setAttribute("erro", "Algo deu errado ao cadastrar. Tente novamente");
                request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            }
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
