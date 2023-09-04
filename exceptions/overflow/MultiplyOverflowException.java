package exceptions.overflow;

public class MultiplyOverflowException extends Overflow {
    public MultiplyOverflowException(String overflow) {
        super("Multiply overflow exception " + overflow);
    }
}
