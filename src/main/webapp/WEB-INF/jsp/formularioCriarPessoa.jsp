<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Formulário de Criação de Pessoa</title>
</head>
<body>
    <h2>Criar Nova Pessoa</h2>
    <form action="/pessoas/criar" method="post">
        Nome: <input type="text" name="nome"><br>
        Usuário: <input type="text" name="usuario"><br>
        Email: <input type="email" name="email"><br>
        Cargo ID: <input type="number" name="cargoId"><br>
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
