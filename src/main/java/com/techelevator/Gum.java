package com.techelevator;

public class Gum extends Item {
    public Gum(String itemNumber, String itemName, double price, String itemType) {
        super(itemNumber, itemName, price, itemType);
    }
    private String gumMessage = "Chew Chew, Yum!";
    @Override
    public String message() {
        return gumMessage;
    }

}