package exceptions.overflow;

public class SubtractOverflowException extends Overflow {
    public SubtractOverflowException(String exception) {
        super("Subtract overflow exception " + exception);
    }
}
