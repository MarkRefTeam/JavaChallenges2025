package org.example;

import java.util.ArrayList;

public class Store {

    private ArrayList<Game> games;
    private ArrayList<Customer> customers;

    public Store() {
        this.games = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void listAvailableGames() {
        System.out.println("Games currently in stock:");
        for (Game game : games) {
            if (game.inStock()) {
                System.out.println(game);
            }
        }
    }

    public void listCustomers() {
        System.out.println("Registered Customers: ");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public Customer findCustomerByName(String name) {
        for(Customer customer : customers) {
            if(customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public Game removeGameByName(String gameName) {
        for(Game game : games) {
            if(game.getTitle().equalsIgnoreCase(gameName)) {
                games.remove(game);
                return game;
            }
        }
        return null;
    }

    public Game getGameByName(String gameName) {
        for(Game game : games) {
            if(game.getTitle().equalsIgnoreCase(gameName)) {
                return game;
            }
        }
        return null;
    }

    public void processSaleRequest(String gameTitle,String customerName) {
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
    public ArrayList<Game> getGames() {
        return games;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

}
