public class Shelter {
    Animal animal1 = new Animal();
    Animal animal2 = new Animal();
    Animal animal3 = new Animal();
    String nome;
    private String location;
    String lotacao;

public  Shelter(){
    animal1.nome="Bob";
    animal1.idade=5;
    animal1.adotar=true;
    animal1.setTipo(Tipo.CROCODILO);
    animal1.adotar();
    animal1.food("Ração seca", "RoyalCannin");

    animal2.nome = "Mia";
    animal2.idade = 3;
    animal2.adotar = false;
    animal2.setTipo(Tipo.GATO);
    String foodty="Restos";
    animal2.food(foodty);
}
public void showDetails(){
    System.out.println("O " + animal1.nome + " tem " + animal1.idade + " anos. É do tipo " + animal1.tipo + ". ADOÇÃO: " + animal1.adotar);
    System.out.println("O " + animal1.nome + " come " + animal1.foodtype + " da marca " + animal1.brandname );
    System.out.println("A " + animal2.nome + " come " + animal2.foodtype );

}

public Shelter(String name, String location){
    this.nome=name;
    this.location=location;
    System.out.println("Construtor 1: Nome do abrigo: " + this.nome + ", Localização: " + this.location);
}
public Shelter(String lotacao){
    this.lotacao=lotacao;
    System.out.println("Construtor 2: Lotação do abrigo: " + this.lotacao);

}
}
