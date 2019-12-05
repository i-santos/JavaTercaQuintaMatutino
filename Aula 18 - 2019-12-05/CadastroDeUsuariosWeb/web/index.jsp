<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String titulo = "App Usuários";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><% out.print(titulo); %></h1>
        <a href="cadastro.jsp">Cadastrar novo usuário</a>
        <a href="usuarios.jsp">Listar usuários cadastrados</a>
        <a href="procura.jsp">Procurar um usuário</a>
        <a href="remove.jsp">Remover um usuário</a>
        
    </body>
</html>
