package deli.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SandwichTest {

    @Test
    public void testSandwichConstructorAndGetPrice() {
        Sandwich sandwich = new Sandwich("Wheat", 12, true); // ✅ fixed args
        assertEquals(8.50, sandwich.getPrice(), 0.01);        // ✅ correct price in dollars
    }

    @Test
    public void testToStringIncludesSizeAndBread() {
        Sandwich sandwich = new Sandwich("White", 8, false);  // ✅ fixed args
        String description = sandwich.toString();
        assertTrue(description.contains("8"));                // size in toString?
        assertTrue(description.contains("White"));
    }
}
