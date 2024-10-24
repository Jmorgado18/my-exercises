import java.util.PriorityQueue;

public class ExemploPriorityQueue {
    public static void main(String[] args) {
        // Criar uma PriorityQueue de inteiros
        PriorityQueue<Integer> filaPrioridade = new PriorityQueue<>();

        // Adicionar elementos à fila
        filaPrioridade.add(10);
        filaPrioridade.add(5);
        filaPrioridade.add(20);
        filaPrioridade.add(1);

        // Exibir o elemento com a maior prioridade (menor número, neste caso)
        System.out.println("Primeiro elemento (maior prioridade): " + filaPrioridade.peek());

        // Remover e exibir os elementos com base na prioridade
        while (!filaPrioridade.isEmpty()) {
            System.out.println("Removido: " + filaPrioridade.poll());
        }
    }
}
