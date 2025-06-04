package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer("Mark",42.0);

        //Methods for chatbot:
        Zino.sayHello();
        Zino.wastingTimeAfter10Sec();

        Store store = new Store();
        store.addGame(new Game("Elder Scrolls", "RPG", 59.99,true));
        store.addGame(new Game("Doom Eternal", "FPS",49.99,true ));
        store.addGame(new Game("Cyberpunk 2077","RPG", 39.99, false));

        store.addCustomer(customer);
        store.addCustomer(new Customer("Ancsa", 100.00));

        store.listAvailableGames();

        while(true) {
            Zino.printMenu();
            int choice = scanner.nextInt();
            Zino.respondToMenuChoice(choice,customer,store, scanner);

            if (choice == 4) {
                break;
            }
            System.out.println("Thanks for stopping by, Legend! :D");
        }
    }
}

