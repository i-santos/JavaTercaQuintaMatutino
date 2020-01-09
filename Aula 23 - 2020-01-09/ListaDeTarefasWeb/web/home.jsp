<%-- 
    Document   : home
    Created on : 09/01/2020, 12:42:10
    Author     : Professor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home</h1>
        <fieldset>
            <legend>Adicionar Tarefa</legend>
            <form method="POST" action="adicionar">
                <p>
                    <label>Título: </label>
                    <input type="text" name="titulo" />
                </p>
                <input type="submit" value="Adicionar"/>
            </form>
        </fieldset>
        <hr>
        <h2>Suas Tarefas: </h2>
        <form method="POST" action="processar">
            <table>
                <thead>
                    <tr>
                        <td></td>
                        <td>Título</td>
                        <td>Finalizada</td>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${usuarioLogado.tarefas}" var="t">
                        <tr>
                            <td><input type="checkbox" name="tarefas" value="${t.id}"/></td>
                            <td>${t.titulo}</td>
                            <td>${t.finalizada}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <select name="acao">
                <option value="finalizar" selected>Finalizar</option>
                <option value="excluir">Excluir</option>
            </select>
            <input type="submit" value="Executar" />
        </form>
    </body>
</html>
