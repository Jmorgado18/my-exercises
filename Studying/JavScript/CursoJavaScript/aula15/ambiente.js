let num=[4,7,8,9,2];

console.log (`O nosso array é composto por ${num}`)
num.push(99); // Adiciona um elemento ao array para a ultima posiçao do mesmo
console.log (`O nosso array é composto por ${num}`)
num.pop(); //Apaga o ultimo elemento do nosso array
console.log (`O nosso array é composto por ${num}`)
let cumprimento=num.length; // Dá-nos o cumprimento do array e guarda numa nova variavavel
console.log (`O cumprimento do nosso array é ${cumprimento}`);
num.sort(); // Ordena do mais pequeno para o maior
console.log (`O nosso array é composto por ${num}`)
//Percorrer o cumprimento do array e mostrar os valores que lá contém.
for (i=0 ; i<cumprimento;  i++  ){
    console.log(`Na posição ${i} está o valor ${num[i]}`);
}
//Ciclo for mais simplificado
for (z in num){
    console.log (`Na posição ${z} temos o valor ${num[z]}`);
}

// Procurar um valor dentro do array
console.log(`O valor 9 está na posição ${num.indexOf(9)}`); 

// Caso tentarmos procurar um valor que não esteja guardado no array, o Javascript retorna o valor -1

let valorAProcurar = 99; 
let procura = num.indexOf(valorAProcurar); //Procura recebe o valor -1
if (procura === -1){
  console.log (`O número ${valorAProcurar} não foi encontrado`);
}
