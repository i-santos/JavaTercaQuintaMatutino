package controller;

import dao.TarefaDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Tarefa;
import model.Usuario;

@WebServlet(name="HomeServlet", urlPatterns={"/HomeServlet"})
public class HomeServlet extends HttpServlet { 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Usuario u = (Usuario) session.getAttribute("usuario");
        
        ArrayList<Tarefa> tarefas = TarefaDAO.buscarTarefasDoUsuario(u);
        u.setTarefas(tarefas);
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
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
