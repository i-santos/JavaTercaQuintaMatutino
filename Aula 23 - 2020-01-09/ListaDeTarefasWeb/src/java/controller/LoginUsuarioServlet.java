package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

@WebServlet(name = "LoginUsuarioServlet", urlPatterns = {"/login"})
public class LoginUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario u = UsuarioDAO.buscarUsuarioPorEmail(email);

        if (u != null && u.getSenha().equals(senha)) {

            HttpSession session = request.getSession();

            session.setAttribute("usuarioLogado", u);
            response.sendRedirect("home");

        } else {

            request.setAttribute("erro", "E-mail/senha inválidos");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);

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
