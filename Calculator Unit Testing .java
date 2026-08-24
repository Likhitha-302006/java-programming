import java.util.*;

public class Main {

    static int add(int a, int b) {
        return a + b;
    }

    static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
    static void testAddition() {
        if (add(10, 20) == 30) {
            System.out.println("Addition Test Passed");
        } else {
            System.out.println("Addition Test Failed");
        }
    }

    static void testDivision() {
        if (divide(20, 10) == 2) {
            System.out.println("Division Test Passed");
        } else {
            System.out.println("Division Test Failed");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();

        String[] parts = expression.trim().split("\\s+");

        int a = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int b = Integer.parseInt(parts[2]);

        int result;

        if (operator.equals("+")) {
            result = add(a, b);
        } else if (operator.equals("/")) {
            result = divide(a, b);
        } else {
            System.out.println("Invalid Operator");
            return;
        }

              if (operator.equals("+") && result == a + b) {
            System.out.println("Test Passed");
        } else if (operator.equals("/") && result == a / b) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        sc.close();
    }
}



Input

10 + 20

Output

Test Passed
