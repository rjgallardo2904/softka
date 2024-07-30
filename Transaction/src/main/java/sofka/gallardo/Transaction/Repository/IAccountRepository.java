package sofka.gallardo.Transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sofka.gallardo.Transaction.Entity.AccountEntity;

public interface IAccountRepository extends JpaRepository<AccountEntity,Long> {
    public AccountEntity findByAccountNumber(String accountNumber);
}
