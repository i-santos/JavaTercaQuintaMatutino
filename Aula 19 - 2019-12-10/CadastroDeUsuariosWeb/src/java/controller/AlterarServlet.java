package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "AlterarServlet", urlPatterns = {"/AlterarServlet"})
public class AlterarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Pegar dados que vieram na request
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Instanciar usuario com os dados
        Usuario u = new Usuario();
        u.setId(id);
        u.setEmail(email);
        u.setSenha(senha);

        // Atualizar no banco de dados
        boolean atualizado = UsuarioDAO.atualizarUsuario(u);

        // Verificar se atualizou
        if (atualizado) {
            // Colocar usuário com novos dados no request
            request.setAttribute("usuario", u);
            // Colocar uma mensagem no request para apresentar na página
            request.setAttribute("msg", "Dados salvos com sucesso!");
            // Encaminhar request para 'perfil.jsp'
            request.getRequestDispatcher("perfil.jsp").forward(request, response);
        } else {
            // Buscar usuário para pegar dados antigos
            u = UsuarioDAO.procurarUsuarioPorId(id);
            // Colocar usuário com dados antigos na request
            request.setAttribute("usuario", u);
            // Colocar uma mensagem de erro para aprensetar na página
            request.setAttribute("msg", "Não foi possível atualizar os dados. Tente novamente");
            // Encaminhar request para 'perfil.jsp'
            request.getRequestDispatcher("perfil.jsp").forward(request, response);
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
