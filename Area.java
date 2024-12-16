package code;

import java.util.Scanner;

abstract class Shape {
    double value1;
    double value2;

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first dimension: ");
        value1 = scanner.nextDouble();
        System.out.print("Enter second dimension: ");
        value2 = scanner.nextDouble();
    }

    abstract double compute_area();
}

class Triangle extends Shape {
    @Override
    double compute_area() {
        return 0.5 * value1 * value2;
    }
}

class Rectangle extends Shape {
    @Override
    double compute_area() {
        return value1 * value2;
    }
}

public class Area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter shape type (triangle/rectangle): ");
        String shapeType = scanner.nextLine();

        Shape shape;
        if (shapeType.equalsIgnoreCase("triangle")) {
            shape = new Triangle();
        } else {
            shape = new Rectangle();
        }

        shape.input();
        System.out.println("The area is: " + shape.compute_area());
    }
}
