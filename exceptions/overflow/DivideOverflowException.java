package exceptions.overflow;

public class DivideOverflowException extends Overflow {
    public DivideOverflowException(String overflow) {
        super("Divide overflow exception " + overflow);
    }
}
