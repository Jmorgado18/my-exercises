/*
Cada novo termo na sequência de Fibonacci é gerado pela soma dos dois termos anteriores. 
Começando com 1 e 2, os primeiros 10 termos serão:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89.

Ao considerar os termos da sequência de Fibonacci cujos valores não excedem quatro milhões,
 encontre a soma dos termos com valores pares.

*/
let primeiroTermo = 1; // Primeiro termo da sequência
let segundoTermo = 2;  // Segundo termo da sequência
let somaPares = 0;     // Variável para armazenar a soma dos termos pares

// Enquanto o segundo termo não exceder quatro milhões
while (segundoTermo <= 4000000) {
    // Verifica se o segundo termo é par
    if (segundoTermo % 2 === 0) {
        somaPares += segundoTermo; // Adiciona o termo par à soma
    }
    
    // Gera o próximo termo da sequência
    let proximoTermo = primeiroTermo + segundoTermo; // Próximo termo
    primeiroTermo = segundoTermo; // Atualiza o primeiro termo
    segundoTermo = proximoTermo;   // Atualiza o segundo termo
}

// Imprime a soma dos termos pares
console.log("A soma dos termos pares da sequência de Fibonacci que não excedem quatro milhões é:", somaPares);
