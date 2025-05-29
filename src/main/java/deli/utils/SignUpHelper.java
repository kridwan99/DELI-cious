package deli.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class SignUpHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String signUp() {
        boolean validEmail = false;
        boolean validPassword = false;
        String[] parts = new String[0];
        String email = "", password = "", firstName = "", lastName = "", phone = "", address = "";

        System.out.println("\n🛵 Delivery requires an account. Please sign up below:");

        System.out.print("First name: ");
        firstName = scanner.nextLine();

        System.out.print("Last name: ");
        lastName = scanner.nextLine();

        System.out.print("Phone number: ");
        phone = scanner.nextLine();

        while (!validEmail) {
            System.out.print("Email: ");
            email = scanner.nextLine().trim();
            parts = email.split("[@.]");

            if (parts.length > 2 && email.contains("@") && email.contains(".")) {
                validEmail = true;
            } else {
                System.out.println("❌ Invalid email address. Please try again.");
            }
        }

        while (!validPassword) {
            System.out.print("Password (8 characters or more): ");
            password = scanner.nextLine();

            if (password.length() >= 8) {
                System.out.print("Delivery address: ");
                address = scanner.nextLine();

                try {
                    File dir = new File("users");
                    if (!dir.exists()) dir.mkdir(); // Auto-create users/ folder

                    String fileName = "users/" + parts[0] + ".csv";
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                        writer.write(email + "," + password + "," + firstName + "," + lastName + "," + phone + "," + address);
                        writer.newLine();
                        System.out.println("✅ Sign-up successful! Welcome, " + firstName + " " + lastName + "!");
                        validPassword = true;
                    }
                } catch (IOException e) {
                    System.out.println("❌ Error saving user info.");
                }
            } else {
                System.out.println("❌ Password must be at least 8 characters.");
            }
        }

        return firstName + " " + lastName + " <" + email + "> | " + phone + " | " + address;
    }
}
