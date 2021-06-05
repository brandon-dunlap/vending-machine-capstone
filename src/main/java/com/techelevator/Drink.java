package com.techelevator;

public class Drink extends Item {
    public Drink(String itemNumber, String itemName, double price, String itemType) {
        super(itemNumber, itemName, price, itemType);
    }
    private String drinkMessage = "Glug Glug, Yum!";
    @Override
    public String message() {
        return drinkMessage;
    }

}
