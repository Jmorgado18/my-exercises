public class Kanguro extends Mamifero{
    public Kanguro(String corPelo, double peso, int idade, int membros) {
        super(corPelo, peso, idade, membros);
    }

    public void UsarBolsa(){
        System.out.println("Usando Bolsa");
    }
    @Override
    public void locomover() {
        System.out.println("Aos saltos");
    }

    public void EmitirSom() {
        System.out.println("Kanguru sounds");
    }
}
