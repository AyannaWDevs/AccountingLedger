package com.pluralsight.capstone;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReadAndWrite {
    //Formatting date and time
    static LocalDate theDate = LocalDate.now();
    static LocalTime theTime = LocalTime.now();
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    //Created variables for formatted date and time
    static String formattedDate = theDate.format(dateFormatter);
    static String formattedTime = theTime.format(timeFormatter);

    static ArrayList<Transaction> transactions = new ArrayList<>();

    // Updated method to accept a list of transactions
    public static void writeToCSV(Transaction transactions) {

        // Write the data to the CSV file
        try {
            FileWriter fWriter = new FileWriter("C:\\pluralsight\\LearnToCode_Capstones\\pluralsight-capstone-1\\src\\main\\resources\\transactions.csv", true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(transactions.getDate() + "|" + transactions.getTime() + "|" + transactions.getDescription() + "|" + transactions.getVendor() + "|" + transactions.getAmount()+"\n");
            bWriter.close();
        } catch (IOException e) {
            System.out.println("error");
        }

    }

    public static void readToFile() {
        try {
            FileReader fileReader = new FileReader("C:\\pluralsight\\LearnToCode_Capstones\\pluralsight-capstone-1\\src\\main\\resources\\transactions.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            while ((input = bufReader.readLine()) != null) {
            String [] transactionInfo = input.split("[|]");
            String date = transactionInfo[0];
            String time = transactionInfo[1];
            String vendor = transactionInfo[2];
            String description = transactionInfo[3];
            double amount = Double.parseDouble(transactionInfo[4]);
            Transaction transaction = new Transaction(description,vendor,amount,date,time);
            transactions.add(transaction);
            }
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
