package deli.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DrinkTest {

    @Test
    public void testSmallDrinkPrice() {
        Drink drink = new Drink(DrinkSize.SMALL, "Cola");
        assertEquals(2.00, drink.getPrice(), 0.01); // ✅ Match Drink.java
    }

    @Test
    public void testMediumDrinkPrice() {
        Drink drink = new Drink(DrinkSize.MEDIUM, "Cola");
        assertEquals(2.50, drink.getPrice(), 0.01); // ✅ Match Drink.java
    }

    @Test
    public void testLargeDrinkPrice() {
        Drink drink = new Drink(DrinkSize.LARGE, "Cola");
        assertEquals(3.00, drink.getPrice(), 0.01); // ✅ Match Drink.java
    }

    @Test
    public void testGetFlavor() {
        Drink drink = new Drink(DrinkSize.SMALL, "Lemonade");
        assertEquals("Lemonade", drink.getFlavor());
    }

    @Test
    public void testGetSize() {
        Drink drink = new Drink(DrinkSize.MEDIUM, "Lemonade");
        assertEquals(DrinkSize.MEDIUM, drink.getSize());
    }

    @Test
    public void testToString() {
        Drink drink = new Drink(DrinkSize.LARGE, "Root Beer");
        String output = drink.toString().toLowerCase(); // 🟢 Safe case-insensitive match
        assertTrue(output.contains("root beer"));
        assertTrue(output.contains("3.00")); // Check formatted price
    }
}
