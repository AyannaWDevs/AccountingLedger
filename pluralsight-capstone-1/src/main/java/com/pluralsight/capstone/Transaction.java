package com.pluralsight.capstone;

import java.time.LocalDate;
import java.time.LocalTime;


public class Transaction { //class properties
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    // constructor
    public Transaction(String description, String vendor, double amount, String date, String time) {
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.date = date;
        this.time = time;
        // same thing
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount + "\n";
    }
}