package um.edu.uy.tad.Queue;

public class QueueConPrioridad <T extends Comparable <T>> implements MyPriorityQueue<T> {

    private Nodo<T> head;
    private Nodo<T> tail;



    public QueueConPrioridad() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void enqueueWithPriority(T element, int prioridad) {

        Nodo<T> nuevoNodo = new Nodo<>(element);
        if(isEmpty()){
            head = nuevoNodo;
            tail = nuevoNodo;
        }else if( prioridad > head.getPrioridad()){

            nuevoNodo.setSiguiente(head);
            head = nuevoNodo;
            return;


        } else if (prioridad <= tail.getPrioridad()) {

            tail.setSiguiente(nuevoNodo);
            tail = nuevoNodo;
            return;

        } else  {

            Nodo<T> actual = head;
            while(actual.getSiguiente() != null && actual.getSiguiente().getPrioridad() >= prioridad){

                actual = actual.getSiguiente();

            }

            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }


    }

    @Override
    public void enqueue(T element) {

        Nodo<T> nuevoNodo = new Nodo<>(element);
        if(isEmpty()){
            head = nuevoNodo;
            tail = nuevoNodo;
        }
        else {
            enqueueWithPriority(element,  Integer.MIN_VALUE);
        }
    }

    @Override
    public T dequeue() throws EmptyQueueException {

        if(isEmpty()){
            throw new EmptyQueueException("La cola esta vacia");
        }

        T ValorOut = head.getValue();
        head = head.getSiguiente();
        return ValorOut;
    }

    @Override
    public boolean isEmpty() {
        return head ==null;
    }
}
