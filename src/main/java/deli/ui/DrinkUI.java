package deli.ui;

import deli.models.Drink;
import deli.models.DrinkSize;
import deli.services.OrderService;
import deli.utils.InputHelper;

public class DrinkUI {
    public void addDrink(OrderService orderService) {
        String sizeInput = InputHelper.getString("Enter drink size (small, medium, large): ").toLowerCase();
        DrinkSize size = switch (sizeInput) {
            case "small" -> DrinkSize.SMALL;
            case "medium" -> DrinkSize.MEDIUM;
            case "large" -> DrinkSize.LARGE;
            default -> {
                System.out.println("Invalid size. Defaulting to small.");
                yield DrinkSize.SMALL;
            }
        };

        String flavor = InputHelper.getString("Enter drink flavor (e.g., cola, lemonade): ");

        Drink drink = new Drink(size, flavor);
        orderService.addDrink(drink);
        System.out.println("✅ Drink added to order.");
    }
}
