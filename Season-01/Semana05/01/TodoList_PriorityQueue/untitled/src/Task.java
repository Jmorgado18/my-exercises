// Classe Task que implementa Comparable para ser usada na PriorityQueue
public class Task implements Comparable<Task> {
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
