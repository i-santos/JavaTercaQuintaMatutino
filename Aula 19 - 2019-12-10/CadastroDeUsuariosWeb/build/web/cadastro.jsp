<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro | App Usuários</title>
    </head>
    <body>
        <a href="index.jsp">Voltar</a>
        <h1>Faça seu cadastro!</h1>
        <form method="POST" action="CadastrarServlet">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email" />
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha" />
            </p>
            <input type="submit" value="Cadastrar" />
            <p>${erro}</p>
        </form>
    </body>
</html>
