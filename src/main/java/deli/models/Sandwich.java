package deli.models;

import java.util.List;

public class Sandwich {
    private String bread;
    private SandwichSize size;
    private List<AbstractTopping> toppings;
    private List<String> sauces;
    private boolean toasted;

    public Sandwich(String bread, SandwichSize size, List<AbstractTopping> toppings, List<String> sauces, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings;
        this.sauces = sauces;
        this.toasted = toasted;
    }

    // Add method to calculate price
    public double calculatePrice() {
        double price = size.getPrice() + getBreadPrice(bread);
        for (AbstractTopping topping : toppings) {
            price += topping.getPrice(size);
        }
        return price;
    }

    private double getBreadPrice(String bread) {
        switch (bread.toLowerCase()) {
            case "white": return 5.50;
            case "wheat": return 7.00;
            case "rye": return 8.50;
            case "wrap": return 8.50;
            default: return 0;
        }
    }

    // toString and other getters/setters
}
