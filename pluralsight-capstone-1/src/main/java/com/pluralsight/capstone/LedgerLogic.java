package com.pluralsight.capstone;
import static com.pluralsight.capstone.ReadAndWrite.transactions;

import java.util.ArrayList;

public class LedgerLogic {

    public static ArrayList<Transaction> getData() {
        return transactions;
    }

    public static void displayEntries(){
        for (Transaction t : transactions) {
                System.out.println(t.getDate() + "|" + t.getTime() + "|" + t.getDescription() + "|" + t.getVendor() + "|" + t.getAmount()+"\n");

        }
   }

    public static void displayDeposits(){
        for (Transaction t : transactions) {
            if (t.getAmount() >= 0) {
                System.out.println(t);
            }
        }
    }

    public static void displayPayments(){
        for (Transaction t : transactions) {
            if (t.getAmount() <= 0) {
                System.out.println(t);
            }
        }
    }

   public static void reportsScreen(){

   }
}
