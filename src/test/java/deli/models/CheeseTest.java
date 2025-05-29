package deli.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheeseTest {

    @Test
    public void testCheeseNameWithoutExtra() {
        Cheese cheese = new Cheese("Swiss", false);
        assertEquals("Swiss", cheese.getName());
    }

    @Test
    public void testCheeseNameWithExtra() {
        Cheese cheese = new Cheese("Cheddar", true);
        assertEquals("Cheddar (Extra)", cheese.getName());
    }

    @Test
    public void testCheesePriceWithSize() {
        assertEquals(0.75, new Cheese("Swiss", false).getPrice(4), 0.01);
        assertEquals(1.50, new Cheese("Swiss", false).getPrice(8), 0.01);
        assertEquals(2.25, new Cheese("Swiss", false).getPrice(12), 0.01);
    }

    @Test
    public void testCheeseExtraPrice() {
        assertEquals(0.375, new Cheese("Swiss", true).getPrice(4), 0.01);
        assertEquals(0.75, new Cheese("Swiss", true).getPrice(8), 0.01);
        assertEquals(1.125, new Cheese("Swiss", true).getPrice(12), 0.01);
    }

    @Test
    public void testIsPremiumTrue() {
        Cheese cheese = new Cheese("American", false);
        assertTrue(cheese.isPremium());
    }
}
