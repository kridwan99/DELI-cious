package deli.models;

public class PhillyCheeseSteakSandwich extends Sandwich {
    public PhillyCheeseSteakSandwich() {
        super("Philly Cheese Steak", "White", 8, true);

        addTopping(new Meat("Steak", false));
        addTopping(new Cheese("American", false));
        addTopping(new RegularTopping("Peppers"));
        addTopping(new RegularTopping("Mayo"));
    }
}
