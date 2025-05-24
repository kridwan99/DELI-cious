package deli.models;

// Represents a premium meat topping
public class Meat extends AbstractTopping {
    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(SandwichSize size) { // Calculates price based on size
        double base = switch (size) {
            case FOUR_INCH -> 1.00;
            case EIGHT_INCH -> 2.00;
            case TWELVE_INCH -> 3.00;
        };
        return base + (isExtra() ? base / 2 : 0); // Extra meat costs 50% more
    }
}
