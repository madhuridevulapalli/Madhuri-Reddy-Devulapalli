import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        while (true) {
            System.out.println("\n=== Queue Operations Menu ===");
            System.out.println("1. Enqueue (Insert)");
            System.out.println("2. Dequeue (Remove)");
            System.out.println("3. Display Queue");
            System.out.println("4. Peek (Front Element)");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int val = scanner.nextInt();
                    queue.offer(val);
                    System.out.println(val + " enqueued to the queue.");
                    break;

                case 2:
                    Integer removed = queue.poll();
                    if (removed != null) {
                        System.out.println("Dequeued: " + removed);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue contents: " + queue);
                    }
                    break;

                case 4:
                    Integer front = queue.peek();
                    if (front != null) {
                        System.out.println("Front element: " + front);
                    } else {
                        System.out.println("Queue is empty.");
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
