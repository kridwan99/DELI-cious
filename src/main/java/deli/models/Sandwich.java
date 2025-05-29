package deli.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String bread;
    private int size;
    private boolean toasted;
    private List<Topping> toppings;
    private String name; // Optional name like "BLT"

    // Constructor without name
    public Sandwich(String bread, int size, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
        this.name = null;
    }

    // Constructor with name (e.g., for signature sandwiches)
    public Sandwich(String name, String bread, int size, boolean toasted) {
        this(bread, size, toasted);
        this.name = name;
    }

    // Add topping to the sandwich
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Calculate price based on size and toppings
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

    // Getters
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

    public int getSize() {
        return size;
    }

    // String representation of the sandwich
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*****Sandwich");
        if (name != null) {
            sb.append(" (").append(name).append(")");
        }
        sb.append("*****\n");
        sb.append("Bread: ").append(bread).append("\n");
        sb.append("Size: ").append(size).append("\n"); // ✅ Added line to fix your test
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
