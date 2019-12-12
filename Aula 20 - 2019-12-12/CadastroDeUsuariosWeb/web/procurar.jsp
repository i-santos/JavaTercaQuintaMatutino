<%-- 
    Document   : procurar
    Created on : 12/12/2019, 12:33:51
    Author     : Professor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procurar | App Usuários</title>
    </head>
    <body>
        <a href="index.jsp">Home</a>
        <h1>Procure um usuário</h1>
        <form method="POST" action="procurar">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email"/>
            </p>
            <input type="submit" value="Procurar"/>
            <p>${erro}</p>
        </form>
    </body>
</html>
