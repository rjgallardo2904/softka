package sofka.gallardo.AccountHolder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sofka.gallardo.AccountHolder.Entity.ClientEntity;
import sofka.gallardo.AccountHolder.Entity.PersonEntity;

public interface IClientRepository extends JpaRepository<ClientEntity,Long> {
    public ClientEntity findByName(String dni);
}
