public class Playground {
    public static void main(String[] args) {
        // Criando instâncias da classe Pessoa
        Pessoa pessoa1 = new Pessoa("Ana", 30, Sex.FEMALE);
        Pessoa pessoa2 = new Pessoa("Carlos", 45, Sex.MALE);
        Pessoa pessoa3 = new Pessoa("José", 46, Sex.MALE);
        Pessoa pessoa4 = new Pessoa("Elena", 40, Sex.FEMALE); // Nova pessoa para professor
        Pessoa pessoa5 = new Pessoa("Laura", 30, Sex.FEMALE); // Nova pessoa para funcionária
        Pessoa pessoa6 = new Pessoa("Pedro", 28, Sex.MALE); // Nova pessoa para aluno

        // Exibindo informações das pessoas
        System.out.println("Nome: " + pessoa1.getName() + ", Idade: " + pessoa1.getAge() + ", Sexo: " + pessoa1.getSex());
        System.out.println("Nome: " + pessoa2.getName() + ", Idade: " + pessoa2.getAge() + ", Sexo: " + pessoa2.getSex());
        System.out.println("Nome: " + pessoa3.getName() + ", Idade: " + pessoa3.getAge() + ", Sexo: " + pessoa3.getSex());
        System.out.println("Nome: " + pessoa4.getName() + ", Idade: " + pessoa4.getAge() + ", Sexo: " + pessoa4.getSex());
        System.out.println("Nome: " + pessoa5.getName() + ", Idade: " + pessoa5.getAge() + ", Sexo: " + pessoa5.getSex());
        System.out.println("Nome: " + pessoa6.getName() + ", Idade: " + pessoa6.getAge() + ", Sexo: " + pessoa6.getSex());

        // Testando o método birthDay()
        pessoa1.birthDay();
        System.out.println(pessoa1.getName() + " fez aniversário! Nova idade: " + pessoa1.getAge());

        // Criando instâncias da classe Aluno usando as pessoas criadas
        Aluno aluno1 = new Aluno(pessoa1, Course.INFORMATICA, 12345); // Ana como Aluna
        Aluno aluno2 = new Aluno(pessoa6, Course.BIOLOGIA, 54321); // Pedro como Aluno

        // Exibindo informações dos alunos
        System.out.println("Aluno: " + aluno1.getName() + ", Curso: " + aluno1.getCourse());
        aluno1.register();  // Ana se matricula
        aluno2.register();  // Pedro se matricula

        // Testando cancelamento de matrícula
        aluno1.unRegister();  // Ana cancela a matrícula

        // Criando instâncias da classe Professor usando a pessoa4
        Professor professor1 = new Professor(pessoa3, Course.MATEMATICA, 5000.0); // José como Professor
        Professor professor2 = new Professor(pessoa4, Course.FISICA, 6000.0); // Elena como Professora

        // Exibindo informações dos professores
        System.out.println("Professor: " + professor1.getName() + ", Curso: " + professor1.getCourse() + ", Salário: " + professor1.getSalary());
        professor1.raiseSalary(500);  // Aumenta o salário do professor José

        // Criando instâncias da classe Funcionario usando a pessoa5
        Funcionario funcionario1 = new Funcionario(pessoa5, Course.QUIMICA); // Laura como Funcionária
        Funcionario funcionario2 = new Funcionario(new Pessoa("Roberto", 35, Sex.MALE), Course.INFORMATICA); // Novo Funcionário

        // Exibindo informações dos funcionários
        System.out.println("Funcionário: " + funcionario1.getName() + ", Curso: " + funcionario1.getCourse() + ", Está trabalhando: " + funcionario1.isWorking());

        // Testando mudança de trabalho
        funcionario1.changeWork();
        System.out.println("Funcionário " + funcionario1.getName() + " está trabalhando: " + funcionario1.isWorking());

        // Testando AlunoBolsa
        AlunoBolsa alunoBolsa = new AlunoBolsa(aluno1, Course.INFORMATICA, 12346); // Ana como Aluna com bolsa
        System.out.println("Aluno com bolsa: " + alunoBolsa.getName() + ", Curso: " + alunoBolsa.getCourse());
        alunoBolsa.pagarmensalidade(200);  // Tentando pagar a mensalidade
    }
}
