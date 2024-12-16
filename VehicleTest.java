// Step 1: Create the Vehicle Interface with common functionalities
interface Vehicle {
    void gearChange();   // Method to change gear
    void speedUp();      // Method to speed up
    void applyBrakes();  // Method to apply brakes
}

// Step 2: Bicycle class implementing Vehicle interface
class Bicycle implements Vehicle {

    @Override
    public void gearChange() {
        System.out.println("Bicycle: Gear changed to a new level.");
    }

    @Override
    public void speedUp() {
        System.out.println("Bicycle: Speeding up by pedaling faster.");
    }

    @Override
    public void applyBrakes() {
        System.out.println("Bicycle: Brakes applied to slow down.");
    }
}

// Step 3: Bike class implementing Vehicle interface
class Bike implements Vehicle {

    @Override
    public void gearChange() {
        System.out.println("Bike: Gear changed to a new level.");
    }

    @Override
    public void speedUp() {
        System.out.println("Bike: Accelerating by twisting the throttle.");
    }

    @Override
    public void applyBrakes() {
        System.out.println("Bike: Brakes applied to stop the bike.");
    }
}

// Step 4: Car class implementing Vehicle interface
class Car implements Vehicle {

    @Override
    public void gearChange() {
        System.out.println("Car: Gear shifted to a different position.");
    }

    @Override
    public void speedUp() {
        System.out.println("Car: Pressing the accelerator to speed up.");
    }

    @Override
    public void applyBrakes() {
        System.out.println("Car: Brakes applied to stop the car.");
    }
}

// Step 5: Main class to demonstrate the functionality
public class VehicleTest {
    public static void main(String[] args) {
        // Create instances of Bicycle, Bike, and Car
        Vehicle bicycle = new Bicycle();
        Vehicle bike = new Bike();
        Vehicle car = new Car();

        // Demonstrate the functionalities for each vehicle
        System.out.println("Bicycle:");
        bicycle.gearChange();
        bicycle.speedUp();
        bicycle.applyBrakes();

        System.out.println("\nBike:");
        bike.gearChange();
        bike.speedUp();
        bike.applyBrakes();

        System.out.println("\nCar:");
        car.gearChange();
        car.speedUp();
        car.applyBrakes();
    }
}

