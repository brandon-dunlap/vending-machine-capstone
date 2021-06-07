package com.techelevator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipsTest {
    private Chips chipsTest;
    @Before
    public void setup() {
        chipsTest = new Chips("A1", "Potato Crisps", 3.05, "Chips");
    }
    @Test
    public void sound_return_test() {
        Assert.assertEquals("Crunch Crunch, Yum!", chipsTest.message());
    }
    @Test
    public void return_to_get_item_number() {
        Assert.assertEquals("A1", chipsTest.getItemNumber());
    }
}
