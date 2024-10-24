public class Mamifero extends Animal{
private String corPelo;

    public Mamifero(String corPelo, double peso, int idade, int membros) {
        super( peso, idade, membros);
        this.corPelo = corPelo;
    }

    @Override
    public void locomover() {
        System.out.println("Correndo");
    }

    @Override
    public void alimentar() {
        System.out.println("Mamando");
    }

    @Override
    public void EmitirSom() {
        System.out.println("MUUUUUHHHH");
    }
}
