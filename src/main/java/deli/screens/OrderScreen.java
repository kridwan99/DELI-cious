package deli.screens;

import deli.models.Order;
import deli.utils.InputHelper;

// Handles the ordering process and lets the user customize their sandwich
public class OrderScreen {

    private final Order order;
    private final InputHelper inputHelper;

    public OrderScreen(Order order) {
        this.order = order;
        this.inputHelper = new InputHelper();
    }

    public void display() {
        System.out.println("🛒 Start your order!");

        // 1) Select sandwich
        SandwichScreen sandwichScreen = new SandwichScreen();
        order.setBread(sandwichScreen.selectBread());
        order.setSize(sandwichScreen.selectSize());
        order.setToasted(inputHelper.readBoolean("Would you like it toasted? (yes/no)"));

        // 2) Select drink
        DrinkScreen drinkScreen = new DrinkScreen();
        order.setDrink(drinkScreen.createDrink());

        // 3) Select chips
        ChipsScreen chipsScreen = new ChipsScreen();
        order.setChips(chipsScreen.selectChips());

        // 4) Proceed to checkout
        CheckoutScreen checkoutScreen = new CheckoutScreen(order);
        checkoutScreen.display();
    }
}
