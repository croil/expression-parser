package exceptions.overflow;

public class AddOverflowException extends Overflow {
    public AddOverflowException(String mistake) {
        super("Add overflow exception " + mistake);
    }
}
