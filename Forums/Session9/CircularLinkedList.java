
public class CircularLinkedList {
    static Node insertAtHeadCircular(Node head, int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node lastNode = head;
        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }

        newNode.next = head;
        lastNode.next = newNode;
        return newNode;
    }

    static Node insertAtTailCircular(Node head, int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node lastNode = head;
        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
        newNode.next = head;
        return head;
    }

    static Node insertAtSpecPosCircular(Node head, int newData, int position) {
        if (head == null || position <= 0) {
            return insertAtHeadCircular(head, newData);
        }

        Node currentNode = head;
        int index = 0;
        while (index < position - 1 && currentNode.next != head) {
            currentNode = currentNode.next;
            index++;
        }

        Node newNode = new Node(newData);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        return head;
    }

    static Node deleteAtHeadCircular(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }

        if (head.next == head) {
            return null;
        }

        Node lastNode = head;
        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }

        Node newHead = head.next;
        lastNode.next = newHead;
        return newHead;// Double node circular linked list
    }

    static Node deleteAtTailCircular(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }

        if (head.next == head) {
            return null;
        }

        Node currentNode = head;
        while (currentNode.next.next != head) {
            currentNode = currentNode.next;
        }

        currentNode.next = head;
        return head;
    }

    static Node deleteAtSpecPosCircular(Node head, int position) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }

        if (position == 0) {
            return deleteAtHeadCircular(head);
        }

        Node currentNode = head;
        int index = 0;
        while (index < position - 1 && currentNode.next != head) {
            currentNode = currentNode.next;
            index++;
        }

        if (currentNode.next == head) {
            System.out.println("Position is out of bounds");
            return head;
        }

        currentNode.next = currentNode.next.next;
        return head;
    }

    static void printCircularList(Node head) {
        if (head == null) {
            System.out.println("List is empty");
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
        // Single node circular linked list
        System.out.println("Single node circular linked list:");
        Node head = new Node(1);
        head.next = head; // Membuat linked list menjadi circular

        head = insertAtTailCircular(head, 2);
        head = insertAtTailCircular(head, 3);
        head = insertAtTailCircular(head, 4);

        printCircularList(head);

        head = deleteAtHeadCircular(head);
        System.out.println("\nCircular linked list setelah penghapusan head:");
        printCircularList(head);

    }

}