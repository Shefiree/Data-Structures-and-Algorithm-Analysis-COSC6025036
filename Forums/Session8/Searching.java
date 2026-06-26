import java.util.Arrays;

public class Searching {
    static int static_arr[] = { 12, 34, 10, 6, 40 };
    static int n = static_arr.length;

    public static int linearSearch(int arr[], int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int key, int low, int high) {
        if (high < low)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (key > arr[mid])
            return binarySearch(arr, key, mid + 1, high);
        return binarySearch(arr, key, low, mid - 1);
    }

    public static int fibonacciSearch(int arr[], int key) {
        int fibM2 = 0; // (m-2)'th Fibonacci No.
        int fibM1 = 1; // (m-1)'th Fibonacci No.
        int fibM = fibM2 + fibM1; // m'th Fibonacci

        while (fibM < n) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibM2, n - 1);

            if (arr[i] < key) {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            } else if (arr[i] > key) {
                fibM = fibM2;
                fibM1 = fibM1 - fibM2;
                fibM2 = fibM - fibM1;
            } else {
                return i;
            }
        }

        if (fibM1 == 1 && arr[offset + 1] == key) {
            return offset + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        // Linear Search (without ordered array)
        System.out.println("1. Linear Search (without ordered array)");
        System.out.println("Array: " + Arrays.toString(static_arr));
        int key = 40;
        System.out.println("Value to search: " + key);
        int pos = linearSearch(static_arr, key);
        if (pos == -1) {
            System.out.println("Value not found in the array");
        } else {
            System.out.println("Value found at index: " + pos);
        }
        System.out.println("------------------------------");

        // Linear Search (with ordered array)
        System.out.println("2. Linear Search (with ordered array)");
        key = 10;
        Arrays.sort(static_arr);
        System.out.println("Array: " + Arrays.toString(static_arr));
        pos = linearSearch(static_arr, key);
        if (pos == -1) {
            System.out.println("Value not found in the array");
        } else {
            System.out.println("Value found at index: " + pos);
        }

        System.out.println("------------------------------");

        // Binary Search (with ordered array)
        System.out.println("3. Binary Search (with ordered array)");
        key = 34;
        System.out.println("Array: " + Arrays.toString(static_arr));
        pos = binarySearch(static_arr, key, 0, n - 1);
        if (pos == -1) {
            System.out.println("Value not found in the array");
        } else {
            System.out.println("Value found at index: " + pos);
        }
        System.out.println("------------------------------");

        // Fibonacci Search (with ordered array)
        System.out.println("4. Fibonacci Search (with ordered array)");
        key = 34;
        System.out.println("Array: " + Arrays.toString(static_arr));
        pos = fibonacciSearch(static_arr, key);
        if (pos == -1) {
            System.out.println("Value not found in the array");
        } else {
            System.out.println("Value found at index: " + pos);
        }
        System.out.println("------------------------------");
    }
}
