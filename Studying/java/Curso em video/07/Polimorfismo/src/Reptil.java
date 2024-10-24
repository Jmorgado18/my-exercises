public class Reptil extends Animal{
    private String corEscama;


    public Reptil(String corEscama, double peso, int idade, int membros) {
        super( peso, idade, membros);
        this.corEscama = corEscama;
    }

    @Override
    public void locomover() {
        System.out.println("Rastejando");
    }

    @Override
    public void alimentar() {
        System.out.println("Comendo instetos");
    }

    @Override
    public void EmitirSom() {
        System.out.println("*strange sound*");
    }
}
