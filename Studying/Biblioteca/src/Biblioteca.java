import java.util.HashMap;

public class Biblioteca {
    private HashMap<Livro, Usuario> emprestimos = new HashMap<>();
    private HashMap<String, Livro> stock = new HashMap<>();

    // Adiciona um livro ao estoque
    public void AddBook(Livro livro) {
        stock.put(livro.getId(), livro);
    }

    // Adiciona um usuário à biblioteca
    public void AddUser(Usuario usuario) {
        System.out.println("Usuário adicionado: " + usuario);
    }

    // Empresta um livro a um usuário, caso esteja disponível
    public void lendBook(Usuario usuario, Livro livro) {
        if (livro.isDisponivel() && stock.containsKey(livro.getId())) {
            livro.emprestar();
            emprestimos.put(livro, usuario);
            System.out.println("Livro emprestado: " + livro.getTitulo() + " a " + usuario.getNome());
        } else {
            System.out.println("O livro " + livro.getTitulo() + " não está disponível.");
        }
    }

    // Mostra todos os livros no estoque
    public void showAllBooks() {
        System.out.println("Livros na biblioteca:");
        for (Livro livro : stock.values()) {
            System.out.println(livro);
        }
    }

    // Mostra todos os livros emprestados
    public void showLendBooks() {
        System.out.println("Livros emprestados:");
        for (HashMap.Entry<Livro, Usuario> entry : emprestimos.entrySet()) {
            System.out.println(entry.getKey().getTitulo() + " emprestado para " + entry.getValue().getNome());
        }
    }

    // Devolve um livro para a biblioteca
    public void returnBook(Livro livro) {
        if (emprestimos.containsKey(livro)) {
            livro.devolver();
            emprestimos.remove(livro);
            System.out.println("Livro devolvido: " + livro.getTitulo());
        } else {
            System.out.println("O livro " + livro.getTitulo() + " não estava emprestado.");
        }
    }
}
