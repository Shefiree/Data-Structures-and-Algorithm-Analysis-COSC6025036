package Assignment.Personal.PersonalAssignment1.Library;

public class Book {

    private String kode;
    private String judul;
    private String penulis;

    public Book(String code, String title, String author) {
        this.kode = code;
        this.judul = title;
        this.penulis = author;
    }

    public Book() {
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String code) {
        this.kode = code;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String title) {
        this.judul = title;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String author) {
        this.penulis = author;
    }

    // perlu untuk override toString() agar bisa menampilkan informasi buku dengan
    // format yang diinginkan
    @Override
    public String toString() {
        return "[" + kode + "] " + judul + " oleh " + penulis;
    }

}
