package ta_4_stack;

import java.util.Stack;

public class TextEditor {
    private String teksSaatIni;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    // Constructor untuk membuat editor teks kosong
    public TextEditor() {
        teksSaatIni = "";
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    // Method untuk menambahkan teks baru
    public void tambahTeks(String teksBaru) {
        // Menyimpan kondisi teks sebelum diubah ke undoStack
        undoStack.push(teksSaatIni);

        // Menambahkan teks baru ke teks saat ini
        teksSaatIni = teksSaatIni + teksBaru;

        // Menghapus redoStack karena ada perubahan baru
        redoStack.clear();

        System.out.println("Teks berhasil ditambahkan.");
    }

    // Method untuk undo atau mengembalikan ke kondisi sebelumnya
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada perubahan yang dapat di-undo.");
        } else {
            // Menyimpan kondisi saat ini ke redoStack
            redoStack.push(teksSaatIni);

            // Mengembalikan teks ke kondisi sebelumnya
            teksSaatIni = undoStack.pop();

            System.out.println("Undo berhasil.");
        }
    }

    // Method untuk redo atau mengembalikan perubahan yang telah di-undo
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada perubahan yang dapat di-redo.");
        } else {
            // Menyimpan kondisi saat ini ke undoStack
            undoStack.push(teksSaatIni);

            // Mengembalikan teks dari redoStack
            teksSaatIni = redoStack.pop();

            System.out.println("Redo berhasil.");
        }
    }

    // Method untuk menampilkan teks saat ini
    public void tampilkanTeks() {
        System.out.println("Teks saat ini: \"" + teksSaatIni + "\"");
    }
}
