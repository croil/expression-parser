package exceptions.overflow;

public class NegateOverflowException extends Overflow {
    public NegateOverflowException(String overflow) {
        super("Negate overflow exception " + overflow);
    }
}
