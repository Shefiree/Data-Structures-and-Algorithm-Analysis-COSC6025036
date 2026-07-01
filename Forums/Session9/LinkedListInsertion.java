
public class LinkedListInsertion {

    static public void insertAtHead(Node head, int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    static public void insertAtTail(Node head, int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    static public void insertAtSpecPos(Node head, int newData, int position) {
        Node newNode = new Node(newData);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < position - 1 && currentNode != null; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            System.out.println("Position is out of bounds");
            return;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

    static public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        insertAtHead(node, 0);
        insertAtTail(node, 2);
        insertAtSpecPos(node, 1, 1);

        printList(node);
    }
}