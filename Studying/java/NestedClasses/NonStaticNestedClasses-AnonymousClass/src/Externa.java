public class Externa {
    public void executar() {
        // Anonymous Inner Class que implementa a interface Runnable
        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                System.out.println("Executando a tarefa de uma classe anônima!");
            }
        };

        // Iniciar a tarefa
        tarefa.run();
    }

    public static void main(String[] args) {
        Externa externa = new Externa();
        externa.executar();
    }
}
