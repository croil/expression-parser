package exceptions;

public class DivisionByZeroException extends AbstractException {
    public DivisionByZeroException(String expression) {
        super("Division by zero: " + expression);
    }
}
