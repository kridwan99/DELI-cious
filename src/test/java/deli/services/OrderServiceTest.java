// OrderServiceTest.java
package deli.services;

import deli.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        orderService = new OrderService();
    }

    @Test
    public void testStartNewOrder() {
        orderService.startNewOrder();
        assertTrue(orderService.hasActiveOrder());
        assertNotNull(orderService.getCurrentOrder());
    }

    @Test
    public void testCancelOrder() {
        orderService.startNewOrder();
        orderService.cancelOrder();
        assertFalse(orderService.hasActiveOrder());
    }

    @Test
    public void testAddSandwich() {
        orderService.startNewOrder();
        Sandwich sandwich = new Sandwich("White", 8, true);
        orderService.addSandwich(sandwich);
        assertTrue(orderService.getCurrentOrder().getItems().contains(sandwich));
    }

    @Test
    public void testAddDrink() {
        orderService.startNewOrder();
        Drink drink = new Drink(DrinkSize.SMALL, "Cola");
        orderService.addDrink(drink);
        assertTrue(orderService.getCurrentOrder().getItems().contains(drink));
    }

    @Test
    public void testAddChips() {
        orderService.startNewOrder();
        Chips chips = new Chips("Lays");
        orderService.addChips(chips);
        assertTrue(orderService.getCurrentOrder().getItems().contains(chips));
    }

    @Test
    public void testCheckoutClearsOrder() {
        orderService.startNewOrder();
        orderService.addChips(new Chips("Doritos"));
        orderService.checkout();
        assertFalse(orderService.hasActiveOrder());
    }
}
