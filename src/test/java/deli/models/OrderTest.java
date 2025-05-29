package deli.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OrderTest {

    @Test
    public void testAddItem() {
        Order order = new Order();
        Sandwich sandwich = new Sandwich("8", "White", 550, false); // 550 cents = $5.50
        order.addItem(sandwich);
        assertEquals(1, order.getItems().size(), "Item should be added to order");
    }

    @Test
    public void testGetItems() {
        Order order = new Order();
        Drink drink = new Drink("Coke", 1.99);
        order.addItem(drink);
        List<Object> items = order.getItems();
        assertTrue(items.contains(drink), "Order should contain the drink");
    }

    @Test
    public void testCalculateTotal() {
        Order order = new Order();
        order.addItem(new Sandwich("8", "Wheat", 600, true));  // $6.00
        order.addItem(new Drink("Coke", 1.99));                // $1.99
        order.addItem(new Chips("Lays", 1.49));                // $1.49

        double total = order.calculateTotal();
        assertEquals(9.48, total, 0.01, "Total should be correct with all items added");
    }

    @Test
    public void testEmptyOrderTotalIsZero() {
        Order order = new Order();
        assertEquals(0.0, order.calculateTotal(), "Empty order should total 0");
    }
}
