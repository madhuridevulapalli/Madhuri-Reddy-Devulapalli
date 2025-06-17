import java.util.Scanner;

public class MainAppLauncher1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\n=== Project Launcher ===");
            System.out.println("1. SmartCalculator");
            System.out.println("2. FileDBExecutor");
            System.out.println("3. DatabaseMenuApp");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = -1;

            // Read input safely
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // discard invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    SmartCalculator4.main(new String[]{});
                    break;
                case 2:
                    FileDBExecutor4.main(new String[]{});
                    break;
                case 3:
                    DatabaseMenuApp1.main(new String[]{});
                    break;
                case 4:
                    continueRunning = false;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            if (continueRunning) {
                System.out.print("\nDo you want to continue? (yes/no): ");
                if (scanner.hasNextLine()) {
                    String answer = scanner.nextLine().trim().toLowerCase();
                    if (!answer.equals("yes") && !answer.equals("y")) {
                        continueRunning = false;
                        System.out.println("Exiting... Thank you!");
                    }
                } else {
                    System.out.println("No input found. Exiting...");
                    continueRunning = false;
                }
            }
        }

        scanner.close();
    }
}
