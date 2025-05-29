package deli.services;

import deli.models.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptService {
    private static final String RECEIPT_FOLDER = "receipts";

    public String generateReceipt(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("------ RECEIPT ------\n");
        for (Object item : order.getItems()) {
            sb.append(item.toString()).append("\n"); // assumes toString() is meaningful
        }
        sb.append("---------------------\n");
        sb.append(String.format("Total: $%.2f\n", order.calculateTotal()));
        sb.append("---------------------\n");
        return sb.toString();
    }

    public static void saveReceipt(Order order) {
        try {
            File folder = new File(RECEIPT_FOLDER);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String filename = RECEIPT_FOLDER + "/" + timestamp + ".txt";

            // 👇 Use generateReceipt here
            String receiptText = new ReceiptService().generateReceipt(order);

            try (FileWriter writer = new FileWriter(filename)) {
                writer.write(receiptText);
            }

            System.out.println("Receipt saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }
}
