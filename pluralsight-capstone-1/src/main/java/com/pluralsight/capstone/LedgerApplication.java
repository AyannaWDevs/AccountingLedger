package com.pluralsight.capstone;
import java.util.Scanner;
import static com.pluralsight.capstone.PaymentsAndDeposits.addDeposit;
import static com.pluralsight.capstone.PaymentsAndDeposits.makePayment;
import static com.pluralsight.capstone.ReadAndWrite.*;

public class LedgerApplication {
    public static void main (String[]args) {
        //Requirements:
        /* Read and write a text file
           Format the file I/OII
           Have methods for each screen
            */
        System.out.println("""
                Hello, Welcome to The Accounting Ledger Application!
                =====================================================
                Enter:
                'D' to add deposit information
                'P' to make a payment
                'L' to display the ledger screen
                'X' to exit the application
                """);

        homeScreen();
        boolean done = false;
    }
    public static void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase().trim(); //take user input
        switch (input) {
            case "D": //prompt user for deposit info and save to csv file
                addDeposit();
                writeToCSV(transactions);
                addDeposit();
                readToFile();
                break;
            case "P":
                makePayment(); //prompt user for debit info and save to csv file
                break;
            case "L":
                displayLedgerScreen(); //display ledger screen
                break;
            case "X":
                System.exit(0);
            default:
                System.out.println("Invalid input. Please enter D, P, L, or X");
                homeScreen();

                //set a boolean to false do while !done x
                //to String to print class
        }
    }
    public static void displayLedgerScreen(){
        String header = String.format("Date","Time","Description","Vendor","Amount");
        System.out.println("""
                Welcome to the Ledger Screen
                =====================================================
                Enter:
                'D' to display all entries
                'P' to display all payments
                'R' to enter the Reports Screen to perform a custom search
                'H' to return to the Home Screen
                """);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase().trim(); //take user input
        switch (input) {
            case "A": //prompt user for deposit info and save to csv file
                System.out.println(header);
                LedgerLogic.displayEntries(); // displays all entries
                break;
            case "D":
                LedgerLogic.displayDeposits(); // displays all deposits
                break;
            case "P":
                LedgerLogic.displayPayments(); //displays all payments
                break;
            case "R":
                LedgerLogic.reportsScreen(); //goes to reports screen
                break;
            case "H":
                System.out.println("Now returning to home screen...");
               homeScreen();  //returns to home screen
                break;
            default:
                System.out.println("Invalid input. Please enter A, D, P, R, or H");
                displayLedgerScreen();
        }
    }
    public static void reportsScreen(){
        boolean loopFlag = true;
        while (loopFlag) {
            System.out.println("""
                    Filter the ledger by choosing one of the options to filter:
                    1) Month to Date
                    2) Previous Month
                    3) Year to Date
                    4) Previous Year
                    5) Search by Vendor
                    0) Return to Reports Screen
                    """);
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;
                case 4:
                    break;

                case 5:
                    break;
                case 0:
                    loopFlag=false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
