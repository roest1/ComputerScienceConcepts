import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number to translate to binary:");
        Converter.IEEE754(scan.nextDouble());
    }
}