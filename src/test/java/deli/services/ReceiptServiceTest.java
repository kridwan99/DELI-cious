package deli.services;

import deli.models.Order;
import deli.models.Sandwich;
import deli.models.Drink;
import deli.models.Chips;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptServiceTest {

    @Test
    public void testReceiptIncludesTotal() {
        Order order = new Order();
        order.addItem(new Sandwich("8", "White", 600, false));  // $6.00
        order.addItem(new Drink("Sprite", 1.99));
        order.addItem(new Chips("Doritos", 1.49));

        ReceiptService receiptService = new ReceiptService();
        String receipt = receiptService.generateReceipt(order);

        assertNotNull(receipt, "Receipt should not be null");
        assertTrue(receipt.contains("Total"), "Receipt should contain the word 'Total'");
    }

    @Test
    public void testReceiptForEmptyOrder() {
        Order order = new Order();

        ReceiptService receiptService = new ReceiptService();
        String receipt = receiptService.generateReceipt(order);

        assertTrue(receipt.contains("Total: $0.00"), "Receipt should show total $0.00 for empty order");
    }

    @Test
    public void testReceiptListsEachItem() {
        Order order = new Order();
        Sandwich sandwich = new Sandwich("12", "Wheat", 800, true); // $8.00
        Drink drink = new Drink("Coke", 2.00);
        Chips chips = new Chips("Lays", 1.50);

        order.addItem(sandwich);
        order.addItem(drink);
        order.addItem(chips);

        ReceiptService receiptService = new ReceiptService();
        String receipt = receiptService.generateReceipt(order);

        assertTrue(receipt.contains("Coke"), "Receipt should list drink");
        assertTrue(receipt.contains("Lays"), "Receipt should list chips");
        assertTrue(receipt.contains("Wheat"), "Receipt should describe sandwich");
    }
}
