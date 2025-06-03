package um.edu.uy.tad.BinaryTree;

import um.edu.uy.tad.LinkedList.ListaEnlazada;
import um.edu.uy.tad.Queue.EmptyQueueException;
import um.edu.uy.tad.Queue.QueueListaEnlazada;
import um.edu.uy.tad.Stack.EmptyStackException;
import um.edu.uy.tad.Stack.Stack;

public class Tree<K, T> implements MyTree<K, T> {
    Node<K, T> Nodo = new Node<>();


    //tipos de orden------------------------------------------------------

    @Override
    public ListaEnlazada inOrder() {
        ListaEnlazada inOrder = new ListaEnlazada();
        inOrderAuxiliar(Nodo, inOrder);
        return inOrder;
    }

    private void inOrderAuxiliar(Node<K, T> node, ListaEnlazada inOrder) {
        if (node == null || node.getKey() == null) {
            return;
        }
        inOrderAuxiliar(node.getLeftChild(), inOrder);
        inOrder.addLast(node.getKey());
        inOrderAuxiliar(node.getRightChild(), inOrder);
    }

    @Override
    public ListaEnlazada preOrder() {
        ListaEnlazada preOrder = new ListaEnlazada();
        preOrderAuxiliar(Nodo, preOrder);
        return preOrder;

    }

    private void preOrderAuxiliar(Node<K, T> node, ListaEnlazada preOrder) {
        if (node == null || node.getKey() == null) {
            return;
        }
        preOrder.addLast(node.getKey());
        preOrderAuxiliar(node.getLeftChild(), preOrder);
        preOrderAuxiliar(node.getRightChild(), preOrder);
    }

    @Override
    public ListaEnlazada postOrder() {
        ListaEnlazada postOrder = new ListaEnlazada();
        postOrderAuxiliar(Nodo, postOrder);
        return postOrder;
    }

    private void postOrderAuxiliar(Node<K, T> node, ListaEnlazada postOrder) {
        if (node == null || node.getKey() == null) {
            return;
        }
        postOrderAuxiliar(node.getLeftChild(), postOrder);
        postOrderAuxiliar(node.getRightChild(), postOrder);
        postOrder.addLast(node.getKey());
    }

    @Override
    public ListaEnlazada levelOrder() throws EmptyQueueException {
        ListaEnlazada levelOrder = new ListaEnlazada();
        if (Nodo == null) {
            return levelOrder;
        }
        Node<K, T>[] lista = (Node<K, T>[]) new Node[100];
        QueueListaEnlazada<Node<K, T>> cola = new QueueListaEnlazada<>(lista);

        cola.enqueue(Nodo);

        while (!cola.isEmpty()) {
            Node<K, T> nodoDesencolado = cola.dequeue();
            levelOrder.addLast(nodoDesencolado.getKey());

            if (nodoDesencolado.getLeftChild() != null) {
                cola.enqueue(nodoDesencolado.getLeftChild());
            }
            if (nodoDesencolado.getRightChild() != null) {
                cola.enqueue(nodoDesencolado.getRightChild());
            }
        }
        return levelOrder;
    }

    //funciones-----------------------------------------------------------------------------

    @Override
    public T find(K key) {
        return buscarNodoData(Nodo, key);
    }

    private T buscarNodoData(Node<K, T> node, K Key) {
        if (node.getKey() == null){
            return null;
        }
        if (node.getKey().equals(Key)){
            return node.getData();
        }

        T busquedaLeft = buscarNodoData(node.getLeftChild(), Key);
        if (busquedaLeft != null){
            return busquedaLeft;
        }

        return buscarNodoData(node.getRightChild(), Key);
    }

    @Override
    public void insert(K key, T data, K parentKey) {
        Node<K, T> nodoPadre = buscarNodo(Nodo, parentKey);

        Node<K, T> nodo = new Node<>();
        nodo.setKey(key);
        nodo.setData(data);

        if (nodoPadre.getLeftChild() == null){
            nodoPadre.setLeftChild(nodo);
        }else if (nodoPadre.getRightChild() == null){
            nodoPadre.setRightChild(nodo);
        }else{
            System.out.println("ERROR: El nodo padre ya tiene asignado dos hijos");
        }
    }

    private Node<K, T> buscarNodo(Node<K, T> node, K Key) {
        if (node.getKey() == null){
            return null;
        }else if (node.getKey().equals(Key)){
            return node;
        }

        Node<K, T> busquedaLeft = buscarNodo(node.getLeftChild(), Key);
        if (busquedaLeft != null){
            return busquedaLeft;
        }
        return buscarNodo(node.getRightChild(), Key);
    }

    @Override
    public void delete(K key) {
        Node<K, T> nodo = buscarNodo(Nodo, key);
        if (nodo != null) {
            nodo = null;
        }
    }

    @Override
    public int size() {
        return contarNodo(Nodo);
    }

    private int contarNodo(Node<K, T> node) {
        if (node == null){
            return 0;
        }
        return 1 + contarNodo(node.getLeftChild()) + contarNodo(node.getRightChild());
    }

    @Override
    public int countLeaf() {
        return contarHojas(Nodo);
    }

    private int contarHojas(Node<K, T> node) {
        if (node == null){
            return 0;
        }
        if (node.getLeftChild() == null && node.getRightChild() == null){
            return 1;
        }
        return 1 + contarHojas(node.getLeftChild()) + contarHojas(node.getRightChild());
    }

    @Override
    public int countCompleteElements() {
        return contarNodosCompletos(Nodo);
    }

    private int contarNodosCompletos(Node<K, T> node) {
        if (node == null || (node.getLeftChild() == null || node.getRightChild() == null)){
            return 0;
        }

        return 1 + contarNodosCompletos(node.getLeftChild()) + contarNodosCompletos(node.getRightChild());
    }

    @Override
    public void loadPostFijaExpression(String sPostFija) throws EmptyStackException {
        Stack<Node<K, T>> stack = new Stack();
        for(int i = 0; i < sPostFija.length(); i++){
            char c = sPostFija.charAt(i);

            if (Character.isLetterOrDigit(c)){
                Node<K, T> nodo = new Node<>();
                nodo.setKey((K) (Character.toString(c)));
                nodo.setData(null);
                stack.push(nodo);
            }else{

                Node<K, T> hijoD = stack.top();
                stack.pop();
                Node<K, T> hijoI = stack.top();
                stack.pop();

                Node<K, T> nodo = new Node<>();
                nodo.setKey((K) (Character.toString(c)));
                nodo.setData(null);

                nodo.setLeftChild(hijoI);
                nodo.setRightChild(hijoD);

                stack.push(nodo);
            }
        }
        Nodo = stack.top();
    }
}
