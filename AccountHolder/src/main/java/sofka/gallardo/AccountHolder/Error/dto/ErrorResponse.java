package sofka.gallardo.AccountHolder.Error.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
}
