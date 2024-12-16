import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PropertyCounter {

    // Generic method to count elements in the collection that satisfy a specific property
    public static <T> int countProperty(List<T> collection, PropertyChecker<T> propertyChecker) {
        int count = 0;
        for (T element : collection) {
            if (propertyChecker.check(element)) {
                count++;
            }
        }
        return count;
    }

    // Interface to check a property on an element
    interface PropertyChecker<T> {
        boolean check(T element);
    }

    // Check if an integer is even
    static class EvenChecker implements PropertyChecker<Integer> {
        @Override
        public boolean check(Integer element) {
            return element % 2 == 0;
        }
    }

    // Check if an integer is odd
    static class OddChecker implements PropertyChecker<Integer> {
        @Override
        public boolean check(Integer element) {
            return element % 2 != 0;
        }
    }

    // Check if an integer is prime
    static class PrimeChecker implements PropertyChecker<Integer> {
        @Override
        public boolean check(Integer element) {
            if (element <= 1) return false;
            for (int i = 2; i <= Math.sqrt(element); i++) {
                if (element % i == 0) return false;
            }
            return true;
        }
    }

    // Check if a string is a palindrome
    static class PalindromeChecker implements PropertyChecker<String> {
        @Override
        public boolean check(String element) {
            String reversed = new StringBuilder(element).reverse().toString();
            return element.equals(reversed);
        }
    }

    public static void main(String[] args) {
        // Create a collection of numbers (Integer) or strings (for palindrome)
        List<Integer> numbers = new ArrayList<>();
        numbers.add(123);
        numbers.add(121);
        numbers.add(56);
        numbers.add(7);
        numbers.add(13);
        numbers.add(10);
        numbers.add(37);

        List<String> words = new ArrayList<>();
        words.add("level");
        words.add("hello");
        words.add("radar");
        words.add("world");

        Scanner scanner = new Scanner(System.in);

        // User selects property to check
        System.out.println("Select the property to check:");
        System.out.println("1. Even Numbers");
        System.out.println("2. Odd Numbers");
        System.out.println("3. Prime Numbers");
        System.out.println("4. Palindromes");
        int choice = scanner.nextInt();

        int count = 0;
        switch (choice) {
            case 1: // Even Numbers
                count = countProperty(numbers, new EvenChecker());
                System.out.println("Count of Even Numbers: " + count);
                break;
            case 2: // Odd Numbers
                count = countProperty(numbers, new OddChecker());
                System.out.println("Count of Odd Numbers: " + count);
                break;
            case 3: // Prime Numbers
                count = countProperty(numbers, new PrimeChecker());
                System.out.println("Count of Prime Numbers: " + count);
                break;
            case 4: // Palindromes
                count = countProperty(words, new PalindromeChecker());
                System.out.println("Count of Palindromes: " + count);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}

