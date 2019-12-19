<%-- 
    Document   : cadastrar
    Created on : 19/12/2019, 10:51:08
    Author     : Professor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro | Lista de Tarefas</title>
    </head>
    <body>
        <h1>Faça o cadastro</h1>
        <form method="POST" action="CadastrarServlet">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email" />
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha" />
            </p>
            <input type="submit" value="Cadastrar"/>
            <p>${erro}</p>
        </form>
        <p>
            <a href="index.jsp">Fazer login</a>
        </p>
    </body>
</html>
