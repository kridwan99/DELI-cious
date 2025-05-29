// Sandwich.java
package deli.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String bread;
    private int size;
    private boolean toasted;
    private List<Topping> toppings;
    private String name; // Optional name like "BLT"

    public Sandwich(String bread, int size, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
        this.name = null;
    }

    public Sandwich(String name, String bread, int size, boolean toasted) {
        this(bread, size, toasted);
        this.name = name;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getPrice() {
        double price = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };

        for (Topping topping : toppings) {
            price += topping.getPrice(size);
        }

        return price;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public String getBread() {
        return bread;
    }

    public boolean isToasted() {
        return toasted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*****Sandwich");
        if (name != null) {
            sb.append(" (").append(name).append(")");
        }
        sb.append("*****\n");
        sb.append("Bread: ").append(bread).append("\n");
        sb.append("Toasted: ").append(toasted ? "Yes" : "No").append("\n");

        sb.append("Premium Toppings: ");
        toppings.stream()
                .filter(t -> t instanceof Meat || t instanceof Cheese)
                .forEach(t -> sb.append(t.getName()).append(" "));
        sb.append("\n");

        sb.append("Regular Toppings: ");
        toppings.stream()
                .filter(t -> t instanceof RegularTopping)
                .forEach(t -> sb.append(t.getName()).append(" "));
        sb.append("\n");

        sb.append("Price: $").append(String.format("%.2f", getPrice()));
        return sb.toString();
    }
}
