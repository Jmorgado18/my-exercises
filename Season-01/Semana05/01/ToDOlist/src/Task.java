public class Task implements Comparable<Task> {

    private Importance importance;
    private int priority;
    private String description;



    public Task(Importance importance ,int priority,String description){
        this.priority=priority;
        this.importance=importance;
        this.description=description;
    }

    public Importance getImportance() {
        return importance;
    }

    public String getDescription() {
        return description;
    }
    public int compareTo(Task othertask){
        if(this.importance!=othertask.getImportance()){
           // System.out.println(this.importance.compareTo(othertask.importance));
            return this.importance.compareTo(othertask.importance);

        }
       // System.out.println(Integer.compare(this.priority,othertask.priority));
        return Integer.compare(this.priority,othertask.priority);

    }


    public String getTask() {
        return this.importance+" " + priority+" "+this.description;
    }
}
