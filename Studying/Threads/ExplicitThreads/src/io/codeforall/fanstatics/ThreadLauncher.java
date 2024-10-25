package io.codeforall.fanstatics;

public class ThreadLauncher {

    public static void main(String[] args) {

        // Cria uma instância que será executada pelas threads
        MyTask myTask = new MyTask();

        // Executa a tarefa diretamente na thread principal
        myTask.run();

        // Loop para criar e iniciar 10 threads que executam a mesma tarefa
        for (int i = 0; i < 10 ; i++) {

            // Cria uma nova thread e associa a tarefa MyTask a esta thread
            Thread thread = new Thread(new MyTask());

            // Define o nome da thread como "T" seguido do índice (ex: "T0", "T1", etc.)
            thread.setName("T" + i);

            // Inicia a execução da thread (chama o método run() em uma nova thread)
            thread.start();
        }

        // Cria uma thread separada para executar a mesma instância de myTask
        Thread thread = new Thread(myTask);

        // Inicia esta nova thread que também executará myTask
        thread.start();
    }
}
