<%-- 
    Document   : cadastrar
    Created on : 12/12/2019, 11:24:28
    Author     : Professor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro | App Usuários</title>
    </head>
    <body>
        <a href="index.jsp">Home</a>
        <h1>Cadastre um usuário</h1>
        <form method="POST" action="CadastrarServlet">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email"/>
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha"/>
            </p>
            <input type="submit" value="Cadastrar"/>
            <p>${erro}</p>
        </form>
    </body>
</html>
