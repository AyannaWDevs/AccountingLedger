package com.pluralsight.capstone;
import static com.pluralsight.capstone.ReadAndWrite.transactions;

import java.util.ArrayList;

public class LedgerLogic {

    public static ArrayList<Transaction> getData() {
        return transactions;
    }

    public static void displayEntries(){
        for (Transaction transaction : transactions) {
                System.out.println(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount()+"\n");

        }
   }

    public static void displayDeposits(){
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() >= 0) {
                System.out.println(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount()+"\n");
            }
        }
    }

    public static void displayPayments(){
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() <= 0) {
                System.out.println(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount()+"\n");
            }
        }
    }

   public static void reportsScreen(){

   }
}
