package sofka.gallardo.AccountHolder.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sofka.gallardo.AccountHolder.Enum.StateCustom;

@Entity
@Getter @Setter
@Table(name = "cliente_tbl")
@AllArgsConstructor @NoArgsConstructor
public class ClientEntity extends PersonEntity{
    @Id
    Long Id;
    @NotNull(message = "La contraseña es obligatorio")
    @Column(name = "contrasena")
    String password;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado es obligatorio")
    @Column(name = "estado")
    StateCustom state;
}
