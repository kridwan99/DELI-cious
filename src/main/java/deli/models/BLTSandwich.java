package deli.models;

public class BLTSandwich extends Sandwich {
    public BLTSandwich() {
        super("BLT", "White", 8, true); // name, bread, size, toasted

        addTopping(new Meat("Bacon", false));
        addTopping(new Cheese("Cheddar", false));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Tomato"));
        addTopping(new RegularTopping("Ranch")); // Sauce is a topping
    }
}
