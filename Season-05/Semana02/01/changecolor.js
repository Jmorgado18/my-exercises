

function RandomColor() {
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
        const cor = RandomColor();
        const coluna = document.createElement("div");
        coluna.style.flex = "1"; 
        coluna.style.backgroundColor = cor;
        coluna.innerText = cor;
        coluna.style.display = "flex";    
        coluna.style.fontSize = "24px";
        coluna.style.padding = "10px";
        coluna.style.color = "white";
        coluna.style.fontWeight = "bold";
        coluna.style.textShadow = "2px 2px 4px rgba(0, 0, 0, 0.5)";
        coluna.style.boxShadow = "0 4px 8px rgba(0, 0, 0, 0.1)";
        coluna.style.justifyContent="center";
        coluna.style.alignItems="flex-end";
        
        body.appendChild(coluna);
    }
}


window.onload = criarColunas;
