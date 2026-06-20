package Assignment.Team.TeamAssignment1;

/*
NIM dan Nama Anggota Kelompok Group 2  :
- 2902800855 – Faisal Nur Arif
- 2902761311 – Mohamad Faizal Norhavid
- 2902800634 – Muhammad Kemal Ilyasa Margana
- 2902783136 – Sandy Maulana Malik Alghozy Sedyo Putra
- 2902773356 – Syafina Andiya Putri
*/

public class Lagu {
    // Properties Kelas
    private String judul;
    private String artis;
    private Double durasi;

    // Constructor Kelas
    public Lagu(String judul, String artis, Double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // Setter - Getter
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

    public Double getDurasi() {
        return durasi;
    }

    public void setDurasi(Double durasi) {
        this.durasi = durasi;
    }

    // Methods Kelas
    public void tampilkanInfo() {
        System.out.println("Informasi Lagu :");
        System.out.println("Judul :" + judul);
        System.out.println("Artis :" + artis);
        System.out.println("Durasi :" + durasi);
    }
}