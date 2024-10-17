package com.pluralsight.capstone;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class PaymentsAndDeposits {
    public static void addDeposit(){
        try{
            Scanner scanner2 = new Scanner(System.in);
            FileWriter myWriter = new FileWriter("./src/main/resources/transactions.csv",true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            System.out.println("Who is the deposit payable to?");
            String depositPayableTo = scanner2.nextLine();
            System.out.println("What is the deposit amount?");
            Double depositAmount = scanner2.nextDouble();
            scanner2.nextLine();
            System.out.println("Enter a description for the deposit");
            String depositDescription = scanner2.nextLine();
            LocalDate depositTime = LocalDate.now();
            LocalTime depositDate = LocalTime.now();
           // ReadAndWrite.writeToCSV();
            bWriter.write(depositDate + "|" + depositTime + "|" +depositDescription+"|"+ depositPayableTo + "|"+depositAmount);
            bWriter.close();
            return;}
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void makePayment(){

    }

}
