<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Abra uma conta</h1>
        <form method="POST" action="cadastrar">
            <p>
                <label>E-mail:</label>
                <input type="email" name="email"/>
            </p>
            <p>
                <label>Senha:</label>
                <input type="password" name="senha"/>
            </p>
            <input type="submit" value="Cadastrar"/>
            <p>${erro}</p>
        </form>

        <p>Já possui uma conta? <a href="login.jsp">Faça o login</a></p>
    </body>
</html>
