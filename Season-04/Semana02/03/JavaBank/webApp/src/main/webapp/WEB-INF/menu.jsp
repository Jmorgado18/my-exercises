<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 28/11/2024
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JavaBank - Menu</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
  <h1>JavaBank</h1>
</header>
<div class="container mt-5">
  <h4 class="text-center mb-4">Bem-vindo ao JavaBank</h4>
  <div class="card p-4">
    <h5 class="mb-3">Suas Contas</h5>
    <ul>
      <li>Conta 1 - Saldo: €1000</li>
      <li>Conta 2 - Saldo: €500</li>
    </ul>
    <div class="d-flex justify-content-between mt-4">
      <a href="levantamento.html" class="btn">Levantamento</a>
      <a href="deposito.html" class="btn">Depósito</a>
      <a href="transferencia.html" class="btn">Transferência</a>
      <a href="delete.html" class="btn btn-danger">Apagar Conta</a>
    </div>
  </div>
</div>
<footer>
  by João Morgado
</footer>
</body>
</html>
