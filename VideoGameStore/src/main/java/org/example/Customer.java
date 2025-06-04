package org.example;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(name + " successFully purchased " + game.getTitle());
    }


    @Override
    public String toString() {
        return "Customer: " + name + " | Wallet: " + walletBalance + "\nOwned Games: " + ownedGames;
    }
}
