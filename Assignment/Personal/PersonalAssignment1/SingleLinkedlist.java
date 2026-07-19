package Assignment.Personal.PersonalAssignment1;

import Assignment.Personal.PersonalAssignment1.Library.Book;

public class SingleLinkedlist {
    public static <T> void Insertion(Node<T> head, T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public static void Deletion(Node<Book> head, String kode) {
        Node<Book> current = head;

        while (current.next != null) {
            if (current.next.data.getKode().equals(kode)) {
                current.next = current.next.next;
                System.out.println("Buku berhasil dihapus.");
                return;
            }
            current = current.next;
        }

        System.out.println("Buku tidak ditemukan.");
    }

    public static <T> void Traverse(Node<T> head) {
        Node<T> current = head.next;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static Book LinearSearch(Node<Book> head, String target) {
        Node<Book> current = head.next;
        int index = 0;

        while (current != null) {
            if (current.data.getKode().equals(target)) {
                System.out.println("Element ditemukan pada index: " + index);
                return current.data;
            }

            current = current.next;
            index++;
        }

        System.out.println("Element tidak ditemukan");
        return null;

    }

    public static <T> int getSize(Node<T> head) {
        Node<T> current = head.next;
        int size = 0;

        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }
}
