package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.String.format;

public class Customer {

    private String name;
    private double walletBalance;
    private List<Game> ownedGames;

    public Customer(String name, double walletBalance) {
        this.name = name;
        this.walletBalance = walletBalance;
        this.ownedGames = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void addFunds(double amount) {
        walletBalance += amount;
    }

    public void addGame(Game game) {
        ownedGames.add(game);
    }

    public void removeGame(Game game) {
        ownedGames.remove(game);
    }

    public void purchaseGame(Game game) {
        if (!game.inStock()) {
            System.out.println("Error: Game is not in stock.");
            return;
        }

        if (walletBalance < game.getPrice()) {
            System.out.println("Error: Insufficient funds to purchase " + game.getTitle());
            return;
        }

        walletBalance -= game.getPrice();
        ownedGames.add(game);
        game.setInStock(false);
        System.out.println("Zino: " + game.getTitle() + " purchased successfully!");
    }

    public List<Game> getOwnedGames() {
        return ownedGames;
    }

    //ConcurrentModificationException ,wtf????

    //An "iterator" is a tool that lets you safely loop through a collection
    //(like an ArrayList) and remove items during the loop without causing errors.

    public Game removeGameByName(String gameName) {
        Iterator<Game> iterator = ownedGames.iterator();
        while (iterator.hasNext()) {
            Game game = iterator.next();
            if (game.getTitle().equalsIgnoreCase(gameName)) {
                iterator.remove();
                return game;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("Customer: %s | Wallet: %.2f | Owned games: %d",
                this.name, this.walletBalance, this.ownedGames.size());
    }
}
