<%-- 
    Document   : usuarios
    Created on : 10/12/2019, 10:01:08
    Author     : Professor
--%>

<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar | App Usuários</title>
    </head>
    <body>
        <a href="index.jsp">Home</a>
        <h1>Usuários cadastrados!</h1>
        
        <table>
            <tr>
                <td>ID</td>
                <td>Email</td>
                <td>Senha</td>
            </tr>
            <% for(Usuario u : usuarios) { %>
                
            <tr>
                <td><%= u.getId() %></td>
                <td><%= u.getEmail() %></td>
                <td><%= u.getSenha() %></td>
            </tr>
            
            <% } %>
        </table>
    </body>
</html>
