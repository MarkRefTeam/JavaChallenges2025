package org.example;

import org.example.Security.AntiHackSystem;
import org.example.Security.IPbanSystem;

public class Main {

    public static void main(String[] args) {

        RentalSystem rentalSystem = new RentalSystem();
        AntiHackSystem antiHack = new AntiHackSystem();
        IPbanSystem iPbanSystem = new IPbanSystem();

        String username = "User1";
        String password = "wrongpass";

        for (int i = 0; i < 6; i++) {
            if(!antiHack.isLocked(username)) {
                boolean success = false;
                if(!success) {
                    antiHack.recordFailedAttempt(username);
                }
            } else {
                System.out.println(username + " is locked due to too many failed attempts.");
                break;
            }
        }

        iPbanSystem.banIP("192.168.0.2");
        System.out.println("Is 192.168.0.2 banned? " + iPbanSystem.isBanned("192.168.0.2"));

        Car car1 = new Car("ABC-123", 50.0, Brand.MERCEDES, "C-Class");
        Car car2 = new Car("XYZ-789", 30.0, Brand.TRABANT, "601");
        Car car3 = new Car("DEF-456", 70.0, Brand.BMW, "X5");

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        String userIP = "192.168.0.1";
        if(iPbanSystem.isBanned(userIP)) {
            System.out.println("Your IP is banned, access denied.");
            return;
        }

        System.out.println("Available cars: ");
        rentalSystem.displayAvailableCars();

        System.out.println("\nRenting a car: ");
        rentalSystem.rentCar(car2, 5);
    }
}
