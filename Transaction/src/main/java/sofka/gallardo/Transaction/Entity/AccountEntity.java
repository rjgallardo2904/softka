package sofka.gallardo.Transaction.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;
import sofka.gallardo.Transaction.Enum.StateAcount;

@Entity
@Table(name = "cuenta_tbl")
@Getter @Setter
@AllArgsConstructor
public class AccountEntity {
    @Id
    Long id;
    @NotNull(message = "la cuenta es obligatoria")
    @Column(name = "cuenta")
    String accountNumber;
    @ManyToOne
    @NotNull(message = "El tipo de cuenta es obligatorio")
    @JoinColumn(name = "tipo_cuenta",nullable = false)
    TypeAccount typeAccount;
    @Column(name = "saldo_inicial")
    @NumberFormat(pattern = "#.##")
    double iniBalance;
    @Column(name = "estado")
    @NotNull(message = "El estado es obigatorio")
    @Enumerated(EnumType.STRING)
    StateAcount state;
    @Column(name = "nombre_persona")
    String namePerson;
    @Column(name = "es_primera_transaccion")
    private boolean isFrisTransaccion;
    public AccountEntity(){
        this.setFrisTransaccion(true);
    }
}
