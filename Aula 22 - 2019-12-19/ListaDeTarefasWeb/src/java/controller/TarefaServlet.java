package controller;

import dao.TarefaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Tarefa;
import model.Usuario;

@WebServlet(name = "TarefaServlet", urlPatterns = {"/TarefaServlet"})
public class TarefaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Usuario u = (Usuario) session.getAttribute("usuario");

        String acao = request.getParameter("acao");
        String[] ids = request.getParameterValues("ids");

        switch (acao) {
            case "finalizar": {

                for (String id : ids) {
                    int idInt = Integer.parseInt(id);
                    Tarefa t = new Tarefa();
                    t.setId(idInt);
                    t.setIdUsuario(u.getId());
                    TarefaDAO.finalizar(t);
                }

                break;
            }
            case "remover": {

                for (String id : ids) {
                    int idInt = Integer.parseInt(id);
                    Tarefa t = new Tarefa();
                    t.setId(idInt);
                    t.setIdUsuario(u.getId());
                    TarefaDAO.remover(t);
                }

                break;
            }
        }

        response.sendRedirect("HomeServlet");

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
