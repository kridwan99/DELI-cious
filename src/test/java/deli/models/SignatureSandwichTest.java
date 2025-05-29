package deli.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SignatureSandwichTest {

    @Test
    public void testBLTSandwichProperties() {
        BLTSandwich blt = new BLTSandwich();

        assertEquals("BLT", blt.getName());
        assertEquals("White", blt.getBread());
        assertTrue(blt.isToasted());
        assertEquals(8, blt.getSize());

        // Check for expected toppings
        assertTrue(blt.getToppings().stream().anyMatch(t -> t.getName().contains("Bacon")));
        assertTrue(blt.getToppings().stream().anyMatch(t -> t.getName().contains("Cheddar")));
        assertTrue(blt.getToppings().stream().anyMatch(t -> t.getName().contains("Lettuce")));
        assertTrue(blt.getToppings().stream().anyMatch(t -> t.getName().contains("Tomato")));
        assertTrue(blt.getToppings().stream().anyMatch(t -> t.getName().contains("Ranch")));
    }

    @Test
    public void testPhillyCheeseSteakSandwichProperties() {
        PhillyCheeseSteakSandwich philly = new PhillyCheeseSteakSandwich();

        assertEquals("Philly Cheese Steak", philly.getName());
        assertEquals("White", philly.getBread());
        assertTrue(philly.isToasted());
        assertEquals(8, philly.getSize());

        // Check for expected toppings
        assertTrue(philly.getToppings().stream().anyMatch(t -> t.getName().contains("Steak")));
        assertTrue(philly.getToppings().stream().anyMatch(t -> t.getName().contains("American")));
        assertTrue(philly.getToppings().stream().anyMatch(t -> t.getName().contains("Peppers")));
        assertTrue(philly.getToppings().stream().anyMatch(t -> t.getName().contains("Mayo")));
    }
}
