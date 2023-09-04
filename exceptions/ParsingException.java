package exceptions;

public class ParsingException extends AbstractException {
    public ParsingException(String parseError) {
        super(parseError);
    }
}
