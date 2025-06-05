package um.edu.uy.tad.Stack;

public class Nodo<T extends Comparable<T>> {
    private T value;
    private Nodo<T> siguiente;
    private Nodo<T> anterior;

    public Nodo(T value) {
        this.value = value;
        this.siguiente = null;
        this.anterior = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }



}
