import java.util.Arrays;
import java.util.Scanner;

public class SortingOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Input elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        while (true) {
            System.out.println("\n=== Sorting Menu ===");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Arrays.sort() (Built-in)");
            System.out.println("5. Exit");
            System.out.print("Choose sorting method: ");
            int choice = scanner.nextInt();

            int[] sortedArray = Arrays.copyOf(array, n); // Make a copy for each run

            switch (choice) {
                case 1:
                    bubbleSort(sortedArray);
                    System.out.println("Sorted using Bubble Sort: " + Arrays.toString(sortedArray));
                    break;

                case 2:
                    selectionSort(sortedArray);
                    System.out.println("Sorted using Selection Sort: " + Arrays.toString(sortedArray));
                    break;

                case 3:
                    insertionSort(sortedArray);
                    System.out.println("Sorted using Insertion Sort: " + Arrays.toString(sortedArray));
                    break;

                case 4:
                    Arrays.sort(sortedArray);
                    System.out.println("Sorted using Arrays.sort(): " + Arrays.toString(sortedArray));
                    break;

                case 5:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Selection Sort
    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // Move elements of arr[0..i-1] > key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
