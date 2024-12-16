import java.util.Scanner;

public class ExceptionHandlingExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input two numbers from the user
            System.out.print("Enter the first number (Num1): ");
            String num1Input = scanner.nextLine();

            System.out.print("Enter the second number (Num2): ");
            String num2Input = scanner.nextLine();

            // Try to parse the numbers (this could throw NumberFormatException)
            int num1 = Integer.parseInt(num1Input);
            int num2 = Integer.parseInt(num2Input);

            // Try to divide the numbers (this could throw ArithmeticException)
            int result = num1 / num2;
            System.out.println("Result of division: " + result);

            // Simulate ArrayIndexOutOfBoundsException for demonstration
            int[] arr = new int[5];
            System.out.println("Accessing array at index 10 (will throw ArrayIndexOutOfBoundsException): ");
            System.out.println(arr[10]); // This will throw the exception

        } catch (NumberFormatException e) {
            // Handle case when input is not a valid integer
            System.out.println("Error: Invalid input. Please enter valid integers.");
        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Error: Cannot divide by zero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle array index out of bounds exception
            System.out.println("Error: Array index out of bounds.");
        } finally {
            // Always executed whether exception occurs or not
            System.out.println("Program execution completed.");
        }

        scanner.close();
    }
}

