package bank.application;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SBI.rateOfInterest = 7;
        HdfcBank.rateOfInterest=6;
        //we'll make two objects
        SBI account1 = new SBI(100000, "123", "Dev");
        SBI account2 = new SBI(150000, "456", "Rakshit");
        HdfcBank account3 = new HdfcBank(150000, "789", "Mehran");

        //Wrong password
        int balance = account1.checkBalance("124");
        System.out.println("The balance for account1 is " + balance);

        //Right password
        int balanceCheck = account1.checkBalance("123");
        System.out.println("The balance for account1 is " + balanceCheck);

        String bankMessage = account2.addMoney(50000);
        System.out.println(bankMessage);

        String message = account3.withdrawMoney(10000, "1234");
        System.out.println(message);

        String message1 = account3.withdrawMoney(50000, "789");
        System.out.println(message1);

        double interest = account1.calculateTotalInterest(20);
        System.out.println("The total interest you will get is " + interest);

        double interest1 = account3.calculateTotalInterest(20);
        System.out.println("The total interest you will get is " + interest1);

        System.out.println("Make it dynamic");
        System.out.println("Welcome to SBI, please enter the details to create account");
        System.out.println("Enter name : ");

        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        System.out.println("Enter balance : ");
        int initialBalance = sc.nextInt();
        System.out.println("Enter password : ");
        String password = sc.next();

        SBI sbiAccount = new SBI(initialBalance, password, name);

        System.out.println("Enter money and password to add");
    }
}