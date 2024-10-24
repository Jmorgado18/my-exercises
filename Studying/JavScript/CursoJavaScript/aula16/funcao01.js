function parimpar(n){
    if(n%2===0){
        return 'Par';
    } else {
        return 'Impar';
    }
}

//Chama a função e guarda o return dentro de res
let res =parimpar(2);
console.log (`O numero é ${res}`);

//Definimos um valor padrão para um parametro caso nao seja atribuido 
function soma (n1=0, n2=0){
    return n1+n2;
}
let s = soma(5);
console.log (s);

//Guardar uma função dentro de uma variavel
let v = function(x){
    return x*2;
}
console.log (v(8));
// Calcular um fatorial de 5 
// 5! = 5*4*3*2*1 = 120
function factorial (n){
    let fat =1;
    for (let 
        c=n;c>1;c--){
        fat *=c;
    }
    return fat;
}   
console.log (factorial(5));
 /* Calcular fatorial de um numero usando a RECURSIVIDADE 
 Chamar uma função dentro dela mesma :
 Factorial de 5 :  5! = 5*4*3*2*1 = 
 Factorial de 4 : 4! = 4*3*2*1 
 Então 5! = 5x 4! 
 ou seja 
 n! = nx(n-1)!
 A não ser que queiramos o fatorial de 1 que é 1! = 1
 */
function factorial2(n){
    if (n===1){
        return 1;
    }else{
        return n*factorial2(n-1);
    }
}
console.log (factorial2(4));