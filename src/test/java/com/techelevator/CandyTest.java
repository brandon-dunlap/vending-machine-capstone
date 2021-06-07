package com.techelevator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {
    private Candy candyTest;
    @Before
    public void setup() {
        candyTest = new Candy("B1", "Moonpie", 1.80, "Candy");
    }
    @Test
    public void sound_return_test() {
        Assert.assertEquals("Munch Munch, Yum!", candyTest.message());
    }
    @Test
    public void return_to_get_item_number() {
        Assert.assertEquals("B1", candyTest.getItemNumber());
    }
}
