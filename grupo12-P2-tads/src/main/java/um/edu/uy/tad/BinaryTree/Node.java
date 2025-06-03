package um.edu.uy.tad.BinaryTree;

public class Node<K, T> implements Comparable<Node<K, T>> {
    private K key;
    private T data;

    private Node<K, T> leftChild;
    private Node<K, T> rightChild;

    public K getKey() {
        return key;
    }

    public T getData() {
        return data;
    }

    public Node<K, T> getLeftChild() {
        return leftChild;
    }

    public Node<K, T> getRightChild() {
        return rightChild;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeftChild(Node<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<K, T> rightChild) {
        this.rightChild = rightChild;
    }
}
