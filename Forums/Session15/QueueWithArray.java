package Session15;

public class QueueWithArray {
    private Object[] queueArray;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public QueueWithArray(int size) {
        queueArray = new Object[size];
        capacity = size;
        front = 0;
        rear = -1;
        this.size = 0;
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

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queueArray[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(queueArray[(front + i) % capacity]);
        }
    }

}
