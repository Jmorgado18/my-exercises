public class Playground {
    public static void main(String[] args) {
        // Criando uma instância de Mamífero
        Mamifero mamifero = new Mamifero("Marrom", 30.5, 5, 4);
        System.out.println("Mamífero:");
        System.out.println("Peso: " + mamifero.getPeso());
        System.out.println("Idade: " + mamifero.getIdade());
        mamifero.locomover();
        mamifero.alimentar();
        mamifero.EmitirSom();

        // Criando uma instância de Réptil
        Reptil reptil = new Reptil("Verde", 2.5, 2, 4);
        System.out.println("\nRéptil:");
        System.out.println("Peso: " + reptil.getPeso());
        System.out.println("Idade: " + reptil.getIdade());
        reptil.locomover();
        reptil.alimentar();
        reptil.EmitirSom();

        // Criando uma instância de Peixe
        Peixe peixe = new Peixe("Azul", 1.0, 1, 0);
        System.out.println("\nPeixe:");
        System.out.println("Peso: " + peixe.getPeso());
        System.out.println("Idade: " + peixe.getIdade());
        peixe.locomover();
        peixe.alimentar();
        peixe.EmitirSom();

        // Criando uma instância de Ave
        Ave ave = new Ave("Branca", 0.8, 3, 2);
        System.out.println("\nAve:");
        System.out.println("Peso: " + ave.getPeso());
        System.out.println("Idade: " + ave.getIdade());
        ave.locomover();
        ave.alimentar();
        ave.EmitirSom();

        // Criando uma instância de Cao
        Cao cao = new Cao("Preto", 12.0, 4, 4);
        System.out.println("\nCão:");
        System.out.println("Peso: " + cao.getPeso());
        System.out.println("Idade: " + cao.getIdade());
        cao.locomover();
        cao.alimentar();
        cao.EmitirSom();
        cao.EnterrarOsso();
        cao.AbanarRabo();

        // Criando uma instância de Kanguro
        Kanguro kanguro = new Kanguro("Cinza", 25.0, 6, 4);
        System.out.println("\nCanguru:");
        System.out.println("Peso: " + kanguro.getPeso());
        System.out.println("Idade: " + kanguro.getIdade());
        kanguro.locomover();
        kanguro.alimentar();
        kanguro.EmitirSom();
        kanguro.UsarBolsa();

        // Criando uma instância de Arara
        Arara arara = new Arara("Vermelha", 1.5, 2, 2);
        System.out.println("\nArara:");
        System.out.println("Peso: " + arara.getPeso());
        System.out.println("Idade: " + arara.getIdade());
        arara.locomover();
        arara.alimentar();
        arara.EmitirSom();

        // Criando uma instância de Goldfish
        Goldfish goldfish = new Goldfish("Dourada", 0.2, 1, 0);
        System.out.println("\nGoldfish:");
        System.out.println("Peso: " + goldfish.getPeso());
        System.out.println("Idade: " + goldfish.getIdade());
        goldfish.locomover();
        goldfish.alimentar();
        goldfish.EmitirSom();

        // Criando uma instância de Tartaruga
        Tartaruga tartaruga = new Tartaruga("Verde", 5.0, 10, 4);
        System.out.println("\nTartaruga:");
        System.out.println("Peso: " + tartaruga.getPeso());
        System.out.println("Idade: " + tartaruga.getIdade());
        tartaruga.locomover();
        tartaruga.alimentar();
        tartaruga.EmitirSom();
    }
}
