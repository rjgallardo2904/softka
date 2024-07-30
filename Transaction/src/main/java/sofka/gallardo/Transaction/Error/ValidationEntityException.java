package sofka.gallardo.Transaction.Error;

public class ValidationEntityException  extends RuntimeException {
    public ValidationEntityException(String message){
        super(message);
    }
}
