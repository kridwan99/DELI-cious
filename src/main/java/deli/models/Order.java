package deli.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Represents a customer order
public class Order {
    private final List<AbstractTopping> toppings = new ArrayList<>();
    private Bread bread;
    private SandwichSize size;
    private Drink drink;
    private Chips chips;
    private boolean toasted;

    public void addTopping(AbstractTopping topping) {
        toppings.add(topping);
    }

    public void setBread(Bread bread) { // Sets bread type
        this.bread = bread;
    }

    public void setSize(SandwichSize size) { // Sets sandwich size
        this.size = size;
    }

    public void setDrink(Drink drink) { // Adds drink to order
        this.drink = drink;
    }

    public void setChips(Chips chips) { // Adds chips to order
        this.chips = chips;
    }

    public void setToasted(boolean toasted) { // Sets toasted preference
        this.toasted = toasted;
    }

    public double calculateTotal() { // Calculates total order cost
        double total = bread.getPrice() + size.getPrice();
        for (AbstractTopping topping : toppings) {
            total += topping.getPrice(size);
        }
        if (drink != null) total += drink.getPrice();
        if (chips != null) total += chips.getPrice();
        return total;
    }

    public void saveReceipt() { // Saves receipt to a file
        String filename = "receipts/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(this.toString());
            System.out.println("Receipt saved: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }

    @Override
    public String toString() { // Formats order details for display
        StringBuilder sb = new StringBuilder();
        sb.append("Bread: ").append(bread).append("\n");
        sb.append("Size: ").append(size).append("\n");
        sb.append("Toppings: ");
        for (AbstractTopping topping : toppings) {
            sb.append(topping.getName()).append(topping.isExtra() ? " (Extra)" : "").append(", ");
        }
        sb.append("\n");
        if (drink != null) sb.append("Drink: ").append(drink).append("\n");
        if (chips != null) sb.append("Chips: ").append(chips).append("\n");
        sb.append("Toasted: ").append(toasted ? "Yes" : "No").append("\n");
        sb.append("Total: $").append(calculateTotal()).append("\n");
        return sb.toString();
    }
}
