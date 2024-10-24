public class Playground {
    public static void main(String[] args) {
        // Criar instâncias de Pessoa
        Pessoa leitor1 = new Pessoa("João", 25, Sexo.MASCULINO);
        Pessoa leitor2 = new Pessoa("Maria", 30, Sexo.FEMININO);

        // Testar método status() da classe Pessoa
        leitor1.status();
        leitor2.status();

        // Testar método birthday() da classe Pessoa
        leitor1.birthday();
        leitor2.birthday();

        // Criar instâncias de Livro
        Livro livro1 = new Livro("Aprendendo Java", "Carlos Silva", 300, 50, false, leitor1);
        Livro livro2 = new Livro("História da Programação", "Ana Borges", 200, 150, true, leitor2);

        // Exibir informações dos livros
        System.out.println(livro1);
        System.out.println(livro2);

        // Testar métodos de navegação e detalhes do livro
        livro1.getDetalhes();
        livro2.getDetalhes();

        // Abrir, avançar páginas e fechar livros
        livro1.openBook();  // Este método ainda não está corretamente implementado, veja correção abaixo
        livro1.nextPage();
        livro1.nextPage();
        livro1.previousPage();
        livro1.closeBook();  // Corrigir também este método

        // Exibir novamente as informações do livro após as operações
        System.out.println("Depois de ler algumas páginas:");
        System.out.println(livro1);

        // Testar método de navegação do livro 2
        livro2.nextPage();
        System.out.println("Livro 2 depois de avançar página:");
        System.out.println(livro2);
    }
}
