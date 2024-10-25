package io.codeforall.fanstatics;

// Implementa a interface Runnable para que possa ser executada numa thread
public class TrabalhadorDasCaldas implements Runnable {

    // Método run que será executado pela thread
    @Override
    public void run() {

        // Exibe o nome da thread que está a executar este código
        System.out.println(Thread.currentThread().getName());

        // Loop para simular o trabalho, repetindo 10 vezes
        for (int i = 0; i < 10 ; i++) {
            // Imprime uma mensagem de "trabalho" com o nome da thread atual
            System.out.println(Thread.currentThread().getName() + " TRABALHADOR DAS CALDAS: Aqui a fazer um caralho...");

            try {
                // Faz a thread "dormir" por 1000 ms (1 segundo), simulando uma pausa no trabalho
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Mensagem caso a thread seja interrompida durante o sono
                System.out.println("Estava a dormir, mas acordaram-me!!!");
                e.printStackTrace();
            }
        }

        // Mensagem final após a conclusão do loop, indicando que o trabalho terminou
        System.out.println("TRABALHADOR DAS CALDAS: Não faço mais um caralho...");
    }
}
