package deli.services;

import deli.models.*;

public class OrderService {
    private Order currentOrder;

    public void startNewOrder() {
        currentOrder = new Order();
    }

    public void cancelOrder() {
        currentOrder = null;
    }

    public boolean hasActiveOrder() {
        return currentOrder != null;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void addSandwich(Sandwich sandwich) {
        if (currentOrder != null) {
            currentOrder.addItem(sandwich);  // ✅ FIXED
        }
    }

    public void addDrink(Drink drink) {
        if (currentOrder != null) {
            currentOrder.addItem(drink);     // ✅ FIXED
        }
    }

    public void addChips(Chips chips) {
        if (currentOrder != null) {
            currentOrder.addItem(chips);     // ✅ FIXED
        }
    }

    public void checkout() {
        if (currentOrder != null) {
            ReceiptService.saveReceipt(currentOrder);
            currentOrder = null;
        }
    }
}
