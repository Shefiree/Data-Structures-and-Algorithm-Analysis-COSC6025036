package Assignment.Personal.PersonalAssignment1;

public class Node<T> {
    public T data;
    Node<T> next;

    // agar node bisa diinisialisasi tanpa data, perlu menambahkan constructor
    // default
    public Node() {
    }

    public Node(T d) {
        data = d;
        next = null;
    }

}
