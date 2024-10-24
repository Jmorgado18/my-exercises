/* CHECK <p>Ao listar os primeiros seis números primos: 2, 3, 5, 7, 11 e 13, podemos ver que o 6.º primo é 13.</p>
<p>Qual é o 10.001.º número primo?</p>
*/

let count = 0; // Contador de números primos encontrados
let num = 1;   // Número a verificar, começamos a partir de 1

// Continuamos a procurar até encontrarmos o 10.001.º primo
while (count < 10001) {
    num++; // Passamos para o próximo número

    let isPrime = true; 

    /* Um número é considerado primo se ele tiver exatamente dois divisores: 1 e ele próprio. 
    Portanto,se puder ser dividido por qualquer número entre 2 e num - 1, então não é primo.*/

    for (let i = 2; i < num; i++) { 
        
        if (num % i === 0) {
            isPrime = false; // Mudamos a suposição, não é primo
            break; // Saímos do loop, pois já sabemos que não é primo
        }
    }

    // Se o número for primo, incrementamos o contador
    if (isPrime) {
        count++; // Contamos este número primo
    }
}

console.log("O 10.001.º número primo é:", num);
