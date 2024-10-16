package com.pluralsight.capstone;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class PaymentsAndDeposits {
    public static void addDeposit(){
        try{
            Scanner scanner2 = new Scanner(System.in);
            FileWriter myWriter = new FileWriter("transactions.csv");
            System.out.println("Who is the deposit payable to?");
            String depositPayableTo = scanner2.nextLine();
            System.out.println("What is the deposit amount?");
            Double depositAmount = scanner2.nextDouble();
            LocalDate depositTime = LocalDate.now();
            LocalTime depositDate = LocalTime.now();
            myWriter.write(depositDate + "|" + depositTime + "|" + depositPayableTo + "|"+depositAmount);
            myWriter.close();
            System.out.println("Succesfully added deposit information!");
            return;}
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void makePayment(){

    }

}
