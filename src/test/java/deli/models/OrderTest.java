package deli.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OrderTest {

    @Test
    public void testAddItem() {
        Order order = new Order();
        Sandwich sandwich = new Sandwich("White", 8, false);  // ✅ fixed args
        order.addItem(sandwich);
        assertEquals(1, order.getItems().size());
    }

    @Test
    public void testGetItems() {
        Order order = new Order();
        Drink drink = new Drink(DrinkSize.LARGE, "Coke");
        order.addItem(drink);
        List<Object> items = order.getItems();
        assertTrue(items.contains(drink));
    }

    @Test
    public void testCalculateTotal() {
        Order order = new Order();
        order.addItem(new Sandwich("Wheat", 8, true));            // $7.00
        order.addItem(new Drink(DrinkSize.MEDIUM, "Coke"));       // $2.50
        order.addItem(new Chips("Lays"));                         // $1.50

        double total = order.calculateTotal();
        assertEquals(11.00, total, 0.01);                         // ✅ Updated total
    }

    @Test
    public void testEmptyOrderTotalIsZero() {
        Order order = new Order();
        assertEquals(0.0, order.calculateTotal());
    }
}
