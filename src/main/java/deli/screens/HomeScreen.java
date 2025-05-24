package deli.screens;

import deli.models.Order;
import deli.utils.InputHelper;

// Main screen that welcomes the user
public class HomeScreen {

    private final InputHelper inputHelper;

    public HomeScreen() {
        this.inputHelper = new InputHelper();
    }

    public void display() {
        System.out.println("Welcome to DELI-cious!");

        while (true) {
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int choice = inputHelper.readInt("Please select an option: ");
            switch (choice) {
                case 1:
                    Order order = new Order();
                    OrderScreen orderScreen = new OrderScreen(order);
                    orderScreen.display(); // Moves to order selection
                    return; // Exits loop after handling the order
                case 0:
                    System.out.println("Thank you for visiting DELI-cious!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
