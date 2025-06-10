import java.util.*;
import java.util.function.BiFunction;

public class LambdaCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueCalc = true;
        Map<Character, BiFunction<Double, Double, Double>> operations = new HashMap<>();
        operations.put('+', (a, b) -> a + b);
        operations.put('-', (a, b) -> a - b);
        operations.put('*', (a, b) -> a * b);
        operations.put('/', (a, b) -> {
            if (b == 0) throw new ArithmeticException("Cannot divide by zero.");
            return a / b;
        });

        while (continueCalc) {
            try {
                System.out.print("Enter the numbers you want: ");
                int count = input.nextInt();

                if (count < 2) {
                    System.out.println("Please enter at least two numbers.");
                    continue;
                }

                System.out.print("Enter the first number: ");
                double result = input.nextDouble();
                for (int i = 1; i < count; i++) {
                    char operator;
                    while (true) {
                        System.out.print("Select the operator (+, -, *, /): ");
                        String op = input.next();
                        if (op.length() == 1 && operations.containsKey(op.charAt(0))) {
                            operator = op.charAt(0);
                            break;
                        } else {
                            System.out.println("Invalid operator! Please enter one of +, -, *, or /");
                        }
                    }
                    System.out.print("Enter the next number: ");
                    double nextNumber = input.nextDouble();
                    result = operations.get(operator).apply(result, nextNumber);
                }

                System.out.println("Result: " + result);

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter valid numeric values.");
                input.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
            while (true) {
                System.out.print("Do you want to continue? (yes/no): ");
                String choice = input.next();
                if (choice.equalsIgnoreCase("yes")) {
                    break;
                } else if (choice.equalsIgnoreCase("no")) {
                    continueCalc = false;
                    System.out.println("Calculator exited.");
                    break;
                } else {
                    System.out.println("Invalid input! Please type 'yes' or 'no'.");
                }
            }
        }

        input.close();
    }
}
