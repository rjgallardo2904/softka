package sofka.gallardo.AccountHolder.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sofka.gallardo.AccountHolder.Entity.ClientEntity;
import sofka.gallardo.AccountHolder.Entity.PersonEntity;
import sofka.gallardo.AccountHolder.Repository.IClientRepository;
import sofka.gallardo.AccountHolder.Service.IClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Override
    public ClientEntity createClient(ClientEntity clientEntity) {
        return clientRepository.save(clientEntity);
    }

    @Override
    public ClientEntity updateClient(ClientEntity clientEntity)
    {

        Long id= clientEntity.getId();
        findById(id);

        return clientRepository.save(clientEntity);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientEntity findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public ClientEntity updateDni(Long id,String dni) {
        ClientEntity clientEntity= findById(id);
        clientEntity.setDni(dni);
        return updateClient(clientEntity);
    }

    @Override
    public List<ClientEntity> listClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientEntity findClienteByName(String name) {
        return clientRepository.findByName(name);
    }
}
