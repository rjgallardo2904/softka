package sofka.gallardo.AccountHolder.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import sofka.gallardo.AccountHolder.Enum.Genre;


@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persona_tbl")
public class PersonEntity {
    @Id
    Long Id;
    @NotNull(message = "El nombre es obligatorio")
    @Column(name = "nombre")
    String name;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El genero es obligatorio")
    @Column(name = "genero")
    Genre genre;
    @NotNull(message = "La edad es obligatorio")
    @Column(name = "edad")
    int age;
    @NotNull(message = "La identificacion es obligatorio")
    @Length(max = 10,message = "La cedula debe tener mimaximo 10 caracteres")
    @Length(min = 9,message = "La cedula debe tener 10 caracteres")
    @Column(name = "identifcacion")
    String dni;

    @NotNull(message = "La Dirección es obligatorio")
    @Column(name = "direccion")
    String address;

    @NotNull(message = "El telefono es obligatorio")
    @Length(max = 10,message = "El maximo de caracteres son 10")
    @Column(name = "telefono")
    String phone;

}