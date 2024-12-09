

function gerarCorAleatoria() {
    const letras = "0123456789ABCDEF";
    let cor = "#";
    for (let i = 0; i < 6; i++) {
        cor += letras[Math.floor(Math.random() * 16)];
    }
    return cor;
}


function criarColunas() {
    const body = document.body;
    body.style.display = "flex"; 
    body.style.margin = "0"; 
    body.style.height = "100vh"; 

    for (let i = 0; i < 5; i++) {
        const cor = gerarCorAleatoria();
        const coluna = document.createElement("div");
        coluna.style.flex = "1"; 
        coluna.style.backgroundColor = cor;
        body.appendChild(coluna);
    }
}

// Executa a função ao carregar a página
window.onload = criarColunas;
