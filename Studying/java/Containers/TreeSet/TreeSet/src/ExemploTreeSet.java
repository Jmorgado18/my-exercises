import java.util.TreeSet;

public class ExemploTreeSet {
    public static void main(String[] args) {
        // Criar um TreeSet de Strings
        TreeSet<String> conjuntoOrdenado = new TreeSet<>();

        // Adicionar elementos ao TreeSet
        conjuntoOrdenado.add("Banana");
        conjuntoOrdenado.add("Maçã");
        conjuntoOrdenado.add("Laranja");

        // Tentar adicionar um elemento duplicado
        boolean adicionado = conjuntoOrdenado.add("Banana");
        System.out.println("Banana foi adicionada novamente? " + adicionado);  // false, pois já existe

        // Exibir os elementos do TreeSet (de forma ordenada)
        System.out.println("Elementos no TreeSet (ordenados): " + conjuntoOrdenado);

        // Acessar o primeiro e o último elemento
        String primeiro = conjuntoOrdenado.first();
        String ultimo = conjuntoOrdenado.last();
        System.out.println("Primeiro elemento: " + primeiro);
        System.out.println("Último elemento: " + ultimo);

        // Remover um elemento
        conjuntoOrdenado.remove("Laranja");
        System.out.println("TreeSet após remover Laranja: " + conjuntoOrdenado);

        // Verificar o tamanho do TreeSet
        System.out.println("Tamanho do TreeSet: " + conjuntoOrdenado.size());
    }
}
