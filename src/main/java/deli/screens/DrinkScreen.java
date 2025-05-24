package deli.screens;

import deli.models.Drink;
import deli.utils.InputHelper;

// Handles drink selection
public class DrinkScreen {

    private final InputHelper inputHelper;

    public DrinkScreen() {
        this.inputHelper = new InputHelper();
    }

    public Drink createDrink() {
        System.out.println("Select your drink:");

        String[] sizes = {"Small", "Medium", "Large"};
        String size = inputHelper.readChoice("Choose a size:", sizes).toLowerCase();

        String[] flavors = {"Cola", "Lemonade", "Water", "Iced Tea"};
        String flavor = inputHelper.readChoice("Choose a flavor:", flavors);

        System.out.println("✅ You selected: " + size + " " + flavor + "!");
        return new Drink(size, flavor);
    }
}
