package bankcom.example.bank.controller;

import bankcom.example.bank.enity.BankAccount;
import bankcom.example.bank.service.bankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankAccountController {

    @Autowired
    private bankService service;

    @PostMapping("/create")
    public BankAccount create(@RequestBody BankAccount acc){
        return service.createAccount(acc);
    }

    @PostMapping("/{id}/credit")
    public BankAccount credit(@PathVariable Long id , @RequestParam float amount){
        return service.credit(id,amount);
    }

    @PostMapping("/{id}/debit")
    public BankAccount debit(@PathVariable Long id, @RequestParam float amount){
        return  service.debit(id,amount);
    }

    @GetMapping("/{id}/balance")
    public float checkBalance(@PathVariable Long id){
        return  service.checkBalance(id);
    }

    @GetMapping("/{id}/get")
    public BankAccount getAccount(@PathVariable Long id){
        return service.getAccount(id);
    }
}
