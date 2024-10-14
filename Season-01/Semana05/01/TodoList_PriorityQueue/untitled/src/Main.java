public class Main {
    public static void main(String[] args) {
        TodoList todolist = new TodoList();

        todolist.add(TodoList.Importance.MEDIUM,1,"Medium priority,1");
        todolist.add(TodoList.Importance.LOW,1,"low priority,1");
        todolist.add(TodoList.Importance.HIGH,1,"High priority,1");
        todolist.add(TodoList.Importance.LOW,2,"Low priority,1");
        todolist.add(TodoList.Importance.MEDIUM,2,"Medium priority,1");
        todolist.add(TodoList.Importance.HIGH,2,"High priority,1");

        while(!todolist.isEmpty()){
            System.out.println(todolist.remove());
        }
    }
}

