package com.techelevator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {
    private Drink drinkTest;
    @Before
    public void setup() {
        drinkTest = new Drink("C3", "Mountain Melter", 1.50, "Drink");
    }
    @Test
    public void sound_return_test() {
        Assert.assertEquals("Glug Glug, Yum!", drinkTest.message());
    }
    @Test
    public void return_to_get_item_number() {
        Assert.assertEquals("C3", drinkTest.getItemNumber());
    }
}
