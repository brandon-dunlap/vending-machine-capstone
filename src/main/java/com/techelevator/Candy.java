package com.techelevator;

public class Candy extends Item {
    public Candy(String itemNumber, String itemName, double price, String itemType) {
        super(itemNumber, itemName, price, itemType);
    }
    private String candyMessage = "Munch Munch, Yum!";
    @Override
    public String message() {
        return candyMessage;
    }

}
