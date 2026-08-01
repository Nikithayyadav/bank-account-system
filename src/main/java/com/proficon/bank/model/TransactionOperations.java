package com.proficon.bank.model;

public interface TransactionOperations {
    boolean deposit(double amount);
    boolean withdraw(double amount);
    double getBalance(); 
}
