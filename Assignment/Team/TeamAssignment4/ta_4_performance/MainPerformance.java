package ta_4_performance;

import ta_4_queue.CustomerQueue;
import ta_4_stack.TextEditor;
import ta_4_singlelinklist.MahasiswaLinkedList;

public class MainPerformance {
    public static void main(String[] args) {

        long startQueue = System.nanoTime();
        CustomerQueue queue = new CustomerQueue();
        queue.tambahPelanggan("Sandy");
        queue.tambahPelanggan("Sukma");
        queue.tambahPelanggan("Lugman");
        queue.layaniPelanggan();
        long endQueue = System.nanoTime();

        long startStack = System.nanoTime();
        TextEditor editor = new TextEditor();
        editor.tambahTeks("Selamat");
        editor.tambahTeks(" datang");
        editor.undo();
        long endStack = System.nanoTime();

        long startLinkedList = System.nanoTime();
        MahasiswaLinkedList list = new MahasiswaLinkedList();
        list.tambahMahasiswa("201912", "Sandy", 90);
        list.tambahMahasiswa("201801", "Sukma", 95);
        list.updateNilai("201912", 92);
        long endLinkedList = System.nanoTime();

        System.out.println("=== Perbandingan Waktu Eksekusi ===");
        System.out.println("Queue       : " + (endQueue - startQueue) + " ns");
        System.out.println("Stack       : " + (endStack - startStack) + " ns");
        System.out.println("Linked List : " + (endLinkedList - startLinkedList) + " ns");
    }
}
