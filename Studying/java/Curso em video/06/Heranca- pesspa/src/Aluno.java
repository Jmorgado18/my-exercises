public  class Aluno extends Pessoa{
    private int registration;
    private Course course;
    private boolean isregistred;
    private double mensalidade;
    public Aluno(Pessoa pessoa, Course course, int registration) {
        super(pessoa.getName(), pessoa.getAge(), pessoa.getSex());
        this.registration=registration;
        this.course=course;
        isregistred=false;
        mensalidade=300;

    }

    public void register(){
        this.isregistred=true;
        System.out.println("O aluno " + this.getName() + " está agora matriculado");

    }

    public void unRegister(){
        this.isregistred=false ;
        System.out.println("O aluno " + this.getName() + " cancelou a matricula");
    }

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean isIsregistred() {
        return isregistred;
    }

    public void setIsregistred(boolean isregistred) {
        this.isregistred = isregistred;
    }
    public void pagarmensalidade(double howmuch){

        double dif = mensalidade-howmuch;
        if (howmuch<mensalidade){
            System.out.println("Falta pagar " + dif );
            return;
        }
        System.out.println("mensalidade paga");
    }


}

