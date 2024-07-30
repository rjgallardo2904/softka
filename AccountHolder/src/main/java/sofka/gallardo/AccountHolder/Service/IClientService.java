package sofka.gallardo.AccountHolder.Service;

import sofka.gallardo.AccountHolder.Entity.ClientEntity;


import java.util.List;
import java.util.Optional;

public interface IClientService {
    public ClientEntity createClient(ClientEntity clientEntity);
    public ClientEntity updateClient( ClientEntity clientEntity);
    public void deleteClient(Long id);

    public ClientEntity findById(Long id);

    public ClientEntity updateDni(Long id,String dni);
    public List<ClientEntity> listClients();

    public ClientEntity findClienteByName(String name);
}
