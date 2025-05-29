package deli.ui;
import deli.models.Chips;

import deli.services.OrderService;
import deli.utils.InputHelper;

public class ChipsUI {
    public void addChips(OrderService orderService) {
        String chipType = InputHelper.getString("Enter chip type (e.g., BBQ, Sour Cream, Plain): ");
        Chips chips = new Chips(chipType);
        orderService.addChips(chips);
        System.out.println("✅ Chips added to order.");
    }
}
