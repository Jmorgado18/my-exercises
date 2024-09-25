// Criar um número aleatório de 1 a 100
let nrRandom = Math.floor(Math.random() * 20) + 1; 
console.log(nrRandom);

// Criar um array com comprimento 100 e valores de 1 a 100
let amostra=[];
for ( i=0 ; i<100 ; i++){
    let valor = (Math.floor(Math.random()*100));
//console.log(valor);
amostra.push(valor);
}
console.log(amostra);

// Variável para armazenar as posições inicial e final
let start = 0;
let end = amostra.length - 1;
let encontra = false;

// procurar o numero 
while (start <= end) {
    let metade = Math.floor((start + end) / 2);

    if (amostra[metade] === nrRandom) {
        console.log(`O número ${nrRandom} está na posição ${metade + 1} do array.`);
        encontra = true;
        break;

    } else if (amostra[metade] < nrRandom) {
        
        start = metade + 1; // Descarta a metade inferior e define o novo start

    } else {
        
        end = metade - 1; // Descarta a metade superior
    }
}

// Mensagem final se o número não foi encontrado
if (encontra===false) {
    console.log(`O número ${nrRandom} não se encontra no array.`);
}
