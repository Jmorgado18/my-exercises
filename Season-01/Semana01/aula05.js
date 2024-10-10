// n! = n*(n-1)!
/*
Pior caso possivel : Se N for menor que 0 - excluir essa possibilidade;
Definir Base Point : Se N for 0 ;
Chamar a função de novo com o valor n até chegar ao basepoint;

*/

let n= -10
let fac= function factorial(n){
    if (n<0){
        console.log (` ${n} é um numero negativo e como tal não tem factorial`);
        return;
    }

    if (n===0){
        return 1;
    }
    return n * factorial(n-1);
}

if (n>=0){
console.log(`O fatorial de ${n} é ${fac(n)}.`);
}else{
    fac(n);
}
/*


*/