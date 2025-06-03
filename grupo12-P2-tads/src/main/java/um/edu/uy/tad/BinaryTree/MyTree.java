package um.edu.uy.tad.BinaryTree;

import um.edu.uy.tad.LinkedList.ListaEnlazada;
import um.edu.uy.tad.Queue.EmptyQueueException;
import um.edu.uy.tad.Stack.EmptyStackException;

public interface MyTree<K, T> {
    ListaEnlazada inOrder();
    ListaEnlazada preOrder();
    ListaEnlazada postOrder();
    ListaEnlazada levelOrder() throws EmptyQueueException;


    T find(K key);

    void insert (K key, T data, K parentKey);

    void delete(K key);

    int size();

    int countLeaf();

    int countCompleteElements();

    void loadPostFijaExpression(String sPostFija) throws EmptyStackException;
}
