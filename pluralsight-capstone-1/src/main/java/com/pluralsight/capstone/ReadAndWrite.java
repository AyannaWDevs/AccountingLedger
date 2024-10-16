package com.pluralsight.capstone;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReadAndWrite {
    //Formatting date and time
    LocalDate theDate = LocalDate.now();
    LocalTime theTime = LocalTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
//Created variables for formatted date and time
    String formattedDate = theDate.format(dateFormatter);
    String formattedTime = theTime.format(timeFormatter);

    // Updated method to accept a list of transactions
    public String writeToCSV(ArrayList<Transaction> transactions) {
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true))) {
            for (String[] row : data) {
                writer.write(String.join("\\|", row));
                writer.newLine(); // Move to the next line
            }
        } catch (IOException e) {
            return "Error writing to file: ";
        }

        return "Successfully written information to file"; // Return statement after writing
    }
    public void readToFile(){
        try{FileReader fileReader = new FileReader("transactions.csv");}
        catch (FileNotFoundException e){
            System.out.println("Error, try again.");
        }
        BufferedReader bufReader = new BufferedReader(fileReader);
    }
}
