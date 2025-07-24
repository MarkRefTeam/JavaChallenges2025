package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car extends Vehicle {

    private Brand brand;
    private String model;

    public Car(String plateNumber, double rentPrice, Brand brand, String model) {
        super(plateNumber, rentPrice);
        this.brand = brand;
        this.model = model;
    }


    @Override
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Plate Number: " + getPlateNumber());
        System.out.println("Rent Price: " + getRentPrice());
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentPrice() * days;
    }
}
