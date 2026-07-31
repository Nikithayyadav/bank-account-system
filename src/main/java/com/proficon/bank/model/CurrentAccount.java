package com.proficon.bank.model;

public class CurrentAccount extends BankAccount {

    private double overdraftLimit = 1000.0;

    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= -overdraftLimit) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    @Override
    public String getAccountType() {
        return "Current Account";
    }
}