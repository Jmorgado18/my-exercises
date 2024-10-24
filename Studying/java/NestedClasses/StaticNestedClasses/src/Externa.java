public class Externa {
    private static String mensagem = "Olá, Mundo!";

    // Static Nested Class
    public static class AninhadaEstatica {
        public void mostrarMensagem() {
            System.out.println("Mensagem da classe externa: " + mensagem);
        }
    }

    public static void main(String[] args) {
        // Instanciar a Static Nested Class sem instanciar a classe externa
        Externa.AninhadaEstatica aninhada = new Externa.AninhadaEstatica();
        aninhada.mostrarMensagem();
    }
}
