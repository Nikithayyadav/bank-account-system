package com.proficon.bank.model;

public class BankResponse { 
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    private String message;
    private boolean success;

    public BankResponse(String accountNumber, String accountHolderName, String accountType, double balance, String message, boolean success) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.message = message;
        this.success = success;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }
    public String getMessage() { return message; }
    public boolean isSuccess() { return success; }
}
