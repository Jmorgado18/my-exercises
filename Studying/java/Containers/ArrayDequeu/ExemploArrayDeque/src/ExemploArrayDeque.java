import java.util.ArrayDeque;

public class ExemploArrayDeque {
    public static void main(String[] args) {
        // Criar uma ArrayDeque de strings
        ArrayDeque<String> deque = new ArrayDeque<>();

        // Adicionar elementos ao final
        deque.add("Maçã");
        deque.add("Banana");
        deque.add("Laranja");

        // Adicionar um elemento no início
        deque.addFirst("Morango");

        // Exibir os elementos da ArrayDeque
        System.out.println("Deque: " + deque);

        // Remover um elemento do início
        String primeiro = deque.removeFirst();
        System.out.println("Removido do início: " + primeiro);

        // Remover um elemento do final
        String ultimo = deque.removeLast();
        System.out.println("Removido do final: " + ultimo);

        // Exibir o estado atual do deque
        System.out.println("Deque após remoções: " + deque);
    }
}
