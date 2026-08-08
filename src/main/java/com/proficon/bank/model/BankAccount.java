package com.proficon.bank.model;

public abstract class BankAccount implements TransactionOperations {  

    private String accountNumber; 
    private String accountHolderName;
    private double balance; 

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }

    @Override
    public double getBalance() { return balance; }

    protected void setBalance(double balance) { this.balance = balance; }

    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public abstract String getAccountType();
}
