package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class WalletTest {

    @Test
    public void addMoney_puts_money_in_wallet_test() {
        Wallet fullWallet = new Wallet();
        double oneDollar = 1.00;
        fullWallet.addMoney(oneDollar);
        double expected = 1.00;
        Assert.assertEquals(expected, fullWallet.getBalance(), .00001);

    }

    @Test
    public void purchases_withdraws_money_test() {
        Wallet emptyWallet = new Wallet();
        double twoDollars = 2.00;
        emptyWallet.addMoney(twoDollars);
        emptyWallet.purchases(twoDollars);
        double expected1 = 0.0;
        Assert.assertEquals(expected1, emptyWallet.getBalance(), .00001);
    }

}
