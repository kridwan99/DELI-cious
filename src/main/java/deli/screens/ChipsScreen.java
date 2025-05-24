package deli.screens;

import deli.models.Chips;
import deli.utils.InputHelper;

// Handles chips selection
public class ChipsScreen {

    private final InputHelper inputHelper;

    public ChipsScreen() {
        this.inputHelper = new InputHelper();
    }

    public Chips selectChips() {
        System.out.println("Select your chips:");

        String[] chipOptions = {"Classic", "BBQ", "Sour Cream & Onion", "Salt & Vinegar"};
        String choice = inputHelper.readChoice("Choose a chip type:", chipOptions);

        System.out.println("✅ You selected: " + choice + " Chips!");
        return new Chips(choice);
    }
}
