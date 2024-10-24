public class Goldfish extends Peixe{

    public Goldfish(String corEscama, double peso, int idade, int membros) {
        super(corEscama, peso, idade, membros);
    }

    @Override
    public void alimentar() {
        System.out.println("Eating o que me dão para comer");
    }
}
