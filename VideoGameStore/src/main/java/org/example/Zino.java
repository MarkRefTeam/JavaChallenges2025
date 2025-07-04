package org.example;

import java.util.Scanner;

public class Zino {

    //Formats:
    //String: %s
    //Int %d
    //Double %.2f
    //New line: %n

    public static void sayHello() {

        //ChatBot welcome message:
        System.out.println("-------------------------");
        System.out.println("Hi , my name is Zino (Mark first interactive chatbot prototype!!");
        System.out.println("I'am the owner of this humble (but Legendary :D) video game store ");
        System.out.println("Need game? A cheat code? A bad pun?");
        System.out.println("You're a right place, man..!");
        System.out.println("What can i help today?");
        System.out.println("-------------------------");
    }

    public static void wastingTimeAfter5Sec() {

        //Easter eggs coming, just wait 5 sec!
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Zino: Someone interrupted my dramatic silence!");
        }
        System.out.println("Zino: I'm aging faster than your loading screen, come on...");
    }

    public static void printMenu() {

        System.out.println();
        System.out.println("1. Browse games");
        System.out.println("2. Check wallet");
        System.out.println("3. Buy a cheat code");
        System.out.println("4. Show customers");
        System.out.println("5. Our loyal crew");
        System.out.println("6. Transfer or sell games :P");
        System.out.println("7. Searching Games");
        System.out.println("8. Upload some Credit!");
        System.out.println("9. Your owned games");
        System.out.println("10. Exit! Bye :D");
    }

    public static void respondToMenuChoice(int choice, Customer customer, Store store, Scanner scanner) {

        switch (choice) {
            case 1 -> {
                System.out.println("Zino: Here's what we've got in stock!");
                for (Game game : store.getGames()) {
                    if (game.inStock()) {
                        System.out.printf(":) %s - %s ($%.2f)%n", game.getTitle(), game.getGenre(), game.getPrice());
                    }
                }
                System.out.println("Zino: Don't see your favorite game? Tough luck ,kiddo :D :D");
            }

            case 2 -> {
                System.out.println("Zino: Let me count your coins...");
                System.out.printf("Zino: %s, you have %.2f credit left in your wallet!%n",
                        customer.getName(), customer.getWalletBalance());
            }

            case 3 -> {
                System.out.println("Zino: One cheat code coming right up!");
                System.out.println("Zino: Use 'IDDQD' next time for god mode"); //You know Doom right? :D
            }

            case 4 -> {
                System.out.println("Zino: These are our current customers (tech view):");
                for (Customer c : store.getCustomers()) {
                    System.out.println(" - " + c);
                }
            }
            case 5 -> {
                System.out.println("Zino: Here's the crew who's been keeping this store alive: ");
                System.out.println("-----------------------------------------");
                store.listCustomers();
                System.out.println("-----------------------------------------");
            }


            case 6 -> {
                System.out.println("Zino: What do you want to do?");
                System.out.println("1.Transfer game between customer");
                System.out.println("2. Sell game to the customer");

                int subChoice = scanner.nextInt();
                scanner.nextLine();

                if (subChoice == 1) {
                    System.out.println("Enter sender's name: ");
                    String fromName = scanner.nextLine();
                    System.out.println("Enter receiver's name: ");
                    String toName = scanner.nextLine();
                    System.out.println("Enter game titles: ");
                    String gameName = scanner.nextLine();

                    Customer from = store.findCustomerByName(fromName);
                    Customer to = store.findCustomerByName(toName);
                    GameLogic.transferGame(store, from, to, gameName);

                } else if (subChoice == 2) {
                    System.out.print("Enter buyer's name: ");
                    String buyerName = scanner.nextLine();
                    System.out.print("Enter game title: ");
                    String gameName = scanner.nextLine();

                    Customer buyer = store.findCustomerByName(buyerName);
                    GameLogic.sellGame(store, buyer, gameName);
                } else {
                    System.out.println("Zino: Invalid choice, bro");
                }
            }

            case 7 -> {
                System.out.println("Zino: Let's find some treasures in the vault");
                System.out.print("Enter a keyword to search: ");

                String keyword = scanner.nextLine();
                store.searchGamesByTitle(keyword);
            }


            case 8 -> {
                System.out.println("Enter your name");

                String name = scanner.nextLine();
                Customer current = store.findCustomerByName(name);
                if (current != null) {
                    System.out.println("Enter amount to add:");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    current.addFunds(amount);
                    System.out.printf("Zino: Added %d credit to %s's wallet!%n", amount, name);
                } else {
                    System.out.println("Zino: Customer not found!");
                }
            }

            case 9 -> {
                System.out.println("Enter you name ");

                String cName = scanner.nextLine();
                Customer selected = store.findCustomerByName(cName);
                if (selected != null) {
                    System.out.println("Zino: Here's what " + cName + " owns: ");
                    for (Game game : selected.getOwnedGames()) {
                        System.out.println("- " + game.getTitle());
                    }
                } else {
                    System.out.println("Zino: Customer not found!");
                }
            }

            case 10 -> System.out.println("Zino: See you , gamer!");

            default -> System.out.println("Zino: That's not on the list, try again!");
        }
    }
}
