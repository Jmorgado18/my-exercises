
let amostra=[];
for ( i=0 ; i<101 ; i++){
    let valor = (Math.floor(Math.random()*100));
//console.log(valor);
amostra.push(valor);
}
console.log("Array desordenado:", amostra);

/*
Início do insertion sort: 
Começamos um loop for a partir do índice 1 
porque o indice 0 nao vai compara, ja é o mais pequeno
key armazena o valor atual que estamos a inserir, e 
j é inicializado como o índice do elemento anterior.
*/

for (let i = 1; i < amostra.length; i++) {
    let key = amostra[i]; // O elemento atual a ser comparado
    let j = i - 1;

    // Mover os elementos que são maiores que o key
    while (j >= 0 && amostra[j] > key) {
        amostra[j + 1] = amostra[j]; // Mover o elemento uma posição à frente
        j--;
    }

    amostra[j + 1] = key; // Inserir o key na posição correta
}

console.log("Array ordenado:", amostra);


