package bankcom.example.bank.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    public String HolderName;
    public float balance;

    public void credit(float amount){
        balance = balance + amount;
    }

    public String debit(float amount){
        if(amount > balance){
            return "balance is insufficient";
        }
        balance= balance - amount;
        return "amount debit succcessful";
    }
}
