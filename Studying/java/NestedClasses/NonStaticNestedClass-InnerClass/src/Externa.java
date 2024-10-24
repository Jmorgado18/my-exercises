public class Externa {
    private String saudacao = "Olá do lado de fora!";

    // Inner Class
    public class AninhadaInterna {
        public void mostrarSaudacao() {
            System.out.println("Saudação da classe externa: " + saudacao);
        }
    }

    public static void main(String[] args) {
        // Instanciar a classe externa primeiro
        Externa externa = new Externa();

        // Agora instanciar a Inner Class através da instância da classe externa
        Externa.AninhadaInterna interna = externa.new AninhadaInterna();
        interna.mostrarSaudacao();
    }
}
