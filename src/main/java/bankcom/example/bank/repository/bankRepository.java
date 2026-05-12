package bankcom.example.bank.repository;

import bankcom.example.bank.enity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bankRepository extends JpaRepository<BankAccount , Long> {
}
