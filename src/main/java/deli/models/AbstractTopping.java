package deli.models;

// Abstract class for toppings (common properties shared by all types of toppings)
public abstract class AbstractTopping {
    private final String name;
    private final boolean isExtra;

    public AbstractTopping(String name, boolean isExtra) { // Constructor
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() { // Get topping name
        return name;
    }

    public boolean isExtra() { // Check if extra topping
        return isExtra;
    }

    public abstract double getPrice(SandwichSize size); // Abstract method for price calculation
}
