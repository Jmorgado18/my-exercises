
//Criar um nr rando de 1 a 100
let nrRandom = Math.floor(Math.random() * 100);
console.log(nrRandom);
//Crio um array com o cumprimeto 100 e atribuo 100 valores aleatorios
//let amostra = Array.from({ length: 100 }, () => Math.floor(Math.random() * 100)); 
let amostra=[];
for ( i=0 ; i<101 ; i++){
    let valor = (Math.floor(Math.random()*100));
//console.log(valor);
amostra.push(valor);
}
console.log(amostra);
//Variavel para encontrar o nr random 
let encontra = false;
// console.log(amostra);

for (let i = 0; i < amostra.length; i++) {
    if (nrRandom === amostra[i]) {
        console.log(`O número ${nrRandom} encontra-se na posição ${i + 1} do array`);
        encontra = true;
       // break; - tirei o break para o caso de haver mais que um numero igual  
    }
}

if (encontra===false) {
    console.log(`O número ${nrRandom} não se encontra no array.`);
}
