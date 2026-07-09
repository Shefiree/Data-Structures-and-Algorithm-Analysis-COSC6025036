package Session14;

import java.util.List;

public class CircularDoublyLinkedList {

    static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }
        Node tail = head.prev;
        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;
        return newNode;
    }

    static Node insertAtTail(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }
        Node tail = head.prev;
        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;
        return head;
    }

    static Node insertAtSpecPos(Node head, int data, int position) {
        if (position == 0) {
            return insertAtHead(head, data);
        }
        Node newNode = new Node(data);
        Node currentNode = head;
        for (int i = 0; i < position - 1; i++) {
            currentNode = currentNode.next;
            if (currentNode == head) {
                System.out.println("Posisi tidak valid");
                return head;
            }
        }
        Node nextNode = currentNode.next;
        newNode.next = nextNode;
        newNode.prev = currentNode;
        currentNode.next = newNode;
        nextNode.prev = newNode;
        return head;
    }

    static Node deleteAtHead(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) {
            return null;
        }
        Node tail = head.prev;
        Node newHead = head.next;
        tail.next = newHead;
        newHead.prev = tail;
        return newHead;
    }

    static Node deleteAtTail(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) {
            return null;
        }
        Node tail = head.prev;
        Node newTail = tail.prev;
        newTail.next = head;
        head.prev = newTail;
        return head;
    }

    static Node deleteSpecPos(Node head, int position) {
        if (head == null) {
            return null;
        }
        if (position == 0) {
            return deleteAtHead(head);
        }
        Node currentNode = head;
        for (int i = 0; i < position; i++) {
            currentNode = currentNode.next;
            if (currentNode == head) {
                System.out.println("Posisi tidak valid");
                return head;
            }
        }
        Node prevNode = currentNode.prev;
        Node nextNode = currentNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        return head;
    }

    static void printList(Node head) {
        if (head == null) {
            return;
        }
        Node currentNode = head;
        do {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        } while (currentNode != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtHead(head, 1);
        head = insertAtTail(head, 3);
        head = insertAtTail(head, 4);
        head = insertAtTail(head, 5);
        head = insertAtTail(head, 6);
        head = insertAtSpecPos(head, 2, 1);
        System.out.println("List setelah insert:");
        printList(head);

        head = deleteAtHead(head);
        System.out.println("List setelah delete head:");
        printList(head);

        head = deleteAtTail(head);
        System.out.println("List setelah delete tail:");
        printList(head);

        head = deleteSpecPos(head, 1);
        System.out.println("List setelah delete posisi 1:");
        printList(head);
    }

}
