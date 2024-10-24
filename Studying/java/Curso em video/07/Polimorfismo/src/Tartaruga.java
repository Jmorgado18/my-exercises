public class Tartaruga extends Reptil{
    public Tartaruga(String corEscama, double peso, int idade, int membros) {
        super(corEscama, peso, idade, membros);
    }

    @Override
    public void locomover(){
        System.out.println("Rastenjando muuuuuito devagarinhooo");
    }
}
