package sofka.gallardo.Transaction.Service;

import sofka.gallardo.Transaction.Entity.TransactionEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ITransactionService {
    public TransactionEntity createTransaction(TransactionEntity transactionEntity);
    public TransactionEntity updateTransaction(TransactionEntity transactionEntity);
    public void deleteTransaction(Long id);

    public TransactionEntity findByIdTransaction(Long id);
    public List<TransactionEntity> listTransactions();
    public List<TransactionEntity> reportBeetweenDates(LocalDateTime startDate, LocalDateTime endDate);
}
