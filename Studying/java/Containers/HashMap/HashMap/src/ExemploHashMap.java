import java.util.HashMap;

public class ExemploHashMap {
    public static void main(String[] args) {
        // Criar um HashMap para armazenar frutas e suas cores
        HashMap<String, String> mapaFrutas = new HashMap<>();

        // Adicionar pares de chave-valor ao HashMap
        mapaFrutas.put("Maçã", "Vermelha");
        mapaFrutas.put("Banana", "Amarela");
        mapaFrutas.put("Laranja", "Laranja");

        // Exibir os pares chave-valor
        System.out.println("Mapa de Frutas: " + mapaFrutas);

        // Obter o valor associado a uma chave
        String corMaca = mapaFrutas.get("Maçã");
        System.out.println("A cor da Maçã é: " + corMaca);

        // Verificar se o mapa contém uma chave ou valor
        boolean temBanana = mapaFrutas.containsKey("Banana");
        System.out.println("O mapa contém a chave 'Banana'? " + temBanana);

        // Remover um par chave-valor
        mapaFrutas.remove("Laranja");
        System.out.println("Mapa após remover Laranja: " + mapaFrutas);

        // Iterar sobre as chaves e valores
        for (String chave : mapaFrutas.keySet()) {
            String valor = mapaFrutas.get(chave);
            System.out.println(chave + " tem a cor " + valor);
        }
    }
}
