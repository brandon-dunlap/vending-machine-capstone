
package com.techelevator;

public abstract class Item {
    private String itemNumber;
    private String itemName;
    private double price;
    private String itemType;
    private int quantity =5;
    private boolean outOfStock;
    private int totalItemsSold = 0;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalItemsSold() {
        return totalItemsSold;
    }

    public void setTotalItemsSold(int totalItemsSold) {
        this.totalItemsSold = this.totalItemsSold + 1;
    }

    public Item(String itemNumber, String itemName, double price, String itemType) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
    }
    public boolean isOutOfStock() {
        if (this.quantity == 0) {
            outOfStock = true; }
        return outOfStock;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String message() {
        return null;
    }

    @Override
    public String toString() {
        return itemNumber + ") " + itemName + " $" + price + ", " + quantity + " in stock";
    }
}