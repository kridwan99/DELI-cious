package deli.screens;

import deli.models.Order;
import deli.utils.InputHelper;

// Handles the order confirmation process
public class CheckoutScreen {

    private final Order order;
    private final InputHelper inputHelper;

    public CheckoutScreen(Order order) {
        this.order = order;
        this.inputHelper = new InputHelper();
    }

    public void display() {
        System.out.println("Order Summary:");
        System.out.println(order);

        System.out.println("1) Confirm Order");
        System.out.println("0) Cancel Order");

        while (true) {
            int choice = inputHelper.readInt("Please select an option: ");
            switch (choice) {
                case 1:
                    order.saveReceipt(); // Saves receipt before finishing
                    System.out.println("✅ Order confirmed. Thank you!");
                    new HomeScreen().display(); // Returns to main menu
                    return;
                case 0:
                    System.out.println("Order has been canceled.");
                    new HomeScreen().display();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
