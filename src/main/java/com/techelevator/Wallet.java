package com.techelevator;

public class Wallet {
    private double balance;
    private int quarter;
    private int dime;
    private int nickel;

    public Wallet() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void addMoney(double total) {
        balance += total;
    }

    public void purchases(double total) {
        balance -= total;
    }

    public void giveChange(Double balance) {
        double lastBalance = balance;
        balance = (balance * 100); // this converts balance to a whole number
        quarter = (int) (balance / 25); // all coins will be cast to integers to be whole numbers
        balance = balance - (quarter * 25);
        dime = (int) (balance / 10);
        balance = balance - (dime * 10);
        nickel = (int) (balance / 5);

        System.out.println("Your change is " + quarter + " quarters, " + dime + " dimes, and " + nickel + " nickels.");

        Logger.writeLog("GIVE CHANGE: $" + lastBalance + " $" + 0.00);
    }
}