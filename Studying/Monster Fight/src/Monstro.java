public class Monstro {
    private String nome;
    private int pontosVida;
    private int forcaAtaque;
    private int forcaDefesa;
    private Habilidade habilidade;

    public Monstro(String nome) {
        this.nome = nome;
        this.pontosVida = 100;
        this.forcaAtaque = gerarForcaAleatoria();
        this.forcaDefesa = gerarForcaAleatoria();
        this.habilidade = gerarHabilidadeAleatoria();
    }

    // Gera um valor de força de ataque ou defesa aleatório entre 1 e 10
    private int gerarForcaAleatoria() {
        return (int) (Math.random() * 10) + 1;
    }

    // Escolhe uma habilidade aleatória do enum Habilidade
    private Habilidade gerarHabilidadeAleatoria() {
        Habilidade[] habilidades = Habilidade.values();
        int indiceAleatorio = (int) (Math.random() * habilidades.length);
        return habilidades[indiceAleatorio];
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public int getForcaAtaque() {
        return forcaAtaque;
    }

    public int getForcaDefesa() {
        return forcaDefesa;
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }

    // Método para receber dano
    public void receberDano(int dano) {
        pontosVida -= dano;
        if (pontosVida < 0) pontosVida = 0;
    }

    // Verifica se o monstro ainda está vivo
    public boolean estaVivo() {
        return pontosVida > 0;
    }

    @Override
    public String toString() {
        return "Monstro{" +
                "nome='" + nome + '\'' +
                ", pontosVida=" + pontosVida +
                ", forcaAtaque=" + forcaAtaque +
                ", forcaDefesa=" + forcaDefesa +
                ", habilidade=" + habilidade +
                '}';
    }
}
