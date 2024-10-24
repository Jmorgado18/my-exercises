public class Playground {
    public static void main(String[] args) {
        // Criando um objeto Dog
        Dog dog = new Dog("Buddy", 5, 25.0);

        // Testando diferentes reações
        System.out.println("Reagindo à hora do dia:");
        dog.react("day");  // Deve imprimir "sou amigavel"
        dog.react("night");  // Deve imprimir "Estou com sono"

        System.out.println("\nReagindo a uma frase:");
        dog.react("goodboy");  // Deve imprimir "sou amigavel"
        dog.react("badboy");  // Deve imprimir "AUUUFFFF"

        System.out.println("\nReagindo ao dono:");
        dog.react(true);  // Deve imprimir "sou amigavel"
        dog.react(false);  // Deve imprimir "AUUUUUFFFF"

        System.out.println("\nReagindo à idade:");
        dog.react(dog.getAge());  // Deve imprimir "Sou amigavel"
        dog.setAge(80);
        dog.react(dog.getAge());  // Deve imprimir "AUUUFFFF"

        System.out.println("\nReagindo à altura:");
        dog.react(dog.getHeight());  // Deve imprimir "AUUUFFFF"
        dog.setHeight(1);
        dog.react(dog.getHeight());  // Deve imprimir "Sou amigavel"
    }
}
