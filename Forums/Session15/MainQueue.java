package Session15;

public class MainQueue {
    public static void main(String[] args) {
        System.out.println("=== Queue dengan Linked List ===");
        QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();

        // Menambahkan elemen ke dalam antrian
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Menampilkan elemen-elemen dalam antrian
        System.out.println("Elemen-elemen dalam antrian:");
        queue.display();

        // Menghapus elemen dari antrian
        System.out.println("Menghapus elemen: " + queue.dequeue());
        System.out.println("Elemen-elemen dalam antrian setelah dequeue:");
        queue.display();

        System.out.println("\n=== Queue dengan Array ===");
        QueueWithArray queueArray = new QueueWithArray(5);
        // Menambahkan elemen ke dalam antrian
        queueArray.enqueue(100);
        queueArray.enqueue(200);
        queueArray.enqueue(300);

        // Menampilkan elemen-elemen dalam antrian
        System.out.println("Elemen-elemen dalam antrian:");
        queueArray.display();
        // Menghapus elemen dari antrian
        System.out.println("Menghapus elemen: " + queueArray.dequeue());
        System.out.println("Elemen-elemen dalam antrian setelah dequeue:");
        queueArray.display();
    }
}
