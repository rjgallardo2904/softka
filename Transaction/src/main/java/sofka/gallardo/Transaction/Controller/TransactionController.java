package sofka.gallardo.Transaction.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sofka.gallardo.Transaction.Entity.TransactionEntity;
import sofka.gallardo.Transaction.Service.Impl.TransactionServiceImpl;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @PostMapping("transaction/create")
    public ResponseEntity<?> createTransaction(@Valid @RequestBody TransactionEntity transaction){
        transactionService.createTransaction(transaction);
        return new ResponseEntity<>("Transaction Creada", HttpStatus.CREATED);
    }

    @PutMapping("transaction/update/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable Long id, @Valid @RequestBody TransactionEntity transaction){
        transaction.setId(id);
        transactionService.updateTransaction(transaction);
        return new ResponseEntity<>("Transaction Actualizada", HttpStatus.OK);
    }

    @DeleteMapping("transaction/delete/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>("Transaction Eliminado", HttpStatus.OK);
    }


    @GetMapping("transaction/list")
    public ResponseEntity<?> getAllTransaction(){
        List<TransactionEntity> listTransactios;
        try {
            listTransactios= transactionService.listTransactions();
            return new ResponseEntity<>(listTransactios, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("No se pudo consultar", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
