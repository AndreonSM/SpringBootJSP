<%@ page import="java.util.List" %>
<%@ page import="com.springbootjsp.model.Vencimentos" %>

<%
    List<Vencimentos> vencimentos = (List<Vencimentos>) request.getAttribute("vencimentos");
%>

<h1>Lista de Vencimentos</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Descricao</th>
            <th>Valor</th>
            <th>Tipo</th>
        </tr>
    </thead>
    <tbody>
        <% for (Vencimentos vencimento : vencimentos) { %>
            <tr>
                <td><%= vencimento.getId() %></td>
                <td><%= vencimento.getDescricao() %></td>
                <td><%= vencimento.getValor() %></td>
                <td><%= vencimento.getTipo() %></td>
            </tr>
        <% } %>
    </tbody>
</table>
