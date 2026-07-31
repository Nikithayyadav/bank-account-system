package com.proficon.bank.controller;

import org.springframework.web.bind.annotation.*;
import com.proficon.bank.model.BankRequest;
import com.proficon.bank.model.BankResponse;
import com.proficon.bank.service.BankService;

@RestController // <-- Springdoc looks for @RestController to render endpoints
@RequestMapping("/api/bank")
@CrossOrigin(origins = "*")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/create")
    public BankResponse createAccount(@RequestBody BankRequest request) {
        return bankService.createAccount(request);
    }

    @PostMapping("/deposit")
    public BankResponse deposit(@RequestBody BankRequest request) {
        return bankService.deposit(request);
    }

    @PostMapping("/withdraw")
    public BankResponse withdraw(@RequestBody BankRequest request) {
        return bankService.withdraw(request);
    }

    @GetMapping("/account/{accountNumber}")
    public BankResponse getAccount(@PathVariable String accountNumber) {
        return bankService.getAccount(accountNumber);
    }
}
