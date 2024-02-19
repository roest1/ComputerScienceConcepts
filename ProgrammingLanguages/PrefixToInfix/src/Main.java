public class Main {
    public static void main(String[] args) throws Exception {

        Converter.prefixToInfix("+ + 1 3 * 5 10"); // A+D+(B*C) : 1 + 3 + (5 * 10) = 54
        Converter.prefixToInfix("+ * 2 10 * 10 10"); // (A*B)+(C*D) : (2 * 10) + (10 * 10) = 120
        Converter.prefixToInfix("* + 3 5 + 19 6"); // (3 + 5) * (19 + 6) = 200
        Converter.prefixToInfix("* + 2 2 + 2 2"); // (A+B)*(C+D) : (2 + 2) * (2 + 2) = 16
        Converter.prefixToInfix("+ + + 10 20 35 50"); // A+B+C+D : 1 + 2 + 3 + 4 = 115

    }
}
