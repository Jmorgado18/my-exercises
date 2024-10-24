public class AlunoBolsa extends Aluno{

    public AlunoBolsa(Aluno aluno, Course course, int registration) {
        super(aluno, course, registration);
    }

    @Override
    public void pagarmensalidade(double howmuch){

        System.out.println("Um aluno com bolsa não paga");
    }
}
