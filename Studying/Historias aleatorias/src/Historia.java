public class Historia {

    private Personagem personagem;
    private Accao accao;
    private Lugar lugar;
    private int aleatorio;

    // Construtor que inicializa os valores aleatórios
    public Historia() {
        this.accao = getAccao();
        this.lugar = getLugar();
        this.personagem = getPersonagem();
    }

    // Método para gerar um número aleatório entre 0 e 29
    private int getAleatorio() {
        aleatorio = (int) Math.floor(Math.random() * 30);
        return aleatorio;
    }

    // Método para obter uma ação aleatória
    private Accao getAccao() {
        Accao[] accoes = Accao.values();

        return accoes[getAleatorio() % accoes.length];  // Garantir que o índice está dentro dos limites
    }

    // Método para obter um personagem aleatório
    private Personagem getPersonagem() {
        Personagem[] personagens = Personagem.values();
        return personagens[getAleatorio() % personagens.length];
    }

    // Método para obter um lugar aleatório
    private Lugar getLugar() {
        Lugar[] lugares = Lugar.values();
        return lugares[getAleatorio() % lugares.length];
    }

    // Método que imprime a história
    private void history() {
        System.out.println("A personagem " + personagem.name().toLowerCase() +
                " realizou a ação: " + accao.name().toLowerCase() +
                " no seguinte lugar: " + lugar.name().toLowerCase());
    }

    // Método público para mostrar a história
    public void showHistory() {
        history();
    }
}
