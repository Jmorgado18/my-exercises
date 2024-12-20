<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 28/11/2024
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JavaBank - Login</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css" type="text/css">
  <link href="https://fonts.googleapis.com/css2?family=Bokor&family=Roboto+Condensed:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
<header>
  <h1>JavaBank</h1>
</header>
<div class="container d-flex justify-content-center align-items-center" style="min-height: 80vh;">
  <div class="card p-4" style="width: 350px;">
    <h4 class="text-center mb-4">Insira o seu ID de Cliente</h4>
    <form action="menu.jsp" method="get">
      <div class="mb-3">
        <label for="clientId" class="form-label">ID de Cliente</label>
        <input type="text" id="clientId" class="form-control" placeholder="Digite o ID">
      </div>
      <button type="submit" class="btn w-100">Entrar</button>
    </form>
  </div>
</div>
<footer>
  by João Morgado
</footer>
</body>
</html>

