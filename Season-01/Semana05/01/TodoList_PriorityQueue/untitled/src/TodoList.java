import java.util.PriorityQueue;

// Classe TodoList que contém uma PriorityQueue de Task
public class TodoList {

    // Alias para o enum Importance que está fora
    public static enum Importance {
        LOW, MEDIUM, HIGH
    }

    // Classe interna Task que implementa Comparable para ser usada na PriorityQueue
    private static class Task implements Comparable<Task> {
        private final Importance importance;
        private final int priority;
        private final String description;

        // Construtor da Task
        public Task(Importance importance, int priority, String description) {
            this.importance = importance;
            this.priority = priority;
            this.description = description;
        }

        // Implementação de compareTo para ordenar tarefas
        @Override
        public int compareTo(Task other) {
            // Comparação com base na importância
            if (this.importance != other.importance) {
                return other.importance.ordinal() - this.importance.ordinal();
            }
            // Se a importância for igual, compara pela prioridade
            return Integer.compare(this.priority, other.priority);
        }

        // Representação da Task como String
        @Override
        public String toString() {
            return "Importance: " + importance + ", Priority: " + priority + ", Description: " + description;
        }
    }

    // PriorityQueue para armazenar as tarefas
    private final PriorityQueue<Task> taskQueue;

    // Construtor da classe TodoList
    public TodoList() {
        taskQueue = new PriorityQueue<>();
    }

    // Método para adicionar uma tarefa
    public void add(Importance importance, int priority, String description) {
        Task newTask = new Task(importance, priority, description);
        taskQueue.add(newTask);
    }

    // Método para remover uma tarefa
    public Task remove() {
        return taskQueue.poll();
    }

    // Método para verificar se a lista está vazia
    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }
}
