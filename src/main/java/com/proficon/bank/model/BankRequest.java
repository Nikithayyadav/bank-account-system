package com.proficon.bank.model;

public class BankRequest {
    private String accountNumber; 
    private String accountHolderName;
    private String accountType;
    private double amount;

    public BankRequest() {}

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) { this.accountHolderName = accountHolderName; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
