package com.pluralsight.capstone;
import static com.pluralsight.capstone.ReadAndWrite.transactions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;


// Updated for loops to use streams for better code readability
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
        transactions.stream().filter(t -> t.getAmount() <= 0).forEach(System.out::println);
//        for (Transaction transaction : transactions) {
//            if (transaction.getAmount() <= 0) {
//                System.out.println(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount() + "\n");
//            }
//        }
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
                System.out.println(transaction);
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

//    private static void customSearch() {
//        // Sort the ledger transactions by the most recent date
//        //transactions.sortLedgerByMostRecent();
//        Scanner scanner = new Scanner(System.in);
//
//
//        // Retrieve the list of transactions from the ledger
//        ArrayList<Transaction> filtered = transactions;
//
//        // Prompt the user to enter the start date for filtering
//        System.out.println("Please enter the start date: ");
//        String startDateString = scanner.nextLine();
//        LocalDate startDate = null;
//
//        // If the user provided a start date, attempt to parse it into a LocalDate object
//        if (!startDateString.equals("")) {
//            try {
//                startDate = LocalDate.parse(startDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//            } catch (Exception e) {
//                // If the date parsing fails, ignore the exception
//            }
//        }
//
//        // Prompt the user to enter the end date for filtering
//        System.out.println("Please enter the end date: ");
//        String endDateString = scanner.nextLine();
//        LocalDate endDate = null;
//
//        // If the user provided an end date, attempt to parse it into a LocalDate object
//        if (!endDateString.equals("")) {
//            try {
//                endDate = LocalDate.parse(endDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//            } catch (Exception e) {
//                // If the date parsing fails, ignore the exception
//            }
//        }
//
//        // Prompt the user to enter a description for filtering
//        System.out.println("Please enter a description of the transaction to filter by: ");
//        String description = scanner.nextLine();
//
//        // Prompt the user to enter an amount for filtering
//        System.out.println("Please enter the amount: ");
//        String amountString = scanner.nextLine();
//        double amount = 0.0;
//
//        // If the user provided an amount, attempt to parse it into a double
//        if (!amountString.equals("")) {
//            try {
//                amount = Double.parseDouble(amountString);
//            } catch (Exception e) {
//                // If parsing fails, ignore the exception
//            }
//        }
//
//        // Create a thread-safe copy of the filtered transactions to avoid concurrent modification issues
//        List<Transaction> list = new CopyOnWriteArrayList<>(filtered);
//        List<Transaction> copy = new ArrayList<>(list); // Copy the list for iteration
//
//        // Iterate over the copy while modifying the original filtered list
//        for (Transaction t : copy) {
//            // Remove transactions that are before the specified start date
//            if (!startDateString.equals("") && t.getIsoLocalDateTime().isBefore(startDate.atStartOfDay())) {
//                filtered.remove(t);
//            }
//            // Remove transactions that are after the specified end date
//            if (!endDateString.equals("") && t.getIsoLocalDateTime().isAfter(endDate.atStartOfDay())) {
//                filtered.remove(t);
//            }
//            // Remove transactions that don't match the specified description (case-insensitive)
//            if (!description.equals("") && !t.getDescription().toLowerCase().contains(description.toLowerCase())) {
//                filtered.remove(t);
//            }
//            // Remove transactions that don't match the specified amount
//            if (!amountString.equals("") && !(t.getAmount() == amount)) {
//                filtered.remove(t);
//            }
//        }
//
//        // Print out the remaining filtered transactions
//        for (Transaction t : filtered) {
//            System.out.println(t);
//        }
//    }

}