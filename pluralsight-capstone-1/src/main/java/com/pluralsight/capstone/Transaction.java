package com.pluralsight.capstone;
import java.time.LocalDate;


public class Transaction { //class properties
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String vendor;
    private double amount;

    //constructor
    public void Transaction() {
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.endDate = endDate;
        this.startDate = startDate;
    }
    // constructor
    public void Transactions(String description, String vendor, double amount, LocalDate endDate, LocalDate startDate){

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
