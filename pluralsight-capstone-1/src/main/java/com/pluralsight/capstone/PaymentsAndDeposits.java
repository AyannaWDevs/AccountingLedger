package com.pluralsight.capstone;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import static com.pluralsight.capstone.ReadAndWrite.transactions;

public class PaymentsAndDeposits {
    private static final LocalDateTime today = LocalDateTime.now();
    private static final DateTimeFormatter ymd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm");
    private static final String date = today.format(ymd);

    public static String getDate() {
        return date;
    }

    public static void addDeposits(Scanner scanner2) {
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/transactions.csv", true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            System.out.println("Who is the deposit payable to?");
            String depositPayableTo = scanner2.nextLine();
            System.out.println("What is the deposit amount?");
            Double depositAmount = scanner2.nextDouble();
            scanner2.nextLine();
            System.out.println("Enter a description for the deposit");
            String depositDescription = scanner2.nextLine();
            String depositDate = getDate();
            String depositTime = today.format(time);
            Transaction deposit = new Transaction(depositDescription, depositPayableTo, depositAmount, depositDate, depositTime);
            transactions.add(deposit);
            ReadAndWrite.writeToCSV(deposit);
            System.out.println("Deposit added successfully.");

            // ReadAndWrite.writeToCSV();
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void makePayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = -scanner.nextDouble();  // Negative value for payments
        String depositDate = getDate();
        String depositTime = today.format(time);
        Transaction payment = new Transaction(description, vendor, amount, depositDate, depositTime);
        transactions.add(payment);
        ReadAndWrite.writeToCSV(payment);
        System.out.println("Payment made successfully.");
    }
}