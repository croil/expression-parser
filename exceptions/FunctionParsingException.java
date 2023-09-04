package exceptions;

public class FunctionParsingException extends ParsingException {
    public FunctionParsingException(String parseError) {
        super("Exception while function parsing " + parseError);
    }
}
