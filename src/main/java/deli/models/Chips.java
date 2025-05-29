package deli.models;

public class Chips {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    public double getPrice() {
        return 1.50;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "*****Chips*****\n" +
                type + " - $" + String.format("%.2f", getPrice()) + "\n";
    }
}
