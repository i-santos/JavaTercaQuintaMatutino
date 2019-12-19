<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <script>
            function enviar(acao) {
                var inputAcao = document.getElementById("acao");
                inputAcao.value = acao;

                var form = document.getElementById("form");
                form.submit();
            }
        </script>
    </head>
    <body>
        <a href="LogoutServlet">Logout</a>
        <h1>Home</h1>
        <fieldset>
            <legend>Adicionar Tarefa</legend>
            <form method="POST" action="AdicionarTarefaServlet">
                <p>
                    <label>Título: </label>
                    <input type="text" name="titulo"/>
                </p>
                <input type="submit" value="Adicionar"/>
            </form>
        </fieldset>
        <c:if test="${usuario.tarefas.size() == 0}">
            Você ainda não tem tarefas.
        </c:if>
        <c:if test="${usuario.tarefas.size() > 0}">
            <h2>Lista de Tarefas:</h2>
            <form id="form" method="POST" action="TarefaServlet">
                <input id="acao" type="hidden" name="acao" />
                <table>
                    <thead>
                        <tr>
                            <td></td>
                            <td>Tarefa</td>
                            <!--<td>Finalizada</td>-->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${usuario.tarefas}" var="t">

                            <c:if test="${!t.finalizada}">
                                <tr>
                                    <td><input type="checkbox" name="ids" value="${t.id}"/></td>
                                    <td>${t.titulo}</td>
<!--                                    <td>
                                        <c:if test="${t.finalizada}">
                                            Sim
                                        </c:if>
                                        <c:if test="${!t.finalizada}">
                                            Não
                                        </c:if>
                                    </td>-->
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
                <button onclick="enviar('finalizar');">Finalizar</button>
                <button onclick="enviar('remover');">Remover</button>
            </form>
        </c:if>
    </body>
</html>
