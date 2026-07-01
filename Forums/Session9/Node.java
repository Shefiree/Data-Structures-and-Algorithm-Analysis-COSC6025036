// tipe data berbentuk class untuk node
// karena linked list terdiri dari node-node yang saling terhubung : 
// [value:data, next: pointer ke node berikutnya]

public class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
