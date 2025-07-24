package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Vehicle {

    private String plateNumber;
    private double rentPrice;

    //abstract:

    public abstract void displayInfo();

    public abstract double calculateRentalCost(int days);
}
