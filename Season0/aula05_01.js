//Recursividade - encontrar um numero num array 

function buscarNumero(arr, numero, indice=0) {
    
    // Se o índice for igual ao comprimento do array, chegámos ao fim
    if (indice >= arr.length) {
        return false; 
    }

    // Se o número no índice atual for o procurado, retornamos true
    if (arr[indice] === numero) {
        return true; // Número encontrado
    }

    // Chamada recursiva para o próximo índice
    return buscarNumero(arr, numero, indice + 1);
}


let amostra = [3, 7, 2, 9, 4];
let numeroProcurado = 9;

if (buscarNumero(amostra, numeroProcurado)) {
    console.log(`O número ${numeroProcurado} foi encontrado no array.`);
} else {
    console.log(`O número ${numeroProcurado} não foi encontrado no array.`);
}
