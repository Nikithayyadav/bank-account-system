package com.proficon.bank.service;

import org.springframework.stereotype.Service;
import com.proficon.bank.model.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {

    private final Map<String, BankAccount> accounts = new HashMap<>();

    public BankResponse createAccount(BankRequest request) {
        if (accounts.containsKey(request.getAccountNumber())) {
            return new BankResponse(request.getAccountNumber(), "", "", 0, "Account already exists!", false);
        }

        BankAccount newAccount;
        if ("SAVINGS".equalsIgnoreCase(request.getAccountType())) {
            newAccount = new SavingsAccount(request.getAccountNumber(), request.getAccountHolderName(), request.getAmount());
        } else {
            newAccount = new CurrentAccount(request.getAccountNumber(), request.getAccountHolderName(), request.getAmount());
        }

        accounts.put(request.getAccountNumber(), newAccount);

        return new BankResponse(
            newAccount.getAccountNumber(),
            newAccount.getAccountHolderName(),
            newAccount.getAccountType(),
            newAccount.getBalance(),
            "Account created successfully!",
            true
        );
    }

    public BankResponse deposit(BankRequest request) {
        BankAccount account = accounts.get(request.getAccountNumber());
        if (account == null) {
            return new BankResponse(request.getAccountNumber(), "", "", 0, "Account not found!", false);
        }

        boolean success = account.deposit(request.getAmount());
        String msg = success ? "Deposit successful!" : "Invalid deposit amount!";

        return new BankResponse(account.getAccountNumber(), account.getAccountHolderName(), account.getAccountType(), account.getBalance(), msg, success);
    }

    public BankResponse withdraw(BankRequest request) {
        BankAccount account = accounts.get(request.getAccountNumber());
        if (account == null) {
            return new BankResponse(request.getAccountNumber(), "", "", 0, "Account not found!", false);
        }

        boolean success = account.withdraw(request.getAmount());
        String msg = success ? "Withdrawal successful!" : "Withdrawal failed! Check minimum balance ($500) or overdraft limit ($1000).";

        return new BankResponse(account.getAccountNumber(), account.getAccountHolderName(), account.getAccountType(), account.getBalance(), msg, success);
    }

    public BankResponse getAccount(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            return new BankResponse(accountNumber, "", "", 0, "Account not found!", false);
        }

        return new BankResponse(account.getAccountNumber(), account.getAccountHolderName(), account.getAccountType(), account.getBalance(), "Account details retrieved", true);
    }
}