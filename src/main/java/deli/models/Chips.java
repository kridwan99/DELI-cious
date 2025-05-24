package deli.models;

// Represents a chip item
public class Chips {
    private final String type;

    public Chips(String type) {
        this.type = type;
    }

    public double getPrice() { // Fixed price for all chips
        return 1.50;
    }

    @Override
    public String toString() { // Formats chips selection for display
        return type + " Chips";
    }
}
