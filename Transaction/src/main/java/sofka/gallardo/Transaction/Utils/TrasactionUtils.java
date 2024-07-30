package sofka.gallardo.Transaction.Utils;

import sofka.gallardo.Transaction.Entity.TransactionEntity;
import sofka.gallardo.Transaction.Error.ValidationEntityException;

public class TrasactionUtils {
    public TransactionEntity calculateBalance(TransactionEntity transaction)  {
        boolean isFristTransaction=transaction.getAccount().isFrisTransaccion();
        double iniBalance= isFristTransaction
                    ?transaction.getAccount().getIniBalance()
                    :transaction.getBalance();
        double valueTransaction = transaction.getValueTransaction();
        double balanceCalcuate= iniBalance-valueTransaction;
        if (balanceCalcuate<0) {
            transaction.setObservation("No se ejecuto la transaccion");
            throw new ValidationEntityException("No hay saldo sufiente");
        }
        transaction.getAccount().setFrisTransaccion(false);
        transaction.setObservation("Transaccion Ejecutada");
        transaction.setBalance(balanceCalcuate);
        return transaction;



    }
}
