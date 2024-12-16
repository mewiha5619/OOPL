package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericCollectionCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter numbers (type 'done' to finish):");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else if (scanner.next().equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Please enter a valid number or 'done' to finish.");
            }
        }

        System.out.println("Count of even numbers: " + countEven(numbers));
        System.out.println("Count of odd numbers: " + countOdd(numbers));
        System.out.println("Count of prime numbers: " + countPrimes(numbers));
        System.out.println("Count of palindromes: " + countPalindromes(numbers));
        
        scanner.close();
    }

    public static long countEven(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).count();
    }

    public static long countOdd(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 != 0).count();
    }

    public static long countPrimes(List<Integer> numbers) {
        return numbers.stream().filter(GenericCollectionCounter::isPrime).count();
    }

    public static long countPalindromes(List<Integer> numbers) {
        return numbers.stream().filter(GenericCollectionCounter::isPalindrome).count();
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
