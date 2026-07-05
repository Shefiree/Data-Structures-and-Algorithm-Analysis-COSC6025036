package Assignment.LAB.Assignment1;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {

    static void TraverseArray(ArrayList<Integer> arr) {
        System.out.println("Traversal ArrayList:");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    static void Insertion(ArrayList<Integer> arr, int element) {

        arr.add(arr.size(), element);
    }

    static void Deletion(ArrayList<Integer> arr, int position) {
        System.out.println("Deletion ArrayList");
        if (position < 0 || position >= arr.size()) {
            System.out.println("Invalid posisi");
            return;
        }
        arr.remove(position);
    }

    static void LinearSearch(ArrayList<Integer> arr, int target) {
        System.out.println("Linear Search " + target + ":");
        int index = arr.indexOf(target);
        if (index != -1) {
            System.out.println("Element ditemukan di index: " + index);
        } else {
            System.out.println("Element tidak ditemukan di ArrayList");
        }
    }

    static void BinarySearch(ArrayList<Integer> arr, int target) {
        System.out.println("Binary Search " + target + ":");
        int index = Collections.binarySearch(arr, target);
        if (index >= 0) {
            System.out.println("Element ditemukan di index: " + index);
        } else {
            System.out.println("Element tidak ditemukan di ArrayList");
        }
    }

    static void Sort(ArrayList<Integer> arr, boolean traverseAfterSort) {
        System.out.println("Sorting ArrayList");
        arr.sort(null);
        if (traverseAfterSort) {
            TraverseArray(arr);
        }
    }

}
