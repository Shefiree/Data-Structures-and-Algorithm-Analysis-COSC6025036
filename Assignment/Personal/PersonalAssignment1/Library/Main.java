package Assignment.Personal.PersonalAssignment1.Library;

import Assignment.Personal.PersonalAssignment1.BaseMenu;
import Assignment.Personal.PersonalAssignment1.Node;
import Assignment.Personal.PersonalAssignment1.SingleLinkedlist;

public class Main extends BaseMenu {
    private Node<Book> head = new Node<>(null);

    @Override
    protected void displayMenuName() {
        System.out.println("=== Menu Perpustakaan ===");
    }

    @Override
    protected void displayOptions() {
        System.out.println("1. Tambah Buku");
        System.out.println("2. Hapus Buku");
        System.out.println("3. Lihat Semua Buku");
        System.out.println("4. Cari Buku");
        System.out.println("5. Exit");
    }

    @Override
    protected boolean handleInput(String input) {
        int size = 0;
        switch (input) {
            case "1":
                boolean keepInserting = true;
                while (keepInserting) {
                    System.out.println("=== Insert Book ===");
                    System.out.print("Masukan kode buku: ");
                    String code = sc.nextLine();
                    if (code.length() > 5) {
                        System.out.println("Kode buku tidak boleh lebih dari 5 karakter.");
                        if (size < 5) {
                            System.out.println("Anda harus menambahkan setidaknya 5 buku.");
                            continue;
                        } else {
                            keepInserting = false;
                            break;
                        }
                    }
                    System.out.print("Masukan judul buku: ");
                    String title = sc.nextLine();
                    System.out.print("Masukan penulis buku: ");
                    String author = sc.nextLine();
                    Node<Book> newBookNode = new Node<>(new Book(code, title, author));
                    SingleLinkedlist.Insertion(head, newBookNode.data);

                    size = SingleLinkedlist.getSize(head);
                    System.out.println("Buku berhasil ditambahkan. Total buku: " + size);

                    System.out.print("Apakah Anda ingin menambahkan buku lain? (y/n): ");
                    String choice = sc.nextLine();
                    if (!choice.equalsIgnoreCase("y") && size < 5) {
                        System.out.println("Anda harus menambahkan setidaknya 5 buku.");
                        keepInserting = true;
                    } else if (!choice.equalsIgnoreCase("y")) {
                        keepInserting = false;
                    }
                }
                break;
            case "2":
                System.out.print("Masukan kode buku yg akan dihapus : ");
                String deleteCode = sc.nextLine();
                SingleLinkedlist.Deletion(head, deleteCode);
                System.out.println("Buku dengan kode " + deleteCode + " berhasil dihapus.");
                break;
            case "3":
                System.out.println("Traversal buku");
                SingleLinkedlist.Traverse(head);
                break;
            case "4":
                System.out.print("Masukan kode buku yg ingin dicari : ");
                String searchCode = sc.nextLine();
                Book foundedBook = SingleLinkedlist.LinearSearch(head, searchCode);
                if (foundedBook != null) {
                    System.out.println("Buku ditemukan: " + foundedBook);
                } else {
                    System.out.println("Buku dengan kode " + searchCode + " tidak ditemukan.");
                }
                break;
            case "5":
                return false;
            default:
                System.out.println("Menu tidak valid. Silakan pilih opsi yang tersedia.");
                break;
        }
        return true;
    }

    public static void main(String[] args) {
        Main menu = new Main();
        menu.run();
    }

}