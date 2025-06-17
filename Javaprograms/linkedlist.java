import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        while (true) {
            System.out.println("\n=== Linked List Operations Menu ===");
            System.out.println("1. Insert Element");
            System.out.println("2. Display Elements");
            System.out.println("3. Search Element");
            System.out.println("4. Delete Element");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int val = scanner.nextInt();
                    list.add(val);
                    System.out.println(val + " inserted into linked list.");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("Linked list is empty.");
                    } else {
                        System.out.println("Linked list elements: " + list);
                    }
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int search = scanner.nextInt();
                    if (list.contains(search)) {
                        System.out.println("Element found at index: " + list.indexOf(search));
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter value to delete: ");
                    int del = scanner.nextInt();
                    if (list.remove((Integer) del)) {
                        System.out.println("Element deleted.");
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
