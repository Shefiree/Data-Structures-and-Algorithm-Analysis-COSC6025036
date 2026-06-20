package Assignment.Team.TeamAssignment1;

/*
 * Class Admin mewarisi class User.
 * Kelebihan Admin: dapat menambahkan lagu baru ke dalam playlist.
 */
public class Admin extends User {

    // Constructor Admin memanggil constructor parent (super)
    public Admin(String nama, Lagu[] playlist, int jumlahLagu) {
        super(nama, playlist, jumlahLagu);
    }

    // Implementasi Polymorphism: tampilkanAkses() khusus Admin
    @Override
    public void tampilkanAkses() {
        System.out.println("=== Akses Admin ===");
        System.out.println("Selamat datang Admin : " + nama);
        System.out.println("Hak akses            : Menambahkan lagu baru & melihat daftar lagu.");
    }

    // Method khusus Admin untuk menambahkan lagu baru ke array playlist.
    // Mengembalikan jumlah lagu terbaru agar bisa disinkronkan ke objek lain.
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