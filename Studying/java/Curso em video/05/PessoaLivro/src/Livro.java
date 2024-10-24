public class Livro implements Publicacao{
    private String titulo;
    private String autor;
    private int totPag;
    private int actPag;
    private boolean isOpen;
    private Pessoa leitor;

    public Livro(String titulo, String autor, int totPag, int actPag, boolean isOpen, Pessoa leitor) {
        this.titulo = titulo;
        this.autor = autor;
        this.totPag = totPag;
        this.actPag = actPag;
        this.isOpen = isOpen;
        this.leitor = leitor;
    }

    public String getTitulo() {
        return titulo;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotPag() {
        return totPag;
    }

    public void setTotPag(int totPag) {
        this.totPag = totPag;
    }

    public int getActPag() {
        return actPag;
    }

    public void setActPag(int actPag) {
        this.actPag = actPag;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Pessoa getLeitor() {
        return leitor;
    }


    private boolean Detalhes() {

        System.out.println("O Livro " + this.getTitulo() + " do autor" + this.getAutor() + " está a ser lido por " + this.getLeitor());
        System.out.println("________------------________");

        return false;
    }
    public boolean getDetalhes(){
        return Detalhes();
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Total de Páginas: " + totPag +
                ", Página Atual: " + actPag + ", Está aberto: " + isOpen + ", Leitor: " + leitor;
    }

    @Override
    public void openBook(){

        isOpen=true;
    }

    @Override
    public void closeBook() {

        isOpen=false;

    }

    @Override
    public void nextPage() {
        this.actPag++;

    }

    @Override
    public void previousPage() {
        this.actPag--;

    }


}
