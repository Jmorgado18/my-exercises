let palavra = "arara"; 

let palavralimpa = word.replace(/\s+/g, '').toLowerCase();
let palavraReversa = "";

for (let i = palavralimpa.length - 1; i >= 0; i--) {
    palavraReversa += palavralimpa[i];
}

if (palavralimpa === palavraReversa) {
    console.log("A palavra é um palíndromo.");
} else {
    console.log("A palavra não é um palíndromo.");
}
