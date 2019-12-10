package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "RemoverServlet", urlPatterns = {"/RemoverServlet"})
public class RemoverServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Pegar dados que vieram no request
        String email = request.getParameter("email");

        // Procurar se usuário com esse email existe
        Usuario u = UsuarioDAO.procurarUsuarioPorEmail(email);

        if (u == null) {
            request.setAttribute("msg", "E-mail não está cadastrado");
            request.getRequestDispatcher("remove.jsp").forward(request, response);
        } else {
            boolean removido = UsuarioDAO.removerUsuario(u);

            if (removido) {
                request.setAttribute("msg", "Usuário removido com sucesso");
                request.getRequestDispatcher("remove.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Não foi possível remover. Tente novamente.");
                request.getRequestDispatcher("remove.jsp").forward(request, response);
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
