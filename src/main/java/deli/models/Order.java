package deli.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Object> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(Object item) {
        items.add(item);
    }

    public List<Object> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Object item : items) {
            if (item instanceof Sandwich s) {
                total += s.getPrice() / 100.0; // If stored in cents
            } else if (item instanceof Drink d) {
                total += d.getPrice();
            } else if (item instanceof Chips c) {
                total += c.getPrice();
            }
        }
        return total;
    }
}
