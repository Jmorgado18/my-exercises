public class Ave extends Animal{

    private String CorPena;

    public Ave(String CorPena, double peso, int idade, int membros) {
        super(peso, idade, membros);
        this.CorPena=CorPena;

    }

    private void fazerNinho(){
        System.out.println("fazendo ninho");
    }

    @Override
    public void locomover() {
        System.out.println("Voando");
    }

    @Override
    public void alimentar() {
        System.out.println("Comendo sementes");
    }

    @Override
    public void EmitirSom() {
        System.out.println("Piu piu");
    }

}
