public class Cao extends Mamifero{

    public Cao(String corPelo, double peso, int idade, int membros) {
        super(corPelo, peso, idade, membros);
    }

    public void EnterrarOsso(){
        System.out.println("Enterrando osso");
    }

    public void AbanarRabo(){
        System.out.println("AbanandoRabo");
    }

    @Override
    public void EmitirSom() {
        System.out.println("Au Au");
    }

}
