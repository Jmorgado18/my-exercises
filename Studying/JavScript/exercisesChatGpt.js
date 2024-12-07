//1. Soma de Números de um Array
//Escreve uma função que recebe um array de números e retorna a soma de todos os elementos.


const array = [1, 2, 3, 4, 5];

function somaArray(array) {
    let soma = 0;
    for (let i = 0; i < array.length; i++) {
        soma += array[i];
    }
    return soma;
}

console.log(somaArray(array));
console.log("-------------------------------------")

//2. Números Pares
// Cria uma função que recebe um número e retorna um array com todos os números pares de 0 até esse número.


function numerosPares(n) {
    let pares = [];
    for (let i = 0; i <= n; i++) {
        if (i % 2 === 0) {
            pares.push(i);
        }
    }   
    return pares;       
}   

console.log(numerosPares(10));          
console.log("-------------------------------------")


//. Palíndromo
// Escreve uma função que verifica se uma palavra é um palíndromo (lê-se igual de trás para frente).

function palindromo(palavra) {
    return palavra === palavra.split("").reverse().join("");
}

console.log(palindromo("ovo"));

console.log("-------------------------------------")

//4. Fatorial
//Escreve uma função que calcula o fatorial de um número.


function fatorial(n) {
    let fatorial = 1;
    for (let i = 1; i <= n; i++) {
        fatorial *= i;
    }
    return fatorial;
}

console.log(fatorial(5));
console.log("-------------------------------------")    


//Cria uma função que conta quantas vogais existem numa string.

function contarVogais(string) {
    let vogais = "aeiouAEIOU";
    let contador = 0;
    for (let i = 0; i < string.length; i++) {
        if (vogais.includes(string[i])) {
            contador++;
        }
    }
    return contador;
}

console.log(contarVogais("Hello, World!"));         
console.log("-------------------------------------")

// 6. Maior Número
//Cria uma função que retorna o maior número de um array.

const maiorNumero = array => Math.max(...array); 

console.log(maiorNumero([1, 2, 7, 4, 5]));
console.log("-------------------------------------")


/*7. FizzBuzz
Escreve uma função que imprime números de 1 a 100 com as seguintes regras:

Substitui múltiplos de 3 por "Fizz".
Substitui múltiplos de 5 por "Buzz".
Substitui múltiplos de 3 e 5 por "FizzBuzz".*/

function fizzBuzz() {
    for (let i = 1; i <= 100; i++) {
        if (i % 3 === 0 && i % 5 === 0) {
            console.log("FizzBuzz");
        } else if (i % 3 === 0) {
            console.log("Fizz");
        } else if (i % 5 === 0) {
            console.log("Buzz");
        } else {
            console.log(i);
        }
    }
}   

fizzBuzz();     
console.log("-------------------------------------")


/*8. Reverte String
Escreve uma função que recebe uma string e retorna a mesma string invertida.*/

function reverseString(str) {
    return str.split("").reverse().join("");
}   

console.log(reverseString("Hello, World!")); 
console.log("-------------------------------------")


/*9. Ordena Números
Escreve uma função que ordena um array de números do menor para o maior.*/

function ordenarNumeros(array) {
    return array.sort(function(a, b) {
        return a - b;
    });
}

console.log(ordenarNumeros([5, 2, 8, 1, 3]));
console.log("-------------------------------------")


/*10. Converte para Maiúsculas
Cria uma função que recebe uma string e retorna a mesma string com todas as letras em maiúsculas.*/

function toUpperCase(str) {
    return str.toUpperCase();
}   

console.log(toUpperCase("hello, world!")); 
console.log("-------------------------------------")




