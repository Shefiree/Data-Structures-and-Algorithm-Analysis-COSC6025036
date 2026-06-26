import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insertion {
    static int[] static_arr = { 25, 14, 56, 15, 36, 56, 77, 18, 29, 49 };
    static Integer[] static_arr2 = { 25, 14, 56, 15, 36, 56, 77, 18, 29, 49 };

    public static void main(String[] args) {
        // Insert element at specific position with shifting elements to the right
        System.out.println("1. Insert element at specific position with shifting elements to the right");
        int[] arr2 = static_arr.clone();
        int idx_position = 2;
        int newVal = 5;
        System.out.println("Array before insertion: " + Arrays.toString(arr2));
        for (int i = arr2.length - 1; i > idx_position; i--) {
            arr2[i] = arr2[i - 1]; // shift elements to the right
        }
        arr2[idx_position] = newVal;
        System.out.println("Array after insertion: " + Arrays.toString(arr2));
        System.out.println("------------------------------");

        // Insert element at specific position with new arr the size one greater than
        // the original arr
        System.out.println(
                "2. Insert element at specific position with new arr the size one greater than the original arr");
        System.out.println("Array before insertion: " + Arrays.toString(static_arr));
        int[] arr3 = new int[static_arr.length + 1];
        int idx_position2 = 3;
        int newVal2 = 10;
        for (int i = 0; i < arr3.length; i++) {
            if (i < idx_position2 - 1) { // shifting elements to the left
                arr3[i] = static_arr[i];
            } else if (i == idx_position2 - 1) { // insert new value at the specific position
                arr3[i] = newVal2;
            } else { // the rest of the elements are shifted to the right
                arr3[i] = static_arr[i - 1];
            }
        }
        System.out.println("Array after insertion: " + Arrays.toString(arr3));
        System.out.println("------------------------------");

        // Insert Element with convert array to ArrayList and use add() method
        System.out.println("3. Insert Element with convert array to ArrayList and use add() method");
        System.out.println("Array before insertion: " + Arrays.toString(static_arr));
        int idx_position3 = 5;
        int newVal3 = 20;
        List<Integer> arrList = new ArrayList<>(Arrays.asList(static_arr2));
        arrList.add(idx_position3 - 1, newVal3);
        System.out.println("Array after insertion: " + arrList);
        System.out.println("------------------------------");

    }
}
