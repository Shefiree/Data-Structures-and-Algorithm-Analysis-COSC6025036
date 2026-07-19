package Assignment.Personal.PersonalAssignment1;

public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public T dequeueByName(String name) {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        Node<T> current = front;
        Node<T> previous = null;

        while (current != null) {
            if (current.data.toString().contains(name)) {
                if (previous == null) {
                    front = current.next;
                    if (front == null) {
                        rear = null;
                    }
                } else {
                    previous.next = current.next;
                    if (current.next == null) {
                        rear = previous;
                    }
                }
                return current.data;
            }
            previous = current;
            current = current.next;
        }

        throw new IllegalArgumentException("Pelanggan dengan nama " + name + " tidak ditemukan dalam antrian.");
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        Node<T> current = front;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void display() {
        Node<T> current = front;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}
