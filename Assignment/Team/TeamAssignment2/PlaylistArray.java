package Assignment.Team.TeamAssignment2;

import java.util.Scanner;

/*
NIM dan Nama Anggota Kelompok Group 2  :
- 2902800855 – Faisal Nur Arif
- 2902761311 – Mohamad Faizal Norhavid
- 2902800634 – Muhammad Kemal Ilyasa Margana
- 2902783136 – Sandy Maulana Malik Alghozy Sedyo Putra
- 2902773356 – Syafina Andiya Putri
*/

public class PlaylistArray {
    static Scanner sc = new Scanner(System.in);

    public static void urutkanLaguBerdasarkanDurasi(Lagu[] playlist) {
        for (int i = 0; i < playlist.length - 1; i++) { // asc sort menggunakan bubble sortting
            for (int j = 0; j < playlist.length - i - 1; j++) {
                // Cek jika index j pada arr playlis null, maka geser ke kanan null
                if (playlist[j] == null) {
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
                // Jika keduanya tidak null, maka bandingkan nilainya
                else if (playlist[j + 1] != null && playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    // Tukar posisi jika durasi kiri lebih besar dari kanan ke Besar
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }

        System.out.println("Playlist sudah tersorting berdasarkan durasi");
        System.out.println("---------------------\n");

        for (Lagu lagu : playlist) { // cetak lagu yang sudah tersortirr
            if (lagu != null) {
                lagu.tampilkanInfo();
            }
        }
    }

    public static void tampilkanSemuaLagu(Lagu[] playlist) {
        char isSorted;
        System.out.println("\nTraversal Lagu");
        System.out.println("---------------------");
        for (Lagu lagu : playlist) { // menggunakan looping foreach untuk memanggil function tampilkaninfo() dari
                                     // class lagu
            if (lagu != null) {
                lagu.tampilkanInfo();
            }
        }
        System.out.println("---------------------\n");
        System.out.println("Urutkan Lagu berdasarkan Durasi ? (y/n)");
        isSorted = sc.next().charAt(0);
        if (isSorted == 'y' || isSorted == 'Y') // pilihan untuk user apakah mau di sort berdasarkan durasi
            urutkanLaguBerdasarkanDurasi(playlist);

    }

    public static void main(String[] args) {

        Lagu[] playlist = new Lagu[10];
        playlist[0] = new Lagu("aaa", "aaa", 15);
        playlist[1] = new Lagu("aaa", "aaa", 9);

        int pilihan;
        do {
            System.out.println("---  Menu Playlist Musik  ---");
            System.out.println("1. Tampilkan Semua Lagu");
            System.out.println("2. Tambah Lagu Baru");
            System.out.println("3. Hapus Lagu Berdasarkan Judul");
            System.out.println("4. Cari Lagu Berdasarkan Judul");
            System.out.println("5. Keluar");
            System.out.print("Pilih : ");
            pilihan = sc.nextInt();
            sc.nextLine();
            switch (pilihan) {
                case 1:
                    tampilkanSemuaLagu(playlist);
                    break;
                case 2:
                    System.out.println("2. Tambah Lagu Baru");
                    break;
                case 3:
                    System.out.println("3. Hapus Lagu Berdasarkan Judul");
                    break;
                case 4:
                    System.out.println("4. Cari Lagu Berdasarkan Judul");
                    break;
                case 5:
                    System.out.println("5. Keluar");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }

        } while (pilihan != 5);
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

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public double getDurasi() {
        return durasi;
    }

    public void setDurasi(double durasi) {
        this.durasi = durasi;
    }

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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Lagu[] getPlaylist() {
        return playlist;
    }

    public int getJumlahLagu() {
        return jumlahLagu;
    }

    public void setJumlahLagu(int jumlahLagu) {
        this.jumlahLagu = jumlahLagu;
    }

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
