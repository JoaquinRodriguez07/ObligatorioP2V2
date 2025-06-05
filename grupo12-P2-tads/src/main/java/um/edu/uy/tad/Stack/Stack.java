package um.edu.uy.tad.Stack;

public class Stack<T extends Comparable<T>> implements MyStack<T> {

    private Nodo<T> head;
    private int size = 0; // <-- contador de elementos

    public Stack() {
        this.head = null;
        this.size = 0;
    }

    public Stack(Nodo<T> head) {
        this.head = head;
        this.size = calcularTamanioDesde(head);
    }

    private int calcularTamanioDesde(Nodo<T> nodo) {
        int count = 0;
        while (nodo != null) {
            count++;
            nodo = nodo.getSiguiente();
        }
        return count;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (this.head == null) {
            throw new EmptyStackException();
        }

        T value = this.head.getValue();
        this.head = this.head.getSiguiente();
        size--;
        return value;
    }

    @Override
    public T top() throws EmptyStackException {
        if (this.head == null) {
            throw new EmptyStackException();
        }
        return this.head.getValue();
    }

    @Override
    public void push(T element) {
        Nodo<T> nuevoNodo = new Nodo<>(element);
        nuevoNodo.setSiguiente(this.head);
        this.head = nuevoNodo;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void makeEmpty() {
        this.head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }




}

