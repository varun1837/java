import java.util.Scanner;

public class ConsoleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = 0, num2 = 0;
        char operator;
        boolean validInput = false;

        System.out.println("=== Console Calculator ===");

        // Get first number
        while (!validInput) {
            System.out.print("Enter first number: ");
            if (scanner.hasNextDouble()) {
                num1 = scanner.nextDouble();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // clear invalid input
            }
        }

        // Get operator
        System.out.print("Enter operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);58

        // Get second number
        validInput = false;
        while (!validInput) {
            System.out.print("Enter second number: ");
            if (scanner.hasNextDouble()) {
                num2 = scanner.nextDouble();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // clear invalid input
            }
        }

        // Perform calculation
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.printf("Result: %.2f%n", result);
                break;
            case '-':
                result = num1 - num2;
                System.out.printf("Result: %.2f%n", result);
                break;
            case '*':
                result = num1 * num2;
                System.out.printf("Result: %.2f%n", result);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                } else {
                    result = num1 / num2;
                    System.out.printf("Result: %.2f%n", result);
                }
                break;
            default:
                System.out.println("Invalid operator. Please use +, -, *, or /.");
        }

        scanner.close();
    }
}
