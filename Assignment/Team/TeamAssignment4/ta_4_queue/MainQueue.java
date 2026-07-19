package ta_4_queue;

import java.util.Scanner;

public class MainQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CustomerQueue customerQueue = new CustomerQueue();

        int pilihan;

        do {
            System.out.println();
            System.out.println("=== Sistem Manajemen Antrean Customer Service ===");
            System.out.println("1. Tambah Pelanggan Baru");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Daftar Antrean");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // membersihkan enter setelah input angka

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = input.nextLine();

                    long startTambah = System.nanoTime();
                    customerQueue.tambahPelanggan(nama);
                    long endTambah = System.nanoTime();

                    System.out.println("Waktu eksekusi tambah pelanggan: " + (endTambah - startTambah) + " ns");
                    break;

                case 2:
                    long startLayani = System.nanoTime();
                    customerQueue.layaniPelanggan();
                    long endLayani = System.nanoTime();

                    System.out.println("Waktu eksekusi layani pelanggan: " + (endLayani - startLayani) + " ns");
                    break;

                case 3:
                    long startTampil = System.nanoTime();
                    customerQueue.tampilkanAntrean();
                    long endTampil = System.nanoTime();

                    System.out.println("Waktu eksekusi tampilkan antrean: " + (endTampil - startTampil) + " ns");
                    break;

                case 4:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu 1-4.");
                    break;
            }

        } while (pilihan != 4);

        input.close();
    }
}
