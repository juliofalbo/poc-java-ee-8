package exceptions;

import javax.ejb.ApplicationException;

@ApplicationException
public class CarCreationException extends RuntimeException {
    public CarCreationException(String message) {
        super(message);
    }
}
