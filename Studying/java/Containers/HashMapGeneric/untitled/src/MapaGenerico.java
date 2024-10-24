import java.util.HashMap;

public class MapaGenerico<T, U> {
    private HashMap<T, U> mapa;

    // Construtor
    public MapaGenerico() {
        mapa = new HashMap<>();
    }

    // Método para adicionar pares chave-valor
    public void adicionar(T chave, U valor) {
        mapa.put(chave, valor);
    }

    // Método para exibir todos os pares chave-valor
    public void exibirMapa() {
        for (T chave : mapa.keySet()) {
            U valor = mapa.get(chave);
            System.out.println("Chave: " + chave + ", Valor: " + valor);
        }
    }

    public static void main(String[] args) {
        // Criar um MapaGenerico com chaves do tipo String e valores do tipo Integer
        MapaGenerico<String, Integer> mapaFrutas = new MapaGenerico<>();
        mapaFrutas.adicionar("Maçã", 10);
        mapaFrutas.adicionar("Banana", 5);
        mapaFrutas.adicionar("Laranja", 7);

        // Exibir o mapa
        mapaFrutas.exibirMapa();

        // Criar um MapaGenerico com chaves do tipo Integer e valores do tipo String
        MapaGenerico<Integer, String> mapaNumeros = new MapaGenerico<>();
        mapaNumeros.adicionar(1, "Um");
        mapaNumeros.adicionar(2, "Dois");
        mapaNumeros.adicionar(3, "Três");

        // Exibir o mapa
        mapaNumeros.exibirMapa();
    }
}
