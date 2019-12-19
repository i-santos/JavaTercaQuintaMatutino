<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <a href="LogoutServlet">Logout</a>
        <h1>Home</h1>
        <p>Id: ${usuario.id}</p>
        <p>Email: ${usuario.email}</p>
        <p>Senha: ${usuario.senha}</p>
        <form method="POST" action="AdicionarTarefaServlet">
            <p>
                <label>Título: </label>
                <input type="text" name="titulo"/>
            </p>
            <input type="submit" value="Adicionar"/>
        </form>
        <h2>Tarefa:</h2>
        <p>${titulo}</p>
    </body>
</html>
