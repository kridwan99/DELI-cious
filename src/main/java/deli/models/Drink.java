package deli.models;

public class Drink {
    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice() {
        return switch (size) {
            case SMALL -> 2.00;
            case MEDIUM -> 2.50;
            case LARGE -> 3.00;
        };
    }

    public String getFlavor() {
        return flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "*****Drink*****\n" +
                flavor + " - $" + String.format("%.2f", getPrice()) + "\n";
    }
}
