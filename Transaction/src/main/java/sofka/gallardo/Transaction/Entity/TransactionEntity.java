package sofka.gallardo.Transaction.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;
import sofka.gallardo.Transaction.Enum.TransactionType;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento_tbl")
@Getter @Setter
@AllArgsConstructor
public class TransactionEntity {
    @Id
    Long id;
    @Column(name = "fecha")
    private LocalDateTime dateTransaction;
    @ManyToOne
    @NotNull(message = "la cuenta es obigatoria")
    @JoinColumn(name = "cuenta",nullable = false)
    private AccountEntity account;
    @Enumerated(EnumType.STRING)
    TransactionType type;
    @NumberFormat(pattern = "#.##")
    @Column(name = "valor")
    private double valueTransaction;
    @Column(name = "saldo")
    private double balance;
    @Column(name = "Observacion")
    private String observation;

    public TransactionEntity() {
        this.dateTransaction = LocalDateTime.now();
    }
}
