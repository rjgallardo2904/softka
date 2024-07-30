package sofka.gallardo.Transaction.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sofka.gallardo.Transaction.Entity.AccountEntity;
import sofka.gallardo.Transaction.Entity.TransactionEntity;
import sofka.gallardo.Transaction.Repository.IAccountRepository;
import sofka.gallardo.Transaction.Repository.ITransactionRepository;
import sofka.gallardo.Transaction.Service.ITransactionService;
import sofka.gallardo.Transaction.Utils.TrasactionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private ITransactionRepository transactionRepository;
    @Autowired
    private IAccountRepository accountRepository;
    TrasactionUtils trasactionUtils= new TrasactionUtils();

    @Override
    public TransactionEntity createTransaction(TransactionEntity transactionEntity) {
        TransactionEntity transactionCalculate;
        Long idAccount=transactionEntity.getAccount().getId();
        AccountEntity account;
        account=accountRepository.getById(idAccount);
        transactionEntity.setAccount(account);
        transactionCalculate= trasactionUtils.calculateBalance(transactionEntity);
        accountRepository.save(transactionCalculate.getAccount());
        return transactionRepository.save(transactionCalculate);
    }

    @Override
    public TransactionEntity updateTransaction(TransactionEntity transactionEntity)
    {
        Long id= transactionEntity.getId();
        findByIdTransaction(id);
        return transactionRepository.save(transactionEntity);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public TransactionEntity findByIdTransaction(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }


    @Override
    public List<TransactionEntity> listTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<TransactionEntity> reportBeetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.reportBeetweenDates(startDate,endDate);
    }


}
