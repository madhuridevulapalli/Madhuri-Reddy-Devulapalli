import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int value) {
        data = value;
        next = null;
    }
}
public class DynamicQueue {
    Node front, rear;

    public DynamicQueue() {
        front = rear = null;
    }
    void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(value + " inserted.");
    }
    void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println(front.data + " removed.");
            front = front.next;
            if (front == null) rear = null;
        }
    }
    void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    void rotate() {
        if (front == null || front.next == null) {
            System.out.println("Rotation not needed (queue is empty or has one element).");
        } else {
            Node temp = front;
            front = front.next;
            temp.next = null;
            rear.next = temp;
            rear = temp;
            System.out.println("Queue rotated.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DynamicQueue queue = new DynamicQueue();
        int choice;
        while (true) {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Rotate");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter number to insert: ");
                    int value = sc.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    queue.rotate();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
