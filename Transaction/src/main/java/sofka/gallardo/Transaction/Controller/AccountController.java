package sofka.gallardo.Transaction.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sofka.gallardo.Transaction.Entity.AccountEntity;
import sofka.gallardo.Transaction.Service.Impl.AccountServiceImpl;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("account/create")
    public ResponseEntity<?> createAccount(@Valid @RequestBody AccountEntity account){
        String response=accountService.createAccount(account);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("account/update/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Long id, @Valid @RequestBody AccountEntity account){
        account.setId(id);
        accountService.updateAccount(account);
        return new ResponseEntity<>("Cuenta actualizado", HttpStatus.OK);
    }

    @DeleteMapping("account/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Cuenta Eliminada", HttpStatus.OK);
    }


    @GetMapping("account/list")
    public ResponseEntity<?> getAllCAccount(){
        List<AccountEntity> listAccount;
        try {
            listAccount= accountService.getAllAccount();
            return new ResponseEntity<>(listAccount, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("No se pudo guardar", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
