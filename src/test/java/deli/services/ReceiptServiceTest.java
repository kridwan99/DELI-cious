package deli.services;

import deli.models.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptServiceTest {

    @Test
    public void testReceiptIncludesItems() {
        Order order = new Order();
        order.addItem(new Sandwich("8", "White", 600, true));
        order.addItem(new Drink(DrinkSize.LARGE, "Coke"));    // ✅ Fixed
        order.addItem(new Chips("Doritos"));

        ReceiptService receiptService = new ReceiptService();
        String receipt = receiptService.generateReceipt(order);

        assertTrue(receipt.contains("Coke"));
        assertTrue(receipt.contains("Doritos"));
        assertTrue(receipt.contains("Total"));
    }

    @Test
    public void testReceiptForEmptyOrder() {
        Order order = new Order();
        ReceiptService receiptService = new ReceiptService();
        String receipt = receiptService.generateReceipt(order);
        assertTrue(receipt.contains("Total: $0.00"));
    }
}
