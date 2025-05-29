package deli.ui;

import deli.models.*;
import deli.services.OrderService;
import deli.utils.InputHelper;

import java.util.Scanner;

public class SandwichUI {
    private final Scanner scanner = new Scanner(System.in);

    public void addSandwich(OrderService orderService) {
        int size = InputHelper.getInt("Enter sandwich size (4, 8, or 12): ");
        String bread = InputHelper.getString("Choose bread (white, wheat, rye, wrap): ");
        boolean toasted = InputHelper.getYesNo("Toasted? (yes/no): ");

        Sandwich sandwich = new Sandwich(bread, size, toasted);

        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("Add topping: (type: meat/cheese/regular, name, extra true/false):");
            String[] parts = scanner.nextLine().split(",");
            if (parts.length >= 2) {
                String type = parts[0].trim().toLowerCase();
                String name = parts[1].trim();
                boolean extra = parts.length > 2 && Boolean.parseBoolean(parts[2].trim());

                Topping topping = switch (type) {
                    case "meat" -> new Meat(name, extra);
                    case "cheese" -> new Cheese(name, extra);
                    case "regular" -> new RegularTopping(name);
                    default -> null;
                };

                if (topping != null) {
                    sandwich.addTopping(topping);
                    System.out.println("Topping added.");
                } else {
                    System.out.println("Invalid topping type.");
                }
            }
            System.out.print("Add another topping? (yes/no): ");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                addingToppings = false;
            }
        }

        System.out.println("Available sauces:");
        for (String sauce : OrderUI.Sauce.getFormattedList()) {
            System.out.println("- " + sauce);
        }

        boolean addMoreSauce = true;
        while (addMoreSauce) {
            String sauceInput = InputHelper.getString("Add a sauce from the list above (or type 'done'): ").toLowerCase();
            if (sauceInput.equals("done")) {
                addMoreSauce = false;
            } else if (OrderUI.Sauce.isValid(sauceInput)) {
                sandwich.addTopping(new RegularTopping(sauceInput));
                System.out.println(sauceInput + " added.");
            } else {
                System.out.println("Invalid sauce. Try again.");
            }
        }

        orderService.addSandwich(sandwich);
        System.out.println("✅ Sandwich added to order.");
    }
}
