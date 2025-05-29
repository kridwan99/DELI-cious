package deli.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeatTest {

    @Test
    public void testMeatNameWithoutExtra() {
        Meat meat = new Meat("Ham", false);
        assertEquals("Ham", meat.getName());
    }

    @Test
    public void testMeatNameWithExtra() {
        Meat meat = new Meat("Turkey", true);
        assertEquals("Turkey (Extra)", meat.getName());
    }

    @Test
    public void testMeatPriceWithSize() {
        assertEquals(1.00, new Meat("Ham", false).getPrice(4), 0.01);
        assertEquals(2.00, new Meat("Ham", false).getPrice(8), 0.01);
        assertEquals(3.00, new Meat("Ham", false).getPrice(12), 0.01);
    }

    @Test
    public void testMeatExtraPrice() {
        assertEquals(0.50, new Meat("Ham", true).getPrice(4), 0.01);
        assertEquals(1.00, new Meat("Ham", true).getPrice(8), 0.01);
        assertEquals(1.50, new Meat("Ham", true).getPrice(12), 0.01);
    }

    @Test
    public void testIsPremiumTrue() {
        Meat meat = new Meat("Roast Beef", false);
        assertTrue(meat.isPremium());
    }
}
