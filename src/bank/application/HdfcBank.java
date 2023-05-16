package bank.application;

import java.util.UUID;

public class HdfcBank implements BankInterface{
    private int balance;
    private String accountNo;
    private String password;
    public String name;

    //because it'll be same for all users
    public static double rateOfInterest;

    //Constructor
    public HdfcBank(int balance, String password, String name){
        //uuid will give us random number that has never been generated before
        this.accountNo = UUID.randomUUID().toString();
        this.balance = balance;
        this.password = password;
        this.name = name;
    }
    @Override
    public int checkBalance(String password) {
        //to check balance we'll check if the password that we're sending matches the local password
        // this.password is always talking about the current password
        if(password == this.password){
            return balance;
        }
        return -1;
    }

    @Override
    public String addMoney(int money) {

        balance = balance + money;
        String message = money + "has been added to bank account" + accountNo;

        return message;
    }

    @Override
    public String withdrawMoney(int drawMoney, String password) {
        if(password == this.password){
            //check if balance is enough or not
            if(drawMoney > balance){
                return "Insufficient Balance";
            }
            else{
                balance = balance - drawMoney;
                return "Money withdrawn successfully.";
            }
        }
        else{
            return "Wrong password";
        }
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        //we'll check if the old password is matching
        if(this.password == oldPassword){
            this.password = newPassword;
            return "Password has been changed  successfully";
        }
        else{
            return "Wrong password";
        }
    }

    @Override
    public double calculateTotalInterest(int years) {
        double interest = (balance * rateOfInterest * years)/100;

        return interest;
    }
}
