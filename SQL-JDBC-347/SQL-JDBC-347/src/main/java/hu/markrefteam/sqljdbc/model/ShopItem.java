package hu.markrefteam.sqljdbc.model;

import java.time.LocalDate;
import java.util.Objects;

public class ShopItem {

    private Long id;
    private String itemName;
    private int itemPrice;
    private int quantity;
    private LocalDate dateAdded;

    public ShopItem(Long id, String itemName, int itemPrice, int quantity, LocalDate dateAdded) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
    }

    public ShopItem(String itemName, int itemPrice, int quantity, LocalDate dateAdded) {
        this(null, itemName, itemPrice, quantity, dateAdded);
    }

    public ShopItem(String itemName, int itemPrice, int quantity) {
        this(null, itemName, itemPrice, quantity, null);
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", quantity=" + quantity +
                ", dateAdded=" + dateAdded +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopItem)) return false;
        ShopItem shopItem = (ShopItem) o;
        return itemPrice == shopItem.itemPrice
                && quantity == shopItem.quantity
                && Objects.equals(id, shopItem.id)
                && Objects.equals(itemName, shopItem.itemName)
                && Objects.equals(dateAdded, shopItem.dateAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, itemPrice, quantity, dateAdded);
    }
}

