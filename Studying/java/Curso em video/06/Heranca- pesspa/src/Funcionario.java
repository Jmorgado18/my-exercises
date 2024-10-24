public class Funcionario extends Pessoa{
    private Course course;
    private boolean isWorking;
    public Funcionario(Pessoa pessoa, Course course) {
        super(pessoa.getName(), pessoa.getAge(), pessoa.getSex());
        this.course=course;
        isWorking=true;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
    public void changeWork(){
        this.isWorking=false;
    }
}
