package um.edu.uy.tad.ArrayList;

public interface MiLista<T> {
    void add(T elemento);
    T get(int indice);
    void set(int indice, T elemento);
    T remove(int indice);
    int size();
    boolean isEmpty();
    void clear();
    boolean contains(T elemento);
    int indexOf(T elemento);

    void addAll(MiLista<T> otraPila);
}