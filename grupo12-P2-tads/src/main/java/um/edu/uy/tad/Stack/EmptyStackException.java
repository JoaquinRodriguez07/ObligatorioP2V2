package um.edu.uy.tad.Stack;

public class EmptyStackException extends Exception{

    public EmptyStackException(){
        super("La pila esta vacía");
    }
}
