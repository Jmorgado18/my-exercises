let num=[4,7,8,9,2];

console.log (`O nosso array é composto por ${num}`)
num.push(99); // Adiciona um elemento ao array para a ultima posiçao do mesmo
console.log (`O nosso array é composto por ${num}`)
num.pop(); //Apaga o ultimo elemento do nosso array
console.log (`O nosso array é composto por ${num}`)
let cumprimento=num.length; // Dá-nos o cumprimento do array e guarda numa nova variavavel
console.log (cumprimento);
num.sort(); // Ordena do mais pequeno para o maior
console.log (`O nosso array é composto por ${num}`)

for (i=0;i=cumprimento;i++){
    console.log(num[i]);

}