package com.techelevator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {
    private Gum gumTest;
    @Before
    public void setup() {
        gumTest = new Gum("D3", "Chiclets", 0.75, "Gum");
    }
    @Test
    public void sound_return_test() {
        Assert.assertEquals("Chew Chew, Yum!", gumTest.message());
    }
    @Test
    public void return_to_get_item_number() {
        Assert.assertEquals("D3", gumTest.getItemNumber());
    }
}
