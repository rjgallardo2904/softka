package sofka.gallardo.Transaction.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cuenta_tipo_tbl")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TypeAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "nombre")
    private String name;
}
