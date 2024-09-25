public class Playground {
    public static void main(String[] args) {

        // Criar um objeto da classe Pessoa
        Pessoa pessoa1 = new Pessoa("João" , 33);
        Pessoa pessoa2 = new Pessoa("Maria", 25);
       // pessoa1.nome = "João";  // Atribuir valores - está comentado porque usei o constructer
        // pessoa1.idade = 33;

        // Chamar o método dizerOla()
        pessoa1.dizerOla();  // Output: Olá, o meu nome é João

        pessoa1.apresentar("Bom dia"); //invoca o metodo apresentar com o argumento passado no parametro
        pessoa1.apresentar("Olá, ", " Adeus");

       //usar o return no metodo idadeEmMeses
        int idadeEmMeses= pessoa1.idadeEmMeses();

        System.out.println("Idade em meses " + idadeEmMeses);

        pessoa2.setNome("Ana");
        System.out.println(pessoa2.getNome());




    }

    }

