package com.techelevator;

public class Chips extends Item {
    public Chips(String itemNumber, String itemName, double price, String itemType) {
        super(itemNumber, itemName, price, itemType);
    }
    private String chipsMessage = "Crunch Crunch, Yum!";
    @Override
    public String message() {
        return chipsMessage;
    }

}
