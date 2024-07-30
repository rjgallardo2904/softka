package sofka.gallardo.Transaction.Service;


import sofka.gallardo.Transaction.Entity.AccountEntity;

import java.util.List;

public interface IAccountService {
    public String createAccount(AccountEntity accountEntity);
    public AccountEntity updateAccount(AccountEntity accountEntity);
    public void deleteAccount(Long id);

    public AccountEntity findByIdAccount(Long id);

    public List<AccountEntity> getAllAccount();

    public AccountEntity getByAccountNumber(String accountNumber);
}
