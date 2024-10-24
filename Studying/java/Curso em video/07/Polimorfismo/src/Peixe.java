public class Peixe extends Animal{
    private String corEscama;

    public Peixe(String corEscama, double peso, int idade, int membros) {
        super( peso, idade, membros);
        this.corEscama = corEscama;
    }

    private void soltarBolha(){

        System.out.println("Soltando bolhinha");
    }

    @Override
    public void locomover() {
        System.out.println("Nadando");
    }

    @Override
    public void alimentar() {
        System.out.println("Eating another fish");
    }

    @Override
    public void EmitirSom() {
        System.out.println("glugluglu");
    }
}
