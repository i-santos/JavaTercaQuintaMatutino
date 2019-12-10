<%-- 
    Document   : remove
    Created on : 10/12/2019, 11:22:52
    Author     : Professor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover | App Usuários</title>
    </head>
    <body>
        <a href="index.jsp">Home</a>
        <h1>Remover um usuário</h1>
        <form method="POST" action="RemoverServlet">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email" />
            </p>
            <input type="submit" value="Remover" />
            <p>${msg}</p>
        </form>
    </body>
</html>
