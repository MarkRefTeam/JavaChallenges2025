package org.example;


public class Game {
    private String title;
    private String genre;
    private double price;
    private boolean inStock;

    public Game(String title, String genre, double price, boolean inStock) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.inStock = inStock;
    }

    public boolean isInStock() {
        return inStock;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public boolean inStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return String.format("Game: %s | Genre: %s | Price: $%.2f | In stock: %b",
                title, genre, price, inStock);
    }

}
