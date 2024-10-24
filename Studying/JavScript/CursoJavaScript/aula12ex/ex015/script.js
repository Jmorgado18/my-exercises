function verificar(){
//window.alert ("Funçao a funcionar?");
var data = new Date();
var ano = data.getFullYear();
var fano=document.getElementById('txtano');
var res=document.querySelector('div#res');
    if (fano.value.length == 0 || Number(fano.value) > ano ) {
        window.alert ("[ERRO] Verifique os dados e tente novamente!");
    }else{
        var fsex=document.getElementsByName('radsex');
        var idade = ano - Number(fano.value);
        // res.innerHTML = `Idade calculada : ${idade}`
        var genero = ``;
        var img =document.createElement('img');
        img.setAttribute('id' , 'foto')
            if(fsex[0].checked) {
                genero="Homem";
                    if (idade >=0 && idade <10) {
                        //CRIANÇA
                        img.setAttribute('src' , 'bebehomem.png')
                    }else if (idade <20) {
                        //JOVEM
                        img.setAttribute('src' , 'jovemhomem.png')
                    }else if (idade < 50) {
                        //ADULTO
                        img.setAttribute('src' , 'adultohomem.png')
                    }else  {
                        //IDOSO
                        img.setAttribute('src' , 'velhohomem.png')
                    }
            }else{
                genero="Mulher";
                if (idade >=0 && idade <10) {
                    //CRIANÇA
                    img.setAttribute('src' , 'bebemulher.png')
                }else if (idade <20) {
                    //JOVEM
                    img.setAttribute('src' , 'jovemmulher.png')
                }else if (idade < 50) {
                    //ADULTO
                    img.setAttribute('src' , 'adultomulher.png')
                }else  {
                    //IDOSO
                    img.setAttribute('src' , 'velhamulher.png')
                }
            }
        res.innerHTML=`${genero} com ${idade} anos`
       res.appendChild(img);
    }

}