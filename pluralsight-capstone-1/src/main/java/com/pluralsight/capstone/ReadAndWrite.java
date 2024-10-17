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
    public static String writeToCSV(ArrayList<Transaction> transactions) {
        ArrayList<String[]> data = new ArrayList<>(); //create arraylist of all data
        data.add(new String[]{"Date", "Time", "Description", "Vendor", "Amount"}); //header

        // Loop through the list of transactions
        for (Transaction transaction : transactions) {

            data.add(new String[]{
                    formattedDate,
                    formattedTime,
                    transaction.getDescription(),
                    transaction.getVendor(),
                    String.valueOf(transaction.getAmount())
            });
        }

        // Write the data to the CSV file
        try {
            FileWriter fWriter = new FileWriter("./src/main/resources/transactions.csv");
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            for (Transaction t : transactions) {
                bWriter.write(formattedDate + "|" + formattedTime );
                bWriter.write(String.format("%s|%s|%s|%s|%f",
                        formattedDate, formattedTime, t.getDescription(), t.getVendor(), t.getAmount()));
           }
                for (Transaction row : transactions) {
                    bWriter.newLine(); // Move to the next line
                }
                bWriter.close();
            } catch(IOException e){
                return "Error writing to file: ";
            }

        return "Successfully written information to file"; // Return statement after writing
    }
    public void readToFile(){
        try {
            FileReader fileReader = new FileReader("./src/main/java/resources/transactions.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            while ((input = bufReader.readLine()) !=null) {
                System.out.println(input);
            }
            bufReader.close();
        }
        catch(IOException e){
               e.printStackTrace();
            }
        }
    }
