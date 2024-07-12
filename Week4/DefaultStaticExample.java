interface Vehicle {
    // default method
    default void start() {
        System.out.println("Vehicle is starting");
    }

    // static method
    static void service() {
        System.out.println("Vehicle is being serviced");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting");
    }
}

class Bike implements Vehicle {
    // does not override the default method
}

public class DefaultStaticExample {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start(); // overridden method

        Vehicle bike = new Bike();
        bike.start(); // default method in Vehicle

        // calling static method
        Vehicle.service();
    }
}
