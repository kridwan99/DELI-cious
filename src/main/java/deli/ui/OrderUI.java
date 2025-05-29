package deli.ui;

import deli.models.*;
import deli.services.OrderService;
import deli.services.ReceiptService;
import deli.utils.SignUpHelper;

import java.util.Scanner;

public class OrderUI {
    private final Scanner scanner = new Scanner(System.in);
    private final OrderService orderService;
    private final ReceiptService receiptService = new ReceiptService(); // ✅ added

    public enum Sauce {
        MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLANDS, VINAIGRETTE;

        public static boolean isValid(String input) {
            for (Sauce s : values()) {
                if (s.name().replace("_", " ").equalsIgnoreCase(input)) return true;
            }
            return false;
        }

        public static String[] getFormattedList() {
            return java.util.Arrays.stream(values())
                    .map(s -> s.name().replace("_", " ").toLowerCase())
                    .toArray(String[]::new);
        }
    }

    public OrderUI(OrderService orderService) {
        this.orderService = orderService;
    }

    public void display() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("\n--- Current Order Menu ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("5) Add Signature Sandwich");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> new SandwichUI().addSandwich(orderService);
                case "2" -> new DrinkUI().addDrink(orderService);
                case "3" -> new ChipsUI().addChips(orderService);
                case "4" -> {
                    System.out.println("\n" + receiptService.generateReceipt(orderService.getCurrentOrder()));

                    System.out.print("Would you like delivery? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        String userInfo = SignUpHelper.signUp();
                        System.out.println("\n🚚 Delivery confirmed for: " + userInfo);
                    }

                    System.out.print("Confirm checkout? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        orderService.checkout();
                        ordering = false;
                    }
                }
                case "5" -> addSignatureSandwich();
                case "0" -> {
                    System.out.println("Order cancelled.");
                    orderService.cancelOrder();
                    ordering = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void addSignatureSandwich() {
        System.out.println("Choose a Signature Sandwich:");
        System.out.println("1) BLT");
        System.out.println("2) Philly Cheese Steak");

        String choice = scanner.nextLine();
        Sandwich sandwich = null;

        switch (choice) {
            case "1" -> {
                sandwich = new BLTSandwich();
                System.out.println("BLT added.");
            }
            case "2" -> {
                sandwich = new PhillyCheeseSteakSandwich();
                System.out.println("Philly Cheese Steak added.");
            }
            default -> System.out.println("Invalid choice.");
        }

        if (sandwich != null) {
            orderService.addSandwich(sandwich);
        }
    }
}
