/*
 * 
 * This class represents a transaction with the date, description, amount, and category
 * 
 */

public class Transaction {
    private String date;
    private String description;
    private double amount;
    private String category;

    // Constructors
    public Transaction(String date, String description, double amount, String category) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public Transaction() {
        this.date = "0000-00-00";
        this.description = "Default Transaction";
        this.amount = 0.0;
        this.category = "Uncategorized";
    }

    // Getters for data, description, amount, and category
    public String date() {
        return date;
    }

    public String description() {
        return description;
    }
    
    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    // Overrides toString method to print transaction
    @Override
    public String toString() {
        return date + " | " + description + " | $" + amount + " | " + category;
    }

}
