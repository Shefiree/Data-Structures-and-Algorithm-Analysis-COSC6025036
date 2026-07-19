package Session15;

public class Node2<T> {
    T data;
    int priority;
    Node2<T> next;

    public Node2(T data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }
}