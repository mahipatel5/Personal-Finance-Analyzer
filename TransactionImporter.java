/*
 * 
 * This class handles import of a file
 * 
 */
import java.io.*;
import java.util.*;
public class TransactionImporter {

    // A list to store transactions
    public static List<Transaction> transactions = new ArrayList<>();
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            br.readLine(); // Skip the header

            // Reads transactions line by line and stores them in list
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 4);
                if (data.length == 4) {
                    String date = data[0].trim();
                    String description = data[1].trim();
                    double amount = Double.parseDouble(data[2].trim());
                    String category = data[3].trim();
                    transactions.add(new Transaction(date, description, amount, category));
                }
            }

        // Handles file reading errors
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

    }
}