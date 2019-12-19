<%-- 
    Document   : index
    Created on : 19/12/2019, 09:39:38
    Author     : Professor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Tarefas</title>
    </head>
    <body>
        <h1>Lista de Tarefas</h1>
        <form method="POST" action="LoginServlet">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email"/>
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha"/>
            </p>
            <input type="submit" value="Entrar"/>
        </form>
        <p>
            <a href="cadastro.jsp">Fazer cadastro</a>
        </p>
    </body>
</html>
