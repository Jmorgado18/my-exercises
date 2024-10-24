public class Externa {
    public void metodoExterno() {
        // Classe interna local ao método
        class Local {
            public void imprimir() {
                System.out.println("Esta é uma classe interna local!");
            }
        }

        // Instanciar e usar a classe interna local
        Local local = new Local();
        local.imprimir();
    }

    public static void main(String[] args) {
        Externa externa = new Externa();
        externa.metodoExterno();
    }
}
