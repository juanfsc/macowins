package Entities.Exceptions;

public class PorcentajeInvalidoException extends RuntimeException {
    public PorcentajeInvalidoException() {
        super();
    }

    public PorcentajeInvalidoException(String message) {
        super(message);
    }
}
