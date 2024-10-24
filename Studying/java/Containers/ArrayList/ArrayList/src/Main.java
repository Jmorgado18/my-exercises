import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criar uma lista de strings
        ArrayList<String> lista = new ArrayList<>();

        // Adicionar elementos à lista
        lista.add("Maçã");
        lista.add("Banana");
        lista.add("Laranja");

        // Exibir os elementos da lista
        System.out.println("Conteúdo da lista: " + lista);

        // Acessar um elemento específico (usando índice)
        String fruta = lista.get(1);  // Pega o segundo elemento (índice 1)
        System.out.println("Fruta no índice 1: " + fruta);

        // Remover um elemento
        lista.remove("Banana");
        System.out.println("Lista após remover Banana: " + lista);

        // Obter o tamanho da lista
        System.out.println("Tamanho da lista: " + lista.size());
    }
}
