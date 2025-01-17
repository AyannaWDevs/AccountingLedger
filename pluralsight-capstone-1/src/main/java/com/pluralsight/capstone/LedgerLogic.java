package com.pluralsight.capstone;
import static com.pluralsight.capstone.ReadAndWrite.transactions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerLogic {

    public static ArrayList<Transaction> getData() {
        return transactions;
    }

    public static void displayEntries() {
        transactions.forEach(System.out::println);
//        for (Transaction transaction : transactions) {
//            System.out.println(transaction);
//        }
    }

    public static void displayDeposits() {
        transactions.stream().filter(t -> t.getAmount() >= 0).forEach(System.out::println);
//        for (Transaction transaction : transactions) {
//            if (transaction.getAmount() >= 0) {
//                System.out.println(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount() + "\n");
//            }
//        }
    }

    public static void displayPayments() {
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() <= 0) {
                System.out.println(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount() + "\n");
            }
        }
    }

    public static String getDate() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static void reportMtD() {
        String[] currentDateParts = getDate().split("-");
        String currentYear = currentDateParts[0];
        String currentMonth = currentDateParts[1];
        for (Transaction transaction : transactions) {
            String[] transactionDateParts = transaction.getDate().split("-");
            String transactionYear = transactionDateParts[0];
            String transactionMonth = transactionDateParts[1];

            if (transactionYear.equals(currentYear) && transactionMonth.equals(currentMonth)) {
                System.out.println(
                        transaction.getDate() + " | " +
                                transaction.getTime() + " | " + transaction.getDescription() + " | " + transaction.getVendor() + " | " + transaction.getAmount());
            }
        }

    }

    public static void reportPreviousMonth() {
        LocalDate previousMonthDate = LocalDate.now().minusMonths(1);
        String previousYear = String.valueOf(previousMonthDate.getYear());
        String previousMonth = String.format("%02d", previousMonthDate.getMonthValue());  // Ensure 2 digits
        for (Transaction transaction : transactions) {
            String[] transactionDateParts = transaction.getDate().split("-");
            String transactionYear = transactionDateParts[0];
            String transactionMonth = transactionDateParts[1];
            if (transactionYear.equals(previousYear) && transactionMonth.equals(previousMonth)) {
                System.out.println(transaction.getDate() + " | " + transaction.getTime() + " | " + transaction.getDescription() + " | " + transaction.getVendor() + " | " + transaction.getAmount());
            }
        }
    }

    public static void reportYtD() {
        String currentYear = String.valueOf(LocalDate.now().getYear());
        System.out.println("Year-to-Date (YTD) Transactions:");
        for (Transaction transaction : transactions) {
            String transactionYear = transaction.getDate().split("-")[0];
            if (transactionYear.equals(currentYear)) {
                System.out.println(
                        transaction.getDate() + " | " + transaction.getTime() + " | " + transaction.getDescription() + " | " + transaction.getVendor() + " | " + transaction.getAmount());
            }
        }
    }

    public static void reportPreviousYear() {
        String previousYear = String.valueOf(LocalDate.now().minusYears(1).getYear());
        System.out.println("Previous Year Transactions:");
        for (Transaction transaction : transactions) {
            String transactionYear = transaction.getDate().split("-")[0];  // Extract the year
            if (transactionYear.equals(previousYear)) {
                System.out.println(transaction.getDate() + " | " + transaction.getTime() + " | " + transaction.getDescription() + " | " + transaction.getVendor() + " | " + transaction.getAmount());
            }
        }
    }

    public static void reportVendorSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the vendor name to search: ");
        String vendor = scanner.nextLine().trim();
        boolean found = false;  // Track if any transactions are found
        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println(transaction.getDate() + " | " + transaction.getTime() + " | " + transaction.getDescription() + " | " + transaction.getVendor() + " | " + transaction.getAmount());
                found = true;
            }
        }
        // If no transactions match, print a message
        if (!found) {
            System.out.println("No transactions found for vendor: " + vendor);
        }
    }
}