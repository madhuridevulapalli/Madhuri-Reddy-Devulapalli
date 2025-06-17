            }

            if (op.equals("(")) {
                tokens.add(op);
                openBrackets++;
                continue;
            }

            if (op.equals(")")) {
                if (openBrackets <= 0) {
                    System.out.println("No matching opening bracket for ')'. Try again.");
                    continue;
                }
                tokens.add(op);
                openBrackets--;
                continue;
            }

            if (op.length() == 1 && "+-*/".contains(op)) {
                tokens.add(op);
                System.out.print("Enter number or '(': ");
                String next = getToken(input, true);
                if (next.equals("(")) openBrackets++;
                tokens.add(next);
            } else {
                System.out.println("Invalid operator.");
            }
        }
    }

    private static String getToken(Scanner input, boolean allowBracket) {
        while (true) {
            String token = input.next();
            if (allowBracket && token.equals("(")) return token;
            try {
                Double.parseDouble(token);
                return token;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }

    private static List<Double> extractNumbers(List<String> tokens) {
        List<Double> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                numbers.add(Double.parseDouble(token));
            } catch (NumberFormatException ignored) {
            }
        }
        return numbers;
    }

    private static double evaluateExpression(String expr) {
        return evaluateRPN(toRPN(expr));
    }

    private static List<String> toRPN(String expr) {
        String[] tokens = expr.split(" ");
        Stack<String> ops = new Stack<>();
        List<String> output = new ArrayList<>();
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                output.add(token);
            } else if ("+-*/".contains(token)) {
                while (!ops.isEmpty() && precedence.containsKey(ops.peek()) &&
                        precedence.get(ops.peek()) >= precedence.get(token)) {
                    output.add(ops.pop());
                }
                ops.push(token);
            } else if (token.equals("(")) {
                ops.push(token);
            } else if (token.equals(")")) {
                while (!ops.peek().equals("(")) {
                    output.add(ops.pop());
                }
                ops.pop();
            }
        }
        while (!ops.isEmpty()) {
            output.add(ops.pop());
        }
        return output;
    }

    private static double evaluateRPN(List<String> rpn) {
        Stack<Double> stack = new Stack<>();
        for (String token : rpn) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/":
                        if (b == 0) throw new ArithmeticException("Division by zero");
                        stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
}
