package org.example;

import java.util.ArrayList;
import java.util.List;

public class Store {

    final List<Game> games;
    final List<Customer> customers;

    public Store() {
        this.games = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    //Game:

    public void addGame(Game game) {
        games.add(game);
    }

    public void removeGame(Game game) {
        games.remove(game);
    }

    public void listAvailableGames() {
        System.out.println("Games currently in stock:");
        for (Game game : games) {
            if (game.inStock()) {
                System.out.println(game);
            }
        }
    }

    public Game removeGameByName(String gameName) {
        for (Game game : games) {
            if (game.getTitle().equalsIgnoreCase(gameName)) {
                games.remove(game);
                return game;
            }
        }
        return null;
    }

    //searching with "flag" logic:

    public void searchGamesByTitle(String keyword) {
        boolean found = false;
        for(Game game : games) {
            if(game.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(game);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Zino: Sorry, no games found for " + keyword + ". :( ");
        }
    }

    //Customers:

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void listCustomers() {
        System.out.println("Registered Customers: ");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public Game getGameByName(String gameName) {
        for (Game game : games) {
            if (game.getTitle().equalsIgnoreCase(gameName)) {
                return game;
            }
        }
        return null;
    }

    public void processSaleRequest(String gameTitle, String customerName) {
        Game selectedGame = null;
        Customer selectedCustomer = null;

        for (Game game : games) {
            if (game.getTitle().equalsIgnoreCase(gameTitle)) {
                selectedGame = game;
                break;
            }
        }
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                selectedCustomer = customer;
                break;
            }
        }
        if (selectedGame == null) {
            System.out.println("Game not found");
            return;
        }
        if (selectedCustomer == null) {
            System.out.println("Customer not found");
            return;
        }

        selectedCustomer.purchaseGame(selectedGame);
    }

    //List's:

    public List<Game> getGames() {
        return games;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

}
