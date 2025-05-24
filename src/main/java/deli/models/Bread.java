package deli.models;

// Enum to represent different types of bread with associated prices
public enum Bread {
    WHITE(5.50),
    WHEAT(7.00),
    RYE(8.50),
    WRAP(8.50);

    private final double price;

    Bread(double price) { // Constructor to set the price
        this.price = price;
    }

    public double getPrice() { // Method to retrieve the price
        return price;
    }
}
