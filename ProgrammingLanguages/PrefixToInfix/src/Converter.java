import java.util.Stack;

public class Converter {

    /**
     * Factors prefix into infix correctly and solves the infix and prints the solution.
     * @param expr // String prefix to be converted to infix and solved
     */
    public static void prefixToInfix(String expr) {
        // To Do: Implement modulus and exponentiation
        String [] tokens = expr.split(" ");
        Stack<String> operands = new Stack<>();
        for (int i = tokens.length - 1; i >= 0; i--) {
            String s = tokens[i];
            if ((s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) { // s.equals("%") || s.equals("^")
                String leftOp, rightOp = "";
                if (s.equals("*") ||s.equals("/")) {
                    leftOp = operands.pop();
                    rightOp = operands.pop();
                    if (leftOp.length() >= 3 && rightOp.length() >= 3 && hasOperator(leftOp) && hasOperator(rightOp)) {
                        operands.add("(" + leftOp + ")" + " " + s + " " + "(" + rightOp + ")");
                    } else if (rightOp.length() >= 3 && hasOperator(rightOp)) {
                        operands.add(leftOp + " " + s + " " + "(" + rightOp + ")");
                    } else if (leftOp.length() >= 3 && hasOperator(leftOp)) {
                        operands.add("(" + leftOp + ")" + s + " " + rightOp);
                    } else {
                        operands.add("(" + leftOp + " " + s + " " + rightOp + ")");

                    }
                } else {
                    leftOp = operands.pop();
                    rightOp = operands.pop();
                    operands.add(leftOp + " " + s + " " + rightOp);
                }
            } else {
                operands.add(s);
            }
        }
        String infix = operands.pop();
        double solution = solve(infix);

        System.out.println(expr + " --> " + infix + " = " + solution);
    }

    private static String OPERATIONS = "+-*/"; // ^%

    private static boolean hasOperator(String operand) {
        return OPERATIONS.indexOf(operand) != -1 ? false : true;
    }

    private static double solve(String infix) {
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c == '(') {
                operators.push(c);
            } else if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    sb.append(infix.charAt(i));
                    i++;
                }
                i--;
                double operand = Double.parseDouble(sb.toString());
                operands.push(operand);
            } else if (c == ')') {

                while (operators.peek() != '(') {
                    operands.push(performOp(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.pop();
            } else {
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    operands.push(performOp(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            operands.push(performOp(operators.pop(), operands.pop(), operands.pop()));
        }
        return operands.pop();
    }

    private static double performOp(char op, double b, double a) {
        switch(op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);

        }
    }

    // returns true if rightOp has precendence over leftOp
    private static boolean hasPrecedence(char leftOp, char rightOp) {
        if (rightOp == '(' || rightOp == ')') {
            return false;
        } else if ((leftOp == '*' || leftOp == '/') && (rightOp == '+' || rightOp == '-')) {
            return false;
        } else {
            return true;
        }
    }

}
