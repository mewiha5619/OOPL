package code;

import java.util.Scanner;

interface Vehicle {
    void gearChange(int gear);
    void speedUp(int increment);
    void applyBrakes(int decrement);
}

class Bicycle implements Vehicle {
    private int speed;
    private int gear;

    @Override
    public void gearChange(int gear) {
        this.gear = gear;
        System.out.println("Bicycle gear changed to: " + gear);
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bicycle speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.println("Bicycle speed decreased to: " + speed);
    }
}

class Bike implements Vehicle {
    private int speed;
    private int gear;

    @Override
    public void gearChange(int gear) {
        this.gear = gear;
        System.out.println("Bike gear changed to: " + gear);
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bike speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.println("Bike speed decreased to: " + speed);
    }
}

class Car implements Vehicle {
    private int speed;
    private int gear;

    @Override
    public void gearChange(int gear) {
        this.gear = gear;
        System.out.println("Car gear changed to: " + gear);
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Car speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.println("Car speed decreased to: " + speed);
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle;

        System.out.println("Choose a vehicle (1: Bicycle, 2: Bike, 3: Car): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                vehicle = new Bicycle();
                break;
            case 2:
                vehicle = new Bike();
                break;
            case 3:
                vehicle = new Car();
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("Enter gear change: ");
        int gear = scanner.nextInt();
        vehicle.gearChange(gear);

        System.out.println("Enter speed increment: ");
        int increment = scanner.nextInt();
        vehicle.speedUp(increment);

        System.out.println("Enter speed decrement: ");
        int decrement = scanner.nextInt();
        vehicle.applyBrakes(decrement);

        scanner.close();
    }
}
