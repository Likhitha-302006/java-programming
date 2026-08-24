import java.util.*;

abstract class Vehicle {
    protected double rate;

    public Vehicle(double rate) {
        this.rate = rate;
    }

 
    public abstract double calculateFare(double distance);
}

class Bike extends Vehicle {

    public Bike() {
        super(5);
    }


    public double calculateFare(double distance) {
        return distance * rate;
    }
}


class Auto extends Vehicle {

    public Auto() {
        super(12);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * rate;
    }
}

class Cab extends Vehicle {

    public Cab() {
        super(12);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * rate;
    }
}

class Driver {
    String name;

    public Driver(String name) {
        this.name = name;
    }
}


class Rider {
    String name;

    public Rider(String name) {
        this.name = name;
    }
}


class Trip {

    private Rider rider;
    private Driver driver;
    private Vehicle vehicle;
    private double distance;

    public Trip(Rider rider, Driver driver,
                Vehicle vehicle, double distance) {

        if (distance <= 0) {
            throw new IllegalArgumentException(
                "Distance must be greater than 0"
            );
        }

        this.rider = rider;
        this.driver = driver;
        this.vehicle = vehicle;
        this.distance = distance;
    }

    public double getFare() {
        return vehicle.calculateFare(distance);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String rideType = sc.next();
            double distance = sc.nextDouble();

            try {

                Vehicle vehicle;

                if (rideType.equalsIgnoreCase("Bike")) {
                    vehicle = new Bike();

                } else if (rideType.equalsIgnoreCase("Auto")) {
                    vehicle = new Auto();

                } else if (rideType.equalsIgnoreCase("Cab")) {
                    vehicle = new Cab();

                } else {
                    throw new IllegalArgumentException(
                        "Invalid ride type"
                    );
                }

                Rider rider = new Rider("Rider");
                Driver driver = new Driver("Driver");

                Trip trip = new Trip(
                    rider,
                    driver,
                    vehicle,
                    distance
                );

                System.out.println((int) trip.getFare());

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid booking");
            }
        }

        sc.close();
    }
}



 Input
3
Bike 10
Cab 15
Auto 8

Output
50
180
96
