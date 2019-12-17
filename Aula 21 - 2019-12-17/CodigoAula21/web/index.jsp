<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aula 21</title>
    </head>
    <body>
        <p>${usuario.email}</p>
        <p>${usuario.senha}</p>
        <hr>
        <h1>Aula 21</h1>
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
            <p>${erro}</p>
        </form>
    </body>
</html>
