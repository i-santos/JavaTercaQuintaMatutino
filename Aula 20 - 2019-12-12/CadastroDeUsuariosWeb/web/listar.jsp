<%-- 
    Document   : listar
    Created on : 12/12/2019, 12:14:05
    Author     : Professor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar | App Usuários</title>
    </head>
    <body>
        <a href="index.jsp">Home</a>
        <h1>Usuários Cadastrados</h1>
        <table>
            <tr>
                <td>ID</td>
                <td>Email</td>
                <td>Senha</td>
            </tr>

            <c:forEach items="${listaUsuarios}" var="u">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.email}</td>
                    <td>${u.senha}</td>
                </tr>
            </c:forEach>


        </table>
    </body>
</html>
