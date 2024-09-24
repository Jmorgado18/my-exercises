function ehPalindromo(palavra) {
    // Normaliza a palavra (opcional, para ignorar maiúsculas/minúsculas e espaços)
    palavra = palavra.replace(/\s+/g, '').toLowerCase(); //REGEX 

    // Função auxiliar recursiva
    function verificaPalindromo(inicio, fim) {
        // Se o início for maior ou igual ao fim, a palavra é um palíndromo - só chega aqui depois de verificar a palavra toda
        if (inicio >= fim) {
            return true;
        }

        // Se os caracteres nas posições 'inicio' e 'fim' não forem iguais
        if (palavra[inicio] !== palavra[fim]) {
            return false; // Não é um palíndromo
        }

        // Chamada recursiva para os próximos caracteres
        return verificaPalindromo(inicio + 1, fim - 1);
    }

    // Chama a função auxiliar com os índices inicial e final
    return verificaPalindromo(0, palavra.length - 1); // Atributos 0 para inicio e o lenght -1 para o final da palavra
}

// Exemplo de uso
let palavra1 = "arara";
let palavra2 = "banana";

console.log(`${palavra1} é um palíndromo? ${ehPalindromo(palavra1)}`);
console.log(`${palavra2} é um palíndromo? ${ehPalindromo(palavra2)}`);

