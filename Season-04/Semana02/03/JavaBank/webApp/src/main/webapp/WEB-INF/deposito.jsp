<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 28/11/2024
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Depósito - JavaBank</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <link href="https://fonts.googleapis.com/css2?family=Bokor&family=Roboto+Condensed:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <h1>JavaBank - Depósito</h1>
</header>
<div class="container d-flex justify-content-center align-items-center" style="min-height: 80vh;">
    <div class="card p-4" style="width: 350px;">
        <h4 class="text-center mb-4">Selecione a Conta e o Valor para Depositar</h4>
        <form action="menu.html">
            <div class="mb-3">
                <label for="accountId" class="form-label">ID da Conta</label>
                <input type="text" id="accountId" class="form-control" placeholder="Digite o ID da Conta" required>
            </div>
            <div class="mb-3">
                <label for="amount" class="form-label">Quantia para Depositar</label>
                <input type="number" id="amount" class="form-control" placeholder="Digite o valor" required>
            </div>
            <button type="submit" class="btn w-100">Validar Depósito</button>
        </form>
        <button class="btn btn-secondary w-100 mt-3" onclick="window.location.href='menu.html'">Voltar ao Menu</button>
    </div>
</div>
<footer>
    by João Morgado
</footer>
</body>
</html>
