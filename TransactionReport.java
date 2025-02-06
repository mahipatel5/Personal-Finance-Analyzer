/*
 * 
 * This class generates a transaction report
 * 
 */

import java.util.Map;
import java.util.Scanner;

public class TransactionReport {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TransactionImporter.main(args);

        // Prompts user to enter budget and stores it
        System.out.print("Enter Budget: $");
        double budget = in.nextDouble();

        // Prints all categories and their totals
        System.out.println(" ______________________\n|  Transaction Report  |\n|______________________|\n");
        Map<String, Double> categoryTotals = TransactionCategorizer.categorizeTransactions(TransactionImporter.transactions);
        TransactionCategorizer.printCategoryTotals(categoryTotals);

        // Prints total income, total expenses, and net savings
        System.out.printf("%-20s $%-14.2f%n", "Total Income:", (TransactionCategorizer.printIncome(categoryTotals)));
        System.out.printf("%-20s $%-14.2f%n", "Total Expenses:", (TransactionCategorizer.printExpenses(categoryTotals)));
        System.out.printf("%-20s $%-14.2f%n", "Net Savings:", (TransactionCategorizer.printNetSavings()));

        // Prints biggest and smallest expense
        System.out.println(TransactionCategorizer.getBiggestExpense(categoryTotals));
        System.out.println(TransactionCategorizer.getSmallestExpense(categoryTotals));

        // Calculates and displays whether user is above or under budget 
        double b = TransactionCategorizer.printBudget(budget);
        if (b>=0){
            System.out.printf("%-20s $%-14.2f%n", "Amount Under Budget:", b);
        }
        else{
            System.out.printf("%-20s $%-14.2f%n", "Amount Over Budget:", b*-1);
        }

    }
}
