import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        TodoList todoList = new TodoList();

        todolist.add(TodoList.Importance.MEDIUM,1,"Medium priority 1");
        todolist.add(TodoList.Importance.MEDIUM,1,"Low priority 1");
        todolist.add(TodoList.Importance.MEDIUM,1,"High priority 1");
        todolist.add(TodoList.Importance.MEDIUM,2,"Low priority 1");
        todolist.add(TodoList.Importance.MEDIUM,2,"Medium priority 1");
        todolist.add(TodoList.Importance.MEDIUM,2,"High priority 1");

        while (!todoList.isEmpty()){
            System.out.println(Objects.remove());
        }


    }
}
