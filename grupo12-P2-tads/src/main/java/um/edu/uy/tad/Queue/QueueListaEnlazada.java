package um.edu.uy.tad.Queue;

public class QueueListaEnlazada<T> implements MyQueue<T> {
    private final T[] lista;
    private final int capacidad;
    private int elemento = -1;

    public QueueListaEnlazada(T[] lista) {
        this.lista = lista;
        this.capacidad = lista.length;
    }


    @Override
    public void enqueue(T element) {
        if(elemento == capacidad - 1) {
            throw new RuntimeException("La cola esta llena");
        }

        elemento++;
        lista[elemento] = element;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(elemento == -1) {
            throw new EmptyQueueException("");
        }

        T salida = lista[0];

        for (int i = 0; i < elemento; i++) {
            lista[i] = lista[i + 1];
        }

        lista[elemento] = null;
        elemento--;
        return salida;
    }

    @Override
    public boolean isEmpty() {
        return elemento == -1;
    }
}
