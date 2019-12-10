<%-- 
    Document   : perfil
    Created on : 10/12/2019, 11:00:53
    Author     : Professor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil | App Usuários</title>
    </head>
    <body>
        <a href="index.jsp">Home</a>
        <h1>Perfil</h1>
        <form method="POST" action="AlterarServlet">
            <input type="hidden" name="id" value="${usuario.id}"/>
            <p>
                <label>E-mail: </label>
                <input type="email" name="email" value="${usuario.email}"/>
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha" value="${usuario.senha}"/>
            </p>
            <input type="submit" value="Salvar" />
            <p>${msg}</p>
        </form>
    </body>
</html>
