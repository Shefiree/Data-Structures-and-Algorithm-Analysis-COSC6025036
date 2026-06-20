package Assignment.Team.TeamAssignment1;

/*
 * Class User adalah PARENT CLASS dari Admin dan Member.
 * Menyimpan atribut umum dan method umum yang akan diwariskan.
 */
public class User {
    // Atribut protected agar dapat diakses oleh class turunan
    protected String nama;
    protected Lagu[] playlist;   // Array untuk menyimpan kumpulan objek Lagu
    protected int jumlahLagu;

    // Constructor User
    public User(String nama, Lagu[] playlist, int jumlahLagu) {
        this.nama = nama;
        this.playlist = playlist;
        this.jumlahLagu = jumlahLagu;
    }

    // Getter & Setter
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public Lagu[] getPlaylist() { return playlist; }
    public int getJumlahLagu() { return jumlahLagu; }
    public void setJumlahLagu(int jumlahLagu) { this.jumlahLagu = jumlahLagu; }

    // Method yang akan di-override oleh child class (Polymorphism)
    public void tampilkanAkses() {
        System.out.println("Akses Default - User: " + nama);
    }

    // Method umum untuk menampilkan seluruh isi playlist
    // Diwariskan ke Admin dan Member
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