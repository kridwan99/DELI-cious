package deli.utils;

import java.util.Scanner;

/**
 * A utility class for handling user input.
 * Provides methods to read integers, enum choices, string selections, and boolean responses.
 */
public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in); // Use a single Scanner instance

    /**
     * Reads an integer input from the user, ensuring valid numeric entry.
     * @param prompt The message to display before user input.
     * @return A valid integer entered by the user.
     */
    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt + " "); // Display prompt

            // Check if input exists before reading
            if (!scanner.hasNextLine()) {
                System.out.println("⚠️ Error: No input detected.");
                continue;
            }

            String input = scanner.nextLine().trim(); // Read and trim input

            // Debugging print statement (for testing issues)
            System.out.println("DEBUG: User entered -> '" + input + "'");

            if (input.isEmpty()) { // Ensure input is not empty
                System.out.println("⚠️ Input cannot be empty. Please enter a valid number.");
                continue;
            }

            try {
                return Integer.parseInt(input); // Convert input to integer safely
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid number. Please enter an integer."); // Error message
            }
        }
    }

    /**
     * Reads a choice from a list of string options.
     * Ensures user selects a valid option.
     * @param prompt The message to display.
     * @param options Array of available options.
     * @return The selected option.
     */
    public String readChoice(String prompt, String[] options) {
        while (true) {
            System.out.println(prompt);
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d) %s%n", i + 1, options[i]); // Display numbered list of options
            }

            int choice = readInt("Enter choice number:"); // Get integer input
            if (choice >= 1 && choice <= options.length) {
                return options[choice - 1]; // Return selected option
            }

            System.out.println("⚠️ Invalid choice. Try again."); // Error message
        }
    }

    /**
     * Reads an Enum choice from available values.
     * Ensures user selects a valid Enum option.
     * @param prompt The message to display.
     * @param values Array of available Enum constants.
     * @return The selected Enum constant.
     */
    public <T extends Enum<T>> T readEnumChoice(String prompt, T[] values) {
        while (true) {
            System.out.println(prompt);
            for (int i = 0; i < values.length; i++) {
                System.out.printf("%d) %s%n", i + 1, values[i].name()); // Display Enum options
            }

            int choice = readInt("Enter choice number:"); // Get integer input
            if (choice >= 1 && choice <= values.length) {
                return values[choice - 1]; // Return selected Enum constant
            }

            System.out.println("⚠️ Invalid choice. Try again."); // Error message
        }
    }

    /**
     * Reads a yes/no input from the user and returns a boolean value.
     * @param prompt The message to display before user input.
     * @return True if the user selects "yes", False if "no".
     */
    public boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt + " (yes/no): "); // Prompt for input

            // Check if input exists before reading
            if (!scanner.hasNextLine()) {
                System.out.println("⚠️ Error: No input detected.");
                continue;
            }

            String input = scanner.nextLine().trim().toLowerCase(); // Read and normalize input

            if (input.equals("yes") || input.equals("y")) return true;
            if (input.equals("no") || input.equals("n")) return false;

            System.out.println("⚠️ Please enter 'yes' or 'no'."); // Error message
        }
    }
}
