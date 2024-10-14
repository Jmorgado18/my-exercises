public class Main {
    public static void main(String[] args) {
        ToDoList todolist = new ToDoList();
        todolist.add(Importance.MEDIUM, 1, "Medium priority 1");
        todolist.add(Importance.LOW, 1, "Low priority 1");
        todolist.add(Importance.HIGH, 1, "High priority 1");
        todolist.add(Importance.LOW, 2, "Low priority 2");
        todolist.add(Importance.MEDIUM, 2, "Medium priority 2");
        todolist.add(Importance.HIGH, 2, "High priority 2");


        while (!todolist.isEmpty()) {
            todolist.remove();

        }



    }
}


