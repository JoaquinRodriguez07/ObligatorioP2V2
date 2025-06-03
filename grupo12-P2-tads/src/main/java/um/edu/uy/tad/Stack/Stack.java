package um.edu.uy.tad.Stack;

public class Stack <T extends Comparable<T>> implements MyStack<T> {

    private Nodo<T> head;

    public Stack() {
        this.head = head;
    }

    @Override
    public void pop() throws EmptyStackException{

        if (this.head == null){
            throw new EmptyStackException();
        }

        this.head = this.head.getSiguiente();
    }

    @Override
    public T top() throws  EmptyStackException{

        if (this.head == null){
            throw new EmptyStackException();
        }

        return  this.head.getValue();
    }


    @Override
    public void push(T element){

        Nodo<T> nuevoNodo = new Nodo<>(element);
        nuevoNodo.setSiguiente(this.head);
        this.head = nuevoNodo;

    }

    @Override
    public boolean isEmpty(){

        if(this.head == null){
            System.out.println("La Pila esta vacía");
            return true;
        }else
            return false;
    }

    @Override
    public void makeEmpty(){

        this.head = null;
    }
}
