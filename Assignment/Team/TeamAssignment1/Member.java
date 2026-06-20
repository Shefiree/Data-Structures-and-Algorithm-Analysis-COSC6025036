package Assignment.Team.TeamAssignment1;

/*
 * Class Member mewarisi class User.
 * Kelebihan Member: dapat mencari lagu, melihat detail, dan menghitung rata-rata durasi.
 */
public class Member extends User {

    // Constructor Member memanggil constructor parent (super)
    public Member(String nama, Lagu[] playlist, int jumlahLagu) {
        super(nama, playlist, jumlahLagu);
    }

    // Implementasi Polymorphism: tampilkanAkses() khusus Member
    @Override
    public void tampilkanAkses() {
        System.out.println("=== Akses Member ===");
        System.out.println("Selamat datang Member : " + nama);
        System.out.println("Hak akses             : Menelusuri, mencari lagu, & menghitung rata-rata durasi.");
    }

    // Method khusus Member: mencari lagu berdasarkan judul (case-insensitive)
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

    // Method khusus Member: melihat detail lagu berdasarkan indeks array
    public void lihatDetailLagu(int indeks) {
        if (indeks >= 0 && indeks < jumlahLagu) {
            System.out.println("\n>> Detail Lagu ke-" + (indeks + 1));
            playlist[indeks].tampilkanInfo();
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    // Method khusus Member: menghitung rata-rata durasi seluruh lagu di playlist
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