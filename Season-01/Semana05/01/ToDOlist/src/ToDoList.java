import java.util.Iterator;
import java.util.PriorityQueue;

public class ToDoList {
    private PriorityQueue<Task> tasks;


    public ToDoList() {
        this.tasks = new PriorityQueue<>();
    }

    public boolean add(Importance importance, int priority, String description) {
        tasks.offer(new Task(importance, priority, description));
        System.out.println(tasks.peek().getTask());


        return true;
    }

    public boolean remove() {
        System.out.println("this is removed "+tasks.peek().getTask());
        tasks.poll();

        return true;
    }

    public void printalhada() {
        System.out.println(tasks.peek().getTask());

    }

    public boolean isEmpty() {


        return tasks.size() == 0;
    }


}



