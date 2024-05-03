<%@ page import="com.springbootjsp.model.Pessoa" %>
<%@ page import="java.util.List" %>

<h1>Lista de Pessoas</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Cargo-Id</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="pessoa" items="${pessoas}">
            <tr>
                <td>${pessoa.id}</td>
                <td>${pessoa.nome}</td>
                <td>${pessoa.cargoId}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
