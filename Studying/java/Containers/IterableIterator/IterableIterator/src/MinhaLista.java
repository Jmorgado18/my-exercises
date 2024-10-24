import java.util.Iterator;
import java.util.NoSuchElementException;

// Classe personalizada que implementa Iterable
public class MinhaLista<T> implements Iterable<T> {
    private T[] elementos;
    private int tamanho;

    // Construtor
    @SuppressWarnings("unchecked")
    public MinhaLista(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    // Método para adicionar um elemento
    public void adicionar(T elemento) {
        if (tamanho < elementos.length) {
            elementos[tamanho++] = elemento;
        } else {
            System.out.println("Lista cheia, não é possível adicionar mais elementos.");
        }
    }

    // Implementação do método iterator da interface Iterable
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < tamanho; // Verifica se há mais elementos
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException(); // Lança exceção se não houver mais elementos
                }
                return elementos[indice++]; // Retorna o próximo elemento
            }
        };
    }

    public static void main(String[] args) {
        // Criar uma instância da MinhaLista
        MinhaLista<String> listaFrutas = new MinhaLista<>(5);
        listaFrutas.adicionar("Maçã");
        listaFrutas.adicionar("Banana");
        listaFrutas.adicionar("Laranja");

        // Usar for-each para iterar sobre a lista
        System.out.println("Iterando sobre a MinhaLista usando for-each:");
        for (String fruta : listaFrutas) {
            System.out.println(fruta);
        }
    }
}
