package org.example;

import java.util.ArrayList;
import java.util.List;

public class RentalSystem {

    private List<Car> availableCars;

    public RentalSystem() {
        this.availableCars = new ArrayList<>();
    }

    public void addCar(Car car) {
        availableCars.add(car);
    }

    public void displayAvailableCars() {
        if (availableCars.isEmpty()) {
            System.out.println("No Cars available at the moment. ");
            return;
        }
        for (Car car : availableCars) {
            car.displayInfo();
            System.out.println("-------------------------");
        }
    }

    public Car findCarByPlateNumber(String plateNumber) {
        for (Car car : availableCars) {
            if (car.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                return car;
            }
        }
        return null;
    }

    public void rentCar(Car car,int days) {
        if(car == null) {
            System.out.println("Car not found");
            return;
        }
        double totalCost = car.calculateRentalCost(days);
        System.out.println("Renting Car: " + car.getPlateNumber());
        System.out.println("Brand: " + car.getBrand());
        System.out.println("Days: " + days);
        System.out.printf("Total cost: $%.2f%n", totalCost);
    }
}
