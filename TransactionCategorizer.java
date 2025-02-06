/*
 * 
 * This class categorizes transactions and calculates various summaries
 * 
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionCategorizer{
    public static double totalIncome=0.0;
    public static double totalExpenses=0.0;

    // Puts transaction categories in a hashmap with amounts as values
    public static Map<String, Double> categorizeTransactions(List<Transaction> transactions) {
        Map<String, Double> categoryTotals = new HashMap<>();

        for (Transaction t : transactions) {
            categoryTotals.put(t.getCategory(), 
                categoryTotals.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
        }

        return categoryTotals;
    }

    // Prints categories and their total amounts
    public static void printCategoryTotals(Map<String, Double> categoryTotals) {
        System.out.println("Category Totals:");
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.printf("%-20s: $%-14.2f%n", entry.getKey(), entry.getValue());
        }
        System.out.println("\n");
    }

    // Calculates and returns total income
    public static double printIncome(Map<String, Double> categoryTotals) {
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            if (entry.getKey().equals("Income")) {
                totalIncome += entry.getValue();
            }
        }
        return totalIncome;
        
    }

    // Calculates and returns total expenses
    public static double printExpenses(Map<String, Double> categoryTotals) {
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            if (!entry.getKey().equals("Income") && !entry.getKey().equals("Savings")) { 
                totalExpenses += entry.getValue()*-1;
            }
        }
        return totalExpenses;
    }

    // Caclulates and returns net savings
    public static double printNetSavings() {
        return totalIncome-totalExpenses;
    }

    // Prints comparison of budget and expenses
    public static double printBudget(double budget) {
        return budget-totalExpenses;
        
    }

    // Calculates and returns biggest expense
    public static String getBiggestExpense(Map<String, Double> categoryTotals) {
        double largestExpense = 0.0;
        String category = "";

        // Iterate over the map to find the largest expense
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            if (!entry.getKey().equals("Income") && !entry.getKey().equals("Savings")) { 
                double expense = entry.getValue() * -1; // Negate to get positive expense

                if (expense > largestExpense) {
                    largestExpense = expense;
                    category = entry.getKey();
                }
            }
        }
        return String.format("Largest Expense:     " + category + ": " + largestExpense);

    }

    // Calculates and returns smallest expense
    public static String getSmallestExpense(Map<String, Double> categoryTotals) {
        double smallestExpense = 1000;
        String category = "";

        // Iterate over the map to find the smallest expense
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            if (!entry.getKey().equals("Income") && !entry.getKey().equals("Savings")) { 
                double expense = entry.getValue() * -1; // Negate to get positive expense

                if (expense < smallestExpense) {
                    smallestExpense = expense;
                    category = entry.getKey();
                }
            }
        }
        return String.format("Smallest Expense:    " + category + ": " + smallestExpense);

    }

}