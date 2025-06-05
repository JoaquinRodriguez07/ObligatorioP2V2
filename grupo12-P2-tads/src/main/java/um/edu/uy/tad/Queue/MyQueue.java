package um.edu.uy.tad.Queue;

public interface MyQueue <T> {
    public void enqueue(T element);
    T dequeue() throws EmptyQueueException;
    boolean isEmpty();

}
