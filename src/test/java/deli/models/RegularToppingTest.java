package deli.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularToppingTest {

    @Test
    public void testRegularToppingName() {
        RegularTopping topping = new RegularTopping("Lettuce");
        assertEquals("Lettuce", topping.getName());
    }

    @Test
    public void testRegularToppingPriceAlwaysZero() {
        RegularTopping topping = new RegularTopping("Lettuce");
        assertEquals(0.0, topping.getPrice(4), 0.01);
        assertEquals(0.0, topping.getPrice(8), 0.01);
        assertEquals(0.0, topping.getPrice(12), 0.01);
    }

    @Test
    public void testIsPremiumFalse() {
        RegularTopping topping = new RegularTopping("Onion");
        assertFalse(topping.isPremium());
    }
}
