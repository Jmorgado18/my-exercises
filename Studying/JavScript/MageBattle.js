/*7. Batalha de Magos
Imagina que estás numa batalha de magos e cada mago tem um poder. Cria uma função batalhaMagos que recebe dois magos e seus poderes (como "fogo", "gelo", "relâmpago") e diz quem venceu a batalha, de acordo com a seguinte regra:

*/

function batalhaMagos(mago1, mago2) {
        if (mago1 === mago2) {
            return "Empate!";
        } else if (mago1 === "fogo" && mago2 === "gelo") {
            return "Mago 1 venceu!";
        } else if (mago1 === "gelo" && mago2 === "relâmpago") {
            return "Mago 1 venceu!"; 
        } else if (mago1 === "relâmpago" && mago2 === "fogo") {
            return "Mago 2 venceu!";
        } else {
            return "Mago 2 venceu!";
        }
    }   
    
    console.log(batalhaMagos("fogo", "gelo"));
    console.log(batalhaMagos("relâmpago", "fogo"));
    console.log(batalhaMagos("gelo", "relâmpago"));

