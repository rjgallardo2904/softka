package sofka.gallardo.AccountHolder.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;
import sofka.gallardo.AccountHolder.Entity.ClientEntity;
import sofka.gallardo.AccountHolder.Service.Impl.ClientServiceImpl;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("client/create")
    public ResponseEntity<?> createPersons(@Valid @RequestBody ClientEntity client){
        clientService.createClient(client);
        return new ResponseEntity<>("Usuario Creado", HttpStatus.CREATED);
    }

    @PutMapping("client/update/{id}")
    public ResponseEntity<?> updatePersons(@PathVariable Long id, @Valid @RequestBody ClientEntity client){
        client.setId(id);
        clientService.updateClient(client);
        return new ResponseEntity<>("Usuario Actualizado", HttpStatus.OK);
    }

    @PatchMapping("client/update-dni/{id}")
    public ResponseEntity<?> updateDniPersons(@PathVariable Long id, @RequestParam String dni){
        clientService.updateDni(id,dni);
        return new ResponseEntity<>("Cedula Actualizada", HttpStatus.CREATED);
    }

    @DeleteMapping("client/delete/{id}")
    public ResponseEntity<?> updateDniPersons(@PathVariable Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>("Usuario Eliminado", HttpStatus.OK);
    }


    @GetMapping("client/list")
    public ResponseEntity<?> getAllClient(){
        List<ClientEntity> listClients;
        try {
            listClients= clientService.listClients();
            return new ResponseEntity<>(listClients, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("No se pudo consultar", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("client/search-name/{name}")
    public ResponseEntity<?> findClienteByName(@PathVariable String name){
        ClientEntity clienteSerach= clientService.findClienteByName(name);
        return new ResponseEntity<>(clienteSerach, HttpStatus.OK);
    }
}
