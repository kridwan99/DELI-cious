package deli.screens;

import deli.models.*;
import deli.utils.InputHelper;

import java.util.ArrayList;
import java.util.List;

// Handles sandwich customization (bread, size, toppings)
public class SandwichScreen {

    private final InputHelper inputHelper;

    public SandwichScreen() {
        this.inputHelper = new InputHelper();
    }

    public Bread selectBread() {
        System.out.println("Select your bread type:");
        Bread[] breadOptions = Bread.values();
        return inputHelper.readEnumChoice("Choose a bread type:", breadOptions);
    }

    public SandwichSize selectSize() {
        System.out.println("Select your sandwich size:");
        SandwichSize[] sizes = SandwichSize.values();
        return inputHelper.readEnumChoice("Choose a sandwich size:", sizes);
    }

    public List<AbstractTopping> selectToppings() {
        List<AbstractTopping> toppings = new ArrayList<>();

        // Meat selection
        String[] meatOptions = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
        for (String meat : meatOptions) {
            if (inputHelper.readBoolean("Add " + meat + "? (yes/no)")) {
                boolean extra = inputHelper.readBoolean("Extra " + meat + "? (yes/no)");
                toppings.add(new Meat(meat, extra));
            }
        }

        // Cheese selection
        String[] cheeseOptions = {"American", "Provolone", "Cheddar", "Swiss"};
        for (String cheese : cheeseOptions) {
            if (inputHelper.readBoolean("Add " + cheese + " cheese? (yes/no)")) {
                boolean extra = inputHelper.readBoolean("Extra " + cheese + " cheese? (yes/no)");
                toppings.add(new Cheese(cheese, extra));
            }
        }

        return toppings;
    }
}
