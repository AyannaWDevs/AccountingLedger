package com.pluralsight.capstone;
import java.time.LocalDate;


public class Transaction { //class properties
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String vendor;
    private double amount;

    //constructor
    public Transaction() {
        this.description = "";
        this.vendor = "";
        this.amount = 0.0;
        this.endDate = null;
        this.startDate = null;
    }
    // constructor
    public Transaction(String description, String vendor, double amount, LocalDate endDate, LocalDate startDate){
            this.description = description;
            // same thing
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
