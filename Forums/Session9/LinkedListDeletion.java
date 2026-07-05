
public class LinkedListDeletion {
    static public Node deleteAtHead(Node head) {
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
        lastNode.next = head.next;
        return head.next;
    }

    static public Node deleteAtTail(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        if (head.next == null) {
            head = null;
            return null;
        }
        Node currentNode = head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        return head;
    }

    static public Node deleteAtSpecPos(Node head, int position) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        if (position == 0) {
            head = head.next;
            return head;
        }
        Node currentNode = head;
        for (int i = 0; i < position - 1 && currentNode != null; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode == null || currentNode.next == null) {
            System.out.println("Position is out of bounds");
            return head;
        }
        currentNode.next = currentNode.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        // panggil method insertAtHead, insertAtTail, dan insertAtSpecPos dari class
        // LinkedListInsertion
        LinkedListInsertion.insertAtHead(node, 1);
        LinkedListInsertion.insertAtTail(node, 2);
        LinkedListInsertion.insertAtTail(node, 3);
        LinkedListInsertion.insertAtTail(node, 4);
        LinkedListInsertion.insertAtTail(node, 5);
        LinkedListInsertion.insertAtTail(node, 6);
        System.out.println("Linked List sebelum penghapusan:");
        LinkedListInsertion.printList(node);

        System.out.println("\nHapus node di posisi 0 (head):");
        node = deleteAtHead(node);
        LinkedListInsertion.printList(node);

        System.out.println("\nHapus node di posisi terakhir (tail):");
        node = deleteAtTail(node);
        LinkedListInsertion.printList(node);

        System.out.println("\nHapus node di posisi 1 (posisi spesifik):");
        node = deleteAtSpecPos(node, 1);
        LinkedListInsertion.printList(node);
    }
}