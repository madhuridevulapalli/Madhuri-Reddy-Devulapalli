import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declare an array of size 100
        int[] array = new int[100];
        int size = 0;

        while (true) {
            System.out.println("\n=== Array Operations Menu ===");
            System.out.println("1. Insert Element");
            System.out.println("2. Display Elements");
            System.out.println("3. Search Element");
            System.out.println("4. Delete Element");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (size >= array.length) {
                        System.out.println("Array is full. Cannot insert.");
                        break;
                    }
                    System.out.print("Enter value to insert: ");
                    int val = scanner.nextInt();
                    array[size++] = val;
                    System.out.println(val + " inserted.");
                    break;

                case 2:
                    if (size == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        System.out.print("Array elements: ");
                        for (int i = 0; i < size; i++) {
                            System.out.print(array[i] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int search = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < size; i++) {
                        if (array[i] == search) {
                            System.out.println("Element found at index " + i);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Element not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter value to delete: ");
                    int del = sc
