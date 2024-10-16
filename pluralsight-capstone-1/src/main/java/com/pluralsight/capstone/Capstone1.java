package com.pluralsight.capstone;
import java.util.Scanner;

import static com.pluralsight.capstone.Ledger.displayLedger;
import static com.pluralsight.capstone.PaymentsAndDeposits.addDeposit;
import static com.pluralsight.capstone.PaymentsAndDeposits.makePayment;

public class Capstone1 {
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
                break;
            case "P":
                makePayment(); //prompt user for debit info and save to csv file
                break;
            case "L":
                displayLedger(); //display ledger screen
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
}
