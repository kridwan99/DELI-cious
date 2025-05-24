package deli.models;

// Represents a drink item
public class Drink {
    private final String size;
    private final String flavor;

    public Drink(String size, String flavor) {
        this.size = size.toLowerCase(); // Convert to lowercase for uniformity
        this.flavor = flavor;
    }

    public double getPrice() { // Determines price based on size
        return switch (size) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }

    @Override
    public String toString() { // Formats drink selection for display
        return flavor + " (" + size + ")";
    }
}
