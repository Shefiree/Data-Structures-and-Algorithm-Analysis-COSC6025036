package Session15;

public class CircukarQueue {
    private Object[] queueArray;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public CircukarQueue(int capacity) {
        this.capacity = capacity;
        queueArray = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(Object item) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = item;
        size++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object item = queueArray[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(queueArray[(front + i) % capacity]);
        }
    }

    public static void main(String[] args) {
        CircukarQueue queue = new CircukarQueue(5);

        queue.enqueue("Item 1");
        queue.enqueue("Item 2");
        queue.enqueue("Item 3");

        System.out.println("Queue contents:");
        queue.display();

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());

        System.out.println("Queue contents after dequeue:");
        queue.display();

    }

}
