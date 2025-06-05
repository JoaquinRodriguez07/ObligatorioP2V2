package um.edu.uy.tad.BinaryTree;

public class BinaryNode <K,T> implements Comparable<BinaryNode<K, T>> {

    private K key;
    private T data;
    private BinaryNode<K, T> leftChild;
    private BinaryNode<K, T> rightChild;

    public BinaryNode(K key, T data, BinaryNode<K, T> leftChild, BinaryNode<K, T> rightChild) {
        this.key = key;
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(BinaryNode<K, T> o) {
        return 0;
    }
}
