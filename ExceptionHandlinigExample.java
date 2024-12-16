package code;

import java.util.Scanner;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter first number (Num1): ");
            String input1 = scanner.nextLine();
            System.out.print("Enter second number (Num2): ");
            String input2 = scanner.nextLine();

            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);

            int result = num1 / num2;
            System.out.println("Result of division: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception: Please enter valid integers.");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: Division by zero is not allowed.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out of Bounds Exception: Invalid array access.");
        } finally {
            scanner.close();
        }
    }
}
