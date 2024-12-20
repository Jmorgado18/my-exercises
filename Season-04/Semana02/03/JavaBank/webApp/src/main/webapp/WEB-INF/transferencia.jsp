<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 28/11/2024
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transferências - JavaBank</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <link href="https://fonts.googleapis.com/css2?family=Bokor&family=Roboto+Condensed:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <h1>JavaBank - Transferências</h1>
</header>
<div class="container d-flex justify-content-center align-items-center" style="min-height: 80vh;">
    <div class="card p-4" style="width: 350px;">
        <h4 class="text-center mb-4">Selecione a Transferência</h4>
        <form action="menu.html">
            <div class="mb-3">
                <label class="form-label">Tipo de Transferência</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="transferType" id="sameClient" checked>
                    <label class="form-check-label" for="sameClient">Entre as Minhas Contas</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="transferType" id="otherClient">
                    <label class="form-check-label" for="otherClient">Para Outro Cliente</label>
                </div>
            </div>

            <div class="mb-3">
                <label for="accountFrom" id="accountFromLabel" class="form-label">Conta de Origem</label>
                <input type="text" id="accountFrom" class="form-control" placeholder="Digite o ID da Conta de Origem" required>
            </div>

            <div class="mb-3">
                <label for="accountTo" class="form-label">Conta de Destino</label>
                <input type="text" id="accountTo" class="form-control" placeholder="Digite o ID da Conta de Destino" required>
            </div>

            <div class="mb-3" id="clientIdGroup" style="display: none;">
                <label for="clientId" class="form-label">ID do Cliente Destinatário</label>
                <input type="text" id="clientId" class="form-control" placeholder="Digite o ID do Cliente" required>
            </div>

            <div class="mb-3">
                <label for="amount" class="form-label">Quantia a Transferir</label>
                <input type="number" id="amount" class="form-control" placeholder="Digite o valor" required>
            </div>

            <button type="submit" class="btn w-100">Validar Transferência</button>
        </form>
        <button class="btn btn-secondary w-100 mt-3" onclick="window.location.href='menu.html'">Voltar ao Menu</button>
    </div>
</div>
<footer>
    by João Morgado
</footer>

<script>
    // Script para alternância de campos (opcional)
    const sameClientRadio = document.querySelector('#sameClient');
    const otherClientRadio = document.querySelector('#otherClient');
    const clientIdGroup = document.querySelector('#clientIdGroup');

    sameClientRadio.addEventListener('change', () => {
        clientIdGroup.style.display = 'none';
    });

    otherClientRadio.addEventListener('change', () => {
        clientIdGroup.style.display = 'block';
    });
</script>
</body>
</html>
