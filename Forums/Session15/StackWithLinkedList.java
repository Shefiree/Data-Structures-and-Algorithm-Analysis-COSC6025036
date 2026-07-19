package Session15;

public class StackWithLinkedList<T> {
    private Node<T> top;

    public StackWithLinkedList() {
        this.top = null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        Node<T> current = top;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}
