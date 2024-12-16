package code;
import java.util.Scanner;
class Complex {
    private double real;
    private double imaginary;

    // Default constructor
    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    // Parameterized constructor
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Addition of two Complex numbers
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Subtraction of two Complex numbers
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }
    // String representation of the Complex number
    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }

    // Complex method to demonstrate the functionality
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of First real no.");
        int real1 = sc.nextInt();
        System.out.println("Enter the value of First img no.");
        int img1 = sc.nextInt();
        System.out.println("Enter the value of Second real no.");
        int real2 = sc.nextInt();
        System.out.println("Enter the value of Second real no.");
        int img2 = sc.nextInt();
        // Creating Complex numbers
        Complex c1 = new Complex(real1, img1);  // 3 + 2i
        Complex c2 = new Complex(real2,img2);  // 1 + 7i

        // Performing arithmetic operations
        System.out.println("Complex Number 1: " + c1);
        System.out.println("Complex Number 2: " + c2);

        // Addition
        Complex c3 = c1.add(c2);
        System.out.println("Addition: " + c3);

        // Subtraction
        Complex c4 = c1.subtract(c2);
        System.out.println("Subtraction: " + c4);
    }
}