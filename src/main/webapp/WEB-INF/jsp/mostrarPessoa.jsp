<%@ page import="com.springbootjsp.model.Pessoa" %>
<%@ page import="java.util.List" %>
<%@ page import="com.springbootjsp.model.Cargo" %>

<%
    Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
    String cargo = (String) request.getAttribute("cargo");
%>

<h1>Detalhes da Pessoa</h1>
<table>
    <tbody>
        <tr>
            <td>ID:</td>
            <td><%= pessoa.getId() %></td>
        </tr>
        <tr>
            <td>Nome:</td>
            <td><%= pessoa.getNome() %></td>
        </tr>
        <tr>
            <td>Cargo-ID:</td>
            <td><%= pessoa.getCargoId() %></td>
        </tr>
        <tr>
            <td>Cargo:</td>
            <td><%= cargo %></td>
        </tr>
        <tr>
            <td>Salario Consolidado:</td>
            <td>${salarioConsolidado}</td>
        </tr>
    </tbody>
</table>
<!-- Botão para acionar a atualização de salários consolidados -->
<form action="/salarios/atualizar-consolidados" method="post">
    <button type="submit">Atualizar Salários Consolidados</button>
</form>
