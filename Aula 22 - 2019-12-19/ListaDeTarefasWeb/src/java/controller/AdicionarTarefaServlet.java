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

@WebServlet(name="AdicionarTarefaServlet", urlPatterns={"/AdicionarTarefaServlet"})
public class AdicionarTarefaServlet extends HttpServlet { 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        
        String titulo = request.getParameter("titulo");
        
        Tarefa t = new Tarefa();
        t.setTitulo(titulo);
        t.setFinalizada(false);
        t.setIdUsuario(u.getId());
        
        boolean inserida = TarefaDAO.inserir(t);
        String msg = "";
        if (inserida) {
            msg = "Inserida com sucesso";
        } else {
            msg = "Erro ao inserir tarefa. Tente novamente";
        }
        
        response.sendRedirect("HomeServlet");
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
