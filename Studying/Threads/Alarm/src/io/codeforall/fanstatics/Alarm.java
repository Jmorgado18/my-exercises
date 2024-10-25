package io.codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {

    // um objeto Timer para agendar as tarefas de alarme
    Timer timer;

    public static void main(String[] args) {

        //  nome da thread atual, que é a thread principal
        System.out.println(Thread.currentThread().getName());

        // Cria um leitor de entrada (BufferedReader)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String interval = null;
        String rings = null;


        System.out.println("Number of times to ring?");

        try {

            rings = reader.readLine();
        } catch (IOException e) {

            e.printStackTrace();
        }


        System.out.println("Interval between rings?");

        try {

            interval = reader.readLine();
        } catch (IOException e) {

            e.printStackTrace();
        }

        // Cria uma instância do alarme
        Alarm alarm = new Alarm();
        alarm.start(interval, rings);

        // Cria uma segunda instância do alarme
        Alarm alarm1 = new Alarm();
        alarm1.start(interval, rings);
    }

    // Método que inicia o temporizador com o intervalo e número de toques definidos
    private void start(String interval, String rings) {
        // Inicializa o temporizador
        timer = new Timer();
        // Agenda a tarefa para tocar o alarme de forma repetitiva conforme o intervalo definido
        timer.scheduleAtFixedRate(new Ring(Integer.parseInt(rings)), Integer.parseInt(interval) * 1000, Integer.parseInt(interval) * 1000);
    }

    // Classe interna Ring que representa a tarefa do alarme e estende TimerTask para definir a ação a ser repetida
    private class Ring extends TimerTask {


        private int numRings;

        public Ring(int numRings) {

            this.numRings = numRings;
        }

        @Override
        public void run() {
            // Exibe o nome da thread que está a executar esta tarefa (alarm ring)
            System.out.println(Thread.currentThread().getName());


            System.out.println("Alarm is ringing.....");


            numRings--;

            
            if (numRings == 0) {
                System.out.println("Alarm is cancelled");
                stop();
            }
        }

        // Método para parar o alarme cancelando o temporizador
        private void stop() {
            timer.cancel();
        }
    }
}
