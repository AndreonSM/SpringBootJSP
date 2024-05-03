<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Listagem de Pessoas</title>
</head>
<body>
    <h2>Listagem de Pessoas</h2>
    <table border="1">
        <tr>
        	<th>ID_tabela</th>
            <th>Nome</th>
            <th>Cargo</th>
            <th>Salário Consolidado</th> 
        </tr>
        <% 
            java.util.List pessoasSalarios = (java.util.List) request.getAttribute("informations");
            for (Object pessoaSalario : pessoasSalarios) {
                com.springbootjsp.model.PessoaSalarioConsolidado obj = (com.springbootjsp.model.PessoaSalarioConsolidado) pessoaSalario;
        %>
        <tr>
        	<td><%= obj.getPessoaId() %></td>
            <td><%= obj.getNomePessoa() %></td>
            <td><%= obj.getNomeCargo() != null ? obj.getNomeCargo() : "Sem cargo" %></td>
            <td><%= obj.getSalario() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
