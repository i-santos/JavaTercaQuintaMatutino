package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name="AtualizarServlet", urlPatterns={"/atualizar"})
public class AtualizarServlet extends HttpServlet { 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Usuario u = new Usuario();
        u.setId(id);
        u.setEmail(email);
        u.setSenha(senha);
        request.setAttribute("usuario", u);
        
        boolean atualizado = UsuarioDAO.atualizarUsuario(u);
        
        if (atualizado) {
            request.setAttribute("msg", "Dados atualizados com sucesso");
            request.getRequestDispatcher("perfil.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "Erro ao atualizar dados. Tente novamente");
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
