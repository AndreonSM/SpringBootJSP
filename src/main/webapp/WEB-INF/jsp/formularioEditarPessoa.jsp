<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Formulário de Edição de Pessoa</title>
</head>
<body>
    <h2>Editar Pessoa</h2>
    <form action="/pessoas/editar/${pessoa.id}" method="post">
        Nome: <input type="text" name="nome" value="${pessoa.nome}"><br>
        Usuário: <input type="text" name="usuario" value="${pessoa.usuario}"><br>
        Email: <input type="email" name="email" value="${pessoa.email}"><br>
        Cargo ID: <input type="number" name="cargoId" value="${pessoa.cargoId}"><br>
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
