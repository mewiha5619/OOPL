import java.util.Scanner;

// Base class Shape (Abstract)
abstract class Shape {
    protected double value1;  // Represents base/length
    protected double value2;  // Represents height/width

    // Method to input dimensions of the shape
    public void inputDimensions(double value1, double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    // Abstract method to compute area
    public abstract double compute_area();
}

// Derived class Triangle
class Triangle extends Shape {
    // Constructor to initialize base and height
    public Triangle(double base, double height) {
        inputDimensions(base, height);
    }

    // Implementing the abstract method to compute area of triangle
    @Override
    public double compute_area() {
        return 0.5 * value1 * value2;  // Area = 1/2 * base * height
    }
}

// Derived class Rectangle
class Rectangle extends Shape {
    // Constructor to initialize length and width
    public Rectangle(double length, double width) {
        inputDimensions(length, width);
    }

    // Implementing the abstract method to compute area of rectangle
    @Override
    public double compute_area() {
        return value1 * value2;  // Area = length * width
    }
}

// Main class
public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the type of shape (1 for Triangle, 2 for Rectangle): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            // Triangle
            System.out.print("Enter the base of the triangle: ");
            double base = sc.nextDouble();
            System.out.print("Enter the height of the triangle: ");
            double height = sc.nextDouble();

            // Create Triangle object and calculate area
            Triangle triangle = new Triangle(base, height);
            double triangleArea = triangle.compute_area();
            System.out.println("Area of the Triangle: " + triangleArea);
        } 
        else if (choice == 2) {
            // Rectangle
            System.out.print("Enter the length of the rectangle: ");
            double length = sc.nextDouble();
            System.out.print("Enter the width of the rectangle: ");
            double width = sc.nextDouble();

            // Create Rectangle object and calculate area
            Rectangle rectangle = new Rectangle(length, width);
            double rectangleArea = rectangle.compute_area();
            System.out.println("Area of the Rectangle: " + rectangleArea);
        } 
        else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    }
}

