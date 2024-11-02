public class Batalha {
    private Monstro monstro1;
    private Monstro monstro2;

    public Batalha(Monstro monstro1, Monstro monstro2) {
        this.monstro1 = monstro1;
        this.monstro2 = monstro2;
    }

    public void iniciar() {
        System.out.println("Início da batalha entre " + monstro1.getNome() + " e " + monstro2.getNome());

        // Loop até que um dos monstros seja derrotado
        while (monstro1.estaVivo() && monstro2.estaVivo()) {
            // Monstro 1 ataca Monstro 2
            realizarAtaque(monstro1, monstro2);

            if (!monstro2.estaVivo()) {
                System.out.println(monstro2.getNome() + " foi derrotado!");
                break;
            }

            // Monstro 2 ataca Monstro 1
            realizarAtaque(monstro2, monstro1);

            if (!monstro1.estaVivo()) {
                System.out.println(monstro1.getNome() + " foi derrotado!");
                break;
            }
        }

        System.out.println("A batalha terminou!");
    }

    private void realizarAtaque(Monstro atacante, Monstro defensor) {
        int dano = atacante.getForcaAtaque() - defensor.getForcaDefesa();
        dano = Math.max(dano, 0);  // Assegura que o dano não é negativo
        defensor.receberDano(dano);

        System.out.println(atacante.getNome() + " ataca " + defensor.getNome() +
                " e causa " + dano + " de dano! " +
                defensor.getNome() + " agora tem " + defensor.getPontosVida() + " pontos de vida.");
    }
}
