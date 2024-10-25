package io.codeforall.fanstatics;

// Classe principal que simula uma fábrica com trabalhadores
public class FabricaDasCaldas {

    public static void main(String[] args) {

        // Exibe o nome da thread principal
        System.out.println(Thread.currentThread().getName());


        System.out.println("GERENTE: À espera que estes colaboradores acabem...");

        // Cria e inicia a primeira thread para o trabalhador
        Thread trabalhador = new Thread(new TrabalhadorDasCaldas());
        trabalhador.start();

        // Cria e inicia a segunda thread para outro trabalhador
        Thread trabalhador2 = new Thread(new TrabalhadorDasCaldas());
        trabalhador2.start();

        // Aguarda que as threads dos trabalhadores terminem antes de continuar
        try {
            trabalhador.join();   // Espera que a primeira thread finalize
            trabalhador2.join();  // Espera que a segunda thread finalize
        } catch (InterruptedException e) {
            // Caso a thread principal seja interrompida durante o join(), exibe esta mensagem
            System.out.println("Acordaram-me da sesta, mas ainda não acabaram!");
            e.printStackTrace();
        }

        // Mensagem do gerente, indicando que os trabalhadores finalmente terminaram
        System.out.println("GERENTE: Finalmente acabaram, vou me por no ...");
    }
}
