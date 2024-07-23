import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount (String accountNumber, double initialBalance){
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber () {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit (double amount){
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successfully. This is your new balance : " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw (double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. This is the new balance : " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

