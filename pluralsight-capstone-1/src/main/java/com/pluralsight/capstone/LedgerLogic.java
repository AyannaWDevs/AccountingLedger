package com.pluralsight.capstone;

import java.util.ArrayList;

public class LedgerLogic {
    static ArrayList<Transaction> data = new ArrayList<>(); //create arraylist of all data

    public static ArrayList<Transaction> getData() {
        return data;
    }

    public static void displayEntries(){
        for (Transaction t : data) {
                System.out.println(t);

        }
   }

    public static void displayDeposits(){
        for (Transaction t : data) {
            if (t.getAmount() >= 0) {
                System.out.println(t);
            }
        }
    }

    public static void displayPayments(){

    }

   public static void reportsScreen(){

   }
}
