import java.util.*;

public class SmartCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueCalc = true;
        while (continueCalc) {
            try {
                List<Double> numberList = new ArrayList<>();
                List<Character> operatorList = new ArrayList<>();
                System.out.print("Enter first number: ");
                double result = getValidNumber(input);
                numberList.add(result);
                while (true) {
                    System.out.print("Enter operator (+, -, *, /, = or 'back' to undo): ");
                    String op = input.next();
                    if (op.equals("=")) {
                        StringBuilder expression = new StringBuilder();
                        expression.append(numberList.get(0));
                        for (int i = 1; i < numberList.size(); i++) {
                            expression.append(" ").append(operatorList.get(i - 1)).append(" ").append(numberList.get(i));
                        }
                        expression.append(" = ").append(result);
                        System.out.println(expression);
                        List<Double> sorted = new ArrayList<>(numberList);
                        Collections.sort(sorted);
                        System.out.println("Sorted numbers entered: " + sorted);
                        List<Double> evenValues = new ArrayList<>();
                        List<Double> oddValues = new ArrayList<>();
                        for (Double num : sorted) {
                            if (num % 2 == 0) {
                                evenValues.add(num);
                            } else {
                                oddValues.add(num);
                            }
                        }
                        System.out.println("Even values: " + evenValues);
                        System.out.println("Odd values: " + oddValues);
                        break;
                    }

                    if (op.equalsIgnoreCase("back")) {
                        if (!operatorList.isEmpty()) {
                            operatorList.remove(operatorList.size() - 1);
                        }
                        if (numberList.size() > 1) {
                            numberList.remove(numberList.size() - 1);
                            result = recalculate(numberList, operatorList);
                            System.out.println("Last entry removed. Current result: " + result);
                        } else {
                            System.out.println("Nothing to remove.");
                        }
                        continue;
                    }

                    if (op.length() != 1 || !"+-*/".contains(op)) {
                        System.out.println("Invalid operator! Use +, -, *, /, = or back.");
                        continue;
                    }

                    char operator = op.charAt(0);
                    System.out.print("Enter next number (or 'back' to undo): ");
                    String inputValue = input.next();

                    if (inputValue.equalsIgnoreCase("back")) {
                        System.out.println("Undo triggered. Returning to operator selection.");
                        continue;
                    }

                    double nextNumber;
                    try {
                        nextNumber = Double.parseDouble(inputValue);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Try again.");
                        continue;
                    }

                    switch (operator) {
                        case '+': result += nextNumber; break;
                        case '-': result -= nextNumber; break;
                        case '*': result *= nextNumber; break;
                        case '/':
                            if (nextNumber == 0) {
                                System.out.println("Cannot divide by zero.");
                                continue;
                            }
                            result /= nextNumber; break;
                    }

                    numberList.add(nextNumber);
                    operatorList.add(operator);
                    System.out.println("Current result: " + result);
                }

            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
                input.nextLine(); // clear input
            }

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String choice = input.next();
            if (choice.equalsIgnoreCase("no")) {
                continueCalc = false;
                System.out.println("Calculator exited.");
            }
        }

        input.close();
    }

    private static double getValidNumber(Scanner input) {
        while (true) {
            try {
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid number. Try again: ");
                input.nextLine();
            }
        }
    }
    private static double recalculate(List<Double> numbers, List<Character> operators) {
        if (numbers.isEmpty()) return 0;
        double result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            char op = operators.get(i - 1);
            double num = numbers.get(i);
            switch (op) {
                case '+': result += num; break;
                case '-': result -= num; break;
                case '*': result *= num; break;
                case '/': result /= num; break;
            }
        }
        return result;
    }
}
