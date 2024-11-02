public class Sandbox {
    public static void main(String[] args) {
        // Criar instância da biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Criar livros
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "001");
        Livro livro2 = new Livro("Dom Quixote", "Miguel de Cervantes", "002");
        Livro livro3 = new Livro("1984", "George Orwell", "003");
        Livro livro4 = new Livro("Orgulho e Preconceito", "Jane Austen", "004");
        Livro livro5 = new Livro("A Revolução dos Bichos", "George Orwell", "005");

        // Adicionar livros à biblioteca
        biblioteca.AddBook(livro1);
        biblioteca.AddBook(livro2);
        biblioteca.AddBook(livro3);
        biblioteca.AddBook(livro4);
        biblioteca.AddBook(livro5);

        // Criar usuários
        Usuario usuario1 = new Usuario("João", "U001");
        Usuario usuario2 = new Usuario("Maria", "U002");
        Usuario usuario3 = new Usuario("Pedro", "U003");
        Usuario usuario4 = new Usuario("Ana", "U004");
        Usuario usuario5 = new Usuario("Luís", "U005");

        // Adicionar usuários à biblioteca
        biblioteca.AddUser(usuario1);
        biblioteca.AddUser(usuario2);
        biblioteca.AddUser(usuario3);
        biblioteca.AddUser(usuario4);
        biblioteca.AddUser(usuario5);

        // Mostrar todos os livros
        System.out.println("\n--- Todos os Livros ---");
        biblioteca.showAllBooks();

        // Testar empréstimos
        System.out.println("\n--- Emprestar Livros ---");
        biblioteca.lendBook(usuario1, livro1);
        biblioteca.lendBook(usuario2, livro3);
        biblioteca.lendBook(usuario3, livro5);

        // Mostrar livros emprestados
        System.out.println("\n--- Livros Emprestados ---");
        biblioteca.showLendBooks();

        // Testar devolução de livros
        System.out.println("\n--- Devolver Livros ---");
        biblioteca.returnBook(livro1);
        biblioteca.returnBook(livro3);

        // Mostrar livros emprestados após devolução
        System.out.println("\n--- Livros Emprestados Após Devolução ---");
        biblioteca.showLendBooks();

        // Verificar a disponibilidade de um livro específico
        System.out.println("\nDisponibilidade de 'O Senhor dos Anéis': " + livro1.isDisponivel());
    }
}
