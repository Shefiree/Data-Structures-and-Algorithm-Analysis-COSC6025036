package Assignment.LAB.Assignment1;

import java.util.Arrays;

public class ArrayOperations {

    static void TraverseArray(int[] arr) {
        System.out.println("Traversal Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void Insertion(int[] arr, int element) {
        int size = arr.length;
        arr[size - 1] = element;
    }

    static void Deletion(int[] arr, int position) {
        int size = arr.length;
        if (position < 0 || position >= size) {
            System.out.println("Invalid posisi");
        }
        for (int i = position; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = 0;
    }

    static void LinearSearch(int[] arr, int target) {
        System.out.println("Linear Search " + target + ":");
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Element ada di index: " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element tidak ditemukan di array");
        }
    }

    static void BinarySearch(int[] arr, int target) {
        System.out.println("Binary Search " + target + ":");
        int left = 0;
        int right = arr.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                System.out.println("Element terletak di index: " + mid);
                found = true;
                break;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Element tidak ditemukan di array");
        }
    }

    static void Sort(int[] arr, boolean traverseAfterSort) {
        System.out.println("Sorting Array");
        Arrays.sort(arr);
        if (traverseAfterSort) {
            TraverseArray(arr);
        }
    }
}
