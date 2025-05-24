package deli.services;

import deli.models.Order;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Service to handle saving order receipts.
 */
public class ReceiptService {

    /**
     * Saves the order receipt to a file inside the "receipts" folder.
     * The filename is based on the current timestamp.
     *
     * @param order The order to save.
     */
    public void saveReceipt(Order order) {
        // Ensure the "receipts" directory exists
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdirs(); // Create the directory if it doesn't exist
        }

        // Generate timestamp-based filename
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        File receiptFile = new File(directory, timestamp + ".txt");

        // Save receipt
        try (PrintWriter writer = new PrintWriter(new FileWriter(receiptFile))) {
            writer.println(order.toString()); // Write order details
            System.out.println("✅ Receipt saved: " + receiptFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("⚠️ Error saving receipt: " + e.getMessage());
        }
    }
}
