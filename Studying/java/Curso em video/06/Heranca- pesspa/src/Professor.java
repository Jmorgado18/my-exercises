public class Professor extends Pessoa{
    private Course course;
    private double salary;

    public Professor(Pessoa pessoa, Course course, double salary) {
        super(pessoa.getName(), pessoa.getAge(), pessoa.getSex());
        this.course=course;
        this.salary=salary;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(int howmuch){
        this.salary=salary + howmuch;
        System.out.println("O salário do " + this.getName() + "aumentou para" + this.getSalary());
    }
}
