import java.util.TreeMap;

public class ExemploTreeMap {
    public static void main(String[] args) {
        // Criar um TreeMap para armazenar frutas e suas cores
        TreeMap<String, String> mapaOrdenado = new TreeMap<>();

        // Adicionar pares de chave-valor ao TreeMap
        mapaOrdenado.put("Banana", "Amarela");
        mapaOrdenado.put("Maçã", "Vermelha");
        mapaOrdenado.put("Laranja", "Laranja");

        // Exibir os pares chave-valor (de forma ordenada)
        System.out.println("Mapa de Frutas (ordenado): " + mapaOrdenado);

        // Obter o valor associado a uma chave
        String corMaca = mapaOrdenado.get("Maçã");
        System.out.println("A cor da Maçã é: " + corMaca);

        // Acessar o primeiro e o último par de chave-valor
        System.out.println("Primeiro par: " + mapaOrdenado.firstEntry());
        System.out.println("Último par: " + mapaOrdenado.lastEntry());

        // Remover um par chave-valor
        mapaOrdenado.remove("Laranja");
        System.out.println("TreeMap após remover Laranja: " + mapaOrdenado);

        // Iterar sobre as chaves e valores
        for (String chave : mapaOrdenado.keySet()) {
            String valor = mapaOrdenado.get(chave);
            System.out.println(chave + " tem a cor " + valor);
        }
    }
}
