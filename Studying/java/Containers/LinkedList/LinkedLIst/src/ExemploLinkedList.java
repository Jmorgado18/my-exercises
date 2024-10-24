import java.util.LinkedList;

public class ExemploLinkedList {
    public static void main(String[] args) {
        // Criar uma LinkedList de Strings
        LinkedList<String> lista = new LinkedList<>();

        // Adicionar elementos à lista
        lista.add("Maçã");
        lista.add("Banana");
        lista.add("Laranja");

        // Exibir os elementos da lista
        System.out.println("Conteúdo da lista: " + lista);

        // Adicionar um elemento no início da lista
        lista.addFirst("Melancia");
        System.out.println("Após adicionar Melancia no início: " + lista);

        // Remover o primeiro e último elemento
        lista.removeFirst();
        lista.removeLast();
        System.out.println("Após remover o primeiro e último: " + lista);

        // Acessar um elemento específico (mesmo que a performance seja melhor para inserção/remover)
        String fruta = lista.get(1);  // Pega o segundo elemento (índice 1)
        System.out.println("Fruta no índice 1: " + fruta);

        // Verificar o tamanho da lista
        System.out.println("Tamanho da lista: " + lista.size());
    }
}
