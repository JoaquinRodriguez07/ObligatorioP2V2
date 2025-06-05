package um.edu.uy.tad.LinkedList;

public interface Lista<T extends Comparable<T>> {
     public void add(T value);
     public void remove(int posicion);
     public T get(int posicion);
     public void visualizar(ListaEnlazada<Integer> P);


}
