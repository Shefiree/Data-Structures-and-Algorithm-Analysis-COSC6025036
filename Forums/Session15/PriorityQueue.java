package Session15;

public class PriorityQueue<T> {

    private Node2<T> front;
    private Node2<T> rear;

    private int size;

    public PriorityQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T data, int priority) {
        Node2<T> newNode = new Node2<>(data, priority);

        if (isEmpty()) {
            front = rear = newNode;
        }
        // Prioritas lebih tinggi dari front
        else if (priority > front.priority) {
            newNode.next = front;
            front = newNode;
        } else {
            Node2<T> current = front;

            while (current.next != null &&
                    current.next.priority >= priority) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;

            if (newNode.next == null) {
                rear = newNode;
            }
        }

        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }

        T data = front.data;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }

        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Priority Queue kosong.");
            return;
        }

        Node2<T> current = front;

        while (current != null) {
            System.out.println(
                    current.data + " (Priority: " + current.priority + ")");
            current = current.next;
        }
    }

    public static void main(String[] args) {

        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.enqueue("Andi", 2);
        pq.enqueue("Budi", 5);
        pq.enqueue("Caca", 1);
        pq.enqueue("Deni", 4);
        pq.enqueue("Eka", 3);

        System.out.println("Isi Priority Queue:");
        pq.display();

        System.out.println("\nPeek : " + pq.peek());

        System.out.println("\nDequeue : " + pq.dequeue());

        System.out.println("\nSetelah dequeue:");
        pq.display();

        System.out.println("\nJumlah data : " + pq.getSize());
    }
}