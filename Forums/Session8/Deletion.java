
import java.util.ArrayList;
import java.util.Arrays;

public class Deletion {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };

        // deletion use loop
        System.out.println("1. Deletion use loop");
        int[] arr2 = new int[arr.length - 1];

        int j = 3;
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i != j) {
                arr2[k++] = arr[i];
            }
        }
        System.out.println("Array before deletion: " + Arrays.toString(arr));
        System.out.println("Array after deletion: " + Arrays.toString(arr2));
        System.out.println("------------------------------");
        // deletion elemnt by its value
        System.out.println("2. Deletion by value");
        int[] arr3 = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (arr[i] != 3) {
                arr3[k++] = arr[i];
            }
        }
        System.out.println("Array before deletion by value: " + Arrays.toString(arr));
        System.out.println("Array after deletion by value: " + Arrays.toString(arr3));
        System.out.println("------------------------------");

        // deletion element by its value when the array contains duplicate values
        System.out.println("3. Deletion by value when the array contains duplicate values");
        ArrayList<Integer> arr4 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != j) {
                arr4.add(arr[i]);
            }
        }
        System.out.println("Array before deletion of all instances: " + Arrays.toString(arr));
        System.out.println("Array after deletion of all instances: " + arr4);
        System.out.println("------------------------------");

        // Shifting elements in same array
        System.out.println("4. Shifting elements in same array");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == j) {
                count++;
                // shift elements to the left
                for (int k = i; k < arr.length - 1; k++) {
                    arr[k] = arr[k + 1];
                }
                i--;

            }
        }
        System.out.println("Array after shifting elements: ");
        for (int i = 0; i < arr.length - count; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
        System.out.println("Whole array after shifting elements: " + Arrays.toString(arr));
        System.out.println("------------------------------");

        // Deletion elements from ArrayList
        System.out.println("5. Deletion elements from ArrayList");
        ArrayList<Integer> arr5 = new ArrayList<Integer>();
        for (int i : arr) {
            arr5.add(i);
        }
        arr5.remove(3);
        System.out.println("Array before deletion from ArrayList: " + Arrays.toString(arr));
        System.out.println("Array after deletion from ArrayList: " + arr5);
        System.out.println("------------------------------");

        // Manual Shifting of elements
        System.out.println("6. Manual Shifting of elements");
        int removedIndex = 2;
        for (int i = removedIndex; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        System.out.println("Array after manual shifting of elements: ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
        System.out.println("------------------------------");

        // Using System.arraycopy() method
        System.out.println("7. Using System.arraycopy() method");
        int removedIndex2 = 2;
        int[] arr6 = new int[arr.length - 1];
        // arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        System.arraycopy(arr, 0, arr6, 0, removedIndex2);
        System.arraycopy(arr, removedIndex2 + 1, arr6, removedIndex2, arr.length - removedIndex2 - 1);
        System.out.println("Array after using System.arraycopy(): " + Arrays.toString(arr6));
        System.out.println("------------------------------");
    }
}