package bankcom.example.bank.service;

import bankcom.example.bank.enity.BankAccount;
import bankcom.example.bank.repository.bankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bankService {

    @Autowired
    private bankRepository repo;

    public BankAccount createAccount(BankAccount acc){
        return repo.save(acc);
    }

    public BankAccount credit(Long id , float amount){
        BankAccount acc = repo.findById(id).orElseThrow(null);
        acc.credit(amount);
        return repo.save(acc);
    }

    public BankAccount debit(Long id , float amount){
        BankAccount acc = repo.findById(id).orElseThrow(null);
        acc.debit(amount);
        return repo.save(acc);
    }

    public BankAccount getAccount(Long id){
        return  repo.findById(id).orElseThrow(null);
    }

    public float checkBalance(Long id){
        return repo.findById(id).orElseThrow().balance;
    }

}
