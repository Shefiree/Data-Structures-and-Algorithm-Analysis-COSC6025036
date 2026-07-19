package Session15;

public class Node<T> {
    public T data;
    Node<T> next;

    public Node() {
    }

    public Node(T d) {
        data = d;
        next = null;
    }

}
