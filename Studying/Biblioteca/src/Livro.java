public class Livro {
    private String titulo;
    private String autor;
    private String id;
    private boolean available;

    public Livro(String titulo, String autor, String id) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.available = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDisponivel() {
        return available;
    }

    public void emprestar() {
        available = false;
    }

    public void devolver() {
        available = true;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", id='" + id + '\'' +
                ", available=" + available +
                '}';
    }
}
