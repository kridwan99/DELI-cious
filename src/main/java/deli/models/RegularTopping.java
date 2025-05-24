package deli.models;

// Represents free toppings (no additional cost)
public class RegularTopping extends AbstractTopping {
    public RegularTopping(String name) {
        super(name, false); // Regular toppings are never "extra"
    }

    @Override
    public double getPrice(SandwichSize size) {
        return 0.0; // Regular toppings are always free
    }
}
