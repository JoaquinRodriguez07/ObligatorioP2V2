package um.edu.uy.tad.Stack;

public class EmptyStackException extends RuntimeException{

    public EmptyStackException(){
        super("La pila esta vacía");
    }
}
