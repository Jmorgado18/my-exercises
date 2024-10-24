import java.util.HashSet;

public class ExemploHashSet {
    public static void main(String[] args) {
        // Criar um HashSet de Strings
        HashSet<String> conjunto = new HashSet<>();

        // Adicionar elementos ao HashSet
        conjunto.add("Maçã");
        conjunto.add("Banana");
        conjunto.add("Laranja");

        // Tentar adicionar um elemento duplicado
        boolean adicionado = conjunto.add("Maçã");
        System.out.println("Maçã foi adicionada novamente? " + adicionado);  // false, porque já existe

        // Exibir os elementos do HashSet
        System.out.println("Elementos no HashSet: " + conjunto);

        // Verificar se um elemento existe
        boolean contemBanana = conjunto.contains("Banana");
        System.out.println("HashSet contém Banana? " + contemBanana);

        // Remover um elemento
        conjunto.remove("Banana");
        System.out.println("HashSet após remover Banana: " + conjunto);

        // Verificar o tamanho do HashSet
        System.out.println("Tamanho do HashSet: " + conjunto.size());
    }
}
