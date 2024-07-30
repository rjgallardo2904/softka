package sofka.gallardo.Transaction.Dto;

import lombok.*;
import sofka.gallardo.Transaction.Enum.StateAcount;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class ResponseReport {
    private LocalDateTime dateTrans;
    private String client;
    private String cta;
    private String tipo;
    private double balanaceInitial;
    private StateAcount state;
    private double moviment;
    private double balace;
}
