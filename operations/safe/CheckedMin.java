package operations.safe;

import exceptions.FunctionParsingException;
import expression.Expression;
import operations.unsafe.Min;

public class CheckedMin extends Min {

    public CheckedMin(char prefix, Expression first, char postfix, Expression second) {
        super(first, second);
        if (Character.isDigit(prefix) || Character.isLetter(postfix)) {
            throw new FunctionParsingException("Illegal min use");
        }
    }
    @Override
    protected int calculate(int first, int second) {
        return Math.min(first, second);
    }

}
