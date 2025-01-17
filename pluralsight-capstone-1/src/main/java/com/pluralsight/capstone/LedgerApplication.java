package com.pluralsight.capstone;

import java.util.Scanner;

import static com.pluralsight.capstone.LedgerLogic.*;
import static com.pluralsight.capstone.PaymentsAndDeposits.makePayment;

public class LedgerApplication {
    public static void main(String[] args) {
        //Requirements:
        /* Read and write a text file
           Format the file I/OII
           Have methods for each screen
        */
        ReadAndWrite.readToFile();
        boolean done = false;
        while(!done) {
            System.out.println("""
                Hello, Welcome to The Accounting Ledger Application!
                =====================================================
                Enter:
                'D' to add deposit information
                'P' to make a payment
                'L' to display the ledger screen
                'X' to exit the application
                """);

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toUpperCase().trim(); //take user input
            switch (input) {
                case "D": //prompt user for deposit info and save to csv file
                    PaymentsAndDeposits.addDeposits(scanner);
                    break;
                case "P":
                    makePayment(); //prompt user for debit info and save to csv file
                    break;
                case "L":
                    displayLedgerScreen(scanner); //display ledger screen
                    break;
                case "X":
                    done=true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter D, P, L, or X");

                    //set a boolean to false do while !done x
                    //to String to print class
            }
        }
    }

    public static void displayLedgerScreen(Scanner scanner) {
        boolean loopFlag = true;
        while(loopFlag) {
            String header = String.format("Date", "Time", "Description", "Vendor", "Amount");
            System.out.println("""
                    Welcome to the Ledger Screen
                    =====================================================
                    Enter:
                    'A' to display all entries
                    'D' to display all deposits
                    'P' to display all payments
                    'R' to enter the Reports Screen to perform a custom search
                    'H' to return to the Home Screen
                    """);
            String input = scanner.nextLine().toUpperCase().trim(); //take user input
            switch (input) {
                case "A": //prompt user for deposit info and save to csv file
                    LedgerLogic.displayEntries(); // displays all entries
                    break;
                case "D":
                    LedgerLogic.displayDeposits(); // displays all deposits
                    break;
                case "P":
                    LedgerLogic.displayPayments(); //displays all payments
                    break;
                case "R":
                    reportsScreen(); //goes to reports screen
                    break;
                case "H":
                    System.out.println("Now returning to home screen...");
                    loopFlag = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter A, D, P, R, or H");
                    displayLedgerScreen(scanner);
            }
        }
    }

    public static void reportsScreen() {
        boolean loopFlag = true;
        while (loopFlag) {
            System.out.println("""
                    Filter the ledger by choosing one of the options to filter:
                    1) Month to Date
                    2) Previous Month
                    3) Year to Date
                    4) Previous Year
                    5) Search by Vendor
                    0) Return to Ledger Screen
                    """);
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    reportMtD();
                    break;
                case 2:
                    reportPreviousMonth();
                    break;
                case 3:
                        reportYtD();
                    break;
                case 4:
                        reportPreviousYear();
                    break;
                case 5:
                        reportVendorSearch();
                    break;
                case 0:
                    loopFlag = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
