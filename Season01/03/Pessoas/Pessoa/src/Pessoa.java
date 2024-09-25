public class Pessoa {

    // Atributos (características)
    String nome;
    int idade;
    String Sexo;

    // Método (comportamento) para dizer olá
    void dizerOla() {
        System.out.println("Olá, o meu nome é " + nome);
    }

    void apresentar(String mensagem) {
        System.out.println(mensagem + ", o meu nome é " + nome);
    }

    //Overloading :
    void apresentar(String mensagem, String despedida) {
        System.out.println(mensagem + "estou com pressa" + despedida);
    }

    int idadeEmMeses() {

        return idade * 12;
    }

    //construtor
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;


    }

    //geter
    public String getNome() {
        return nome;
    }

    //setter
    public void setNome(String nome) {
        this.nome = nome;
    }

}