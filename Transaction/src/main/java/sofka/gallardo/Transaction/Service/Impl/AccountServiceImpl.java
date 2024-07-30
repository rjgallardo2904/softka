package sofka.gallardo.Transaction.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sofka.gallardo.Transaction.Entity.AccountEntity;
import sofka.gallardo.Transaction.Error.ValidationEntityException;
import sofka.gallardo.Transaction.Repository.IAccountRepository;
import sofka.gallardo.Transaction.Service.IAccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ApiService apiService;
    @Override
    public String createAccount(AccountEntity account) {
        String name= account.getNamePerson();
        String response;
        var resposeExternalApi= apiService.getDataFromApi(name);
        if(resposeExternalApi ==null){
            try {
                response="No se puede Guaradar Uasrio no existe";
                throw new ValidationEntityException("No exixte Usuario registrado");
            } catch (ValidationEntityException e) {
                throw new RuntimeException(e);
            }

        }else{
            accountRepository.save(account);
            response="guardado correctamente";
        }
        return response;
    }

    @Override
    public AccountEntity updateAccount(AccountEntity AccountEntity)
    {
        Long id= AccountEntity.getId();
        findByIdAccount(id);
        return accountRepository.save(AccountEntity);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public AccountEntity findByIdAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public List<AccountEntity> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity getByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }


}
