package ta_4_queue;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    // Queue berbasis LinkedList untuk menyimpan antrean pelanggan
    private Queue<String> antrean;

    // Constructor untuk membuat antrean kosong
    public CustomerQueue() {
        antrean = new LinkedList<>();
    }

    // Method untuk menambahkan pelanggan baru ke antrean
    public void tambahPelanggan(String nama) {
        antrean.add(nama);
        System.out.println(nama + " berhasil ditambahkan ke antrean.");
    }

    // Method untuk melayani pelanggan pertama dalam antrean
    public void layaniPelanggan() {
        if (antrean.isEmpty()) {
            System.out.println("Antrean kosong, tidak ada pelanggan yang dapat dilayani.");
        } else {
            String pelanggan = antrean.poll();
            System.out.println("Melayani pelanggan: " + pelanggan);
        }
    }

    // Method untuk menampilkan daftar pelanggan dalam antrean
    public void tampilkanAntrean() {
        if (antrean.isEmpty()) {
            System.out.println("Antrean kosong.");
        } else {
            System.out.println("Pelanggan dalam antrean:");
            int nomor = 1;

            for (String pelanggan : antrean) {
                System.out.println(nomor + ". " + pelanggan);
                nomor++;
            }
        }
    }
}