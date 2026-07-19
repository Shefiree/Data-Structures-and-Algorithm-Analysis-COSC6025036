package Assignment.Personal.PersonalAssignment1.Cashier;

import Assignment.Personal.PersonalAssignment1.BaseMenu;
import Assignment.Personal.PersonalAssignment1.Queue;
import Assignment.Personal.PersonalAssignment1.Stack;

public class Main extends BaseMenu {
    private Queue<Transaction> antrian = new Queue<>();
    private Stack<Transaction> riwayatTransaksi = new Stack<>();
    private int nomorBerikutnya = 1;

    @Override
    protected void displayMenuName() {
        System.out.println("=== Menu Kasir ===");
    }

    @Override
    protected void displayOptions() {
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Layani Pelanggan");
        System.out.println("3. Lihat Antrian");
        System.out.println("4. Lihat Riwayat Transaksi");
        System.out.println("5. Keluar");
    }

    @Override
    protected boolean handleInput(String input) {
        switch (input) {
            case "1":
                boolean keepAdding = true;

                while (keepAdding) {
                    int nomorAntrian = nomorBerikutnya++;

                    System.out.println("=== Tambah Antrian ===");
                    System.out.print("Masukan nama pelanggan: ");
                    String namaPelanggan = sc.nextLine();

                    System.out.print("Masukan total belanja: ");
                    double totalBelanja = Double.parseDouble(sc.nextLine());

                    Transaction transaction = new Transaction(
                            nomorAntrian,
                            namaPelanggan,
                            totalBelanja);

                    antrian.enqueue(transaction);
                    System.out.println("Total antrian: " + antrian.getSize());

                    System.out.print("Apakah ingin menambah antrian lagi? (y/n): ");
                    String choice = sc.nextLine();
                    if (!choice.equalsIgnoreCase("y")) {
                        if (antrian.getSize() < 5) {
                            System.out.println("Minimal harus ada 5 pelanggan dalam antrian.");
                        } else {
                            keepAdding = false;
                        }
                    }
                }
                break;
            case "2":
                System.out.println("=== Layani Pelanggan ===");
                System.out.print("Masukkan nama pelanggan yang ingin dilayani: ");
                String namaPelanggan = sc.nextLine();
                if (antrian.isEmpty()) {
                    System.out.println("Tidak ada pelanggan dalam antrian.");
                } else {
                    Transaction servedTransaction = antrian.dequeueByName(namaPelanggan);
                    riwayatTransaksi.push(servedTransaction);
                    System.out.println("Pelanggan " + servedTransaction.namaCustomer + " telah dilayani.");
                }
                break;
            case "3":
                System.out.println("=== Lihat Antrian ===");
                antrian.display();
                break;
            case "4":
                System.out.println("=== Lihat Riwayat Transaksi ===");
                riwayatTransaksi.display();
                break;
            case "5":
                System.out.println("Keluar dari menu kasir.");
                return false;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }

        return true;
    }

    public static void main(String[] args) {
        Main menu = new Main();
        menu.run();
    }

}
