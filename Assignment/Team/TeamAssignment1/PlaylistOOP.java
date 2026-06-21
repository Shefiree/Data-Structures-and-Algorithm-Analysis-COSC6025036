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

// Class utama yang public (harus sama dengan nama file)
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
                User userAdmin = admin; // Upcasting
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
                User userMember = member; // Upcasting
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

// ==========================================================
// CLASS LAGU (Nomor 1) - Tanpa modifier public
// ==========================================================
class Lagu {
    private String judul;
    private String artis;
    private double durasi;

    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getArtis() { return artis; }
    public void setArtis(String artis) { this.artis = artis; }

    public double getDurasi() { return durasi; }
    public void setDurasi(double durasi) { this.durasi = durasi; }

    public void tampilkanInfo() {
        System.out.println("Judul  : " + judul);
        System.out.println("Artis  : " + artis);
        System.out.println("Durasi : " + durasi + " menit");
    }
}

// ==========================================================
// CLASS USER (PARENT CLASS) - Nomor 2
// ==========================================================
class User {
    protected String nama;
    protected Lagu[] playlist;
    protected int jumlahLagu;

    public User(String nama, Lagu[] playlist, int jumlahLagu) {
        this.nama = nama;
        this.playlist = playlist;
        this.jumlahLagu = jumlahLagu;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public Lagu[] getPlaylist() { return playlist; }
    public int getJumlahLagu() { return jumlahLagu; }
    public void setJumlahLagu(int jumlahLagu) { this.jumlahLagu = jumlahLagu; }

    // Method yang akan di-override (Polymorphism)
    public void tampilkanAkses() {
        System.out.println("Akses Default - User: " + nama);
    }

    // Method umum yang diwariskan
    public void lihatDaftarLagu() {
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }
        System.out.println("\n===== Daftar Lagu =====");
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(playlist[i].getJudul() + " - " + playlist[i].getArtis()
                    + " (" + playlist[i].getDurasi() + " menit)");
        }
    }
}

// ==========================================================
// CLASS ADMIN (CHILD CLASS) - Nomor 2
// ==========================================================
class Admin extends User {

    public Admin(String nama, Lagu[] playlist, int jumlahLagu) {
        super(nama, playlist, jumlahLagu);
    }

    @Override
    public void tampilkanAkses() {
        System.out.println("=== Akses Admin ===");
        System.out.println("Selamat datang Admin : " + nama);
        System.out.println("Hak akses            : Menambahkan lagu baru & melihat daftar lagu.");
    }

    public int tambahLagu(String judul, String artis, double durasi) {
        if (jumlahLagu < playlist.length) {
            playlist[jumlahLagu] = new Lagu(judul, artis, durasi);
            jumlahLagu++;
            System.out.println("Lagu \"" + judul + "\" berhasil ditambahkan ke playlist!");
        } else {
            System.out.println("Playlist penuh! Tidak dapat menambahkan lagu lagi.");
        }
        return jumlahLagu;
    }
}

// ==========================================================
// CLASS MEMBER (CHILD CLASS) - Nomor 2
// ==========================================================
class Member extends User {

    public Member(String nama, Lagu[] playlist, int jumlahLagu) {
        super(nama, playlist, jumlahLagu);
    }

    @Override
    public void tampilkanAkses() {
        System.out.println("=== Akses Member ===");
        System.out.println("Selamat datang Member : " + nama);
        System.out.println("Hak akses             : Menelusuri, mencari lagu, & menghitung rata-rata durasi.");
    }

    public void cariLagu(String judul) {
        boolean ditemukan = false;
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.println("\n>> Lagu ditemukan!");
                playlist[i].tampilkanInfo();
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Lagu dengan judul \"" + judul + "\" tidak ditemukan.");
        }
    }

    public void lihatDetailLagu(int indeks) {
        if (indeks >= 0 && indeks < jumlahLagu) {
            System.out.println("\n>> Detail Lagu ke-" + (indeks + 1));
            playlist[indeks].tampilkanInfo();
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    public void hitungRataRataDurasi() {
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong, tidak ada durasi yang dihitung.");
            return;
        }
        double total = 0;
        for (int i = 0; i < jumlahLagu; i++) {
            total += playlist[i].getDurasi();
        }
        double rata = total / jumlahLagu;
        System.out.println("Total lagu            : " + jumlahLagu);
        System.out.println("Total durasi          : " + total + " menit");
        System.out.println("Rata-rata durasi lagu : " + rata + " menit");
    }
}