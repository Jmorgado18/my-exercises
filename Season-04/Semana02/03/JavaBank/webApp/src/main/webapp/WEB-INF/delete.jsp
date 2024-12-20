<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 28/11/2024
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Apagar Conta - JavaBank</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
  <h1>JavaBank - Apagar Conta</h1>
</header>
<div class="container mt-5">
  <h4 class="text-center mb-4">Selecione a Conta para Apagar</h4>
  <div class="card p-4" style="width: 350px;">
    <form action="menu.html">
      <div class="mb-3">
        <label for="accountToDelete" class="form-label">Conta a Apagar</label>
        <select id="accountToDelete" class="form-select" required>
          <option value="conta1">Conta 1</option>
          <option value="conta2">Conta 2</option>
        </select>
      </div>
      <button type="submit" class="btn btn-danger w-100">Apagar Conta</button>
    </form>
    <button class="btn btn-secondary w-100 mt-3" onclick="window.location.href='menu.html'">Voltar ao Menu</button>
  </div>
</div>
<footer>
  by João Morgado
</footer>
</body>
</html>
