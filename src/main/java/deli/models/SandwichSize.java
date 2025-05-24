package deli.models;

// Enum to represent sandwich sizes and their base prices
public enum SandwichSize {
    FOUR_INCH(4.00), EIGHT_INCH(5.00), TWELVE_INCH(6.00);

    private final double price;

    SandwichSize(double price) { // Constructor to set price
        this.price = price;
    }

    public double getPrice() { // Method to get price
        return price;
    }
}
