package Assignment.Team.TeamAssignment1;

import java.util.Scanner;

/*
NIM dan Nama Anggota Kelompok Group 2  :
- 2902800855 – Faisal Nur Arif
- 2902761311 – Mohamad Faizal Norhavid
- 2902800634 – Muhammad Kemal Ilyasa Margana
- 2902783136 – Sandy Maulana Malik Alghozy Sedyo Putra
- 2902773356 – Syafina Andiya Putri
*/

public class PlaylistOOP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inisialisasi array untuk menyimpan objek Lagu (kapasitas 100)
        Lagu[] playlist = new Lagu[100];
        int jumlahLagu = 0;

        // Membuat objek Admin dan Member yang berbagi array playlist yang sama
        Admin admin = new Admin("Admin Group 2", playlist, jumlahLagu);
        Member member = new Member("Member Group 2", playlist, jumlahLagu);

        boolean running = true;
        while (running) {
            System.out.println("\n========= SISTEM MANAJEMEN PLAYLIST =========");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Member");
            System.out.println("3. Keluar");
            System.out.print("Pilih peran : ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            if (pilihan == 1) {
                // ===== DEMO POLYMORPHISM =====
                // Reference bertipe parent (User) menunjuk ke objek child (Admin)
                // Saat tampilkanAkses() dipanggil, versi Admin yang akan tereksekusi.
                User userAdmin = admin;
                userAdmin.tampilkanAkses();

                boolean adminMode = true;
                while (adminMode) {
                    System.out.println("\n--- Menu Admin ---");
                    System.out.println("1. Tambah Lagu");
                    System.out.println("2. Lihat Daftar Lagu");
                    System.out.println("3. Logout");
                    System.out.print("Pilih : ");
                    int pil = sc.nextInt();
                    sc.nextLine();

                    if (pil == 1) {
                        System.out.print("Judul  : ");
                        String j = sc.nextLine();
                        System.out.print("Artis  : ");
                        String a = sc.nextLine();
                        System.out.print("Durasi (menit) : ");
                        double d = sc.nextDouble();
                        sc.nextLine();
                        // Tambah lagu dan update jumlahLagu agar sinkron di Admin & Member
                        jumlahLagu = admin.tambahLagu(j, a, d);
                        admin.setJumlahLagu(jumlahLagu);
                        member.setJumlahLagu(jumlahLagu);
                    } else if (pil == 2) {
                        admin.lihatDaftarLagu();
                    } else {
                        adminMode = false;
                    }
                }
            } else if (pilihan == 2) {
                // ===== DEMO POLYMORPHISM =====
                // Reference bertipe parent (User) menunjuk ke objek child (Member)
                User userMember = member;
                userMember.tampilkanAkses();

                boolean memberMode = true;
                while (memberMode) {
                    System.out.println("\n--- Menu Member ---");
                    System.out.println("1. Lihat Daftar Lagu");
                    System.out.println("2. Cari Lagu (berdasarkan judul)");
                    System.out.println("3. Lihat Detail Lagu (berdasarkan indeks)");
                    System.out.println("4. Hitung Rata-rata Durasi");
                    System.out.println("5. Logout");
                    System.out.print("Pilih : ");
                    int pil = sc.nextInt();
                    sc.nextLine();

                    if (pil == 1) {
                        member.lihatDaftarLagu();
                    } else if (pil == 2) {
                        System.out.print("Masukkan judul lagu : ");
                        String j = sc.nextLine();
                        member.cariLagu(j);
                    } else if (pil == 3) {
                        System.out.print("Masukkan indeks lagu (mulai dari 0) : ");
                        int i = sc.nextInt();
                        sc.nextLine();
                        member.lihatDetailLagu(i);
                    } else if (pil == 4) {
                        member.hitungRataRataDurasi();
                    } else {
                        memberMode = false;
                    }
                }
            } else if (pilihan == 3) {
                running = false;
                System.out.println("Terima kasih telah menggunakan sistem ini.");
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
        sc.close();
    }
}