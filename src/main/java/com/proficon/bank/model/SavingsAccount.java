package com.proficon.bank.model;

public class SavingsAccount extends BankAccount {

    private double minimumBalance = 500.0;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= minimumBalance) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }
}