public class Sandbox {
    public static void main(String[] args) {
        Monstro monstro1 = new Monstro("Dragão");
        Monstro monstro2 = new Monstro("Golem");

        Batalha batalha = new Batalha(monstro1, monstro2);
        batalha.iniciar();
    }
}
