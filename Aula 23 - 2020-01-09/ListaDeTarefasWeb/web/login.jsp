<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Faça o login!</h1>
        <form method="POST" action="login">
            <p>
                <label>E-mail:</label>
                <input type="email" name="email" />
            </p>
            <p>
                <label>Senha:</label>
                <input type="password" name="senha" />
            </p>
            <input type="submit" value="Entrar" />
            <p>${erro}</p>
        </form>
    </body>
</html>
