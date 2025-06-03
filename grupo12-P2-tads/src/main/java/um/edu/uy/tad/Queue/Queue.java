package um.edu.uy.tad.Queue;

public class Queue <T extends Comparable <T>> implements MyQueue<T> {

    private Nodo <T> head;
    private Nodo<T> tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void enqueue(T element) {

        Nodo<T> nuevoNodo = new Nodo<>(element);
        if(isEmpty()) {
            head = nuevoNodo;
            tail = nuevoNodo;
        }else{
            tail.setSiguiente(nuevoNodo);
            tail = nuevoNodo;
        }

    }

    @Override
    public T dequeue() throws EmptyQueueException {

        if (isEmpty()) {
            throw new EmptyQueueException("La cola esta vacia");
        }

        T valorOut = head.getValue();
        head = head.getSiguiente();

        if (head == null) {
            tail = null;
        }
        return valorOut;


    }


    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public Nodo<T> getHead() {
        return head;
    }

    public void setHead(Nodo<T> head) {
        this.head = head;
    }

    public Nodo<T> getTail() {
        return tail;
    }

    public void setTail(Nodo<T> tail) {
        this.tail = tail;
    }
}
