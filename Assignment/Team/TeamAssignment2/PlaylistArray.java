package Assignment.Team.TeamAssignment2;

import java.util.Scanner;

/*
NIM dan Nama Anggota Kelompok Group 2:
- 2902800855 – Faisal Nur Arif
- 2902761311 – Mohamad Faizal Norhavid
- 2902800634 – Muhammad Kemal Ilyasa Margana
- 2902783136 – Sandy Maulana Malik Alghozy Sedyo Putra
- 2902773356 – Syafina Andiya Putri
*/

public class PlaylistArray {
    static Scanner sc = new Scanner(System.in);
    static int jumlahLagu = 0; // Melacak jumlah lagu yang tersimpan di array

    /* ================================================================
     * OPERASI 1: TRAVERSAL (Penelusuran)
     * Menelusuri setiap elemen array dari indeks 0 hingga jumlahLagu-1
     * dan menampilkan informasi setiap lagu menggunakan looping.
     * ================================================================ */

    /**
     * Method untuk menelusuri (Traversal) dan menampilkan semua lagu dalam playlist.
     * @param playlist Array of Lagu yang berisi kumpulan lagu.
     */
    public static void tampilkanSemuaLagu(Lagu[] playlist) {
        char isSorted;

        System.out.println("\n==================================================");
        System.out.println("           TRAVERSAL - Daftar Lagu");
        System.out.println("==================================================");

        if (jumlahLagu == 0) {
            System.out.println(">> Playlist masih kosong.");
        } else {
            // TRAVERSAL: loop melalui setiap elemen array
            for (int i = 0; i < jumlahLagu; i++) {
                System.out.println("Lagu ke-" + (i + 1));
                playlist[i].tampilkanInfo();
                System.out.println("--------------------------------------------------");
            }
        }

        System.out.println("Total lagu saat ini: " + jumlahLagu);
        System.out.print("Urutkan Lagu berdasarkan Durasi? (y/n): ");
        isSorted = sc.next().charAt(0);
        sc.nextLine(); // consume newline

        if (isSorted == 'y' || isSorted == 'Y') {
            urutkanLaguBerdasarkanDurasi(playlist);
        }
    }

    /**
     * Method untuk mengurutkan lagu berdasarkan durasi menggunakan Bubble Sort (Ascending).
     * @param playlist Array of Lagu yang akan diurutkan.
     */
    public static void urutkanLaguBerdasarkanDurasi(Lagu[] playlist) {
        for (int i = 0; i < jumlahLagu - 1; i++) {
            for (int j = 0; j < jumlahLagu - i - 1; j++) {
                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }

        System.out.println("\n==================================================");
        System.out.println("      Playlist Sudah Tersorting (Ascending)");
        System.out.println("==================================================");
        for (int i = 0; i < jumlahLagu; i++) {
            playlist[i].tampilkanInfo();
            System.out.println("--------------------------------------------------");
        }
    }

    /* ================================================================
     * OPERASI 2: SEARCHING (Pencarian)
     * Linear Search - mencari lagu berdasarkan judul.
     * ================================================================ */

    /**
     * Method untuk mencari lagu berdasarkan judul (Searching).
     * @param playlist Array of Lagu sebagai tempat pencarian.
     * @param judul Judul lagu yang dicari.
     */
    public static void cariLaguBerdasarkanJudul(Lagu[] playlist, String judul) {
        System.out.println("\n==================================================");
        System.out.println("           SEARCHING - Cari Lagu");
        System.out.println("==================================================");
        System.out.println("Mencari lagu dengan judul: \"" + judul + "\"");
        System.out.println("--------------------------------------------------");

        boolean ditemukan = false;

        // LINEAR SEARCH: telusuri setiap elemen array satu per satu
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.println(">> Lagu DITEMUKAN pada indeks ke-" + i);
                playlist[i].tampilkanInfo();
                ditemukan = true;
                break; // Berhenti setelah ditemukan
            }
        }

        if (!ditemukan) {
            System.out.println(">> Maaf, lagu dengan judul \"" + judul + "\" TIDAK DITEMUKAN.");
        }
        System.out.println("==================================================\n");
    }

    /* ================================================================
     * OPERASI 3: INSERTION (Penyisipan)
     * Menyisipkan lagu baru ke dalam array pada indeks terakhir.
     * ================================================================ */

    /**
     * Method untuk menambahkan lagu baru ke dalam array (Insertion).
     * @param playlist Array of Lagu tempat lagu baru akan disisipkan.
     */
    public static void tambahLaguBaru(Lagu[] playlist) {
        System.out.println("\n==================================================");
        System.out.println("           INSERTION - Tambah Lagu Baru");
        System.out.println("==================================================");

        if (jumlahLagu >= playlist.length) {
            System.out.println(">> Playlist penuh! Tidak dapat menambahkan lagu lagi.");
            return;
        }

        System.out.print("Masukkan Judul Lagu : ");
        String judul = sc.nextLine();
        System.out.print("Masukkan Nama Artis : ");
        String artis = sc.nextLine();
        System.out.print("Masukkan Durasi (menit): ");
        double durasi = sc.nextDouble();
        sc.nextLine(); // consume newline

        // INSERTION: sisipkan objek Lagu baru pada indeks jumlahLagu
        playlist[jumlahLagu] = new Lagu(judul, artis, durasi);
        System.out.println("--------------------------------------------------");
        System.out.println(">> Lagu \"" + judul + "\" berhasil disisipkan pada indeks ke-" + jumlahLagu);
        jumlahLagu++;
        System.out.println(">> Total lagu dalam playlist: " + jumlahLagu);
        System.out.println("==================================================\n");
    }

    // ================================================================
    // MAIN METHOD
    // ================================================================
    public static void main(String[] args) {
        // Inisialisasi array dengan kapasitas 10
        Lagu[] playlist = new Lagu[10];

        // Data awal (Seeding)
        playlist[jumlahLagu++] = new Lagu("Bohemian Rhapsody", "Queen", 5.55);
        playlist[jumlahLagu++] = new Lagu("Imagine", "John Lennon", 3.03);
        playlist[jumlahLagu++] = new Lagu("Hotel California", "Eagles", 6.30);

        // ===== Demonstrasi OOP: Inheritance & Polymorphism =====
        System.out.println("\n==================================================");
        System.out.println("         SISTEM MANAJEMEN PLAYLIST MUSIK");
        System.out.println("==================================================");

        Admin admin = new Admin("Admin MusicApp", playlist, jumlahLagu);
        Member member = new Member("Guest User", playlist, jumlahLagu);

        admin.tampilkanAkses();
        System.out.println("--------------------------------------------------");
        member.tampilkanAkses();
        System.out.println("==================================================\n");

        // Variabel untuk menyimpan pilihan menu
        int pilihan;

        // Struktur perulangan Do-While untuk Menu Interaktif
        do {
            System.out.println("===============  MENU UTAMA  ===============");
            System.out.println("1. Tampilkan Semua Lagu   (Traversal)");
            System.out.println("2. Tambah Lagu Baru       (Insertion)");
            System.out.println("3. Hapus Lagu Berdasarkan Judul (Deletion)");
            System.out.println("4. Cari Lagu              (Searching)");
            System.out.println("5. Keluar");
            System.out.println("============================================");
            System.out.print("Pilih Menu [1-5]: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // Menangkap karakter newline (enter)

            // Struktur percabangan Switch-Case untuk operasi menu
            switch (pilihan) {
                case 1:
                    tampilkanSemuaLagu(playlist);
                    break;
                case 2:
                    tambahLaguBaru(playlist);
                    break;
                case 3:
                    System.out.print("Masukkan judul lagu yang ingin dihapus: ");

                    break;
                case 4:
                    System.out.print("Masukkan judul lagu yang ingin dicari: ");
                    cariLaguBerdasarkanJudul(playlist, sc.nextLine());
                    break;
                case 5:
                    System.out.println("\n>> Terima kasih telah menggunakan aplikasi!");
                    break;
                default:
                    System.out.println("\n>> Pilihan tidak valid! Silakan masukkan angka 1-5.\n");
                    break;
            }
        } while (pilihan != 5);

        sc.close(); // Menutup scanner untuk mencegah resource leak
    }
}

// ==========================================================
// CLASS LAGU (Nomor 1) - Class untuk merepresentasikan objek Lagu
// ==========================================================
class Lagu {
    private String judul;
    private String artis;
    private double durasi;

    /**
     * Constructor untuk membuat objek Lagu baru.
     */
    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // Getters dan Setters
    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getArtis() { return artis; }
    public void setArtis(String artis) { this.artis = artis; }

    public double getDurasi() { return durasi; }
    public void setDurasi(double durasi) { this.durasi = durasi; }

    /**
     * Method untuk menampilkan informasi detail lagu.
     */
    public void tampilkanInfo() {
        System.out.println("Judul  : " + judul);
        System.out.println("Artis  : " + artis);
        System.out.println("Durasi : " + durasi + " menit");
    }
}

// ==========================================================
// CLASS USER (PARENT CLASS) - Nomor 2
// Menerapkan konsep Inheritance (Pewarisan)
// ==========================================================
class User {
    protected String nama;
    protected Lagu[] playlist;
    protected int jumlahLagu;

    /**
     * Constructor Parent Class User.
     */
    public User(String nama, Lagu[] playlist, int jumlahLagu) {
        this.nama = nama;
        this.playlist = playlist;
        this.jumlahLagu = jumlahLagu;
    }

    // Getters dan Setters
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public Lagu[] getPlaylist() { return playlist; }

    public int getJumlahLagu() { return jumlahLagu; }
    public void setJumlahLagu(int jumlahLagu) { this.jumlahLagu = jumlahLagu; }

    /**
     * Method yang akan di-override oleh child class (Polymorphism).
     */
    public void tampilkanAkses() {
        System.out.println("Akses Default - User: " + nama);
    }

    /**
     * Method umum yang diwariskan untuk melihat daftar lagu.
     */
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
// Mewarisi class User
// ==========================================================
class Admin extends User {

    /**
     * Constructor untuk Admin.
     */
    public Admin(String nama, Lagu[] playlist, int jumlahLagu) {
        super(nama, playlist, jumlahLagu);
    }

    /**
     * Override method tampilkanAkses untuk hak akses Admin.
     */
    @Override
    public void tampilkanAkses() {
        System.out.println("=== Akses Admin ===");
        System.out.println("Selamat datang Admin : " + nama);
        System.out.println("Hak akses            : Menambahkan lagu baru & melihat daftar lagu.");
    }

    /**
     * Method untuk menambahkan lagu (Insertion) oleh Admin.
     */
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
// Mewarisi class User
// ==========================================================
class Member extends User {

    /**
     * Constructor untuk Member.
     */
    public Member(String nama, Lagu[] playlist, int jumlahLagu) {
        super(nama, playlist, jumlahLagu);
    }

    /**
     * Override method tampilkanAkses untuk hak akses Member.
     */
    @Override
    public void tampilkanAkses() {
        System.out.println("=== Akses Member ===");
        System.out.println("Selamat datang Member : " + nama);
        System.out.println("Hak akses             : Menelusuri, mencari lagu, & menghitung rata-rata durasi.");
    }

    /**
     * Method untuk mencari lagu (Searching) oleh Member.
     */
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

    /**
     * Method untuk melihat detail lagu berdasarkan indeks.
     */
    public void lihatDetailLagu(int indeks) {
        if (indeks >= 0 && indeks < jumlahLagu) {
            System.out.println("\n>> Detail Lagu ke-" + (indeks + 1));
            playlist[indeks].tampilkanInfo();
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    /**
     * Method untuk menghitung rata-rata durasi lagu dalam playlist.
     */
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