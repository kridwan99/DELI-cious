package deli.models;

// Represents a premium cheese topping
public class Cheese extends AbstractTopping {
    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(SandwichSize size) { // Calculates price based on size
        double base = switch (size) {
            case FOUR_INCH -> 0.75;
            case EIGHT_INCH -> 1.50;
            case TWELVE_INCH -> 2.25;
        };
        return base + (isExtra() ? base * 0.4 : 0); // Extra cheese costs 40% more
    }
}
