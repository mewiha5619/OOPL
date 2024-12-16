import java.util.Scanner;

// Define the Complex class
class Complex {
    double real;
    double imaginary;

    // Default constructor (initializes both real and imaginary parts to 0)
    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    // Parameterized constructor to initialize complex number with given real and imaginary parts
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to add two complex numbers
    public Complex add(Complex c) {
        double realPart = this.real + c.real;
        double imaginaryPart = this.imaginary + c.imaginary;
        return new Complex(realPart, imaginaryPart);
    }

    // Method to subtract two complex numbers
    public Complex subtract(Complex c) {
        double realPart = this.real - c.real;
        double imaginaryPart = this.imaginary - c.imaginary;
        return new Complex(realPart, imaginaryPart);
    }

    // Method to multiply two complex numbers
    public Complex multiply(Complex c) {
        double realPart = (this.real * c.real) - (this.imaginary * c.imaginary);
        double imaginaryPart = (this.real * c.imaginary) + (this.imaginary * c.real);
        return new Complex(realPart, imaginaryPart);
    }

    // Method to divide two complex numbers
    public Complex divide(Complex c) {
        double denominator = c.real * c.real + c.imaginary * c.imaginary;
        double realPart = ((this.real * c.real) + (this.imaginary * c.imaginary)) / denominator;
        double imaginaryPart = ((this.imaginary * c.real) - (this.real * c.imaginary)) / denominator;
        return new Complex(realPart, imaginaryPart);
    }

    // Method to display the complex number in a+bi format
    public void display() {
        if (imaginary >= 0)
            System.out.println(real + " + " + imaginary + "i");
        else
            System.out.println(real + " - " + Math.abs(imaginary) + "i");
    }
}

public class ComplexNumberOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for first complex number
        System.out.println("Enter the first complex number:");
        System.out.print("Real part: ");
        double real1 = sc.nextDouble();
        System.out.print("Imaginary part: ");
        double imaginary1 = sc.nextDouble();
        Complex complex1 = new Complex(real1, imaginary1);

        // Input for second complex number
        System.out.println("Enter the second complex number:");
        System.out.print("Real part: ");
        double real2 = sc.nextDouble();
        System.out.print("Imaginary part: ");
        double imaginary2 = sc.nextDouble();
        Complex complex2 = new Complex(real2, imaginary2);

        // Perform and display arithmetic operations
        System.out.println("\nOperations on the two complex numbers:");

        // Addition
        Complex sum = complex1.add(complex2);
        System.out.print("Addition: ");
        sum.display();

        // Subtraction
        Complex difference = complex1.subtract(complex2);
        System.out.print("Subtraction: ");
        difference.display();

        // Multiplication
        Complex product = complex1.multiply(complex2);
        System.out.print("Multiplication: ");
        product.display();

        // Division
        Complex quotient = complex1.divide(complex2);
        System.out.print("Division: ");
        quotient.display();

        sc.close();
    }
}

