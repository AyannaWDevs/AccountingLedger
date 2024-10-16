package com.pluralsight.capstone;
import javax.swing.text.DateFormatter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAndWrite {
    LocalDate theDate = LocalDate.now();
    LocalTime theTime = LocalTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    String formattedDate = now.format(dateFormatter);
    String formattedTime = now.format(timeFormatter);

    public String writeToCSV() {
        ArrayList<String[]> data = new ArrayList<>();
    data.add(new String[]{"Date", "Time", "Description", "Vendor", "Amount"});
    data.add(new String[]{});
   return ("Successfully written to file");
    }
 }
