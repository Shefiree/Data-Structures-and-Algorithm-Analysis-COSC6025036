package Assignment.LAB.Assignment1;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Comparison {

    static long measureTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return (end - start) / 1_000_000;
    }

    static void warmup() {
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(OutputStream.nullOutputStream()));
        for (int i = 0; i < 10000; i++) {
            int[] arr = new int[1000];
            for (int j = 0; j < 1000; j++) {
                arr[j] = j + 1;
            }
            ArrayOperations.LinearSearch(arr, 500);
            ArrayOperations.BinarySearch(arr, 500);
            ArrayOperations.Sort(arr, false);

            ArrayList<Integer> arrList = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                arrList.add(j + 1);
            }
            ArrayListOperations.LinearSearch(arrList, 500);
            ArrayListOperations.BinarySearch(arrList, 500);
            ArrayListOperations.Sort(arrList, false);
        }
        System.setOut(originalOut);
        System.out.println("Warmup selesai! Mulai eksekusi benchmark...");
    }

    public static void main(String[] args) {

        // melakukan warmup untuk mengurangi efek JIT compiler
        warmup();

        int[] arr = { 10, 20, 30, 40, 50 };
        ArrayList<Integer> arrList = new ArrayList<>(List.of(10, 20, 30, 40, 50));

        System.out.println("--- LOG EKSEKUSI OPERASI ---");
        System.out.println("Array:");
        long timeArray = measureTime(() -> {
            ArrayOperations.TraverseArray(arr);
            ArrayOperations.LinearSearch(arr, 30);
            ArrayOperations.BinarySearch(arr, 30);
            ArrayOperations.Insertion(arr, 60);
            ArrayOperations.Deletion(arr, 1);
            ArrayOperations.Sort(arr, true);
        });

        long timeArrayLarge = measureTime(() -> {
            int[] largeList = new int[10000];
            for (int i = 0; i < 10000; i++) {
                largeList[i] = i + 1;
            }
            ArrayOperations.LinearSearch(largeList, 500);
            ArrayOperations.BinarySearch(largeList, 500);
            ArrayOperations.Sort(largeList, false);
        });

        System.out.println("\nArray List:");
        long timeArrayList = measureTime(() -> {
            ArrayListOperations.TraverseArray(arrList);
            ArrayListOperations.LinearSearch(arrList, 30);
            ArrayListOperations.BinarySearch(arrList, 30);
            ArrayListOperations.Insertion(arrList, 60);
            ArrayListOperations.Deletion(arrList, 1);
            ArrayListOperations.Sort(arrList, true);
        });

        long timeArrayListLarge = measureTime(() -> {
            ArrayList<Integer> largeArrList = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                largeArrList.add(i + 1);
            }
            ArrayListOperations.LinearSearch(largeArrList, 500);
            ArrayListOperations.BinarySearch(largeArrList, 500);
            ArrayListOperations.Sort(largeArrList, false);
        });

        System.out.println("\n\n--- HASIL BENCHMARK ---");
        System.out.println("+-------------------------------------------+------------+");
        System.out.printf("| %-41s | %-10s |\n", "Jenis Operasi", "Waktu");
        System.out.println("+-------------------------------------------+------------+");
        System.out.printf("| %-41s | %6d ms |\n", "Waktu Operasi Array", timeArray);
        System.out.printf("| %-41s | %6d ms |\n", "Waktu Operasi Array dengan 10000 data", timeArrayLarge);
        System.out.printf("| %-41s | %6d ms |\n", "Waktu Operasi ArrayList", timeArrayList);
        System.out.printf("| %-41s | %6d ms |\n", "Waktu Operasi ArrayList dengan 10000 data", timeArrayListLarge);
        System.out.println("+-------------------------------------------+------------+");
    }
}