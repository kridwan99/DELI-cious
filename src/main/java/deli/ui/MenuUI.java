package deli.ui;

import java.util.Scanner;

public class MenuUI {

    private Scanner scanner;

    public MenuUI() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("==================================");
            System.out.println("   Welcome to DELI-cious Deli!");
            System.out.println("==================================");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Please choose an option: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("\nStarting a new order...\n");
                    // TODO: Call OrderUI.startOrder() or similar
                    break;
                case "0":
                    System.out.println("Thank you for visiting DELI-cious. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }

        scanner.close();
    }
}
