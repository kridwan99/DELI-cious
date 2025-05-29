package deli.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChipsTest {

    @Test
    public void testGetType() {
        Chips chips = new Chips("BBQ");
        assertEquals("BBQ", chips.getType());
    }

    @Test
    public void testGetPrice() {
        Chips chips = new Chips("BBQ");
        assertEquals(1.50, chips.getPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Chips chips = new Chips("BBQ");
        String output = chips.toString().toLowerCase();
        assertTrue(output.contains("bbq"));
        assertTrue(output.contains("1.50"));
        assertTrue(output.contains("chips")); // From header line
    }
}
