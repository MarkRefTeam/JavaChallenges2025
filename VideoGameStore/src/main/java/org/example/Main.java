package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Customer customer = new Customer("Mark", 42.0);

        //Methods for chatbot:
        Zino.sayHello();
        Zino.wastingTimeAfter5Sec();

        Store store = new Store();
        Game[] preloadedGames = Games.getPreloadedGames();
        for (Game game : preloadedGames) {
            store.addGame(game);
        }

        store.addCustomer(customer);
        store.addCustomer(new Customer("Ancsa", 100.00));

        while (true) {
            Zino.printMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            Zino.respondToMenuChoice(choice, customer, store, scanner);

            if (choice == 4) {
                break;
            }
            System.out.println("Thanks for stopping by, Legend! :D");
        }
    }
}

