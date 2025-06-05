package um.edu.uy.tad.BinaryTree;

import um.edu.uy.p4.tadsAuxiliares.ArrayList.MiArrayList;
import um.edu.uy.p4.tadsAuxiliares.ArrayList.MiLista;

public interface MyTree <K,T> {



    T find(K key, BinaryNode<K, T> Nodo);

    void insert (K key, T data, K parentKey) throws ExistingChilds;
    void delete (K key);

    int size(BinaryNode<K,T> nodo);

    int countLeaf(BinaryNode<K,T> nodo);

    int countCompleteElements(BinaryNode<K,T> nodo);

    MiLista<K> recorridoPorNivel(BinaryNode<K,T> nodo);
}
